package iih.pis.ivx.pisivxmsgtmpl.i;

import xap.mw.core.data.BizException;
import iih.pis.ivx.pisivxmsgtmpl.d.PisivxMsgTmplDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 微信发布-群发模板消息数据维护服务
*/
public interface IPisivxmsgtmplCudService {
	/**
	*  微信发布-群发模板消息数据真删除
	*/
    public abstract void delete(PisivxMsgTmplDO[] aggdos) throws BizException;
    
    /**
	*  微信发布-群发模板消息数据插入保存
	*/
	public abstract PisivxMsgTmplDO[] insert(PisivxMsgTmplDO[] aggdos) throws BizException;
	
    /**
	*  微信发布-群发模板消息数据保存
	*/
	public abstract PisivxMsgTmplDO[] save(PisivxMsgTmplDO[] aggdos) throws BizException;
	
    /**
	*  微信发布-群发模板消息数据更新
	*/
	public abstract PisivxMsgTmplDO[] update(PisivxMsgTmplDO[] aggdos) throws BizException;
	
	/**
	*  微信发布-群发模板消息数据逻辑删除
	*/
	public abstract void logicDelete(PisivxMsgTmplDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PisivxMsgTmplDO[] enableWithoutFilter(PisivxMsgTmplDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PisivxMsgTmplDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PisivxMsgTmplDO[] disableVOWithoutFilter(PisivxMsgTmplDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PisivxMsgTmplDO[] dos) throws BizException ;
}
