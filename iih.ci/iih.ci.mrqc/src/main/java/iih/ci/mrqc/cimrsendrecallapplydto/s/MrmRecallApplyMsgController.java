package iih.ci.mrqc.cimrsendrecallapplydto.s;

import java.net.URI;
import java.util.Map;

import iih.ci.mrqc.cimrsendrecallapplydto.d.CiMrSendRecallApplyDTO;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.sys.message.message.i.IGenerateRouserMsg;

public class MrmRecallApplyMsgController implements IGenerateRouserMsg{

	@Override
	public String getContent(Map<String, Object> arg0) throws BizException {
		//消息内容
		CiMrSendRecallApplyDTO recallapply = getMessageDataInfo(arg0);
		String msg="";	
		if(recallapply != null){
			//for(CiMrSendRecallApplyDTO applydto : recallapply){
				msg+="患者："+recallapply.getPat_name()+"  病案号："+recallapply.getCode_en_ip()+"  召回申请被驳回！ 驳回人："+recallapply.getName_recall();
			//}
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
		CiMrSendRecallApplyDTO applydto = getMessageDataInfo(arg0);
		if(applydto != null ){
			String  user_id = applydto.getId_apply_user();
			String [] str = {user_id};
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
	
	@SuppressWarnings("unchecked")
	public  CiMrSendRecallApplyDTO getMessageDataInfo(Map<String, Object> arg0) {		
		if (arg0 != null && arg0.size() > 0 && arg0.containsKey("CIMRRecallApply")) {
			return   (CiMrSendRecallApplyDTO)arg0.get("CIMRRecallApply");
		}
		return null;
	}

}
