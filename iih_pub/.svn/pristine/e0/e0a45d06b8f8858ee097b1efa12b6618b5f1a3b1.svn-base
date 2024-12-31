package iih.mm.st.stockcheck.i;

import xap.mw.core.data.BizException;
import iih.mm.st.stockcheck.d.StockCheckDO;
import iih.mm.st.stockcheck.d.StockcheckAggDO;

/**
* 库存盘点数据维护服务
*/
public interface IStockcheckCudService {
	/**
	*  库存盘点数据真删除
	*/
    public abstract void delete(StockcheckAggDO[] aggdos) throws BizException;
    
    /**
	*  库存盘点数据插入保存
	*/
	public abstract StockcheckAggDO[] insert(StockcheckAggDO[] aggdos) throws BizException;
	
    /**
	*  库存盘点数据保存
	*/
	public abstract StockcheckAggDO[] save(StockcheckAggDO[] aggdos) throws BizException;
	
    /**
	*  库存盘点数据更新
	*/
	public abstract StockcheckAggDO[] update(StockcheckAggDO[] aggdos) throws BizException;
	
	/**
	*  库存盘点数据逻辑删除
	*/
	public abstract void logicDelete(StockcheckAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对库存盘点数据真删除
	 */
	public abstract void deleteByParentDO(StockCheckDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对库存盘点数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(StockCheckDO[] mainDos) throws BizException;
}
