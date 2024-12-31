package iih.mc.st.stockout.i;

import xap.mw.core.data.BizException;
import iih.mc.st.stockout.d.McStockOutDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 耗材出库数据维护服务
*/
public interface IStockoutMDOCudService {
	/**
	*  耗材出库数据真删除
	*/
    public abstract void delete(McStockOutDO[] aggdos) throws BizException;
    
    /**
	*  耗材出库数据插入保存
	*/
	public abstract McStockOutDO[] insert(McStockOutDO[] aggdos) throws BizException;
	
    /**
	*  耗材出库数据保存
	*/
	public abstract McStockOutDO[] save(McStockOutDO[] aggdos) throws BizException;
	
    /**
	*  耗材出库数据更新
	*/
	public abstract McStockOutDO[] update(McStockOutDO[] aggdos) throws BizException;
	
	/**
	*  耗材出库数据逻辑删除
	*/
	public abstract void logicDelete(McStockOutDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public McStockOutDO[] enableWithoutFilter(McStockOutDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(McStockOutDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public McStockOutDO[] disableVOWithoutFilter(McStockOutDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(McStockOutDO[] aggdos) throws BizException ;
	
}