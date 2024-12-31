package iih.mm.qy.stockplinfo.i;

import xap.mw.core.data.BizException;
import iih.mm.qy.stockplinfo.d.StockPlQueryView;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 采购计划查询数据维护服务
*/
public interface IStockplinfoCudService {
	/**
	*  采购计划查询数据真删除
	*/
    public abstract void delete(StockPlQueryView[] aggdos) throws BizException;
    
    /**
	*  采购计划查询数据插入保存
	*/
	public abstract StockPlQueryView[] insert(StockPlQueryView[] aggdos) throws BizException;
	
    /**
	*  采购计划查询数据保存
	*/
	public abstract StockPlQueryView[] save(StockPlQueryView[] aggdos) throws BizException;
	
    /**
	*  采购计划查询数据更新
	*/
	public abstract StockPlQueryView[] update(StockPlQueryView[] aggdos) throws BizException;
	
	/**
	*  采购计划查询数据逻辑删除
	*/
	public abstract void logicDelete(StockPlQueryView[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public StockPlQueryView[] enableWithoutFilter(StockPlQueryView[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(StockPlQueryView[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public StockPlQueryView[] disableVOWithoutFilter(StockPlQueryView[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(StockPlQueryView[] dos) throws BizException ;
}
