package iih.sc.scbd.scheduleca.i;

import xap.mw.core.data.BizException;
import iih.sc.scbd.scheduleca.d.ScheduleCADO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 排班分类数据维护服务
*/
public interface ISchedulecaCudService {
	/**
	*  排班分类数据真删除
	*/
    public abstract void delete(ScheduleCADO[] aggdos) throws BizException;
    
    /**
	*  排班分类数据插入保存
	*/
	public abstract ScheduleCADO[] insert(ScheduleCADO[] aggdos) throws BizException;
	
    /**
	*  排班分类数据保存
	*/
	public abstract ScheduleCADO[] save(ScheduleCADO[] aggdos) throws BizException;
	
    /**
	*  排班分类数据更新
	*/
	public abstract ScheduleCADO[] update(ScheduleCADO[] aggdos) throws BizException;
	
	/**
	*  排班分类数据逻辑删除
	*/
	public abstract void logicDelete(ScheduleCADO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ScheduleCADO[] enableWithoutFilter(ScheduleCADO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ScheduleCADO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ScheduleCADO[] disableVOWithoutFilter(ScheduleCADO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ScheduleCADO[] dos) throws BizException ;
}
