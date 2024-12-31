package iih.ci.ord.s.bp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.event.pub.ICiIEEventConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciordems.d.OrConfirm;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.RefuseCheckTp;
import iih.ci.ord.dto.ordercheckdto.CheckConfirmRstDTO;
import iih.ci.ord.i.ICiOrdLogService;
import iih.ci.ord.i.mqmsg.meta.NurseCheckRefusedMsgDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.listener.ICiEventConst;
import iih.ci.ord.s.bp.event.FireOrNsCheckEvent4IeBP;
import iih.ci.ord.s.bp.exception.CiOrOperatorCheckException;
import iih.ci.ord.s.bp.order.check.UpdateOrdStatusInfo1BP;
import iih.ci.ord.s.bp.validate.CiOrConfirmValidateBP;
import iih.ci.ord.s.bp.validate.MethodConstants;
import iih.ci.ord.s.ems.cache.BDDeptInfoCache;
import iih.ci.ord.s.ems.meta.StringList;
import iih.mp.ot.i.external.provide.IMpOtCiService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.log.logging.Level;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.message.message.i.IGenerateMessageExtdService;

/**
 * 医嘱确认操作，包含拒绝确认，发送消息等功能
 * 
 * @author zhanwq
 *
 */
public class OrConfirmBP {
	Hashtable<String, Hashtable<String, String>> htors8ieevent = new Hashtable<String, Hashtable<String, String>>();
	Hashtable<String, String> htor = new Hashtable<String, String>();

