package iih.hr.hsc.hscschedweek.i;

import xap.mw.core.data.BizException;
import iih.hr.hsc.hscschedweek.d.HscSchedWeekDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 排班周信息数据维护服务
*/
public interface IHscschedweekMDOCudService {
	/**
	*  排班周信息数据真删除
	*/
    public abstract void delete(HscSchedWeekDO[] aggdos) throws BizException;
    
    /**
	*  排班周信息数据插入保存
	*/
	public abstract HscSchedWeekDO[] insert(HscSchedWeekDO[] aggdos) throws BizException;
	
    /**
	*  排班周信息数据保存
	*/
	public abstract HscSchedWeekDO[] save(HscSchedWeekDO[] aggdos) throws BizException;
	
    /**
	*  排班周信息数据更新
	*/
	public abstract HscSchedWeekDO[] update(HscSchedWeekDO[] aggdos) throws BizException;
	
	/**
	*  排班周信息数据逻辑删除
	*/
	public abstract void logicDelete(HscSchedWeekDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HscSchedWeekDO[] enableWithoutFilter(HscSchedWeekDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HscSchedWeekDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HscSchedWeekDO[] disableVOWithoutFilter(HscSchedWeekDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HscSchedWeekDO[] aggdos) throws BizException ;
	
}
