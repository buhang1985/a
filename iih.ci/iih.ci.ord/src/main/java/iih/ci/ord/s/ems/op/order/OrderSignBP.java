package iih.ci.ord.s.ems.op.order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bl.cg.dto.cglogic.d.BlCgAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountRltDTO;
import iih.bl.cg.dto.cglogic.d.BlCgOpAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.OepCgModeEnum;
import iih.bl.cg.i.IBlCgAccountService;
import iih.bl.cg.service.i.IBLCancelSettlement;
import iih.bl.comm.IBlCgFuncConst;
import iih.bl.hp.cihpcheckresultdto.d.CiHpCheckFailResultEnum;
import iih.bl.hp.cihpcheckresultdto.d.CiHpCheckResultDTO;
import iih.bl.hp.dto.d.ItmChkRstDTO;
import iih.ci.core.utils.ObjectUtils;
import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.diag.i.ICidiagQryService;
import iih.ci.event.ord.utils.IOrdEventSources;
import iih.ci.mi.common.utils.MiEnContextUtil;
import iih.ci.ord.app.d.CiapplissheetAggDO;
import iih.ci.ord.cior.d.CiOrSessionDO;
import iih.ci.ord.ciord.d.OrSrvAgentInfoDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.HpIndicJudgeEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderRService;
import iih.ci.ord.ciorder.i.IOrdSrvDOCudService;
import iih.ci.ord.d.CijudgeSpecillDTO;
import iih.ci.ord.dto.d.MedicalSharingDTO;
import iih.ci.ord.dto.mergetube.d.MergeTubeRstDTO;
import iih.ci.ord.dto.mergetube.d.MergeTubeRstEnum;
import iih.ci.ord.dto.prescostdto.d.PrescriptionConstBaseDto;
import iih.ci.ord.dto.prescostdto.d.PrescriptionCostDto;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.hp.gj.HpDetailedRuleBP;
import iih.ci.ord.i.ICiOrdCustomSysParamConst;
import iih.ci.ord.i.ICiOrdQryService;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.listener.ICiEventConst;
import iih.ci.ord.pub.util.biz.CiEnContextUtil;
import iih.ci.ord.s.bp.CiOrEventsSaveBP;
import iih.ci.ord.s.bp.CiOrOpSessionInsertBP;
import iih.ci.ord.s.bp.CiOrSufInfo4ScAptApplBp;
import iih.ci.ord.s.bp.CiOrderRisInfoToScAptApplBp;
import iih.ci.ord.s.bp.CiOrderUpdateHpCiDiBP;
import iih.ci.ord.s.bp.UseBtOrNumMarginBuUpdateBP;
import iih.ci.ord.s.bp.UseBtOrNumMarginBuValidateBP;
import iih.ci.ord.s.bp.ciprn.CiprnSaveAppBtDataBP;
import iih.ci.ord.s.bp.ciprn.CiprnSaveAppBuDataBP;
import iih.ci.ord.s.bp.ciprn.CiprnSaveAppPathgyDataBP;
import iih.ci.ord.s.bp.ciprn.CiprnSaveAppRisDataBP;
import iih.ci.ord.s.bp.ems.hp.OrdHpSignInfoBP;
import iih.ci.ord.s.bp.orsms.lis.CiLisOrSmsHandlerBP;
import iih.ci.ord.s.bp.orsms.lis.mergetube.MergeTubeSendToMPBP;
import iih.ci.ord.s.bp.splitpres.CiOrPresSplitHandleBP;
import iih.ci.ord.s.bp.validate.PathgySampValidateBP;
import iih.ci.ord.s.bp.validate.SkinTestOrSignBP;
import iih.ci.ord.s.bp.validate.skintest.OpSkinTestOrSignBP;
import iih.ci.ord.s.ems.itf.bp.IOrderSignBP;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import iih.ci.ord.s.ems.meta.StringList;
import iih.ci.ord.s.ems.utils.SysParamUtils;
import iih.ci.ord.s.utils.OpSimpleOrderSignBP;
import iih.en.pv.entdi.d.EntDiDO;
import iih.sc.apt.out.i.ISc4CiCmdService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.permfw.userindividual.d.UserIndividualPropertyDO;
import xap.sys.permfw.userindividual.i.IUserindividualRService;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 医嘱签署
 * 
 * @author Young
 *
 */
public class OrderSignBP implements IOrderSignBP {
	/**
	 * 签署的拓展信息
	 */
	private FMap2 emsExtensionMap2;

