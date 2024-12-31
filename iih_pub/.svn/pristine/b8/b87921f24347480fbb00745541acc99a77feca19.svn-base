package iih.mm.qy.stockcheckinfo.i;

import xap.mw.core.data.BizException;
import iih.mm.qy.stockcheckinfo.d.StockChkQueryView;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 盘点信息查询数据维护服务
*/
public interface IStockcheckinfoCudService {
	/**
	*  盘点信息查询数据真删除
	*/
    public abstract void delete(StockChkQueryView[] aggdos) throws BizException;
    
    /**
	*  盘点信息查询数据插入保存
	*/
	public abstract StockChkQueryView[] insert(StockChkQueryView[] aggdos) throws BizException;
	
    /**
	*  盘点信息查询数据保存
	*/
	public abstract StockChkQueryView[] save(StockChkQueryView[] aggdos) throws BizException;
	
    /**
	*  盘点信息查询数据更新
	*/
	public abstract StockChkQueryView[] update(StockChkQueryView[] aggdos) throws BizException;
	
	/**
	*  盘点信息查询数据逻辑删除
	*/
	public abstract void logicDelete(StockChkQueryView[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public StockChkQueryView[] enableWithoutFilter(StockChkQueryView[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(StockChkQueryView[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public StockChkQueryView[] disableVOWithoutFilter(StockChkQueryView[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(StockChkQueryView[] dos) throws BizException ;
}
