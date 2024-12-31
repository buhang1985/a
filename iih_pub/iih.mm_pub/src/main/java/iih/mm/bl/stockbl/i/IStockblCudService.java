package iih.mm.bl.stockbl.i;

import xap.mw.core.data.BizException;
import iih.mm.bl.stockbl.d.StockBlDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 结存数据维护服务
*/
public interface IStockblCudService {
	/**
	*  结存数据真删除
	*/
    public abstract void delete(StockBlDO[] aggdos) throws BizException;
    
    /**
	*  结存数据插入保存
	*/
	public abstract StockBlDO[] insert(StockBlDO[] aggdos) throws BizException;
	
    /**
	*  结存数据保存
	*/
	public abstract StockBlDO[] save(StockBlDO[] aggdos) throws BizException;
	
    /**
	*  结存数据更新
	*/
	public abstract StockBlDO[] update(StockBlDO[] aggdos) throws BizException;
	
	/**
	*  结存数据逻辑删除
	*/
	public abstract void logicDelete(StockBlDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public StockBlDO[] enableWithoutFilter(StockBlDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(StockBlDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public StockBlDO[] disableVOWithoutFilter(StockBlDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(StockBlDO[] dos) throws BizException ;
}
