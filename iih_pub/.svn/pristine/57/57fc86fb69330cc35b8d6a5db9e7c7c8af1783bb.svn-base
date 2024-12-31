package iih.mp.nr.mporplan.i;

import xap.mw.core.data.BizException;
import iih.mp.nr.mporplan.d.MpOrPlanDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医嘱执行点数据维护服务
*/
public interface IMporplanCudService {
	/**
	*  医嘱执行点数据真删除
	*/
    public abstract void delete(MpOrPlanDO[] aggdos) throws BizException;
    
    /**
	*  医嘱执行点数据插入保存
	*/
	public abstract MpOrPlanDO[] insert(MpOrPlanDO[] aggdos) throws BizException;
	
    /**
	*  医嘱执行点数据保存
	*/
	public abstract MpOrPlanDO[] save(MpOrPlanDO[] aggdos) throws BizException;
	
    /**
	*  医嘱执行点数据更新
	*/
	public abstract MpOrPlanDO[] update(MpOrPlanDO[] aggdos) throws BizException;
	
	/**
	*  医嘱执行点数据逻辑删除
	*/
	public abstract void logicDelete(MpOrPlanDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MpOrPlanDO[] enableWithoutFilter(MpOrPlanDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MpOrPlanDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MpOrPlanDO[] disableVOWithoutFilter(MpOrPlanDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MpOrPlanDO[] dos) throws BizException ;
}
