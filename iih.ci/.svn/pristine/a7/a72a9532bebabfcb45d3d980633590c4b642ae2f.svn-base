package iih.ci.ord.s.bp.order.sign.tl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.mysql.fabric.xmlrpc.base.Array;

import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvTpDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import iih.bl.cg.service.i.IBLCancelSettlement;
import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.ci.diag.i.ICidiagQryService;
import iih.ci.ord.cior.d.ReactExtOrsAndStopOrsDO;
import iih.ci.ord.cior.d.ValidateRtnInfoDTO;
import iih.ci.ord.ciord.d.OrSrvAgentInfoDO;
import iih.ci.ord.ciordems.d.EmsOrDrug;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.d.CijudgeSpecillDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ICiOrdCustomSysParamConst;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.i.ICiOrdQryService;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.CiApSugAgainSignValidateBP;
import iih.ci.ord.s.bp.CiOrdersSaveInvalidateBP;
import iih.ci.ord.s.bp.UseBtOrNumMarginBuValidateBP;
import iih.ci.ord.s.bp.order.sign.CiOrderSignStep1aBP;
import iih.ci.ord.s.bp.validate.OrDoctorCheckValidateBP;
import iih.ci.ord.s.bp.validate.OrMutexValidateBP;
import iih.ci.ord.s.bp.validate.PathgySampValidateBP;
import iih.ci.ord.s.bp.validate.skintest.IpSkinTestOrSignBP;
import iih.ci.ord.s.bp.validate.skintest.OpSkinTestOrSignBP;
import iih.ci.ord.s.bp.validate.tl.OrSrvDoctorRtValidateBP;
import iih.ci.ord.specanti.d.SpeConsRstType;
import iih.ci.ord.specanti.d.SpecAntiConsDO;
import iih.ci.ord.specanti.d.SpecOrderAntiDrugAppDTO;
import iih.ci.ord.specanti.d.SpecOrderAntiDrugDTO;
import iih.ci.ord.specanti.i.ISpecantOrderService;
import iih.ci.ord.specanti.i.ISpecanticonsMDORService;
import iih.en.pv.dto.d.Ent4BannerDTO;
import iih.en.pv.entdi.d.EntDiDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/*
 * 临床医嘱的签署操作BP
 */
public class CiOrderSignBP {

	// 诊断服务接口
	private ICidiagQryService icidiagQryService;

	public CiOrderSignBP() {
		icidiagQryService = (ICidiagQryService) ServiceFinder.find(ICidiagQryService.class);
	}

