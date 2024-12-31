package iih.bd.srv.ext.medsrvvalidate.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.ext.medsrvvalidate.d.MedSrvValidateResult;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 服务校验数据维护服务
*/
public interface IMedsrvvalidateCudService {
	/**
	*  服务校验数据真删除
	*/
    public abstract void delete(MedSrvValidateResult[] aggdos) throws BizException;
    
    /**
	*  服务校验数据插入保存
	*/
	public abstract MedSrvValidateResult[] insert(MedSrvValidateResult[] aggdos) throws BizException;
	
    /**
	*  服务校验数据保存
	*/
	public abstract MedSrvValidateResult[] save(MedSrvValidateResult[] aggdos) throws BizException;
	
    /**
	*  服务校验数据更新
	*/
	public abstract MedSrvValidateResult[] update(MedSrvValidateResult[] aggdos) throws BizException;
	
	/**
	*  服务校验数据逻辑删除
	*/
	public abstract void logicDelete(MedSrvValidateResult[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MedSrvValidateResult[] enableWithoutFilter(MedSrvValidateResult[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MedSrvValidateResult[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MedSrvValidateResult[] disableVOWithoutFilter(MedSrvValidateResult[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MedSrvValidateResult[] dos) throws BizException ;
}