	@Override
	public OrderRstDTO sign(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		emsExtensionMap2 = arg.getExtension();

		OrderRstDTO rstDTO = new OrderRstDTO();
		Context.get().setAttribute("CiEnContextDTO", ctx);
		FArrayList paramList = arg.getDocument();
		if (paramList == null || paramList.size() <= 0) {
			rstDTO.setIsSuccess(FBoolean.FALSE);
			return rstDTO;
		}

		StringList lstIdors = new StringList(paramList);

		if (lstIdors.size() == 0) {
			rstDTO.setIsSuccess(FBoolean.FALSE);
			return rstDTO;
		}

		// 获得医嘱聚集数据集合
		CiorderAggDO[] aggors = CiOrdAppUtils.getOrAggQryService().findByIds(lstIdors.asArray(), FBoolean.FALSE);
		if (CiOrdUtils.isEmpty(aggors)) {
			rstDTO.setIsSuccess(FBoolean.FALSE);
			FMap2 scene = new FMap2();
			scene.put("checkResult", "医嘱状态已经发生变化，请刷新列表！");
			rstDTO.setExtension(scene);
			OrdBizLogger.info(null, "皮试自动签署失败--状态校验");
			return rstDTO;
		}
		// 判断患者是医保，有自费诊断，是否含有医保的医嘱
		JudgeOrderSelfPayDiagBP selfpaybp = new JudgeOrderSelfPayDiagBP();
		if (FBoolean.TRUE.equals(selfpaybp.JudgeOrderSelfPayDiagBP(aggors, arg))) {
			rstDTO.setIsSuccess(FBoolean.FALSE);
			FMap2 scene = new FMap2();
			scene.put("checkResult", "医保患者有自费诊断，并且存在医保的医嘱，不允许签署！");
			rstDTO.setExtension(scene);
			OrdBizLogger.info(null, "皮试自动签署失败--医保判断");
			return rstDTO;
		}
		// 签署时医保验证自费签署
		if (emsExtensionMap2 != null && emsExtensionMap2.containsKey("MedicalSharingDTO")) {
			String id_orsrv = (String) emsExtensionMap2.get("MedicalSharingDTO");
			ValidataMedicalSharing(id_orsrv, aggors);
		}
		// 皮试医嘱保存校验
		List<CiOrderDO> id_ors_ps = new ArrayList<CiOrderDO>();
		if ("1".equals(CiOrdUtils.GetDefaultSkinModel(ctx.getId_org()))) {
			// 皮试逻辑保存校验
			OpSkinTestOrSignBP skintestbp = new OpSkinTestOrSignBP();
			FMap2 skinTestRstMap = skintestbp.exec(aggors, arg);
			FMap2 scene = new FMap2();
			rstDTO.setExtension(scene);
			if(skinTestRstMap!=null && skinTestRstMap.containsKey("ErrMsg")){
				scene.put("ErrMsg", skinTestRstMap.get("ErrMsg"));
			}
			if(skinTestRstMap!=null && skinTestRstMap.containsKey("UnCheckIdors")){
				scene.put("UnCheckIdors", skinTestRstMap.get("UnCheckIdors"));
			}
			if (skinTestRstMap != null && skinTestRstMap.containsKey("StopSignOrders")) {
				List<CiOrderDO> id_ors = (List<CiOrderDO>) skinTestRstMap.get("StopSignOrders");

				if (skinTestRstMap.containsKey("SignOrList")) {
					id_ors_ps = (List<CiOrderDO>) skinTestRstMap.get("SignOrList");
				}

				List<CiorderAggDO> aggList = new ArrayList<CiorderAggDO>();
				List<CiOrderDO> orList = new ArrayList<CiOrderDO>();
				for (int i = aggors.length - 1; i >= 0; i--) {
					if (!id_ors.contains(aggors[i].getParentDO())) {
						aggList.add(aggors[i]);
					}
				}
				if (aggList.size() == 0) {
					// 返回前台
					rstDTO.setIsSuccess(FBoolean.FALSE);
					// 添加生成的皮试医嘱
					if (id_ors_ps != null && id_ors_ps.size() > 0) {
						// CiOrderDO[] ciorders =(CiOrderDO[])
						// id_ors_ps.toArray();
						FArrayList ciorders = CiOrdUtils.list2FArrayList(id_ors_ps);
						scene.put("ciors", ciorders);
						rstDTO.setIsSuccess(FBoolean.TRUE);
						rstDTO.setExtension(scene);
					}
					OrdBizLogger.info(null, "皮试自动签署失败--皮试判断");
					return rstDTO;
				}
				aggors = aggList.toArray(new CiorderAggDO[0]);
			} else if (skinTestRstMap != null && skintestbp.isNeedToFront()) {
				// 返回前台
				rstDTO.setIsSuccess(FBoolean.FALSE);
				// 添加生成的皮试医嘱
				if (id_ors_ps != null && id_ors_ps.size() > 0) {
					CiOrderDO[] ciorders = (CiOrderDO[]) id_ors_ps.toArray();
					scene.put("ciors", CiOrdUtils.array2FArrayList(ciorders));
					rstDTO.setIsSuccess(FBoolean.TRUE);
					rstDTO.setExtension(scene);
				}
				rstDTO.setExtension(skinTestRstMap);
				OrdBizLogger.info(null, "皮试自动签署失败--皮试判断");
				return rstDTO;
			}
		} else {
			SkinTestOrSignBP skintestbp = new SkinTestOrSignBP();
			String strRst_skintest = skintestbp.exec(aggors);
			if (!StringUtils.isNullOrEmpty(strRst_skintest)) {
				rstDTO.setIsSuccess(FBoolean.FALSE);
				FMap2 scene = new FMap2();
				scene.put("checkResult", strRst_skintest);
				rstDTO.setExtension(scene);
				OrdBizLogger.info(null, "皮试自动签署失败--皮试判断");
				return rstDTO;
			}
		}

		// 病理标本项目非空检查
		PathgySampValidateBP pathgysamptestbp = new PathgySampValidateBP();
		String strRst_pathgy = pathgysamptestbp.exec(aggors);
		if (!StringUtils.isNullOrEmpty(strRst_pathgy)) {
			rstDTO.setIsSuccess(FBoolean.FALSE);
			FMap2 scene = new FMap2();
			scene.put("checkResult", strRst_pathgy);
			rstDTO.setExtension(scene);
			OrdBizLogger.info(null, "皮试自动签署失败--病理标本判断");
			return rstDTO;
		}
		
		// 用血医嘱可用血余量的校验
		UseBtOrNumMarginBuValidateBP usebtbp = new UseBtOrNumMarginBuValidateBP();
		String strRst_ub = usebtbp.exe(aggors);
		if (!StringUtils.isNullOrEmpty(strRst_ub)) {
			rstDTO.setIsSuccess(FBoolean.FALSE);
			FMap2 scene = new FMap2();
			scene.put("checkResult", strRst_ub);
			rstDTO.setExtension(scene);
			OrdBizLogger.info(null, "皮试自动签署失败--用血判断");
			return rstDTO;
		}
		
		// 手术签署动态指标校验
		String viewItemErrorInfo = validateOpViewItem(aggors);
		if (!StringUtils.isNullOrEmpty(viewItemErrorInfo)) {
			rstDTO.setIsSuccess(FBoolean.FALSE);
			FMap2 scene = new FMap2();
			scene.put("checkResult", viewItemErrorInfo);
			rstDTO.setExtension(scene);
			OrdBizLogger.info(null, viewItemErrorInfo);
			return rstDTO;
		}

		// 如果是医保类医嘱或临床路径待判断的医嘱，判断医生是否已经判断过。如果存在医生未判断，则将数据传送到前台，让医生判断
		/*OrDoctorCheckValidateBP docvalidatebp = new OrDoctorCheckValidateBP();
		FArrayList willCheckIdOrs = docvalidatebp.exec(aggors);
		if (!CiOrdUtils.isEmpty(willCheckIdOrs)) {
			OrderRstDTO dto = new OrderRstDTO();
			FMap2 scene = new FMap2();
			scene.put("willCheckIdOrs", willCheckIdOrs);
			dto.setExtension(scene);
			OrdBizLogger.info(null, "皮试自动签署失败--医保类审核判断");
			return dto;
		}*/

		// 医保待判断医嘱 过滤、特殊病标识赋值
		OrdHpSignInfoBP ordHpSignInfo = new OrdHpSignInfoBP();
		OrderRstDTO orderRst = ordHpSignInfo.checkOrdHpInfoSign(ctx,arg, aggors);
		if(orderRst != null){
			return orderRst;
		}
		/*FArrayList idOrList = ordHpSignInfo.getWaitJudgeIdOrList(ctx, aggors);
		if (!CiOrdUtils.isEmpty(idOrList)) {
			OrderRstDTO dto = new OrderRstDTO();
			FMap2 scene = new FMap2();
			scene.put("willCheckIdOrs", idOrList);
			dto.setExtension(scene);
			OrdBizLogger.info(null, "未进行医保判断，不允许进行签署！");
			return dto;
		}*/
		
		// 验证当前为医保数据进行医保规则校验
		String hpmessage = "";

		if (ctx != null && this.getOrderSignBlHpValidate(ctx.getId_org())
				&& (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(ctx.getCode_entp())
						|| IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(ctx.getCode_entp())
						|| IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(ctx.getCode_entp()))
				&& ctx.getSd_hptp() != null && ctx.getSd_hptp().startsWith("1")) {
			if (emsExtensionMap2 != null) {
				hpmessage = (String) emsExtensionMap2.get("hpmessage");
			}
			if (hpmessage == "") { // 界面确认返回的
				// 医保规则
				OrderRstDTO checkRstDTO = SignMedicalRule(aggors);
				if (checkRstDTO != null) {
					OrdBizLogger.info(null, "皮试自动签署失败--医保类规则判断");
					return checkRstDTO;
				}
			}
		}
		// 医嘱服务开立权限判断逻辑
		FMap2 orsrvrtchk = null;
		if (CiOrdUtils.PROJECT_GJ.equals(CiOrdUtils.getProjectIdentity(ctx.getCode_entp()))) {
			iih.ci.ord.s.bp.validate.gj.OrSrvDoctorRtValidateBP doctorRtbp = new iih.ci.ord.s.bp.validate.gj.OrSrvDoctorRtValidateBP();
			orsrvrtchk = doctorRtbp.exec(aggors);
		} else {
			iih.ci.ord.s.bp.validate.tl.OrSrvDoctorRtValidateBP doctorRtbp = new iih.ci.ord.s.bp.validate.tl.OrSrvDoctorRtValidateBP();
			orsrvrtchk = doctorRtbp.exec(aggors, CiOrdUtils.isUrgentWf(ctx.getCode_entp()));
		}

		if (orsrvrtchk != null && orsrvrtchk.size() > 0) {
			OrderRstDTO dto = new OrderRstDTO();
			dto.setExtension(orsrvrtchk);
			OrdBizLogger.info(null, "皮试自动签署失败--开立权限判断");
			return dto;
		}

		CiOrderDO[] ciors = getCiOrderDOs(aggors);
		FDateTime dt_cur = CiOrdAppUtils.getServerDateTime();
		// 药品毒麻信息审核
		FArrayList checkPatInfoSrvs = srvPoisInfoCheck(aggors);
		// 判断特殊病，用户干预后 点击 否 签署 不是特殊病药，不在进行判断 bug 106951
		String notSpecilDrugIdOrsrv = "";
		if (emsExtensionMap2 != null) {
			notSpecilDrugIdOrsrv = (String) emsExtensionMap2.get("notSpecilDrugIdOrsrv");
			// ValidataMedicalSharing(notSpecilDrugIdOrsrv,aggors);
		}
		if (notSpecilDrugIdOrsrv == "") {
			// 特殊病判断
			FMap2 mapIdOrsrv = new FMap2();
			String specilInfo = "";//judgeSpecillFlag(aggors, ctx, mapIdOrsrv);
			if (checkPatInfoSrvs.size() > 0 || !CiOrdUtils.isEmpty(specilInfo)) {
				// 插入 用户干预点 //用户确认后继续
				OrderRstDTO dto = new OrderRstDTO();
				FMap2 scene = new FMap2();
				scene.put("dt_cur", dt_cur);
				scene.put("ciors", CiOrdUtils.array2FArrayList(ciors));
				if (checkPatInfoSrvs.size() > 0) {
					scene.put("checkPatInfoSrvs", checkPatInfoSrvs);
				}
				if (!CiOrdUtils.isEmpty(specilInfo)) {
					scene.put("specilDrugs", specilInfo);
				}
				scene.put("notSpecilDrugIdOrsrv", getMapKey(mapIdOrsrv));
				dto.setExtension(scene);
				OrdBizLogger.info(null, "皮试自动签署失败--毒麻精一判断");
				return dto;
			}
		}

		// 本次就诊为医保就诊时，判断是否存在保外诊断，如果存在保外诊断更新医嘱中的保外诊断属性
		if (CiOrdUtils.isHpUsing(ctx)) {
			/*
			重复开药判断放到费用域的规则校验中
			List<String> idSrvList = new ArrayList<String>();
			for (CiorderAggDO ciorderAgg : aggors) {
				CiOrderDO ciOrder = ciorderAgg.getParentDO();
				if (ICiDictCodeConst.SD_SU_OPEN.equals(ciOrder.getSd_su_or())) {
					String sdSrvtp = ciOrder.getSd_srvtp();
					// 药品，非溶媒 时校验是否重复开药
					if (sdSrvtp.startsWith(IBdSrvTpDictCodeConst.SD_SRVTP_DRUG)) {
						OrdSrvDO[] OrdSrvs = ciorderAgg.getOrdSrvDO();
						for (OrdSrvDO ordSrv : OrdSrvs) {
							String srvSdSrvtp = ordSrv.getSd_srvtp();
							// 非溶媒,非草药时校验是否重复开药
							if (IBdSrvTpDictCodeConst.SD_SRVTP_WESTDRUG_DSY.equals(srvSdSrvtp)
									|| IBdSrvTpDictCodeConst.SD_SRVTP_HERBDRUG_CHINA.equals(srvSdSrvtp)) {
								continue;
							}
							if (idSrvList.contains(ordSrv.getId_srv())) {
								OrdBizLogger.info(null, "皮试自动签署失败--医保患者签署处置时存在重复药品判断");
								throw new BizRuntimeException("医保患者签署处置时存在重复药品[" + ordSrv.getName() + "]！");
							}
							// 医保只需要 医保校验排除自费，自备，外配，频次周期类型为一次的药品
							if (FBoolean.TRUE.equals(ordSrv.getFg_mm()) && !FBoolean.TRUE.equals(ordSrv.getFg_selfpay())
									&& !FBoolean.TRUE.equals(ordSrv.getFg_self())
									&& !IBdSrvDictCodeConst.SD_FREQNUNITCT_ONCE.equals(ordSrv.getSd_frequnitct())) {
								idSrvList.add(ordSrv.getId_srv());
							}
						}
					}
				}
			}*/

			// 查询保外诊断
			ICidiagQryService icidiagQryService = (ICidiagQryService) ServiceFinder.find(ICidiagQryService.class);
			CiDiagItemDO[] ciDiagItems = icidiagQryService.getHpjudgetpCiDiagItems(ctx.getId_en());

			if (!CiOrdUtils.isEmpty(ciDiagItems)) {

				CiEnContextUtil.SetHpCiDiagItem(ctx, ciDiagItems);
				for (CiOrderDO ciOrderDO : ciors) {
					ciOrderDO.setEu_hpindicjudge(HpIndicJudgeEnum.NONEEDJUDGE);// 医保适应症判断标识枚举
					ciOrderDO.setBhpjudgerst(ctx.getBhpjudgerst()); // 基本医保判断结果数据信息
					ciOrderDO.setDes_bhpjudgerst(ctx.getDes_bhpjudgerst()); // 基本医保判断结果数据信息描述，保外诊断id串
				}

				CiOrderUpdateHpCiDiBP ciOrderUpdateHpCiDiBP = new CiOrderUpdateHpCiDiBP(ctx);
				ciOrderUpdateHpCiDiBP.execUpdateOrdSrvs(lstIdors.toArray(new String[lstIdors.size()]));
			}
		}

		OrderRstDTO saveSignData = saveSignData(aggors, dt_cur, arg);
		// 添加生成的皮试医嘱
		if (id_ors_ps != null && id_ors_ps.size() > 0) {
			// CiOrderDO[] ciorders =(CiOrderDO[]) id_ors_ps.toArray();
			FArrayList ciorders = CiOrdUtils.list2FArrayList(id_ors_ps);
			FMap2 scene = new FMap2();
			scene.put("ciors", ciorders);
			saveSignData.setIsSuccess(FBoolean.TRUE);
			saveSignData.setExtension(scene);
		}

		return saveSignData;
	}

