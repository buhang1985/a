package iih.ci.event.ord.bps.revert.op.listenerbp;

import iih.ci.event.ord.bps.revert.op.logicbp.OpBuRevertLogicDealWithBP;
import iih.ci.event.ord.listeners.OPIPSendIECommonListener;
import iih.ci.event.ord.utils.IOrdEventSources;
import iih.ci.event.ord.utils.OrdEventFireDTO;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.iemsg.d.IEOpBtUseOrDTO;
import xap.ip.event.BusiType;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IEventType;
/**
 * 门诊用血撤回标准版BS309
 * @author F
 *
 * @date 2019年10月10日下午2:16:52
 *
 * @classpath iih.ci.event.ord.bps.revert.op.listenerbp.OpBuRevertStandardBP
 */
public class OpBuRevertStandardBP extends OPIPSendIECommonListener{

	@Override
	public boolean isMatchSourceIdAndEventType(IBusinessEvent event)throws BizException{
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS309-门诊撤回用血判断事件源和事件类型");
		if(!(IOrdEventSources.OP_BU_REVERT.equals(event.getSourceID())&& IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType()))) {
			return false;	
		}
		return true;
	}
	
	@Override
	public BaseDTO[] assembleData(BaseDTO baseDTO) throws BizException {
		OrdEventFireDTO firedto=(OrdEventFireDTO)baseDTO;
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS309-进入组装门诊用血撤回数据方法，id_ors:"+firedto.getIdors());
		OpBuRevertLogicDealWithBP bp=new OpBuRevertLogicDealWithBP();
		return bp.exec(firedto);
	}

	@Override
	public void sendMessagesToIE(BaseDTO[] dtos) throws BizException {
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS309-进入门诊用血撤回发往集成平台方法");
		for (BaseDTO baseDTO : dtos) {
			OrdEventLogger.info(this.getClass().getSimpleName(), "BS309-门诊 用血 撤回 msgDtoString:"+baseDTO.serializeJson()+",");
			//获取执行科室
			IEOpBtUseOrDTO iebudto =(IEOpBtUseOrDTO) baseDTO;
			@SuppressWarnings("unused")
			String iemsgcaString=iebudto.getIemsgca_code();
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(baseDTO, BusiType.MZ,iebudto.getExec_code(),"099");
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode(OrdEventUtil.DELETE);
			mbx.setPatientCode(iebudto.getPatient_id());
			mbx.setEntimes(Integer.parseInt(iebudto.getTimes()));
			mbx.setEnNO(iebudto.getP_bar_code());
			mbx.setApplyNO(iebudto.getUse_sn());
			mbx.setOrderNO(iebudto.getYz_no());
			mbx.setExtendSubId(iebudto.getPay_flag());// 扩展码-第八位收费标志位(0表示未收费，1表示收费)
			mbx.setApplyUnitId(iebudto.getApply_code());// 第四位申请科室遍码
			FMap2 params = new FMap2();
	        params.put("VISIT_TYPE", iebudto.getVisit_type());// 第三位域ID（就诊类别）
	        mbx.setExtras(params);
			userobj.setMsgObj(mbx);	
			OrdEventUtil.fireEvent(IOrdEventSources.EVENT_IE_CIOR_OP_UBT, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });	
			OrdEventLogger.info(this.getClass().getSimpleName(), "BS309-门诊撤回用血 往集成平台每次发送的数据:"+userobj.serializeJson());
		}
		
	}
}
