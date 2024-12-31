package iih.mc.st.stockin.i;

import xap.mw.core.data.BizException;
import iih.mc.st.stockin.d.McStockInDO;
import iih.mc.st.stockin.d.StockinAggDO;

/**
* 耗材入库单数据维护服务
*/
public interface IStockinCudService {
	/**
	*  耗材入库单数据真删除
	*/
    public abstract void delete(StockinAggDO[] aggdos) throws BizException;
    
    /**
	*  耗材入库单数据插入保存
	*/
	public abstract StockinAggDO[] insert(StockinAggDO[] aggdos) throws BizException;
	
    /**
	*  耗材入库单数据保存
	*/
	public abstract StockinAggDO[] save(StockinAggDO[] aggdos) throws BizException;
	
    /**
	*  耗材入库单数据更新
	*/
	public abstract StockinAggDO[] update(StockinAggDO[] aggdos) throws BizException;
	
	/**
	*  耗材入库单数据逻辑删除
	*/
	public abstract void logicDelete(StockinAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对耗材入库单数据真删除
	 */
	public abstract void deleteByParentDO(McStockInDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对耗材入库单数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(McStockInDO[] mainDos) throws BizException;
}
