package iih.mm.pl.stockplan.i;

import xap.mw.core.data.BizException;
import  iih.mm.pl.stockplan.d.StockplanAggDO;

/**
* 库存计划数据维护服务
*/
public interface IStockplanCudService {
	/**
	*  库存计划数据真删除
	*/
    public abstract void delete(StockplanAggDO[] aggdos) throws BizException;
    
    /**
	*  库存计划数据插入保存
	*/
	public abstract StockplanAggDO[] insert(StockplanAggDO[] aggdos) throws BizException;
	
    /**
	*  库存计划数据保存
	*/
	public abstract StockplanAggDO[] save(StockplanAggDO[] aggdos) throws BizException;
	
    /**
	*  库存计划数据更新
	*/
	public abstract StockplanAggDO[] update(StockplanAggDO[] aggdos) throws BizException;
	
	/**
	*  库存计划数据逻辑删除
	*/
	public abstract void logicDelete(StockplanAggDO[] aggdos) throws BizException;
}
