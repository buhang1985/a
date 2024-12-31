package iih.bd.srv.ortpl.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.ortpl.d.OrTmplDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 医嘱模板数据维护服务
*/
public interface IOrtmplMDOCudService {
	/**
	*  医嘱模板数据真删除
	*/
    public abstract void delete(OrTmplDO[] aggdos) throws BizException;
    
    /**
	*  医嘱模板数据插入保存
	*/
	public abstract OrTmplDO[] insert(OrTmplDO[] aggdos) throws BizException;
	
    /**
	*  医嘱模板数据保存
	*/
	public abstract OrTmplDO[] save(OrTmplDO[] aggdos) throws BizException;
	
    /**
	*  医嘱模板数据更新
	*/
	public abstract OrTmplDO[] update(OrTmplDO[] aggdos) throws BizException;
	
	/**
	*  医嘱模板数据逻辑删除
	*/
	public abstract void logicDelete(OrTmplDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public OrTmplDO[] enableWithoutFilter(OrTmplDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(OrTmplDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public OrTmplDO[] disableVOWithoutFilter(OrTmplDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(OrTmplDO[] aggdos) throws BizException ;
	
}
