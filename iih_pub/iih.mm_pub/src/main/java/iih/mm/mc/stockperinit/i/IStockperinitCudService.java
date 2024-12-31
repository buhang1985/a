package iih.mm.mc.stockperinit.i;

import xap.mw.core.data.BizException;
import iih.mm.mc.stockperinit.d.StockPerInitDO;
import iih.mm.mc.stockperinit.d.StockperinitAggDO;

/**
* 库存期初数据维护服务
*/
public interface IStockperinitCudService {
	/**
	*  库存期初数据真删除
	*/
    public abstract void delete(StockperinitAggDO[] aggdos) throws BizException;
    
    /**
	*  库存期初数据插入保存
	*/
	public abstract StockperinitAggDO[] insert(StockperinitAggDO[] aggdos) throws BizException;
	
    /**
	*  库存期初数据保存
	*/
	public abstract StockperinitAggDO[] save(StockperinitAggDO[] aggdos) throws BizException;
	
    /**
	*  库存期初数据更新
	*/
	public abstract StockperinitAggDO[] update(StockperinitAggDO[] aggdos) throws BizException;
	
	/**
	*  库存期初数据逻辑删除
	*/
	public abstract void logicDelete(StockperinitAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对库存期初数据真删除
	 */
	public abstract void deleteByParentDO(StockPerInitDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对库存期初数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(StockPerInitDO[] mainDos) throws BizException;
}
