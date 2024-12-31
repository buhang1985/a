package iih.mm.st.stockdaycheck.i;

import xap.mw.core.data.BizException;
import iih.mm.st.stockdaycheck.d.StockDayCheckDO;
import iih.mm.st.stockdaycheck.d.StockdaycheckAggDO;

/**
* 药房日点账数据维护服务
*/
public interface IStockdaycheckCudService {
	/**
	*  药房日点账数据真删除
	*/
    public abstract void delete(StockdaycheckAggDO[] aggdos) throws BizException;
    
    /**
	*  药房日点账数据插入保存
	*/
	public abstract StockdaycheckAggDO[] insert(StockdaycheckAggDO[] aggdos) throws BizException;
	
    /**
	*  药房日点账数据保存
	*/
	public abstract StockdaycheckAggDO[] save(StockdaycheckAggDO[] aggdos) throws BizException;
	
    /**
	*  药房日点账数据更新
	*/
	public abstract StockdaycheckAggDO[] update(StockdaycheckAggDO[] aggdos) throws BizException;
	
	/**
	*  药房日点账数据逻辑删除
	*/
	public abstract void logicDelete(StockdaycheckAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对药房日点账数据真删除
	 */
	public abstract void deleteByParentDO(StockDayCheckDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对药房日点账数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(StockDayCheckDO[] mainDos) throws BizException;
}
