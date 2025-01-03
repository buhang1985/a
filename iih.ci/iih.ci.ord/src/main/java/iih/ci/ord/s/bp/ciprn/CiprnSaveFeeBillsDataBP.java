package iih.ci.ord.s.bp.ciprn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.cfg.dto.fee.FeeDataMergeDTO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciprn.d.CiPrnDO;
import iih.ci.ord.ciprn.d.CiPrnItmDO;
import iih.ci.ord.ciprn.d.CiprintAggDO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.i.IOrdsrvmmRService;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.util.biz.CiEnContextUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 费用清单打印数据保存
 * @author Young
 *
 */
public class CiprnSaveFeeBillsDataBP {

	/**
	 * 执行保存
	 * @param idors
	 * @param Id_hp
	 * @param Sd_hptp
	 * @return
	 * @throws BizException
	 */
	public FBoolean exec(String[] idors, String Id_hp, String Sd_hptp) throws BizException {
		if (idors == null || idors.length <= 0)
			return FBoolean.TRUE;
//		CiprnDeleteFeeBillsDataBP bp = new CiprnDeleteFeeBillsDataBP();
//		bp.exec(idors, false);
		OrdSrvDO[] srvDOs = CiprnUtils.GetOrdSrvDOByIdorFee(idors);
		if (srvDOs == null || srvDOs.length == 0)
			return null;
		List<String> lstIdorsrvs = new ArrayList<String>();
		for (OrdSrvDO srvDO : srvDOs) {
			lstIdorsrvs.add(srvDO.getId_orsrv());
		}
		OrdSrvDO[] srvDos = getNewPrintData(lstIdorsrvs);
		if (srvDos == null || srvDos.length <= 0)
			return null;
		
		List<String> lstIdors=new ArrayList<String>();
		for (OrdSrvDO srv : srvDos) {
			if(!lstIdors.contains(srv.getId_or())){
				lstIdors.add(srv.getId_or());
			}
		}
		CiOrderDO[] ciorders = CiprnUtils.GetCiOrderDOByIds(lstIdors.toArray(new String[] {}));
		Map<String, CiOrderDO> mapCiOrderDOs = new HashMap<String, CiOrderDO>();
		for (CiOrderDO ciorder : ciorders) {
			mapCiOrderDOs.put(ciorder.getId_or(), ciorder);
		}
		
		List<FeeDataMergeDTO> feeDataMergeList  = getPrintBillData(srvDos, mapCiOrderDOs);

		if (feeDataMergeList.size() == 0)
			return null;
		
		List<CiprintAggDO> aggDOs = getCiprintAggDOs(srvDos, feeDataMergeList, Id_hp, Sd_hptp, mapCiOrderDOs);
		if (aggDOs == null || aggDOs.size() <= 0)
			return null;
		CiprintAggDO[] result = CiprnUtils.SaveCiprintAggDO(aggDOs.toArray(new CiprintAggDO[aggDOs.size()]));

		return result != null ? FBoolean.TRUE : FBoolean.FALSE;
	}

	/**
	 * 获取需要打印的所有数据（未打过的）
	 * 
	 * @param idorsrvs
	 * @return
	 * @throws BizException
	 */
	private OrdSrvDO[] getNewPrintData(List<String> idorsrvs) throws BizException {
		if (idorsrvs == null || idorsrvs.size() <= 0)
			return null;
		CiPrnItmDO[] ciPrnItmDOs = CiprnUtils.GetCiPrnItmDOByIdorsrv(idorsrvs);
		if (ciPrnItmDOs != null && ciPrnItmDOs.length > 0) {
			//去除已打印的
			for (CiPrnItmDO itmDO : ciPrnItmDOs) {
				if (idorsrvs.contains(itmDO.getId_biz()))
					idorsrvs.remove(itmDO.getId_biz());
			}
		}
		//获取新增打印的医嘱服务DO集合
		OrdSrvDO[] srvDos = CiprnUtils.GetOrdSrvDOById(idorsrvs.toArray(new String[idorsrvs.size()]));

		return srvDos;
	}

