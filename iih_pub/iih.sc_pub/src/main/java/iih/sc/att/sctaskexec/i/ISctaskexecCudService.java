package iih.sc.att.sctaskexec.i;

import xap.mw.core.data.BizException;
import iih.sc.att.sctaskexec.d.SctaskexecDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 考勤执行数据维护服务
*/
public interface ISctaskexecCudService {
	/**
	*  考勤执行数据真删除
	*/
    public abstract void delete(SctaskexecDO[] aggdos) throws BizException;
    
    /**
	*  考勤执行数据插入保存
	*/
	public abstract SctaskexecDO[] insert(SctaskexecDO[] aggdos) throws BizException;
	
    /**
	*  考勤执行数据保存
	*/
	public abstract SctaskexecDO[] save(SctaskexecDO[] aggdos) throws BizException;
	
    /**
	*  考勤执行数据更新
	*/
	public abstract SctaskexecDO[] update(SctaskexecDO[] aggdos) throws BizException;
	
	/**
	*  考勤执行数据逻辑删除
	*/
	public abstract void logicDelete(SctaskexecDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SctaskexecDO[] enableWithoutFilter(SctaskexecDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SctaskexecDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SctaskexecDO[] disableVOWithoutFilter(SctaskexecDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SctaskexecDO[] dos) throws BizException ;
}
