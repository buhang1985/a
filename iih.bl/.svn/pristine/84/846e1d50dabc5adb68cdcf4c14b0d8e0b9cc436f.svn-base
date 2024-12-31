package iih.bl.itf.std.inner;

import iih.bl.itf.std.bean.input.charge.WsParamGetCostBill;
import iih.bl.itf.std.bean.input.charge.WsParamGetCostBillNew;
import iih.bl.itf.std.bean.input.charge.WsParamOpCostBillNew;
import iih.bl.itf.std.bean.input.charge.WsParamSelfHelpPayItem;
import iih.bl.itf.std.bean.input.charge.WsParamSelfHelpPricing;
import iih.bl.itf.std.bean.input.charge.WsParanExamunationCg;
import iih.bl.itf.std.bean.output.WsResultMsgInfo;
import iih.bl.itf.std.bean.output.charge.WsResultOpGetCostBill;
import iih.bl.itf.std.bean.output.charge.WsResultOpGetPay;
import iih.bl.itf.std.bean.output.charge.WsResultOpGetPayNew;
import iih.bl.itf.std.bean.output.charge.WsResultOpGetSelfHelpPayItem;
import iih.bl.itf.std.bean.output.charge.WsResultOpGetSelfHelpPricing;
import iih.bl.itf.std.bp.opcharge.GetOpCostBillBP;
import iih.bl.itf.std.bp.opcharge.GetOpNoPayBP;
import iih.bl.itf.std.bp.opcharge.GetOpNoPayNewBP;
import iih.bl.itf.std.bp.opcharge.GetOpSelfHelpPayItemBP;
import iih.bl.itf.std.bp.opcharge.GetOpSelfHelpPricingBP;
import iih.bl.itf.std.bp.opcharge.SetOpCostBillBP;
import iih.bl.itf.std.bp.opcharge.SetOpCostBillNewBP;
import xap.mw.core.data.BizException;

/**
 * 费用标准对外服务--门诊收费服务(内部接口，出入参为未转xml时数据)
 * @author ly 2019/7/17
 *
 */
public class BlOpChargeInnerServiceImpl implements IBlOpChargeInnerService{

	/**
	 * 门诊自助划价(带事务)
	 * @param inParam
	 * @return
	 * @throws BizException
	 */
	@Override
	public WsResultOpGetSelfHelpPricing pricing(WsParamSelfHelpPricing inParam) throws BizException {
		GetOpSelfHelpPricingBP bp = new GetOpSelfHelpPricingBP();
		return bp.execTransTV(inParam);
	}
	
	/**
	 * 门诊自助划价（不带事务）
	 * @param inParam
	 * @return
	 * @throws BizException
	 */
	@Override
	public WsResultOpGetSelfHelpPricing pricingNoTrans(WsParamSelfHelpPricing inParam) throws BizException {
		GetOpSelfHelpPricingBP bp = new GetOpSelfHelpPricingBP();
		return bp.execTV(inParam);
	}

	/**
	 * 门诊自助收付款
	 * @param inParam
	 * @return
	 * @throws BizException
	 */
	@Override
	public WsResultOpGetSelfHelpPayItem pay(WsParamSelfHelpPayItem inParam) throws BizException {
		GetOpSelfHelpPayItemBP bp = new GetOpSelfHelpPayItemBP();
		return bp.execTransTV(inParam);
	}

	/**
	 * 门诊补退费
	 */
	@Override
	public WsResultMsgInfo setOpCostBill(WsParanExamunationCg inParam) throws BizException {
		SetOpCostBillBP bp =new SetOpCostBillBP();
		return bp.execTransTV(inParam);
	}

	/**
	 * 门诊费用清单查询
	 */
	@Override
	public WsResultOpGetCostBill getCostBill(WsParamGetCostBill inParam) throws BizException {
		GetOpCostBillBP bp = new GetOpCostBillBP();
		return bp.execTV(inParam);
	}

	/**
	 * 门诊自助支付待缴查询
	 */
	@Override
	public WsResultOpGetPay getNoPay(WsParamGetCostBill inParam) throws BizException {
		//GetOpNoPayBP bp = new GetOpNoPayBP();
		GetOpNoPayNewBP bp = new GetOpNoPayNewBP();
		return bp.execTV(inParam);
	}

	/**
	 * 门诊自助支付待缴查询新(预划价接口是新的)
	 */
	@Override
	public WsResultOpGetPay getNoPayNew(WsParamGetCostBill inParam) throws BizException {
		GetOpNoPayNewBP bp = new GetOpNoPayNewBP();
		return bp.execTV(inParam);
	}

	/**
	 * 门诊补退费新(可循环记账)
	 */
	@Override
	public WsResultMsgInfo setOpCostBillNew(WsParamOpCostBillNew inParam) throws BizException {
		SetOpCostBillNewBP bp = new SetOpCostBillNewBP();
		return bp.execTransTV(inParam);
	}

}
