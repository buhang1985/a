package iih.ei.std.s.v1.bp.pe.updatebyplan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.thoughtworks.xstream.alias.ClassMapper.Null;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.bc.udi.pub.IMpNsDictCodeConst;
import iih.bl.cg.dto.cglogic.d.RefundModeEnum;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ei.std.d.v1.mp.updatebycodeor.d.UpdateStatusParams;
import iih.ei.std.d.v1.mp.updatebycodeor.d.WOrPlanDTO;
import iih.ei.std.s.v1.bp.common.EiParamUtils;
import iih.ei.std.s.v1.bp.mp.common.CreateTemTable;
import iih.ei.std.s.v1.bp.mp.common.MpnrUtils;
import iih.ei.std.s.v1.bp.mp.updatebyplan.qry.QueryPlanSql;
import iih.mp.nr.api.d.StatusContrastDTO;
import iih.mp.nr.dto.internal.d.ExecuteTpEnum;
import iih.mp.nr.dto.internal.d.OrPlanDTO;
import iih.mp.nr.dto.internal.d.StatusDTO;
import iih.mp.nr.dto.temporarytable.d.TamTableColumnDTO;
import iih.mp.nr.dto.temporarytable.d.TamTableDataDTO;
import iih.mp.nr.i.IMporInternalService;
import iih.mp.nr.mpcharge.IMpChargeService;
import iih.mp.nr.mpcharge.d.MpChargeRltDTO;
import iih.mp.nr.mpcharge.d.MpRefundChargeSetDTO;
import iih.mp.nr.mporplan.d.ExecuteStatusEnum;
import iih.mp.nr.mporplan.d.MpOrPlanDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FType;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;

/**
 * 修改医嘱状态
 * 
 * @author hjh
 *
 */
public class UpdatePeOrStaBp {
	private Map<String, String> infoMap;// 人员部门基本信息
	private String id_orpltp;// 一次调用只能是相同类型 相同闭环医嘱

	/**
	 * 主入口
	 * 
	 * @param statusParam
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public void exec(UpdateStatusParams statusParam) throws BizException {

		// 1.参数校验
		validateParam(statusParam);

		// 2.根据医嘱编码查询医嘱主键
		List<WOrPlanDTO> list = statusParam.getOrplan();
		String[] ors = getcodeors(list);
		// 实例化部门人员信息
		setMpData(list);

		// 3.根据医嘱编码查询医嘱信息
		CiOrderDO[] orderDOs = ServiceFinder.find(ICiorderMDORService.class).findByAttrValStrings(CiOrderDO.CODE_OR, ors);

		// 3.5校验是否存在对应的医嘱
		existCiOrder(ors, orderDOs);

		// 4.根据医嘱号找到对应的映射
		Map<String, CiOrderDO> mapAll = groupbyCodeor(orderDOs);

		// 5.医嘱编码替换成医嘱id
		converData(mapAll, list);

		// 6.根据医嘱和计划执行时间查询计划
		MpOrPlanDO[] plans = queryBranch(list);

		// // 7.查询闭环功能对照
		// String funcode = queryOrpltpstaFunc(list.get(0).getCode_status());
		//
		// // 8.参数装换
		// OrPlanDTO[] orplans = createOrPlanDTO(list, plans);
		//
		// // 9.调用通用改状态
		// ServiceFinder.find(IMporInternalService.class).updateOrpltpByOr(orplans,
		// funcode, "");

		// 7.更新状态
		updateStatus(plans, list);

	}

	/**
	 * 参数校验
	 * 
	 * @param statusParam
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void validateParam(UpdateStatusParams statusParam) throws BizException {
		if (statusParam == null) {
			throw new BizException("参数空异常！");
		}
		List<WOrPlanDTO> list = statusParam.getOrplan();
		if (list == null || list.size() < 1) {
			throw new BizException("参数空异常！");
		}
		Set<String> staSet = new LinkedHashSet<>();
		for (WOrPlanDTO planDTO : list) {
			if (StringUtil.isEmptyWithTrim(planDTO.getCode_or())) {
				throw new BizException("医嘱编码为空！");
			}
			if (StringUtil.isEmptyWithTrim(planDTO.getCode_dep_exec())) {
				throw new BizException("执行科室编码为空！");
			}
			if (StringUtil.isEmptyWithTrim(planDTO.getCode_status())) {
				throw new BizException("医嘱状态更新接口,状态码【Code_status】空异常");
			} else {
				staSet.add(planDTO.getCode_status());
			}
		}
		if (staSet.size() != 1) {
			throw new BizException("医嘱状态更新接口,状态码【Code_status】不一致");
		}
	}

	/**
	 * 赋值执行人执行科室，执行执行时间
	 * 
	 * @param orPlanDTOs
	 * @param params
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void setMpData(List<WOrPlanDTO> list) throws BizException {
		infoMap = new HashMap<String, String>();
		DAFacade daf = new DAFacade();
		List<DeptDO> deptDOs = (List<DeptDO>) daf.findByAttrValString(DeptDO.class, DeptDO.CODE, list.get(0).getCode_dep_exec(), new String[] { DeptDO.CODE, DeptDO.ID_DEP });
		PsnDocDO[] psnDocDOs = null; 
		if (!StringUtil.isEmptyWithTrim(list.get(0).getCode_emp_exec())) {			
		   psnDocDOs = ServiceFinder.find(IPsndocMDORService.class).findByAttrValString(PsnDocDO.CODE, list.get(0).getCode_emp_exec());
		}
		if (deptDOs != null && deptDOs.size() > 0) {
			infoMap.put(deptDOs.get(0).getCode(), deptDOs.get(0).getId_dep());
			Context.get().setDeptId(deptDOs.get(0).getId_dep());

		} else {
			throw new BizException("医嘱状态修改接口,科室编码有误,未查询到科室信息");
		}
		if (psnDocDOs != null && psnDocDOs.length > 0) {
			infoMap.put(psnDocDOs[0].getCode(), psnDocDOs[0].getId_psndoc());
			Context.get().setStuffId(psnDocDOs[0].getId_psndoc());
		}
	}

	/**
	 * 获取医嘱编码集合
	 * 
	 * @param pramList
	 * @return
	 */
	private String[] getcodeors(List<WOrPlanDTO> list) {
		List<String> codeorList = new ArrayList<String>();
		for (WOrPlanDTO planDTO : list) {
			codeorList.add(planDTO.getCode_or());
		}
		return codeorList.toArray(new String[codeorList.size()]);
	}

