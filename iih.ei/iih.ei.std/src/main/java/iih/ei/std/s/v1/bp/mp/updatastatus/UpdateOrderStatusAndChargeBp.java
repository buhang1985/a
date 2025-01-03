package iih.ei.std.s.v1.bp.mp.updatastatus;

import iih.bd.bc.event.pub.IMpEventConst;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.bc.udi.pub.IMpNsDictCodeConst;
import iih.bl.cg.dto.cglogic.d.RefundModeEnum;
import iih.bl.cg.i.IBlCgValidateService;
import iih.bl.cg.i.IBlOutCmdService;
import iih.bl.cg.service.udi.IBlCgCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.i.ICiorderMDOCudService;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.i.external.provide.ICiOrdMpService;
import iih.ei.std.d.v1.mp.updatestatus.d.BillsupplyDTO;
import iih.ei.std.d.v1.mp.updatestatus.d.OrMpPlanDTO;
import iih.ei.std.d.v1.mp.updatestatus.d.OrderstateDTO;
import iih.ei.std.d.v1.mp.updatestatus.d.StatusContrastDTO;
import iih.ei.std.s.v1.bp.common.EiParamUtils;
import iih.ei.std.s.v1.bp.mp.bill.SetSupplyBillBp;
import iih.ei.std.s.v1.bp.mp.common.MpnrUtils;
import iih.ei.std.s.v1.bp.mp.updatastatus.qry.QueryLabFeeQry;
import iih.ei.std.s.v1.bp.mp.updatastatus.qry.QueryOrPlanSql;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.mp.nr.dto.internal.d.OrPlanDTO;
import iih.mp.nr.i.IMporInternalService;
import iih.mp.nr.mpcharge.IMpChargeService;
import iih.mp.nr.mpcharge.d.MpChargeSetDTO;
import iih.mp.nr.mpcharge.d.MpRefundChargeSetDTO;
import iih.mp.nr.mporplan.d.ExecuteStatusEnum;
import iih.mp.nr.mporplan.d.MpOrPlanDO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;

/**
 * 
 * @ClassName: UpdateOrderStatusAndChargeBp
 * @Description: 更新相关医嘱状态 执行状态并计费
 * @author zhy
 * @date 2019年9月29日
 *
 */
public class UpdateOrderStatusAndChargeBp {

	private String code_status;// 状态
	private String code_entp;// 就诊类型
	private Map<String, String> infoMap;// 人员部门基本信息
	private String code_ent;// 就诊编码

	/**
	 * 程序入口
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public BaseDO exec(OrderstateDTO[] orderstateDTOs, BillsupplyDTO[] billsupplyDTOs) throws BizException {
		// 0.时间处理
		formatDate(orderstateDTOs);

		// 1.获取申请单号集合
		String[] no_appliforms = getApplyForms(orderstateDTOs);

		// 2.查询医嘱计划
		OrMpPlanDTO[] orPlanDTOs = queryOrPlan(no_appliforms);

		// 3.基础校验
		validation(orPlanDTOs);

		// 4.实例化人员部门信息
		setMpData(orderstateDTOs);

		// 5.计费处理
		boolean b = setbill(orPlanDTOs, orderstateDTOs, no_appliforms);

		// 6.状态处理
		handleStatus(orPlanDTOs, orderstateDTOs, no_appliforms);

		// 7.补费处理
		if (b || IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(code_entp)) {
			supplyBiil(billsupplyDTOs);
		}

		return null;
	}

	/**
	 * 时间类处理
	 * 
	 * @param orderstateDTOs
	 * @throws BizException
	 */
	private void formatDate(OrderstateDTO[] orderstateDTOs) throws BizException {
		Object obj = null;
		try {
			if (orderstateDTOs != null && orderstateDTOs.length > 0) {
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				for (OrderstateDTO orderstate : orderstateDTOs) {
					obj = orderstate.getAttrVal("Dt_exe");
					if (obj != null) {
						String dt = obj.toString().replace("/", "-");
						FDateTime dt_exe = new FDateTime(sf.parse(dt).getTime());
						orderstate.setDt_exe(dt_exe);
					}
				}
			}
		} catch (Exception e) {
			throw new BizException("医嘱执行状态更新：执行时间【" + obj + "】不合法");
		}

	}

