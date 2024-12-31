package iih.mc.po.stockinvoice.i;

import iih.mc.po.stockinvoice.d.McStockInvoiceDO;
import iih.mc.po.stockinvoice.d.StockinvoiceAggDO;
import iih.mc.st.stockin.d.McStockInDO;
import iih.mc.st.stockin.d.StockinAggDO;
import xap.mw.core.data.BizException;

public interface IStockinvoiceMaintainService {
	
	/**
	 *  生成采购发票(采购发票节点生单用)，默认模式下 
	 * @param inOrderDOS 采购入库单
	 * @throws BizException
	 */
	public StockinvoiceAggDO initInvoiceOrderByStockInOrder(McStockInDO[] inOrderDOS) throws BizException;
	
	/**
	 *  生成采购发票(采购发票节点生单用)，子模式下 
	 * @param inOrderDOS 采购入库单
	 * @throws BizException
	 */
	public StockinvoiceAggDO[] initInvoiceOrderDataForItm(McStockInDO[] inOrderDOS) throws BizException;
	
	/**
	 *  生成采购发票(采购发票节点生单用)，主模式下 
	 * @param inOrderDOS 采购入库单
	 * @throws BizException
	 */
	public StockinvoiceAggDO[] initInvoiceOrderDataForMain(McStockInDO[] inOrderDOS) throws BizException;
	/**
	 *  生成采购发票(采购入库节点用)
	 * @param inAggDOS 采购入库单
	 * @throws BizException
	 */
	public void initInvoiceDirect(StockinAggDO[] inAggDOS) throws BizException;
	
	/**
	 * 采购发票确认
	 * @param invoiceOrderDOS 采购发票
	 * @throws BizException
	 */
	public void confirmMainDO(McStockInvoiceDO[] invoiceOrderDOS) throws BizException;
	
	/**
	 * 采购发票确认
	 * @param invoiceAggDO 采购发票
	 * @throws BizException
	 */
	public StockinvoiceAggDO confirmAggDO(StockinvoiceAggDO invoiceAggDO) throws BizException;
	
	/**
	 * 采购发票结算
	 * @param invoiceOrderDOS 采购发票
	 * @throws BizException
	 */
	public void invoiceOrderSettle(McStockInvoiceDO[] invoiceOrderDOS) throws BizException;
}
