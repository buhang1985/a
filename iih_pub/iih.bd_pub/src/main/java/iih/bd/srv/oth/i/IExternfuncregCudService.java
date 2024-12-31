package iih.bd.srv.oth.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.oth.d.ExternFuncRegDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 外挂函数注册数据维护服务
*/
public interface IExternfuncregCudService {
	/**
	*  外挂函数注册数据真删除
	*/
    public abstract void delete(ExternFuncRegDO[] aggdos) throws BizException;
    
    /**
	*  外挂函数注册数据插入保存
	*/
	public abstract ExternFuncRegDO[] insert(ExternFuncRegDO[] aggdos) throws BizException;
	
    /**
	*  外挂函数注册数据保存
	*/
	public abstract ExternFuncRegDO[] save(ExternFuncRegDO[] aggdos) throws BizException;
	
    /**
	*  外挂函数注册数据更新
	*/
	public abstract ExternFuncRegDO[] update(ExternFuncRegDO[] aggdos) throws BizException;
	
	/**
	*  外挂函数注册数据逻辑删除
	*/
	public abstract void logicDelete(ExternFuncRegDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ExternFuncRegDO[] enableWithoutFilter(ExternFuncRegDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ExternFuncRegDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ExternFuncRegDO[] disableVOWithoutFilter(ExternFuncRegDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ExternFuncRegDO[] dos) throws BizException ;
}
