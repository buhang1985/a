package iih.mc.mc.stockperinit.i;

import xap.mw.core.data.BizException;
import iih.mc.mc.stockperinit.d.McStockPerInitDO;
import iih.mc.mc.stockperinit.d.StockperinitAggDO;

/**
* 耗材库存期初数据维护服务
*/
public interface IStockperinitCudService {
	/**
	*  耗材库存期初数据真删除
	*/
    public abstract void delete(StockperinitAggDO[] aggdos) throws BizException;
    
    /**
	*  耗材库存期初数据插入保存
	*/
	public abstract StockperinitAggDO[] insert(StockperinitAggDO[] aggdos) throws BizException;
	
    /**
	*  耗材库存期初数据保存
	*/
	public abstract StockperinitAggDO[] save(StockperinitAggDO[] aggdos) throws BizException;
	
    /**
	*  耗材库存期初数据更新
	*/
	public abstract StockperinitAggDO[] update(StockperinitAggDO[] aggdos) throws BizException;
	
	/**
	*  耗材库存期初数据逻辑删除
	*/
	public abstract void logicDelete(StockperinitAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对耗材库存期初数据真删除
	 */
	public abstract void deleteByParentDO(McStockPerInitDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对耗材库存期初数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(McStockPerInitDO[] mainDos) throws BizException;
}
