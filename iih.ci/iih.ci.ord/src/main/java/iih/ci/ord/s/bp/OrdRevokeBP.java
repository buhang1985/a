package iih.ci.ord.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ap.i.ICiapspecantirecordCudService;
import iih.ci.ord.cior.d.CiOrderTypeEnum;
import iih.ci.ord.cior.d.CiorappsurgeryAggDO;
import iih.ci.ord.cior.d.OrdApOpAgainDO;
import iih.ci.ord.cior.d.OrdApOpDO;
import iih.ci.ord.cior.i.ICiorappsurgeryMDORService;
import iih.ci.ord.cior.i.ICiorappsurgeryRService;
import iih.ci.ord.cior.i.IOrdApOpAgainDOCudService;
import iih.ci.ord.cior.i.IOrdApOpAgainDORService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiOrderReactDO;
import iih.ci.ord.ciprn.i.ICiprintExtService;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.idvproperty.d.IdVProperty;
import iih.ci.ord.moreemsdto.d.MoreEmsParamDTO;
import iih.ci.ord.msg.CiMsgSenderUtil;
import iih.ci.ord.pub.CiOrPubUtils;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.listener.ICiEventConst;
import iih.ci.ord.s.bp.assi.tl.ciorcopy.IpCiOrderCopyBP;
import iih.ci.ord.s.bp.ems.CiOrUseBtRollBackBP;
import iih.ci.ord.s.bp.orsms.lis.mergetube.MergeTubeDataDelValidate;
import iih.ci.ord.s.bp.orsms.ris.mergesheet.ImageTextReportDelValidate;
import iih.ci.ord.s.bp.splitpres.RrevokeOrderHandlePresBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.orm.utils.AuditInfoUtil;

/**
 * 医嘱撤回操作
 * 
 * @author zhangwq
 *
 */
public class OrdRevokeBP {

	public OrderRstDTO ordRevoke(IdVProperty[] id_ors, FArrayList reactOrds, CiEnContextDTO ciEnContext, FDateTime dt_end,
			String sd_su_or, OrderOperateDTO arg) throws BizException {
		validateCheck(id_ors, sd_su_or);
		// 获得医嘱
		Object[] os = CiOrdUtils.getIdVPropInfo(id_ors);
		CiOrderDO[] orders = CiOrdAppUtils.getOrQryService().findByIds((String[]) os[0], new FBoolean(false));
		
		List<String> orderIds = new ArrayList<String>();
		for (CiOrderDO order : orders) {
		    orderIds.add(order.getId_or());
		}
	    // 判断容器费撤回时，存不存在检验医嘱
        MergeTubeDataDelValidate.DiriveDataDelValide(orderIds);
        // 判断图文报告费撤回时，存不存在检查医嘱
        ImageTextReportDelValidate.DiriveDataDelValideRis(orderIds);
        
		// 将撤回的用血医嘱查找出来，条件（1、是用血医嘱，2、医嘱状态是开立）
		ArrayList<CiOrderDO> useBtrollBacks = new ArrayList<CiOrderDO>();
		for (CiOrderDO ciorder : orders) {
			if (CiOrderTypeEnum.USEBTORDER.equals(CiOrPubUtils.getCiOrderType(ciorder))) {
				useBtrollBacks.add(ciorder);
			}

		}
		// 设置医嘱状态
		CiOrderDO[] ors = setOrdState(orders, dt_end, sd_su_or);
		// 医嘱撤回、停止、作废时调用发送给医嘱确认节点消息提醒
		CiMsgSenderUtil.sendCiOrdConfirmMsg(ors);
		// 医嘱撤回时删除申请单
		OrderRstDTO clearPrintRst = clearPrintData((String[]) os[0], arg);
		if (clearPrintRst != null && clearPrintRst.getExtension() != null && clearPrintRst.getExtension().containsKey("SampColPri")) {
		    clearPrintRst.setIsSuccess(FBoolean.TRUE);
            return clearPrintRst;
        }
		//删除二次手术申请单
		CiOrdUtils.clearSugAgainData((String[]) os[0]);
		// 撤销、删除、作废调用SC接口向sc回写手术申请撤回信息
		CiOrSufInfo4ScAptApplBp bp = new CiOrSufInfo4ScAptApplBp();
		bp.sendSugInfo4ScAptAppl(ciEnContext,orders);
		// 医嘱撤回和作废时，发送事件到病历组
		CiOrdUtils.fireBDEvent(ICiEventConst.CIOR_STATUS_SIGN2OPEN_EVENT_SOURCEID, IEventType.TYPE_UPDATE_AFTER, ors);
		//0167550: 检查项目关联费用的，签署后一起选中点撤回，报如图异常
		CiOrderDO[] ords2 = CiOrdAppUtils.getOrQryService().findByIds((String[]) os[0], new FBoolean(false));
		//撤回的医嘱被删除，过滤已删除医嘱
		if(ords2.length!=ors.length) {			
			ors=filterDeleteOrd(ors,ords2);			
		}
		// 医嘱及事件保存
		ciOrStatusRelInfoSave(ors, sd_su_or);
		// 执行用血医嘱的回撤逻辑
		if (useBtrollBacks.size() > 0) {
			CiOrUseBtRollBackBP rollbak = new CiOrUseBtRollBackBP();
			rollbak.exe(useBtrollBacks.toArray(new CiOrderDO[useBtrollBacks.size()]));
		}
		// 被排斥医嘱撤回逻辑
		this.reactOrdRevoke(reactOrds, ciEnContext);
		return null;
	}
	
