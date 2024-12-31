package iih.mc.bl.stockbl.i;

import xap.mw.core.data.BizException;
import iih.mc.bl.stockbl.d.McStockBlDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 耗材结存数据维护服务
*/
public interface IStockblCudService {
	/**
	*  耗材结存数据真删除
	*/
    public abstract void delete(McStockBlDO[] aggdos) throws BizException;
    
    /**
	*  耗材结存数据插入保存
	*/
	public abstract McStockBlDO[] insert(McStockBlDO[] aggdos) throws BizException;
	
    /**
	*  耗材结存数据保存
	*/
	public abstract McStockBlDO[] save(McStockBlDO[] aggdos) throws BizException;
	
    /**
	*  耗材结存数据更新
	*/
	public abstract McStockBlDO[] update(McStockBlDO[] aggdos) throws BizException;
	
	/**
	*  耗材结存数据逻辑删除
	*/
	public abstract void logicDelete(McStockBlDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public McStockBlDO[] enableWithoutFilter(McStockBlDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(McStockBlDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public McStockBlDO[] disableVOWithoutFilter(McStockBlDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(McStockBlDO[] dos) throws BizException ;
}