	/**
	 * 获取申请单号集合
	 * 
	 * @param orderstateDTOs
	 * @return
	 */
	private String[] getApplyForms(OrderstateDTO[] orderstateDTOs) {
		List<String> reList = new ArrayList<String>();
		for (OrderstateDTO param : orderstateDTOs) {
			if (!reList.contains(param.getNo_applyform())) {
				reList.add(param.getNo_applyform());
			}
		}
		return reList.toArray(new String[reList.size()]);
	}

	/**
	 * 查询医嘱计划
	 * 
	 * @param no_appliforms
	 * @return
	 * @throws BizException
	 */
	private OrMpPlanDTO[] queryOrPlan(String[] no_appliforms) throws BizException {
		QueryOrPlanSql qry = new QueryOrPlanSql(no_appliforms);
		OrMpPlanDTO[] orPlanDTOs = (OrMpPlanDTO[]) AppFwUtil.getDORstWithDao(qry, OrMpPlanDTO.class);
		if (orPlanDTOs == null || orPlanDTOs.length < 1) {
			throw new BizException("医嘱执行状态更新：申请单不存在！");
		}
		// 作废医嘱给出提示
		for (OrMpPlanDTO orMpPlanDTO : orPlanDTOs) {
			if (null != orMpPlanDTO.getFg_canc() && orMpPlanDTO.getFg_canc().booleanValue()) {
				throw new BizException("医嘱执行状态更新：患者【" + orMpPlanDTO.getName_pat() + "】的【" + orMpPlanDTO.getName_or() + "】医嘱已作废!");
			}
		}

		PatiVisitDO ent = ServiceFinder.find(IPativisitRService.class).findById(orPlanDTOs[0].getId_ent());

		if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(ent.getCode_entp())) { // 门诊取code
			code_ent = ent.getCode();
		} else {
			code_ent = ent.getId_ent();
		}

