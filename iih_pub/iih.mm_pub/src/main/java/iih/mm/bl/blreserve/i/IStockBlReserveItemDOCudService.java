package iih.mm.bl.blreserve.i;

import xap.mw.core.data.BizException;
import iih.mm.bl.blreserve.d.StockBlReserveItemDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 物品结存预留处理明细数据维护服务
*/
public interface IStockBlReserveItemDOCudService {
	/**
	*  物品结存预留处理明细数据真删除
	*/
    public abstract void delete(StockBlReserveItemDO[] aggdos) throws BizException;
    
    /**
	*  物品结存预留处理明细数据插入保存
	*/
	public abstract StockBlReserveItemDO[] insert(StockBlReserveItemDO[] aggdos) throws BizException;
	
    /**
	*  物品结存预留处理明细数据保存
	*/
	public abstract StockBlReserveItemDO[] save(StockBlReserveItemDO[] aggdos) throws BizException;
	
    /**
	*  物品结存预留处理明细数据更新
	*/
	public abstract StockBlReserveItemDO[] update(StockBlReserveItemDO[] aggdos) throws BizException;
	
	/**
	*  物品结存预留处理明细数据逻辑删除
	*/
	public abstract void logicDelete(StockBlReserveItemDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public StockBlReserveItemDO[] enableWithoutFilter(StockBlReserveItemDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(StockBlReserveItemDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public StockBlReserveItemDO[] disableVOWithoutFilter(StockBlReserveItemDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(StockBlReserveItemDO[] aggdos) throws BizException ;
	
}
