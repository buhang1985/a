package iih.pis.ivx.pisivxnotice.i;

import xap.mw.core.data.BizException;
import iih.pis.ivx.pisivxnotice.d.PisIvxNoticeDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 微信服务-通知数据维护服务
*/
public interface IPisivxnoticeCudService {
	/**
	*  微信服务-通知数据真删除
	*/
    public abstract void delete(PisIvxNoticeDO[] aggdos) throws BizException;
    
    /**
	*  微信服务-通知数据插入保存
	*/
	public abstract PisIvxNoticeDO[] insert(PisIvxNoticeDO[] aggdos) throws BizException;
	
    /**
	*  微信服务-通知数据保存
	*/
	public abstract PisIvxNoticeDO[] save(PisIvxNoticeDO[] aggdos) throws BizException;
	
    /**
	*  微信服务-通知数据更新
	*/
	public abstract PisIvxNoticeDO[] update(PisIvxNoticeDO[] aggdos) throws BizException;
	
	/**
	*  微信服务-通知数据逻辑删除
	*/
	public abstract void logicDelete(PisIvxNoticeDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PisIvxNoticeDO[] enableWithoutFilter(PisIvxNoticeDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PisIvxNoticeDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PisIvxNoticeDO[] disableVOWithoutFilter(PisIvxNoticeDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PisIvxNoticeDO[] dos) throws BizException ;
}
