package iih.sc.scp.scplweek.i;

import xap.mw.core.data.BizException;
import iih.sc.scp.scplweek.d.ScPlanWeekEnDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 计划排班_计划_周数据维护服务
*/
public interface IScPlanWeekEnDOCudService {
	/**
	*  计划排班_计划_周数据真删除
	*/
    public abstract void delete(ScPlanWeekEnDO[] aggdos) throws BizException;
    
    /**
	*  计划排班_计划_周数据插入保存
	*/
	public abstract ScPlanWeekEnDO[] insert(ScPlanWeekEnDO[] aggdos) throws BizException;
	
    /**
	*  计划排班_计划_周数据保存
	*/
	public abstract ScPlanWeekEnDO[] save(ScPlanWeekEnDO[] aggdos) throws BizException;
	
    /**
	*  计划排班_计划_周数据更新
	*/
	public abstract ScPlanWeekEnDO[] update(ScPlanWeekEnDO[] aggdos) throws BizException;
	
	/**
	*  计划排班_计划_周数据逻辑删除
	*/
	public abstract void logicDelete(ScPlanWeekEnDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ScPlanWeekEnDO[] enableWithoutFilter(ScPlanWeekEnDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ScPlanWeekEnDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ScPlanWeekEnDO[] disableVOWithoutFilter(ScPlanWeekEnDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ScPlanWeekEnDO[] aggdos) throws BizException ;
	
}
