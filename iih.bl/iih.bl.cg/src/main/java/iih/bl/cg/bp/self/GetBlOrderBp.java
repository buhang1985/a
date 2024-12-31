package iih.bl.cg.bp.self;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bl.cg.api.d.ApplyInfo;
import iih.bl.cg.blcgoep.d.FeeOriginEnum;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.service.i.IBLCiOrderToBlCgService;
import iih.bl.comm.log.BLThirdItfLogger;
import iih.bl.params.BlParams;
import iih.bl.st.service.i.IBLStQueService;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.pi.reg.pat.d.PatDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;

public class GetBlOrderBp {

	/**
	 * 将医嘱转换为返回的ApplyInfo信息
	 * 
	 * @param patCode
	 * @param patType
	 * @param beginTime
	 * @param endTime
	 * @return
	 * @throws BizException
	 */
	public ApplyInfo[] getApplyForBlOrder(String patCode, String patType, String beginTime, String endTime) throws BizException {

		FDateTime beginFDateTime = new FDateTime(beginTime + " 00:00:00");
		FDateTime endFDateTime = new FDateTime(endTime + " 23:59:59");
		return this.getApplyForBlOrder(patCode, patType, beginFDateTime, endFDateTime);
	}

	/**
	 * 重构方法 便于 微信接口调用 因业务相同返回数据也相同
	 * 
	 * @param patCode
	 * @param patType
	 * @param beginFDateTime
	 * @param endFDateTime
	 * @return
	 * @throws BizException
	 */
	public ApplyInfo[] getApplyForBlOrder(String patCode, String patType, FDateTime beginFDateTime, FDateTime endFDateTime) throws BizException {
		List<ApplyInfo> app = new ArrayList<ApplyInfo>();
		PatDO patdo = this.getPat(patCode);
		// 患者chis编码
		String barCode_chis = patdo.getBarcode_chis();

		// 获取患者历史就诊次数
		HashMap<String, Integer> patTimesMap = new HashMap<String, Integer>();
		// 含有未结算挂号的就诊次数列表
		List<Integer> noRegistOpTimes = new ArrayList<Integer>();
		// 未持卡挂号的医保就诊列表--走自费流程
		HashMap<String, Integer> patEntTypeMap = new HashMap<String, Integer>();
		patEntTypeMap = getPatType(patdo.getId_pat());

		patTimesMap = getPatTimes(patdo.getId_pat());
		BlOrderAppendBillParamDTO[] blOrder = this.getBlOrder(patdo.getId_pat());
		if (ArrayUtil.isEmpty(blOrder)) {
			return new ApplyInfo[]{};
		}
		// 就诊的集合
		ArrayList<String> idEnList = new ArrayList<String>();

		// 获取服务下所有物品打印名称map
		HashMap<String, String> bdMmMap = new HashMap<String, String>();
		ArrayList<String> srvIdList = new ArrayList<String>();
		for (BlOrderAppendBillParamDTO dto : blOrder) {
			if (beginFDateTime.before(dto.getDt_or()) && endFDateTime.after(dto.getDt_or())) {
				srvIdList.add(dto.getId_srv());
			}
			if (!idEnList.contains(dto.getId_ent())&&dto.getId_ent()!=null) {
				idEnList.add(dto.getId_ent());
			}
		}
		// 患者分类（应该为每次就诊的患者分类）
		Map<String, String> code_chis = getPatCa(idEnList);

		bdMmMap = getMMPrintNameMap(srvIdList.toArray(new String[srvIdList.size()]));

		for (BlOrderAppendBillParamDTO dto : blOrder) {
			if (beginFDateTime.before(dto.getDt_or()) && endFDateTime.after(dto.getDt_or())) {
				if (("0").equals(patType)) {
					// 自费 非持卡挂号的医保数据和自费就诊的的数据
					if (patEntTypeMap.containsKey(dto.getId_ent())) {
						int typepat = patEntTypeMap.get(dto.getId_ent());
						if (typepat == 1) {
							continue;
						}
					} else {
						continue;
					}
				} else if (("1").equals(patType)) {
					// 医保
					// 只返回医保持卡挂号的数据
					if (patEntTypeMap.containsKey(dto.getId_ent())) {
						int typepat = patEntTypeMap.get(dto.getId_ent());
						if (typepat == 2) {
							continue;
						}
					}
				}

				ApplyInfo info = new ApplyInfo();
				info.setApplyCode(dto.getCode_apply());
				info.setOpTimes(dto.getEnt_times());
				info.setId_ent(dto.getId_ent());
				String presType = dto.getCode_applytp();
				// 判断当前费用来源如果为就诊弹出
				// 如果有未结算挂号信息则不加载挂号以及当次就诊医嘱信息
				if (FeeOriginEnum.ENCOUNTER_FEE.equals(dto.getEu_srctp())) {
					noRegistOpTimes.add(dto.getEnt_times());
					continue;
				}
				// 对于未结算挂号费的医嘱，则不用返回给app
				if (noRegistOpTimes.contains(dto.getEnt_times())) {
					continue;
				}
				if(presType==null){
					presType ="";
					BLThirdItfLogger.error("id_ent:"+dto.getId_ent()+"  "+dto.getCode_srv()+"申请单类型为空");
				}
				switch (presType) {
				case IBdSrvDictCodeConst.DRUG_TYPE:
					info.setApplyTpName("处方");
					break;
				case IBdSrvDictCodeConst.RIS_TYPE:
					info.setApplyTpName("检查");
					break;
				case IBdSrvDictCodeConst.LIS_TYPE:
					info.setApplyTpName("检验");
					break;
				default:
					info.setApplyTpName("诊疗");
					break;
				}
				info.setApplyTpCode(presType);

				info.setSrvCode(dto.getCode_srv());
				// 设置物品打印名称
				if (FBoolean.TRUE.equals(dto.getFg_mm()) && bdMmMap.containsKey(dto.getId_mm())) {
					String printNmae = bdMmMap.get(dto.getId_mm());
					info.setSrvName(printNmae);
				} else {
					info.setSrvName(dto.getName_srv());
				}
				info.setUnit(dto.getSrvu_name());
				info.setSpecification(dto.getSpec());
				info.setPrice(dto.getPrice_ratio().toDouble());
				info.setQuan(dto.getQuan().toDouble());
				info.setAmt(dto.getAmt_ratio().toDouble());
				info.setSrvChargeGrade((dto.getSd_hpsrvtp() == "1" ? "甲类" : (dto.getSd_hpsrvtp() == "2" ? "乙类" : "丙类")));
				info.setQuanOrders(dto.getOrders());
				info.setSignTime(dto.getDt_or().toString());
				info.setCreateDateTime(dto.getDt_or().toString());
				info.setMpStatus(dto.getSd_su_mp() == "20" ? dto.getSd_su_mp() : "0");
				info.setBarCodeChis(barCode_chis);
				// 设置就诊次数
				if (patTimesMap.containsKey(dto.getId_ent())) {
					int times = patTimesMap.get(dto.getId_ent());
					info.setOpTimes(times);
				}
				info.setOrDepCode(dto.getId_dep_or());

				if (!StringUtil.isEmptyWithTrim(dto.getName_dep_or())) {
					info.setOrDepName(dto.getName_dep_or());
				} else {
					DeptDO deptdo = getDeptDO(dto.getId_dep_or());
					info.setOrDepName(deptdo.getName());
				}

				info.setOrEmpCode(dto.getId_emp_or());
				if (!StringUtil.isEmptyWithTrim(dto.getName_emp_or())) {
					info.setOrEmpName(dto.getName_emp_or());
				} else {
					PsnDocDO psndoc = this.getPsnDocDO(dto.getId_emp_or());
					info.setOrEmpName(psndoc.getName());
				}
				info.setCode_chis_patca(code_chis.get(info.getId_ent()));
				info.setEntpCode(dto.getCode_enttp());
				info.setObservationFlag(false);
				info.setSpecification(dto.getSpec());
				// //设置物品打印名称
				// if(FBoolean.TRUE.equals(dto.getFg_mm()) &&
				// bdMmMap.containsKey(dto.getId_srv())){
				// String printNmae=bdMmMap.get(dto.getId_srv());
				// info.setPrintName(printNmae);
				// }
				app.add(info);
			}
		}
		// 如果返回数据只有未结算挂号的医嘱数据，则提示，否则返回没有未结算挂号医嘱信息
		if (noRegistOpTimes.size() > 0 && app.size() <= 0) {
			throw new BizException("存在未结算的挂号信息，请到窗口处理！");
		}
		return app.toArray(new ApplyInfo[0]);
	}

