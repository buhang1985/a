package iih.ci.event.ord.bps.sign.ip.listenerbp;

import iih.ci.event.ord.bps.sign.ip.logicbp.IpTreatSignLogicDealWithBP;
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
 * 住院 治疗 签署 标准版逻辑BS002
 * @author F
 *
 * @date 2019年8月29日下午2:17:59
 *
 * @classpath iih.ci.event.ord.bps.sign.ip.listenerbp.IpTreatSignStandardBP
 */
public class IpTreatSignStandardBP extends OPIPSendIECommonListener{

	@Override
	public boolean isMatchSourceIdAndEventType(IBusinessEvent event)throws BizException{
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS303-住院签署 治疗医嘱 判断事件源和事件类型");
		if(!(IOrdEventSources.IP_TREAT_SIGN.equals(event.getSourceID())&& IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType()))) {
			return false;
		}
		return true;
	}
	
	@Override
	public BaseDTO[] assembleData(BaseDTO baseDTO) throws BizException {
		OrdEventFireDTO firedto=(OrdEventFireDTO)baseDTO;
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS303-进入组装住院治疗签署数据方法，id_ors:"+firedto.getIdors());
		IpTreatSignLogicDealWithBP bp=new IpTreatSignLogicDealWithBP();
		return bp.exec(firedto);
	}

	@Override
	public void sendMessagesToIE(BaseDTO[] dtos) throws BizException {
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS303-进入 住院治疗签署 发往集成平台方法");
		for (BaseDTO baseDTO : dtos) {
			OrdEventLogger.info(this.getClass().getSimpleName(), "BS303-住院 治疗 签署 msgDtoString:"+baseDTO.serializeJson()+",");
			IEOpTreatOrEnDTO ielisdto =(IEOpTreatOrEnDTO) baseDTO;
			IEOpTreatOrDTO ielisordto=null;
			String execDeptString=null;//执行科室
			@SuppressWarnings("unused")
			String iemsgcaString=null;//集成分类
			String payFlayString=null;//收费标识
			String yzNoString=null;//医嘱编号
			if(!OrdEventUtil.isEmpty(ielisdto.getIetreators())) {
				ielisordto=(IEOpTreatOrDTO) (ielisdto.getIetreators()).get(0);	
				execDeptString=ielisordto.getExec_sn();
				iemsgcaString=ielisordto.getSd_iemsgca();
				payFlayString=ielisordto.getPayflag();
				yzNoString=ielisordto.getYz_no();
			}
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(baseDTO, BusiType.ZY,execDeptString,"0");
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode(OrdEventUtil.NEW);
			mbx.setPatientCode(ielisdto.getPatient_id());
			mbx.setEntimes(Integer.parseInt(ielisdto.getAdmiss_times()));
			mbx.setOrderNO(yzNoString);
			mbx.setEnNO(ielisdto.getP_bar_code());
			mbx.setExtendSubId(payFlayString);// 扩展码-第八位收费标志位(0表示未收费，1表示收费)
			mbx.setApplyUnitId(ielisdto.getApply_code());// 第四位申请科室遍码
			FMap2 params = new FMap2();
	        params.put("VISIT_TYPE", ielisdto.getVisittype());// 第三位域ID（就诊类别）
	        mbx.setExtras(params);
			userobj.setMsgObj(mbx);	
			OrdEventUtil.fireEvent(IOrdEventSources.EVENT_IE_CIOR_NSCHK_TREAT, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });		
			OrdEventLogger.info(this.getClass().getSimpleName(), "BS303-住院签署治疗 往集成平台每次发送的数据:"+userobj.serializeJson());
		}
		
	}

}