	/**
	 * 过滤已删除医嘱
	 * @param ors
	 * @param ords2
	 * @return
	 */
	private CiOrderDO[] filterDeleteOrd(CiOrderDO[] ors,CiOrderDO[] ords2) {
		
		Map<String,CiOrderDO> map=new HashMap<>();
		for (CiOrderDO ciOrderDO : ords2) {
			map.put(ciOrderDO.getId_or(), ciOrderDO);
		}
		CiOrderDO[] ords3=new CiOrderDO[ords2.length];
		int i=0;
		for (CiOrderDO ciOrderDO : ors) {
			if(map.containsKey(ciOrderDO.getId_or())) {
				ords3[i++]=ciOrderDO;
			}
		}
		return ords3;
	}

	/**
	 * 有效性校验
	 * 
	 * @param id_ors
	 * @param dt_end
	 * @param sd_su_or
	 * @throws BizException
	 */
	private void validateCheck(IdVProperty[] id_ors, String sd_su_or) throws BizException {
		if (id_ors == null || id_ors.length == 0)
			return;

		// 状态校验
		if (!CiOrdUtils.orStatusValidateCheck4Mod(sd_su_or)) {
			throw new BizException("传入的状态值不正确！");
		}
	}

	/**
	 * 将医嘱设置为开立状态
	 * 
	 * @param orders
	 * @param dt_end
	 * @param sd_su_or
	 * @param os
	 * @return
	 * @throws BizException
	 */
	private CiOrderDO[] setOrdState(CiOrderDO[] orders, FDateTime dt_end, String sd_su_or) throws BizException {
		ArrayList<CiOrderDO> rtns = new ArrayList<CiOrderDO>();
		CiOrderDO or = null;
		String id_emp = CiOrdAppUtils.getEnvContext().getUserId();
		id_emp = CiOrdUtils.getPsnDocID(id_emp);
		for (int i = 0; i < orders.length; i++) {
			or = orders[i];
			AuditInfoUtil.updateData(or);
			or.setId_su_or(ICiDictCodeConst.SD_SU_ID_OPEN);
			or.setSd_su_or(sd_su_or);
			or.setFg_sign(new FBoolean(false));
			or.setDt_sign(null);
			or.setId_dep_sign(null);
			or.setId_emp_sign(null);
			or.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
			or.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
			or.setStatus(DOStatus.UPDATED);
			// 处理医嘱撤回的
			RrevokeOrderHandlePresBP bp = new RrevokeOrderHandlePresBP();
			bp.execOrders(orders);
			rtns.add(or);
		}
		return orders;
	}

	/**
	 * 删除打印数据
	 * 
	 * @param ids
	 * @throws BizException
	 */
	private OrderRstDTO clearPrintData(String[] ids, OrderOperateDTO arg) throws BizException {
	    ICiprintExtService service = ServiceFinder.find(ICiprintExtService.class);
        OrderRstDTO rst = service.DeleteAppLisRelData(ids, arg);
        if (rst != null && rst.getExtension() != null && rst.getExtension().containsKey("SampColPri")) {
            return rst;
        }
		service.DeleteAppLisRelDataIp(ids,null);
		service.DeleteAppRisData(ids);
		service.DeleteAppPathgyData(ids);
		service.DeleteTreateExecData(ids);
		service.DeleteFeeBillsData(ids);
		ICiapspecantirecordCudService recordService = ServiceFinder.find(ICiapspecantirecordCudService.class);
		recordService.deleteByIdOrs(ids);
		return null;
	}

	/**
	 * 医嘱及事件保存
	 * 
	 * @param ors
	 * @param sd_su_or
	 * @throws BizException
	 */
	private void ciOrStatusRelInfoSave(CiOrderDO[] ors, String sd_su_or) throws BizException {
		CiOrdAppUtils.getOrService().update(ors);

		// 医嘱事件创建保存 时机应该选择为 签署阶段
		ciEventInfoSave(ors, sd_su_or);
	}

