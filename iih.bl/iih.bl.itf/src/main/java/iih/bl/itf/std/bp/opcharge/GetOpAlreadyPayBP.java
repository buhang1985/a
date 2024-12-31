package iih.bl.itf.std.bp.opcharge;

import iih.bl.itf.std.bean.input.charge.WsParamGetCostBill;
import iih.bl.itf.std.bean.output.WsResultMsg;
import iih.bl.itf.std.bean.output.charge.WsResultOpGetPay;
import iih.bl.itf.std.bp.BlItfBaseBP;
import iih.bl.itf.std.bp.validator.WsParamPayQryValidator;
import xap.mw.core.data.BizException;

/**
 * 门诊自助支付已缴费查询(废弃)
 * @author shaokx 2019/1/9
 *
 */
public class GetOpAlreadyPayBP extends BlItfBaseBP<WsParamGetCostBill,WsResultMsg>{

	@Override
	protected String getBusiness() {
		// TODO Auto-generated method stub
		return "门诊自助支付已缴费查询";
	}

	@Override
	protected void checkParam(WsParamGetCostBill param) throws BizException {
		WsParamPayQryValidator validator = new WsParamPayQryValidator();
		validator.validate(param);
	}

	@Override
	protected WsResultMsg doWork(WsParamGetCostBill param) throws BizException {
		WsResultOpGetPay a = new WsResultOpGetPay();
		return null;
	}

}
