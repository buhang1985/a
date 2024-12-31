package iih.ci.mr.nu.newbabyskinriskass.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.newbabyskinriskass.d.NewBabySkinAssDO;
import iih.ci.mr.nu.newbabyskinriskass.d.NewbabyskinriskassAggDO;

/**
* 新生儿皮肤风险评估数据维护服务
*/
public interface INewbabyskinriskassCudService {
	/**
	*  新生儿皮肤风险评估数据真删除
	*/
    public abstract void delete(NewbabyskinriskassAggDO[] aggdos) throws BizException;
    
    /**
	*  新生儿皮肤风险评估数据插入保存
	*/
	public abstract NewbabyskinriskassAggDO[] insert(NewbabyskinriskassAggDO[] aggdos) throws BizException;
	
    /**
	*  新生儿皮肤风险评估数据保存
	*/
	public abstract NewbabyskinriskassAggDO[] save(NewbabyskinriskassAggDO[] aggdos) throws BizException;
	
    /**
	*  新生儿皮肤风险评估数据更新
	*/
	public abstract NewbabyskinriskassAggDO[] update(NewbabyskinriskassAggDO[] aggdos) throws BizException;
	
	/**
	*  新生儿皮肤风险评估数据逻辑删除
	*/
	public abstract void logicDelete(NewbabyskinriskassAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对新生儿皮肤风险评估数据真删除
	 */
	public abstract void deleteByParentDO(NewBabySkinAssDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对新生儿皮肤风险评估数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NewBabySkinAssDO[] mainDos) throws BizException;
}
