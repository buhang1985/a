package iih.mp.nr.mpordperformstate.i;

import xap.mw.core.data.BizException;
import iih.mp.nr.mpordperformstate.d.MpOrdPerformStateDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医嘱执行状态数据维护服务
*/
public interface IMpordperformstateCudService {
	/**
	*  医嘱执行状态数据真删除
	*/
    public abstract void delete(MpOrdPerformStateDO[] aggdos) throws BizException;
    
    /**
	*  医嘱执行状态数据插入保存
	*/
	public abstract MpOrdPerformStateDO[] insert(MpOrdPerformStateDO[] aggdos) throws BizException;
	
    /**
	*  医嘱执行状态数据保存
	*/
	public abstract MpOrdPerformStateDO[] save(MpOrdPerformStateDO[] aggdos) throws BizException;
	
    /**
	*  医嘱执行状态数据更新
	*/
	public abstract MpOrdPerformStateDO[] update(MpOrdPerformStateDO[] aggdos) throws BizException;
	
	/**
	*  医嘱执行状态数据逻辑删除
	*/
	public abstract void logicDelete(MpOrdPerformStateDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MpOrdPerformStateDO[] enableWithoutFilter(MpOrdPerformStateDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MpOrdPerformStateDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MpOrdPerformStateDO[] disableVOWithoutFilter(MpOrdPerformStateDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MpOrdPerformStateDO[] dos) throws BizException ;
}
