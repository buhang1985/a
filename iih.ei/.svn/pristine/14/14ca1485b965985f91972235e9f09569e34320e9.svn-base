package iih.ei.std.s.v1;

import iih.ei.std.d.v1.bl.ecincswitchpaper.d.EcIncSwitchPaperDTO;
import iih.ei.std.d.v1.bl.ipcostbillqrydto.d.IpCostBillQryParamDTO;
import iih.ei.std.d.v1.bl.ipcostbillqrydto.d.IpCostBillQryResultDTO;
import iih.ei.std.d.v1.bl.iprechargedto.d.IpRechargeParamDTO;
import iih.ei.std.d.v1.bl.iprechargedto.d.IpRechargeResultDTO;
import iih.ei.std.d.v1.bl.iprechargerecorddto.d.IpRechargeRecordParamDTO;
import iih.ei.std.d.v1.bl.iprechargerecorddto.d.IpRechargeRecordResultDTO;
import iih.ei.std.d.v1.bl.iprefundsupplydto.d.IpRefundSupplyParamDTO;
import iih.ei.std.d.v1.bl.opaccountinfo.d.OpAccountInfoParamDTO;
import iih.ei.std.d.v1.bl.opaccountinfo.d.OpAccountInfoResultDTO;
import iih.ei.std.d.v1.bl.opcostbillqrydto.d.OpCostBillQryParamDTO;
import iih.ei.std.d.v1.bl.opcostbillqrydto.d.OpCostBillQryResultDTO;
import iih.ei.std.d.v1.bl.opincitminfodto.d.OpIncItmInfoParamDTO;
import iih.ei.std.d.v1.bl.opincitminfodto.d.OpIncItmInfoResultDTO;
import iih.ei.std.d.v1.bl.opnopaydto.d.OpNoPayParamDTO;
import iih.ei.std.d.v1.bl.opnopaydto.d.OpNoPayResultDTO;
import iih.ei.std.d.v1.bl.oppatincinfodto.d.OpPatIncInfoParamDTO;
import iih.ei.std.d.v1.bl.oppatincinfodto.d.OpPatIncInfoResultDTO;
import iih.ei.std.d.v1.bl.oppaydto.d.OpPayParamDTO;
import iih.ei.std.d.v1.bl.oppaydto.d.OpPayResultDTO;
import iih.ei.std.d.v1.bl.oppricingdto.d.OpPricingParamDTO;
import iih.ei.std.d.v1.bl.oppricingdto.d.OpPricingResultDTO;
import iih.ei.std.d.v1.bl.oprechargedto.d.OpRechargeParamDTO;
import iih.ei.std.d.v1.bl.oprechargedto.d.OpRechargeResultDTO;
import iih.ei.std.d.v1.bl.oprechargerecorddto.d.OpRechargeRecordParamDTO;
import iih.ei.std.d.v1.bl.oprechargerecorddto.d.OpRechargeRecordResultDTO;
import iih.ei.std.d.v1.bl.oprefundsupplydto.d.OpRefundSupplyParamDTO;
import iih.ei.std.d.v1.bl.paytradedto.d.PayTradeParamDTO;
import iih.ei.std.d.v1.bl.paytradedto.d.PayTradeResultDTO;
import iih.ei.std.d.v1.bl.prepaytradedto.d.PrepayTradeParamDTO;
import iih.ei.std.d.v1.bl.prepaytradedto.d.PrepayTradeResultDTO;
import iih.ei.std.d.v1.bl.thirdpaytradedto.d.ThirdPayTradeParamDTO;
import iih.ei.std.d.v1.bl.thirdpaytradedto.d.ThirdPayTradeResultDTO;
import iih.ei.std.i.v1.IBlApiService;
import iih.ei.std.s.v1.bp.bl.EcIncSwitchPaperBP;
import iih.ei.std.s.v1.bp.bl.GetIpCostBillBP;
import iih.ei.std.s.v1.bp.bl.GetIpRechargeRecordBP;
import iih.ei.std.s.v1.bp.bl.GetOpAccountInfoBP;
import iih.ei.std.s.v1.bp.bl.GetOpCostBillBP;
import iih.ei.std.s.v1.bp.bl.GetOpIncItmInfoBP;
import iih.ei.std.s.v1.bp.bl.GetOpNoPayNewBP;
import iih.ei.std.s.v1.bp.bl.GetOpPatIncInfoBP;
import iih.ei.std.s.v1.bp.bl.GetOpRechargeRecordBP;
import iih.ei.std.s.v1.bp.bl.GetPayTradeInfoBP;
import iih.ei.std.s.v1.bp.bl.GetPrepayTradeInfoBP;
import iih.ei.std.s.v1.bp.bl.GetThirdPayTradeInfoBP;
import iih.ei.std.s.v1.bp.bl.IpRechargeBP;
import iih.ei.std.s.v1.bp.bl.IpRefundSupplyFeeBP;
import iih.ei.std.s.v1.bp.bl.OpPayBP;
import iih.ei.std.s.v1.bp.bl.OpPricingBP;
import iih.ei.std.s.v1.bp.bl.OpRechargeBP;
import iih.ei.std.s.v1.bp.bl.OpRefundSupplyFeeBP;
import xap.mw.core.data.BizException;

public class BlApiServiceImpl implements IBlApiService{

	/**
	 * 微信支付宝对账接口
	 */
	@Override
	public ThirdPayTradeResultDTO getThirdPayTradeInfo(ThirdPayTradeParamDTO param) throws BizException {
		GetThirdPayTradeInfoBP bp = new GetThirdPayTradeInfoBP();
		return bp.exec(param);
	}
	
