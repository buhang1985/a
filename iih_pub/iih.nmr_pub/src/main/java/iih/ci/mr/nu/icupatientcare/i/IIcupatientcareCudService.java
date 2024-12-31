package iih.ci.mr.nu.icupatientcare.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.icupatientcare.d.PatientInfoDO;
import iih.ci.mr.nu.icupatientcare.d.IcupatientcareAggDO;

/**
* ICU患者护理记录单数据维护服务
*/
public interface IIcupatientcareCudService {
	/**
	*  ICU患者护理记录单数据真删除
	*/
    public abstract void delete(IcupatientcareAggDO[] aggdos) throws BizException;
    
    /**
	*  ICU患者护理记录单数据插入保存
	*/
	public abstract IcupatientcareAggDO[] insert(IcupatientcareAggDO[] aggdos) throws BizException;
	
    /**
	*  ICU患者护理记录单数据保存
	*/
	public abstract IcupatientcareAggDO[] save(IcupatientcareAggDO[] aggdos) throws BizException;
	
    /**
	*  ICU患者护理记录单数据更新
	*/
	public abstract IcupatientcareAggDO[] update(IcupatientcareAggDO[] aggdos) throws BizException;
	
	/**
	*  ICU患者护理记录单数据逻辑删除
	*/
	public abstract void logicDelete(IcupatientcareAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对ICU患者护理记录单数据真删除
	 */
	public abstract void deleteByParentDO(PatientInfoDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对ICU患者护理记录单数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PatientInfoDO[] mainDos) throws BizException;
}
