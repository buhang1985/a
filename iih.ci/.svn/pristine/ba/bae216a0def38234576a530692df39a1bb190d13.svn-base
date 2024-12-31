package iih.ci.event.ord.bps.sign.ip.listenerbp;

import iih.ci.event.ord.bps.sign.ip.logicbp.IpOtherSignLogicDealWithBP;
import iih.ci.event.ord.listeners.OPIPSendIECommonListener;
import iih.ci.event.ord.utils.IOrdEventSources;
import iih.ci.event.ord.utils.OrdEventFireDTO;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.iemsg.d.IEOthOrDTO;
import iih.ci.ord.iemsg.d.IEOthOrEnDTO;
import xap.ip.event.BusiType;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IEventType;
/**
 * 住院 其他 签署 标准版逻辑BS305
 * @author F
 *
 * @date 2019年8月23日下午4:34:18
 *
 * @classpath iih.ci.event.ord.bps.sign.ip.listenerbp.IpOtherSignStandardBP
 */
public class IpOtherSignStandardBP extends OPIPSendIECommonListener{

	@Override
	public boolean isMatchSourceIdAndEventType(IBusinessEvent event)throws BizException{
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS305-住院签署 其他医嘱 判断事件源和事件类型");
		if(!(IOrdEventSources.IP_OTHER_SIGN.equals(event.getSourceID())&& IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType()))) {
			return false;
		}
		return true;
	}
	
	@Override
	public BaseDTO[] assembleData(BaseDTO baseDTO) throws BizException {
		OrdEventFireDTO firedto=(OrdEventFireDTO)baseDTO;
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS305-进入组装住院其他签署数据方法，id_ors:"+firedto.getIdors());
		IpOtherSignLogicDealWithBP bp=new IpOtherSignLogicDealWithBP();
		return bp.exec(firedto);
	}

	@Override
	public void sendMessagesToIE(BaseDTO[] msgdtos) throws BizException {
		//多个其他类型的签署 就会合并，这样消息头就会有问题  且收费标识ci_or_srv的fg_bl为N 就会取不到收费标识 手术也是这样
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS305-进入住院 其他 签署发往集成平台方法");
		for (Object object : msgdtos) {
			OrdEventLogger.info(this.getClass().getSimpleName(), "BS305-住院 其他 签署 msgDtoString:"+object.toString()+",");
			IEOthOrEnDTO ieothorendto = (IEOthOrEnDTO)object;
			IEOthOrDTO ieothordto = (IEOthOrDTO)(ieothorendto.getIeothors()).get(0);
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(object, BusiType.ZY,ieothordto.getExe_dept_code(), ieothordto.getSd_iemsgca());
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode(OrdEventUtil.NEW);
			mbx.setPatientCode(ieothorendto.getPatientid());
			mbx.setEntimes(Integer.parseInt(ieothorendto.getAdmiss_times()));
			mbx.setOrderNO(ieothordto.getYz_code());
			mbx.setEnNO(ieothorendto.getPatientseqnum());
			mbx.setExtendSubId(ieothordto.getFybj_code());// 扩展码-第八位收费标志位(0表示未收费，1表示收费)
			mbx.setApplyUnitId(ieothordto.getApply_code());// 第四位申请科室遍码
			FMap2 params = new FMap2();
	        params.put("VISIT_TYPE", ieothorendto.getVisit_type_code());// 第三位域ID（就诊类别）
	        mbx.setExtras(params);// 就诊类别，通过Map传递
	        userobj.setMsgObj(mbx);	
			//触发事件
			OrdEventUtil.fireEvent(IOrdEventSources.EVENT_IE_CIOR_NSCHK_OTH,IEventType.TYPE_UPDATE_AFTER,new BaseDTO[] { userobj });
			OrdEventLogger.info(this.getClass().getSimpleName(), "BS305-住院签署其他 往集成平台每次发送的数据:"+userobj.serializeJson());
		}
	}

}
