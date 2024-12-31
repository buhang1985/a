package iih.sc.scp.scplticks.i;

import xap.mw.core.data.BizException;
import iih.sc.scp.scplticks.d.ScPlanWeekTicksDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 排班计划号段数据维护服务
*/
public interface IScplticksCudService {
	/**
	*  排班计划号段数据真删除
	*/
    public abstract void delete(ScPlanWeekTicksDO[] aggdos) throws BizException;
    
    /**
	*  排班计划号段数据插入保存
	*/
	public abstract ScPlanWeekTicksDO[] insert(ScPlanWeekTicksDO[] aggdos) throws BizException;
	
    /**
	*  排班计划号段数据保存
	*/
	public abstract ScPlanWeekTicksDO[] save(ScPlanWeekTicksDO[] aggdos) throws BizException;
	
    /**
	*  排班计划号段数据更新
	*/
	public abstract ScPlanWeekTicksDO[] update(ScPlanWeekTicksDO[] aggdos) throws BizException;
	
	/**
	*  排班计划号段数据逻辑删除
	*/
	public abstract void logicDelete(ScPlanWeekTicksDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ScPlanWeekTicksDO[] enableWithoutFilter(ScPlanWeekTicksDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ScPlanWeekTicksDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ScPlanWeekTicksDO[] disableVOWithoutFilter(ScPlanWeekTicksDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ScPlanWeekTicksDO[] dos) throws BizException ;
}