	/**
	 * 根据患者id查询历史就诊次数
	 * 
	 * @param id_pat
	 * @return
	 * @throws DAException
	 */
	private HashMap<String, Integer> getPatTimes(String id_pat) throws DAException {
		// 获取就诊次数
		HashMap<String, Integer> patTimesMap = new HashMap<String, Integer>();
		String strSql = "select ent.id_ent,op.times_op from en_ent ent inner join en_ent_op op on ent.id_ent=op.id_ent where id_pat  = '" + id_pat + "' ";
		List<OutpatientDO> timesList = (List<OutpatientDO>) new DAFacade().execQuery(strSql, new BeanListHandler(OutpatientDO.class));
		if (timesList != null && timesList.size() > 0) {
			for (OutpatientDO pat : timesList) {
				patTimesMap.put(pat.getId_ent(), pat.getTimes_op());
			}
			return patTimesMap;
		}
		return null;
	}

	/**
	 * 查询所有物品的打印名称
	 * 
	 * @return
	 * @throws BizException
	 */
	private HashMap<String, String> getMMPrintNameMap(String[] srvIdList) throws BizException {
		HashMap<String, String> BdMmMap = new HashMap<String, String>();
		IMeterialMDORService iMeterialMDORService = ServiceFinder.find(IMeterialMDORService.class);
		MeterialDO[] MmDO = iMeterialMDORService.find(SqlUtils.getInSqlByIds(MeterialDO.ID_SRV, srvIdList), "", FBoolean.FALSE);
		if (MmDO != null) {
			for (MeterialDO mmDO : MmDO) {
				BdMmMap.put(mmDO.getId_mm(), mmDO.getPrintname());
			}
		}
		return BdMmMap;
	}

