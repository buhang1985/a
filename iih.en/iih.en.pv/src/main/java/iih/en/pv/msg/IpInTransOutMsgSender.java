package iih.en.pv.msg;

import iih.en.pv.inpatient.dto.d.IpSysMsgDTO;

import java.net.URI;
import java.util.Map;

import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.sys.message.message.i.IGenerateRouserMsg;

/**
 * 住院入出转消息发送
 * 
 * @author liubin
 *
 */
public class IpInTransOutMsgSender implements IGenerateRouserMsg {

	@Override
	public URI getURI() throws BizException {
		return null;
	}

	@Override
	public String getContent(Map<String, Object> paramMap) throws BizException {
		if(paramMap == null)
			return null;
		if(paramMap.containsKey(IpSysMsgDTO.class.getSimpleName())){
			IpSysMsgDTO ipSysMsg = (IpSysMsgDTO) paramMap.get(IpSysMsgDTO.class.getSimpleName());
			if(ipSysMsg != null)
				return ipSysMsg.getId_dep_nur();
		}
		return null;
	}

	@Override
	public String getTitle(Map<String, Object> paramMap) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getRecipient(Map<String, Object> paramMap)
			throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getContents(BaseDO[] paramArrayOfBaseDO,
			BaseDTO[] paramArrayOfBaseDTO) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTitles(BaseDO[] paramArrayOfBaseDO,
			BaseDTO[] paramArrayOfBaseDTO) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getRecipients(BaseDO[] paramArrayOfBaseDO,
			BaseDTO[] paramArrayOfBaseDTO) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDep(Map<String, Object> var) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

}