	public String exec(OrConfirm[] orConfirms) throws BizException {
		List<String> refuseIdList = new ArrayList<String>();
		List<String> idList = new ArrayList<String>();
		// 签署拒绝
		List<CiOrderDO> signRefuseOrdList = new ArrayList<CiOrderDO>();
		// 停止拒绝
		List<CiOrderDO> stopRefuseOrdList = new ArrayList<CiOrderDO>();
		// 作废拒绝
		List<CiOrderDO> cancRefuseOrdList = new ArrayList<CiOrderDO>();
		// 签署核对
		List<CiOrderDO> signOrdList = new ArrayList<CiOrderDO>();
		// 停止核对
		List<CiOrderDO> stopOrdList = new ArrayList<CiOrderDO>();
		// 作废核对
		List<CiOrderDO> cancOrdList = new ArrayList<CiOrderDO>();
		for (OrConfirm item : orConfirms) {
			if (item.getOpst() == 2) {
				refuseIdList.add(item.getId_confirm());
			}
			idList.add(item.getId_confirm());
		}
		CiOrderDO[] ciorders = getCiOrderDOs(idList);
		FDateTime dt_refuse = CiOrdAppUtils.getServerDateTime();
		String nurseRefusedMsg = String.format("【%s】护士于【%s】时间，", getPsndocName(Context.get().getUserId()),
				dt_refuse.toStdString());
		//List<CiOrderDO> RisAppList = new ArrayList<CiOrderDO>();
		//List<CiOrderDO> CancRisAppList = new ArrayList<CiOrderDO>();
		for (CiOrderDO order : ciorders) {
			// 签署确认
			if (FBoolean.TRUE.equals(order.getFg_sign()) && FBoolean.FALSE.equals(order.getFg_chk())) {
				if (refuseIdList.contains(order.getId_or())) {
					order.setEu_refusechecktp(RefuseCheckTp.REFUSE_SIGN_CHECK);
					order.setFg_refusecheck(FBoolean.TRUE);
					order.setId_emp_refusecheck(Context.get().getUserDataSource());
					order.setDt_refusecheck(dt_refuse);
					order.setError_level("Z");
					order.setError_des(nurseRefusedMsg + "拒绝医嘱核对确认！");
					signRefuseOrdList.add(order);
				} else {
					signOrdList.add(order);
					//if(order.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS) && order.getSd_srvtp() != IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI) {
					//	RisAppList.add(order);
					//}
				}
			} else if (FBoolean.TRUE.equals(order.getFg_chk()) &&FBoolean.TRUE.equals( order.getFg_stop())
					&& FBoolean.FALSE.equals(order.getFg_chk_stop()) && FBoolean.FALSE.equals(order.getFg_canc())) {
				// 停止核对
				if (refuseIdList.contains(order.getId_or())) {
					order.setEu_refusechecktp(RefuseCheckTp.REFUSE_STOP_CHECK);
					order.setFg_refusecheck(FBoolean.TRUE);
					order.setId_emp_refusecheck(Context.get().getStuffId());
					order.setDt_refusecheck(dt_refuse);
					order.setError_level("Z");
					order.setError_des(nurseRefusedMsg + "拒绝医嘱停止核对！");
					stopRefuseOrdList.add(order);
				} else {
					stopOrdList.add(order);
				}
			} else if (FBoolean.TRUE.equals(order.getFg_canc()) && FBoolean.FALSE.equals(order.getFg_chk_canc())) {
				// 作废核对
				if (refuseIdList.contains(order.getId_or())) {
					order.setEu_refusechecktp(RefuseCheckTp.REFUSE_CANC_CHECK);
					order.setFg_refusecheck(FBoolean.TRUE);
					order.setId_emp_refusecheck(Context.get().getStuffId());
					order.setDt_refusecheck(dt_refuse);
					order.setError_level("Z");
					order.setError_des(nurseRefusedMsg + "拒绝医嘱作废核对！");
					cancRefuseOrdList.add(order);
				} else {
					cancOrdList.add(order);
					//if(order.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS) && order.getSd_srvtp() != IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI) {
					//	CancRisAppList.add(order);
					//}
				}
			}
		}
		//预约
		//setRisApp(RisAppList);
		// 调用预约接口向预约发送删除的手术信息
		//CiOrderDO[] ciors = (CiOrderDO[]) CancRisAppList.toArray(new CiOrderDO[CancRisAppList.size()]);
		//CiOrSufInfo4ScAptApplBp sufInfo4ScAptApplBp = new CiOrSufInfo4ScAptApplBp();
		//sufInfo4ScAptApplBp.sendSugInfo4ScAptAppl(null, ciors);
		// 确认操作
		ciOrderCheck(signOrdList);
		this.ciOrderStopChk(stopOrdList);
		this.ciOrderCancChk(cancOrdList);
		CiOrderDO[] rtn = mergeChkOrds(signOrdList, cancOrdList, stopOrdList);
		// 发送集成平台
		fireEvent4Ie8Pv(htors8ieevent, htor);
		CiOrdUtils.fireBDEvent(ICiEventConst.CIOR_STATUS_EVENT_SOURCEID, IEventType.TYPE_UPDATE_AFTER, rtn);
		// 拒绝确认操作
		CiOrderDO[] refOrders = mergeChkOrds(signRefuseOrdList, cancRefuseOrdList, stopRefuseOrdList);
		refuseOperate(refOrders);

		// 发送广播消息
		if (orConfirms != null && orConfirms.length > 0 && refOrders != null && refOrders.length > 0) {
			broadcastRefusedNoticeMsg(orConfirms[0].getCode_bed(), orConfirms[0].getName_pat(), refOrders);
		}

		//
		return "";
	}

	protected void broadcastRefusedNoticeMsg(String code_bed, String name_pat, CiOrderDO[] refOrders)
			throws BizException {
		// 组织消息参数
		Map<String, Object> msgMap = new HashMap<String, Object>();
		List<NurseCheckRefusedMsgDTO> msgList = new ArrayList<NurseCheckRefusedMsgDTO>();
		for (CiOrderDO orderInfo : refOrders) {
			NurseCheckRefusedMsgDTO msgInfo = new NurseCheckRefusedMsgDTO();
			msgInfo.setCode_or(orderInfo.getCode_or());
			msgInfo.setName_or(orderInfo.getName_or());
			msgInfo.setEu_refusechecktp(orderInfo.getEu_refusechecktp());
			msgInfo.setName_dep_ns(BDDeptInfoCache.GetNameOfBDeptInfo(orderInfo.getId_dep_ns()));
			msgInfo.setCode_bed(code_bed);
			msgInfo.setName_pat(name_pat);
			msgInfo.setId_dep_or(orderInfo.getId_dep_or());
			msgInfo.setName_dep_or(BDDeptInfoCache.GetNameOfBDeptInfo(orderInfo.getId_dep_or()));
			msgInfo.setId_emp_or(orderInfo.getId_emp_or());
			msgList.add(msgInfo);
		}
		msgMap.put("CIS_MSG_NURSECHECK_REFUSED", msgList);

		IGenerateMessageExtdService msgService = ServiceFinder.find(IGenerateMessageExtdService.class);
		// 此处调用方法，为Map参数，因此在后台接收，也应该实现Map参数的接口方法
		msgService.GenerateMessageAndMap("CIS_MSG_NURSECHECK_REFUSED", msgMap, null);
	}

