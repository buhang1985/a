package iih.mm.qy.stockdealtypeconfig.i;

import xap.mw.core.data.BizException;
import iih.mm.qy.stockdealtypeconfig.d.StockDealTypeConfigDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 库存交易分类方案配置数据维护服务
*/
public interface IStockdealtypeconfigMDOCudService {
	/**
	*  库存交易分类方案配置数据删除
	*/
    public abstract void logicDelete(StockDealTypeConfigDO[] aggdos) throws BizException;
    
    /**
	*  库存交易分类方案配置数据插入保存
	*/
	public abstract StockDealTypeConfigDO[] insert(StockDealTypeConfigDO[] aggdos) throws BizException;
	
    /**
	*  库存交易分类方案配置数据保存
	*/
	public abstract StockDealTypeConfigDO[] save(StockDealTypeConfigDO[] aggdos) throws BizException;
	
    /**
	*  库存交易分类方案配置数据更新
	*/
	public abstract StockDealTypeConfigDO[] update(StockDealTypeConfigDO[] aggdos) throws BizException;
	
	/**
	*  库存交易分类方案配置数据真删
	*/
	public abstract void delete(StockDealTypeConfigDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public StockDealTypeConfigDO[] enableWithoutFilter(StockDealTypeConfigDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(StockDealTypeConfigDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public StockDealTypeConfigDO[] disableVOWithoutFilter(StockDealTypeConfigDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(StockDealTypeConfigDO[] aggdos) throws BizException ;
	
}
