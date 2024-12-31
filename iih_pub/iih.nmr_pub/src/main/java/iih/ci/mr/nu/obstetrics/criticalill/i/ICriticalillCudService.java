package iih.ci.mr.nu.obstetrics.criticalill.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.obstetrics.criticalill.d.CriticalCustDO;
import iih.ci.mr.nu.obstetrics.criticalill.d.CriticalillAggDO;

/**
* 患者急诊就诊护理记录单数据维护服务
*/
public interface ICriticalillCudService {
	/**
	*  患者急诊就诊护理记录单数据真删除
	*/
    public abstract void delete(CriticalillAggDO[] aggdos) throws BizException;
    
    /**
	*  患者急诊就诊护理记录单数据插入保存
	*/
	public abstract CriticalillAggDO[] insert(CriticalillAggDO[] aggdos) throws BizException;
	
    /**
	*  患者急诊就诊护理记录单数据保存
	*/
	public abstract CriticalillAggDO[] save(CriticalillAggDO[] aggdos) throws BizException;
	
    /**
	*  患者急诊就诊护理记录单数据更新
	*/
	public abstract CriticalillAggDO[] update(CriticalillAggDO[] aggdos) throws BizException;
	
	/**
	*  患者急诊就诊护理记录单数据逻辑删除
	*/
	public abstract void logicDelete(CriticalillAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对患者急诊就诊护理记录单数据真删除
	 */
	public abstract void deleteByParentDO(CriticalCustDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对患者急诊就诊护理记录单数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(CriticalCustDO[] mainDos) throws BizException;
}
