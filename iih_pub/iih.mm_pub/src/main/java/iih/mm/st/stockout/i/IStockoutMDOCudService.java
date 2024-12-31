package iih.mm.st.stockout.i;

import xap.mw.core.data.BizException;
import iih.mm.st.stockout.d.StockOutDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 出库单数据维护服务
*/
public interface IStockoutMDOCudService {
	/**
	*  出库单数据真删除
	*/
    public abstract void delete(StockOutDO[] aggdos) throws BizException;
    
    /**
	*  出库单数据插入保存
	*/
	public abstract StockOutDO[] insert(StockOutDO[] aggdos) throws BizException;
	
    /**
	*  出库单数据保存
	*/
	public abstract StockOutDO[] save(StockOutDO[] aggdos) throws BizException;
	
    /**
	*  出库单数据更新
	*/
	public abstract StockOutDO[] update(StockOutDO[] aggdos) throws BizException;
	
	/**
	*  出库单数据逻辑删除
	*/
	public abstract void logicDelete(StockOutDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public StockOutDO[] enableWithoutFilter(StockOutDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(StockOutDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public StockOutDO[] disableVOWithoutFilter(StockOutDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(StockOutDO[] aggdos) throws BizException ;
	
}
