/**
 * 
 */
package iih.bl.itf.std;

import xap.mw.core.data.BizException;

/**
 * 预交金扩展服务接口
 * 
 * @author dupeng 2018-04-27
 *
 */
public interface IBlPrepayExternalService {
	
	/**
	 * 住院预交金(押金)缴费
	 * 
	 * @param paramXml 参数XML
	 * @return
	 * @throws BizException
	 */
	public abstract String saveIpPrepayToIIH(String paramXml) throws BizException;
	
	/**
	 * 门诊预交金(预付费账户)缴费
	 * 
	 * @param paramXml 参数XML
	 * @return
	 * @throws BizException
	 */
	public abstract String saveOpPrepayToIIH(String paramXml) throws BizException;

}
