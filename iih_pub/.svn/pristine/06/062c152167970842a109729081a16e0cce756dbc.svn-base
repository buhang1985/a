package iih.pe.pps.perstslicemng.i;

import xap.mw.core.data.BizException;
import iih.pe.pps.perstslicemng.d.PeRstSliceMngPsnDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 体检重要结果分层管理数据维护服务
*/
public interface IPeRstSliceMngPsnDOCudService {
	/**
	*  体检重要结果分层管理数据真删除
	*/
    public abstract void delete(PeRstSliceMngPsnDO[] aggdos) throws BizException;
    
    /**
	*  体检重要结果分层管理数据插入保存
	*/
	public abstract PeRstSliceMngPsnDO[] insert(PeRstSliceMngPsnDO[] aggdos) throws BizException;
	
    /**
	*  体检重要结果分层管理数据保存
	*/
	public abstract PeRstSliceMngPsnDO[] save(PeRstSliceMngPsnDO[] aggdos) throws BizException;
	
    /**
	*  体检重要结果分层管理数据更新
	*/
	public abstract PeRstSliceMngPsnDO[] update(PeRstSliceMngPsnDO[] aggdos) throws BizException;
	
	/**
	*  体检重要结果分层管理数据逻辑删除
	*/
	public abstract void logicDelete(PeRstSliceMngPsnDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeRstSliceMngPsnDO[] enableWithoutFilter(PeRstSliceMngPsnDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeRstSliceMngPsnDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeRstSliceMngPsnDO[] disableVOWithoutFilter(PeRstSliceMngPsnDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeRstSliceMngPsnDO[] aggdos) throws BizException ;
	
}
