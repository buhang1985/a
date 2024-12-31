package iih.ci.event.ord.bps.refund.listenerbp;

import iih.bl.cg.dto.d.OpRefund4IpEsDTO;
import iih.ci.event.ord.bps.refund.logicbp.OpTreatRefundLogicDealWithBP;
import iih.ci.event.ord.listeners.refund.op.OpRefundSendCommonListener;
import iih.ci.event.ord.utils.IOrdEventSources;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.iemsg.d.IEOpTreatOrEnDTO;
import xap.ip.event.BusiType;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IEventType;
/**
 * 门诊诊疗 退费标准版BS303
 * @author F
 *
 * @date 2019年9月16日下午4:46:03
 *
 * @classpath iih.ci.event.ord.bps.refund.listenerbp.OpTreatRefundStandardBP
 */
public class OpTreatRefundStandardBP extends OpRefundSendCommonListener{

	@Override
	public boolean isMatchSourceIdAndEventType(IBusinessEvent event) throws BizException {
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS303-门诊诊疗退费判断事件源和事件类型");
		if(!(IOrdEventSources.OP_TREAT_REFUND.equals(event.getSourceID())&& IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType()))) {
			return false;
		}
		return true;
	}

	@Override
	public BaseDTO[] assembleData(OpRefund4IpEsDTO[] opRefund4IpEsDTOs) throws BizException {
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS303-门诊诊疗退费opRefund4IpEsDTOs:"+opRefund4IpEsDTOs.toString());
		OpTreatRefundLogicDealWithBP bp=new OpTreatRefundLogicDealWithBP();
		return bp.exec(opRefund4IpEsDTOs);
	}

	@Override
	public void sendMessagesToIE(BaseDTO[] dtos) throws BizException {
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS303-进入门诊诊疗退费发往集成平台方法");
		for (BaseDTO baseDTO : dtos) {
			OrdEventLogger.info(this.getClass().getSimpleName(),"BS303-门诊 诊疗 退费 msgDtoString:" + baseDTO.serializeJson() + ",");
			 // 获取执行科室
			 IEOpTreatOrEnDTO ierisdto = (IEOpTreatOrEnDTO) baseDTO;
			 DomainBusinessUserObj userobj = new DomainBusinessUserObj(baseDTO, BusiType.MZ,ierisdto.getExec_sn(),"0");
			 MsgObj mbx = new MsgObj();
			 mbx.setInteractionCode(OrdEventUtil.RENEW);
			 userobj.setMsgObj(mbx);
			 OrdEventUtil.fireEvent(IOrdEventSources.EVENT_IE_CIOR_OP_TREAT,IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
			 OrdEventLogger.info(this.getClass().getSimpleName(),"BS303-门诊退费诊疗 往集成平台每次发送的数据:" + userobj.serializeJson());
		}
//		for (BaseDTO baseDTO : dtos) {
//			OrdEventLogger.info(this.getClass().getSimpleName(),"BS303-门诊 诊疗 退费 msgDtoString:" + baseDTO.serializeJson() + ",");
//			 IEOpTreatOrEnDTO ierisdto = (IEOpTreatOrEnDTO) baseDTO;
//			 IEOpTreatOrDTO orDto=null;
//			 String execDeptString=null;
//			 String iemsgcaString=null;
//			 MsgObj mbx = new MsgObj();
//			 if(!OrdEventUtil.isEmpty(ierisdto.getIetreators())) {
//				 orDto=(IEOpTreatOrDTO)ierisdto.getIetreators().get(0);
//				 mbx.setExtendSubId(orDto.getPayflag());// 收费标识
//				 execDeptString=orDto.getExec_sn();//执行科室
//				 iemsgcaString=orDto.getSd_iemsgca();//集成分类
//			 }
//			 DomainBusinessUserObj userobj = new DomainBusinessUserObj(baseDTO, BusiType.MZ,execDeptString,iemsgcaString);
//			 mbx.setInteractionCode(OrdEventUtil.RENEW);
//			 mbx.setPatientCode(ierisdto.getPatient_id());
//			 mbx.setEntimes(Integer.parseInt(ierisdto.getAdmiss_times()));
//			 mbx.setEnNO(ierisdto.getVisitordno());
//			 mbx.setApplyUnitId(ierisdto.getApply_code());// 申请科室编码
//			 FMap2 params = new FMap2();
//			 params.put("VISIT_TYPE", ierisdto.getVisittype());// 第三位域ID（就诊类别）
//			 mbx.setExtras(params);// 就诊类别，通过Map传递
//			 userobj.setMsgObj(mbx);
//			 OrdEventUtil.fireEvent(IOrdEventSources.EVENT_IE_CIOR_OP_TREAT,IEventType.TYPE_UPDATE_AFTER,new BaseDTO[] { userobj });
//			 OrdEventLogger.info(this.getClass().getSimpleName(),"BS303-门诊退费诊疗 往集成平台每次发送的数据:" + userobj.serializeJson());
//		}
	}

}
