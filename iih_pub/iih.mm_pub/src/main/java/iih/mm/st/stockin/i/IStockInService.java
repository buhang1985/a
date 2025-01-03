package iih.mm.st.stockin.i;

import iih.mm.st.stockin.d.StockInDO;
import iih.mm.st.stockin.d.StockInItemDO;
import iih.mm.st.stockin.d.StockinAggDO;
import iih.mm.st.stockinvoice.d.StockinvoiceAggDO;
import xap.mw.core.data.BizException;

public interface IStockInService {
	
	/**
	 * 根据采购单生成采购入库单
	 */
	public StockinAggDO initPoInOrderByPurchase(String[] plIdList) throws BizException;
	
	/**
	 * 初始化采购单明细信息
	 */
	public StockInItemDO initStockInItemInfo(StockInDO inOrderDO, StockInItemDO inItemDO) throws BizException;
	
	/**
	 * 提交入库单
	 */
	public StockinAggDO[] submit(String[] ids) throws BizException;

	/**
	 * 入库单删除 
	 */
	public void delete(String[] ids) throws BizException;
	
	/**
	 * 更细入库单开发票标志
	 */
	public void updateInOrderInv(StockinvoiceAggDO[] invoiceAggDOS, Boolean fg_delete) throws BizException;
	
	/**
	 * 根据结存主键创建结余入库明细
	 * 
	 * @param blId
	 * @return
	 */
	public abstract StockInItemDO createProfigItemByBlId(String blId) throws BizException;
	
	/**
	 * 更新已确认入库单的发票号
	 * @throws BizException 
	 */
	public StockinAggDO updateInvoice(StockinAggDO stockinDO) throws BizException;
	
	/**
	 * 读取二维码，获取入库数据
	 * @throws BizException 
	 */
	public StockInItemDO[] readBarCode(StockInDO inOrderDO, String barCode) throws BizException;

	/**
	 * 校验物品是否为固定价模式
	 * @param idMm
	 * @return
	 * @throws BizException
	 */
	public Boolean checkPriEqual(String idMm) throws BizException;
}
