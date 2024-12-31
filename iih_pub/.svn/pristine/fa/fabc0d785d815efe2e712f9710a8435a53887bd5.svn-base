package iih.bd.srv.maintenanceexeclog.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.maintenanceexeclog.d.MainTenanceExecLogDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 运维工具-运行日志数据维护服务
*/
public interface IMaintenanceexeclogCudService {
	/**
	*  运维工具-运行日志数据真删除
	*/
    public abstract void delete(MainTenanceExecLogDO[] aggdos) throws BizException;
    
    /**
	*  运维工具-运行日志数据插入保存
	*/
	public abstract MainTenanceExecLogDO[] insert(MainTenanceExecLogDO[] aggdos) throws BizException;
	
    /**
	*  运维工具-运行日志数据保存
	*/
	public abstract MainTenanceExecLogDO[] save(MainTenanceExecLogDO[] aggdos) throws BizException;
	
    /**
	*  运维工具-运行日志数据更新
	*/
	public abstract MainTenanceExecLogDO[] update(MainTenanceExecLogDO[] aggdos) throws BizException;
	
	/**
	*  运维工具-运行日志数据逻辑删除
	*/
	public abstract void logicDelete(MainTenanceExecLogDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MainTenanceExecLogDO[] enableWithoutFilter(MainTenanceExecLogDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MainTenanceExecLogDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MainTenanceExecLogDO[] disableVOWithoutFilter(MainTenanceExecLogDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MainTenanceExecLogDO[] dos) throws BizException ;
}
