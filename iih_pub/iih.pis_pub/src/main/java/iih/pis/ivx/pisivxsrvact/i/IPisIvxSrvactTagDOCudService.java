package iih.pis.ivx.pisivxsrvact.i;

import xap.mw.core.data.BizException;
import iih.pis.ivx.pisivxsrvact.d.PisIvxSrvactTagDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 微信服务号数据维护服务
*/
public interface IPisIvxSrvactTagDOCudService {
	/**
	*  微信服务号数据真删除
	*/
    public abstract void delete(PisIvxSrvactTagDO[] aggdos) throws BizException;
    
    /**
	*  微信服务号数据插入保存
	*/
	public abstract PisIvxSrvactTagDO[] insert(PisIvxSrvactTagDO[] aggdos) throws BizException;
	
    /**
	*  微信服务号数据保存
	*/
	public abstract PisIvxSrvactTagDO[] save(PisIvxSrvactTagDO[] aggdos) throws BizException;
	
    /**
	*  微信服务号数据更新
	*/
	public abstract PisIvxSrvactTagDO[] update(PisIvxSrvactTagDO[] aggdos) throws BizException;
	
	/**
	*  微信服务号数据逻辑删除
	*/
	public abstract void logicDelete(PisIvxSrvactTagDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PisIvxSrvactTagDO[] enableWithoutFilter(PisIvxSrvactTagDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PisIvxSrvactTagDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PisIvxSrvactTagDO[] disableVOWithoutFilter(PisIvxSrvactTagDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PisIvxSrvactTagDO[] aggdos) throws BizException ;
	
}
