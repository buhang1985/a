package iih.bd.srv.srvreact.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.srvreact.d.SrvReactDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 服务互斥数据维护服务
*/
public interface ISrvreactMDOCudService {
	/**
	*  服务互斥数据真删除
	*/
    public abstract void delete(SrvReactDO[] aggdos) throws BizException;
    
    /**
	*  服务互斥数据插入保存
	*/
	public abstract SrvReactDO[] insert(SrvReactDO[] aggdos) throws BizException;
	
    /**
	*  服务互斥数据保存
	*/
	public abstract SrvReactDO[] save(SrvReactDO[] aggdos) throws BizException;
	
    /**
	*  服务互斥数据更新
	*/
	public abstract SrvReactDO[] update(SrvReactDO[] aggdos) throws BizException;
	
	/**
	*  服务互斥数据逻辑删除
	*/
	public abstract void logicDelete(SrvReactDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SrvReactDO[] enableWithoutFilter(SrvReactDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SrvReactDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SrvReactDO[] disableVOWithoutFilter(SrvReactDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SrvReactDO[] aggdos) throws BizException ;
	
}
