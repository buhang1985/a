package iih.ci.event.ord.bps.revert.op.listenerbp;

import iih.ci.event.ord.bps.revert.op.logicbp.OpTreatRevertLogicDealWithBP;
import iih.ci.event.ord.listeners.OPIPSendIECommonListener;
import iih.ci.event.ord.utils.IOrdEventSources;
import iih.ci.event.ord.utils.OrdEventFireDTO;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.iemsg.d.IEOpTreatOrDTO;
import iih.ci.ord.iemsg.d.IEOpTreatOrEnDTO;
import xap.ip.event.BusiType;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IEventType;
/**
 * 门诊 治疗 撤回标注版BS303
 * @author F
 *
 * @date 2019年9月11日下午1:14:02
 *
 * @classpath iih.ci.event.ord.bps.revert.op.listenerbp.OpTreatRevertStandardBP
 */
public class OpTreatRevertStandardBP extends OPIPSendIECommonListener{

	@Override
	public boolean isMatchSourceIdAndEventType(IBusinessEvent event) throws BizException {
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS303-门诊撤回 治疗判断事件源和事件类型");
		if (!(IOrdEventSources.OP_TREAT_REVERT.equals(event.getSourceID())
				&& IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType()))) {
			return false;
		}
		return true;
	}

	@Override
	public BaseDTO[] assembleData(BaseDTO baseDTO) throws BizException {
		OrdEventFireDTO firedto=(OrdEventFireDTO)baseDTO;
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS303-进入组装 门诊治疗撤回数据方法，id_ors:"+firedto.getIdors());
		OpTreatRevertLogicDealWithBP bp=new OpTreatRevertLogicDealWithBP();
		return bp.exec(firedto);
	}

	@Override
	public void sendMessagesToIE(BaseDTO[] dtos) throws BizException {
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS303-进入门诊治疗撤回发往集成平台方法");
		for (BaseDTO baseDTO : dtos) {
			OrdEventLogger.info(this.getClass().getSimpleName(), "BS303-门诊 治疗 撤回 msgDtoString:"+baseDTO.serializeJson()+",");
			//获取执行科室
			IEOpTreatOrEnDTO ielisdto =(IEOpTreatOrEnDTO) baseDTO;
			IEOpTreatOrDTO ielisordto=null;
			@SuppressWarnings("unused")
			String iemsgca=null;
			String execDept=null;
			MsgObj mbx=new MsgObj();
			if(!OrdEventUtil.isEmpty(ielisdto.getIetreators())) {
				ielisordto=(IEOpTreatOrDTO) (ielisdto.getIetreators()).get(0);	
				iemsgca=ielisordto.getSd_iemsgca();
				execDept=ielisordto.getExec_sn();
				mbx.setOrderNO(ielisordto.getOrder_no());
				mbx.setExtendSubId(ielisordto.getPayflag());// 扩展码-第八位收费标志位(0表示未收费，1表示收费)
			}
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(baseDTO, BusiType.MZ,execDept,"099");
			mbx.setInteractionCode(OrdEventUtil.DELETE);
			mbx.setPatientCode(ielisdto.getPatient_id());
			mbx.setEntimes(Integer.parseInt(ielisdto.getAdmiss_times()));
			mbx.setEnNO(ielisdto.getP_bar_code());
			mbx.setApplyUnitId(ielisdto.getApply_code());// 第四位申请科室遍码
			FMap2 params = new FMap2();
	        params.put("VISIT_TYPE", ielisdto.getVisittype());// 第三位域ID（就诊类别）
	        mbx.setExtras(params);
			userobj.setMsgObj(mbx);	
			OrdEventUtil.fireEvent(IOrdEventSources.EVENT_IE_CIOR_OP_TREAT, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });	
			OrdEventLogger.info(this.getClass().getSimpleName(), "BS303-门诊撤回治疗 往集成平台每次发送的数据:"+userobj.serializeJson());
		}
		
	}

}
