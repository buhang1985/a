package iih.mm.mc.stockperinit.i;

import xap.mw.core.data.BizException;
import iih.mm.mc.stockperinit.d.StockPerInitItemDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 库存期初数据维护服务
*/
public interface IStockPerInitItemDOCudService {
	/**
	*  库存期初数据真删除
	*/
    public abstract void delete(StockPerInitItemDO[] aggdos) throws BizException;
    
    /**
	*  库存期初数据插入保存
	*/
	public abstract StockPerInitItemDO[] insert(StockPerInitItemDO[] aggdos) throws BizException;
	
    /**
	*  库存期初数据保存
	*/
	public abstract StockPerInitItemDO[] save(StockPerInitItemDO[] aggdos) throws BizException;
	
    /**
	*  库存期初数据更新
	*/
	public abstract StockPerInitItemDO[] update(StockPerInitItemDO[] aggdos) throws BizException;
	
	/**
	*  库存期初数据逻辑删除
	*/
	public abstract void logicDelete(StockPerInitItemDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public StockPerInitItemDO[] enableWithoutFilter(StockPerInitItemDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(StockPerInitItemDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public StockPerInitItemDO[] disableVOWithoutFilter(StockPerInitItemDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(StockPerInitItemDO[] aggdos) throws BizException ;
	
}
