package iih.pis.ivx.pisivxinit.i;

import xap.mw.core.data.BizException;
import iih.pis.ivx.pisivxinit.d.PisivxInitDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 微信服务号初始化数据维护服务
*/
public interface IPisivxinitCudService {
	/**
	*  微信服务号初始化数据真删除
	*/
    public abstract void delete(PisivxInitDO[] aggdos) throws BizException;
    
    /**
	*  微信服务号初始化数据插入保存
	*/
	public abstract PisivxInitDO[] insert(PisivxInitDO[] aggdos) throws BizException;
	
    /**
	*  微信服务号初始化数据保存
	*/
	public abstract PisivxInitDO[] save(PisivxInitDO[] aggdos) throws BizException;
	
    /**
	*  微信服务号初始化数据更新
	*/
	public abstract PisivxInitDO[] update(PisivxInitDO[] aggdos) throws BizException;
	
	/**
	*  微信服务号初始化数据逻辑删除
	*/
	public abstract void logicDelete(PisivxInitDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PisivxInitDO[] enableWithoutFilter(PisivxInitDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PisivxInitDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PisivxInitDO[] disableVOWithoutFilter(PisivxInitDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PisivxInitDO[] dos) throws BizException ;
}
