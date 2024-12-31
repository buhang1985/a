package iih.ci.mr.nu.medicrecord.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.medicrecord.d.MedicalRecordSetDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 医疗记录数据集数据维护服务
*/
public interface IMedicrecordMDOCudService {
	/**
	*  医疗记录数据集数据真删除
	*/
    public abstract void delete(MedicalRecordSetDO[] aggdos) throws BizException;
    
    /**
	*  医疗记录数据集数据插入保存
	*/
	public abstract MedicalRecordSetDO[] insert(MedicalRecordSetDO[] aggdos) throws BizException;
	
    /**
	*  医疗记录数据集数据保存
	*/
	public abstract MedicalRecordSetDO[] save(MedicalRecordSetDO[] aggdos) throws BizException;
	
    /**
	*  医疗记录数据集数据更新
	*/
	public abstract MedicalRecordSetDO[] update(MedicalRecordSetDO[] aggdos) throws BizException;
	
	/**
	*  医疗记录数据集数据逻辑删除
	*/
	public abstract void logicDelete(MedicalRecordSetDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MedicalRecordSetDO[] enableWithoutFilter(MedicalRecordSetDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MedicalRecordSetDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MedicalRecordSetDO[] disableVOWithoutFilter(MedicalRecordSetDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MedicalRecordSetDO[] aggdos) throws BizException ;
	
}