	/**
	 * map 的values 转换成 String
	 * 
	 * @param map
	 * @return
	 */
	private String getMapKey(FMap2 map) {
		StringBuffer sb = new StringBuffer();
		if (map != null) {
			for (Object id_orsrv : map.values()) {
				sb.append("'");
				sb.append(id_orsrv.toString());
				sb.append("',");
			}
		}
		return sb.toString();
	}

	/**
	 * 签署验证医保规则
	 * 
	 * @param aggors
	 * @return
	 * @throws BizException
	 */
	private OrderRstDTO SignMedicalRule(CiorderAggDO[] aggors) throws BizException {
		// 为医保验证弹窗中的服务名称拼装物品名称:服务名称(物品名称) by yzh 2017-10-23 13:39:40 BUG:0109371
		if (!CiOrdUtils.isEmpty(aggors)) {
			for (CiorderAggDO ciorderAggDO : aggors) {
				String MM_name = getOrderMMName(ciorderAggDO);
				if (MM_name != null)
					ciorderAggDO.getParentDO()
							.setName_or(ciorderAggDO.getParentDO().getName_or() + "(" + MM_name + ")");
			}
		}
		CiHpCheckResultDTO result = HpDetailedRuleBP.getInstance().getHpOrderSigndRule(aggors);
		if (result != null && !result.getCheckflag().booleanValue()) {
			FMap2 hpmessageMap = new FMap2();
			FArrayList2 hplist = new FArrayList2();
			FArrayList rstlist = result.getErroritm_list();
			if (rstlist != null) {
				for (int i = 0; i < rstlist.size(); i++) {
					ItmChkRstDTO chkRstDTO = (ItmChkRstDTO) rstlist.get(i);
					MedicalSharingDTO medicalSahringDTO = new MedicalSharingDTO();
					medicalSahringDTO.setCode_or(chkRstDTO.getCode_or());
					// medicalSahringDTO.setName_srv(chkRstDTO.getName_srv());
					// 医保验证弹窗服务名称取值 by yzh bug:0109371
					medicalSahringDTO.setName_srv(chkRstDTO.getName_or());
					FMap map = chkRstDTO.getError_map();
					List<String> mapKeyList = new ArrayList<String>(map.keySet());
					String keys = "";
					String values = "";
					for (String key : mapKeyList) {
						keys += "," + key;
						values += map.get(key) + "\n";
					}
					if (FBoolean.TRUE.equals(WarningAndStop(keys))) {
						medicalSahringDTO.setCode("Stop");
					}
					medicalSahringDTO.setReason(values);
					hplist.add(medicalSahringDTO);
				}
			}
			hpmessageMap.put("hprule", hplist);
			OrderRstDTO dto = new OrderRstDTO();
			hpmessageMap.put("hpmessage", "hpmessage");
			dto.setExtension(hpmessageMap);
			return dto;
		}
		return null;
	}

