package iih.bl.itf.std;

import iih.bl.itf.std.bp.balacc.GetPayTradeInfo;
import iih.bl.itf.std.bp.balacc.GetThirdPayInfoBP;
import iih.bl.itf.std.bp.balacc.GetTradeInfoBP;
import xap.mw.core.data.BizException;

/**
 * 费用标准对外服务--对账服务
 * 
 * @author ly 2018/07/29
 *
 */
public class BlBalanceAccountServiceImpl implements IBlBalanceAccountService {

	/**
	 * 查询对账信息(预交金)
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 * @author ly 2018/07/29
	 */
	@Override
	public String getTradeInfo(String param) throws BizException {
		GetTradeInfoBP bp = new GetTradeInfoBP();
		return bp.exec(param);
	}

	/**
	 * 微信支付宝对账接口
	 * 
	 * @param param
	 * @return
	 * @author zhang 2019年3月27日
	 * @throws BizException
	 */
	public String getPayInfos(String param) throws BizException {
		GetThirdPayInfoBP bp = new GetThirdPayInfoBP();
		return bp.exec(param);
	}

	/**
	 * 查询对账信息(收付款)
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 * @author shaokx 2019/07/04
	 */
	@Override
	public String getPayTradeInfo(String param) throws BizException {
		GetPayTradeInfo bp = new GetPayTradeInfo();
		return bp.exec(param);
	}

}