	/**
	 * 校验入参的医嘱编码是否有与之对应的医嘱信息
	 * 
	 * @param ors
	 * @param orderDOs
	 * @throws BizException
	 */
	private void existCiOrder(String[] ors, CiOrderDO[] orderDOs) throws BizException {
		StringBuffer buffer = new StringBuffer("");
		if (null == orderDOs || orderDOs.length == 0) {
			for (String code_or : ors) {
				buffer.append("修改医嘱状态：医嘱编码【" + code_or + "】的医嘱不存在\r\n");
			}
		} else if (orderDOs.length < ors.length) {
			for (String code_or : ors) {
				int i = -1;
				for (CiOrderDO ciOrderDO : orderDOs) {
					if (code_or.equals(ciOrderDO.getCode_or())) {
						i++;
						break;
					}
				}
				if (i == -1) {
					buffer.append("修改医嘱状态：医嘱编码【" + code_or + "】的医嘱不存在\r\n");
				}

			}
		}
		if (!StringUtil.isEmptyWithTrim(buffer.toString())) {
			throw new BizException(buffer.toString());
		}
	}

	/**
	 * 返回医嘱编码和医嘱实体的映射
	 * 
	 * @param orderDOs
	 * @param mapop
	 * @param mapip
	 * @return
	 * @throws BizException
	 */
	private Map<String, CiOrderDO> groupbyCodeor(CiOrderDO[] orderDOs) throws BizException {
		Map<String, CiOrderDO> map = new HashMap<String, CiOrderDO>();
		id_orpltp = "";
		if (orderDOs != null && orderDOs.length > 0) {
			for (CiOrderDO ciOrderDO : orderDOs) {
				if (!StringUtil.isEmptyWithTrim(id_orpltp) && !id_orpltp.equals(ciOrderDO.getId_orpltp())) {
					throw new BizException("闭环状态不一致！");
				}
				map.put(ciOrderDO.getCode_or(), ciOrderDO);
				id_orpltp = ciOrderDO.getId_orpltp();
			}
		}
		return map;
	}

	/**
	 * 赋值医嘱ID
	 * 
	 * @param mapAll
	 * @param pramList
	 * @throws BizException
	 */
	private void converData(Map<String, CiOrderDO> mapAll, List<WOrPlanDTO> list) throws BizException {
		for (WOrPlanDTO updateStatusParam : list) {
			CiOrderDO orderdo = mapAll.get(updateStatusParam.getCode_or());
			updateStatusParam.setCode_or(mapAll.get(updateStatusParam.getCode_or()).getId_or());
			if (FBoolean.TRUE.equals(orderdo.getFg_long()) && StringUtil.isEmptyWithTrim(updateStatusParam.getDt_mp_plan())) {
				throw new BizException("计划执行时间！");
			}
		}

	}

