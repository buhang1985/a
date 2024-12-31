package iih.bl.pay.blreservepat.i;

import xap.mw.core.data.BizException;
import iih.bl.pay.blreservepat.d.BlReservePatDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 预住院预交金数据维护服务
*/
public interface IBlreservepatCudService {
	/**
	*  预住院预交金数据真删除
	*/
    public abstract void delete(BlReservePatDO[] aggdos) throws BizException;
    
    /**
	*  预住院预交金数据插入保存
	*/
	public abstract BlReservePatDO[] insert(BlReservePatDO[] aggdos) throws BizException;
	
    /**
	*  预住院预交金数据保存
	*/
	public abstract BlReservePatDO[] save(BlReservePatDO[] aggdos) throws BizException;
	
    /**
	*  预住院预交金数据更新
	*/
	public abstract BlReservePatDO[] update(BlReservePatDO[] aggdos) throws BizException;
	
	/**
	*  预住院预交金数据逻辑删除
	*/
	public abstract void logicDelete(BlReservePatDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BlReservePatDO[] enableWithoutFilter(BlReservePatDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BlReservePatDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BlReservePatDO[] disableVOWithoutFilter(BlReservePatDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BlReservePatDO[] dos) throws BizException ;
}
