package iih.mm.st.stockpriceadjust.i;

import xap.mw.core.data.BizException;
import iih.mm.st.stockpriceadjust.d.StockPriceAdjustDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 库存调价数据维护服务
*/
public interface IStockpriceadjustMDOCudService {
	/**
	*  库存调价数据删除
	*/
    public abstract void logicDelete(StockPriceAdjustDO[] aggdos) throws BizException;
    
    /**
	*  库存调价数据插入保存
	*/
	public abstract StockPriceAdjustDO[] insert(StockPriceAdjustDO[] aggdos) throws BizException;
	
    /**
	*  库存调价数据保存
	*/
	public abstract StockPriceAdjustDO[] save(StockPriceAdjustDO[] aggdos) throws BizException;
	
    /**
	*  库存调价数据更新
	*/
	public abstract StockPriceAdjustDO[] update(StockPriceAdjustDO[] aggdos) throws BizException;
	
	/**
	*  库存调价数据真删
	*/
	public abstract void delete(StockPriceAdjustDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public StockPriceAdjustDO[] enableWithoutFilter(StockPriceAdjustDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(StockPriceAdjustDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public StockPriceAdjustDO[] disableVOWithoutFilter(StockPriceAdjustDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(StockPriceAdjustDO[] aggdos) throws BizException ;
	
}
