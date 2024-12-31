package iih.mm.qy.stockbackinfo.i;

import xap.mw.core.data.BizException;
import iih.mm.qy.stockbackinfo.d.StockBackQueryView;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 单到回冲明细查数据维护服务
*/
public interface IStockbackinfoCudService {
	/**
	*  单到回冲明细查数据真删除
	*/
    public abstract void delete(StockBackQueryView[] aggdos) throws BizException;
    
    /**
	*  单到回冲明细查数据插入保存
	*/
	public abstract StockBackQueryView[] insert(StockBackQueryView[] aggdos) throws BizException;
	
    /**
	*  单到回冲明细查数据保存
	*/
	public abstract StockBackQueryView[] save(StockBackQueryView[] aggdos) throws BizException;
	
    /**
	*  单到回冲明细查数据更新
	*/
	public abstract StockBackQueryView[] update(StockBackQueryView[] aggdos) throws BizException;
	
	/**
	*  单到回冲明细查数据逻辑删除
	*/
	public abstract void logicDelete(StockBackQueryView[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public StockBackQueryView[] enableWithoutFilter(StockBackQueryView[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(StockBackQueryView[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public StockBackQueryView[] disableVOWithoutFilter(StockBackQueryView[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(StockBackQueryView[] dos) throws BizException ;
}
