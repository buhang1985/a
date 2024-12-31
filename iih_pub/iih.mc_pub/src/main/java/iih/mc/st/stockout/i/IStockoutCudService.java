package iih.mc.st.stockout.i;

import xap.mw.core.data.BizException;
import iih.mc.st.stockout.d.McStockOutDO;
import iih.mc.st.stockout.d.StockoutAggDO;

/**
* 耗材出库数据维护服务
*/
public interface IStockoutCudService {
	/**
	*  耗材出库数据真删除
	*/
    public abstract void delete(StockoutAggDO[] aggdos) throws BizException;
    
    /**
	*  耗材出库数据插入保存
	*/
	public abstract StockoutAggDO[] insert(StockoutAggDO[] aggdos) throws BizException;
	
    /**
	*  耗材出库数据保存
	*/
	public abstract StockoutAggDO[] save(StockoutAggDO[] aggdos) throws BizException;
	
    /**
	*  耗材出库数据更新
	*/
	public abstract StockoutAggDO[] update(StockoutAggDO[] aggdos) throws BizException;
	
	/**
	*  耗材出库数据逻辑删除
	*/
	public abstract void logicDelete(StockoutAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对耗材出库数据真删除
	 */
	public abstract void deleteByParentDO(McStockOutDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对耗材出库数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(McStockOutDO[] mainDos) throws BizException;
}
