package iih.pis.ivx.pisivxwordnet.i;

import xap.mw.core.data.BizException;
import iih.pis.ivx.pisivxwordnet.d.PisIvxWordNetDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 微信语言识别词网数据维护服务
*/
public interface IPisivxwordnetCudService {
	/**
	*  微信语言识别词网数据真删除
	*/
    public abstract void delete(PisIvxWordNetDO[] aggdos) throws BizException;
    
    /**
	*  微信语言识别词网数据插入保存
	*/
	public abstract PisIvxWordNetDO[] insert(PisIvxWordNetDO[] aggdos) throws BizException;
	
    /**
	*  微信语言识别词网数据保存
	*/
	public abstract PisIvxWordNetDO[] save(PisIvxWordNetDO[] aggdos) throws BizException;
	
    /**
	*  微信语言识别词网数据更新
	*/
	public abstract PisIvxWordNetDO[] update(PisIvxWordNetDO[] aggdos) throws BizException;
	
	/**
	*  微信语言识别词网数据逻辑删除
	*/
	public abstract void logicDelete(PisIvxWordNetDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PisIvxWordNetDO[] enableWithoutFilter(PisIvxWordNetDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PisIvxWordNetDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PisIvxWordNetDO[] disableVOWithoutFilter(PisIvxWordNetDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PisIvxWordNetDO[] dos) throws BizException ;
}
