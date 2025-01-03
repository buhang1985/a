package iih.ei.std.i.v1;

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
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;

public interface IBlApiService {

	/**
	 * 微信支付宝对账接口
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public ThirdPayTradeResultDTO getThirdPayTradeInfo(ThirdPayTradeParamDTO param) throws BizException;
	
	/**
	 * 查询对账信息(收付款)
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public PayTradeResultDTO getPayTradeInfo(PayTradeParamDTO param) throws BizException;
	
	/**
	 * 查询对账信息(预交金)
	 * @return
	 */
	public PrepayTradeResultDTO getPrepayTradeInfo(PrepayTradeParamDTO param) throws BizException;
	
	/**
	 * 门诊费用清单查询
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public OpCostBillQryResultDTO getOpCostBill(OpCostBillQryParamDTO param) throws BizException;
	
	/**
	 * 住院费用清单查询
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public IpCostBillQryResultDTO getIpCostBill(IpCostBillQryParamDTO param) throws BizException;
	
	/**
	 * 门诊充值记录查询(含余额)
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public OpRechargeRecordResultDTO getOpRechargeRecord(OpRechargeRecordParamDTO param) throws BizException;
	
	/**
	 * 住院充值记录查询(含余额)
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public IpRechargeRecordResultDTO getIpRechargeRecord(IpRechargeRecordParamDTO param) throws BizException;
	
	/**
	 * 门诊账户信息查询
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public OpAccountInfoResultDTO getOpAccountInfo(OpAccountInfoParamDTO param) throws BizException;
	
	/**
	 * 门诊自助发票查询（查询一个患者的发票信息）
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public OpPatIncInfoResultDTO getOpPatIncInfo(OpPatIncInfoParamDTO param) throws BizException;
	
	/**
	 * 门诊自助发票明细查询（根据一个结算id查询发票明细信息）（带有发票打印逻辑）
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public OpIncItmInfoResultDTO getOpIncItmInfo(OpIncItmInfoParamDTO param) throws BizException;
	
	/**
	 * 门诊押金充值
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public OpRechargeResultDTO opRecharge(OpRechargeParamDTO param) throws BizException;
	
	/**
	 * 住院押金充值
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public IpRechargeResultDTO ipRecharge(IpRechargeParamDTO param) throws BizException;
	
	/**
	 * 门诊自助支付待缴查询
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public OpNoPayResultDTO getOpNoPayNew(OpNoPayParamDTO param) throws BizException;
	
	/**
	 * 门诊划价(带事务)
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public OpPricingResultDTO opPricing(OpPricingParamDTO param) throws BizException;
	
	/**
	 * 门诊划价(不带事务)
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public OpPricingResultDTO opPricingNoTrans(OpPricingParamDTO param) throws BizException;
	
	/**
	 * 门诊付款
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public OpPayResultDTO opPay(OpPayParamDTO param) throws BizException;
	
	/**
	 * 住院退补费(重构)
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public void ipRefundSupplyFee(IpRefundSupplyParamDTO param) throws BizException;
	
	/**
	 * 门诊退补费
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public void opRefundSupplyFee(OpRefundSupplyParamDTO param) throws BizException;
	
	/**
	 * 电子发票换开回写IIH数据
	 * @param param
	 * @throws BizException
	 * @author ly 2020/01/08
	 */
	public void ecIncSwitchPaper(EcIncSwitchPaperDTO param) throws BizException;
}
