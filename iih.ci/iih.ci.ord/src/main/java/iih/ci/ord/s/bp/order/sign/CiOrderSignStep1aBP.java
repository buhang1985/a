package iih.ci.ord.s.bp.order.sign;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bl.cg.service.d.CgTypeEnum;
import iih.ci.ord.app.d.CiapplissheetAggDO;
import iih.ci.ord.cior.d.CiOrSessionDO;
import iih.ci.ord.cior.d.OrdApConsDO;
import iih.ci.ord.cior.d.ReactExtOrsAndStopOrsDO;
import iih.ci.ord.cior.d.ValidateRtnInfoDTO;
import iih.ci.ord.cior.i.ICiorappconsultMDORService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.dto.mergetube.d.MergeTubeRstDTO;
import iih.ci.ord.dto.mergetube.d.MergeTubeRstEnum;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.msg.CiMsgSenderUtil;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.listener.ICiEventConst;
import iih.ci.ord.s.bp.CiOrOpSessionInsertBP;
import iih.ci.ord.s.bp.CiOrSufInfo4ScAptApplBp;
import iih.ci.ord.s.bp.CiOrderRisInfoToScAptApplBp;
import iih.ci.ord.s.bp.CiOrderSignHelper;
import iih.ci.ord.s.bp.ciprn.CiprnSaveAppBtDataBP;
import iih.ci.ord.s.bp.ciprn.CiprnSaveAppBuDataBP;
import iih.ci.ord.s.bp.ciprn.CiprnSaveAppPathgyDataBP;
import iih.ci.ord.s.bp.ciprn.CiprnSaveAppRisDataBP;
import iih.ci.ord.s.bp.order.check.UpdateOrdStatusInfo1BP;
import iih.ci.ord.s.bp.order.sign.pre.UpdatePreIpOrderSignStateBP;
import iih.ci.ord.s.bp.order.sign.tl.CiOrderSignBP;
import iih.ci.ord.s.bp.order.stop.CiOrValidFgLongOrStopBP;
import iih.ci.ord.s.bp.orsms.lis.CiLisOrSmsHandlerBP;
import iih.ci.ord.s.bp.orsms.lis.ip.IpCiLisOrSmsHandlerBP;
import iih.ci.ord.s.bp.orsms.lis.mergetube.MergeTubeSendToMPBP;
import iih.ci.ord.s.bp.splitpres.CiOrPresSplitHandleBP;
import iih.ci.ord.s.ems.biz.ip.mqmsg.CiOrderExecDepMQBP;
import iih.ci.ord.s.ems.biz.ip.mqmsg.CiOrderNurseMQBP;
import iih.ci.ord.s.ems.biz.ip.mqmsg.CiOrderYnhzMQBP;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import iih.ci.ord.s.ems.utils.SysParamUtils;
import iih.ci.ord.s.utils.OpSimpleOrderSignBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/*
 * 临床医嘱的签署操作BP（Step1）
 * 
 * 更新医嘱状态、被排斥医嘱停止、
 * 门诊创建会话期间、门诊处方分方
 */
