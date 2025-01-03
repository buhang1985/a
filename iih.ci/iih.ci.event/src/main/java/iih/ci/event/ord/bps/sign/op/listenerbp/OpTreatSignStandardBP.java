package iih.ci.event.ord.bps.sign.op.listenerbp;

import iih.ci.event.ord.bps.sign.op.logicbp.OpTreatSignLogicDealWithBP;
import iih.ci.event.ord.listeners.OPIPSendIECommonListener;
import iih.ci.event.ord.utils.IOrdEventSources;
import iih.ci.event.ord.utils.OrdEventFireDTO;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventMessageTitleDTO;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.iemsg.d.IEOpTreatOrDTO;
import iih.ci.ord.iemsg.d.IEOpTreatOrEnDTO;
import xap.ip.event.BusiType;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IEventType;
/**
 * 门诊签署治疗标准版BS303
 * @author F
 *
 * @date 2019年8月23日下午1:53:16
 *
 * @classpath iih.ci.event.ord.bps.sign.op.listenerbp.OpTreatSignStandardBP
 */
public class OpTreatSignStandardBP extends OPIPSendIECommonListener{

	@Override
	public boolean isMatchSourceIdAndEventType(IBusinessEvent event)throws BizException{
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS303-门诊签署治疗判断事件源和事件类型");
		if(!(IOrdEventSources.OP_TREAT_SIGN.equals(event.getSourceID())&& IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType()))) {
			return false;
		}
		return true;
	}
	
	@Override
	public BaseDTO[] assembleData(BaseDTO baseDTO) throws BizException {
		OrdEventFireDTO firedto=(OrdEventFireDTO)baseDTO;
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS303-进入组装门诊治疗签署数据方法，id_ors:"+firedto.getIdors());
		OpTreatSignLogicDealWithBP bp=new OpTreatSignLogicDealWithBP();
		return bp.exec(firedto);
	}

	@Override
	public void sendMessagesToIE(BaseDTO[] dtos) throws BizException {
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS303-进入门诊治疗签署发往集成平台方法");
		for (BaseDTO baseDTO : dtos) {
			OrdEventLogger.info(this.getClass().getSimpleName(), "BS303-门诊 治疗 签署 msgDtoString:"+baseDTO.serializeJson()+",");
			OrdEventMessageTitleDTO messageDTO=new OrdEventMessageTitleDTO();
			//获取执行科室
			IEOpTreatOrEnDTO ieTreatEndto =(IEOpTreatOrEnDTO) baseDTO;
			IEOpTreatOrDTO ieTreatordto=null;
			if(!OrdEventUtil.isEmpty(ieTreatEndto.getIetreators())) {
				ieTreatordto=(IEOpTreatOrDTO) (ieTreatEndto.getIetreators()).get(0);
				messageDTO.setExecDept_code(ieTreatordto.getExec_sn());//执行科室 消息头第五位
				messageDTO.setIemsgca_code("099");//集成分类 消息头第七位
				messageDTO.setOrderNO(ieTreatordto.getOrder_no());//医嘱编码
				messageDTO.setPayflag(ieTreatordto.getPayflag());//收费标识 消息头第八位
			}
			messageDTO.setBussiType(BusiType.MZ);//业务类型
			messageDTO.setInteractionCode(OrdEventUtil.NEW);//交互类型
			messageDTO.setPatientCode(ieTreatEndto.getPatient_id());//患者编码
			messageDTO.setEntimes(ieTreatEndto.getAdmiss_times());//就诊次数
			messageDTO.setEnNO(ieTreatEndto.getP_bar_code());//就诊编号
			messageDTO.setApply_unit(ieTreatEndto.getApply_code());//申请科室遍码 消息头第四位
			messageDTO.setVisit_type(ieTreatEndto.getVisittype());//就诊类型 消息头第三位
			OrdEventUtil.sendMessageToIE(baseDTO, messageDTO, IOrdEventSources.EVENT_IE_CIOR_OP_TREAT, IEventType.TYPE_UPDATE_AFTER);
		}
	}

}
