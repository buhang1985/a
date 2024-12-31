package iih.ci.mrm.s.mrmbackoff.qry;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import iih.ci.mrm.mrmbackoffmsgdto.d.MrmBackoffMsgDTO;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.sys.message.message.i.IGenerateRouserMsg;

public class MrmBackoffMsgController implements IGenerateRouserMsg {

	@Override
	public String getContent(Map<String, Object> arg0) throws BizException {
		MrmBackoffMsgDTO entArr = getMessageDataInfo(arg0);
		String msg="";	
		if(entArr != null){
//			for(MrmBackoffMsgDTO ent : entArr){
				msg+="患者："+entArr.getName_pat()+"  就诊号： "+entArr.getCode_amr_ip()+"  的病案被退回        退回人："+entArr.getName_dep_doc()+"     退回原因："+entArr.getBackoff_reason();
//			}
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
		//消息接收用户
		MrmBackoffMsgDTO entArr = getMessageDataInfo(arg0);
		if(entArr!=null){
			String  recipients = entArr.getId_psn();
			String [] str = {recipients};
			return str;
		}
		return null;
	}

	@Override
	public String[] getRecipients(BaseDO[] arg0, BaseDTO[] arg1) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTitle(Map<String, Object> arg0) throws BizException {
		// TODO Auto-generated method stub
		return null;
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

	public  MrmBackoffMsgDTO getMessageDataInfo(Map<String, Object> arg0) {		
		if (arg0 != null && arg0.size() > 0 && arg0.containsKey("CIMRMBACKOFF")) {
			return   (MrmBackoffMsgDTO)arg0.get("CIMRMBACKOFF");
		}
		return null;
	}
}
