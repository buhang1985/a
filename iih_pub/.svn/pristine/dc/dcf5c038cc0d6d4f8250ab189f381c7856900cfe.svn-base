package iih.sc.scbd.scheduleres.i;

import xap.mw.core.data.BizException;
import iih.sc.scbd.scheduleres.d.ScheduleResDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 排班资源数据维护服务
*/
public interface IScheduleresCudService {
	/**
	*  排班资源数据真删除
	*/
    public abstract void delete(ScheduleResDO[] aggdos) throws BizException;
    
    /**
	*  排班资源数据插入保存
	*/
	public abstract ScheduleResDO[] insert(ScheduleResDO[] aggdos) throws BizException;
	
    /**
	*  排班资源数据保存
	*/
	public abstract ScheduleResDO[] save(ScheduleResDO[] aggdos) throws BizException;
	
    /**
	*  排班资源数据更新
	*/
	public abstract ScheduleResDO[] update(ScheduleResDO[] aggdos) throws BizException;
	
	/**
	*  排班资源数据逻辑删除
	*/
	public abstract void logicDelete(ScheduleResDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ScheduleResDO[] enableWithoutFilter(ScheduleResDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ScheduleResDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ScheduleResDO[] disableVOWithoutFilter(ScheduleResDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ScheduleResDO[] dos) throws BizException ;
}
