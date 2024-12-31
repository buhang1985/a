package iih.ci.mr.nu.inpatientrecord.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.inpatientrecord.d.InPatientInfoDO;
import iih.ci.mr.nu.inpatientrecord.d.InpatientrecordAggDO;

/**
* 内科住院患者护理记录单数据维护服务
*/
public interface IInpatientrecordCudService {
	/**
	*  内科住院患者护理记录单数据真删除
	*/
    public abstract void delete(InpatientrecordAggDO[] aggdos) throws BizException;
    
    /**
	*  内科住院患者护理记录单数据插入保存
	*/
	public abstract InpatientrecordAggDO[] insert(InpatientrecordAggDO[] aggdos) throws BizException;
	
    /**
	*  内科住院患者护理记录单数据保存
	*/
	public abstract InpatientrecordAggDO[] save(InpatientrecordAggDO[] aggdos) throws BizException;
	
    /**
	*  内科住院患者护理记录单数据更新
	*/
	public abstract InpatientrecordAggDO[] update(InpatientrecordAggDO[] aggdos) throws BizException;
	
	/**
	*  内科住院患者护理记录单数据逻辑删除
	*/
	public abstract void logicDelete(InpatientrecordAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对内科住院患者护理记录单数据真删除
	 */
	public abstract void deleteByParentDO(InPatientInfoDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对内科住院患者护理记录单数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(InPatientInfoDO[] mainDos) throws BizException;
}
