package iih.ci.mr.nu.dvtriskass.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.dvtriskass.d.DvtriskassDO;
import iih.ci.mr.nu.dvtriskass.d.DvtriskassAggDO;

/**
* DVT风险评估单数据维护服务
*/
public interface IDvtriskassCudService {
	/**
	*  DVT风险评估单数据真删除
	*/
    public abstract void delete(DvtriskassAggDO[] aggdos) throws BizException;
    
    /**
	*  DVT风险评估单数据插入保存
	*/
	public abstract DvtriskassAggDO[] insert(DvtriskassAggDO[] aggdos) throws BizException;
	
    /**
	*  DVT风险评估单数据保存
	*/
	public abstract DvtriskassAggDO[] save(DvtriskassAggDO[] aggdos) throws BizException;
	
    /**
	*  DVT风险评估单数据更新
	*/
	public abstract DvtriskassAggDO[] update(DvtriskassAggDO[] aggdos) throws BizException;
	
	/**
	*  DVT风险评估单数据逻辑删除
	*/
	public abstract void logicDelete(DvtriskassAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对DVT风险评估单数据真删除
	 */
	public abstract void deleteByParentDO(DvtriskassDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对DVT风险评估单数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(DvtriskassDO[] mainDos) throws BizException;
}
