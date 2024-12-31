package iih.bl.itf.std;

import xap.mw.core.data.BizException;

/**
 * 费用标准对外服务--对账服务
 * @author ly 2018/07/29
 *
 */
public interface IBlBalanceAccountService {

	/**
	 * 查询对账信息(预交金)
	 * @param param
	 * @return
	 * @throws BizException
	 * @author ly 2018/07/29
	 */
	public abstract String getTradeInfo (String param) throws BizException;
	/**
	 * 微信支付宝对账接口
	 * @param param
	 * @return
	 * @author zhang 2019年3月27日
	 * @throws BizException
	 */
	public abstract String getPayInfos (String param) throws BizException;
	
	/**
	 * 查询对账信息(收付款)
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract String getPayTradeInfo(String param) throws BizException;
	
}
