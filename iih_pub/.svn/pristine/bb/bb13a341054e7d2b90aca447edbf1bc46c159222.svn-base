package iih.mc.st.stockcheck.i;

import xap.mw.core.data.BizException;
import iih.mc.st.stockcheck.d.McStockCheckDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 库存盘点数据维护服务
*/
public interface IStockcheckMDOCudService {
	/**
	*  库存盘点数据真删除
	*/
    public abstract void delete(McStockCheckDO[] aggdos) throws BizException;
    
    /**
	*  库存盘点数据插入保存
	*/
	public abstract McStockCheckDO[] insert(McStockCheckDO[] aggdos) throws BizException;
	
    /**
	*  库存盘点数据保存
	*/
	public abstract McStockCheckDO[] save(McStockCheckDO[] aggdos) throws BizException;
	
    /**
	*  库存盘点数据更新
	*/
	public abstract McStockCheckDO[] update(McStockCheckDO[] aggdos) throws BizException;
	
	/**
	*  库存盘点数据逻辑删除
	*/
	public abstract void logicDelete(McStockCheckDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public McStockCheckDO[] enableWithoutFilter(McStockCheckDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(McStockCheckDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public McStockCheckDO[] disableVOWithoutFilter(McStockCheckDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(McStockCheckDO[] aggdos) throws BizException ;
	
}
