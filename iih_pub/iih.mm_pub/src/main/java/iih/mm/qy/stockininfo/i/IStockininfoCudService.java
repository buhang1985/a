package iih.mm.qy.stockininfo.i;

import xap.mw.core.data.BizException;
import iih.mm.qy.stockininfo.d.StockInQueryView;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 入库信息查询数据维护服务
*/
public interface IStockininfoCudService {
	/**
	*  入库信息查询数据真删除
	*/
    public abstract void delete(StockInQueryView[] aggdos) throws BizException;
    
    /**
	*  入库信息查询数据插入保存
	*/
	public abstract StockInQueryView[] insert(StockInQueryView[] aggdos) throws BizException;
	
    /**
	*  入库信息查询数据保存
	*/
	public abstract StockInQueryView[] save(StockInQueryView[] aggdos) throws BizException;
	
    /**
	*  入库信息查询数据更新
	*/
	public abstract StockInQueryView[] update(StockInQueryView[] aggdos) throws BizException;
	
	/**
	*  入库信息查询数据逻辑删除
	*/
	public abstract void logicDelete(StockInQueryView[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public StockInQueryView[] enableWithoutFilter(StockInQueryView[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(StockInQueryView[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public StockInQueryView[] disableVOWithoutFilter(StockInQueryView[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(StockInQueryView[] dos) throws BizException ;
}
