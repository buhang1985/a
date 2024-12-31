package iih.bd.pp.medinsurrecdiff.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.medinsurrecdiff.d.MedInsurSrvFacRecDiffDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 医保记录差异数据维护服务
*/
public interface IMedInsurSrvFacRecDiffDOCudService {
	/**
	*  医保记录差异数据真删除
	*/
    public abstract void delete(MedInsurSrvFacRecDiffDO[] aggdos) throws BizException;
    
    /**
	*  医保记录差异数据插入保存
	*/
	public abstract MedInsurSrvFacRecDiffDO[] insert(MedInsurSrvFacRecDiffDO[] aggdos) throws BizException;
	
    /**
	*  医保记录差异数据保存
	*/
	public abstract MedInsurSrvFacRecDiffDO[] save(MedInsurSrvFacRecDiffDO[] aggdos) throws BizException;
	
    /**
	*  医保记录差异数据更新
	*/
	public abstract MedInsurSrvFacRecDiffDO[] update(MedInsurSrvFacRecDiffDO[] aggdos) throws BizException;
	
	/**
	*  医保记录差异数据逻辑删除
	*/
	public abstract void logicDelete(MedInsurSrvFacRecDiffDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MedInsurSrvFacRecDiffDO[] enableWithoutFilter(MedInsurSrvFacRecDiffDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MedInsurSrvFacRecDiffDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MedInsurSrvFacRecDiffDO[] disableVOWithoutFilter(MedInsurSrvFacRecDiffDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MedInsurSrvFacRecDiffDO[] aggdos) throws BizException ;
	
}
