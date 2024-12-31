package iih.mp.dg.webservicereissue.i;

import xap.mw.core.data.BizException;
import iih.mp.dg.webservicereissue.d.WebServiceReissueDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 第三方接口补发数据维护服务
*/
public interface IWebservicereissueCudService {
	/**
	*  第三方接口补发数据真删除
	*/
    public abstract void delete(WebServiceReissueDO[] aggdos) throws BizException;
    
    /**
	*  第三方接口补发数据插入保存
	*/
	public abstract WebServiceReissueDO[] insert(WebServiceReissueDO[] aggdos) throws BizException;
	
    /**
	*  第三方接口补发数据保存
	*/
	public abstract WebServiceReissueDO[] save(WebServiceReissueDO[] aggdos) throws BizException;
	
    /**
	*  第三方接口补发数据更新
	*/
	public abstract WebServiceReissueDO[] update(WebServiceReissueDO[] aggdos) throws BizException;
	
	/**
	*  第三方接口补发数据逻辑删除
	*/
	public abstract void logicDelete(WebServiceReissueDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public WebServiceReissueDO[] enableWithoutFilter(WebServiceReissueDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(WebServiceReissueDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public WebServiceReissueDO[] disableVOWithoutFilter(WebServiceReissueDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(WebServiceReissueDO[] dos) throws BizException ;
}
