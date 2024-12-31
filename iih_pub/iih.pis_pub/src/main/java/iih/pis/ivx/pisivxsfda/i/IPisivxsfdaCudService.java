package iih.pis.ivx.pisivxsfda.i;

import xap.mw.core.data.BizException;
import iih.pis.ivx.pisivxsfda.d.PisIvxSfdaDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 微信服务-整体满意度调查数据维护服务
*/
public interface IPisivxsfdaCudService {
	/**
	*  微信服务-整体满意度调查数据真删除
	*/
    public abstract void delete(PisIvxSfdaDO[] aggdos) throws BizException;
    
    /**
	*  微信服务-整体满意度调查数据插入保存
	*/
	public abstract PisIvxSfdaDO[] insert(PisIvxSfdaDO[] aggdos) throws BizException;
	
    /**
	*  微信服务-整体满意度调查数据保存
	*/
	public abstract PisIvxSfdaDO[] save(PisIvxSfdaDO[] aggdos) throws BizException;
	
    /**
	*  微信服务-整体满意度调查数据更新
	*/
	public abstract PisIvxSfdaDO[] update(PisIvxSfdaDO[] aggdos) throws BizException;
	
	/**
	*  微信服务-整体满意度调查数据逻辑删除
	*/
	public abstract void logicDelete(PisIvxSfdaDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PisIvxSfdaDO[] enableWithoutFilter(PisIvxSfdaDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PisIvxSfdaDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PisIvxSfdaDO[] disableVOWithoutFilter(PisIvxSfdaDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PisIvxSfdaDO[] dos) throws BizException ;
}