	/**
	 * 临床事件保存
	 * 
	 * @param ors
	 * @param sd_su_or
	 * @throws BizException
	 */
	private void ciEventInfoSave(CiOrderDO[] ors, String sd_su_or) throws BizException {
		// 有效性校验
		if (ors == null || ors.length == 0)
			return;
		if (!ICiDictCodeConst.SD_SU_SIGN.equals(sd_su_or))
			return;
		// 医嘱事件创建保存 时机应该选择为 签署阶段
		CiOrEventsSaveBP bp = new CiOrEventsSaveBP();
		bp.exec(ors);
	}

	/**
	 * 被排斥医嘱撤回
	 * 
	 * @param reactOrds
	 * @return
	 * @throws BizException
	 */
	private boolean reactOrdRevoke(FArrayList reactOrds, CiEnContextDTO ciEnContext) throws BizException {
		if (!CiOrdUtils.isEmpty(reactOrds)) {
			// 回退的医嘱
			List<String> revokeIdors = new ArrayList<String>();
			// 重开的医嘱
			List<String> reopenIdors = new ArrayList<String>();
			Map<String, CiOrderReactDO> tempMap = new HashMap<String, CiOrderReactDO>();
			List<CiOrderReactDO> reactDOList = new ArrayList<CiOrderReactDO>();
			for (Object reactObj : reactOrds) {
				CiOrderReactDO reactDO = (CiOrderReactDO) reactObj;
				String id_or = reactDO.getId_or_react_itm();
				if (reactDO.getIsreadonly().booleanValue()) {
					reopenIdors.add(id_or);// 重开的医嘱集合
				} else {
					revokeIdors.add(id_or);// 回退的医嘱集合
				}
				tempMap.put(id_or, reactDO);
				reactDO.setDs(1);
				reactDOList.add(reactDO);
			}
			// 回退操作
			if (!CiOrdUtils.isEmpty(revokeIdors)&&revokeIdors.size()>0) {
				CiOrderDO[] orderList = CiOrdAppUtils.getOrQryService().findByBIds(revokeIdors.toArray(new String[0]),
						FBoolean.FALSE);
				String NULL_DATE = "2099-01-01 00:00:00";
				for (CiOrderDO order : orderList) {
					CiOrderReactDO react = tempMap.get(order.getId_or());
					// 停止、未停止确认、未作废、未完成的可以停止撤回
					if (order.getFg_stop() != null && !order.getFg_stop().booleanValue()
							&& order.getFg_chk_stop() != null && !order.getFg_chk_stop().booleanValue()
							&& order.getFg_canc() != null && !order.getFg_canc().booleanValue()
							&& order.getSd_su_or() != ICiDictCodeConst.SD_SU_FINISH) {
					if (CiOrdUtils.isEmpty(react.getDt_end())) {
						order.setDt_end(new FDateTime(NULL_DATE));
						order.setFg_stop(FBoolean.FALSE);
						order.setId_emp_stop(null);
						order.setId_dep_stop(null);
					} else {
						order.setDt_end(react.getDt_end());
						order.setFg_stop(FBoolean.TRUE);
						order.setId_emp_stop(ciEnContext.getId_emp_or());
						order.setId_dep_stop(ciEnContext.getId_dep_or());
					}
				}
				}
				CiOrdAppUtils.getOrService().update(orderList);
				//执行域响应停止操作
				CiOrdAppUtils.getIResponseOrderHandelService().responseOrStop(revokeIdors.toArray(new String[0]));
			}
			// 重开走复制逻辑
			if (!CiOrdUtils.isEmpty(reopenIdors)&&reopenIdors.size()>0) {
				IpCiOrderCopyBP bp2 = new IpCiOrderCopyBP(reopenIdors.toArray(new String[0]), ciEnContext);
				MoreEmsParamDTO paramDTO = bp2.exec();
				FArrayList ciEmsDTOList = (FArrayList) paramDTO.getErrormap2().get("errorOrders");
				for (Object emsObj : ciEmsDTOList) {
					CiEmsDTO emsdto = (CiEmsDTO) emsObj;
					emsdto.setDt_begin(tempMap.get(emsdto.getAttrVal("Id_or_src")).getDt_begin());
					CiOrdAppUtils.getICiOrdMaintainService().SaveCiEmsDTO(emsdto, ciEnContext);
				}
			}
			CiOrdAppUtils.getCiorderreactCudService().logicDelete(CiOrdAppUtils.getCiorderreactRService().findByAttrValString(CiOrderReactDO.ID_OR, reactDOList.get(0).getId_or()));
			reopenIdors.addAll(revokeIdors);
		}
		return true;
	}
}