	/**
	 * 物品名称 by yzh
	 * 
	 * @param oraggandrelinfo
	 * @return
	 */
	private String getOrderMMName(CiorderAggDO aggor) {
		if (!CiOrdUtils.isEmpty(aggor)) {
			OrdSrvDO[] ordSrvDOs = aggor.getOrdSrvDO();
			if (CiOrdUtils.isEmpty(ordSrvDOs))
				return null;
			for (OrdSrvDO ordSrvDO : ordSrvDOs) {
				if (CiOrdUtils.isEmpty(ordSrvDO))
					continue;
				if (FBoolean.TRUE.equals(ordSrvDO.getFg_mm()))
					return ordSrvDO.getName();
			}
		}
		return null;
	}

	/**
	 * 保存时 提示信息还是终止保存；
	 * 
	 * @param keys
	 * @return
	 */
	private FBoolean WarningAndStop(String keys) {
		if (keys != "") {
			if (keys.contains(CiHpCheckFailResultEnum.REPEAT_PRES_DRUG)) {
				return FBoolean.TRUE;
			}
			if (keys.contains(CiHpCheckFailResultEnum.GREATER_THAN_ONE_TIME)) {
				return FBoolean.TRUE;
			}
			if (keys.contains(CiHpCheckFailResultEnum.GREATER_THAN_GET_OEP)) {
				return FBoolean.TRUE;
			}
			if (keys.contains(CiHpCheckFailResultEnum.GREATER_THAN_OWN_OEP)) {
				return FBoolean.TRUE;
			}
			if (keys.contains(CiHpCheckFailResultEnum.GREATER_THAN_GET_ER)) {
				return FBoolean.TRUE;
			}
			return FBoolean.FALSE;
		}

		return FBoolean.FALSE;
	}

	/**
	 * 获得医嘱主DO数组
	 * 
	 * @param aggors
	 * @return
	 */
	private CiOrderDO[] getCiOrderDOs(CiorderAggDO[] aggors) {

		List<CiOrderDO> ciOrderList = new ArrayList<CiOrderDO>();
		for (int i = 0; i < aggors.length; i++) {
			CiOrderDO ciOrder = aggors[i].getParentDO();
			if (ICiDictCodeConst.SD_SU_OPEN.equals(ciOrder.getSd_su_or())) {
				ciOrderList.add(ciOrder);
			}
		}
		if (ciOrderList.size() != aggors.length) {
			throw new BizRuntimeException("医嘱数据状态发生改变，请勿重复签署！");
		}
		return ciOrderList.toArray(new CiOrderDO[ciOrderList.size()]);
	}

