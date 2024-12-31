package iih.ci.event.ord.bps.charge.op.listenerbp;

import iih.ci.event.ord.bps.charge.op.logicbp.OpOpChargeLogicDealWithBP;
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
 * 门诊手术收费标准版BS007(之前的并不触发该消息 这一版先加着)
 * @author F
 *
 * @date 2019年9月11日下午2:01:27
 *
 * @classpath iih.ci.event.ord.bps.charge.op.listenerbp.OpOpChargeStandardBP
 */
public class OpOpChargeStandardBP extends OPIPSendIECommonListener{

	@Override
	public boolean isMatchSourceIdAndEventType(IBusinessEvent event) throws BizException {
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS007-门诊手术收费判断事件源和事件类型");
		if(!(IOrdEventSources.OP_OP_CHARGE.equals(event.getSourceID())&& IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType()))) {
			return false;
		}
		return true;
	}

	@Override
	public BaseDTO[] assembleData(BaseDTO baseDTO) throws BizException {
		OrdEventFireDTO firedto=(OrdEventFireDTO)baseDTO;
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS007-进入组装门诊手术收费数据方法，id_ors:"+firedto.getIdors());
		OpOpChargeLogicDealWithBP bp=new OpOpChargeLogicDealWithBP();
		return bp.exec(firedto);
	}

	@Override
	public void sendMessagesToIE(BaseDTO[] dtos) throws BizException {
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS007-进入门诊手术收费发往集成平台方法");
		for (BaseDTO baseDTO : dtos) {
			OrdEventLogger.info(this.getClass().getSimpleName(), "BS007-门诊 手术 收费 msgDtoString:"+baseDTO.serializeJson()+",");
			//获取执行科室
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
			OrdEventLogger.info(this.getClass().getSimpleName(), "BS007-门诊收费手术 往集成平台每次发送的数据:"+userobj.serializeJson());
		}
	}

}
