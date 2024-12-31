package iih.mm.st.stockdaycheck.i;

import xap.mw.core.data.BizException;
import iih.mm.st.stockdaycheck.d.StockDayCheckItmDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 药房日点账数据维护服务
*/
public interface IStockDayCheckItmDOCudService {
	/**
	*  药房日点账数据真删除
	*/
    public abstract void delete(StockDayCheckItmDO[] aggdos) throws BizException;
    
    /**
	*  药房日点账数据插入保存
	*/
	public abstract StockDayCheckItmDO[] insert(StockDayCheckItmDO[] aggdos) throws BizException;
	
    /**
	*  药房日点账数据保存
	*/
	public abstract StockDayCheckItmDO[] save(StockDayCheckItmDO[] aggdos) throws BizException;
	
    /**
	*  药房日点账数据更新
	*/
	public abstract StockDayCheckItmDO[] update(StockDayCheckItmDO[] aggdos) throws BizException;
	
	/**
	*  药房日点账数据逻辑删除
	*/
	public abstract void logicDelete(StockDayCheckItmDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public StockDayCheckItmDO[] enableWithoutFilter(StockDayCheckItmDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(StockDayCheckItmDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public StockDayCheckItmDO[] disableVOWithoutFilter(StockDayCheckItmDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(StockDayCheckItmDO[] aggdos) throws BizException ;
	
}
