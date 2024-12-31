package iih.sc.att.sctaskexecperi.i;

import xap.mw.core.data.BizException;
import iih.sc.att.sctaskexecperi.d.ScTaskExecPeriDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 考勤执行期间数据维护服务
*/
public interface ISctaskexecperiCudService {
	/**
	*  考勤执行期间数据真删除
	*/
    public abstract void delete(ScTaskExecPeriDO[] aggdos) throws BizException;
    
    /**
	*  考勤执行期间数据插入保存
	*/
	public abstract ScTaskExecPeriDO[] insert(ScTaskExecPeriDO[] aggdos) throws BizException;
	
    /**
	*  考勤执行期间数据保存
	*/
	public abstract ScTaskExecPeriDO[] save(ScTaskExecPeriDO[] aggdos) throws BizException;
	
    /**
	*  考勤执行期间数据更新
	*/
	public abstract ScTaskExecPeriDO[] update(ScTaskExecPeriDO[] aggdos) throws BizException;
	
	/**
	*  考勤执行期间数据逻辑删除
	*/
	public abstract void logicDelete(ScTaskExecPeriDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ScTaskExecPeriDO[] enableWithoutFilter(ScTaskExecPeriDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ScTaskExecPeriDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ScTaskExecPeriDO[] disableVOWithoutFilter(ScTaskExecPeriDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ScTaskExecPeriDO[] dos) throws BizException ;
}
