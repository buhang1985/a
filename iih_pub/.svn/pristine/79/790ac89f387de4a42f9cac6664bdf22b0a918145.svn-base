package iih.bd.srv.maintenance.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.maintenance.d.MainTenanceDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 业务数据运维数据维护服务
*/
public interface IMaintenanceCudService {
	/**
	*  业务数据运维数据真删除
	*/
    public abstract void delete(MainTenanceDO[] aggdos) throws BizException;
    
    /**
	*  业务数据运维数据插入保存
	*/
	public abstract MainTenanceDO[] insert(MainTenanceDO[] aggdos) throws BizException;
	
    /**
	*  业务数据运维数据保存
	*/
	public abstract MainTenanceDO[] save(MainTenanceDO[] aggdos) throws BizException;
	
    /**
	*  业务数据运维数据更新
	*/
	public abstract MainTenanceDO[] update(MainTenanceDO[] aggdos) throws BizException;
	
	/**
	*  业务数据运维数据逻辑删除
	*/
	public abstract void logicDelete(MainTenanceDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MainTenanceDO[] enableWithoutFilter(MainTenanceDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MainTenanceDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MainTenanceDO[] disableVOWithoutFilter(MainTenanceDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MainTenanceDO[] dos) throws BizException ;
}
