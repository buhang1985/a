package iih.bl.itf.std.inner;

import iih.bl.itf.std.bean.input.balacc.WsParamPayTrade;
import iih.bl.itf.std.bean.input.balacc.WsParamThirdPay;
import iih.bl.itf.std.bean.input.balacc.WsParamThirdPayBill;
import iih.bl.itf.std.bean.input.balacc.WsParamTrade;
import iih.bl.itf.std.bean.output.balacc.WsResultPayTrade;
import iih.bl.itf.std.bean.output.balacc.WsResultTrade;
import xap.mw.core.data.BizException;

/**
 * 费用标准对外服务--对账服务(内部接口，出入参为未转xml时数据)
 * @author shaokx 2019/7/22
 *
 */
public interface IBlBalanceAccountInnerService {

	/**
	 * 查询对账信息(预交金)
	 * @param param
	 * @return
	 * @throws BizException
	 * @author ly 2018/07/29
	 */
	public abstract WsResultTrade getTradeInfo (WsParamTrade inParam) throws BizException;
	/**
	 * 微信支付宝对账接口
	 * @param param
	 * @return
	 * @author zhang 2019年3月27日
	 * @throws BizException
	 */
	public abstract WsParamThirdPayBill getPayInfos (WsParamThirdPay inParam) throws BizException;
	
	/**
	 * 查询对账信息(收付款)
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract WsResultPayTrade getPayTradeInfo(WsParamPayTrade inParam) throws BizException;
}