	/**
	 * 医技补录医嘱后医嘱确认逻辑
	 * 
	 * @param szOrderInfo
	 * @return
	 * @throws BizException
	 */
	public String runMtOrderSignConfirm(CiOrderDO[] szOrderInfo) throws BizException {
		// if(szOrderInfo == null || szOrderInfo.length == 0){
		// return null;
		// }
		// try{
		// StringList idList = new StringList();
		// for(CiOrderDO ord : szOrderInfo){
		// idList.add(ord.getId_or());
		// }
		// CiOrderDO[] ciorders = getCiOrderDOs(idList);
		// //确认操作
		// ciOrderCheck(Arrays.asList(ciorders));
		//
		// //发送集成平台
		// fireEvent4Ie8Pv(htors8ieevent,htor);
		//
		// //发送医嘱确认更新数据库后置事件
		// CiOrdUtils.fireBDEvent(ICiEventConst.CIOR_STATUS_EVENT_SOURCEID,IEventType.TYPE_UPDATE_AFTER,szOrderInfo);
		//
		// //TODO:调用执行接口（吴浩提供）
		// IMpOtCiService mpService = ServiceFinder.find(IMpOtCiService.class);
		// if(mpService != null){
		// mpService.otExecConfirm(idList.asArray());
		// }
		// }
		// catch(Exception e){
		// return e.getMessage();
		// }

		return null;
	}

	/**
	 * 医技医嘱作废确认
	 * 
	 * @param szOrderInfo
	 * @return
	 * @throws BizException
	 */
	public String runMtOrderCancelConfirm(CiOrderDO[] szOrderInfo) throws BizException {
		// if(szOrderInfo == null || szOrderInfo.length == 0){
		// return null;
		// }
		// try{
		// StringList idList = new StringList();
		// for(CiOrderDO ord : szOrderInfo){
		// idList.add(ord.getId_or());
		// }
		// CiOrderDO[] ciorders = getCiOrderDOs(idList);
		// //确认操作
		// ciOrderCancChk(Arrays.asList(ciorders));
		//
		// //发送集成平台
		// fireEvent4Ie8Pv(htors8ieevent,htor);
		//
		// //发送医嘱确认更新数据库后置事件
		// CiOrdUtils.fireBDEvent(ICiEventConst.CIOR_STATUS_EVENT_SOURCEID,IEventType.TYPE_UPDATE_AFTER,szOrderInfo);
		//
		// //TODO:调用执行接口（吴浩提供）
		// IMpOtCiService mpService = ServiceFinder.find(IMpOtCiService.class);
		// if(mpService != null){
		// mpService.otExecCancel(idList.asArray());
		// }
		// }
		// catch(Exception e){
		// return e.getMessage();
		// }

		return null;
	}

