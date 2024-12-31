package iih.ci.mr.nu.critillpatcare.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.critillpatcare.d.IllPatientDO;
import iih.ci.mr.nu.critillpatcare.d.CritillpatcareAggDO;

/**
* 患者病危护理记录数据维护服务
*/
public interface ICritillpatcareCudService {
	/**
	*  患者病危护理记录数据真删除
	*/
    public abstract void delete(CritillpatcareAggDO[] aggdos) throws BizException;
    
    /**
	*  患者病危护理记录数据插入保存
	*/
	public abstract CritillpatcareAggDO[] insert(CritillpatcareAggDO[] aggdos) throws BizException;
	
    /**
	*  患者病危护理记录数据保存
	*/
	public abstract CritillpatcareAggDO[] save(CritillpatcareAggDO[] aggdos) throws BizException;
	
    /**
	*  患者病危护理记录数据更新
	*/
	public abstract CritillpatcareAggDO[] update(CritillpatcareAggDO[] aggdos) throws BizException;
	
	/**
	*  患者病危护理记录数据逻辑删除
	*/
	public abstract void logicDelete(CritillpatcareAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对患者病危护理记录数据真删除
	 */
	public abstract void deleteByParentDO(IllPatientDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对患者病危护理记录数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(IllPatientDO[] mainDos) throws BizException;
}
