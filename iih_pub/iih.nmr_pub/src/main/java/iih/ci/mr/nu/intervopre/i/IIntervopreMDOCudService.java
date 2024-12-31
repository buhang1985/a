package iih.ci.mr.nu.intervopre.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.intervopre.d.InterPatInfoDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 介入手术护理记录单数据维护服务
*/
public interface IIntervopreMDOCudService {
	/**
	*  介入手术护理记录单数据真删除
	*/
    public abstract void delete(InterPatInfoDO[] aggdos) throws BizException;
    
    /**
	*  介入手术护理记录单数据插入保存
	*/
	public abstract InterPatInfoDO[] insert(InterPatInfoDO[] aggdos) throws BizException;
	
    /**
	*  介入手术护理记录单数据保存
	*/
	public abstract InterPatInfoDO[] save(InterPatInfoDO[] aggdos) throws BizException;
	
    /**
	*  介入手术护理记录单数据更新
	*/
	public abstract InterPatInfoDO[] update(InterPatInfoDO[] aggdos) throws BizException;
	
	/**
	*  介入手术护理记录单数据逻辑删除
	*/
	public abstract void logicDelete(InterPatInfoDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public InterPatInfoDO[] enableWithoutFilter(InterPatInfoDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(InterPatInfoDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public InterPatInfoDO[] disableVOWithoutFilter(InterPatInfoDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(InterPatInfoDO[] aggdos) throws BizException ;
	
}
