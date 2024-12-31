package iih.ci.mr.nu.medicrecord.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.medicrecord.d.MedicalRecordSetDO;
import iih.ci.mr.nu.medicrecord.d.MedicrecordAggDO;

/**
* 医疗记录数据集数据维护服务
*/
public interface IMedicrecordCudService {
	/**
	*  医疗记录数据集数据真删除
	*/
    public abstract void delete(MedicrecordAggDO[] aggdos) throws BizException;
    
    /**
	*  医疗记录数据集数据插入保存
	*/
	public abstract MedicrecordAggDO[] insert(MedicrecordAggDO[] aggdos) throws BizException;
	
    /**
	*  医疗记录数据集数据保存
	*/
	public abstract MedicrecordAggDO[] save(MedicrecordAggDO[] aggdos) throws BizException;
	
    /**
	*  医疗记录数据集数据更新
	*/
	public abstract MedicrecordAggDO[] update(MedicrecordAggDO[] aggdos) throws BizException;
	
	/**
	*  医疗记录数据集数据逻辑删除
	*/
	public abstract void logicDelete(MedicrecordAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对医疗记录数据集数据真删除
	 */
	public abstract void deleteByParentDO(MedicalRecordSetDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对医疗记录数据集数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(MedicalRecordSetDO[] mainDos) throws BizException;
}