	/**
	 * 创建临时表查询执行计划
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	private MpOrPlanDO[] queryBranch(List<WOrPlanDTO> list) throws BizException {

		// 创建临时表
		new DAFacade().execUpdate("delete from mp_or_pr_temp;", new SqlParam());
		String tableName = createTable(list);
		QueryPlanSql sql = new QueryPlanSql(tableName);
		MpOrPlanDO[] rtns = (MpOrPlanDO[]) AppFwUtil.getDORstWithDao(sql, MpOrPlanDO.class);
		return rtns;
	}

	/**
	 * 列生产
	 * 
	 * @param columnName
	 * @param columnTp
	 * @param type
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private TamTableColumnDTO getColumn(String columnName, String columnTp, FType type) {

		TamTableColumnDTO column = new TamTableColumnDTO();
		column.setColumn(columnName);
		column.setColumntp(columnTp);
		FArrayList array = new FArrayList();
		array.add(type);
		column.setDatatp(array);
		return column;
	}

	/**
	 * 创建临时表
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	private String createTable(List<WOrPlanDTO> list) throws BizException {

		TamTableColumnDTO[] columns = new TamTableColumnDTO[3];
		columns[0] = getColumn("Id_or", "VARCHAR2(20)", FType.String);
		columns[1] = getColumn("Dt_mp_plan", "CHAR(19)", FType.FDateTime);
		columns[2] = getColumn("Id_or_pr", "VARCHAR2(20)", FType.String);

		TamTableDataDTO[] columnData = getTemTableData(list);

		String tableName = "mp_or_pr_temp";
		CreateTemTable bp = new CreateTemTable();
		bp.exec(tableName, columns, columnData);
		return tableName;
	}

	/**
	 * 获取临时表数据
	 * 
	 * @param ParamDTO
	 * @return
	 */
	private TamTableDataDTO[] getTemTableData(List<WOrPlanDTO> list) {

		List<TamTableDataDTO> reList = new ArrayList<TamTableDataDTO>();
		for (WOrPlanDTO param : list) {
			TamTableDataDTO DTO = new TamTableDataDTO();
			DTO.setColumn1(param.getCode_or());
			DTO.setColumn2(param.getDt_mp_plan().toString());
			DTO.setColumn3("~");
			reList.add(DTO);
		}
		return reList.toArray(new TamTableDataDTO[reList.size()]);
	}

	/**
	 * 查询闭环功能对照
	 * 
	 * @param code_status
	 * @return
	 * @throws BizException
	 */
	private String queryOrpltpstaFunc(String code_status) throws BizException {
		QueryPeOrpltpstaBp stabp = new QueryPeOrpltpstaBp();
		StatusContrastDTO[] funsta = stabp.exec(code_status, id_orpltp);
		if (funsta == null || funsta.length < 1) {
			throw new BizException("闭环功能未对照！");
		}
		return funsta[0].getFun_code();
	}

	/**
	 * 构建更新计划状态所需参数
	 * 
	 * @param orMpPlanDTOs
	 * @param infoMap
	 * @param params
	 * @return
	 */
	private OrPlanDTO[] createOrPlanDTO(List<WOrPlanDTO> list, MpOrPlanDO[] plans) {

		List<OrPlanDTO> orPlanDTOs = new ArrayList<OrPlanDTO>();
		for (MpOrPlanDO orMpPlanDTO : plans) {
			OrPlanDTO planDTO = new OrPlanDTO();
			planDTO.setId_or(orMpPlanDTO.getId_or());
			planDTO.setDt_mp_plan(orMpPlanDTO.getDt_mp_plan());
			planDTO.setId_dep(infoMap.get(list.get(0).getCode_dep_exec()));
			planDTO.setId_emp(infoMap.get(list.get(0).getCode_emp_exec()));
			planDTO.setDt_exe(new FDateTime(list.get(0).getDt_exec()));
			planDTO.setEu_tp(ExecuteTpEnum.EXECUTE);
			orPlanDTOs.add(planDTO);
		}
		return orPlanDTOs.toArray(new OrPlanDTO[orPlanDTOs.size()]);
	}