	/**
	 * 临床医嘱的签署（Step0）
	 * 
	 * 阶段0 返回互斥医嘱及相关停止医嘱数据信息(数据类型：ReactExOrsAndStopOrsDO key="willstopors"） 阶段#
	 * 阶段99 为校验检查通过 返回签署成功的医嘱及互斥停止的医嘱信息（数据类型：FArrayList<CiOrderDO> key="ciors"）
	 * 
	 * @param id_ors
	 * @param fgUseEr
	 *            急诊标识
	 * @return
	 * @throws BizException
	 */
	public ValidateRtnInfoDTO exec(String[] id_ors, CiEnContextDTO ctx, boolean fgUseEr, OrderOperateDTO arg)
			throws BizException {

		String Code_entp = ctx.getCode_entp();

		ValidateRtnInfoDTO rstDTO = new ValidateRtnInfoDTO();

		// 有效性校验
		if (CiOrdUtils.isEmpty(id_ors)) {
			return null;
		}

		// 获得医嘱聚集数据集合
		CiorderAggDO[] aggors = CiOrdAppUtils.getOrAggQryService().findByIds(id_ors, FBoolean.FALSE);
		if (aggors == null || aggors.length == 0) {
			FMap2 scenedatum = new FMap2();
			scenedatum.put("checkResult", "医嘱信息已经发生变化，请刷新列表！");
			rstDTO.setScenedatum(scenedatum);
			return rstDTO;
		}
		CiOrderDO[] ciors = getCiOrderDOs(aggors);

		// *************************************************************//
		/**
		 * 0127291: 出院诊断判断 郑州骨伤科医院需求 liyuelong-2018-07-25
		 */
		checkDiagBeforeOutHos(ctx, ciors);
		//校验医嘱是否存在错误信息
		validateErrorInfo( ctx, ciors);
		// *************************************************************//
		// 医嘱保存校验 其内部逻辑待完善
		CiOrdersSaveInvalidateBP validate4save = new CiOrdersSaveInvalidateBP();
		validate4save.exec(aggors);

		// 如果医嘱是医保类医嘱或临床路径待判断的医嘱，判断医生是否已经判断过。如果存在医生未判断，则将数据传送到前台，让医生判断
		boolean isPreopImport = arg.getExtension() != null && arg.getExtension().containsKey("preImportAutoSign");
		if (!isPreopImport) {
		OrDoctorCheckValidateBP docvalidate = new OrDoctorCheckValidateBP();
		FArrayList willCheckIdOrs = docvalidate.exec(aggors);
		if (!CiOrdUtils.isEmpty(willCheckIdOrs)) {
			ValidateRtnInfoDTO dto = new ValidateRtnInfoDTO();
			FMap2 scene = new FMap2();
			scene.put("willCheckIdOrs", willCheckIdOrs);
			dto.setScenedatum(scene);
			return dto;
		    }		    
		}

		// 用血医嘱可用血余量的校验
		UseBtOrNumMarginBuValidateBP usebt = new UseBtOrNumMarginBuValidateBP();
		String strRst_ub = usebt.exe(aggors);
		if (!CiOrdUtils.isEmpty(strRst_ub)) {
			FMap2 scenedatum = new FMap2();
			scenedatum.put("checkResult", strRst_ub);
			rstDTO.setScenedatum(scenedatum);
			return rstDTO;
		}

		// 病理标本项目非空检查
		PathgySampValidateBP pathgysamptestbp = new PathgySampValidateBP();
		String strRst_pathgy = pathgysamptestbp.exec(aggors);
		if (!CiOrdUtils.isEmpty(strRst_ub)) {
			FMap2 scenedatum = new FMap2();
			scenedatum.put("checkResult", strRst_pathgy);
			rstDTO.setScenedatum(scenedatum);
			return rstDTO;
		}

		// 执行科室校验逻辑 待完成
		// ExDeptValidateBP bpdept=new ExDeptValidateBP();
		// bpdept.exec();

		// 药品库存检查 待完成
		// MmInvValidateBP bpinv=new MmInvValidateBP();
		// bpinv.exec();

		if (!fgUseEr) {
			// 医嘱服务开立权限判断逻辑
			FMap2 orsrvrtchk = orSrvRtCtlChkHandle(aggors);
			if (orsrvrtchk != null && orsrvrtchk.size() > 0) {
				ValidateRtnInfoDTO dto = new ValidateRtnInfoDTO();
				dto.setScenedatum(orsrvrtchk);
				return dto;
			}
		}

		if (ParamsetQryUtil.getParaString(ctx.getId_org(),
				ICiOrdCustomSysParamConst.LL_PARAM_IS_OPEN_SPECIAL_ANTIBACTERIAL_CONS) == "true") {
			// 特殊级抗生素（抗菌药）签署验证
			ValidateRtnInfoDTO specdto = verifySignSpecAntiDrugsInfo(ctx, ciors);// specAntiConsSignValidate(ciors);
			if (specdto != null && specdto.getScenedatum().get("validateMessage") != null) {
				return specdto;
			}
		}
		CiApSugAgainSignValidateBP sugValidateBp = new CiApSugAgainSignValidateBP();
		rstDTO = sugValidateBp.exec(ciors);
		// 存在错误信息,二次手术未审核通过
		if (rstDTO != null && rstDTO.getScenedatum().containsKey("ApOpAgainErrroInfo")) {
			return rstDTO;
		}
		if ("1".equals(CiOrdUtils.GetDefaultSkinModel(ctx.getId_org()))) {
			//TODO 增加住院皮试签署生成逻辑，调用住院签署
			// 皮试逻辑保存校验
			IpSkinTestOrSignBP skintestbp = new IpSkinTestOrSignBP();
			FMap2 skinTestRstMap = skintestbp.exec(aggors, arg);
			FMap2 rstMap2 = new FMap2();
			if (skinTestRstMap != null && skinTestRstMap.containsKey("StopSignOrders")) {
				List<CiOrderDO> stopSignIdors = (List<CiOrderDO>) skinTestRstMap.get("StopSignOrders");
				List<CiorderAggDO> aggList = new ArrayList<CiorderAggDO>();
				List<CiOrderDO> orList = new ArrayList<CiOrderDO>();
				for (int i = aggors.length - 1; i >= 0; i--) {
					if (!stopSignIdors.contains(aggors[i].getParentDO())) {
						aggList.add(aggors[i]);
						orList.add(aggors[i].getParentDO());
					}
				}
				if (aggList.size() == 0) {
					rstDTO = new ValidateRtnInfoDTO();
					// 返回前台
					rstMap2.put("Fail", FBoolean.FALSE);
					rstDTO.setRtnvalue(rstMap2);
					return rstDTO;
				}
				aggors = aggList.toArray(new CiorderAggDO[0]);
				ciors = orList.toArray(new CiOrderDO[0]);
			} else if (skinTestRstMap != null && skintestbp.isNeedToFront()) {
				rstDTO = new ValidateRtnInfoDTO();
				// 返回前台
				rstMap2.put("Fail", FBoolean.FALSE);
				rstMap2.put("Extention", skinTestRstMap);
				rstDTO.setRtnvalue(rstMap2);
				return rstDTO;
			}
		}

		// 进行互斥检查校验 仅对住院流程起作用
		FDateTime dt_cur = CiOrdAppUtils.getServerDateTime();
		FArrayList fa = new FArrayList();
		fa.add(dt_cur);
		// 被排斥医嘱的停止时间应为全排医嘱的开立时间
		OrMutexValidateBP bp = new OrMutexValidateBP();
		ReactExtOrsAndStopOrsDO willstopors = bp.exec(aggors, fa);
		dt_cur = (FDateTime) fa.get(0);
		FArrayList checkPatInfoSrvs = new FArrayList();
		// 住院不进行毒麻信息的核对,其他就诊类型进行毒麻药患者信息的核对
		//if (!ctx.getCode_entp().equals(IEnDictCodeConst.SD_ENTP_INPATIENT)) {
			// 药品毒麻信息审核
			checkPatInfoSrvs = srvPoisInfoCheck(aggors);
		//}
		// 特殊病判断
		String specilInfo = judgeSpecillFlag(aggors, ctx);
		// 有要停止的医嘱时的处理逻辑setStopords
		if ((!CiOrdUtils.isEmpty(willstopors) && !CiOrdUtils.isEmpty(willstopors.getStopords()))
				|| checkPatInfoSrvs.size() > 0 || !CiOrdUtils.isEmpty(specilInfo)) {
			// 插入 用户干预点 //用户确认后继续
			ValidateRtnInfoDTO dto = new ValidateRtnInfoDTO();
			orReactStopOrPromptRtnHandle(dto, ciors, willstopors, dt_cur);
			if (checkPatInfoSrvs.size() > 0) {
				dto.getScenedatum().put("checkPatInfoSrvs", checkPatInfoSrvs);
			}
			if (!CiOrdUtils.isEmpty(specilInfo)) {
				dto.getScenedatum().put("specilDrugs", specilInfo + "是特殊病药品，未录入其对应特殊病的诊断，是否录入?");
			}
			return dto;
		}

		// TODO 签署逻辑需要调整，将校验调整与处理分开，最终调用同一个签署方法
		// 本次就诊为医保就诊时，判断是否存在保外诊断，如果存在保外诊断更新医嘱中的保外诊断属性
		// 铜陵 没有保外诊断，和医保细规则校验，去掉重复开药和保外诊断处理逻辑
		/*
		 * if(CiOrdUtils.isHpUsing(ciEnContextDTO)){
		 * 
		 * List<String> idSrvList = new ArrayList<String>(); for(CiorderAggDO
		 * ciorderAgg : aggors){ CiOrderDO ciOrder = ciorderAgg.getParentDO();
		 * if(ICiDictCodeConst.SD_SU_OPEN.equals( ciOrder.getSd_su_or())){
		 * 
		 * String sdSrvtp = ciOrder.getSd_srvtp();
		 * 
		 * // 药品，非溶媒 时校验是否重复开药
		 * if(sdSrvtp.startsWith(IBdSrvTpDictCodeConst.SD_SRVTP_DRUG) &&
		 * !IBdSrvTpDictCodeConst.SD_SRVTP_WESTDRUG_DSY.equals(sdSrvtp)){
		 * 
		 * OrdSrvDO[] OrdSrvs = ciorderAgg.getOrdSrvDO(); for(OrdSrvDO ordSrv :
		 * OrdSrvs){ if(idSrvList.contains(ordSrv.getId_srv())){ throw new
		 * BizRuntimeException("医保患者签署处置时存在重复药品["+ordSrv.getName()+"]！"); } //
		 * 医保只需要 非自费物品 if(ordSrv.getFg_mm() == FBoolean.TRUE &&
		 * ordSrv.getFg_selfpay() != FBoolean.TRUE){
		 * idSrvList.add(ordSrv.getId_srv()); } } } } }
		 * 
		 * // 查询保外诊断 CiDiagItemDO[] ciDiagItems =
		 * icidiagQryService.getHpjudgetpCiDiagItems(ciEnContextDTO.getId_en());
		 * 
		 * if (ciDiagItems != null && ciDiagItems.length > 0) {
		 * 
		 * CiEnContextUtil.SetHpCiDiagItem(ciEnContextDTO, ciDiagItems); for
		 * (CiOrderDO ciOrderDO : ciors) {
		 * 
		 * ciOrderDO.setEu_hpindicjudge(HpIndicJudgeEnum.NONEEDJUDGE);//
		 * 医保适应症判断标识枚举
		 * ciOrderDO.setBhpjudgerst(ciEnContextDTO.getBhpjudgerst()); //
		 * 基本医保判断结果数据信息
		 * ciOrderDO.setDes_bhpjudgerst(ciEnContextDTO.getDes_bhpjudgerst()); //
		 * 基本医保判断结果数据信息描述，保外诊断id串 }
		 * 
		 * CiOrderUpdateHpCiDiBP ciOrderUpdateHpCiDiBP = new
		 * CiOrderUpdateHpCiDiBP(ciEnContextDTO);
		 * ciOrderUpdateHpCiDiBP.execUpdateOrdSrvs(id_ors); } }
		 */
		// 临床医嘱的签署（Step1）
		// 更新医嘱状态、被排斥医嘱停止、创建临床事件 门诊创建会话期间、门诊处方分方
		CiOrderSignStep1aBP bp1a = new CiOrderSignStep1aBP();
		return bp1a.exec(ciors, willstopors, dt_cur,ctx,arg);
	}
	/**
	 * 简易签署
	 * @param id_ors
	 * @param ctx
	 * @param fgUseEr
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public ValidateRtnInfoDTO execSimple(String[] id_ors, CiEnContextDTO ctx, boolean fgUseEr, OrderOperateDTO arg)
			throws BizException {
		if (CiOrdUtils.isEmpty(id_ors)) {
			return null;
		}
		CiorderAggDO[] aggors = CiOrdAppUtils.getOrAggQryService().findByIds(id_ors, FBoolean.FALSE);
		CiOrderDO[] ciors = getCiOrderDOs(aggors);
		FDateTime dt_cur = CiOrdAppUtils.getServerDateTime();
		FArrayList fa = new FArrayList();
		fa.add(dt_cur);
		dt_cur = (FDateTime) fa.get(0);
		CiOrderSignStep1aBP bp1a = new CiOrderSignStep1aBP();
		return bp1a.exec(ciors, new ReactExtOrsAndStopOrsDO(), dt_cur,ctx,arg);
	}
	/**
	 * 校验医嘱是否存在错误信息
	 * @param ctx
	 * @param szOrders
	 * @return
	 * @throws BizException
	 */
	public void validateErrorInfo(CiEnContextDTO ctx, CiOrderDO[] szOrders)
			throws BizException {
		StringBuilder sb=new StringBuilder();
		for (CiOrderDO ciOrderDO : szOrders) {
			if(ciOrderDO.getError_level()!=null&&"E".equals(ciOrderDO.getError_level())) {
				sb.append(ciOrderDO.getName_or()+", ");
			}			
		}
		
		if(sb.length()>0) {
			throw new BizException(sb.toString()+"存在错误信息，请修正后再签署！");
		}
	}
	/**
	 * 特抗药签署校验逻辑
	 * 
	 * @param ctx
	 * @param szOrders
	 * @return
	 * @throws BizException
	 */
	protected ValidateRtnInfoDTO verifySignSpecAntiDrugsInfo(CiEnContextDTO ctx, CiOrderDO[] szOrders)
			throws BizException {
		// 有效性判断
		if (szOrders == null || szOrders.length == 0)
			return null;

		// 返回审核结果
		ValidateRtnInfoDTO rstInfo = new ValidateRtnInfoDTO();
		StringBuilder sbValidateMessage = new StringBuilder();

		// 用户同意继续签署，则删除未审核和审核未通过的抗菌药医嘱idor
		List<String> lsRemoveIdor = new ArrayList<String>();

		// 未申请会诊提示信息
		StringBuilder sbUnappliedMsg = new StringBuilder();

		// 筛选出医嘱集合中的西药医嘱，并获取西药医嘱的ID集合
		List<String> wdOrderList = new ArrayList<String>();
		for (int i = 0; i < szOrders.length; i++) {
			if (szOrders[i].getSd_srvtp().startsWith(IBdSrvTpDictCodeConst.SD_SRVTP_WESTDRUG)) {
				wdOrderList.add(szOrders[i].getId_or());
			}
		}
		// 如果西药医嘱Id 集合为空，则不需要特抗药的审核校验
		if (wdOrderList.size() == 0)
			return null;

		// 获取当前签署的医嘱中的特抗药信息集合
		SpecOrderAntiDrugDTO[] szOrderAntiDrugInfos = ServiceFinder.find(ISpecantOrderService.class)
				.getOrderAntiDrugsInfo(wdOrderList.toArray(new String[wdOrderList.size()]));

		// 获取该患者就诊下所有的特抗药申请记录结果
		SpecOrderAntiDrugAppDTO[] szSpecOrderAntiDrugAppInfo = ServiceFinder.find(ISpecantOrderService.class)
				.getOrderAntiDrugAppsInfo(ctx.getId_en());
		Map<String, SpecOrderAntiDrugAppDTO> tmpMmInAntiAppMap = new HashMap<String, SpecOrderAntiDrugAppDTO>();
		if (null != szSpecOrderAntiDrugAppInfo && szSpecOrderAntiDrugAppInfo.length > 0) {
			for (SpecOrderAntiDrugAppDTO item : szSpecOrderAntiDrugAppInfo) {
				if (tmpMmInAntiAppMap.containsKey(item.getId_srv())) {
					SpecOrderAntiDrugAppDTO tmpItem = tmpMmInAntiAppMap.get(item.getId_srv());
					// 如果 医务科 审过了
					if (!StringUtil.isEmpty(item.getSd_approve_meddep())) {
						tmpMmInAntiAppMap.put(item.getId_srv(), item);
					}
				} else {
					tmpMmInAntiAppMap.put(item.getId_srv(), item);
				}

			}
		}

		// 当前签署的医嘱中包含的特抗药信息有效性判断
		if (null == szOrderAntiDrugInfos || szOrderAntiDrugInfos.length == 0) {
			return null;
		}
		// 循环遍历当前医嘱中的特抗药集合，进行验证

		// 没有进行抗菌药申请的医嘱信息集合
		StringBuilder sbUnapplied_order_msg = new StringBuilder();
		// 专家未审核message
		StringBuilder sbApprove_emp_msg = new StringBuilder();
		// 专家审核未通过message
		StringBuilder sbApprove_emp_fail_msg = new StringBuilder();
		// 医务室未审核message
		StringBuilder sbApprove_meddep_msg = new StringBuilder();
		// 医务室审核未通过message
		StringBuilder sbApprove_meddep_fail_msg = new StringBuilder();

		for (SpecOrderAntiDrugDTO item : szOrderAntiDrugInfos) {

			// 是否特抗药已经申请过
			if (!tmpMmInAntiAppMap.containsKey(item.getId_srv())) {
				sbUnapplied_order_msg.append("[" + item.getName_mm() + "-医嘱编码:" + item.getCode_or() + "]");
			} else {
				SpecOrderAntiDrugAppDTO appInfo = tmpMmInAntiAppMap.get(item.getId_srv());
				// 首先判断 【专家】还没有审核，则 首要限制条件校验不通过
				if (StringUtil.isEmpty(appInfo.getSd_approve_emp())) {

					sbApprove_emp_msg.append("[" + item.getName_mm() + "-医嘱编码:" + item.getCode_or() + "]");
					lsRemoveIdor.add(item.getId_or());
				}
				// 如果 专家 已经审核，并且拒绝
				else if (!appInfo.getSd_approve_emp().equals(SpeConsRstType.SPECONSD_AGREE)) {

					// 审核未通过专家意见设置为content_or
					String advice = (StringUtil.isEmpty(appInfo.getAdvice()) ? "" : appInfo.getAdvice());
					sbApprove_emp_fail_msg
							.append("[" + item.getName_mm() + "，医嘱编码:" + item.getCode_or() + "，专家意见:" + advice + "]");

					lsRemoveIdor.add(item.getId_or());
				}
				// 如果【医务处】没有审核
				else if (StringUtil.isEmpty(appInfo.getSd_approve_meddep())) {

					sbApprove_meddep_msg.append("[" + item.getName_mm() + "-医嘱编码:" + item.getCode_or() + "]");
					lsRemoveIdor.add(item.getId_or());
				}
				// 如果【医务处】没有审核通过
				else if (!appInfo.getSd_approve_meddep().equals(SpeConsRstType.SPECONSD_AGREE)) {

					sbApprove_meddep_fail_msg.append("[" + item.getName_mm() + "，医嘱编码:" + item.getCode_or() + "]");
					lsRemoveIdor.add(item.getId_or());
				}

			}
		}

		if (sbUnappliedMsg.length() > 0) {
			sbUnappliedMsg.append(sbUnapplied_order_msg + "\r\n未申请会诊！");
		}
		if (sbApprove_emp_msg.length() > 0) {

			sbApprove_emp_msg.append("专家未审核\r\n");
		}
		if (sbApprove_emp_fail_msg.length() > 0) {

			sbApprove_emp_fail_msg.append("专家审核未通过\r\n");
		}
		if (sbApprove_meddep_msg.length() > 0) {

			sbApprove_meddep_msg.append("医务室未审核\r\n");
		}
		if (sbApprove_meddep_fail_msg.length() > 0) {

			sbApprove_meddep_fail_msg.append("医务室审核未通过\r\n");
		}
		// 拼接验证信息

		sbValidateMessage.append("签署失败！特殊级抗菌药\r\n").append(sbUnappliedMsg).append(sbApprove_emp_msg)
				.append(sbApprove_emp_fail_msg).append(sbApprove_meddep_msg).append(sbApprove_meddep_fail_msg)
				.append("是否继续签署？");

		// 返回的信息
		rstInfo.setScenedatum(new FMap2());
		if (lsRemoveIdor.isEmpty()) {
			rstInfo.getScenedatum().put("validateMessage", null);
		} else {
			rstInfo.getScenedatum().put("validateMessage", sbValidateMessage.toString());
			FArrayList tmpRemoveIdors = new FArrayList();
			tmpRemoveIdors.addAll(lsRemoveIdor);
			rstInfo.getScenedatum().put("removeidor", tmpRemoveIdors);
		}
		return rstInfo;
	}

