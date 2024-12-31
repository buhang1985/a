package iih.bd.srv.srvpkggrpitm.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.srvpkggrpitm.d.SrvPkgItmSrvContrastDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 医疗服务包分组项目数据维护服务
*/
public interface ISrvPkgItmSrvContrastDOCudService {
	/**
	*  医疗服务包分组项目数据真删除
	*/
    public abstract void delete(SrvPkgItmSrvContrastDO[] aggdos) throws BizException;
    
    /**
	*  医疗服务包分组项目数据插入保存
	*/
	public abstract SrvPkgItmSrvContrastDO[] insert(SrvPkgItmSrvContrastDO[] aggdos) throws BizException;
	
    /**
	*  医疗服务包分组项目数据保存
	*/
	public abstract SrvPkgItmSrvContrastDO[] save(SrvPkgItmSrvContrastDO[] aggdos) throws BizException;
	
    /**
	*  医疗服务包分组项目数据更新
	*/
	public abstract SrvPkgItmSrvContrastDO[] update(SrvPkgItmSrvContrastDO[] aggdos) throws BizException;
	
	/**
	*  医疗服务包分组项目数据逻辑删除
	*/
	public abstract void logicDelete(SrvPkgItmSrvContrastDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SrvPkgItmSrvContrastDO[] enableWithoutFilter(SrvPkgItmSrvContrastDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SrvPkgItmSrvContrastDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SrvPkgItmSrvContrastDO[] disableVOWithoutFilter(SrvPkgItmSrvContrastDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SrvPkgItmSrvContrastDO[] aggdos) throws BizException ;
	
}
