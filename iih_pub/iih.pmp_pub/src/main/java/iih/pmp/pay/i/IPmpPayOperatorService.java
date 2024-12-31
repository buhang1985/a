package iih.pmp.pay.i;


import iih.pmp.pay.bill.d.WXBillDTO;
import iih.pmp.pay.billcheckexception.d.BillCheckExceptionDO;
import iih.pmp.pay.billcheckrst.d.BillCheckRstDO;
import iih.pmp.pay.blpmp.d.PmpBlReconciliationDifferencerDTO;
import iih.pmp.pay.blpmp.d.PmpBlReconciliationQryCondDTO;
import iih.pmp.pay.d.Reconcilldto;
import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ordqryrstdto.d.BillQryReqDTO;
import iih.pmp.pay.ordqryrstdto.d.OrdQryRstDTO;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.ordrstdto.d.OrdRstDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;

public interface IPmpPayOperatorService {
	
	
	/**
	 * 创建支付交易
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	OrdRstDTO tradeCreate(OrdReqDTO dto) throws BizException;
	/**
	 * 创建退款交易
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	OrdRstDTO refundtradeCreate(OrdReqDTO dto) throws BizException;
	/**
	 * 反扫支付（条码支付，不含交易生成）
	 * @param dto
	 * @return
	 * @throws BizException
	 */
    OrdRstDTO barcodePay(OrdReqDTO dto) throws BizException;
	/**
	 * 正扫支付（扫码支付，不含交易生成）
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	OrdRstDTO scanPayPrecreate(OrdReqDTO dto) throws BizException;
	/**
	 * 退款（不包含创建退款交易）
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	OrdRstDTO refund(OrdReqDTO dto) throws BizException;
	/**
	 * 查询（移动支付节点使用）
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	OrdDO[] query(OrdReqDTO dto) throws BizException;
	/**
	 * 订单查询（过渡屏使用）
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	OrdQryRstDTO[] pmpquery(OrdReqDTO dto)throws BizException;
	/**
	 * 查询（暂时没有用）
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	OrdQryRstDTO[] pmpquery4Biz(OrdReqDTO dto)throws BizException;
	/**
	 * 暂时无用
	 * @param date
	 * @param option
	 * @param sd_chl
	 * @return
	 * @throws BizException
	 */
	WXBillDTO[] downLoadBill(FDate date,String option,String sd_chl) throws BizException;
	
	/**
	 * 无用接口
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	OrdRstDTO RePayTradeCreate(OrdReqDTO dto) throws BizException;
	/**
	 * 创建订单
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	OrdDO createOrder(OrdReqDTO dto) throws BizException;
	
	/**
	 * 下载渠道对账单
	 * @param p
	 * @return
	 * @throws BizException
	 */
	String billCheck(BillCheckExceptionDO p) throws BizException;
	/**
	 * 退款查询
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	OrdQryRstDTO[] refundquery(OrdReqDTO dto) throws BizException;
	/**
	 * 生成对账结果数据
	 * @param dtos
	 * @return
	 * @throws BizException
	 */
	BillCheckRstDO[] getBillCheckRst(BillQryReqDTO[] dtos)throws BizException;
	/**
	 * 生成对账异常数据
	 * @param p
	 * @return
	 * @throws BizException
	 */
	String getBillCheckRstExp(BillCheckExceptionDO p) throws BizException;
	/**
	 * 退款状态查询
	 */
	public String refundqueryStatus(OrdReqDTO dto) throws BizException;
	
	 /**
	  * 批量退款查询
	  * @param dto
	  * @return
	  * @throws BizException
	  */
	 OrdQryRstDTO[] PMPQueryBatch(OrdReqDTO[] dtos) throws BizException;
	 /**
	  * 交易数据汇总查询
	  * @param dto
	  * @return
	  * @throws BizException
	  */
	 PmpBlReconciliationDifferencerDTO getTraSantis(PmpBlReconciliationQryCondDTO   dto) throws BizException;
	 
	 /**
	  * 整体对账
	  * @param dto
	  * @return
	  * @throws BizException
	  */
	 Reconcilldto[] PmpBillCheckExternal(String startTime,String endTime) throws BizException;	
	 /**
	  * 退款任务查询
	  * @param dto
	  * @return
	  * @throws BizException
	  */
	 String RefundTaskQry(OrdReqDTO dto ) throws BizException;	
	
}
