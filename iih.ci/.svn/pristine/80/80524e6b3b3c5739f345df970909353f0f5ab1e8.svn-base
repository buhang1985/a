package iih.ci.event.ord.bps.refund.listenerbp;

import iih.bl.cg.dto.d.OpRefund4IpEsDTO;
import iih.ci.event.ord.bps.refund.logicbp.OpDrugRefundLogicDealWithBP;
import iih.ci.event.ord.listeners.refund.op.OpRefundSendCommonListener;
import iih.ci.event.ord.utils.IOrdEventSources;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.iemsg.d.IEOpPharmOrEnDTO;
import xap.ip.event.BusiType;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 门诊处方退费标准版BS302
 * 
 * @author F
 *
 * @date 2019年9月16日下午4:38:50
 *
 * @classpath iih.ci.event.ord.bps.refund.listenerbp.OpDrugRefundStandardBP
 */
public class OpDrugRefundStandardBP extends OpRefundSendCommonListener {

	@Override
	public boolean isMatchSourceIdAndEventType(IBusinessEvent event) throws BizException {
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS302-门诊处方退费判断事件源和事件类型");
		if (!(IOrdEventSources.OP_DRUG_REFUND.equals(event.getSourceID())
				&& IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType()))) {
			return false;
		}
		return true;
	}

	@Override
	public BaseDTO[] assembleData(OpRefund4IpEsDTO[] opRefund4IpEsDTOs) throws BizException {
		OrdEventLogger.info(this.getClass().getSimpleName(),"BS302-门诊处方退费opRefund4IpEsDTOs:" + opRefund4IpEsDTOs.toString());
		OpDrugRefundLogicDealWithBP bp = new OpDrugRefundLogicDealWithBP();
		return bp.exec(opRefund4IpEsDTOs);
	}

	@Override
	public void sendMessagesToIE(BaseDTO[] dtos) throws BizException {
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS302-进入门诊处方退费发往集成平台方法");
		for (BaseDTO baseDTO : dtos) {
			OrdEventLogger.info(this.getClass().getSimpleName(),"BS302-门诊 处方 退费 msgDtoString:" + baseDTO.serializeJson() + ",");
			// 获取执行科室
			IEOpPharmOrEnDTO ierisdto = (IEOpPharmOrEnDTO) baseDTO;
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(baseDTO, BusiType.MZ, ierisdto.getDept_code(), "0");
			MsgObj mbx = new MsgObj();
			mbx.setInteractionCode(OrdEventUtil.RENEW);
			userobj.setMsgObj(mbx);
			OrdEventUtil.fireEvent(IOrdEventSources.EVENT_IE_CIOR_OP_DRUG, IEventType.TYPE_UPDATE_AFTER,new BaseDTO[] { userobj });
			OrdEventLogger.info(this.getClass().getSimpleName(),"BS302-门诊退费处方 往集成平台每次发送的数据:" + userobj.serializeJson());
		}
//		for (BaseDTO baseDTO : dtos) {
//			OrdEventLogger.info(this.getClass().getSimpleName(),"BS302-门诊 处方 退费 msgDtoString:" + baseDTO.serializeJson() + ",");
//			// 获取执行科室
//			IEOpPharmOrEnDTO ierisdto = (IEOpPharmOrEnDTO) baseDTO;
//			DomainBusinessUserObj userobj = new DomainBusinessUserObj(baseDTO, BusiType.MZ, null, "0");
//			MsgObj mbx = new MsgObj();
//			mbx.setInteractionCode(OrdEventUtil.RENEW);
//			mbx.setPatientCode(ierisdto.getPatientid());
//			mbx.setEntimes(Integer.parseInt(ierisdto.getTimes()));
//			mbx.setEnNO(ierisdto.getP_bar_code());
//			mbx.setApplyUnitId(ierisdto.getApplydeptcode());// 申请科室编码
//			mbx.setExtendSubId(null);// 收费标识
//			FMap2 params = new FMap2();
//			params.put("VISIT_TYPE", ierisdto.getVisittypecode());// 第三位域ID（就诊类别）
//			mbx.setExtras(params);// 就诊类别，通过Map传递
//			userobj.setMsgObj(mbx);
//			OrdEventUtil.fireEvent(IOrdEventSources.EVENT_IE_CIOR_OP_DRUG, IEventType.TYPE_UPDATE_AFTER,new BaseDTO[] { userobj });
//			OrdEventLogger.info(this.getClass().getSimpleName(),"BS302-门诊退费处方 往集成平台每次发送的数据:" + userobj.serializeJson());
//		}
	}

}
