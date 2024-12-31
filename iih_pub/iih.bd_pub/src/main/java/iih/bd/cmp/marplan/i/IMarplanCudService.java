package iih.bd.cmp.marplan.i;

import xap.mw.core.data.BizException;
import iih.bd.cmp.marplan.d.BdCmpMarPlanDO;
import iih.bd.cmp.marplan.d.MarplanAggDO;

/**
* 营销方案数据维护服务
*/
public interface IMarplanCudService {
	/**
	*  营销方案数据真删除
	*/
    public abstract void delete(MarplanAggDO[] aggdos) throws BizException;
    
    /**
	*  营销方案数据插入保存
	*/
	public abstract MarplanAggDO[] insert(MarplanAggDO[] aggdos) throws BizException;
	
    /**
	*  营销方案数据保存
	*/
	public abstract MarplanAggDO[] save(MarplanAggDO[] aggdos) throws BizException;
	
    /**
	*  营销方案数据更新
	*/
	public abstract MarplanAggDO[] update(MarplanAggDO[] aggdos) throws BizException;
	
	/**
	*  营销方案数据逻辑删除
	*/
	public abstract void logicDelete(MarplanAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对营销方案数据真删除
	 */
	public abstract void deleteByParentDO(BdCmpMarPlanDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对营销方案数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(BdCmpMarPlanDO[] mainDos) throws BizException;
}
