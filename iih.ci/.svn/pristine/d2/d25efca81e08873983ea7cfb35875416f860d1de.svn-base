package iih.ci.event.ord.bps.sign.ip.listenerbp;

import iih.ci.event.ord.bps.sign.ip.logicbp.IpNsSignLogicDealWithBP;
import iih.ci.event.ord.listeners.OPIPSendIECommonListener;
import iih.ci.event.ord.utils.IOrdEventSources;
import iih.ci.event.ord.utils.OrdEventFireDTO;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.iemsg.d.IENsOrDTO;
import iih.ci.ord.iemsg.d.IENsOrEnDTO;
import xap.ip.event.BusiType;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IEventType;
/**
 * 住院 护理 签署 标准版逻辑BS304
 * @author F
 *
 * @date 2019年8月28日下午4:31:25
 *
 * @classpath iih.ci.event.ord.bps.sign.ip.listenerbp.IpNsSignStandardBP
 */
public class IpNsSignStandardBP extends OPIPSendIECommonListener{

	@Override
	public boolean isMatchSourceIdAndEventType(IBusinessEvent event)throws BizException{
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS304-住院签署护理判断事件源和事件类型");
		if(!(IOrdEventSources.IP_NS_SIGN.equals(event.getSourceID())&& IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType()))) {
			return false;
		}
		return true;
	}
	
	@Override
	public BaseDTO[] assembleData(BaseDTO baseDTO) throws BizException {
		OrdEventFireDTO firedto=(OrdEventFireDTO)baseDTO;
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS304-进入组装住院护理签署数据方法，id_ors:"+firedto.getIdors());
		IpNsSignLogicDealWithBP bp=new IpNsSignLogicDealWithBP();
		return bp.exec(firedto);
		//return bp.execOfNoMerge(firedto);
	}

	@Override
	public void sendMessagesToIE(BaseDTO[] dtos) throws BizException {
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS304-进入 住院护理签署 发往集成平台方法");
		for (BaseDTO baseDTO : dtos) {
			OrdEventLogger.info(this.getClass().getSimpleName(), "BS304-住院 护理 签署 msgDtoString:"+baseDTO.serializeJson()+",");
			//获取执行科室
			IENsOrEnDTO iensdto=(IENsOrEnDTO) baseDTO;
			IENsOrDTO iensordto=(IENsOrDTO) (iensdto.getId_iensors()).get(0);
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(baseDTO, BusiType.ZY,iensordto.getExe_dept_code(),iensordto.getSd_iemsgca());
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode(OrdEventUtil.NEW);
			mbx.setPatientCode(iensdto.getPatientid());
			mbx.setEntimes(Integer.parseInt(iensdto.getAdmiss_times()));
			mbx.setOrderNO(iensordto.getOrder_code());
			mbx.setEnNO(iensdto.getPatientseqnum());
			mbx.setExtendSubId(iensordto.getPay_flag());// 扩展码-第八位收费标志位(0表示未收费，1表示收费)
			mbx.setApplyUnitId(iensdto.getApply_code());// 第四位申请科室遍码
			FMap2 params = new FMap2();
	        params.put("VISIT_TYPE", iensdto.getVisit_type_code());// 第三位域ID（就诊类别）
	        mbx.setExtras(params);// 就诊类别，通过Map传递
			userobj.setMsgObj(mbx);	
			OrdEventUtil.fireEvent(IOrdEventSources.EVENT_IE_CIOR_NSCHK_NS, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
			OrdEventLogger.info(this.getClass().getSimpleName(), "BS304-住院签署护理 往集成平台每次发送的数据:"+userobj.serializeJson());
		}
	}

}