	/**
	 * 特殊级抗菌药签署验证 签署条件： 1、西成药 2、特级抗生素 3、专家和医务都审核 4、专家和医务审核都通过
	 * 
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	private ValidateRtnInfoDTO specAntiConsSignValidate(CiOrderDO[] szOrderInfo) throws BizException {
		if (szOrderInfo == null || szOrderInfo.length == 0)
			return null;
		// 返回审核结果
		ValidateRtnInfoDTO rstInfo = new ValidateRtnInfoDTO();
		StringBuilder sbValidateMessage = new StringBuilder();
		// 西成药idors
		FArrayList xcyOrds = new FArrayList();
		for (int i = 0; i < szOrderInfo.length; i++) {
			if (szOrderInfo[i].getSd_srvtp().startsWith(IBdSrvTpDictCodeConst.SD_SRVTP_WESTDRUG)) {
				xcyOrds.add(szOrderInfo[i].getId_or());
			}
		}
		// 特殊级抗菌药【医嘱】集合
		CiOrderDO[] szOrderInAntiDrugInfos = CiOrdUtils
				.getBdSrvDrugByIdors((String[]) xcyOrds.toArray(new String[xcyOrds.size()]));

		// 未申请会诊提示信息
		StringBuilder sbUnappliedMsg = new StringBuilder();
		if (szOrderInAntiDrugInfos != null && szOrderInAntiDrugInfos.length > 0) {
			// 用户同意继续签署，则删除未审核和审核未通过的抗菌药医嘱idor
			List<String> lsRemoveIdor = new ArrayList<String>();

			// id_or,ciorderdo
			Map<String, CiOrderDO> antiOrderMap = new HashMap<String, CiOrderDO>();
			if (szOrderInAntiDrugInfos != null && szOrderInAntiDrugInfos.length > 0) {
				for (int i = 0; i < szOrderInAntiDrugInfos.length; i++) {
					antiOrderMap.put(szOrderInAntiDrugInfos[i].getId_or(), szOrderInAntiDrugInfos[i]);
				}
			}

			// 根据医嘱id查特级抗菌药表，如果没有记录则表明没有发出会诊申请(这种判断是错误的)
			SpecAntiConsDO[] szSpecAntiAppInfo = ServiceFinder.find(ISpecanticonsMDORService.class)
					.findByAttrValStrings(SpecAntiConsDO.ID_OR,
							(String[]) antiOrderMap.keySet().toArray(new String[antiOrderMap.size()]));
			// 没有进行抗菌药申请的医嘱信息集合
			StringBuilder sbUnappliedOrderMsg = new StringBuilder();
			if (szSpecAntiAppInfo == null || szSpecAntiAppInfo.length == 0) {
				// 所有包含特殊级抗菌药的医嘱id
				for (int i = 0; i < szOrderInAntiDrugInfos.length; i++) {
					sbUnappliedOrderMsg.append("[" + szOrderInAntiDrugInfos[i].getName_or() + "-医嘱编码:"
							+ szOrderInAntiDrugInfos[i].getCode_or() + "]");
				}
				lsRemoveIdor.addAll(antiOrderMap.keySet());
				sbUnappliedMsg.append("签署失败！特殊级抗菌药\r\n").append(sbUnappliedOrderMsg).append("\r\n未申请会诊！");
				sbValidateMessage.append(sbUnappliedMsg.append("\r\n是否继续签署？"));
			} else {
				// 获取已申请的特抗药
				List<String> lsAppliedIdors = new ArrayList<String>();
				for (int i = 0; i < szSpecAntiAppInfo.length; i++) {
					lsAppliedIdors.add(szSpecAntiAppInfo[i].getId_or());
				}
				// 得到未申请的特抗药
				Map<String, CiOrderDO> unAppliedOrderMap = new HashMap<String, CiOrderDO>();

				// 获取没有特抗药申请的医嘱 ID 信息集合
				unAppliedOrderMap.putAll(antiOrderMap);
				unAppliedOrderMap.keySet().removeAll(lsAppliedIdors);

				lsRemoveIdor.addAll(unAppliedOrderMap.keySet());

				// {{ 拼接没有特抗药申请的医嘱客户端提示信息字符串
				if (unAppliedOrderMap.size() > 0) {
					for (CiOrderDO orderItem : unAppliedOrderMap.values()) {
						sbUnappliedOrderMsg
								.append("[" + orderItem.getName_or() + "-医嘱编码:" + orderItem.getCode_or() + "]");
					}
					sbUnappliedMsg.append(sbUnappliedOrderMsg + "\r\n未申请会诊！");
				}
				// }}

				// 专家未审核message
				StringBuilder approve_emp_msg = new StringBuilder();
				// 专家审核未通过message
				StringBuilder approve_emp_fail_msg = new StringBuilder();
				// 医务室未审核message
				StringBuilder approve_meddep_msg = new StringBuilder();
				// 医务室审核未通过message
				StringBuilder approve_meddep_fail_msg = new StringBuilder();

				// 遍历当前医嘱在特抗药申请单列表的信息，并作出响应的客户端提示信息
				for (int i = 0; i < szSpecAntiAppInfo.length; i++) {

					// 获取 特抗药 申请单对象
					SpecAntiConsDO specAntiConsInfo = szSpecAntiAppInfo[i];

					// 获取特抗药医嘱对象
					CiOrderDO specAntiDrugOrder = (CiOrderDO) antiOrderMap.get(specAntiConsInfo.getId_or());

					// 首先判断 【专家】还没有审核，则 首要限制条件校验不通过
					if (StringUtil.isEmpty(specAntiConsInfo.getSd_approve_emp())) {

						approve_emp_msg.append(
								"[" + specAntiDrugOrder.getName_or() + "-医嘱编码:" + specAntiDrugOrder.getCode_or() + "]");
						lsRemoveIdor.add(specAntiConsInfo.getId_or());
					}

					// 如果 专家 已经审核，并且拒绝
					else if (!specAntiConsInfo.getSd_approve_emp().equals(SpeConsRstType.SPECONSD_AGREE)) {

						// 审核未通过专家意见设置为content_or
						specAntiDrugOrder.setContent_or(
								(StringUtil.isEmpty(specAntiConsInfo.getAdvice()) ? "" : specAntiConsInfo.getAdvice()));
						approve_emp_fail_msg.append("[" + specAntiDrugOrder.getName_or() + "，医嘱编码:"
								+ specAntiDrugOrder.getCode_or() + "，专家意见:" + specAntiDrugOrder.getContent_or() + "]");

						lsRemoveIdor.add(specAntiConsInfo.getId_or());
					}
					// 如果【医务处】没有审核
					else if (StringUtil.isEmpty(specAntiConsInfo.getSd_approve_meddep())) {

						approve_meddep_msg.append(
								"[" + specAntiDrugOrder.getName_or() + "-医嘱编码:" + specAntiDrugOrder.getCode_or() + "]");
						lsRemoveIdor.add(specAntiConsInfo.getId_or());
					}
					// 如果【医务处】没有审核通过
					else if (!specAntiConsInfo.getSd_approve_meddep().equals(SpeConsRstType.SPECONSD_AGREE)) {

						approve_meddep_fail_msg.append(
								"[" + specAntiDrugOrder.getName_or() + "，医嘱编码:" + specAntiDrugOrder.getCode_or() + "]");
						lsRemoveIdor.add(specAntiConsInfo.getId_or());
					}

				}

				if (approve_emp_msg.length() > 0) {

					approve_emp_msg.append("专家未审核\r\n");
				}
				if (approve_emp_fail_msg.length() > 0) {

					approve_emp_fail_msg.append("专家审核未通过\r\n");
				}
				if (approve_meddep_msg.length() > 0) {

					approve_meddep_msg.append("医务室未审核\r\n");
				}
				if (approve_meddep_fail_msg.length() > 0) {

					approve_meddep_fail_msg.append("医务室审核未通过\r\n");
				}
				// 拼接验证信息

				sbValidateMessage.append("签署失败！特殊级抗菌药\r\n").append(sbUnappliedMsg).append(approve_emp_msg)
						.append(approve_emp_fail_msg).append(approve_meddep_msg).append(approve_meddep_fail_msg)
						.append("是否继续签署？");

			}

			// 返回的信息
			rstInfo.setScenedatum(new FMap2());
			if (lsRemoveIdor.isEmpty()) {
				rstInfo.getScenedatum().put("validateMessage", null);
			} else {
				rstInfo.getScenedatum().put("validateMessage", sbValidateMessage.toString());
				FArrayList tmpRemoveIdors = new FArrayList();
				tmpRemoveIdors.addAll(lsRemoveIdor);
				rstInfo.getScenedatum().put("removeidor", tmpRemoveIdors);
			}
			return rstInfo;
		} else {
			return null;
		}

	}

	/**
	 * 出院之前检查是否有诊疗项目
	 * 
	 * @param ciEnContextDTO
	 * @param ciors
	 * @author liyuelong-2018-07-26
	 * @throws BizException
	 */
	protected void checkDiagBeforeOutHos(CiEnContextDTO ciEnContextDTO, CiOrderDO[] ciors) throws BizException {
		for (int i = 0; i < ciors.length; i++) {
			// 当有出院时，判断是否有诊疗项目
			if (IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_LEAVEHOS.equals(ciors[i].getSd_srvtp())) {
				CidiagAggDO[] cidiagAggDo = icidiagQryService.getLastCiDiags(ciEnContextDTO.getId_en());
				if (cidiagAggDo == null || 0 == cidiagAggDo.length) {
					throw new BizRuntimeException("该患者没有有效的出院诊断，无法出院！");
				} else {
					boolean flag = true;
					for (CidiagAggDO aggdo : cidiagAggDo) {
						//出院诊断或者死亡诊断
						if (ICiDictCodeConst.SD_OUTHOSPITAL.equals(aggdo.getParentDO().getSd_ditp())||ICiDictCodeConst.SD_DIE.equals(aggdo.getParentDO().getSd_ditp())) {
							flag = false;
							break;
						}
					}
					if (flag) {
						throw new BizRuntimeException("该患者没有有效的出院诊断，无法出院！");
					}
				}
			}
		}
	}

