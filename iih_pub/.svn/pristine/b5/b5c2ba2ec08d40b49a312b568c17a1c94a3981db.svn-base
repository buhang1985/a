package iih.mm.qy.stockoutsum.i;

import xap.mw.core.data.BizException;
import iih.mm.qy.stockoutsum.d.StockOutSumDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 出库汇总数据维护服务
*/
public interface IStockoutsumCudService {
	/**
	*  出库汇总数据真删除
	*/
    public abstract void delete(StockOutSumDO[] aggdos) throws BizException;
    
    /**
	*  出库汇总数据插入保存
	*/
	public abstract StockOutSumDO[] insert(StockOutSumDO[] aggdos) throws BizException;
	
    /**
	*  出库汇总数据保存
	*/
	public abstract StockOutSumDO[] save(StockOutSumDO[] aggdos) throws BizException;
	
    /**
	*  出库汇总数据更新
	*/
	public abstract StockOutSumDO[] update(StockOutSumDO[] aggdos) throws BizException;
	
	/**
	*  出库汇总数据逻辑删除
	*/
	public abstract void logicDelete(StockOutSumDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public StockOutSumDO[] enableWithoutFilter(StockOutSumDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(StockOutSumDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public StockOutSumDO[] disableVOWithoutFilter(StockOutSumDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(StockOutSumDO[] dos) throws BizException ;
}