	/**
	 * 状态更新
	 * 
	 * @param plans
	 * @param list
	 * @throws BizException 
	 */
	private void updateStatus(MpOrPlanDO[] plans, List<WOrPlanDTO> list) throws BizException {
		// 执行状态取消
		if (IMpNsDictCodeConst.SD_CANCELSTATUS.equals(list.get(0).getCode_status())) {
			cancelStatusAndRefund(plans, list.toArray(new WOrPlanDTO[0]));
		} else {
			// 1.封装状态参数
			StatusDTO dto = packageStatusDTO(list.get(0).getCode_status());
			// 2.参数装换
			OrPlanDTO[] orplans = createOrPlanDTO(list.toArray(new WOrPlanDTO[0]), plans, ExecuteTpEnum.EXECUTE);
			// 3.调用通用改状态 并根据闭环配置计费
			ServiceFinder.find(IMporInternalService.class).updateOrpltpAndChargeByOuter(orplans, dto, FBoolean.TRUE);
		}
	}


	/**
	 * 取消及退费
	 * 
	 * @param plans
	 * @param array
	 * @throws BizException 
	 */
	private void cancelStatusAndRefund(MpOrPlanDO[] plans, WOrPlanDTO[] array) throws BizException {
		// 根据就诊类型将执行计划分组
		HashMap<String, List<MpOrPlanDO>> mapPlans = groupBaseDO(plans, MpOrPlanDO.CODE_ENTP);

		// 门诊状态取消退计费
		EiParamUtils paramUtil = new EiParamUtils();
		if (mapPlans.containsKey(IBdFcDictCodeConst.SD_CODE_ENTP_OP)) {

			if (FBoolean.TRUE.equals(paramUtil.MPNR0146()) && IBlDictCodeConst.PARAM_VALUE_EXECACCOUNT.equals(paramUtil.BLCG0002())) {
				List<MpOrPlanDO> opOrPlans = mapPlans.get(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
				// 医嘱取消(闭环状态直接返回到初始状态)门诊退费
				opRefundForInitial(opOrPlans);
				// 医嘱取消(闭环状态返回上一状态)门诊退费
				// opRefundForPre(opOrPlans);
			}
		}

		// 住院状态取消退计费
		if (mapPlans.containsKey(IBdFcDictCodeConst.SD_CODE_ENTP_IP)) {
			List<MpOrPlanDO> ipOrPlans = mapPlans.get(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
			List<String> idorprList = getIdOrPrs(ipOrPlans, ICiDictCodeConst.SD_SU_BL_ACCOUNT);
			if (idorprList != null && idorprList.size() > 0) {
				if (FBoolean.TRUE.equals(paramUtil.MPNR0146())) {
					MpRefundChargeSetDTO refundChargeSetDTO = getRefundParamset();
					MpChargeRltDTO[] rtns = ServiceFinder.find(IMpChargeService.class).mpRefundByOrpr(idorprList.toArray(new String[idorprList.size()]), refundChargeSetDTO);
				}
			}
		}

		// 状态取消 (直接回退到闭环的初始状态)
		if (FBoolean.TRUE.equals(paramUtil.MPNR0146())) {
			OrPlanDTO[] orPlans = createOrPlanDTO(array, plans, ExecuteStatusEnum.CANCEL);
			IMporInternalService service = ServiceFinder.find(IMporInternalService.class);
			service.cancelByOtherSys(orPlans);
		}

	}


	/**
	 * 分组
	 * 
	 * @param params
	 * @param attrName
	 * @return
	 */
	private HashMap<String, List<MpOrPlanDO>> groupBaseDO(MpOrPlanDO[] params, String attrName) {
		HashMap<String, List<MpOrPlanDO>> reMap = new HashMap<String, List<MpOrPlanDO>>();
		if (params != null && params.length > 0) {
			for (MpOrPlanDO t : params) {
				Object key = t.getAttrVal(attrName);
				if (key == null)
					continue;
				if (reMap.containsKey(key.toString())) {
					reMap.get(key.toString()).add(t);
				} else {
					List<MpOrPlanDO> list = new ArrayList<MpOrPlanDO>();
					list.add(t);
					reMap.put(key.toString(), list);
				}
			}
		}
		return reMap;
	}

	/**
	 * 医嘱取消(闭环状态直接返回到初始状态)门诊退费
	 * 
	 * @param opOrPlans
	 * @throws BizException 
	 */
	private void opRefundForInitial(List<MpOrPlanDO> opOrPlans) throws BizException {
		String[] id_ors = MpnrUtils.getAttrVal(opOrPlans, MpOrPlanDO.ID_OR);
		ServiceFinder.find(IMporInternalService.class).mpOpOrderRefund(id_ors);
	}

	
	/**
	 * 获取退费的执行计划id
	 * 
	 * @param ipOrPlans
	 * @param sdSuBlAccount
	 * @return
	 * @throws DAException
	 */
	private List<String> getIdOrPrs(List<MpOrPlanDO> ipOrPlans, String sd_su_bl) throws DAException {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		// 获取id_or的集合
		List<String> id_orList = new ArrayList<String>();
		for (MpOrPlanDO mpPlanDO : ipOrPlans) {
			if (map.containsKey(mpPlanDO.getId_or())) {
				map.get(mpPlanDO.getId_or()).add(mpPlanDO.getId_or_pr());
			} else {
				List<String> rtnList = new ArrayList<String>();
				rtnList.add(mpPlanDO.getId_or_pr());
				map.put(mpPlanDO.getId_or(), rtnList);
			}
			id_orList.add(mpPlanDO.getId_or());
		}

		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		List<CiOrderDO> orderDOs = (List<CiOrderDO>) daf.findByPKs(CiOrderDO.class, id_orList.toArray(new String[id_orList.size()]), new String[] { CiOrderDO.ID_OR, CiOrderDO.ID_DEP_MP, CiOrderDO.SD_SU_BL });

		List<String> idorprList = new ArrayList<String>();
		if (orderDOs != null && orderDOs.size() > 0) {
			// 计费科室只会是一个
			for (CiOrderDO ord : orderDOs) {
				if (sd_su_bl.equals(ord.getSd_su_bl())) {
					idorprList.addAll(map.get(ord.getId_or()));
				}
				Context.get().setDeptId(ord.getId_dep_mp());
			}
		}

		return idorprList;
	}
	
	/**
	 * 获取记账参数
	 * @return
	 */
	private MpRefundChargeSetDTO getRefundParamset() {
		MpRefundChargeSetDTO rtn = new MpRefundChargeSetDTO();
		rtn.setId_emp_cg(Context.get().getStuffId());// 记账人
		rtn.setId_dep_cg(Context.get().getDeptId());// 记账科室
		rtn.setDt_cg(new FDateTime());// 记账时间
		rtn.setFg_singlepat(FBoolean.FALSE);// 单患者模式
		rtn.setFg_exception(FBoolean.TRUE);// 是否抛异常
		rtn.setSrcfunc_des("techcharge");// 记账来源
		rtn.setEu_rfdmode(RefundModeEnum.PRSRV_KEY);
		return rtn;
	}
	
	/**
	 * 构建更新计划状态所需参数
	 * @param array
	 * @param plans
	 * @param cancel
	 * @return
	 * @throws BizException 
	 */
	private OrPlanDTO[] createOrPlanDTO(WOrPlanDTO[] pramList, MpOrPlanDO[] plans, Integer eu_su) throws BizException {
		if (null == plans || plans.length < 1) {
			throw new BizException("医嘱状态更新: 无执行计划");
		}
		List<OrPlanDTO> orPlanDTOs = new ArrayList<OrPlanDTO>();
		for (MpOrPlanDO orMpPlanDTO : plans) {
			OrPlanDTO planDTO = new OrPlanDTO();
			planDTO.setId_or(orMpPlanDTO.getId_or());
			planDTO.setId_or_pr(orMpPlanDTO.getId_or_pr());
			planDTO.setDt_mp_plan(orMpPlanDTO.getDt_mp_plan());
			planDTO.setCode_entp(orMpPlanDTO.getCode_entp());
			planDTO.setId_pat(orMpPlanDTO.getId_pat());
			planDTO.setId_dep(infoMap.get(pramList[0].getCode_dep_exec()));
			planDTO.setId_emp(infoMap.get(pramList[0].getCode_emp_exec()));
			planDTO.setDt_exe(pramList[0].getDt_exec() == null ? new FDateTime() : new FDateTime(pramList[0].getDt_exec()));			planDTO.setEu_tp(eu_su);
			orPlanDTOs.add(planDTO);
		}
		return orPlanDTOs.toArray(new OrPlanDTO[orPlanDTOs.size()]);
	}
	
	/**
	 * 封装状态参数
	 * @param code_status
	 * @return
	 * @throws BizException 
	 */
	private StatusDTO packageStatusDTO(String code_status) throws BizException {
		if (StringUtil.isEmptyWithTrim(code_status)) {
			throw new BizException("修改医嘱状态,第三方状态对照码为空");
		}
		StatusDTO dto = new StatusDTO();
		dto.setCode_status(code_status);
		dto.setIsiih(FBoolean.FALSE);
		return dto;
	}
}
