package iih.nm.nqm.nmnqmtask.i;

import xap.mw.core.data.BizException;
import iih.nm.nqm.nmnqmtask.d.NmNqmTaskDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 护理管理_检查任务数据维护服务
*/
public interface INqmtaskMDOCudService {
	/**
	*  护理管理_检查任务数据真删除
	*/
    public abstract void delete(NmNqmTaskDO[] aggdos) throws BizException;
    
    /**
	*  护理管理_检查任务数据插入保存
	*/
	public abstract NmNqmTaskDO[] insert(NmNqmTaskDO[] aggdos) throws BizException;
	
    /**
	*  护理管理_检查任务数据保存
	*/
	public abstract NmNqmTaskDO[] save(NmNqmTaskDO[] aggdos) throws BizException;
	
    /**
	*  护理管理_检查任务数据更新
	*/
	public abstract NmNqmTaskDO[] update(NmNqmTaskDO[] aggdos) throws BizException;
	
	/**
	*  护理管理_检查任务数据逻辑删除
	*/
	public abstract void logicDelete(NmNqmTaskDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmNqmTaskDO[] enableWithoutFilter(NmNqmTaskDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmNqmTaskDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmNqmTaskDO[] disableVOWithoutFilter(NmNqmTaskDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmNqmTaskDO[] aggdos) throws BizException ;
	
}
