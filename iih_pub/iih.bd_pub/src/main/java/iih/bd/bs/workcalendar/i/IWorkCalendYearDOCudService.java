package iih.bd.bs.workcalendar.i;

import xap.mw.core.data.BizException;
import iih.bd.bs.workcalendar.d.WorkCalendYearDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 工作日历数据维护服务
*/
public interface IWorkCalendYearDOCudService {
	/**
	*  工作日历数据真删除
	*/
    public abstract void delete(WorkCalendYearDO[] aggdos) throws BizException;
    
    /**
	*  工作日历数据插入保存
	*/
	public abstract WorkCalendYearDO[] insert(WorkCalendYearDO[] aggdos) throws BizException;
	
    /**
	*  工作日历数据保存
	*/
	public abstract WorkCalendYearDO[] save(WorkCalendYearDO[] aggdos) throws BizException;
	
    /**
	*  工作日历数据更新
	*/
	public abstract WorkCalendYearDO[] update(WorkCalendYearDO[] aggdos) throws BizException;
	
	/**
	*  工作日历数据逻辑删除
	*/
	public abstract void logicDelete(WorkCalendYearDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public WorkCalendYearDO[] enableWithoutFilter(WorkCalendYearDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(WorkCalendYearDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public WorkCalendYearDO[] disableVOWithoutFilter(WorkCalendYearDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(WorkCalendYearDO[] aggdos) throws BizException ;
	
}