	/**
	 * 药品毒麻信息审核
	 * 
	 * @param aggors
	 * @return
	 */
	private FArrayList srvPoisInfoCheck(CiorderAggDO[] aggors) {
		FArrayList idorsrvs = new FArrayList();
		FArrayList ordsrvPois = new FArrayList();
		FBoolean poisinfocheck = CiOrdUtils.Poisinfocheck(Context.get().getOrgId(), "00");
		if (FBoolean.FALSE.equals(poisinfocheck)) {
			return ordsrvPois;
		}

		FMap orsrvMap = new FMap();
		for (CiorderAggDO agg : aggors) {
			if (!agg.getParentDO().getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG))
				continue;
			OrdSrvDO[] ordSrvdos = agg.getOrdSrvDO();
			for (OrdSrvDO srvdo : ordSrvdos) {
				idorsrvs.append(srvdo.getId_orsrv());
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
					idorsrvs.append(srvmm.getId_orsrv());
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
						ordsrvPois.append(orsrvMap.get(id_orsrv.toString()));
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
	 * 删除
	 * @param aggs
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	@Deprecated
	private String judgeSpecillFlag(CiorderAggDO[] aggs, CiEnContextDTO ctx, FMap2 mapIdOrsrv) throws BizException {

		// return "西药，中药";
		// 非医保或患者非特病返回false
		if (CiOrdUtils.isEmpty(ctx.getId_hp()) || !CiOrdUtils.isTrue(ctx.getFg_hpspcl()))
			return null;
		FArrayList idOrsrvs = new FArrayList();
		Map<String, OrdSrvDO> ordsrvMap = new HashMap<String, OrdSrvDO>();
		for (CiorderAggDO agg : aggs) {
			OrdSrvDO[] ordsrvs = agg.getOrdSrvDO();
			for (OrdSrvDO srv : ordsrvs) {
				if (FBoolean.FALSE.equals(srv.getFg_self()) && FBoolean.FALSE.equals(srv.getFg_selfpay())
						&& srv.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG)) {
					idOrsrvs.append(srv.getId_orsrv());
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

							mapIdOrsrv.put(mmMap.get(specill.getId_mm()).getId_orsrv(),
									mmMap.get(specill.getId_mm()).getId_orsrv());
							String name_srv = ordsrvMap.get(mmMap.get(specill.getId_mm()).getId_orsrv()).getName();
							specilDrugs.add(name_srv + "[" + mmMap.get(specill.getId_mm()).getName_mm()
									+ "] 是特殊病药品，未录入其对应特殊病的诊断: " + getMapName(diagmap) + System.lineSeparator());
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
			StringBuffer str = new StringBuffer();
			for (Object info : specilDrugs) {
				str.append(info.toString());
			}
			return str.append("是否录入?").toString();
		} else {
			return null;
		}
	}

	/**
	 * 特殊病诊断集合
	 * 
	 * @param diagmap
	 *            特殊病诊断集合
	 * @return
	 */
	private String getMapName(FMap2 diagmap) {
		StringBuffer sb = new StringBuffer();
		if (diagmap == null || diagmap.isEmpty()) {
			return "";
		}

		for (Object key : diagmap.keySet()) {
			sb.append("，" + key + " " + diagmap.get(key));
		}

		return sb.substring(1);
	}

	/**
	 * 执行签署数据更新
	 * 
	 * @param ciors
	 * @throws BizException
	 */
	private OrderRstDTO saveSignData(CiorderAggDO[] aggdos, FDateTime dt_cur, OrderOperateDTO orderOperateDTO) throws BizException {
		CiEnContextDTO ctx = (CiEnContextDTO) Context.get().getAttribute("CiEnContextDTO");
		CiOrderDO[] ciors = this.getCiOrderDOs(aggdos);
		Long startTIme = System.currentTimeMillis();
		OrderRstDTO rst = this.saveSignData(ciors, dt_cur, orderOperateDTO);
		CiOrdUtils.getlogger().info("CiLisOrSmsHandlerBP 签署总耗时  .." + (System.currentTimeMillis() - startTIme) + "毫秒");
		return rst;
	}

	/**
	 * 执行签署数据更新
	 * 
	 * @param ciors
	 * @throws BizException
	 */
	protected OrderRstDTO saveSignData(CiOrderDO[] ciors, FDateTime dt_cur, OrderOperateDTO orderOperateDTO) throws BizException {

		CiEnContextDTO ctx = (CiEnContextDTO) Context.get().getAttribute("CiEnContextDTO");

		// 创建门诊医嘱会话区间 
		CiOrOpSessionInsertBP bpSession = new CiOrOpSessionInsertBP();
		CiOrSessionDO sessiondo = bpSession.exec(ciors, dt_cur);

		// 检验合单 兰陵不需要 暂时 注释
		CiLisOrSmsHandlerBP bpLis = new CiLisOrSmsHandlerBP();
		MergeTubeRstDTO mergeTubeRstDTO = null;
		if (emsExtensionMap2 == null || !emsExtensionMap2.containsKey("RelationOrders_check")) {
			if (emsExtensionMap2 != null && emsExtensionMap2.containsKey("MergeTubeRstDTO")) {
				mergeTubeRstDTO = (MergeTubeRstDTO) emsExtensionMap2.get("MergeTubeRstDTO");
				mergeTubeRstDTO = bpLis.exec(ctx, mergeTubeRstDTO);
			} else {
				mergeTubeRstDTO = bpLis.megeTube(ctx, ciors, sessiondo);
				if (mergeTubeRstDTO != null && MergeTubeRstEnum.FAIL.equals(mergeTubeRstDTO.getRstStatus())) {
					OrderRstDTO dto = new OrderRstDTO();
					dto.setIsSuccess(FBoolean.FALSE);
					FMap2 scene = new FMap2();
					scene.put("MergeTubeRstDTO", mergeTubeRstDTO);
					dto.setExtension(scene);
					return dto;
				}
			}
		}
		if (mergeTubeRstDTO != null && mergeTubeRstDTO.getNewCreateOrders() != null) {
			List<CiOrderDO> orders = Arrays.asList(ciors);
			List<CiOrderDO> newOrders = mergeTubeRstDTO.getNewCreateOrders();
			List<CiOrderDO> list = new ArrayList<CiOrderDO>();
			list.addAll(orders);
			list.addAll(newOrders);
			ciors = list.toArray(new CiOrderDO[0]);
		}
		Long startTIme = System.currentTimeMillis();
		// 保存检查打印数据 仅门急诊使用，并生成图文报告
		CiprnSaveAppRisDataBP bpRis = new CiprnSaveAppRisDataBP();
		List<CiOrderDO> imageTextOrdres = bpRis.exec(ctx, ciors, sessiondo);
		CiOrdUtils.getlogger()
				.info("CiLisOrSmsHandlerBP 检查生成图文报告总耗时  .." + (System.currentTimeMillis() - startTIme) + "毫秒");
		if (imageTextOrdres != null && imageTextOrdres.size() > 0) {
			List<CiOrderDO> orderList = new ArrayList<CiOrderDO>();
			for (CiOrderDO newOrder : imageTextOrdres) {
				// 需要单独走一下签署逻辑，需要合单、分方等操作
				if (!StringUtils.isNullOrEmpty(newOrder.getSd_srvtp())
						&& (newOrder.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)
								|| newOrder.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS)
								|| newOrder.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_LIS))) {
					orderList.add(newOrder);
				}
			}
			if (orderList.size() > 0) {
				imageTextOrdres.removeAll(orderList);
				OpSimpleOrderSignBP simpleSignBP = new OpSimpleOrderSignBP();
				simpleSignBP.sign(ctx, orderList);
			}
			// 如果还存在诊疗类的医嘱，继续合并到当前签署队列中一起更新医嘱状态
			if (imageTextOrdres.size() > 0) {
				List<CiOrderDO> orders = Arrays.asList(ciors);
				List<CiOrderDO> list = new ArrayList<CiOrderDO>();
				list.addAll(orders);
				list.addAll(imageTextOrdres);
				ciors = list.toArray(new CiOrderDO[0]);
			}
		}
		
		//医保：关联出来的医嘱如果存在待判断医嘱，则需要进行医保适应症判断
		if (MiEnContextUtil.isHpPat(ctx) && orderOperateDTO != null) {
			//医嘱id集合
			List<String> orIdList = new ArrayList<>();
			FArrayList list = new FArrayList();
			for (CiOrderDO ciOrderDO : ciors) {
				orIdList.add(ciOrderDO.getId_or());
				list.append(ciOrderDO);
			}
			ICiorderRService ciorderRService = ServiceFinder.find(ICiorderRService.class);
			CiorderAggDO[] ordAggs = ciorderRService.findByBIds(orIdList.toArray(new String[orIdList.size()]), FBoolean.FALSE);
			OrdHpSignInfoBP ordHpSignInfo = new OrdHpSignInfoBP();
			OrderRstDTO orderRst = ordHpSignInfo.checkOrdHpInfoSign(ctx, orderOperateDTO, ordAggs);
			if(orderRst != null){
				//返回所有医嘱
				orderRst.getExtension().put("RelationOrderIsWaitingJudge", list);
				return orderRst;
			}
		}
		
		// 更新医嘱状态为签署
		updateOrderStatus(ciors);

		// 签署时，按规则自动分方 仅门急诊使用 新接口 可配置第三方插件
		CiOrPresSplitHandleBP bpPresSplit = new CiOrPresSplitHandleBP();
		bpPresSplit.exec(ctx, ciors, sessiondo);
		startTIme = System.currentTimeMillis();
		// 集成平台消息入口
		CiOrdUtils.fireBDEvent(IOrdEventSources.OP_IP_SIGN_ENTER, IEventType.TYPE_UPDATE_AFTER, ciors);// 门诊住院签署入口-集成平台
		CiOrdUtils.getlogger().info("CiLisOrSmsHandlerBP 集成平台耗时  .." + (System.currentTimeMillis() - startTIme) + "毫秒");
		// 发送消息给执行域
		startTIme = System.currentTimeMillis();
		CiOrdUtils.fireBDEvent(ICiEventConst.CIOR_STATUS_EVENT_SOURCEID, IEventType.TYPE_UPDATE_AFTER, ciors);
		CiOrdUtils.getlogger()
				.info("CiLisOrSmsHandlerBP 签署后置事件耗时  .." + (System.currentTimeMillis() - startTIme) + "毫秒");
		// 临床事件保存
		ciEventInfoSave(ciors);
		startTIme = System.currentTimeMillis();
		// 如果包含检验项目合单数据，发送到执行域
		if (mergeTubeRstDTO != null && mergeTubeRstDTO.getCiapplissheet() != null) {
			CiapplissheetAggDO[] lissheets = (CiapplissheetAggDO[]) mergeTubeRstDTO.getCiapplissheet()
					.toArray(new CiapplissheetAggDO[0]);
			mergeTubeSendToMp(ctx, lissheets);
		}
		CiOrdUtils.getlogger()
				.info("CiLisOrSmsHandlerBP 发送到执行域耗时  .." + (System.currentTimeMillis() - startTIme) + "毫秒");
		// 备血可用血余量更新
		UseBtOrNumMarginBuUpdateBP bpBuUpdate = new UseBtOrNumMarginBuUpdateBP();
		bpBuUpdate.exec(ciors, true);

		// 保存病理打印数据 仅门急诊使用
		CiprnSaveAppPathgyDataBP bpPathgy = new CiprnSaveAppPathgyDataBP();
		bpPathgy.exec(ciors, sessiondo);

		// 保存备血打印数据 仅门急诊使用
		CiprnSaveAppBtDataBP bpBt = new CiprnSaveAppBtDataBP();
		bpBt.exec(ctx, ciors, sessiondo);

		// 保存取血打印数据 仅门急诊使用
		CiprnSaveAppBuDataBP bpBu = new CiprnSaveAppBuDataBP();
		bpBu.exec(ctx, ciors, sessiondo);

		// 生成门诊费用清单打印数据
		if (ctx != null) {

			if (ctx != null && (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(ctx.getCode_entp())
					|| IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(ctx.getCode_entp())
					|| IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(ctx.getCode_entp()))) {
				// 生成保存门诊费用清单打印数据
				String[] id_ors = new String[ciors.length];
				int i = 0;
				for (CiOrderDO ciorder : ciors) {
					id_ors[i] = ciorder.getId_or();
					i++;
				}
				CiOrdAppUtils.getICiprintExtService().SaveFeeBillsData(id_ors, ctx.getId_hp(), ctx.getSd_hptp());

				// 高端商保记账
				// 高端商保判断是每条医嘱的金额 不能超过限制的 金额
				if (ctx.getSd_hptp() != null && ctx.getSd_hptp().startsWith("2")) {
					highHpAccount(ctx.getId_en());
//					CiOrdAppUtils.getIBLOrderAppendBillService().SetOrderAppendBill_ByItms_ci_kljz_new(ctx.getId_en(),
//							ctx.getCode_entp(), CgTypeEnum.CG_HPCG, ctx.getId_emp_or());
				}
			}
		}

		// Runnable r = new OrderSignSaveDataRunnable(ciors, sessiondo,
		// (CiEnContextDTO) Context.get().getAttribute(
		// "CiEnContextDTO"));
		// ExecutorUtil.startRunnable(r);

		OrderRstDTO dto = new OrderRstDTO();
		FMap2 scene = new FMap2();
		scene.put("ciors", CiOrdUtils.array2FArrayList(ciors));
		dto.setExtension(scene);
		dto.setIsSuccess(FBoolean.TRUE);
		startTIme = System.currentTimeMillis();
		// 调用预约接口向预约发送手术申请数据
		CiOrSufInfo4ScAptApplBp bp = new CiOrSufInfo4ScAptApplBp();
		bp.sendSugInfo4ScAptAppl(ciors);
		CiOrdUtils.getlogger().info("CiLisOrSmsHandlerBP 手术预约耗时  .." + (System.currentTimeMillis() - startTIme) + "毫秒");
		startTIme = System.currentTimeMillis();
		// 医技预约
		CiOrderRisInfoToScAptApplBp risScBp = new CiOrderRisInfoToScAptApplBp();
		risScBp.sendCiOrderRisInfoToScAptAppl(ciors, ctx.getSd_hptp());
		CiOrdUtils.getlogger().info("CiLisOrSmsHandlerBP 医技预约耗时  .." + (System.currentTimeMillis() - startTIme) + "毫秒");
		/*
		 * CiOrderRisInfoToScAptApplBp risbp = new
		 * CiOrderRisInfoToScAptApplBp();
		 * risbp.sendCiOrderRisInfoToScAptAppl(ciors,ctx.getSd_hptp());
		 */
		// getSaveAutoApt4C(ciors);
		OrdBizLogger.info(null, "皮试自动签署成功--");
		return dto;
	}

