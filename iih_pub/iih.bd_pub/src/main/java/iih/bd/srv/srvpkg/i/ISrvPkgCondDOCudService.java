package iih.bd.srv.srvpkg.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.srvpkg.d.SrvPkgCondDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 医疗服务包数据维护服务
*/
public interface ISrvPkgCondDOCudService {
	/**
	*  医疗服务包数据真删除
	*/
    public abstract void delete(SrvPkgCondDO[] aggdos) throws BizException;
    
    /**
	*  医疗服务包数据插入保存
	*/
	public abstract SrvPkgCondDO[] insert(SrvPkgCondDO[] aggdos) throws BizException;
	
    /**
	*  医疗服务包数据保存
	*/
	public abstract SrvPkgCondDO[] save(SrvPkgCondDO[] aggdos) throws BizException;
	
    /**
	*  医疗服务包数据更新
	*/
	public abstract SrvPkgCondDO[] update(SrvPkgCondDO[] aggdos) throws BizException;
	
	/**
	*  医疗服务包数据逻辑删除
	*/
	public abstract void logicDelete(SrvPkgCondDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SrvPkgCondDO[] enableWithoutFilter(SrvPkgCondDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SrvPkgCondDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SrvPkgCondDO[] disableVOWithoutFilter(SrvPkgCondDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SrvPkgCondDO[] aggdos) throws BizException ;
	
}