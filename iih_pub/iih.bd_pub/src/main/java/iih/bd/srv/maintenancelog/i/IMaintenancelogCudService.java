package iih.bd.srv.maintenancelog.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.maintenancelog.d.MainTenanceLogDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 运维工具—管理日志数据维护服务
*/
public interface IMaintenancelogCudService {
	/**
	*  运维工具—管理日志数据真删除
	*/
    public abstract void delete(MainTenanceLogDO[] aggdos) throws BizException;
    
    /**
	*  运维工具—管理日志数据插入保存
	*/
	public abstract MainTenanceLogDO[] insert(MainTenanceLogDO[] aggdos) throws BizException;
	
    /**
	*  运维工具—管理日志数据保存
	*/
	public abstract MainTenanceLogDO[] save(MainTenanceLogDO[] aggdos) throws BizException;
	
    /**
	*  运维工具—管理日志数据更新
	*/
	public abstract MainTenanceLogDO[] update(MainTenanceLogDO[] aggdos) throws BizException;
	
	/**
	*  运维工具—管理日志数据逻辑删除
	*/
	public abstract void logicDelete(MainTenanceLogDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MainTenanceLogDO[] enableWithoutFilter(MainTenanceLogDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MainTenanceLogDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MainTenanceLogDO[] disableVOWithoutFilter(MainTenanceLogDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MainTenanceLogDO[] dos) throws BizException ;
}
