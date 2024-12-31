package iih.ci.mr.nu.obstetrics.criticallyill.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.obstetrics.criticallyill.d.CriticallyCustDO;
import iih.ci.mr.nu.obstetrics.criticallyill.d.CriticallyillAggDO;

/**
* 患者就诊护理记录单数据维护服务
*/
public interface ICriticallyillCudService {
	/**
	*  患者就诊护理记录单数据真删除
	*/
    public abstract void delete(CriticallyillAggDO[] aggdos) throws BizException;
    
    /**
	*  患者就诊护理记录单数据插入保存
	*/
	public abstract CriticallyillAggDO[] insert(CriticallyillAggDO[] aggdos) throws BizException;
	
    /**
	*  患者就诊护理记录单数据保存
	*/
	public abstract CriticallyillAggDO[] save(CriticallyillAggDO[] aggdos) throws BizException;
	
    /**
	*  患者就诊护理记录单数据更新
	*/
	public abstract CriticallyillAggDO[] update(CriticallyillAggDO[] aggdos) throws BizException;
	
	/**
	*  患者就诊护理记录单数据逻辑删除
	*/
	public abstract void logicDelete(CriticallyillAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对患者就诊护理记录单数据真删除
	 */
	public abstract void deleteByParentDO(CriticallyCustDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对患者就诊护理记录单数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(CriticallyCustDO[] mainDos) throws BizException;
}