	/**
	 * 护嘱确认逻辑
	 * 
	 * @param szOrderInfo
	 * @return
	 * @throws BizException
	 */
	public String runNurOrderSignConfirm(CiOrderDO[] szOrderInfo) throws BizException {
		if (szOrderInfo == null || szOrderInfo.length == 0) {
			return null;
		}
		try {
			StringList idList = new StringList();
			for (CiOrderDO ord : szOrderInfo) {
				idList.add(ord.getId_or());
			}
			CiOrderDO[] ciorders = getCiOrderDOs(idList);
			// 确认操作
			ciNursOrderCheck(Arrays.asList(ciorders));

			// 发送集成平台
			fireEvent4Ie8Pv(htors8ieevent, htor);

			// 发送医嘱确认更新数据库后置事件
			CiOrdUtils.fireBDEvent(ICiEventConst.CIOR_STATUS_EVENT_SOURCEID, IEventType.TYPE_UPDATE_AFTER, ciorders);

			// TODO:调用执行接口（吴浩提供）
//			IMpOtCiService mpService = ServiceFinder.find(IMpOtCiService.class);
//			if (mpService != null) {
//				mpService.otExecConfirm(idList.asArray());
//			}
		} catch (Exception e) {
			return e.getMessage();
		}

		return null;
	}

	/**
	 * 护嘱作废确认
	 * 
	 * @param szOrderInfo
	 * @return
	 * @throws BizException
	 */
	public String runNurOrderCancelConfirm(CiOrderDO[] szOrderInfo) throws BizException {
		if (szOrderInfo == null || szOrderInfo.length == 0) {
			return null;
		}
		try {
			StringList idList = new StringList();
			for (CiOrderDO ord : szOrderInfo) {
				idList.add(ord.getId_or());
			}
			CiOrderDO[] ciorders = getCiOrderDOs(idList);
			// 确认操作
			nurCiOrderCancChk(Arrays.asList(ciorders));

			// 发送集成平台
			fireEvent4Ie8Pv(htors8ieevent, htor);

			// 发送医嘱确认更新数据库后置事件
			CiOrdUtils.fireBDEvent(ICiEventConst.CIOR_STATUS_EVENT_SOURCEID, IEventType.TYPE_UPDATE_AFTER, ciorders);
			if (ciorders != null && ciorders.length > 0) {
				idList = new StringList();
				for (CiOrderDO ord : ciorders) {
					idList.add(ord.getId_or());
				}
				// 执行域响应作废操作，处理执行计划
				CiOrdAppUtils.getIResponseOrderHandelService().responseOrInvalid(idList.asArray());
				// TODO:调用执行接口（吴浩提供）
//				IMpOtCiService mpService = ServiceFinder.find(IMpOtCiService.class);
//				if (mpService != null) {
//					mpService.otExecCancel(idList.asArray());
//				}
			}

		} catch (Exception e) {
			return e.getMessage();
		}

		return null;
	}

	/**
	 * 护嘱停止确认
	 * 
	 * @param szOrderInfo
	 * @return
	 * @throws BizException
	 */
	public String runNurOrderStopConfirm(CiOrderDO[] szOrderInfo) throws BizException {
		ICiOrdLogService logService = ServiceFinder.find(ICiOrdLogService.class);
		logService.log("=============护嘱停止确认入口==============", Level.ERROR);
		if (szOrderInfo == null || szOrderInfo.length == 0) {
			return null;
		}
		logService.log("=============护嘱停止确认患者信息==============患者：" + szOrderInfo[0].getId_pat() + "科室:"
				+ szOrderInfo[0].getId_dep_or(), Level.ERROR);
		StringList idList = new StringList();
		Map<String, CiOrderDO> sourceOrders = new HashMap<String, CiOrderDO>();
		for (CiOrderDO ord : szOrderInfo) {
			idList.add(ord.getId_or());
			sourceOrders.put(ord.getId_or(), ord);
		}
		CiOrderDO[] ciorders = getCiOrderDOs(idList);
		// 处理停止时间和停止人
		handelStopInfo(ciorders, sourceOrders);
		// 确认操作
		ciOrderStopChk(Arrays.asList(ciorders));

		// 发送集成平台
		fireEvent4Ie8Pv(htors8ieevent, htor);
		logService.log("=============护嘱停止确认的医嘱数量==============" + ciorders.length, Level.ERROR);
		if (ciorders != null && ciorders.length > 0) {
			idList = new StringList();
			for (CiOrderDO ord : ciorders) {
				idList.add(ord.getId_or());
			}
			logService.log("=============护嘱停止确认调用执行域的医嘱==============" + idList.toStringWithNO(1), Level.ERROR);
			// 执行域响应停止操作，处理执行计划
			CiOrdAppUtils.getIResponseOrderHandelService().responseOrStop(idList.asArray());
		}
		// 发送医嘱确认更新数据库后置事件
		CiOrdUtils.fireBDEvent(ICiEventConst.CIOR_STATUS_EVENT_SOURCEID, IEventType.TYPE_UPDATE_AFTER, ciorders);
		logService.log("=============护嘱停止确认出口==============", Level.ERROR);
		return null;
	}