public class CiOrderSignStep1aBP {
	public static final String Hz_Code = "0902";//院内会诊服务sd_srvtp
	public static final String ID_OR= "Id_or";
	/**
	 * 临床医嘱的签署（Step1） 更新医嘱状态、被排斥医嘱停止、创建临床事件 门诊创建会话期间、门诊处方分方
	 * 
	 * @param ciors
	 * @param willstopors
	 * @param dt_cur
	 * @return
	 * @throws BizException
	 */
	public ValidateRtnInfoDTO exec(CiOrderDO[] ciors, ReactExtOrsAndStopOrsDO willstopors, FDateTime dt_cur,
			String code_entp, CiEnContextDTO ctx) throws BizException {
		ValidateRtnInfoDTO dto = new ValidateRtnInfoDTO();

		if (ciors == null || ciors.length == 0)
			return dto;

		CiEnContextDTO context = (CiEnContextDTO) Context.get().getAttribute("CiEnContextDTO");

		// 创建门诊医嘱会话区间
		CiOrOpSessionInsertBP bp3 = new CiOrOpSessionInsertBP();
		CiOrSessionDO sessiondo = bp3.exec(ciors, dt_cur);
		
		// 保存检查打印数据 仅门急诊使用,，并生成图文报告
		CiprnSaveAppRisDataBP bpRis = new CiprnSaveAppRisDataBP();
		List<CiOrderDO> imageTextOrdres = bpRis.exec(context, ciors, sessiondo);

		if(imageTextOrdres != null && imageTextOrdres.size()>0){
			List<CiOrderDO> orderList = new ArrayList<CiOrderDO>();
			for(CiOrderDO newOrder : imageTextOrdres){
				//需要单独走一下签署逻辑，需要合单、分方等操作
				if(!StringUtils.isNullOrEmpty(newOrder.getSd_srvtp())
						&&(newOrder.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)
						||newOrder.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS)
						||newOrder.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_LIS))){
					orderList.add(newOrder);
				}
			}
			if(orderList.size()>0){
				imageTextOrdres.removeAll(orderList);
				OpSimpleOrderSignBP simpleSignBP = new OpSimpleOrderSignBP();
				simpleSignBP.sign(ctx, orderList);
			}
			//如果还存在诊疗类的医嘱，继续合并到当前签署队列中一起更新医嘱状态
			if(imageTextOrdres.size()>0){
				List<CiOrderDO> orders = Arrays.asList(ciors);
				List<CiOrderDO> list = new ArrayList<CiOrderDO>();
				list.addAll(orders);
				list.addAll(imageTextOrdres);
				ciors = list.toArray(new CiOrderDO[0]);
			}
		}
		
		// 更新医嘱状态为签署
		UpdateOrdStatusInfo1BP bp1 = new UpdateOrdStatusInfo1BP();
		bp1.exec(ciors, null,null, ICiDictCodeConst.SD_SU_SIGN);

		// 排斥时，排斥的有效医嘱停止处理逻辑 仅住院
		CiOrValidFgLongOrStopBP bp2 = new CiOrValidFgLongOrStopBP();
		ArrayList<CiOrderDO> reactstopors = bp2.exec(willstopors, dt_cur);

		// //签署时，按规则自动分方 仅门急诊使用
		// PresSplitRuleArrangeBP bp4=new PresSplitRuleArrangeBP();
		// bp4.exec(ciors,sessiondo,code_entp);

		// 签署时，按规则自动分方 仅门急诊使用 新接口 可配置第三方插件
		CiOrPresSplitHandleBP bp4 = new CiOrPresSplitHandleBP();
		bp4.exec(context, ciors, sessiondo);

		// 检验合单
		CiLisOrSmsHandlerBP bp5 = new CiLisOrSmsHandlerBP();
		bp5.exec(context, ciors, sessiondo);

		// 保存病理打印数据 仅门急诊使用
		CiprnSaveAppPathgyDataBP bpPathgy = new CiprnSaveAppPathgyDataBP();
		bpPathgy.exec(ciors, sessiondo);

		// 保存备血打印数据 仅门急诊使用 02-11--玉溪住院临时修改
		CiprnSaveAppBtDataBP bpBt = new CiprnSaveAppBtDataBP();
		bpBt.exec(ctx, ciors, sessiondo);

		// 保存取血打印数据 仅门急诊使用 02-11 --玉溪住院临时修改
		CiprnSaveAppBuDataBP bpBu = new CiprnSaveAppBuDataBP();
		bpBu.exec(ctx, ciors, sessiondo);

		// 生成门诊费用清单打印数据
		if (context != null) {

			if (context.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_OP)
					|| context.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW)
					|| context.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID)) {
				// 生成保存门诊费用清单打印数据
				String[] id_ors = new String[ciors.length];
				int i = 0;
				for (CiOrderDO ciorder : ciors) {
					id_ors[i] = ciorder.getId_or();
					i++;
				}
				CiOrdAppUtils.getICiprintExtService().SaveFeeBillsData(id_ors, context.getId_hp(),
						context.getSd_hptp());

				// 高端商保记账
				// 高端商保判断是每条医嘱的金额 不能超过限制的 金额
				if (context.getSd_hptp() != null && context.getSd_hptp().startsWith("2")) {
					String id_psndoc = context.getId_emp_or();
					CiOrdAppUtils.getIBLOrderAppendBillService().SetOrderAppendBill_ByItms_ci_kljz_new(
							context.getId_en(), context.getCode_entp(), CgTypeEnum.CG_HPCG, id_psndoc);
				}
			}
		}

		CiOrdUtils.fireBDEvent(ICiEventConst.CIOR_STATUS_EVENT_SOURCEID, IEventType.TYPE_UPDATE_AFTER, ciors);
		// 给医嘱确认发送消息
		CiMsgSenderUtil.sendCiOrdConfirmMsg(ciors);

		// 发送护士站的消息提醒
		// GH 2019年2月26日 将此方法单独做成bp 因为0141480中的需求增加了 停止医嘱也需要发送消息
		CiOrderNurseMQBP nurMQBP = new CiOrderNurseMQBP();
		nurMQBP.broadcastNurseConfirmMsg(ctx, ciors);
		//判断是否是院内会诊加急的医嘱  对加急医嘱进行消息发送
		handleYnhzOrderSignInfo(ctx,ciors);
		// 返回值空判断
		if (CiOrdUtils.isEmpty(reactstopors)) {
			CiOrderSignHelper.orReactStopOrPromptRtnHandle(dto, ciors);
			return dto;
		}

		// 返回
		CiOrderSignHelper.orReactStopOrPromptRtnHandle(dto, ciors, reactstopors);
		return dto;
	}
	
	/**
	 * 住院签署状态为加急的院内会诊时 对受邀科室用户进行消息发送 
	 * @param ctx
	 * @param ciors
	 * @throws BizException 
	 */
	private void handleYnhzOrderSignInfo(CiEnContextDTO ctx, CiOrderDO[] ciors) throws BizException {
		String param = SysParamUtils.getSysParam().getSYS_PARAM_SpecantiConsRecordValue().getOrgParam();
		// param 参数值
		/*手术不发送消息        0
		手术 勾选加急标志   1
		手术全部发送       2*/
		for (CiOrderDO ciOrderDO : ciors) {
			if(Hz_Code.equals(ciOrderDO.getSd_srvtp())){
				ICiorappconsultMDORService ciorappconsultMDORService = ServiceFinder.find(ICiorappconsultMDORService.class);
				OrdApConsDO[] ordApConsDOs = ciorappconsultMDORService.findByAttrValString(ID_OR, ciOrderDO.getId_or());
				for (OrdApConsDO ordApConsDO : ordApConsDOs) {
					if(!"0".equals(param)) {
						CiOrderYnhzMQBP ciOrderYnhzMQBP = new CiOrderYnhzMQBP();
						ciOrderYnhzMQBP.broadcastYnhzConfirmMsg(ctx, ciors);
					}
				}
			}
		}
		
	}

	/**
	 * 临床医嘱的签署（Step1） 更新医嘱状态、被排斥医嘱停止、创建临床事件 门诊创建会话期间、门诊处方分方
	 * 
	 * @param ciors
	 * @param willstopors
	 * @param dt_cur
	 * @return
	 * @throws BizException
	 */
	public ValidateRtnInfoDTO exec(CiOrderDO[] ciors, ReactExtOrsAndStopOrsDO willstopors, FDateTime dt_cur,
			CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		ValidateRtnInfoDTO dto = new ValidateRtnInfoDTO();

		if (ciors == null || ciors.length == 0)
			return dto;

		CiEnContextDTO context = (CiEnContextDTO) Context.get().getAttribute("CiEnContextDTO");
		// 创建门诊医嘱会话区间
		CiOrOpSessionInsertBP bp3 = new CiOrOpSessionInsertBP();
		CiOrSessionDO sessiondo = bp3.exec(ciors, dt_cur);

		CiLisOrSmsHandlerBP bpLis = new IpCiLisOrSmsHandlerBP();
		FMap2 emsExtensionMap2 = arg.getExtension();
		MergeTubeRstDTO mergeTubeRstDTO;
		if (emsExtensionMap2 != null && emsExtensionMap2.containsKey("MergeTubeRstDTO")) {
			mergeTubeRstDTO = (MergeTubeRstDTO) emsExtensionMap2.get("MergeTubeRstDTO");
			mergeTubeRstDTO = bpLis.exec(ctx, mergeTubeRstDTO);
		} else {
			mergeTubeRstDTO = bpLis.megeTube(ctx, ciors, sessiondo);
			if (mergeTubeRstDTO != null && MergeTubeRstEnum.FAIL.equals(mergeTubeRstDTO.getRstStatus())) {
				ValidateRtnInfoDTO rtn = new ValidateRtnInfoDTO();
				FMap2 rstMap2 = new FMap2();
				// 返回前台
				rstMap2.put("Fail", FBoolean.FALSE);
				rstMap2.put("MergeTubeRstDTO", mergeTubeRstDTO);
				rtn.setRtnvalue(rstMap2);
				return rtn;
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
		
		// 保存检查打印数据 仅门急诊使用,，并生成图文报告
		CiprnSaveAppRisDataBP bpRis = new CiprnSaveAppRisDataBP();
		List<CiOrderDO> imageTextOrdres = bpRis.exec(context, ciors, sessiondo);

		if(imageTextOrdres != null && imageTextOrdres.size()>0){
			List<CiOrderDO> orderList = new ArrayList<CiOrderDO>();
			for(CiOrderDO newOrder : imageTextOrdres){
				//需要单独走一下签署逻辑，需要合单、分方等操作
				if(!StringUtils.isNullOrEmpty(newOrder.getSd_srvtp())
						&&(newOrder.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)
						||newOrder.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS)
						||newOrder.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_LIS))){
					orderList.add(newOrder);
				}
			}
			if(orderList.size()>0){
				imageTextOrdres.removeAll(orderList);
				//TODO 调用住院签署,增加住院简易签署逻辑
//				OpSimpleOrderSignBP simpleSignBP = new OpSimpleOrderSignBP();
//				simpleSignBP.sign(ctx, orderList);
				CiOrderSignBP ciOrderSignBP = new CiOrderSignBP();
				String[] id_ors=new String[orderList.size()];
				for(int i=0;i<orderList.size();i++) {
					if(orderList.get(i)!=null) {
						id_ors[i]=orderList.get(i).getId_or();
					}
				}
				ciOrderSignBP.execSimple(id_ors, ctx, false, new OrderOperateDTO());
			}
			//如果还存在诊疗类的医嘱，继续合并到当前签署队列中一起更新医嘱状态
			if(imageTextOrdres.size()>0){
				List<CiOrderDO> orders = Arrays.asList(ciors);
				List<CiOrderDO> list = new ArrayList<CiOrderDO>();
				list.addAll(orders);
				list.addAll(imageTextOrdres);
				ciors = list.toArray(new CiOrderDO[0]);
			}
		}		
		
		// 更新医嘱状态为签署，预住院申请导入成医嘱时签署单独处理
		if (arg.getExtension() != null && arg.getExtension().containsKey("preImportAutoSign")) {
			UpdatePreIpOrderSignStateBP bp = new UpdatePreIpOrderSignStateBP();
			bp.exec(ctx, ciors, arg);
		} else {
		UpdateOrdStatusInfo1BP bp1 = new UpdateOrdStatusInfo1BP();
		bp1.exec(ciors, null,null, ICiDictCodeConst.SD_SU_SIGN);
		}
		// 排斥时，排斥的有效医嘱停止处理逻辑 仅住院
		CiOrValidFgLongOrStopBP bp2 = new CiOrValidFgLongOrStopBP();
		ArrayList<CiOrderDO> reactstopors = bp2.exec(willstopors, dt_cur);

		// //签署时，按规则自动分方 仅门急诊使用
		// PresSplitRuleArrangeBP bp4=new PresSplitRuleArrangeBP();
		// bp4.exec(ciors,sessiondo,code_entp);

		// 签署时，按规则自动分方 仅门急诊使用 新接口 可配置第三方插件
		CiOrPresSplitHandleBP bp4 = new CiOrPresSplitHandleBP();
		bp4.exec(context, ciors, sessiondo);

