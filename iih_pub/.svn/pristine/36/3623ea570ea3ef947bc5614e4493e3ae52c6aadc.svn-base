package iih.bl.itf.std;

import xap.mw.core.data.BizException;

/**
 * 费用标准对外服务--住院记账服务
 * @author ly 2018/7/16
 *
 */
public interface IBlIpChargeService {

	/**
	 * 住院退补费
	 * @param param
	 * @return
	 * @throws BizException
	 * @author ly 2018/7/16
	 */
	public abstract String setCostAppendToIIH(String param) throws BizException;
	
	/**
	 * 住院自助结算-住院待结算调入（含审核、调入、结算）
	 * @author : hanjq 2019年10月23日 下午4:07:31
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract String settlement(String param) throws BizException;
	
	/**
	 * 住院自助支付
	 * @author : hanjq 2019年10月25日 上午10:27:35
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract String payment(String param) throws BizException;
	
}
