package iih.nm.nhr.nhrschedweek.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.nhrschedweek.d.NhrSchedWeekDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 排班周信息数据维护服务
*/
public interface INhrschedweekCudService {
	/**
	*  排班周信息数据真删除
	*/
    public abstract void delete(NhrSchedWeekDO[] aggdos) throws BizException;
    
    /**
	*  排班周信息数据插入保存
	*/
	public abstract NhrSchedWeekDO[] insert(NhrSchedWeekDO[] aggdos) throws BizException;
	
    /**
	*  排班周信息数据保存
	*/
	public abstract NhrSchedWeekDO[] save(NhrSchedWeekDO[] aggdos) throws BizException;
	
    /**
	*  排班周信息数据更新
	*/
	public abstract NhrSchedWeekDO[] update(NhrSchedWeekDO[] aggdos) throws BizException;
	
	/**
	*  排班周信息数据逻辑删除
	*/
	public abstract void logicDelete(NhrSchedWeekDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NhrSchedWeekDO[] enableWithoutFilter(NhrSchedWeekDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NhrSchedWeekDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NhrSchedWeekDO[] disableVOWithoutFilter(NhrSchedWeekDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NhrSchedWeekDO[] dos) throws BizException ;
}
