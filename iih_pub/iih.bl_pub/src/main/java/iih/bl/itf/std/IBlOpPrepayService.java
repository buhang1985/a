package iih.bl.itf.std;

import xap.mw.core.data.BizException;

/**
 * 费用标准对外服务--门诊预交金服务
 * @author ly 2018/7/16
 *
 */
public interface IBlOpPrepayService {

	/**
	 * 门诊预交金充值
	 * @param param
	 * @return
	 * @throws BizException
	 * @author ly 2018/7/16
	 */
	public abstract String recharge(String param) throws BizException;
	
	/**
	 * 门诊预交金退充值校验
	 * @param param
	 * @return
	 * @throws BizException
	 * @author ly 2019/11/21
	 */
	public abstract String refundCheck(String param) throws BizException;
	
	/**
	 * 门诊预交金退充值
	 * @param param
	 * @return
	 * @throws BizException
	 * @author ly 2019/11/21
	 */
	public abstract String refund(String param) throws BizException;
}
