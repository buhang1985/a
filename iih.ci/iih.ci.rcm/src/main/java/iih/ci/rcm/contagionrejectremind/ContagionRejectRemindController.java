package iih.ci.rcm.contagionrejectremind;

import java.net.URI;
import java.util.Map;
import iih.ci.mrqc.qcremindmsgdto.d.QcRemindMsgDTO;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.sys.message.message.i.IGenerateRouserMsg;

public class ContagionRejectRemindController implements IGenerateRouserMsg{

	@Override
	public String getContent(Map<String, Object> arg0) throws BizException {
		// 消息内容
		QcRemindMsgDTO msgdto = getMessageDataInfo(arg0);		
		if (msgdto != null ) {
			String msg=msgdto.getCode_ent()+"患者"+msgdto.getPat_name()+"传染病报卡被驳回，驳回原因："+msgdto.getRemind_content();
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
		QcRemindMsgDTO msgdto = getMessageDataInfo(arg0);
		return new String[]{msgdto.getCreatedby()};
	}

	@Override
	public String[] getRecipients(BaseDO[] arg0, BaseDTO[] arg1) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTitle(Map<String, Object> arg0) throws BizException {
		return "提示！传染病报卡被驳回";
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

	public QcRemindMsgDTO getMessageDataInfo(Map<String, Object> arg0) {
		if (arg0 != null && arg0.size() > 0 && arg0.containsKey("MRCONREJECTREMIND")) {
			return (QcRemindMsgDTO) arg0.get("MRCONREJECTREMIND");
		}
		return null;
	}
}
