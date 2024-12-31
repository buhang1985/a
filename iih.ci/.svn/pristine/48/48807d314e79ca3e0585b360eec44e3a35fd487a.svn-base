package iih.ci.event.ord.bps.sign.op.listenerbp;

import iih.ci.event.ord.bps.sign.op.logicbp.OpOpSignLogicDealWithBP;
import iih.ci.event.ord.listeners.OPIPSendIECommonListener;
import iih.ci.event.ord.utils.IOrdEventSources;
import iih.ci.event.ord.utils.OrdEventFireDTO;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.iemsg.d.IEOpOpOrEnDTO;
import iih.ci.ord.iemsg.d.IEOperationInfoDTO;
import xap.ip.event.BusiType;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IEventType;
/**
 * 门诊 手术 签署 标准版逻辑BS007
 * @author F
 *
 * @date 2019年8月19日上午10:13:31
 *
 * @classpath iih.ci.event.ord.bps.sign.op.listenerbp.OpOpSignStandardBP
 */
public class OpOpSignStandardBP extends OPIPSendIECommonListener{

	@Override
	public boolean isMatchSourceIdAndEventType(IBusinessEvent event)throws BizException{
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS007-门诊签署手术判断事件源和事件类型");
		if(!(IOrdEventSources.OP_OP_SIGN.equals(event.getSourceID())&& IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType()))) {
			return false;
		}
		return true;
	}
	
	@Override
	public BaseDTO[] assembleData(BaseDTO baseDTO) throws BizException {
		OrdEventFireDTO firedto=(OrdEventFireDTO)baseDTO;
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS007-进入组装门诊手术签署数据方法，id_ors:"+firedto.getIdors());
		OpOpSignLogicDealWithBP bp=new OpOpSignLogicDealWithBP();
		return bp.exec(firedto);
	}

	@Override
	public void sendMessagesToIE(BaseDTO[] msgdtos) throws BizException {
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS007-进入门诊手术签署发往集成平台方法");
		for(BaseDTO baseDTO:msgdtos) {
			OrdEventLogger.info(this.getClass().getSimpleName(), "BS007-门诊 手术 签署 msgDtoString:"+baseDTO.serializeJson()+",");
			IEOpOpOrEnDTO ieopdto =(IEOpOpOrEnDTO) baseDTO;
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(baseDTO, BusiType.MZ,ieopdto.getExec_code(),ieopdto.getIemsgca_code());
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode(OrdEventUtil.NEW);
			mbx.setPatientCode(ieopdto.getPatient_id());
			mbx.setEntimes(Integer.parseInt(ieopdto.getAdmit_times()));
			mbx.setEnNO(ieopdto.getP_bar_code());
			mbx.setApplyNO(ieopdto.getOp_record_id());
			mbx.setOrderNO(ieopdto.getYz_no());
			if(!OrdEventUtil.isEmpty(ieopdto.getIesugorders())) {
				IEOperationInfoDTO infoDto = (IEOperationInfoDTO)ieopdto.getIesugorders().get(0);
				mbx.setExtendSubId(infoDto.getPayflag());// 扩展码-第八位收费标志位(0表示未收费，1表示收费)
			}
			mbx.setApplyUnitId(ieopdto.getDept_code());// 第四位申请科室遍码
			FMap2 params = new FMap2();
	        params.put("VISIT_TYPE", ieopdto.getVisittype());// 第三位域ID（就诊类别）
	        mbx.setExtras(params);// 就诊类别，通过Map传递
			userobj.setMsgObj(mbx);
			OrdEventUtil.fireEvent(IOrdEventSources.EVENT_IE_CIOR_OP_OP, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj } );
			OrdEventLogger.info(this.getClass().getSimpleName(), "BS007-门诊签署手术 往集成平台每次发送的数据:"+userobj.serializeJson());
		}
	}

}