	/**
	 * 构造分单依据集合
	 * @param srvDos
	 * @param mapCiOrderDOs
	 * @return
	 * @throws BizException
	 */
	private List<FeeDataMergeDTO> getPrintBillData(OrdSrvDO[] ordSrvs, Map<String, CiOrderDO> mapCiOrderDOs) throws BizException {

		List<FeeDataMergeDTO> feeDataMergeList = new ArrayList<FeeDataMergeDTO>();
		if (ordSrvs == null || ordSrvs.length == 0)
			return feeDataMergeList;
		
		//构造分单依据集合，依据  Id_emp_sign签署医生/Id_dep_mp执行科室/Fg_selfpay是否医保内/Fg_specill特殊病  进行分单,根据属性拼接后的字符串作为分组规则
		List<String> identitifactionList = new ArrayList<String>(); 
		
		for(OrdSrvDO ordSrv : ordSrvs){
			
			//判断是否签署
			CiOrderDO ciorder = mapCiOrderDOs.get(ordSrv.getId_or());
			if (!FBoolean.TRUE.equals(ciorder.getFg_sign()))
				continue;
			
			String id_emp_sign = StringUtils.isNullOrEmpty(ciorder.getId_emp_sign()) ? "" : ciorder.getId_emp_sign();
			String id_dep_mp = StringUtils.isNullOrEmpty(ordSrv.getId_dep_mp()) ? "" : ordSrv.getId_dep_mp();
			
			String key = id_emp_sign+ id_dep_mp+ordSrv.getFg_selfpay() + ordSrv.getFg_specill();
			
			if(identitifactionList.contains(key)){
				continue;
			}
			
			identitifactionList.add(key);
			
			FeeDataMergeDTO  feeDataMerge = new FeeDataMergeDTO();
			feeDataMerge.setId_emp_sign(id_emp_sign);
			feeDataMerge.setId_dep_mp(id_dep_mp);
			feeDataMerge.setFg_selfpay(ordSrv.getFg_selfpay());
			feeDataMerge.setFg_specill(ordSrv.getFg_specill());
			
			feeDataMergeList.add(feeDataMerge);
		}
		
		return feeDataMergeList;	
		
	}

