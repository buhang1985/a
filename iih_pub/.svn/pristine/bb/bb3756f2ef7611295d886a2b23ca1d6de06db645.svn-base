package iih.mm.pl.stockoutstatistics.i;

import xap.mw.core.data.BizException;
import iih.mm.pl.stockoutstatistics.d.StockOutStatisticsDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 出库统计数据维护服务
*/
public interface IStockoutstatisticsCudService {
	/**
	*  出库统计数据真删除
	*/
    public abstract void delete(StockOutStatisticsDO[] aggdos) throws BizException;
    
    /**
	*  出库统计数据插入保存
	*/
	public abstract StockOutStatisticsDO[] insert(StockOutStatisticsDO[] aggdos) throws BizException;
	
    /**
	*  出库统计数据保存
	*/
	public abstract StockOutStatisticsDO[] save(StockOutStatisticsDO[] aggdos) throws BizException;
	
    /**
	*  出库统计数据更新
	*/
	public abstract StockOutStatisticsDO[] update(StockOutStatisticsDO[] aggdos) throws BizException;
	
	/**
	*  出库统计数据逻辑删除
	*/
	public abstract void logicDelete(StockOutStatisticsDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public StockOutStatisticsDO[] enableWithoutFilter(StockOutStatisticsDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(StockOutStatisticsDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public StockOutStatisticsDO[] disableVOWithoutFilter(StockOutStatisticsDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(StockOutStatisticsDO[] dos) throws BizException ;
}
