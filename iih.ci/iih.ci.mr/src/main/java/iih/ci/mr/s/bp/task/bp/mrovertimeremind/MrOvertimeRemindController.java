package iih.ci.mr.s.bp.task.bp.mrovertimeremind;

import java.net.URI;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import iih.ci.mrqc.qcremindmsgdto.d.QcRemindMsgDTO;
import xap.lui.core.xml.StringUtils;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.sys.message.message.i.IGenerateRouserMsg;

public class MrOvertimeRemindController implements IGenerateRouserMsg{

	@Override
	public String getContent(Map<String, Object> arg0) throws BizException {
		// 消息内容
		QcRemindMsgDTO msgdto = getMessageDataInfo(arg0);	
		if (msgdto != null) {		
			String msg=msgdto.getDep_phy_name()+msgdto.getCode_ent()+"患者："+msgdto.getPat_name()+" ";
			if(!StringUtils.isEmptyWithTrim(msgdto.getName_tmpl_remind())){
				msg+="病历模板为《"+msgdto.getName_tmpl_remind()+"》的";
			}
			msg+="住院病历待书写文书《"+msgdto.getMr_name()+"》即将超时，请尽快书写并签署!";	
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
		// 责任医师
		String user1=msgdto.getId_psn();
		// 创建人
		String user2=msgdto.getCreatedby();
		// 最后修改人
		String user3=msgdto.getModifiedby();
	    Set<String> set=new HashSet<String>();
	    if(!StringUtils.isEmptyWithTrim(user1)){
	    	set.add(user1);
	    }
	    if(!StringUtils.isEmptyWithTrim(user2)){
	    	set.add(user2);
	    }
	    if(!StringUtils.isEmptyWithTrim(user3)){
	    	set.add(user3);
	    }
		return (String[]) set.toArray(new String[set.size()]);
	}

	@Override
	public String[] getRecipients(BaseDO[] arg0, BaseDTO[] arg1) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTitle(Map<String, Object> arg0) throws BizException {
		return "提示！住院病历待书写文书超时";
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
		if (arg0 != null && arg0.size() > 0 && arg0.containsKey("CIMROTREMIND")) {
			return (QcRemindMsgDTO) arg0.get("CIMROTREMIND");
		}
		return null;
	}
}
