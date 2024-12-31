package iih.ci.event.ord.bps.revert.op.listenerbp;

import iih.ci.event.ord.bps.revert.op.logicbp.OpConRevertLogicDealWithBP;
import iih.ci.event.ord.listeners.OPIPSendIECommonListener;
import iih.ci.event.ord.utils.IOrdEventSources;
import iih.ci.event.ord.utils.OrdEventFireDTO;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.iemsg.d.IEOpOpConsulationDTO;
import xap.ip.event.BusiType;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IEventType;
/**
 * 会诊门诊撤回标准版BS318
 * @author F
 *
 * @date 2019年11月19日下午4:24:09
 *
 * @classpath iih.ci.event.ord.bps.revert.op.listenerbp.OpConRevertStandardBP
 */
public class OpConRevertStandardBP extends OPIPSendIECommonListener{

	@Override
	public boolean isMatchSourceIdAndEventType(IBusinessEvent event)throws BizException{
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS318-门诊撤回会诊判断事件源和事件类型");
		if(!(IOrdEventSources.OP_CON_REVERT.equals(event.getSourceID())&& IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType()))) {
			return false;
		}
		return true;
	}
	
	@Override
	public BaseDTO[] assembleData(BaseDTO baseDTO) throws BizException {
		OrdEventFireDTO firedto=(OrdEventFireDTO)baseDTO;
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS318-进入组装门诊会诊撤回数据方法，id_ors:"+firedto.getIdors());
		OpConRevertLogicDealWithBP bp=new OpConRevertLogicDealWithBP();
		return bp.exec(firedto);
	}

	@Override
	public void sendMessagesToIE(BaseDTO[] dtos) throws BizException {
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS318-进入 门诊会诊撤回 发往集成平台方法");
		for (BaseDTO baseDTO : dtos) {
			OrdEventLogger.info(this.getClass().getSimpleName(), "BS318-门诊 会诊 撤回 msgDtoString:"+baseDTO.serializeJson()+",");
			//获取执行科室
			IEOpOpConsulationDTO ieopdto =(IEOpOpConsulationDTO) baseDTO;
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(baseDTO, BusiType.MZ,ieopdto.getExecdept(),ieopdto.getSertypecode());
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode(OrdEventUtil.DELETE);
			mbx.setPatientCode(ieopdto.getPatientlid());
			mbx.setEntimes(ieopdto.getVisittimes());
			mbx.setEnNO(ieopdto.getVisitno());
			mbx.setApplyNO(ieopdto.getRequestno());
			mbx.setOrderNO(ieopdto.getOrderlid());
			mbx.setExtendSubId(ieopdto.getPayflag());// 扩展码-第八位收费标志位(0表示未收费，1表示收费)
			mbx.setApplyUnitId(ieopdto.getOrderdept());// 第四位申请科室遍码
			FMap2 params = new FMap2();
	        params.put("VISIT_TYPE", ieopdto.getVisittype());// 第三位域ID（就诊类别）
	        mbx.setExtras(params);
			userobj.setMsgObj(mbx);	
			OrdEventUtil.fireEvent(IOrdEventSources.EVENT_IE_CIOR_OP_CON, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
			OrdEventLogger.info(this.getClass().getSimpleName(), "BS318-门诊撤回会诊 往集成平台每次发送的数据:"+userobj.serializeJson());
		}
		
	}

}