	/**
	 * 高端商报记账
	 * 
	 * @param id_ent
	 * @throws BizException 
	 */
	private void highHpAccount(String id_ent) throws BizException {
		BlCgOpAccountSetDTO accSetDto = new BlCgOpAccountSetDTO();
		accSetDto.setId_emp_cg(Context.get().getStuffId());//记账人员
		accSetDto.setId_org_cg(Context.get().getOrgId());//记账机构
		accSetDto.setId_dep_cg(Context.get().getDeptId());//记账科室
		accSetDto.setDt_cg(new FDateTime(new Date()));//记账时间
		accSetDto.setSrcfunc_des(IBlCgFuncConst.FUNC_OPOR_DOCTORSTATION);//记账来源
		accSetDto.setEu_oepcgmode(OepCgModeEnum.HIGHHP_CG);//门诊记账模式
		accSetDto.setFg_reserve(FBoolean.TRUE);
		List<BlCgAccountDTO> accDtos = new ArrayList<>();
		// 获得处方信息和处方费用相关信息
		PrescriptionConstBaseDto baseDTO = CiOrdAppUtils.getCiOrdQryService()
				.getPrescriptionConstAccounting(id_ent, new String[]{"0"});
		if (baseDTO == null) {
			return;
		}
		// 组装记账数据对象
		FArrayList prescriptionCostDtos = baseDTO.getPrescriptionCostDto();
		if (prescriptionCostDtos == null || prescriptionCostDtos.size() <= 0) {
			return;
		}
		for (Object obj : prescriptionCostDtos) {
			PrescriptionCostDto dto = (PrescriptionCostDto) obj;
			BlCgAccountDTO blCgAccountDTO = new BlCgAccountDTO();
			blCgAccountDTO.setId_ent(dto.getId_en());// 就诊
			blCgAccountDTO.setId_pat(dto.getId_pat());// 患者
			blCgAccountDTO.setId_or(dto.getId_or());// 医嘱
			blCgAccountDTO.setId_orsrv(dto.getId_orsrv());// 医嘱服务
			blCgAccountDTO.setId_srv(dto.getId_srv());// 服务
			blCgAccountDTO.setId_mm(dto.getId_mm());// 物品
			blCgAccountDTO.setFg_mm(dto.getFg_mm());// 物品管理标识
			blCgAccountDTO.setId_unit_srv(dto.getId_unit_med());// 服务单位
			blCgAccountDTO.setId_pkgu_cur(dto.getId_unit_cur());// 物品单位
			if (dto.getSd_srvtp().startsWith("01")) {// 药品
				blCgAccountDTO.setQuan(dto.getQuan_cur());// 数量
			} else {// 非药品
				blCgAccountDTO.setQuan(new FDouble(dto.getQuan_med()));// 数量
			}
			blCgAccountDTO.setPrice_std(dto.getPri_std());// 标准价
			blCgAccountDTO.setPrice_ratio(dto.getPri_ratio());// 折扣价
			blCgAccountDTO.setEu_direct(1);// 记账方向
			blCgAccountDTO.setId_dep_or(dto.getId_dep_srv());// 开立科室
			blCgAccountDTO.setId_emp_or(dto.getId_emp_srv());// 开立医生
			blCgAccountDTO.setId_dep_mp(dto.getId_dep_mp());// 执行科室
			blCgAccountDTO.setId_dep_wh(dto.getId_dep_wh());// 执行药房
			blCgAccountDTO.setFg_addfee(FBoolean.FALSE);// 补费标识
			accDtos.add(blCgAccountDTO);
		}
		IBlCgAccountService bIBlCgAccountService = ServiceFinder.find(IBlCgAccountService.class);
		BlCgAccountRltDTO blCgAccountRltDTO = bIBlCgAccountService.keepAccountForOp(accDtos.toArray(new BlCgAccountDTO[accDtos.size()]), accSetDto);
	}

