package iih.bl.itf.std.inner;

import iih.bl.itf.std.bean.input.charge.WsParamGetCostBill;
import iih.bl.itf.std.bean.input.charge.WsParamOpCostBillNew;
import iih.bl.itf.std.bean.input.charge.WsParamSelfHelpPayItem;
import iih.bl.itf.std.bean.input.charge.WsParamSelfHelpPricing;
import iih.bl.itf.std.bean.input.charge.WsParanExamunationCg;
import iih.bl.itf.std.bean.output.WsResultMsgInfo;
import iih.bl.itf.std.bean.output.charge.WsResultOpGetCostBill;
import iih.bl.itf.std.bean.output.charge.WsResultOpGetPay;
import iih.bl.itf.std.bean.output.charge.WsResultOpGetSelfHelpPayItem;
import iih.bl.itf.std.bean.output.charge.WsResultOpGetSelfHelpPricing;
import xap.mw.core.data.BizException;

/**
 * 费用标准对外服务--门诊收费服务(内部接口，出入参为未转xml时数据)
 * @author ly 2019/7/17
 *
 */
public interface IBlOpChargeInnerService {

	/**
	 * 门诊自助划价（带事务）
	 * @param inParam
	 * @return
	 * @throws BizException
	 */
	public abstract WsResultOpGetSelfHelpPricing pricing(WsParamSelfHelpPricing inParam) throws BizException;
	
	/**
	 * 门诊自助划价（不带事务）
	 * @param inParam
	 * @return
	 * @throws BizException
	 */
	public abstract WsResultOpGetSelfHelpPricing pricingNoTrans(WsParamSelfHelpPricing inParam) throws BizException;
	
	/**
	 * 门诊自助收付款
	 * @param inParam
	 * @return
	 * @throws BizException
	 */
	public abstract WsResultOpGetSelfHelpPayItem pay(WsParamSelfHelpPayItem inParam) throws BizException;
	
	/**
	 * 门诊补退费
	 * @param param
	 * @return
	 * @throws BizException
	 * @author zhangxin
	 */
	public abstract WsResultMsgInfo setOpCostBill(WsParanExamunationCg inParam) throws BizException;
	
	/**
	 * 门诊补退费新(可循环记账)
	 * @param inParam
	 * @return
	 * @throws BizException
	 */
	public abstract WsResultMsgInfo setOpCostBillNew(WsParamOpCostBillNew inParam) throws BizException;
	
	/**
	 * 门诊费用清单查询
	 * @param param
	 * @return
	 * @throws BizException
	 * @author shaokx 2018/7/22
	 */
	public abstract WsResultOpGetCostBill getCostBill(WsParamGetCostBill inParam) throws BizException;
	
	/**
	 * 门诊自助支付待缴查询
	 * @param param
	 * @return
	 * @throws BizException
	 * @author shaokx 2019/7/22
	 */
	public abstract WsResultOpGetPay getNoPay(WsParamGetCostBill inParam) throws BizException;
	
	/**
	 * 门诊自助支付待缴查询新(跟旧的相比换了预划价接口)
	 * @param param
	 * @return
	 * @throws BizException
	 * @author shaokx 2019/1/9
	 */
	public abstract WsResultOpGetPay getNoPayNew(WsParamGetCostBill inParam) throws BizException;
}