	/**
	 * 查询对账信息(收付款)
	 */
	@Override
	public PayTradeResultDTO getPayTradeInfo(PayTradeParamDTO param) throws BizException {
		GetPayTradeInfoBP bp = new GetPayTradeInfoBP();
		return bp.exec(param);
	}

	
	/**
	 * 查询对账信息(预交金)
	 */
	@Override
	public PrepayTradeResultDTO getPrepayTradeInfo(PrepayTradeParamDTO param) throws BizException {
		GetPrepayTradeInfoBP bp = new GetPrepayTradeInfoBP();
		return bp.exec(param);
	}
	
	/**
	 * 门诊费用清单查询
	 */
	@Override
	public OpCostBillQryResultDTO getOpCostBill(OpCostBillQryParamDTO param) throws BizException {
		GetOpCostBillBP bp = new GetOpCostBillBP();
		return bp.exec(param);
	}

	/**
	 * 住院费用清单查询
	 */
	@Override
	public IpCostBillQryResultDTO getIpCostBill(IpCostBillQryParamDTO param) throws BizException {
		GetIpCostBillBP bp = new GetIpCostBillBP();
		return bp.exec(param);
	}

	/**
	 * 门诊充值记录查询(含余额)
	 */
	@Override
	public OpRechargeRecordResultDTO getOpRechargeRecord(OpRechargeRecordParamDTO param) throws BizException {
		GetOpRechargeRecordBP bp = new GetOpRechargeRecordBP();
		return bp.exec(param);
	}

	/**
	 * 住院充值记录查询(含余额)
	 */
	@Override
	public IpRechargeRecordResultDTO getIpRechargeRecord(IpRechargeRecordParamDTO param) throws BizException {
		GetIpRechargeRecordBP bp = new GetIpRechargeRecordBP();
		return bp.exec(param);
	}

	/**
	 * 门诊账户信息查询
	 */
	@Override
	public OpAccountInfoResultDTO getOpAccountInfo(OpAccountInfoParamDTO param) throws BizException {
		GetOpAccountInfoBP bp = new GetOpAccountInfoBP();
		return bp.exec(param);
	}

	/**
	 * 门诊自助发票查询（查询一个患者的发票信息）
	 */
	@Override
	public OpPatIncInfoResultDTO getOpPatIncInfo(OpPatIncInfoParamDTO param) throws BizException {
		GetOpPatIncInfoBP bp = new GetOpPatIncInfoBP();
		return bp.exec(param);
	}

	/**
	 * 门诊自助发票明细查询（根据一个结算id查询发票明细信息）（带有发票打印逻辑）
	 */
	@Override
	public OpIncItmInfoResultDTO getOpIncItmInfo(OpIncItmInfoParamDTO param) throws BizException {
		GetOpIncItmInfoBP bp = new GetOpIncItmInfoBP();
		return bp.execTrans(param);
	}

	/**
	 * 门诊押金充值
	 */
	@Override
	public OpRechargeResultDTO opRecharge(OpRechargeParamDTO param) throws BizException {
		OpRechargeBP bp = new OpRechargeBP();
		return bp.execTrans(param);
	}

	/**
	 * 住院押金充值
	 */
	@Override
	public IpRechargeResultDTO ipRecharge(IpRechargeParamDTO param) throws BizException {
		IpRechargeBP bp = new IpRechargeBP();
		return bp.execTrans(param);
	}

	/**
	 * 门诊自助支付待缴查询
	 */
	@Override
	public OpNoPayResultDTO getOpNoPayNew(OpNoPayParamDTO param) throws BizException {
		GetOpNoPayNewBP bp = new GetOpNoPayNewBP();
		return bp.execTrans(param);
	}

	/**
	 * 门诊划价(带事务)
	 */
	@Override
	public OpPricingResultDTO opPricing(OpPricingParamDTO param) throws BizException {
		OpPricingBP bp = new OpPricingBP();
		return bp.execTrans(param);
	}

	/**
	 * 门诊划价(不带事务)
	 */
	@Override
	public OpPricingResultDTO opPricingNoTrans(OpPricingParamDTO param) throws BizException {
		OpPricingBP bp = new OpPricingBP();
		return bp.exec(param);
	}

	/**
	 * 门诊付款
	 */
	@Override
	public OpPayResultDTO opPay(OpPayParamDTO param) throws BizException {
		OpPayBP bp = new OpPayBP();
		return bp.execTrans(param);
	}

	/**
	 * 住院退补费(重构)
	 */
	@Override
	public void ipRefundSupplyFee(IpRefundSupplyParamDTO param) throws BizException {
		IpRefundSupplyFeeBP bp = new IpRefundSupplyFeeBP();
		bp.execTrans(param);
	}

	/**
	 * 门诊退补费
	 */
	@Override
	public void opRefundSupplyFee(OpRefundSupplyParamDTO param) throws BizException {
		OpRefundSupplyFeeBP bp = new OpRefundSupplyFeeBP();
		bp.execTrans(param);
	}

	/**
	 * 电子发票换开回写IIH数据
	 * @param param
	 * @throws BizException
	 * @author ly 2020/01/08
	 */
	@Override
	public void ecIncSwitchPaper(EcIncSwitchPaperDTO param) throws BizException{
		EcIncSwitchPaperBP bp = new EcIncSwitchPaperBP();
		bp.exec(param);
	}
}
