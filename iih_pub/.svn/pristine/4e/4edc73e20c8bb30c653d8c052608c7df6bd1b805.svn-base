package iih.mm.st.stockout.i;

import xap.mw.core.data.BizException;
import iih.mm.st.stockout.d.StockOutDO;
import  iih.mm.st.stockout.d.StockoutAggDO;

/**
* 出库单数据维护服务
*/
public interface IStockoutCudService {
	/**
	*  出库单数据真删除
	*/
    public abstract void delete(StockoutAggDO[] aggdos) throws BizException;
    
    /**
	*  出库单数据插入保存
	*/
	public abstract StockoutAggDO[] insert(StockoutAggDO[] aggdos) throws BizException;
	
    /**
	*  出库单数据保存
	*/
	public abstract StockoutAggDO[] save(StockoutAggDO[] aggdos) throws BizException;
	
    /**
	*  出库单数据更新
	*/
	public abstract StockoutAggDO[] update(StockoutAggDO[] aggdos) throws BizException;
	
	/**
	*  出库单数据逻辑删除
	*/
	public abstract void logicDelete(StockoutAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对出库单数据真删除
	 */
	public abstract void deleteByParentDO(StockOutDO[] mainDos) throws BizException;
}
