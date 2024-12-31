package iih.bd.pp.medinsurtreatrec.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.medinsurtreatrec.d.MedInsurTreatRecDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保诊疗记录数据维护服务
*/
public interface IMedinsurtreatrecCudService {
	/**
	*  医保诊疗记录数据真删除
	*/
    public abstract void delete(MedInsurTreatRecDO[] aggdos) throws BizException;
    
    /**
	*  医保诊疗记录数据插入保存
	*/
	public abstract MedInsurTreatRecDO[] insert(MedInsurTreatRecDO[] aggdos) throws BizException;
	
    /**
	*  医保诊疗记录数据保存
	*/
	public abstract MedInsurTreatRecDO[] save(MedInsurTreatRecDO[] aggdos) throws BizException;
	
    /**
	*  医保诊疗记录数据更新
	*/
	public abstract MedInsurTreatRecDO[] update(MedInsurTreatRecDO[] aggdos) throws BizException;
	
	/**
	*  医保诊疗记录数据逻辑删除
	*/
	public abstract void logicDelete(MedInsurTreatRecDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MedInsurTreatRecDO[] enableWithoutFilter(MedInsurTreatRecDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MedInsurTreatRecDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MedInsurTreatRecDO[] disableVOWithoutFilter(MedInsurTreatRecDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MedInsurTreatRecDO[] dos) throws BizException ;
}
