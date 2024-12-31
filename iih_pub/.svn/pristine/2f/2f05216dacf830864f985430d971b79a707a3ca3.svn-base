package iih.pis.ivx.pisivxnews.i;

import xap.mw.core.data.BizException;
import iih.pis.ivx.pisivxnews.d.PisivxArticleDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 微信服务-新闻服务数据维护服务
*/
public interface IPisivxArticleDOCudService {
	/**
	*  微信服务-新闻服务数据真删除
	*/
    public abstract void delete(PisivxArticleDO[] aggdos) throws BizException;
    
    /**
	*  微信服务-新闻服务数据插入保存
	*/
	public abstract PisivxArticleDO[] insert(PisivxArticleDO[] aggdos) throws BizException;
	
    /**
	*  微信服务-新闻服务数据保存
	*/
	public abstract PisivxArticleDO[] save(PisivxArticleDO[] aggdos) throws BizException;
	
    /**
	*  微信服务-新闻服务数据更新
	*/
	public abstract PisivxArticleDO[] update(PisivxArticleDO[] aggdos) throws BizException;
	
	/**
	*  微信服务-新闻服务数据逻辑删除
	*/
	public abstract void logicDelete(PisivxArticleDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PisivxArticleDO[] enableWithoutFilter(PisivxArticleDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PisivxArticleDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PisivxArticleDO[] disableVOWithoutFilter(PisivxArticleDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PisivxArticleDO[] aggdos) throws BizException ;
	
}