	private void getSaveAutoApt4C(CiOrderDO[] ciOrderDO) throws BizException {
		String risapp = SysParamUtils.getSysParam().getSYS_PARAM_IsOpenRisApt4IIH().getOrgParam();
		if (new FBoolean(risapp).booleanValue()) {
			ISc4CiCmdService outcmdService = ServiceFinder.find(ISc4CiCmdService.class);
			if (outcmdService == null)
				throw new BizException("预约的 ISc4CiCmdService 为空！");
			String param = getRisAppParam();
			if ("02".equals(param)) { // 00 不预约 01 弹出预约 02 自动预约
				for (CiOrderDO ciorderDO : ciOrderDO) {
					if (ciorderDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS)
							&& ciorderDO.getSd_srvtp() != IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI) {
						// MtAptParamDTO paramDTO = new MtAptParamDTO();
						// paramDTO.setId_or(ciorderDO.getId_or());
						// paramDTO.setId_srv(ciorderDO.getId_srv());
						// paramDTO.setDt_effe_or(ciorderDO.getDt_effe());
						// paramDTO.setName_or(ciorderDO.getName_or());
						// paramDTO.setD_begin(ciorderDO.getDt_effe().getDate());
						// paramDTO.setId_ent(ciorderDO.getId_en());
						// paramDTO.setId_dep_mp(ciorderDO.getId_dep_mp());
						// paramDTO.setId_emp_appl(ciorderDO.getId_emp_or());
						// paramDTO.setFg_urgent(ciorderDO.getFg_urgent());
						// paramDTO.setApplyno(ciorderDO.getApplyno());
						// paramDTO.setId_pat(ciorderDO.getId_pat());
						// paramDTO.setCode_scchl("02");
						// paramDTO.setContent_or(ciorderDO.getContent_or());
						// paramDTO.setId_dep_apply(ciorderDO.getId_dep_or());
						// paramDTO.setId_entp(ciorderDO.getId_entp());
						// paramDTO.setSc_mt_mode(IScDictCodeConst.CI_AUTO_SC_APT_MODE);
						// outcmdService.saveApt4Ci(paramDTO);
					}
				}
			}
		}
	}

	private String getRisAppParam() throws BizException {
		StringBuffer sbuilder = new StringBuffer();
		CiEnContextDTO context = (CiEnContextDTO) Context.get().getAttribute("CiEnContextDTO");
		sbuilder.append(" Id_user='");
		sbuilder.append(context.getId_user());
		sbuilder.append("' and Id_group='");
		if (!StringUtils.isNullOrEmpty(context.getId_org())) {
			sbuilder.append(context.getId_org());
		} else {
			sbuilder.append(context.getId_grp());
		}
		sbuilder.append("' and Pageid='");
		sbuilder.append("xap.rui.Control.XapBaseControl.UserIndividualSetting");
		sbuilder.append("' and Propertyname='");
		sbuilder.append("461005");
		sbuilder.append("'");
		IUserindividualRService userindividualservice = ServiceFinder.find(IUserindividualRService.class);
		UserIndividualPropertyDO[] userIndividual = userindividualservice.find(sbuilder.toString(), "", FBoolean.FALSE);
		if (userIndividual != null && userIndividual.length > 0) {
			String value = userIndividual[0].getValue();
			if (value != null && value.indexOf(":") > 0) {
				return value.substring(value.indexOf(":") + 1);
			}
		}
		return "";
	}

	/**
	 * 更新医嘱签署状态
	 * 
	 * @param orders
	 * @throws BizException
	 */
	protected void updateOrderStatus(CiOrderDO[] orders) throws BizException {
		String[] arrayFieldNames = new String[] { CiOrderDO.ID_SU_OR, CiOrderDO.SD_SU_OR, CiOrderDO.FG_SIGN,
				CiOrderDO.DT_SIGN, CiOrderDO.ID_DEP_SIGN, CiOrderDO.ID_EMP_SIGN, CiOrderDO.SD_SKINTEST_SKIP_REASON };
		FDateTime dtNow = CiOrdAppUtils.getServerDateTime();
		String id_dep = CiOrdAppUtils.getEnvContext().getDeptId();
		String id_emp = CiOrdUtils.getPsnDocID(CiOrdAppUtils.getEnvContext().getUserId());
		List<CiOrderDO> origindos = new ArrayList<CiOrderDO>();
		for (CiOrderDO order : orders) {
			origindos.add(order);

			order.setId_su_or(ICiDictCodeConst.SD_SU_ID_SIGN);
			order.setSd_su_or(ICiDictCodeConst.SD_SU_SIGN);
			order.setFg_sign(new FBoolean(true));
			order.setDt_sign(dtNow);
			order.setId_dep_sign(id_dep);
			order.setId_emp_sign(id_emp);
		}
		new DAFacade().updateDOArray(orders, arrayFieldNames);
	}

	/**
	 * 临床事件保存
	 * 
	 * @param ors
	 * @param sd_su_or
	 * @throws BizException
	 */
	private void ciEventInfoSave(CiOrderDO[] orders) throws BizException {
		// 有效性校验
		if (orders == null || orders.length == 0)
			return;
		// 医嘱事件创建保存 时机应该选择为 签署阶段
		CiOrEventsSaveBP bp = new CiOrEventsSaveBP();
		bp.exec(orders);
	}

	/**
	 * 签署时医保验证 （选择自费开立时）
	 * 
	 * @param id_orsrv
	 * @param aggors
	 */
	private void ValidataMedicalSharing(String id_orsrv, CiorderAggDO[] aggors) throws BizException {

		if (id_orsrv != null && aggors != null && aggors.length > 0) {
			List<OrdSrvDO> list = new ArrayList();
			for (CiorderAggDO orderDO : aggors) {
				for (OrdSrvDO srvdo : orderDO.getOrdSrvDO()) {
					if (id_orsrv.contains(srvdo.getId_orsrv())) {
						srvdo.setFg_selfpay(FBoolean.TRUE);
						srvdo.setStatus(DOStatus.UPDATED);
						list.add(srvdo);
					}
				}
			}
			if (list != null && list.size() > 0) {
				IOrdSrvDOCudService iordSrvDOCudService = CiOrdAppUtils.getOrSrvService();
				iordSrvDOCudService.save(list.toArray(new OrdSrvDO[list.size()]));
			}

		}
	}

	/**
	 * 临床医嘱签署时，是否调用费用域医保审核
	 * 
	 * @param id_org
	 * @return
	 */
	private boolean getOrderSignBlHpValidate(String id_org) {
		try {
			return ParamsetQryUtil.getParaBoolean(id_org, ICiOrdCustomSysParamConst.WW_ORDER_SIGN_BL_HP_VALIDATE)
					.booleanValue();
		} catch (Exception ex) {
			return true;
		}
	}

	/**
	 * 检验合管同步到执行域
	 * 
	 * @throws BizException
	 */
	private void mergeTubeSendToMp(CiEnContextDTO ctx, CiapplissheetAggDO[] lissheets) throws BizException {
		MergeTubeSendToMPBP bp = new MergeTubeSendToMPBP();
		bp.exec(ctx, lissheets);
	}
	
	/**
	 * 手术动态指标必填校验
	 * @param aggors
	 * @return
	 * @throws DAException 
	 */
	private String validateOpViewItem(CiorderAggDO[] aggors) throws DAException {
		// 如果是手术医嘱，且存在动态指标，则需要提示医生填写动态指标
		List<CiorderAggDO> opOrders = new ArrayList<CiorderAggDO>();
		for (CiorderAggDO order : aggors) {
			if (order.getParentDO().getSd_srvtp().startsWith("04")) {
				opOrders.add(order);
			}
		}
		
		if (ObjectUtils.isEmpty(opOrders)) {
			return null;
		}
		
		for (CiorderAggDO opOrder : opOrders) {
			// 查询是否已填写必填的动态指标
			StringBuilder sql = new StringBuilder();
			sql.append(" select count(*) count")
			.append(" from ci_ap_sug_viewitm viewitm")
			.append("	inner join CI_AP_SUG apsug on viewitm.ID_APOP = apsug.ID_APOP")
			.append("	inner join bd_srv_of_dyncitm bditm on viewitm.ID_SRV = bditm.ID_SRV")
			.append(" where bditm.FG_ALLOWEMPTY = 'N'")
			.append("	and apsug.ID_OR = ?")
			.append("	and (viewitm.VAL_RSTRPTLA is null or viewitm.VAL_RSTRPTLA = '');");
			
			SqlParam sqlParam = new SqlParam();
			sqlParam.addParam(opOrder.getParentDO().getId_or());
			
			Integer count = (Integer) new DAFacade().execQuery(sql.toString(), sqlParam, new ColumnHandler("count"));
			if (count > 0){
				return "【" + opOrder.getParentDO().getName_or() + "】存在动态指标未填写，请填写完整后再签署!";
			}
		}
		
		return null;
	}
}