		return orPlanDTOs;
	}

	/**
	 * 参数校验
	 * 
	 * @param orPlanDTOs
	 * @throws BizException
	 */
	private void validation(OrMpPlanDTO[] orPlanDTOs) throws BizException {
		String code_entp = orPlanDTOs[0].getCode_entp();
		if (StringUtil.isEmptyWithTrim(code_entp)) {
			throw new BizException("医嘱执行状态更新：就诊类型空异常");
		}

	}

	/**
	 * 赋值执行人执行科室，执行执行时间
	 * 
	 * @param orderstateDTOs
	 * @throws BizException
	 */
	private void setMpData(OrderstateDTO[] orderstateDTOs) throws BizException {
		infoMap = new HashMap<String, String>();
		DeptDO[] deptDOs = ServiceFinder.find(IDeptRService.class).findByAttrValString(DeptDO.CODE, orderstateDTOs[0].getCode_dep());
		PsnDocDO[] psnDocDOs = ServiceFinder.find(IPsndocMDORService.class).findByAttrValString(PsnDocDO.CODE, orderstateDTOs[0].getCode_emp());
		if (deptDOs != null && deptDOs.length > 0) {
			infoMap.put(deptDOs[0].getCode(), deptDOs[0].getId_dep());
			Context.get().setDeptId(deptDOs[0].getId_dep());

		}
		if (psnDocDOs != null && psnDocDOs.length > 0) {
			infoMap.put(psnDocDOs[0].getCode(), psnDocDOs[0].getId_psndoc());
			Context.get().setStuffId(psnDocDOs[0].getId_psndoc());
		}
	}

	/**
	 * 计费处理
	 * 
	 * @param orPlanDTOs
	 * @param orderstateDTOs
	 * @param no_appliforms
	 * @return
	 * @throws BizException
	 */
	private boolean setbill(OrMpPlanDTO[] orPlanDTOs, OrderstateDTO[] orderstateDTOs, String[] no_appliforms) throws BizException {

		// 实例化全局变量
		code_status = orderstateDTOs[0].getCode_status();
		code_entp = orPlanDTOs[0].getCode_entp();

		boolean b = false;
		if (IMpNsDictCodeConst.SD_CANCELSTATUS.equals(code_status)) {
			return b;
		}
		// 根据第三方闭环编码返回闭环ID
		StatusContrastDTO contrastDTO = getOrpltpStaMap(orderstateDTOs);
		String id_orpltpsta = contrastDTO.getId_orpltpsta();

		// 门诊计费
		if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(code_entp)) {
			b = opCharge(id_orpltpsta, orPlanDTOs, b);
		}

		// 住院计费
		if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(code_entp)) {
			b = ipCharge(id_orpltpsta, orPlanDTOs, b);
		}

		return b;
	}

	/**
	 * 获取闭环中的功能编码
	 * 
	 * @param orderstateDTOs
	 * @return
	 * @throws BizException
	 */
	private StatusContrastDTO getOrpltpStaMap(OrderstateDTO[] orderstateDTOs) throws BizException {
		String srvtp = getSrvtp(orderstateDTOs);
		String sd_org = "";
		String sd_product = "";
		if (srvtp.indexOf("03") == 0) {
			sd_org = IBdFcDictCodeConst.SD_LIS_ORG;
			sd_product = IBdFcDictCodeConst.SD_LIS_PRODUCT;
		} else if (srvtp.indexOf("02") == 0) {
			sd_org = "002";
			sd_product = "00201";
		} else {
			throw new BizException("状态未对照！");
		}
		GetStatusContractNewBp bp = new GetStatusContractNewBp();
		StatusContrastDTO[] statusDTOS = bp.exec(orderstateDTOs, sd_org, sd_product);
		if (statusDTOS == null || statusDTOS.length < 1) {
			return null;
		}
		return statusDTOS[0];
	}

	/**
	 * 获取服务类型
	 * 
	 * @param orderstateDTOs
	 * @return
	 * @throws BizException
	 */
	private String getSrvtp(OrderstateDTO[] orderstateDTOs) throws BizException {
		List<String> listApplyNo = new ArrayList<String>();
		for (OrderstateDTO sta : orderstateDTOs) {
			listApplyNo.add(sta.getNo_applyform());
		}
		CiOrderDO[] orders = ServiceFinder.find(ICiorderMDORService.class).findByAttrValStrings(CiOrderDO.APPLYNO, listApplyNo.toArray(new String[listApplyNo.size()]));
		if (orders != null && orders.length > 0) {
			return orders[0].getSd_srvtp();
		}
		throw new BizException("申请单未找到！");
	}

	/**
	 * 门诊计费
	 * 
	 * @param id_orpltpsta
	 * @param orPlanDTOs
	 * @param b
	 * @return
	 * @throws BizException
	 */
	private boolean opCharge(String id_orpltpsta, OrMpPlanDTO[] orPlanDTOs, boolean b) throws BizException {

		if (EiParamUtils.MPNR0130().equals(id_orpltpsta) || EiParamUtils.SDLLMPNR0001().equals(id_orpltpsta)) {
			// 获取医嘱ID集合
			if (IBlDictCodeConst.PARAM_VALUE_EXECACCOUNT.equals(EiParamUtils.BLCG0002())) {
				Map<String, List<String>> mapPat = getIdOrsByPatID(orPlanDTOs, ICiDictCodeConst.SD_SU_BL_NONE+ICiDictCodeConst.SD_SU_BL_REFOUND);
				Set<String> idpat = mapPat.keySet();
				IBlOutCmdService service = ServiceFinder.find(IBlOutCmdService.class);
				for (String patId : idpat) {
					List<String> ordList = mapPat.get(patId);
					b = true;
					service.chareForOpPrepayOr(patId, ordList.toArray(new String[0]), IBlCgCodeConst.LisOrPacs);

				}
			}
		}
		return b;
	}

	/**
	 * 获取医嘱ID集合按患者ID分组
	 * 
	 * @param orPlanDTOs
	 * @param sdSuBlNone
	 * @return
	 * @throws DAException
	 */
	private Map<String, List<String>> getIdOrsByPatID(OrMpPlanDTO[] orPlanDTOs, String sd_su_bl) throws DAException {
		Map<String, List<String>> map = new HashMap<String, List<String>>();

		// 获取id_or的集合
		List<String> id_orList = new ArrayList<String>();
		for (OrMpPlanDTO mpPlanDTO : orPlanDTOs) {
			if (id_orList.contains(mpPlanDTO.getId_or())) {
				continue;
			}
			id_orList.add(mpPlanDTO.getId_or());
		}

		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		List<CiOrderDO> orderDOs = (List<CiOrderDO>) daf.findByPKs(CiOrderDO.class, id_orList.toArray(new String[id_orList.size()]), new String[] { CiOrderDO.ID_OR, CiOrderDO.ID_PAT, CiOrderDO.SD_SU_BL });
		if (orderDOs != null && orderDOs.size() > 0) {
			for (CiOrderDO ord : orderDOs) {
				if (sd_su_bl.contains(ord.getSd_su_bl())) {
					if (map.containsKey(ord.getId_pat())) {
						map.get(ord.getId_pat()).add(ord.getId_or());
					} else {
						List<String> rtnList = new ArrayList<String>();
						rtnList.add(ord.getId_or());
						map.put(ord.getId_pat(), rtnList);
					}
				}
			}
		}

		return map;
	}

	/**
	 * 住院计费
	 * 
	 * @param id_orpltpsta
	 * @param orPlanDTOs
	 * @param b
	 * @return
	 * @throws BizException
	 */
	private boolean ipCharge(String id_orpltpsta, OrMpPlanDTO[] orPlanDTOs, boolean b) throws BizException {

		String MPNR0130 = EiParamUtils.MPNR0130();
		String MPNR0131 = EiParamUtils.MPNR0131();
		;
		if (MPNR0130.equals(id_orpltpsta) || MPNR0131.equals(id_orpltpsta)) {
			Map<String, List<String>> depMap = getIdOrPrsBydep(orPlanDTOs, ICiDictCodeConst.SD_SU_BL_NONE);
			Set<String> id_deps = depMap.keySet();
			if (id_deps != null && id_deps.size() > 0) {
				MpChargeSetDTO paramSet = getParamset();
				b = true;
				IMpChargeService chargeService = ServiceFinder.find(IMpChargeService.class);
				for (String id_dep : id_deps) {
					Context.get().setDeptId(id_dep);
					List<String> idorprList = depMap.get(id_dep);
					chargeService.mpChargingByOrpr(idorprList.toArray(new String[idorprList.size()]), paramSet);
				}
			}
		}

		return false;
	}

	/**
	 * 计划主键按部门分组
	 * 
	 * @param orPlanDTOs
	 * @param sdSuBlNone
	 * @return
	 * @throws BizException
	 */
	private Map<String, List<String>> getIdOrPrsBydep(OrMpPlanDTO[] orPlanDTOs, String sd_su_bl) throws BizException {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		// 获取id_or的集合
		List<String> id_orList = new ArrayList<String>();
		for (OrMpPlanDTO mpPlanDTO : orPlanDTOs) {
			if (map.containsKey(mpPlanDTO.getId_or())) {
				map.get(mpPlanDTO.getId_or()).add(mpPlanDTO.getId_or_pr());
			} else {
				List<String> rtnList = new ArrayList<String>();
				rtnList.add(mpPlanDTO.getId_or_pr());
				map.put(mpPlanDTO.getId_or(), rtnList);
			}
			id_orList.add(mpPlanDTO.getId_or());
		}

		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		List<CiOrderDO> orderDOs = (List<CiOrderDO>) daf.findByPKs(CiOrderDO.class, id_orList.toArray(new String[id_orList.size()]), new String[] { CiOrderDO.ID_OR, CiOrderDO.ID_DEP_MP, CiOrderDO.SD_SU_BL });

		Map<String, List<String>> depMap = new HashMap<String, List<String>>();
		if (orderDOs != null && orderDOs.size() > 0) {
			// 计费科室只会是一个
			for (CiOrderDO ord : orderDOs) {
				if (FBoolean.TRUE.equals(ord.getFg_canc())) {
					throw new BizException(" 申请单号：" + ord.getApplyno() + " 的【" + ord.getName_or() + "] 已被医生作废！");
				}
				if (sd_su_bl.equals(ord.getSd_su_bl())) {
					if (depMap.containsKey(ord.getId_dep_mp())) {
						depMap.get(ord.getId_dep_mp()).addAll(map.get(ord.getId_or()));
					} else {
						List<String> idorprList = new ArrayList<String>();
						idorprList.addAll(map.get(ord.getId_or()));
						depMap.put(ord.getId_dep_mp(), idorprList);
					}
				}
			}
		}

		return depMap;
	}

	/**
	 * 获取记账参数
	 * 
	 * @return
	 */
	private MpChargeSetDTO getParamset() {
		MpChargeSetDTO rtn = new MpChargeSetDTO();
		rtn.setId_emp_cg(Context.get().getStuffId());// 记账人
		rtn.setId_dep_cg(Context.get().getDeptId());// 记账科室
		rtn.setDt_cg(new FDateTime());// 记账时间
		rtn.setFg_price_cal(FBoolean.TRUE);// 计算服务价格
		rtn.setFg_singlepat(FBoolean.FALSE);// 单患者模式
		rtn.setFg_postpaid(FBoolean.TRUE);// 是否支持后付费
		rtn.setFg_exception(FBoolean.TRUE);// 是否抛异常
		rtn.setSrcfunc_des("techcharge");// 记账来源
		return rtn;
	}

	/**
	 * 状态处理
	 * 
	 * @param orPlanDTOs
	 * @param orderstateDTOs
	 * @param no_appliforms
	 * @throws BizException
	 */
	private void handleStatus(OrMpPlanDTO[] orMpPlanDTOs, OrderstateDTO[] orderstateDTOs, String[] no_appliforms) throws BizException {
		if (IMpNsDictCodeConst.SD_CANCELSTATUS.equals(code_status)) {
			// 获取医嘱ID集合(过滤掉没有走计费闭环的数据)
			// 门诊取消状态回写
			// 调用临床接口返回试管费 采集费
			List<String> id_ors = ServiceFinder.find(ICiOrdMpService.class).getLisMegeRefundOrdIds(no_appliforms);

			if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(code_entp)) {
				// 门诊退费
				opRefund(orMpPlanDTOs, orderstateDTOs, no_appliforms, id_ors);
			}

			// 2017年10月26日20:17:00住院取消状态回写(医嘱状态完成，医嘱执行状态取消)
			if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(code_entp)) {
				// 住院退费
				ipRefund(orMpPlanDTOs, orderstateDTOs, id_ors);
			}
		} else {
			if (IBdFcDictCodeConst.SD_ORPLTPSTA_LAB_CONFIRMREPORT.equals(code_status) || IBdFcDictCodeConst.SD_ORPLTPSTA_OBS_CONFIRMREPORT.equals(code_status)) {
				List<String> id_orList = getIDorList(orMpPlanDTOs);
				// 修改医嘱报告状态
				updateOrderRptStatus(id_orList);
			}
			// 修改计划状态
			UpdateStatus(orMpPlanDTOs, orderstateDTOs, code_entp);
			// 医嘱完成改报告状态
		}

	}

	/**
	 * 门诊退费
	 * 
	 * @param orMpPlanDTOs
	 * @param orderstateDTOs
	 * @param no_appliforms
	 * @param id_ors
	 * @throws BizException
	 */
	private void opRefund(OrMpPlanDTO[] orMpPlanDTOs, OrderstateDTO[] orderstateDTOs, String[] no_appliforms, List<String> id_ors) throws BizException {
		// 查询出已计费的医嘱ID
		Map<String, List<String>> map = getIdOrs(orMpPlanDTOs, ICiDictCodeConst.SD_SU_BL_ACCOUNT, id_ors);

		// 参数控制是否修改可退费标记
		FBoolean MPNR0002 = EiParamUtils.MPNR0002(); // 输液标签 药品条数显示参数
		if (FBoolean.TRUE.equals(MPNR0002)) {
			ConfirmFeeBp bp = new ConfirmFeeBp();
			bp.exec(no_appliforms, IMpEventConst.SD_FEE_UNCOMFIRM);// 门诊取消，更新医嘱为可退费状态
		}
		// 是否走第三方改状态接口退费
		FBoolean MPNR0146 = EiParamUtils.MPNR0146();
		String BLCG0002 = EiParamUtils.BLCG0002();
		if (FBoolean.TRUE.equals(MPNR0146) && IBlDictCodeConst.PARAM_VALUE_EXECACCOUNT.equals(BLCG0002)) {
			Set<String> ident = map.keySet();
			if (ident != null && ident.size() > 0) {
				IBlOutCmdService bloutService = ServiceFinder.find(IBlOutCmdService.class);
				// 判断是否需结算
				IBlCgValidateService setService = ServiceFinder.find(IBlCgValidateService.class);
				for (String id_ent : ident) {
					List<String> ordList = map.get(id_ent);
					Map<String, FBoolean> isSettled = setService.orHasSettled(ordList.toArray(new String[ordList.size()]));
					// 过滤掉已经结算的
					List<String> rtnList = filterSettled(ordList, isSettled);
					if (rtnList.size() > 0) {
						// 预交金模式未结算的直接退费
						bloutService.refundForOpIdOrs(id_ent, infoMap.get(orderstateDTOs[0].getCode_emp()), rtnList.toArray(new String[rtnList.size()]));
					}
				}
			}
		}
		OrPlanDTO[] orPlans = createOrPlanDTO(orMpPlanDTOs, infoMap, orderstateDTOs[0], ExecuteStatusEnum.CANCEL, id_ors);
		IMporInternalService service = ServiceFinder.find(IMporInternalService.class);
		service.cancelByOtherSys(orPlans);
	}

	/**
	 * 过滤掉已经结算的医嘱
	 * 
	 * @param ordList
	 * @param isSettled
	 * @return
	 */
	private List<String> filterSettled(List<String> ordList, Map<String, FBoolean> isSettled) {
		List<String> rtnList = new ArrayList<String>();
		for (String idor : ordList) {
			if (isSettled.containsKey(idor)) {
				if (FBoolean.TRUE.equals(isSettled.get(idor))) {
					continue;
				}
				rtnList.add(idor);
			}
		}

		return rtnList;
	}
	/**
	 * 获取医嘱id集合
	 * 
	 * @param orMpPlanDTOs
	 * @param sdSuBlAccount
	 * @return
	 * @throws DAException
	 */
	private Map<String, List<String>> getIdOrs(OrMpPlanDTO[] orPlanDTOs, String sd_su_bl, List<String> id_sampors) throws DAException {
		Map<String, List<String>> map = new HashMap<String, List<String>>();

		// 获取id_or的集合
		List<String> id_orList = new ArrayList<String>();
		for (OrMpPlanDTO mpPlanDTO : orPlanDTOs) {
			if (id_orList.contains(mpPlanDTO.getId_or())) {
				continue;
			}
			id_orList.add(mpPlanDTO.getId_or());
		}

		// 拼上试管费采血费
		if (id_sampors != null && id_sampors.size() > 0) {
			id_orList.addAll(id_sampors);
		}
		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		List<CiOrderDO> orderDOs = (List<CiOrderDO>) daf.findByPKs(CiOrderDO.class, id_orList.toArray(new String[id_orList.size()]), new String[] { CiOrderDO.ID_OR, CiOrderDO.ID_EN, CiOrderDO.SD_SU_BL });

		if (orderDOs != null && orderDOs.size() > 0) {
			for (CiOrderDO ord : orderDOs) {
				if (sd_su_bl.equals(ord.getSd_su_bl())) {
					if (map.containsKey(ord.getId_en())) {
						map.get(ord.getId_en()).add(ord.getId_or());
					} else {
						List<String> rtnList = new ArrayList<String>();
						rtnList.add(ord.getId_or());
						map.put(ord.getId_en(), rtnList);
					}
				}
			}
		}

		return map;
	}

	/**
	 * 构建更新计划状态所需参数
	 * 
	 * @param id_ors
	 * @throws DAException
	 */
	private OrPlanDTO[] createOrPlanDTO(OrMpPlanDTO[] orMpPlanDTOs, Map<String, String> infoMap, OrderstateDTO orderstateDTO, Integer eu_su, List<String> id_ors) throws DAException {

		List<OrMpPlanDTO> plList = new ArrayList<OrMpPlanDTO>();
		plList.addAll(Arrays.asList(orMpPlanDTOs));
		if (id_ors != null && id_ors.size() > 0) {

			QueryLabFeeQry sql = new QueryLabFeeQry(id_ors.toArray(new String[0]));
			@SuppressWarnings("unchecked")
			List<OrMpPlanDTO> orPlanDOs = (List<OrMpPlanDTO>) new DAFacade().execQuery(sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(OrMpPlanDTO.class));
			plList.addAll(orPlanDOs);
		}

		List<OrPlanDTO> orPlanDTOs = new ArrayList<OrPlanDTO>();
		for (OrMpPlanDTO orMpPlanDTO : plList) {
			OrPlanDTO planDTO = new OrPlanDTO();
			planDTO.setId_or(orMpPlanDTO.getId_or());
			planDTO.setDt_mp_plan(orMpPlanDTO.getDt_mp_plan());
			planDTO.setId_dep(infoMap.get(orderstateDTO.getCode_dep()));
			planDTO.setId_emp(infoMap.get(orderstateDTO.getCode_emp()));
			planDTO.setDt_exe(orderstateDTO.getDt_exe());
			planDTO.setEu_tp(eu_su);
			orPlanDTOs.add(planDTO);
		}
		return orPlanDTOs.toArray(new OrPlanDTO[orPlanDTOs.size()]);
	}

	/**
	 * 住院退费
	 * 
	 * @param orMpPlanDTOs
	 * @param orderstateDTOs
	 * @param id_ors
	 * @throws BizException
	 */
	private void ipRefund(OrMpPlanDTO[] orMpPlanDTOs, OrderstateDTO[] orderstateDTOs, List<String> id_ors) throws BizException {
		List<String> idorprList = getIdOrPrs(orMpPlanDTOs, ICiDictCodeConst.SD_SU_BL_ACCOUNT, id_ors);
		if (idorprList != null && idorprList.size() > 0) {
			// 是否走第三方改状态接口退费
			FBoolean MPNR0146 = EiParamUtils.MPNR0146();
			if (FBoolean.TRUE.equals(MPNR0146)) {
				MpRefundChargeSetDTO refundChargeSetDTO = getRefundParamset();
				ServiceFinder.find(IMpChargeService.class).mpRefundByOrpr(idorprList.toArray(new String[idorprList.size()]), refundChargeSetDTO);
			}
		}

		OrPlanDTO[] orPlans = createOrPlanDTO(orMpPlanDTOs, infoMap, orderstateDTOs[0], ExecuteStatusEnum.CANCEL, id_ors);
		IMporInternalService service = ServiceFinder.find(IMporInternalService.class);
		service.cancelByOtherSys(orPlans);
	}

	/**
	 * 住院检验计费(新)
	 * 
	 * @param orMpPlanDTOs
	 * @param sdSuBlAccount
	 * @return
	 * @throws DAException
	 */
	private List<String> getIdOrPrs(OrMpPlanDTO[] orPlanDTOs, String sd_su_bl, List<String> id_sampors) throws DAException {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		// 获取id_or的集合
		List<String> id_orList = new ArrayList<String>();
		for (OrMpPlanDTO mpPlanDTO : orPlanDTOs) {
			if (map.containsKey(mpPlanDTO.getId_or())) {
				map.get(mpPlanDTO.getId_or()).add(mpPlanDTO.getId_or_pr());
			} else {
				List<String> rtnList = new ArrayList<String>();
				rtnList.add(mpPlanDTO.getId_or_pr());
				map.put(mpPlanDTO.getId_or(), rtnList);
			}
			id_orList.add(mpPlanDTO.getId_or());
		}

		DAFacade daf = new DAFacade();
		// 拼上试管费采集费
		if (id_sampors != null && id_sampors.size() > 0) {
			id_orList.addAll(id_sampors);
			@SuppressWarnings("unchecked")
			List<MpOrPlanDO> orPlanDOs = (List<MpOrPlanDO>) daf.findByAttrValStrings(MpOrPlanDO.class, MpOrPlanDO.ID_OR, id_sampors.toArray(new String[0]), new String[] { MpOrPlanDO.ID_OR, MpOrPlanDO.ID_OR_PR });
			Map<String, List<String>> orMap = MpnrUtils.groupBaseDO(orPlanDOs.toArray(new MpOrPlanDO[0]), MpOrPlanDO.ID_OR, MpOrPlanDO.ID_OR_PR);
			map.putAll(orMap);
		}

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
	 * 获取退记账参数
	 * 
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
	 * 查询医嘱ID集合
	 * 
	 * @param orMpPlanDTOs
	 * @return
	 */
	private List<String> getIDorList(OrMpPlanDTO[] orPlanDTOs) {
		List<String> id_orList = new ArrayList<String>();
		for (OrMpPlanDTO mpPlanDTO : orPlanDTOs) {
			if (id_orList.contains(mpPlanDTO.getId_or())) {
				continue;
			}
			id_orList.add(mpPlanDTO.getId_or());
		}
		return id_orList;
	}

	/**
	 * 修改报告状态为已出
	 * 
	 * @param id_orList
	 * @throws BizException
	 */
	private void updateOrderRptStatus(List<String> id_orList) throws BizException {
		ICiorderMDORService ciorRservice = ServiceFinder.find(ICiorderMDORService.class);
		ICiorderMDOCudService cudService = ServiceFinder.find(ICiorderMDOCudService.class);
		CiOrderDO[] orderDOs = ciorRservice.findByBIds(id_orList.toArray(new String[id_orList.size()]), FBoolean.FALSE);
		List<String> applyNoList = new ArrayList<>();
		for (CiOrderDO ciOrderDO : orderDOs) {
			ciOrderDO.setStatus(DOStatus.UPDATED);
			ciOrderDO.setId_orrsttp(ICiDictCodeConst.ID_CI_RPT_LAB_FBBG);
			ciOrderDO.setSd_orrsttp(ICiDictCodeConst.SD_CI_RPT_LAB_FBBG);
			if (!"1".equals(ciOrderDO.getSd_su_bl())) { // 未记账
				applyNoList.add(ciOrderDO.getApplyno());
			}
		}
		if (applyNoList.size() > 0) {
			throw new BizException("申请编号为" + applyNoList.toString() + "的医嘱没有记账");
		}
		cudService.save(orderDOs);
	}

	/**
	 * 判断门诊或者住院走不同的分支
	 * 
	 * @param orMpPlanDTOs
	 * @param orderstateDTOs
	 * @param code_entp2
	 * @throws BizException
	 */
	private void UpdateStatus(OrMpPlanDTO[] orMpPlanDTOs, OrderstateDTO[] orderstateDTOs, String code_entp2) throws BizException {
		// 1.构建更新状态所属参数
		OrPlanDTO[] orPlanDTOs = createOrPlanDTO(orMpPlanDTOs, infoMap, orderstateDTOs[0], ExecuteStatusEnum.EXECUTED, null);

		// 2.获取闭环中的节点编码
		String funcode = getOrpltpStaMap(orderstateDTOs).getFun_code();
		if (StringUtil.isEmptyWithTrim(funcode)) {
			return;
		}

		// 3.更新相关医嘱计划状态
		ServiceFinder.find(IMporInternalService.class).updateOrpltpByOr(orPlanDTOs, funcode, "");

	}

	/**
	 * 合管补费
	 * 
	 * @param billsupplyDTOs
	 * @throws BizException
	 */
	private void supplyBiil(BillsupplyDTO[] billsupplyDTOs) throws BizException {
		if (billsupplyDTOs == null || billsupplyDTOs.length < 1) {
			return;
		}

		Map<String, BillsupplyDTO> map = new HashMap<String, BillsupplyDTO>();
		for (BillsupplyDTO billsupply : billsupplyDTOs) {
			if(StringUtil.isEmptyWithTrim(billsupply.getCode_srv())){
				continue;
			}
			if (map.containsKey(billsupply.getCode_srv())) {
				BillsupplyDTO supply = map.get(billsupply.getCode_srv());
				FDouble quan = new FDouble(billsupply.getAttrVal("Quan_medu") + "");
				FDouble suppplyQuan = new FDouble(supply.getAttrVal("Quan_medu") + "");
				supply.setQuan_medu(suppplyQuan.add(quan));

			} else {
				map.put(billsupply.getCode_srv(), billsupply);
			}
			billsupply.setCode_ent(code_ent);
		}

		if(map.size()>0){
			// 住院通用补费
			SetSupplyBillBp billbp = new SetSupplyBillBp();
			billbp.exec(map.values().toArray(new BillsupplyDTO[map.values().size()]), code_entp);
		}

	}

}
