package iih.mm.st.stockin.purchasereturn.i;

import iih.mm.st.stockin.d.StockInDO;
import iih.mm.st.stockin.d.StockInItemDO;
import iih.mm.st.stockin.d.StockinAggDO;
import xap.mw.core.data.BizException;

public interface IPurchaseReturnCudService {

	/**
	 * 保存采购退货单
	 * 
	 * @param stockinAggDOs
	 * @return
	 * @throws BizException
	 */
	public abstract StockinAggDO[] save(StockinAggDO[] stockinAggDOs) throws BizException;

	/**
	 * 提交采购退货单
	 * 
	 * @param stockInDOs
	 * @return
	 * @throws BizException
	 */
	public abstract StockInDO[] submit(StockInDO[] stockInDOs) throws BizException;

	/**
	 * 删除采购退货单
	 * 
	 * @param stockInDOs
	 * @throws BizException
	 */
	public abstract void delete(String[] stockInIds) throws BizException;

	/**
	 * 根据采购入库单生成采退货单
	 * 
	 * @param stockInIds
	 * @return
	 * @throws BizException
	 */
	public abstract StockinAggDO generateByStockIn(String[] stockInIds) throws BizException;

	/**
	 * 创建新的采购退货单
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract StockinAggDO createNewPurchaseReturn() throws BizException;

	/**
	 * 根据结存主键创建采购入库单明细
	 * 
	 * @param blId
	 * @return
	 */
	public abstract StockInItemDO createPurRtnItemByBlId(String blId) throws BizException;
}