	/**
	 * 拒绝确认操作
	 * 
	 * @param ciOrders
	 * @throws BizException
	 */
	private void refuseOperate(CiOrderDO[] ciOrders) throws BizException {
		if (ciOrders != null && ciOrders.length > 0) {
			// 更新状态
			CiOrdAppUtils.getOrService().update(ciOrders);
			// 发送事件，待实现
		}
	}

	/**
	 * 合并集合
	 * 
	 * @param OrdList
	 * @return
	 */
	private CiOrderDO[] mergeChkOrds(List<CiOrderDO>... OrdList) {
		List<CiOrderDO> rtns = new ArrayList<CiOrderDO>();
		for (int i = 0; i < OrdList.length; i++) {
			if (OrdList[i] != null && OrdList[i].size() > 0) {
				rtns.addAll(OrdList[i]);
			}
		}
		return rtns.toArray(new CiOrderDO[0]);
	}

	/**
	 * 获得医嘱信息
	 * 
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	protected CiOrderDO[] getCiOrderDOs(List<String> idors) throws BizException {
		if (idors == null || idors.size() == 0) {
			return null;
		}
		return CiOrdAppUtils.getOrQryService().findByBIds(idors.toArray(new String[0]), FBoolean.FALSE);
	}

	/**
	 * 签署确认
	 * 
	 * @param ciorders
	 * @throws BizException
	 */
	protected void ciOrderCheck(List<CiOrderDO> ciorders) throws BizException {
		if (ciorders == null || ciorders.size() == 0) {
			return;
		}
		CiOrConfirmValidateBP validate = new CiOrConfirmValidateBP();
		CheckConfirmRstDTO checkRstDTO = validate.exec(ciorders.toArray(new CiOrderDO[0]), MethodConstants.CHECK_VALIDATE);
		if (!checkRstDTO.isSuccessful()) {
			throw new CiOrOperatorCheckException(checkRstDTO.getErrorMessage());
		}
		// 医嘱状态调整为停止
		UpdateOrdStatusInfo1BP bp1 = new UpdateOrdStatusInfo1BP();
		bp1.exec(ciorders.toArray(new CiOrderDO[0]), null,null, ICiDictCodeConst.SD_SU_CHECKTHROUGH);
		for (CiOrderDO ciOrderDO : ciorders) {
			orGrpHandle4IeEvent(htors8ieevent, ciOrderDO, false, "0", htor);// 2016-08-19
																			// 集成平台事件新增逻辑
		}
	}
	/**
	 * 签署确认
	 * 
	 * @param ciorders
	 * @throws BizException
	 */
	protected void ciNursOrderCheck(List<CiOrderDO> ciorders) throws BizException {
		if (ciorders == null || ciorders.size() == 0) {
			return;
		}
		// 医嘱状态调整为停止
		UpdateOrdStatusInfo1BP bp1 = new UpdateOrdStatusInfo1BP();
		bp1.exec(ciorders.toArray(new CiOrderDO[0]), null,null, ICiDictCodeConst.SD_SU_CHECKTHROUGH);
		for (CiOrderDO ciOrderDO : ciorders) {
			orGrpHandle4IeEvent(htors8ieevent, ciOrderDO, false, "0", htor);// 2016-08-19
																			// 集成平台事件新增逻辑
		}
	}