	/**
	 * 医保签署时 提示医保信息
	 * 
	 * @param map
	 * @param Code_entp
	 * @return
	 * @throws BizException
	 */
	public ValidateRtnInfoDTO CiorderSignMedicalInsurance(FMap2 map, String Code_entp) throws BizException {
		FArrayList aggList = (FArrayList) map.get("aggors");
		CiorderAggDO[] aggors = (CiorderAggDO[]) CiOrdUtils.FArrayLiatToBaseDOArray(aggList);
		CiOrderDO[] ciors = getCiOrderDOs(aggors);

		ValidateRtnInfoDTO dto = new ValidateRtnInfoDTO();
		// 用血医嘱可用血余量的校验
		UseBtOrNumMarginBuValidateBP usebt = new UseBtOrNumMarginBuValidateBP();
		usebt.exe(aggors);

		// 执行科室校验逻辑 待完成
		// ExDeptValidateBP bpdept=new ExDeptValidateBP();
		// bpdept.exec();

		// 药品库存检查 待完成
		// MmInvValidateBP bpinv=new MmInvValidateBP();
		// bpinv.exec();

		// 医嘱服务开立权限判断逻辑
		FMap2 orsrvrtchk = orSrvRtCtlChkHandle(aggors);
		if (orsrvrtchk != null && orsrvrtchk.size() > 0) {
			dto.setScenedatum(orsrvrtchk);
			return dto;
		}

		// 进行互斥检查校验 仅对住院流程起作用
		// li_cheng 修改
		FDateTime dt_cur = CiOrdAppUtils.getServerDateTime();
		FArrayList fa = new FArrayList();
		fa.add(dt_cur);
		OrMutexValidateBP bp = new OrMutexValidateBP();
		// 被排斥医嘱的停止时间应为全排医嘱的开立时间 li_cheng 修改
		ReactExtOrsAndStopOrsDO willstopors = bp.exec(aggors, fa);
		dt_cur = (FDateTime) fa.get(0);
		// 有要停止的医嘱时的处理逻辑
		if (!CiOrdUtils.isEmpty(willstopors) && !CiOrdUtils.isEmpty(willstopors.getStopordos())) {
			// 插入 用户干预点 //用户确认后继续
			orReactStopOrPromptRtnHandle(dto, ciors, willstopors, dt_cur);
			return dto;
		}

		// 临床医嘱的签署（Step1）
		// 更新医嘱状态、被排斥医嘱停止、创建临床事件 门诊创建会话期间、门诊处方分方
		CiOrderSignStep1aBP bp1a = new CiOrderSignStep1aBP();
		return bp1a.exec(ciors, willstopors, dt_cur, Code_entp, null);
	}

