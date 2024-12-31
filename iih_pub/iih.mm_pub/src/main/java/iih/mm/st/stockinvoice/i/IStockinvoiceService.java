package iih.mm.st.stockinvoice.i;

import iih.mm.st.stockin.d.StockInDO;
import iih.mm.st.stockin.d.StockinAggDO;
import iih.mm.st.stockinvoice.d.StockinvoiceAggDO;
import xap.mw.core.data.BizException;

public interface IStockinvoiceService {
	
	/**
	 * 根据采购入库单初始化采购发票信息
	 * @param stockInDOList
	 * @return
	 * @throws BizException
	 */
	public StockinvoiceAggDO initInvoiceByStockIn(StockInDO[] stockInDOList) throws BizException;
	
	/**
	 * 根据采购入库单生成采购发票
	 */
	public StockinvoiceAggDO[] initInvoiceDirect(StockinAggDO[] stockInAggList) throws BizException;
	
	/**
	 * 提交采购发票
	 */
	public StockinvoiceAggDO[] submitInvoice(String[] ids) throws BizException;
	
	/**
	 * 确认采购发票
	 */
	public StockinvoiceAggDO[] confirmInvoice(String[] ids) throws BizException;
	
	/**
	 * 采购发票审核通过
	 */
	public StockinvoiceAggDO acceptInvoice(StockinvoiceAggDO stockinvoiceAggDO) throws BizException;
	
	/**
	 * 采购发票审核驳回
	 */
	public StockinvoiceAggDO rejectInvoice(StockinvoiceAggDO stockinvoiceAggDO) throws BizException;
	
	/**
	 * 采购发票删除 
	 */
	public void delete(String[] ids) throws BizException;
	
	/**
	 * 更新采购发票结算标志
	 */
	public void updateInvoiceBanl(String[] ids) throws BizException;
}
