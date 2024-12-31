package iih.en.pv.inpatient.i;

import xap.mw.core.data.BizException;
import iih.en.pv.inpatient.d.EnPeCmpyDO;
import iih.en.pv.inpatient.d.EnpecmpyAggDO;

/**
* 团检记录数据维护服务
*/
public interface IEnpecmpyCudService {
	/**
	*  团检记录数据真删除
	*/
    public abstract void delete(EnpecmpyAggDO[] aggdos) throws BizException;
    
    /**
	*  团检记录数据插入保存
	*/
	public abstract EnpecmpyAggDO[] insert(EnpecmpyAggDO[] aggdos) throws BizException;
	
    /**
	*  团检记录数据保存
	*/
	public abstract EnpecmpyAggDO[] save(EnpecmpyAggDO[] aggdos) throws BizException;
	
    /**
	*  团检记录数据更新
	*/
	public abstract EnpecmpyAggDO[] update(EnpecmpyAggDO[] aggdos) throws BizException;
	
	/**
	*  团检记录数据逻辑删除
	*/
	public abstract void logicDelete(EnpecmpyAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对团检记录数据真删除
	 */
	public abstract void deleteByParentDO(EnPeCmpyDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对团检记录数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(EnPeCmpyDO[] mainDos) throws BizException;
}
