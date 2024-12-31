package iih.sc.apt.scaptapplexchl.i;

import xap.mw.core.data.BizException;
import iih.sc.apt.scaptapplexchl.d.ScAptApplExchlDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 计划排班_预约_申请_外部渠道数据维护服务
*/
public interface IScaptapplexchlCudService {
	/**
	*  计划排班_预约_申请_外部渠道数据真删除
	*/
    public abstract void delete(ScAptApplExchlDO[] aggdos) throws BizException;
    
    /**
	*  计划排班_预约_申请_外部渠道数据插入保存
	*/
	public abstract ScAptApplExchlDO[] insert(ScAptApplExchlDO[] aggdos) throws BizException;
	
    /**
	*  计划排班_预约_申请_外部渠道数据保存
	*/
	public abstract ScAptApplExchlDO[] save(ScAptApplExchlDO[] aggdos) throws BizException;
	
    /**
	*  计划排班_预约_申请_外部渠道数据更新
	*/
	public abstract ScAptApplExchlDO[] update(ScAptApplExchlDO[] aggdos) throws BizException;
	
	/**
	*  计划排班_预约_申请_外部渠道数据逻辑删除
	*/
	public abstract void logicDelete(ScAptApplExchlDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ScAptApplExchlDO[] enableWithoutFilter(ScAptApplExchlDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ScAptApplExchlDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ScAptApplExchlDO[] disableVOWithoutFilter(ScAptApplExchlDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ScAptApplExchlDO[] dos) throws BizException ;
}
