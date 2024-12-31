package iih.mm.st.stockin.i;

import xap.mw.core.data.BizException;
import iih.mm.st.stockin.d.StockInItemDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 入库单数据维护服务
*/
public interface IStockInItemDOCudService {
	/**
	*  入库单数据删除
	*/
    public abstract void logicDelete(StockInItemDO[] aggdos) throws BizException;
    
    /**
	*  入库单数据插入保存
	*/
	public abstract StockInItemDO[] insert(StockInItemDO[] aggdos) throws BizException;
	
    /**
	*  入库单数据保存
	*/
	public abstract StockInItemDO[] save(StockInItemDO[] aggdos) throws BizException;
	
    /**
	*  入库单数据更新
	*/
	public abstract StockInItemDO[] update(StockInItemDO[] aggdos) throws BizException;
	
	/**
	*  入库单数据真删
	*/
	public abstract void delete(StockInItemDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public StockInItemDO[] enableWithoutFilter(StockInItemDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(StockInItemDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public StockInItemDO[] disableVOWithoutFilter(StockInItemDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(StockInItemDO[] aggdos) throws BizException ;
	
}
