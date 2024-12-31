package iih.pe.pbd.peconsentform.i;

import xap.mw.core.data.BizException;
import iih.pe.pbd.peconsentform.d.PeConsentFormDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体检知情同意书数据维护服务
*/
public interface IPeconsentformCudService {
	/**
	*  体检知情同意书数据真删除
	*/
    public abstract void delete(PeConsentFormDO[] aggdos) throws BizException;
    
    /**
	*  体检知情同意书数据插入保存
	*/
	public abstract PeConsentFormDO[] insert(PeConsentFormDO[] aggdos) throws BizException;
	
    /**
	*  体检知情同意书数据保存
	*/
	public abstract PeConsentFormDO[] save(PeConsentFormDO[] aggdos) throws BizException;
	
    /**
	*  体检知情同意书数据更新
	*/
	public abstract PeConsentFormDO[] update(PeConsentFormDO[] aggdos) throws BizException;
	
	/**
	*  体检知情同意书数据逻辑删除
	*/
	public abstract void logicDelete(PeConsentFormDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeConsentFormDO[] enableWithoutFilter(PeConsentFormDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeConsentFormDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeConsentFormDO[] disableVOWithoutFilter(PeConsentFormDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeConsentFormDO[] dos) throws BizException ;
}
