package iih.mm.st.stockinvoice.i;

import xap.mw.core.data.BizException;
import iih.mm.st.stockinvoice.d.StockInvoiceDO;
import iih.mm.st.stockinvoice.d.StockinvoiceAggDO;

/**
* 采购发票数据维护服务
*/
public interface IStockinvoiceCudService {
	/**
	*  采购发票数据真删除
	*/
    public abstract void delete(StockinvoiceAggDO[] aggdos) throws BizException;
    
    /**
	*  采购发票数据插入保存
	*/
	public abstract StockinvoiceAggDO[] insert(StockinvoiceAggDO[] aggdos) throws BizException;
	
    /**
	*  采购发票数据保存
	*/
	public abstract StockinvoiceAggDO[] save(StockinvoiceAggDO[] aggdos) throws BizException;
	
    /**
	*  采购发票数据更新
	*/
	public abstract StockinvoiceAggDO[] update(StockinvoiceAggDO[] aggdos) throws BizException;
	
	/**
	*  采购发票数据逻辑删除
	*/
	public abstract void logicDelete(StockinvoiceAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对采购发票数据真删除
	 */
	public abstract void deleteByParentDO(StockInvoiceDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对采购发票数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(StockInvoiceDO[] mainDos) throws BizException;
}
