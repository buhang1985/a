package iih.pe.pwf.pedayinit.i;

import xap.mw.core.data.BizException;
import iih.pe.pwf.pedayinit.d.PeDayInitDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体检流程每日初始化数据维护服务
*/
public interface IPedayinitCudService {
	/**
	*  体检流程每日初始化数据真删除
	*/
    public abstract void delete(PeDayInitDO[] aggdos) throws BizException;
    
    /**
	*  体检流程每日初始化数据插入保存
	*/
	public abstract PeDayInitDO[] insert(PeDayInitDO[] aggdos) throws BizException;
	
    /**
	*  体检流程每日初始化数据保存
	*/
	public abstract PeDayInitDO[] save(PeDayInitDO[] aggdos) throws BizException;
	
    /**
	*  体检流程每日初始化数据更新
	*/
	public abstract PeDayInitDO[] update(PeDayInitDO[] aggdos) throws BizException;
	
	/**
	*  体检流程每日初始化数据逻辑删除
	*/
	public abstract void logicDelete(PeDayInitDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeDayInitDO[] enableWithoutFilter(PeDayInitDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeDayInitDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeDayInitDO[] disableVOWithoutFilter(PeDayInitDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeDayInitDO[] dos) throws BizException ;
}
