package iih.pis.ivx.pay.i;

import java.util.List;

import iih.bl.itf.std.bean.output.charge.sub.WsResultSingleEntInfo;
import iih.pis.ivx.pay.d.WsResultOpGetSelfHelpPayItem;
import iih.pis.ivx.pay.d.WsResultPrepay;
import xap.mw.core.data.BizException;

public interface IPayCudService {
	
	/**
	 * 门诊预交金充值
	 * @param id_pisivxmember
	 * @param payMoney
	 * @return
	 * @throws BizException
	 */
	public WsResultPrepay opRecharge(String id_pisivxmember,String payMoney) throws BizException;
	
	/**
	 * 住院预交金充值
	 * @param id_pisivxmember
	 * @param payMoney
	 * @return
	 * @throws BizException
	 */
	public WsResultPrepay ipRecharge(String id_pisivxmember,String payMoney) throws BizException;
	
	/**
	 * 门诊待缴费划价及支付
	 * @param patCode
	 * @param cardCode
	 * @param sdCode
	 * @param payMoney
	 * @param oepEntList
	 * @return
	 * @throws BizException
	 */
	public WsResultOpGetSelfHelpPayItem pricingAndPay(String patCode,String cardCode,String sdCode,String payMoney,List<WsResultSingleEntInfo> oepEntList) throws BizException;
	
	/**
	 * 门诊预交金退充值校验
	 * @param id_pisivxmember
	 * @param payMoney
	 * @return
	 * @throws BizException
	 */
	public WsResultPrepay refundCheck(String id_pisivxmember,String prepay) throws BizException;
	
	/**
	 * 门诊预交金退充值
	 * @param id_pisivxmember
	 * @param payMoney
	 * @return
	 * @throws BizException
	 */
	public WsResultPrepay refund(String id_pisivxmember,String prepay) throws BizException;

}
