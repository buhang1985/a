package iih.bl.itf.std.inner;

import iih.bl.itf.std.bean.input.balacc.WsParamPayTrade;
import iih.bl.itf.std.bean.input.balacc.WsParamThirdPay;
import iih.bl.itf.std.bean.input.balacc.WsParamThirdPayBill;
import iih.bl.itf.std.bean.input.balacc.WsParamTrade;
import iih.bl.itf.std.bean.output.balacc.WsResultPayTrade;
import iih.bl.itf.std.bean.output.balacc.WsResultTrade;
import iih.bl.itf.std.bp.balacc.GetPayTradeInfo;
import iih.bl.itf.std.bp.balacc.GetThirdPayInfoBP;
import iih.bl.itf.std.bp.balacc.GetTradeInfoBP;
import xap.mw.core.data.BizException;

/**
 * 费用标准对外服务--对账服务(内部接口，出入参为未转xml时数据)
 * @author shaokx 2019/7/22
 *
 */
public class BlBalanceAccountInnerServiceImpl implements IBlBalanceAccountInnerService{

	/**
	 * 查询对账信息(预交金)
	 * @param param
	 * @return
	 * @throws BizException
	 * @author ly 2018/07/29
	 */
	@Override
	public WsResultTrade getTradeInfo(WsParamTrade inParam) throws BizException {
		GetTradeInfoBP bp = new GetTradeInfoBP();
		return bp.execTV(inParam);
	}

	/**
	 * 微信支付宝对账接口
	 * @param param
	 * @return
	 * @author zhang 2019年3月27日
	 * @throws BizException
	 */
	@Override
	public WsParamThirdPayBill getPayInfos(WsParamThirdPay inParam) throws BizException {
		GetThirdPayInfoBP bp = new GetThirdPayInfoBP();
		return bp.execTV(inParam);
	}

	/**
	 * 查询对账信息(收付款)
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@Override
	public WsResultPayTrade getPayTradeInfo(WsParamPayTrade inParam) throws BizException {
		GetPayTradeInfo bp = new GetPayTradeInfo();
		return bp.execTV(inParam);
	}

}
