package iih.ci.event.ord.bps.stop.ip.listenerbp;

import iih.ci.event.ord.bps.stop.ip.logicbp.IpStopLogicDealWithBP;
import iih.ci.event.ord.listeners.OPIPSendIECommonListener;
import iih.ci.event.ord.utils.IOrdEventSources;
import iih.ci.event.ord.utils.OrdEventFireDTO;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.iemsg.d.IEOrCancStpDTO;
import iih.ci.ord.iemsg.d.IEOrCancStpEnDTO;
import xap.ip.event.BusiType;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IEventType;
/**
 * 住院停止标准版BS005
 * @author F
 *
 * @date 2019年9月3日上午11:51:27
 *
 * @classpath iih.ci.event.ord.bps.stop.ip.listenerbp.IpStopStandardBP
 */
public class IpStopStandardBP extends OPIPSendIECommonListener{

	@Override
	public boolean isMatchSourceIdAndEventType(IBusinessEvent event) throws BizException {
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS005-住院停止判断事件源和事件类型");
		if(!(IOrdEventSources.IP_STOP_SIGN.equals(event.getSourceID())&& IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType()))) {
			return false;
		}
		return true;
	}

	@Override
	public BaseDTO[] assembleData(BaseDTO baseDTO) throws BizException {
		OrdEventFireDTO firedto=(OrdEventFireDTO)baseDTO;
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS005-进入组装住院停止数据方法，id_ors:"+firedto.getIdors());
		IpStopLogicDealWithBP bp = new IpStopLogicDealWithBP();
		return bp.execNew(firedto);
	}

	@Override
	public void sendMessagesToIE(BaseDTO[] dtos) throws BizException {
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS005-进入 住院停止 发往集成平台方法");
		for (BaseDTO baseDTO : dtos) {
			OrdEventLogger.info(this.getClass().getSimpleName(), "BS005-住院停止 msgDtoString:"+baseDTO.serializeJson()+",");
			IEOrCancStpEnDTO ieusedto =(IEOrCancStpEnDTO) baseDTO;
			IEOrCancStpDTO ieOrCancStpDTO=null;
			String iemsgca_codeString=null;
			MsgObj mbx=new MsgObj();
			if(!OrdEventUtil.isEmpty(ieusedto.getId_ieorcancstps())) {
				ieOrCancStpDTO=(IEOrCancStpDTO)ieusedto.getId_ieorcancstps().get(0);
				mbx.setOrderNO(ieOrCancStpDTO.getOrderno());
				mbx.setSpecimenNO(ieOrCancStpDTO.getBbno());
				iemsgca_codeString=ieOrCancStpDTO.getIemsgca_code();
				mbx.setExtendSubId(ieOrCancStpDTO.getPayflag());// 扩展码-第八位收费标志位(0表示未收费，1表示收费)
			}
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(baseDTO, BusiType.ZY,ieusedto.getExec_dept_code(),iemsgca_codeString);
			mbx.setInteractionCode(OrdEventUtil.STOP);
			mbx.setPatientCode(ieusedto.getPatientid());
			mbx.setEntimes(Integer.parseInt(ieusedto.getAdmiss_times()));
			mbx.setApplyUnitId(ieusedto.getApply_code());// 第四位申请科室遍码
			FMap2 params = new FMap2();
	        params.put("VISIT_TYPE", ieusedto.getVisit_type_code());// 第三位域ID（就诊类别）
	        mbx.setExtras(params);// 就诊类别，通过Map传递
			userobj.setMsgObj(mbx);	
			OrdEventUtil.fireEvent(IOrdEventSources.EVENT_IE_CIOR_NSCHK_CANC_STOP, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
			OrdEventLogger.info(this.getClass().getSimpleName(), "BS005-住院停止 往集成平台每次发送的数据:"+userobj.serializeJson());
		}
	}

}