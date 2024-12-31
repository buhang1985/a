package iih.sfda.aer.aerevwarn.i;

import xap.mw.core.data.BizException;
import iih.sfda.aer.aerevwarn.d.AerEvWarnDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 事件更新提醒数据维护服务
*/
public interface IAerevwarnCudService {
	/**
	*  事件更新提醒数据真删除
	*/
    public abstract void delete(AerEvWarnDO[] aggdos) throws BizException;
    
    /**
	*  事件更新提醒数据插入保存
	*/
	public abstract AerEvWarnDO[] insert(AerEvWarnDO[] aggdos) throws BizException;
	
    /**
	*  事件更新提醒数据保存
	*/
	public abstract AerEvWarnDO[] save(AerEvWarnDO[] aggdos) throws BizException;
	
    /**
	*  事件更新提醒数据更新
	*/
	public abstract AerEvWarnDO[] update(AerEvWarnDO[] aggdos) throws BizException;
	
	/**
	*  事件更新提醒数据逻辑删除
	*/
	public abstract void logicDelete(AerEvWarnDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public AerEvWarnDO[] enableWithoutFilter(AerEvWarnDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(AerEvWarnDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public AerEvWarnDO[] disableVOWithoutFilter(AerEvWarnDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(AerEvWarnDO[] dos) throws BizException ;
}