	/**
	 * 作废确认
	 * 
	 * @param ciorders
	 * @throws BizException
	 */
	private void ciOrderCancChk(List<CiOrderDO> ciorders) throws BizException {
		if (ciorders == null || ciorders.size() == 0) {
			return;
		}
		CiOrConfirmValidateBP validate = new CiOrConfirmValidateBP();
		CheckConfirmRstDTO checkRstDTO = validate.exec(ciorders.toArray(new CiOrderDO[0]), MethodConstants.CHECK_VALIDATE);
		if (!checkRstDTO.isSuccessful()) {
			throw new CiOrOperatorCheckException(checkRstDTO.getErrorMessage());
		}

		CiOrMpRtnDrug4StopCanc2BP bp = new CiOrMpRtnDrug4StopCanc2BP();
		bp.execCanc(getCancelMap(ciorders.toArray(new CiOrderDO[0])));
		// 医嘱状态调整为作废核对
		UpdateOrdStatusInfo1BP bp1 = new UpdateOrdStatusInfo1BP();
		bp1.exec(ciorders.toArray(new CiOrderDO[0]), null,null, ICiDictCodeConst.SD_SU_CHECKCANCEL);
		for (CiOrderDO ciOrderDO : ciorders) {
			orGrpHandle4IeEvent(htors8ieevent, ciOrderDO, true, "1", htor);// 2016-08-19
																			// 集成平台事件新增逻辑
		}
	}

	/**
	 * 护嘱作废确认
	 * 
	 * @param ciorders
	 * @throws BizException
	 */
	private void nurCiOrderCancChk(List<CiOrderDO> ciorders) throws BizException {
		if (ciorders == null || ciorders.size() == 0) {
			return;
		}
		CiOrConfirmValidateBP validate = new CiOrConfirmValidateBP();
		CiOrderDO[] cidos = validate.nurCancelChkValidate(ciorders);
		if (cidos == null || cidos.length == 0) {
			return;
		}

		CiOrMpRtnDrug4StopCanc2BP bp = new CiOrMpRtnDrug4StopCanc2BP();
		bp.execCanc(getCancelMap(cidos));
		// 医嘱状态调整为作废核对
		UpdateOrdStatusInfo1BP bp1 = new UpdateOrdStatusInfo1BP();
		bp1.exec(cidos, null,null, ICiDictCodeConst.SD_SU_CHECKCANCEL);
		for (CiOrderDO ciOrderDO : cidos) {
			orGrpHandle4IeEvent(htors8ieevent, ciOrderDO, true, "1", htor);// 2016-08-19
																			// 集成平台事件新增逻辑
		}
	}

	/**
	 * 停止核对
	 * 
	 * @param ciorders
	 * @throws BizException
	 */
	private void ciOrderStopChk(List<CiOrderDO> ciorders) throws BizException {
		if (ciorders == null || ciorders.size() == 0) {
			return;
		}
		CiOrConfirmValidateBP validate = new CiOrConfirmValidateBP();
		CiOrderDO[] cidos = validate.nurStopChkValidate(ciorders);
		if (cidos == null || cidos.length == 0) {
			return;
		}
		CiOrMpRtnDrug4StopCanc2BP bp = new CiOrMpRtnDrug4StopCanc2BP();
		bp.execStop(getStopMap(cidos));
		// 停止操作,护嘱没有界面进行停止确认，所以直接把状态改为停止和停止确认
		nurOrderStopChk(cidos);
		for (CiOrderDO ciOrderDO : cidos) {
			orGrpHandle4IeEvent(htors8ieevent, ciOrderDO, true, "2", htor);// 2016-08-19
																			// 集成平台事件新增逻辑
		}

	}

	/**
	 * 缓存作废时间
	 * 
	 * @param ciors
	 * @return
	 * @throws BizException
	 */
	private FMap getCancelMap(CiOrderDO[] ciors) throws BizException {
		FMap m = new FMap();
		for (CiOrderDO ciOrderDO : ciors) {
			if (ciOrderDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG))
				m.put(ciOrderDO.getId_or(), ciOrderDO.getDt_canc());
		}

