package iih.pmp.pay.i;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import iih.pmp.pay.bill.d.WXBillDTO;
import iih.pmp.pay.billcheckexception.d.BillCheckExceptionDO;
import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ordqryrstdto.d.OrdQryRstDTO;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.ordrstdto.d.OrdRstDTO;
import iih.pmp.pay.trade.d.TradeDO;

public interface IPmpPayService {
	
	/**
	 * 创建支付交易
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	OrdRstDTO pmpTradeCreate(OrdReqDTO dto) throws BizException;
	/**
	 * 创建退款交易
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	OrdRstDTO pmpReFundTradeCreate(OrdReqDTO dto) throws BizException;
	/**
	 * 反扫支付（不含交易生成）
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	OrdRstDTO pmpbarcodePay(OrdReqDTO dto) throws BizException;
	/**
	 * 扫码支付（不含交易生成）
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	OrdRstDTO pmpqrcodePay(OrdReqDTO dto) throws BizException;
	/**
	 * 退款（不含交易生成）
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	OrdRstDTO pmprefund(OrdReqDTO dto) throws BizException;
	/**
	 * 订单查询（过渡屏支付时使用）
	 * @param dto
	 * @return  OrdQryRstDTO
	 * @throws BizException
	 */
	OrdQryRstDTO[] pmpQuery2(OrdReqDTO dto)throws BizException;
	
	/**
	 * 订单查询（移动支付节点使用）
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	OrdDO[] pmpQuery(OrdReqDTO dto) throws BizException;
	/**
	 * 退款查询
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	OrdQryRstDTO[] pmprefundquery(OrdReqDTO dto) throws BizException;
	/**
	 *       后台任务退款
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	OrdRstDTO refund4task(OrdReqDTO dto) throws BizException;

	OrdRstDTO barcodePay(OrdReqDTO dto) throws BizException;

	OrdRstDTO payCreate(OrdReqDTO dto) throws BizException;

	OrdRstDTO refund(OrdReqDTO dto) throws BizException;

	OrdRstDTO cancel(OrdReqDTO dto) throws BizException;

	OrdDO[] query(OrdReqDTO dto) throws BizException;

	OrdQryRstDTO[] query2(OrdReqDTO dto) throws BizException;

	OrdRstDTO WXBarcodePay(OrdReqDTO dto) throws BizException;

	OrdRstDTO WXScanPay(OrdReqDTO dto) throws BizException;

	OrdRstDTO dowxrefund(OrdReqDTO dto) throws BizException;

	OrdDO[] WXQuery(OrdReqDTO dto) throws BizException;

	WXBillDTO[] downloadBill(FDate date, String option);

	OrdRstDTO WXTradeCreate(OrdReqDTO dto) throws BizException;

	OrdRstDTO WXReFundTradeCreate(OrdReqDTO dto) throws BizException;

	TradeDO queryrefund(OrdReqDTO dto) throws BizException;

	OrdRstDTO AlipayTradeCreate(OrdReqDTO dto) throws BizException;

	OrdRstDTO AlipayRefundTradeCreate(OrdReqDTO dto) throws BizException;

	OrdRstDTO WXRePayTradeCreate(OrdReqDTO dto) throws BizException;

	OrdQryRstDTO[] WXQuery2(OrdReqDTO dto) throws BizException;

	OrdQryRstDTO[] cmbcqueryrefund(OrdReqDTO dto) throws BizException;

	OrdRstDTO cmbcbarcodePay(OrdReqDTO dto) throws BizException;

	OrdRstDTO cmbcrefund(OrdReqDTO dto) throws BizException;

	OrdQryRstDTO[] cmbcQuery2(OrdReqDTO dto) throws BizException;

	OrdQryRstDTO[] cmbcQuery4Biz(OrdReqDTO dto) throws BizException;

	OrdRstDTO cmbcTradeCreate(OrdReqDTO dto) throws BizException;

	OrdRstDTO cmbcReFundTradeCreate(OrdReqDTO dto) throws BizException;

	OrdDO[] cmbcQuery(OrdReqDTO dto) throws BizException;

	WXBillDTO[] cmbcdownloadBill(FDate date, String option) throws BizException;

	void billcheck(BillCheckExceptionDO p) throws BizException;

}
