package iih.mm.st.stockin.i;

import xap.mw.core.data.BizException;
import iih.mm.st.stockin.d.StockInDO;
import iih.mm.st.stockin.d.StockinAggDO;

/**
* 入库单数据维护服务
*/
public interface IStockinCudService {
	/**
	*  入库单数据真删除
	*/
    public abstract void delete(StockinAggDO[] aggdos) throws BizException;
    
    /**
	*  入库单数据插入保存
	*/
	public abstract StockinAggDO[] insert(StockinAggDO[] aggdos) throws BizException;
	
    /**
	*  入库单数据保存
	*/
	public abstract StockinAggDO[] save(StockinAggDO[] aggdos) throws BizException;
	
    /**
	*  入库单数据更新
	*/
	public abstract StockinAggDO[] update(StockinAggDO[] aggdos) throws BizException;
	
	/**
	*  入库单数据逻辑删除
	*/
	public abstract void logicDelete(StockinAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对入库单数据真删除
	 */
	public abstract void deleteByParentDO(StockInDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对入库单数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(StockInDO[] mainDos) throws BizException;
}
