package iih.pe.papt.pepsnitmsel.i;

import xap.mw.core.data.BizException;
import iih.pe.papt.pepsnitmsel.d.PePsnapptItmDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体检项目选择数据维护服务
*/
public interface IPepsnitmselCudService {
	/**
	*  体检项目选择数据真删除
	*/
    public abstract void delete(PePsnapptItmDO[] aggdos) throws BizException;
    
    /**
	*  体检项目选择数据插入保存
	*/
	public abstract PePsnapptItmDO[] insert(PePsnapptItmDO[] aggdos) throws BizException;
	
    /**
	*  体检项目选择数据保存
	*/
	public abstract PePsnapptItmDO[] save(PePsnapptItmDO[] aggdos) throws BizException;
	
    /**
	*  体检项目选择数据更新
	*/
	public abstract PePsnapptItmDO[] update(PePsnapptItmDO[] aggdos) throws BizException;
	
	/**
	*  体检项目选择数据逻辑删除
	*/
	public abstract void logicDelete(PePsnapptItmDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PePsnapptItmDO[] enableWithoutFilter(PePsnapptItmDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PePsnapptItmDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PePsnapptItmDO[] disableVOWithoutFilter(PePsnapptItmDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PePsnapptItmDO[] dos) throws BizException ;
}
