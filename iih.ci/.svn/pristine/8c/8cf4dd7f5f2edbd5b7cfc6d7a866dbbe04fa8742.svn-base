package iih.ci.event.ord.bps.revert.op.listenerbp;

import iih.ci.event.ord.bps.revert.op.logicbp.OpOpRevertLogicDealWithBP;
import iih.ci.event.ord.listeners.OPIPSendIECommonListener;
import iih.ci.event.ord.utils.IOrdEventSources;
import iih.ci.event.ord.utils.OrdEventFireDTO;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.iemsg.d.IEOpOrCancStpDTO;
import iih.ci.ord.iemsg.d.IEOpOrCancStpEnDTO;
import xap.ip.event.BusiType;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IEventType;
/**
 * 门诊 手术撤回 标准版BS005
 * @author F
 *
 * @date 2019年9月11日下午1:14:29
 *
 * @classpath iih.ci.event.ord.bps.revert.op.listenerbp.OpOpRevertStandardBP
 */
public class OpOpRevertStandardBP extends OPIPSendIECommonListener{

	@Override
	public boolean isMatchSourceIdAndEventType(IBusinessEvent event) throws BizException {
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS005-门诊撤回 手术判断事件源和事件类型");
		if (!(IOrdEventSources.OP_OP_REVERT.equals(event.getSourceID())
				&& IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType()))) {
			return false;
		}
		return true;
	}

	@Override
	public BaseDTO[] assembleData(BaseDTO baseDTO) throws BizException {
		OrdEventFireDTO firedto=(OrdEventFireDTO)baseDTO;
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS005-进入组装 门诊手术撤回数据方法，id_ors:"+firedto.getIdors());
		OpOpRevertLogicDealWithBP bp=new OpOpRevertLogicDealWithBP();
		return bp.exec(firedto);
	}

	@Override
	public void sendMessagesToIE(BaseDTO[] dtos) throws BizException {
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS005-进入门诊手术撤回发往集成平台方法");
		for (BaseDTO baseDTO : dtos) {
			OrdEventLogger.info(this.getClass().getSimpleName(), "BS005-门诊 手术 撤回 msgDtoString:"+baseDTO.serializeJson()+",");
			//获取执行科室
			IEOpOrCancStpEnDTO ieusedto =(IEOpOrCancStpEnDTO) baseDTO;
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(baseDTO, BusiType.MZ,ieusedto.getExec_unit(),ieusedto.getIemsgca_code());//消息分发规则：门诊手术医嘱小分类					
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode(OrdEventUtil.CANCEL);
			mbx.setPatientCode(ieusedto.getPatient_id());
			mbx.setEntimes(Integer.parseInt(ieusedto.getTimes()));
			IEOpOrCancStpDTO ieOpOrCancStpDTO=null;
			if(!OrdEventUtil.isEmpty(ieusedto.getId_ieorcancstps())) {
				ieOpOrCancStpDTO=(IEOpOrCancStpDTO)ieusedto.getId_ieorcancstps().get(0);
				mbx.setApplyUnitId(ieOpOrCancStpDTO.getApply_code());// 第四位申请科室遍码
				mbx.setOrderNO(ieOpOrCancStpDTO.getOrder_id());
				mbx.setExtendSubId(ieOpOrCancStpDTO.getPayflag());// 扩展码-第八位收费标志位(0表示未收费，1表示收费)
			}
			FMap2 params = new FMap2();
	        params.put("VISIT_TYPE", ieusedto.getVisittype());// 第三位域ID（就诊类别）
	        mbx.setExtras(params);// 就诊类别，通过Map传递
			userobj.setMsgObj(mbx);
			OrdEventUtil.fireEvent(IOrdEventSources.EVENT_IE_CIOR_OP_CANC_STOP, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
			OrdEventLogger.info(this.getClass().getSimpleName(), "BS005-门诊撤回手术 往集成平台每次发送的数据:"+userobj.serializeJson());
		}
		
	}

}
