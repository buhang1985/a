package iih.mm.qy.stockoutinfo.i;

import xap.mw.core.data.BizException;
import iih.mm.qy.stockoutinfo.d.StockOutQueryView;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 出库单查询数据维护服务
*/
public interface IStockoutinfoCudService {
	/**
	*  出库单查询数据真删除
	*/
    public abstract void delete(StockOutQueryView[] aggdos) throws BizException;
    
    /**
	*  出库单查询数据插入保存
	*/
	public abstract StockOutQueryView[] insert(StockOutQueryView[] aggdos) throws BizException;
	
    /**
	*  出库单查询数据保存
	*/
	public abstract StockOutQueryView[] save(StockOutQueryView[] aggdos) throws BizException;
	
    /**
	*  出库单查询数据更新
	*/
	public abstract StockOutQueryView[] update(StockOutQueryView[] aggdos) throws BizException;
	
	/**
	*  出库单查询数据逻辑删除
	*/
	public abstract void logicDelete(StockOutQueryView[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public StockOutQueryView[] enableWithoutFilter(StockOutQueryView[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(StockOutQueryView[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public StockOutQueryView[] disableVOWithoutFilter(StockOutQueryView[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(StockOutQueryView[] dos) throws BizException ;
}
