package iih.sc.apt.scaptappl.i;

import xap.mw.core.data.BizException;
import iih.sc.apt.scaptappl.d.ScAptApplItmDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 计划排班_预约_申请数据维护服务
*/
public interface IScAptApplItmDOCudService {
	/**
	*  计划排班_预约_申请数据真删除
	*/
    public abstract void delete(ScAptApplItmDO[] aggdos) throws BizException;
    
    /**
	*  计划排班_预约_申请数据插入保存
	*/
	public abstract ScAptApplItmDO[] insert(ScAptApplItmDO[] aggdos) throws BizException;
	
    /**
	*  计划排班_预约_申请数据保存
	*/
	public abstract ScAptApplItmDO[] save(ScAptApplItmDO[] aggdos) throws BizException;
	
    /**
	*  计划排班_预约_申请数据更新
	*/
	public abstract ScAptApplItmDO[] update(ScAptApplItmDO[] aggdos) throws BizException;
	
	/**
	*  计划排班_预约_申请数据逻辑删除
	*/
	public abstract void logicDelete(ScAptApplItmDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ScAptApplItmDO[] enableWithoutFilter(ScAptApplItmDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ScAptApplItmDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ScAptApplItmDO[] disableVOWithoutFilter(ScAptApplItmDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ScAptApplItmDO[] aggdos) throws BizException ;
	
}
