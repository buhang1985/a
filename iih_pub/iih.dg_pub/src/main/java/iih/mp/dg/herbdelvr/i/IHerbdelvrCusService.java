package iih.mp.dg.herbdelvr.i;

import xap.mw.core.data.BizException;

/**
 * 草药配送对接第三方服务
 * 
 * @author dj.zhang
 *
 */
public interface IHerbdelvrCusService {

	/**
	 * 门诊草药外送（对接第三方接口）
	 * 
	 * @param presId
	 * @return 返回值 状态码： 0 标识调用成功 1 标识调用失败
	 * @throws BizException
	 */
	public abstract String outDelivery(String presId) throws BizException;

	/**
	 * 门诊草药取消外送（对接第三方接口）
	 * 
	 * @param presId
	 * @return 返回值 状态码： 0 标识调用成功 1 标识调用失败
	 * @throws BizException
	 */
	public abstract String cancelDelivery(String presId) throws BizException;
}
