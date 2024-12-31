package iih.ci.event.ord.bps.sign.ip.listenerbp;

import iih.ci.event.ord.bps.sign.ip.logicbp.IpConCompleteLogicDealWithBP;
import iih.ci.event.ord.listeners.OPIPSendIECommonListener;
import iih.ci.event.ord.utils.IOrdEventSources;
import iih.ci.event.ord.utils.OrdEventFireDTO;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.mr.cimripbasedto.d.CiMrIPBaseDTO;
import xap.ip.event.BusiType;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 住院会诊完成BS340标准版
 * @author zhengqiang
 *
 */
public class IpConCompleteStandardBP extends OPIPSendIECommonListener{

	@Override
	public boolean isMatchSourceIdAndEventType(IBusinessEvent event) throws BizException {
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS340-住院会诊完成  判断事件源和事件类型");
		if(!(IOrdEventSources.IP_CON_COMPLETE.equals(event.getSourceID()) && IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType()))){
			return false;
		}
		return true;
	}

	@Override
	public BaseDTO[] assembleData(BaseDTO baseDTO) throws BizException {
		OrdEventFireDTO firedto=(OrdEventFireDTO)baseDTO;
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS340-进入组装住院会诊完成数据方法，id_ors:"+firedto.getIdors());
		IpConCompleteLogicDealWithBP bp = new IpConCompleteLogicDealWithBP();
		return bp.exec(firedto);
	}

	@Override
	public void sendMessagesToIE(BaseDTO[] dtos) throws BizException {
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS340-进入 住院会诊完成时 发往集成平台方法");
		for (BaseDTO baseDTO : dtos) {
			OrdEventLogger.info(this.getClass().getSimpleName(), "BS340-住院会诊完成时 msgDtoString:"+baseDTO.serializeJson()+",");
			CiMrIPBaseDTO ipcidto =(CiMrIPBaseDTO) baseDTO;
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(baseDTO, BusiType.ZY,ipcidto.getCode_dept(),ipcidto.getType_message());
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode(OrdEventUtil.NEW);
			mbx.setPatientCode(ipcidto.getId_pat());
			mbx.setEntimes(Integer.parseInt(ipcidto.getTimes_ip()));
			mbx.setEnNO(ipcidto.getId_ent());
			mbx.setApplyNO(ipcidto.getRequestno());
			mbx.setOrderNO(ipcidto.getCons_orderid());
			mbx.setExtendSubId(ipcidto.getPayfalg());// 扩展码-第八位收费标志位(0表示未收费，1表示收费)
			mbx.setApplyUnitId(ipcidto.getCons_code_reqdept());// 第四位申请科室遍码
			FMap2 params = new FMap2();
	        params.put("VISIT_TYPE", ipcidto.getCode_entp());// 第三位域ID（就诊类别）
	        mbx.setExtras(params);
			userobj.setMsgObj(mbx);	
			OrdEventUtil.fireEvent(IOrdEventSources.EVENT_IE_CIOR_NSCHK_CON_COMPLETE, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
			OrdEventLogger.info(this.getClass().getSimpleName(), "BS340-住院会诊完成时往集成平台每次发送的数据:"+userobj.serializeJson());
			
		}
	}

  
}
