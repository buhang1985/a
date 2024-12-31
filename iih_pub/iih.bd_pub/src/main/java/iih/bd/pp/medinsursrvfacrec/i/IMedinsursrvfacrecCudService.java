package iih.bd.pp.medinsursrvfacrec.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.medinsursrvfacrec.d.MedInsurSrvFacRecDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保服务设施记录数据维护服务
*/
public interface IMedinsursrvfacrecCudService {
	/**
	*  医保服务设施记录数据真删除
	*/
    public abstract void delete(MedInsurSrvFacRecDO[] aggdos) throws BizException;
    
    /**
	*  医保服务设施记录数据插入保存
	*/
	public abstract MedInsurSrvFacRecDO[] insert(MedInsurSrvFacRecDO[] aggdos) throws BizException;
	
    /**
	*  医保服务设施记录数据保存
	*/
	public abstract MedInsurSrvFacRecDO[] save(MedInsurSrvFacRecDO[] aggdos) throws BizException;
	
    /**
	*  医保服务设施记录数据更新
	*/
	public abstract MedInsurSrvFacRecDO[] update(MedInsurSrvFacRecDO[] aggdos) throws BizException;
	
	/**
	*  医保服务设施记录数据逻辑删除
	*/
	public abstract void logicDelete(MedInsurSrvFacRecDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MedInsurSrvFacRecDO[] enableWithoutFilter(MedInsurSrvFacRecDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MedInsurSrvFacRecDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MedInsurSrvFacRecDO[] disableVOWithoutFilter(MedInsurSrvFacRecDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MedInsurSrvFacRecDO[] dos) throws BizException ;
}
