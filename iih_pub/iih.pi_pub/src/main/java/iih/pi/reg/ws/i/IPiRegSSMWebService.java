package iih.pi.reg.ws.i;

import xap.mw.core.data.BizException;

/**
 * 兰陵自助机接口
 * 
 * @author dj.zhang
 *
 */
public interface IPiRegSSMWebService {

	/**
	 * 患者注册发卡
	 */
	public abstract String patRegAndDistrCard(String paramXml) throws BizException;

	/**
	 * 患者校验，返回患者是否存在
	 * 
	 */
	public abstract String patValidate(String paramXml) throws BizException;

}
