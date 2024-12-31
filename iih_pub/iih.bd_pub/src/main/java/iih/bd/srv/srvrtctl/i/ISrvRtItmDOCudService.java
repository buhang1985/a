package iih.bd.srv.srvrtctl.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.srvrtctl.d.SrvRtItmDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 服务开立权限数据维护服务
*/
public interface ISrvRtItmDOCudService {
	/**
	*  服务开立权限数据真删除
	*/
    public abstract void delete(SrvRtItmDO[] aggdos) throws BizException;
    
    /**
	*  服务开立权限数据插入保存
	*/
	public abstract SrvRtItmDO[] insert(SrvRtItmDO[] aggdos) throws BizException;
	
    /**
	*  服务开立权限数据保存
	*/
	public abstract SrvRtItmDO[] save(SrvRtItmDO[] aggdos) throws BizException;
	
    /**
	*  服务开立权限数据更新
	*/
	public abstract SrvRtItmDO[] update(SrvRtItmDO[] aggdos) throws BizException;
	
	/**
	*  服务开立权限数据逻辑删除
	*/
	public abstract void logicDelete(SrvRtItmDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SrvRtItmDO[] enableWithoutFilter(SrvRtItmDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SrvRtItmDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SrvRtItmDO[] disableVOWithoutFilter(SrvRtItmDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SrvRtItmDO[] aggdos) throws BizException ;
	
}
