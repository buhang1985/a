package iih.mm.st.stockinvinrel.i;

import iih.mm.st.stockinvoice.d.StockinvoiceAggDO;
import xap.mw.core.data.BizException;

public interface IStockinvinrelService {
	/**
	 * 发票入库单关联表数据插入处理
	 * @param idInList 入库单主键
	 * @param stockInvID 发票单主键
	 */
	public void initStockInvInRel(StockinvoiceAggDO[] invoiceAggDOS) throws BizException;
	
	/**
	 * 发票入库单关联表数据删除处理
	 * @param stockInvID 发票单主键
	 */
	public void delStockInvInRel(StockinvoiceAggDO[] invoiceAggDOS) throws BizException;
}