	/**
	 * 根据患者id查询挂号类型（1 医保 2 自费或者医保非持卡）
	 * 
	 * @param id_pat
	 * @return
	 * @throws DAException
	 */
	private HashMap<String, Integer> getPatType(String id_pat) throws DAException {
		HashMap<String, Integer> list = new HashMap<String, Integer>();
		String strSql = "select ent.id_ent,case when hp.fg_hp_card='Y'then 1 else 2 end as times_op from en_ent ent left join en_ent_hp hp on ent.id_ent=hp.id_ent and fg_maj='Y' where id_pat  = '" + id_pat + "' ";
		List<OutpatientDO> timesList = (List<OutpatientDO>) new DAFacade().execQuery(strSql, new BeanListHandler(OutpatientDO.class));
		if (timesList != null && timesList.size() > 0) {
			for (OutpatientDO pat : timesList) {
				list.put(pat.getId_ent(), pat.getTimes_op());
			}
		}
		return list;
	}

	/**
	 * 获取患者分类chis通过就诊编号
	 * 
	 * @param idEnList
	 * @return
	 * @throws DAException
	 */
	private Map<String, String> getPatCa(List<String> idEnList) throws DAException {
		if(ListUtil.isEmpty(idEnList)){
			return new HashMap<String, String>();
		}
		
		String strSql;
		Map<String, String> retMap = new HashMap<String, String>();
		strSql = "select ent.id_ent,patca.code_chis as Def1 from en_ent ent inner join pi_pat_ca patca on ent.id_patca=patca.id_patca where " + SqlUtils.getInSqlByIds("ent.id_ent", idEnList);
		List<PatiVisitDO> mapList = (List<PatiVisitDO>) new DAFacade().execQuery(strSql, new  BeanListHandler(PatiVisitDO.class));

		if (!ListUtil.isEmpty(mapList)) {
			for (PatiVisitDO map : mapList) {
				retMap.put(map.getId_ent(), map.getDef1());
			}
		}
		return retMap;
	}

	/**
	 * 获取患者信息
	 * 
	 * @param patCode
	 * @return
	 * @throws BizException
	 */
	private PatDO getPat(String patCode) throws BizException {
		String[] pat = { "Id_org,Barcode_chis" };
		List<PatDO> patDoList = (List<PatDO>) new DAFacade().findByCond(PatDO.class, "code = '" + patCode + "' ", "Id_pat", pat);

		if (patDoList == null || patDoList.size() <= 0) {
			return new PatDO();
		}

		return patDoList.get(0);
	}

	/**
	 * 获取医生信息
	 * 
	 * @param idPd
	 * @return
	 * @throws BizException
	 */
	private PsnDocDO getPsnDocDO(String idPd) throws BizException {
		IPsndocMDORService docser = ServiceFinder.find(IPsndocMDORService.class);
		PsnDocDO docdo = docser.findById(idPd);
		if (docdo == null) {
			throw new BizException("未查询到对应的开单医生！");
		}
		return docdo;
	}

	/**
	 * 获取医生信息
	 * 
	 * @param idPd
	 * @return
	 * @throws BizException
	 */
	private DeptDO getDeptDO(String idDep) throws BizException {
		StringBuilder sqlDep = new StringBuilder();
		sqlDep.append(" select id_dep,code,name from bd_dep where id_dep = ? ");
		SqlParam sqlParamDep = new SqlParam();
		sqlParamDep.addParam(idDep);
		@SuppressWarnings("unchecked")
		List<DeptDO> depList = (List<DeptDO>) new DAFacade().execQuery(sqlDep.toString(), sqlParamDep, new BeanListHandler(DeptDO.class));
		if (depList == null || depList.size() <= 0) {
			throw new BizException("未查询到对应的开单科室！");
		}
		return depList.get(0);
	}

	/**
	 * 获取医嘱信息
	 * 
	 * @param id_pat
	 * @param patType
	 * @param beginTime
	 * @param endTime
	 * @return
	 * @throws BizException
	 * @author LIM
	 */
	private BlOrderAppendBillParamDTO[] getBlOrder(String id_pat) throws BizException {

		// 1.根据患者code查询患者id_pat
		// PatDO pat = new PatDO();
		// pat = this.getPat(patCode);
		// if (pat == null || pat.getId_pat() == null) {
		// throw new BizException("该患者不存在！");
		// }
		if (StringUtils.isEmpty(id_pat)) {
			throw new BizException("该患者不存在！");
		}
		IBLStQueService server = ServiceFinder.find(IBLStQueService.class);
		// 使用门诊收费调入接口 并设置为不删除记账数据
		BlOrderAppendBillParamDTO[] blOrder = server.getOrderSrvPrinceInfoByIdpres_load_NoDel(id_pat, BlParams.BLSTOEP0004());
		// 预划价
		IBLCiOrderToBlCgService blservice = ServiceFinder.find(IBLCiOrderToBlCgService.class);
		blOrder = blservice.computePrice(blOrder);
		return blOrder;
	}
}