	/**
	 * 获得医嘱主DO数组
	 * 
	 * @param aggors
	 * @return
	 */
	protected CiOrderDO[] getCiOrderDOs(CiorderAggDO[] aggors) {

		List<CiOrderDO> ciOrderList = new ArrayList<CiOrderDO>();
		for (int i = 0; i < aggors.length; i++) {
			CiOrderDO ciOrder = aggors[i].getParentDO();
			if (ICiDictCodeConst.SD_SU_OPEN.equals(ciOrder.getSd_su_or())) {
				ciOrderList.add(ciOrder);
			}
		}
		if (ciOrderList.size() != aggors.length) {
			throw new BizRuntimeException("数据状态发生改变，请勿重复签署！");
		}
		return ciOrderList.toArray(new CiOrderDO[ciOrderList.size()]);
	}

	/**
	 * 医嘱签署权限检查处理
	 * 
	 * @param aggors
	 * @throws BizException
	 */
	protected FMap2 orSrvRtCtlChkHandle(CiorderAggDO[] aggors) throws BizException {
		OrSrvDoctorRtValidateBP bp = new OrSrvDoctorRtValidateBP();
		return bp.exec(aggors, false);

	}

	/**
	 * 
	 * @param aggors
	 * @return
	 */
	protected FArrayList srvPoisInfoCheck(CiorderAggDO[] aggors) {
		FArrayList idorsrvs = new FArrayList();
		FArrayList ordsrvPois = new FArrayList();
		FMap orsrvMap = new FMap();
		FBoolean poisinfocheck = CiOrdUtils.Poisinfocheck(Context.get().getOrgId(),"10");
		if(FBoolean.FALSE.equals(poisinfocheck)){
			return ordsrvPois;
		}
		for (CiorderAggDO agg : aggors) {
			OrdSrvDO[] ordSrvdos = agg.getOrdSrvDO();
			for (OrdSrvDO srvdo : ordSrvdos) {
				idorsrvs.add(srvdo.getId_orsrv());
				orsrvMap.put(srvdo.getId_orsrv(), srvdo);
			}
		}
		try {
			OrdSrvMmDO[] srvmms = CiOrdAppUtils.getOrSrvMmQryService().findByAttrValList("Id_orsrv", idorsrvs);
			idorsrvs.clear();
			if (srvmms == null)
				return ordsrvPois;
			for (OrdSrvMmDO srvmm : srvmms) {
				if (CiOrdUtils.isEmpty(srvmm.getSd_pois()))
					continue;
				if (CiOrdUtils.isNeedCheckPatInfo(srvmm.getSd_pois()).booleanValue()) {
					idorsrvs.add(srvmm.getId_orsrv());
				}
			}
			if (idorsrvs.size() > 0) {
				OrSrvAgentInfoDO[] orsrvAgentInfoDOs = CiOrdAppUtils.getCiorsrvagentRService()
						.findByAttrValList("Id_orsrv", idorsrvs);
				if (!CiOrdUtils.isEmpty(orsrvAgentInfoDOs)) {
					for (OrSrvAgentInfoDO srvagent : orsrvAgentInfoDOs) {
						idorsrvs.remove(srvagent.getId_orsrv());
					}
				}

				if (idorsrvs.size() > 0) {
					for (Object id_orsrv : idorsrvs) {
						ordsrvPois.add(orsrvMap.get(id_orsrv.toString()));
					}
				}
			}
		} catch (BizException e) {
			e.printStackTrace();
		}
		return ordsrvPois;
	}

