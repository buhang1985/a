package iih.ci.mr.s.bp.message;

import java.net.URI;
import java.util.Map;

import iih.ci.mrm.dto.cimrmqrylist.d.CiMrmQryListDTO;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.sys.message.message.i.IGenerateRouserMsg;

public class MrUnFinishedMsgController implements IGenerateRouserMsg {

	@Override
	public String getContent(Map<String, Object> arg0) throws BizException {
		CiMrmQryListDTO entArr = getMessageDataInfo(arg0);
		String msg="";	
		if(entArr != null){
			msg = entArr.getBakeoffreason();
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
		CiMrmQryListDTO entArr = getMessageDataInfo(arg0);
		if(entArr != null){
			String  recipients = entArr.getId_emp_phy();
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
	
	public  CiMrmQryListDTO getMessageDataInfo(Map<String, Object> arg0) {		
		if (arg0 != null && arg0.size() > 0 && arg0.containsKey("CIMRUNFINISHED")) {
			return   (CiMrmQryListDTO)arg0.get("CIMRUNFINISHED");
		}
		return null;
	}

}