	/**
	 * 根据分单依据集合构造打印对象集合
	 * @param srvDos
	 * @param typelist
	 * @param Id_hp
	 * @param Sd_hptp
	 * @param mapCiOrderDOs
	 * @return
	 * @throws BizException
	 */
	private List<CiprintAggDO> getCiprintAggDOs(OrdSrvDO[] srvDos, List<FeeDataMergeDTO> feeDataMergeList, String Id_hp,
			String Sd_hptp, Map<String, CiOrderDO> mapCiOrderDOs) throws BizException {
		List<CiprintAggDO> aggdolist = new ArrayList<CiprintAggDO>();
		String idor = "";
		CiOrderDO ciorder = new CiOrderDO();
		FBoolean fg_hp = FBoolean.FALSE;
		
		String strIdorsrvs = "";
		for (OrdSrvDO srv : srvDos) {
			strIdorsrvs += ",'" + srv.getId_orsrv() + "'";
		}
		IOrdsrvmmRService srvmmRService = ServiceFinder.find(IOrdsrvmmRService.class);
		OrdSrvMmDO[] ordSrvMmDOs = srvmmRService.find(" id_orsrv in (" + strIdorsrvs.substring(1) + ")", null,
				FBoolean.FALSE);
		Map<String, List<OrdSrvMmDO>> mapOrdSrvMmDOs = new HashMap<String, List<OrdSrvMmDO>>();
		if (ordSrvMmDOs != null && ordSrvMmDOs.length > 0) {
			for (OrdSrvMmDO ordSrvMmDO : ordSrvMmDOs) {
				if (mapOrdSrvMmDOs.containsKey(ordSrvMmDO.getId_orsrv())) {
					mapOrdSrvMmDOs.get(ordSrvMmDO.getId_orsrv()).add(ordSrvMmDO);
				} else {
					List<OrdSrvMmDO> lst = new ArrayList<OrdSrvMmDO>();
					lst.add(ordSrvMmDO);
					mapOrdSrvMmDOs.put(ordSrvMmDO.getId_orsrv(), lst);
				}
			}
		}
		
		idor = srvDos[0].getId_or();
		ciorder = mapCiOrderDOs.get(idor);
		fg_hp = ciorder.getFg_orhp();
		
		String strDi = CiprnUtils.GetStr_name_di(ciorder.getId_en());
		
		CiPrnDO prnDO4NO = new CiPrnDO();
		prnDO4NO.setId_en(ciorder.getId_en());
		String[] presNOs = CiOrdUtils.generateNormNOs(feeDataMergeList.size(), prnDO4NO);
		int i = 0;
		
		for(FeeDataMergeDTO feeDataMerge : feeDataMergeList){
			
			CiprintAggDO aggDO = new CiprintAggDO();
			CiPrnDO prnDO = new CiPrnDO();
			List<CiPrnItmDO> prnItmDOs = new ArrayList<CiPrnItmDO>();

			//第一次打印的单据（新增）
			for (OrdSrvDO srv : srvDos) {
				//获取签署医生ID
				if (!srv.getId_or().equals(idor)) {
					idor = srv.getId_or();
					ciorder = mapCiOrderDOs.get(idor);
				}

				String id_emp_sign = StringUtils.isNullOrEmpty(ciorder.getId_emp_sign()) ? "" : ciorder.getId_emp_sign();
				String id_dep_mp = StringUtils.isNullOrEmpty(srv.getId_dep_mp()) ? "" : srv.getId_dep_mp();
				
				if(feeDataMerge.getId_emp_sign().equals(id_emp_sign) && feeDataMerge.getId_dep_mp().equals(id_dep_mp)
						&& feeDataMerge.getFg_selfpay().equals(srv.getFg_selfpay()) && feeDataMerge.getFg_specill().equals(srv.getFg_specill())){
					
					CiPrnItmDO prnItmDO = new CiPrnItmDO();
					prnItmDO.setId_biz(srv.getId_orsrv());
					//业务金额
					if (srv.getFg_bl().equals(FBoolean.TRUE)) {
						if (srv.getFg_mm().equals(FBoolean.TRUE)) {
							if(mapOrdSrvMmDOs.containsKey(srv.getId_orsrv())){
								OrdSrvMmDO[] srvMmDOs = mapOrdSrvMmDOs.get(srv.getId_orsrv()).toArray(new OrdSrvMmDO[0]);
								if (srvMmDOs != null && srvMmDOs.length > 0) {
									if (srvMmDOs[0].getQuan_cur() == null || srvMmDOs[0].getPrice_pgku_cur() == null) {
										prnItmDO.setAmt_biz(new FDouble("0.00"));
									} else {
										prnItmDO.setAmt_biz(srvMmDOs[0].getQuan_cur().multiply(
												srvMmDOs[0].getPrice_pgku_cur()));
									}
								}
							}
						} else {
							if (srv.getQuan_total_medu() == null || srv.getPri() == null) {
								prnItmDO.setAmt_biz(new FDouble("0.00"));
							} else {
								prnItmDO.setAmt_biz(srv.getQuan_total_medu().multiply(srv.getPri()));
							}
						}
					} else {
						prnItmDO.setAmt_biz(new FDouble("0.00"));
					}
					fg_hp = ciorder.getFg_orhp();
					prnItmDO.setStatus(DOStatus.NEW);
					prnItmDOs.add(prnItmDO);
				}
			}
			prnDO.setId_grp(ciorder.getId_grp());
			prnDO.setId_org(ciorder.getId_org());
			prnDO.setId_en(ciorder.getId_en());
			prnDO.setId_entp(ciorder.getId_entp());
			prnDO.setCode_entp(ciorder.getCode_entp());
			//			prnDO.setId_di(Id_di);
			//			prnDO.setId_diitm(Id_diitm);
			//			prnDO.setStr_id_diitm(Str_id_diitm);
			//			prnDO.setStr_code_di(Str_code_di);
			prnDO.setStr_name_di(strDi);
			//			prnDO.setName_diag(Name_diag);
			prnDO.setId_pat(ciorder.getId_pat());
			prnDO.setFg_bb(ciorder.getFg_bb());
			prnDO.setNo_bb(ciorder.getNo_bb());
			prnDO.setCode_prn(presNOs[i]);
			prnDO.setName_prn("门诊诊疗项目收费清单");
			prnDO.setId_org_prn(Context.get().getOrgId());
			prnDO.setId_dep_prn(Context.get().getDeptId());
			prnDO.setId_emp_prn(Context.get().getStuffId());
			prnDO.setDt_prn(new FDateTime());
			prnDO.setId_dep_mp(ciorder.getId_dep_mp());
			prnDO.setId_ciprntp(IBdSrvDictCodeConst.SD_CIPRNTP_COSTBILL_ID);
			prnDO.setSd_ciprntp(IBdSrvDictCodeConst.SD_CIPRNTP_COSTBILL);
			prnDO.setFg_prn(FBoolean.FALSE);
			prnDO.setCnt_prn(0);
			prnDO.setFg_hp(fg_hp);
			prnDO.setFg_prepay(ciorder.getFg_prepay());
			prnDO.setFg_hecominsur(CiEnContextUtil.isHeComInsurPat(Id_hp, Sd_hptp) ? FBoolean.TRUE : FBoolean.FALSE);
			//			prnDO.setHecominsurinfo(Hecominsurinfo);
			prnDO.setFg_vip(ciorder.getFg_vip());
			prnDO.setFg_blsettled(FBoolean.FALSE);
			prnDO.setFg_specill(feeDataMerge.getFg_specill());
			prnDO.setStatus(DOStatus.NEW);

			aggDO.setParentDO(prnDO);
			aggDO.setCiPrnItmDO(prnItmDOs.toArray(new CiPrnItmDO[prnItmDOs.size()]));
			aggdolist.add(aggDO);
			i++;
		}

		return aggdolist;
	}

}
