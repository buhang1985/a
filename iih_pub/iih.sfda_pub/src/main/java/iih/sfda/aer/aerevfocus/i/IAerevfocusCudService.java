package iih.sfda.aer.aerevfocus.i;

import xap.mw.core.data.BizException;
import iih.sfda.aer.aerevfocus.d.AerEvFocusDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 事件关注数据维护服务
*/
public interface IAerevfocusCudService {
	/**
	*  事件关注数据真删除
	*/
    public abstract void delete(AerEvFocusDO[] aggdos) throws BizException;
    
    /**
	*  事件关注数据插入保存
	*/
	public abstract AerEvFocusDO[] insert(AerEvFocusDO[] aggdos) throws BizException;
	
    /**
	*  事件关注数据保存
	*/
	public abstract AerEvFocusDO[] save(AerEvFocusDO[] aggdos) throws BizException;
	
    /**
	*  事件关注数据更新
	*/
	public abstract AerEvFocusDO[] update(AerEvFocusDO[] aggdos) throws BizException;
	
	/**
	*  事件关注数据逻辑删除
	*/
	public abstract void logicDelete(AerEvFocusDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public AerEvFocusDO[] enableWithoutFilter(AerEvFocusDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(AerEvFocusDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public AerEvFocusDO[] disableVOWithoutFilter(AerEvFocusDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(AerEvFocusDO[] dos) throws BizException ;
}
