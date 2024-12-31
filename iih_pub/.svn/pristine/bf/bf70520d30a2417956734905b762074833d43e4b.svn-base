package iih.bd.srv.operateprocess.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.operateprocess.d.OperateProcessDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 操作流程数据维护服务
*/
public interface IOperateprocessCudService {
	/**
	*  操作流程数据真删除
	*/
    public abstract void delete(OperateProcessDO[] aggdos) throws BizException;
    
    /**
	*  操作流程数据插入保存
	*/
	public abstract OperateProcessDO[] insert(OperateProcessDO[] aggdos) throws BizException;
	
    /**
	*  操作流程数据保存
	*/
	public abstract OperateProcessDO[] save(OperateProcessDO[] aggdos) throws BizException;
	
    /**
	*  操作流程数据更新
	*/
	public abstract OperateProcessDO[] update(OperateProcessDO[] aggdos) throws BizException;
	
	/**
	*  操作流程数据逻辑删除
	*/
	public abstract void logicDelete(OperateProcessDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public OperateProcessDO[] enableWithoutFilter(OperateProcessDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(OperateProcessDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public OperateProcessDO[] disableVOWithoutFilter(OperateProcessDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(OperateProcessDO[] dos) throws BizException ;
}
