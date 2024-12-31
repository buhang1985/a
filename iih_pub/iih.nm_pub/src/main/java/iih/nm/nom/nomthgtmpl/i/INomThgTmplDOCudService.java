package iih.nm.nom.nomthgtmpl.i;

import xap.mw.core.data.BizException;
import iih.nm.nom.nomthgtmpl.d.NomThgTmplDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 病区事物记录模板数据维护服务
*/
public interface INomThgTmplDOCudService {
	/**
	*  病区事物记录模板数据真删除
	*/
    public abstract void delete(NomThgTmplDO[] aggdos) throws BizException;
    
    /**
	*  病区事物记录模板数据插入保存
	*/
	public abstract NomThgTmplDO[] insert(NomThgTmplDO[] aggdos) throws BizException;
	
    /**
	*  病区事物记录模板数据保存
	*/
	public abstract NomThgTmplDO[] save(NomThgTmplDO[] aggdos) throws BizException;
	
    /**
	*  病区事物记录模板数据更新
	*/
	public abstract NomThgTmplDO[] update(NomThgTmplDO[] aggdos) throws BizException;
	
	/**
	*  病区事物记录模板数据逻辑删除
	*/
	public abstract void logicDelete(NomThgTmplDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NomThgTmplDO[] enableWithoutFilter(NomThgTmplDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NomThgTmplDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NomThgTmplDO[] disableVOWithoutFilter(NomThgTmplDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NomThgTmplDO[] aggdos) throws BizException ;
	
}
