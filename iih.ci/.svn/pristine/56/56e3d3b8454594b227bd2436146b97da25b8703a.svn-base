package iih.ci.rcm.hosreminder.s;

import java.net.URI;
import java.util.Map;

import iih.ci.rcm.hosremindermsgdto.d.HosReminderMsgDTO;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.sys.message.message.i.IGenerateRouserMsg;

public class HosReminderMsgController implements IGenerateRouserMsg {

	@Override
	public String getContent(Map<String, Object> arg0) throws BizException {
		// 消息内容
		HosReminderMsgDTO msgdto = getMessageDataInfo(arg0);
		
		if (msgdto != null ) {
			return "请前往住院医生站填写"+msgdto.getName_bed()+"床"+msgdto.getName_pat()+"患者院感报卡！";	
		}
		return null;
	}

	@Override
	public String getContents(BaseDO[] arg0, BaseDTO[] arg1) throws BizException {
		return null;
	}

	@Override
	public String getDep(Map<String, Object> arg0) throws BizException {
		// 消息接收科室
		HosReminderMsgDTO msgdto = getMessageDataInfo(arg0);
		return msgdto.getId_dept();
	}

	@Override
	public String[] getRecipient(Map<String, Object> arg0) throws BizException {
		// 消息接收用户
		HosReminderMsgDTO msgdto = getMessageDataInfo(arg0);
		return new String[]{ msgdto.getId_doc()};
	}

	@Override
	public String[] getRecipients(BaseDO[] arg0, BaseDTO[] arg1) throws BizException {
		return null;
	}

	@Override
	public String getTitle(Map<String, Object> arg0) throws BizException {
		
		return "提示！请填写院感报卡";
	}

	@Override
	public String getTitles(BaseDO[] arg0, BaseDTO[] arg1) throws BizException {
		return null;
	}

	@Override
	public URI getURI() throws BizException {
		return null;
	}
	
	public HosReminderMsgDTO getMessageDataInfo(Map<String, Object> arg0) {
		
		if (arg0 != null && arg0.size() > 0 && arg0.containsKey("CIRCMFILLINHOS")) {
			return (HosReminderMsgDTO) arg0.get("CIRCMFILLINHOS");
		}
		return null;
	}

}