		return m;
	}

	/**
	 * 缓存停止时间
	 * 
	 * @param ciors
	 * @return
	 * @throws BizException
	 */
	private FMap getStopMap(CiOrderDO[] ciors) throws BizException {
		FMap m = new FMap();

		for (CiOrderDO ciOrderDO : ciors) {
			if (ciOrderDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG))
				m.put(ciOrderDO.getId_or(), ciOrderDO.getDt_end());
		}

		return m;
	}

	/**
	 * 医嘱数据组织
	 * 
	 * @param ht
	 * @param or
	 * @param iscancStp
	 */
	private void orGrpHandle4IeEvent(Hashtable<String, Hashtable<String, String>> ht, CiOrderDO or, boolean iscancStp,
			String signStr, Hashtable<String, String> htor) {
		String ieeventtype = "";

		// 事件类型获得
		if (iscancStp) {
			ieeventtype = ICiIEEventConst.EVENT_IE_CIOR_NSCHK_CANC_STOP;
		} else {
			ieeventtype = CiOrdUtils.getIeEventTypeStr(or.getSd_srvtp());
		}

		// 就诊数据组织
		if (!htor.containsKey(or.getId_en())) {
			htor.put(or.getId_en(), signStr + or.getId_or());
		}

		// 医嘱数据组织
		orGrpHandle4IeEvent(ht, or, ieeventtype);
	}

	/**
	 * 医嘱数据组织
	 * 
	 * @param ht
	 * @param or
	 */
	private void orGrpHandle4IeEvent(Hashtable<String, Hashtable<String, String>> ht, CiOrderDO or,
			String ieeventtype) {
		// 有效性校验
		if (CiOrdUtils.isEmpty(ieeventtype))
			return;
		String id_en = or.getId_en();
		if (ht.containsKey(id_en)) {
			Hashtable<String, String> ht0 = ht.get(id_en);
			htEventTypeHandle(ieeventtype, ht0, or);
			ht.put(id_en, ht0);
		} else {
			Hashtable<String, String> ht0 = new Hashtable<String, String>();
			htEventTypeHandle(ieeventtype, ht0, or);
			ht.put(id_en, ht0);
		}

	}

	/**
	 * 按事件类型处理逻辑
	 * 
	 * @param ieeventtype
	 * @param ht
	 * @param or
	 */
	private void htEventTypeHandle(String ieeventtype, Hashtable<String, String> ht, CiOrderDO or) {
		if (ht.containsKey(ieeventtype)) {
			String ors = ht.get(ieeventtype) + CiOrdUtils.COMMA_STR + or.getId_or();
			ht.put(ieeventtype, ors);
		} else {
			ht.put(ieeventtype, or.getId_or());
		}
	}

	/**
	 * 触发事件 集成平台事件
	 * 
	 * @param id_sign_ors
	 * @param id_canc_ors
	 * @param id_stop_ors
	 * @throws BizException
	 */
	private void fireEvent4Ie8Pv(Hashtable<String, Hashtable<String, String>> htors8ieevent,
			Hashtable<String, String> htor) throws BizException {
		// 有效性校验
		if (CiOrdUtils.isEmpty(htors8ieevent))
			return;

		// 参数设置
		Enumeration<String> en1 = htors8ieevent.keys();
		String key = "";

		// 遍历
		while (en1.hasMoreElements()) {
			key = en1.nextElement();
			fireEvent4Ie(htors8ieevent.get(key), htor.get(key));
		}
	}

	/**
	 * 触发事件 集成平台事件
	 * 
	 * @param id_sign_ors
	 * @param id_canc_ors
	 * @param id_stop_ors
	 * @throws BizException
	 */
	private void fireEvent4Ie(Hashtable<String, String> htors8ieevent, String id_or) throws BizException {
		FireOrNsCheckEvent4IeBP bp = new FireOrNsCheckEvent4IeBP();
		bp.exec(htors8ieevent, id_or);
	}

	/**
	 * 
	 * @param userid
	 * @return
	 * @throws BizException
	 */
	private String getPsndocName(String userid) throws BizException {
		if (StringUtils.isBlank(userid))
			return "";
		StringBuffer sb = new StringBuffer();
		sb.append(" select bd_psndoc.name from sys_user ,bd_psndoc");
		sb.append(" where sys_user.id_psn = bd_psndoc.id_psndoc ");
		sb.append(" and sys_user.id_user='").append(userid).append("'");
		DAFacade dafacade = new DAFacade();
		List<String> list = (List<String>) dafacade.execQuery(sb.toString(), new ColumnListHandler());
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return "";
	}

	/**
	 * 护嘱的停止信息赋值
	 * 
	 * @param ciOrders
	 * @param sourceOrders
	 */
	private void handelStopInfo(CiOrderDO[] ciOrders, Map<String, CiOrderDO> sourceOrders) {
		for (int i = ciOrders.length - 1; i >= 0; i--) {
			if (sourceOrders.containsKey(ciOrders[i].getId_or())) {
				if (FBoolean.FALSE.equals(ciOrders[i].getFg_stop())) {
					ciOrders[i].setDt_end(sourceOrders.get(ciOrders[i].getId_or()).getDt_end());
					ciOrders[i].setId_emp_stop(sourceOrders.get(ciOrders[i].getId_or()).getId_emp_stop());
					ciOrders[i].setId_dep_stop(sourceOrders.get(ciOrders[i].getId_or()).getId_dep_stop());
				}
				ciOrders[i].setId_dep_chk_stop(sourceOrders.get(ciOrders[i].getId_or()).getId_dep_chk_stop());
				ciOrders[i].setId_emp_chk_stop(sourceOrders.get(ciOrders[i].getId_or()).getId_emp_chk_stop());
				FDateTime date = new FDateTime();
				if (sourceOrders.get(ciOrders[i].getId_or()).getDt_chk_stop() == null
						|| sourceOrders.get(ciOrders[i].getId_or()).getDt_chk_stop()
								.compareTo(new FDateTime("2098-01-01 00:00:00")) > 0) {
					ciOrders[i].setDt_chk_stop(date);
				} else {
					ciOrders[i].setDt_chk_stop(sourceOrders.get(ciOrders[i].getId_or()).getDt_chk_stop());
				}
				if (sourceOrders.get(ciOrders[i].getId_or()).getDt_stop() == null || sourceOrders
						.get(ciOrders[i].getId_or()).getDt_stop().compareTo(new FDateTime("2098-01-01 00:00:00")) > 0) {
					ciOrders[i].setDt_stop(date);
				} else {
					ciOrders[i].setDt_stop(sourceOrders.get(ciOrders[i].getId_or()).getDt_stop());
				}
			}
		}
	}
	private void setRisApp(List<CiOrderDO> RisAppList) throws BizException {
		if (RisAppList == null || RisAppList.size() == 0)
			return;
		CiOrderRisInfoToScAptApplBp risbp = new CiOrderRisInfoToScAptApplBp();
		String sd_hp = "2";
		if (FBoolean.TRUE.equals(RisAppList.get(0).getFg_orhp()))
			sd_hp = "2";
		else
			sd_hp = "1";
		risbp.sendCiOrderRisInfoToScAptAppl(RisAppList.toArray(new CiOrderDO[0]), sd_hp);
	}


	/**
	 * 护嘱停止确认更改状态
	 * 
	 * @param cidos
	 * @throws BizException
	 */
	private void nurOrderStopChk(CiOrderDO[] cidos) throws BizException {
		// 医嘱状态调整为停止核对
		UpdateOrdStatusInfo1BP bp1 = new UpdateOrdStatusInfo1BP();
		for (int i = 0; i < cidos.length; i++) {
			CiOrderDO or = cidos[i];
			if (!or.getSd_su_or().equals(ICiDictCodeConst.SD_SU_FINISH)) {// 医嘱状态为完成不修改完成状态
				or.setId_su_or(ICiDictCodeConst.SD_SU_ID_CHECKSTOP);
				or.setSd_su_or(ICiDictCodeConst.SD_SU_CHECKSTOP);
			}
			or.setFg_chk_stop(new FBoolean(true));
			or.setFg_stop(new FBoolean(true));
			or.setStatus(DOStatus.UPDATED);
		}
		// 医嘱及事件保存
		bp1.ciOrStatusRelInfoSave(cidos, ICiDictCodeConst.SD_SU_CHECKSTOP); // 保存更新走相应的校验操作
	}
}