//		// 检验合单
//		CiLisOrSmsHandlerBP bp5 = new CiLisOrSmsHandlerBP();
//		bp5.exec(context, ciors, sessiondo);

		// 保存检查打印数据 仅门急诊使用
//		CiprnSaveAppRisDataBP bpRis = new CiprnSaveAppRisDataBP();
//		bpRis.exec(context, ciors, sessiondo);

		// 保存病理打印数据 仅门急诊使用
		CiprnSaveAppPathgyDataBP bpPathgy = new CiprnSaveAppPathgyDataBP();
		bpPathgy.exec(ciors, sessiondo);

		// 保存备血打印数据 仅门急诊使用 02-11--玉溪住院临时修改
		CiprnSaveAppBtDataBP bpBt = new CiprnSaveAppBtDataBP();
		bpBt.exec(ctx, ciors, sessiondo);

		// 保存取血打印数据 仅门急诊使用 02-11 --玉溪住院临时修改
		CiprnSaveAppBuDataBP bpBu = new CiprnSaveAppBuDataBP();
		bpBu.exec(ctx, ciors, sessiondo);

		// 生成门诊费用清单打印数据
		if (context != null) {

			if (context.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_OP)
					|| context.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW)
					|| context.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID)) {
				// 生成保存门诊费用清单打印数据
				String[] id_ors = new String[ciors.length];
				int i = 0;
				for (CiOrderDO ciorder : ciors) {
					id_ors[i] = ciorder.getId_or();
					i++;
				}
				CiOrdAppUtils.getICiprintExtService().SaveFeeBillsData(id_ors, context.getId_hp(),
						context.getSd_hptp());

				// 高端商保记账
				// 高端商保判断是每条医嘱的金额 不能超过限制的 金额
				if (context.getSd_hptp() != null && context.getSd_hptp().startsWith("2")) {
					String id_psndoc = context.getId_emp_or();
					CiOrdAppUtils.getIBLOrderAppendBillService().SetOrderAppendBill_ByItms_ci_kljz_new(
							context.getId_en(), context.getCode_entp(), CgTypeEnum.CG_HPCG, id_psndoc);
				}
			}
		}

		CiOrdUtils.fireBDEvent(ICiEventConst.CIOR_STATUS_EVENT_SOURCEID, IEventType.TYPE_UPDATE_AFTER, ciors);
		// 给医嘱确认发送消息
		CiMsgSenderUtil.sendCiOrdConfirmMsg(ciors);

		// 发送护士站的消息提醒
		// GH 2019年2月26日 将此方法单独做成bp 因为0141480中的需求增加了 停止医嘱也需要发送消息
		CiOrderNurseMQBP nurMQBP = new CiOrderNurseMQBP();
		nurMQBP.broadcastNurseConfirmMsg(ctx, ciors);
		//判断是否是院内会诊加急的医嘱  对加急医嘱进行消息发送
		
		
			handleYnhzOrderSignInfo(ctx,ciors);
		//调用预约
		callAppointment(ciors,ctx);
		// 返回值空判断
		if (CiOrdUtils.isEmpty(reactstopors)) {
			CiOrderSignHelper.orReactStopOrPromptRtnHandle(dto, ciors);
			return dto;
		}

		// 返回
		CiOrderSignHelper.orReactStopOrPromptRtnHandle(dto, ciors, reactstopors);
		return dto;
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
	 * 调用预约接口
	 * 
	 * @throws BizException
	 */
	private void callAppointment(CiOrderDO[] ciors,CiEnContextDTO ctx) throws BizException{
		String cfgParam = ParamsetQryUtil.getParaString(Context.get().getOrgId(), "CIOR0821");
		if("1".equals(cfgParam)){
			OrdBizLogger.info(null, "调用预约接口向预约发送手术申请数据");
			//调用预约接口向预约发送手术申请数据
			CiOrSufInfo4ScAptApplBp bp = new CiOrSufInfo4ScAptApplBp();
			bp.sendSugInfo4ScAptAppl(ciors);
			//调用接口向手术执行科室发送消息
			CiOrderExecDepMQBP ordExecDepMQBP = new CiOrderExecDepMQBP();
			ordExecDepMQBP.broadcastOrderListViewMsg(ctx, ciors);
			//医技预约
			CiOrderRisInfoToScAptApplBp risScBp = new CiOrderRisInfoToScAptApplBp();
			risScBp.sendCiOrderRisInfoToScAptAppl(ciors,null);
		}
	}
}
