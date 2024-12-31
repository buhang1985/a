package iih.ci.rcm.reportrejectedremind;

import java.net.URI;
import java.util.Map;

import iih.ci.mrqc.qcremindmsgdto.d.QcRemindMsgDTO;
import iih.ci.rcm.reportcarddoc.d.Reportcarddocdto;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.sys.message.message.i.IGenerateRouserMsg;

public class ReportRejectedRemindController implements IGenerateRouserMsg {
	@Override
	public String getContent(Map<String, Object> arg0) throws BizException {
		// 消息内容
		Reportcarddocdto msgdto = getMessageDataInfo(arg0);		
		if (msgdto != null ) {
			String msg="患者："+msgdto.getSuffer_name()+"； 就诊号："+msgdto.getId_ent()+"； 报卡名称："+msgdto.getName()+"； 驳回原因："+msgdto.getReason_reject()+"；";
			return msg;
		}
		return null;
	}

	@Override
	public String getContents(BaseDO[] arg0, BaseDTO[] arg1) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDep(Map<String, Object> arg0) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getRecipient(Map<String, Object> arg0) throws BizException {
		// 消息接收用户
		Reportcarddocdto msgdto = getMessageDataInfo(arg0);
		return new String[]{msgdto.getCreatedby()};
	}

	@Override
	public String[] getRecipients(BaseDO[] arg0, BaseDTO[] arg1) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTitle(Map<String, Object> arg0) throws BizException {
		return "提示！报卡被驳回";
	}

	@Override
	public String getTitles(BaseDO[] arg0, BaseDTO[] arg1) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public URI getURI() throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	public Reportcarddocdto getMessageDataInfo(Map<String, Object> arg0) {
		if (arg0 != null && arg0.size() > 0 && arg0.containsKey("MR0001")) {
			return (Reportcarddocdto) arg0.get("MR0001");
		}
		return null;
	}
}
