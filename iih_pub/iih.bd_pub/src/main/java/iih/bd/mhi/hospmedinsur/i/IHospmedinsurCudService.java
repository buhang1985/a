package iih.bd.mhi.hospmedinsur.i;

import xap.mw.core.data.BizException;
import iih.bd.mhi.hospmedinsur.d.HpHospMedInsurDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医疗保险_医院医保信息数据维护服务
*/
public interface IHospmedinsurCudService {
	/**
	*  医疗保险_医院医保信息数据真删除
	*/
    public abstract void delete(HpHospMedInsurDO[] aggdos) throws BizException;
    
    /**
	*  医疗保险_医院医保信息数据插入保存
	*/
	public abstract HpHospMedInsurDO[] insert(HpHospMedInsurDO[] aggdos) throws BizException;
	
    /**
	*  医疗保险_医院医保信息数据保存
	*/
	public abstract HpHospMedInsurDO[] save(HpHospMedInsurDO[] aggdos) throws BizException;
	
    /**
	*  医疗保险_医院医保信息数据更新
	*/
	public abstract HpHospMedInsurDO[] update(HpHospMedInsurDO[] aggdos) throws BizException;
	
	/**
	*  医疗保险_医院医保信息数据逻辑删除
	*/
	public abstract void logicDelete(HpHospMedInsurDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HpHospMedInsurDO[] enableWithoutFilter(HpHospMedInsurDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HpHospMedInsurDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HpHospMedInsurDO[] disableVOWithoutFilter(HpHospMedInsurDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HpHospMedInsurDO[] dos) throws BizException ;
}
