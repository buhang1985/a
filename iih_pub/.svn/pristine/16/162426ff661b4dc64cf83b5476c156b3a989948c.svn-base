package iih.mc.common.i;

import iih.mc.po.stockinvoice.d.McStockInvoiceDO;
import iih.mc.st.stockcheck.d.McStockCheckDO;
import iih.mc.st.trreqapimpl.d.McTrReqApImplDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;

public interface IValidAccountYearService {
	
	/**
	 * 出入库时，对制单日期进行验证
	 * @param whouseID 仓库ID
	 * @param dtSt 制单日期
	 * @return
	 * @throws BizException
	 */
	public String checkInOutOrderStDt(String whouseID, FDateTime dtSt, String sd_sttp) throws BizException;
	
	/**
	 * 调拨时，对制单日期进行验证
	 * @param transOrderDO 调拨单
	 * @return
	 * @throws BizException
	 */
	public String checkTransOrderStDt(McTrReqApImplDO transOrderDO) throws BizException;
	
	/**
	 * 盘点时，对盘点日期进行验证
	 * @param checkOrderDO 盘点单
	 * @return
	 * @throws BizException
	 */
	public String checkInventoryOrderStDt(McStockCheckDO checkOrderDO) throws BizException;
	
	/**
	 * 采购发票保存时，对采购发票制单日期进行验证
	 * @param invoiceDO 采购发票单
	 * @return
	 * @throws BizException
	 */
	public String checkInvoiceOrderStDt(McStockInvoiceDO invoiceDO) throws BizException;
	
	/**
	 * 采购发票结算时，对结算日期进行验证
	 * @param invoiceOrderDOS 采购发票单
	 * @param settleTime 结算时间
	 * @return
	 * @throws BizException
	 */
	public void checkSettlementDt(McStockInvoiceDO[] invoiceOrderDOS, FDateTime settleTime) throws BizException;
}
