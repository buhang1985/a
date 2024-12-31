package iih.mp.nr.mpsrvplan.i;

import xap.mw.core.data.BizException;
import iih.mp.nr.mpsrvplan.d.MpSrvPlanDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 组件数据维护服务
*/
public interface IMpsrvplanCudService {
	/**
	*  组件数据真删除
	*/
    public abstract void delete(MpSrvPlanDO[] aggdos) throws BizException;
    
    /**
	*  组件数据插入保存
	*/
	public abstract MpSrvPlanDO[] insert(MpSrvPlanDO[] aggdos) throws BizException;
	
    /**
	*  组件数据保存
	*/
	public abstract MpSrvPlanDO[] save(MpSrvPlanDO[] aggdos) throws BizException;
	
    /**
	*  组件数据更新
	*/
	public abstract MpSrvPlanDO[] update(MpSrvPlanDO[] aggdos) throws BizException;
	
	/**
	*  组件数据逻辑删除
	*/
	public abstract void logicDelete(MpSrvPlanDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MpSrvPlanDO[] enableWithoutFilter(MpSrvPlanDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MpSrvPlanDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MpSrvPlanDO[] disableVOWithoutFilter(MpSrvPlanDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MpSrvPlanDO[] dos) throws BizException ;
}