	/**
	 * 特殊判断，返回需要校验特殊病的服务集合
	 * 
	 * @param aggs
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	protected String judgeSpecillFlag(CiorderAggDO[] aggs, CiEnContextDTO ctx) throws BizException {

		// return "西药，中药";
		// 非医保或患者非特病返回false
		if (CiOrdUtils.isEmpty(ctx.getId_hp()) || ctx.getFg_hpspcl() == null || !ctx.getFg_hpspcl().booleanValue())
			return null;
		FArrayList idOrsrvs = new FArrayList();
		Map<String, OrdSrvDO> ordsrvMap = new HashMap<String, OrdSrvDO>();
		for (CiorderAggDO agg : aggs) {
			OrdSrvDO[] ordsrvs = agg.getOrdSrvDO();
			for (OrdSrvDO srv : ordsrvs) {
				if (srv.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG)) {
					idOrsrvs.add(srv.getId_orsrv());
					ordsrvMap.put(srv.getId_orsrv(), srv);
				}
			}
		}

		if (idOrsrvs.size() == 0)
			return null;
		OrdSrvMmDO[] srvmmdos = CiOrdAppUtils.getOrSrvMmQryService().findByAttrValList("Id_orsrv", idOrsrvs);
		List<String> idMMs = new ArrayList<String>();
		Map<String, OrdSrvMmDO> mmMap = new HashMap<String, OrdSrvMmDO>();
		if (!CiOrdUtils.isEmpty(srvmmdos)) {
			for (OrdSrvMmDO srvmm : srvmmdos) {
				if (!CiOrdUtils.isEmpty(srvmm.getId_mm())) {
					if (!idMMs.contains(srvmm.getId_mm())) {
						idMMs.add(srvmm.getId_mm());
						mmMap.put(srvmm.getId_mm(), srvmm);
					}
				}
			}
		} else {
			return null;
		}

		List<OrdSrvDO> updSpecilSrvs = new ArrayList<OrdSrvDO>();
		FArrayList2 specilDrugs = new FArrayList2();
		IBLCancelSettlement blservice = CiOrdAppUtils.getIBLCancelSettlement();
		List<CijudgeSpecillDTO> specils = blservice.JudgeSpecillFlag(ctx.getNo_hp(), ctx.getId_hp(),
				idMMs.toArray(new String[idMMs.size()]));
		if (!CiOrdUtils.isEmpty(specils) && specils.size() > 0) {
			ICiOrdQryService ciordqryservice = CiOrdAppUtils.getCiOrdQryService();
			EntDiDO[] entdis = ciordqryservice.getEntDiDOList(ctx.getId_en());
			for (CijudgeSpecillDTO specill : specils) {
				FMap2 diagmap = specill.getDiagmap();
				if (!CiOrdUtils.isEmpty(specill.getFg_mmspecill()) && specill.getFg_mmspecill().booleanValue()
						&& !CiOrdUtils.isEmpty(diagmap)) {
					if (!CiOrdUtils.isEmpty(entdis)) {
						boolean flag = true;
						for (EntDiDO entdi : entdis) {
							String code_di = entdi.getCode_didef_dis();
							if (diagmap.containsKey(code_di)) {
								flag = false;
								break;
							}
						}
						if (flag) {
							specilDrugs.add(mmMap.get(specill.getId_mm()).getName_mm());
						} else {
							OrdSrvDO srvdo = ordsrvMap.get(mmMap.get(specill.getId_mm()).getId_orsrv());
							srvdo.setFg_specill(FBoolean.TRUE);
							updSpecilSrvs.add(srvdo);
						}
					}
				}
			}
		}
		if (updSpecilSrvs.size() > 0) {
			CiOrdAppUtils.getICiorderSrvDOCudService()
					.update(updSpecilSrvs.toArray(new OrdSrvDO[updSpecilSrvs.size()]));
		}
		if (specilDrugs.size() > 0) {
			return specilDrugs.toString();
		} else {
			return null;
		}
	}

	/**
	 * 医嘱互斥停止相关医嘱执行时，设置返回值数据信息
	 * 
	 * @param dto
	 * @param ors
	 * @param willstopors
	 * @param dt_cur
	 */
	protected ValidateRtnInfoDTO orReactStopOrPromptRtnHandle(ValidateRtnInfoDTO dto, CiOrderDO[] ciors,
			ReactExtOrsAndStopOrsDO willstopors, FDateTime dt_cur) {
		dto.setPhaseno(0); // 阶段0
		FMap2 scene = new FMap2();
		scene.put("dt_cur", dt_cur);
		scene.put("ciors", CiOrdUtils.array2FArrayList(ciors));
		dto.setScenedatum(scene);
		FMap2 rtnvalue = new FMap2();
		rtnvalue.put("willstopors", willstopors);
		dto.setRtnvalue(rtnvalue);
		dto.setFg_rtnscene(FBoolean.TRUE);
		return dto;
	}
}
