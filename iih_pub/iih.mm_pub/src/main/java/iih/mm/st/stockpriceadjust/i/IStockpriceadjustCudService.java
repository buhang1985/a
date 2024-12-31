package iih.mm.st.stockpriceadjust.i;

import xap.mw.core.data.BizException;
import  iih.mm.st.stockpriceadjust.d.StockpriceadjustAggDO;

/**
* 库存调价数据维护服务
*/
public interface IStockpriceadjustCudService {
	/**
	*  库存调价数据真删除
	*/
    public abstract void delete(StockpriceadjustAggDO[] aggdos) throws BizException;
    
    /**
	*  库存调价数据插入保存
	*/
	public abstract StockpriceadjustAggDO[] insert(StockpriceadjustAggDO[] aggdos) throws BizException;
	
    /**
	*  库存调价数据保存
	*/
	public abstract StockpriceadjustAggDO[] save(StockpriceadjustAggDO[] aggdos) throws BizException;
	
    /**
	*  库存调价数据更新
	*/
	public abstract StockpriceadjustAggDO[] update(StockpriceadjustAggDO[] aggdos) throws BizException;
	
	/**
	*  库存调价数据逻辑删除
	*/
	public abstract void logicDelete(StockpriceadjustAggDO[] aggdos) throws BizException;
}
