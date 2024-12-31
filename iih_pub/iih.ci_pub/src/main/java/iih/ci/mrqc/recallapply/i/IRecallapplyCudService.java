package iih.ci.mrqc.recallapply.i;

import xap.mw.core.data.BizException;
import iih.ci.mrqc.recallapply.d.ReCallApplyDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 病历召回申请DO数据维护服务
*/
public interface IRecallapplyCudService {
	/**
	*  病历召回申请DO数据真删除
	*/
    public abstract void delete(ReCallApplyDO[] aggdos) throws BizException;
    
    /**
	*  病历召回申请DO数据插入保存
	*/
	public abstract ReCallApplyDO[] insert(ReCallApplyDO[] aggdos) throws BizException;
	
    /**
	*  病历召回申请DO数据保存
	*/
	public abstract ReCallApplyDO[] save(ReCallApplyDO[] aggdos) throws BizException;
	
    /**
	*  病历召回申请DO数据更新
	*/
	public abstract ReCallApplyDO[] update(ReCallApplyDO[] aggdos) throws BizException;
	
	/**
	*  病历召回申请DO数据逻辑删除
	*/
	public abstract void logicDelete(ReCallApplyDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ReCallApplyDO[] enableWithoutFilter(ReCallApplyDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ReCallApplyDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ReCallApplyDO[] disableVOWithoutFilter(ReCallApplyDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ReCallApplyDO[] dos) throws BizException ;
}
