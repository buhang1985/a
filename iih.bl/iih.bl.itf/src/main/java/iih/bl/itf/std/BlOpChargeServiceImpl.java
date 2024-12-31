package iih.bl.itf.std;

import iih.bl.itf.std.bp.opcharge.GetOpAlreadyPayBP;
import iih.bl.itf.std.bp.opcharge.GetOpCostBillBP;
import iih.bl.itf.std.bp.opcharge.GetOpNoPayNewBP;
import iih.bl.itf.std.bp.opcharge.GetOpSelfHelpPayItemBP;
import iih.bl.itf.std.bp.opcharge.GetOpSelfHelpPricingBP;
import iih.bl.itf.std.bp.opcharge.SetOpCostBillBP;
import iih.bl.itf.std.bp.opcharge.SetOpCostBillNewBP;
import xap.mw.core.data.BizException;

/**
 * 费用标准对外服务--门诊收费服务
 * @author ly 2018/7/16
 *
 */
public class BlOpChargeServiceImpl implements IBlOpChargeService, IBlOpChargeRService {

	/**
	 * 门诊费用清单查询
	 * @param param
	 * @return
	 * @throws BizException
	 * @author ly 2018/7/16
	 */
	@Override
	public String getCostBill(String param) throws BizException {
		GetOpCostBillBP bp = new GetOpCostBillBP();
		return bp.exec(param);
	}

	/**
	 * 门诊自助支付待缴查询
	 * @param param
	 * @return
	 * @throws BizException
	 * @author shaokx 2019/1/9
	 */
	@Override
	public String getNoPay(String param) throws BizException {
		//GetOpNoPayBP bp = new GetOpNoPayBP();
		GetOpNoPayNewBP bp = new GetOpNoPayNewBP();
		return bp.exec(param);
	}

	/**
	 * 门诊自助支付已缴费查询(废弃)
	 * @param param
	 * @return
	 * @throws BizException
	 * @author shaokx 2019/1/9
	 */
	@Override
	public String getAlreadyPay(String param) throws BizException {
		GetOpAlreadyPayBP bp = new GetOpAlreadyPayBP();
		return bp.exec(param);
	}

	/**
	 * 门诊自助收付款
	 * @param param
	 * @return
	 * @throws BizException
	 * @author shaokx 2019/1/9
	 */
	@Override
	public String pay(String param) throws BizException {
		GetOpSelfHelpPayItemBP bp = new GetOpSelfHelpPayItemBP();
		return bp.execTrans(param);
	}

	/**
	 * 门诊自助划价(带事务)
	 * @param param
	 * @return
	 * @throws BizException
	 * @author shaokx 2019/1/17
	 */
	@Override
	public String pricing(String param) throws BizException {
		GetOpSelfHelpPricingBP bp = new GetOpSelfHelpPricingBP();
		return bp.execTrans(param);
	}
	
	/**
	 * 门诊自助划价(不带事务)
	 * @param param
	 * @return
	 * @throws BizException
	 * @author shaokx 
	 */
	@Override
	public String pricingNoTrans(String param) throws BizException {
		GetOpSelfHelpPricingBP bp = new GetOpSelfHelpPricingBP();
		return bp.exec(param);
	}
	
	
	/**
	 * 门诊补退费
	 * @param param
	 * @return
	 * @throws BizException
	 * @author zhangxin
	 */
	@Override
	public String setOpCostBill(String param) throws BizException {
		SetOpCostBillBP bp =new SetOpCostBillBP();
		return bp.execTrans(param);
	}

	/**
	 * 门诊自助支付待缴查询新(预划价接口是新的)
	 */
	@Override
	public String getNoPayNew(String param) throws BizException {
		GetOpNoPayNewBP bp = new GetOpNoPayNewBP();
		return bp.exec(param);
	}

	/**
	 * 门诊补退费新(可循环记账)
	 */
	@Override
	public String setOpCostBillNew(String param) throws BizException {
		SetOpCostBillNewBP bp = new SetOpCostBillNewBP();
		return bp.execTrans(param);
	}

}
