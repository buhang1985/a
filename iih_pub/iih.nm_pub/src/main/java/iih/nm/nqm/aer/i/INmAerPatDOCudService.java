package iih.nm.nqm.aer.i;

import xap.mw.core.data.BizException;
import iih.nm.nqm.aer.d.NmAerPatDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 不良事件上报数据维护服务
*/
public interface INmAerPatDOCudService {
	/**
	*  不良事件上报数据真删除
	*/
    public abstract void delete(NmAerPatDO[] aggdos) throws BizException;
    
    /**
	*  不良事件上报数据插入保存
	*/
	public abstract NmAerPatDO[] insert(NmAerPatDO[] aggdos) throws BizException;
	
    /**
	*  不良事件上报数据保存
	*/
	public abstract NmAerPatDO[] save(NmAerPatDO[] aggdos) throws BizException;
	
    /**
	*  不良事件上报数据更新
	*/
	public abstract NmAerPatDO[] update(NmAerPatDO[] aggdos) throws BizException;
	
	/**
	*  不良事件上报数据逻辑删除
	*/
	public abstract void logicDelete(NmAerPatDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmAerPatDO[] enableWithoutFilter(NmAerPatDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmAerPatDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmAerPatDO[] disableVOWithoutFilter(NmAerPatDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmAerPatDO[] aggdos) throws BizException ;
	
}
