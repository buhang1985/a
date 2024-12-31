package iih.mm.bl.blreserve.i;

import xap.mw.core.data.BizException;
import iih.mm.bl.blreserve.d.StockBlReserveDO;
import iih.mm.bl.blreserve.d.BlreserveAggDO;

/**
* 物品结存预留处理明细数据维护服务
*/
public interface IBlreserveCudService {
	/**
	*  物品结存预留处理明细数据真删除
	*/
    public abstract void delete(BlreserveAggDO[] aggdos) throws BizException;
    
    /**
	*  物品结存预留处理明细数据插入保存
	*/
	public abstract BlreserveAggDO[] insert(BlreserveAggDO[] aggdos) throws BizException;
	
    /**
	*  物品结存预留处理明细数据保存
	*/
	public abstract BlreserveAggDO[] save(BlreserveAggDO[] aggdos) throws BizException;
	
    /**
	*  物品结存预留处理明细数据更新
	*/
	public abstract BlreserveAggDO[] update(BlreserveAggDO[] aggdos) throws BizException;
	
	/**
	*  物品结存预留处理明细数据逻辑删除
	*/
	public abstract void logicDelete(BlreserveAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对物品结存预留处理明细数据真删除
	 */
	public abstract void deleteByParentDO(StockBlReserveDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对物品结存预留处理明细数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(StockBlReserveDO[] mainDos) throws BizException;
}
