package iih.mm.st.stockcheck.i.ds;

import iih.mm.st.stockcheck.d.StockcheckAggDO;
import xap.mw.core.data.BizException;

public interface IStockChkFlowService {
	/**
	 * 物品盘点盈亏提交。
	 * @param ids 盘点单主键(必须)
	 * @return
	 * @throws BizException
	 */
	public StockcheckAggDO[] submit(String[] ids) throws BizException;
	
	/**
	 * 物品盘点盈亏取消提交。
	 * @param ids 盘点单主键(必须)
	 * @return
	 * @throws BizException
	 */
	public StockcheckAggDO[] cancelSubmit(String[] ids) throws BizException;
	
	/**
	 * 物品盘点盈亏审核通过。
	 * @param stockChkAggDO 盘点单(必须)
	 * @return
	 * @throws BizException
	 */
	public StockcheckAggDO accept(StockcheckAggDO stockChkAggDO) throws BizException;
	
	/**
	 * 物品盘点盈亏审核驳回。
	 * @param stockChkAggDO 盘点单(必须)
	 * @return
	 * @throws BizException
	 */
	public StockcheckAggDO reject(StockcheckAggDO stockChkAggDO) throws BizException;
}
