package iih.mm.pl.stockplan.i;

import xap.mw.core.data.BizException;
import iih.mm.pl.stockplan.d.StockPlanDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 库存计划数据维护服务
*/
public interface IStockplanMDOCudService {
	/**
	*  库存计划数据删除
	*/
    public abstract void logicDelete(StockPlanDO[] aggdos) throws BizException;
    
    /**
	*  库存计划数据插入保存
	*/
	public abstract StockPlanDO[] insert(StockPlanDO[] aggdos) throws BizException;
	
    /**
	*  库存计划数据保存
	*/
	public abstract StockPlanDO[] save(StockPlanDO[] aggdos) throws BizException;
	
    /**
	*  库存计划数据更新
	*/
	public abstract StockPlanDO[] update(StockPlanDO[] aggdos) throws BizException;
	
	/**
	*  库存计划数据真删
	*/
	public abstract void delete(StockPlanDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public StockPlanDO[] enableWithoutFilter(StockPlanDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(StockPlanDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public StockPlanDO[] disableVOWithoutFilter(StockPlanDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(StockPlanDO[] aggdos) throws BizException ;
	
}
