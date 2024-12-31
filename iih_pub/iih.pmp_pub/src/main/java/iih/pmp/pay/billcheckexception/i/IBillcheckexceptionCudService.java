package iih.pmp.pay.billcheckexception.i;

import xap.mw.core.data.BizException;
import iih.pmp.pay.billcheckexception.d.BillCheckExceptionDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 对账异常数据数据维护服务
*/
public interface IBillcheckexceptionCudService {
	/**
	*  对账异常数据数据真删除
	*/
    public abstract void delete(BillCheckExceptionDO[] aggdos) throws BizException;
    
    /**
	*  对账异常数据数据插入保存
	*/
	public abstract BillCheckExceptionDO[] insert(BillCheckExceptionDO[] aggdos) throws BizException;
	
    /**
	*  对账异常数据数据保存
	*/
	public abstract BillCheckExceptionDO[] save(BillCheckExceptionDO[] aggdos) throws BizException;
	
    /**
	*  对账异常数据数据更新
	*/
	public abstract BillCheckExceptionDO[] update(BillCheckExceptionDO[] aggdos) throws BizException;
	
	/**
	*  对账异常数据数据逻辑删除
	*/
	public abstract void logicDelete(BillCheckExceptionDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BillCheckExceptionDO[] enableWithoutFilter(BillCheckExceptionDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BillCheckExceptionDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BillCheckExceptionDO[] disableVOWithoutFilter(BillCheckExceptionDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BillCheckExceptionDO[] dos) throws BizException ;
}
