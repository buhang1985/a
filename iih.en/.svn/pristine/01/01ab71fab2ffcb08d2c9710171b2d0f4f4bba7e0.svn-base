package iih.en.pv.msg;

import iih.en.pv.inpatient.dto.d.IpSysMsgDTO;

import java.net.URI;
import java.util.Map;

import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.sys.message.message.i.IGenerateRouserMsg;

/**
 * 住院转出消息发送
 * 
 * @author jizb
 *
 */
public class IpTransOutMsgSender implements IGenerateRouserMsg {

	@Override
	public String getContent(Map<String, Object> paramMap) throws BizException {
		if(paramMap == null)
			return null;
		if(paramMap.containsKey(IpSysMsgDTO.class.getSimpleName())){
			IpSysMsgDTO ipSysMsgDTO = (IpSysMsgDTO) paramMap.get(IpSysMsgDTO.class.getSimpleName());
			if(ipSysMsgDTO != null)
				return ipSysMsgDTO.getName_dep_phy() + "," + ipSysMsgDTO.getName_dep_nur() + "的患者" + ipSysMsgDTO.getName_pat() + ",转科到本病区！";
		}
		return null;
	}

	@Override
	public String getContents(BaseDO[] arg0, BaseDTO[] arg1) throws BizException {
		return null;
	}

	@Override
	public String getDep(Map<String, Object> paramMap) throws BizException {
		if(paramMap == null)
			return null;
		if(paramMap.containsKey(IpSysMsgDTO.class.getSimpleName())){
			IpSysMsgDTO ipSysMsgDTO = (IpSysMsgDTO) paramMap.get(IpSysMsgDTO.class.getSimpleName());
			if(ipSysMsgDTO != null)
				return ipSysMsgDTO.getId_dep_nur();
		}
		return null;
	}

	@Override
	public String[] getRecipient(Map<String, Object> arg0) throws BizException {
		return null;
	}

	@Override
	public String[] getRecipients(BaseDO[] arg0, BaseDTO[] arg1) throws BizException {
		return null;
	}

	@Override
	public String getTitle(Map<String, Object> paramMap) throws BizException {
		if(paramMap == null)
			return null;
		if(paramMap.containsKey(IpSysMsgDTO.class.getSimpleName())){
			IpSysMsgDTO ipSysMsgDTO = (IpSysMsgDTO) paramMap.get(IpSysMsgDTO.class.getSimpleName());
			if(ipSysMsgDTO != null)
				return ipSysMsgDTO.getNoticecode();
		}
		return null;
	}

	@Override
	public String getTitles(BaseDO[] arg0, BaseDTO[] arg1) throws BizException {
		return null;
	}

	@Override
	public URI getURI() throws BizException {
		return null;
	}

}
