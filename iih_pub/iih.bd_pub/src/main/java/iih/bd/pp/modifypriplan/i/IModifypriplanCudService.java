package iih.bd.pp.modifypriplan.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.modifypriplan.d.ModifyPriPlanDO;
import iih.bd.pp.modifypriplan.d.ModifypriplanAggDO;

/**
* 调价计划数据维护服务
*/
public interface IModifypriplanCudService {
	/**
	*  调价计划数据真删除
	*/
    public abstract void delete(ModifypriplanAggDO[] aggdos) throws BizException;
    
    /**
	*  调价计划数据插入保存
	*/
	public abstract ModifypriplanAggDO[] insert(ModifypriplanAggDO[] aggdos) throws BizException;
	
    /**
	*  调价计划数据保存
	*/
	public abstract ModifypriplanAggDO[] save(ModifypriplanAggDO[] aggdos) throws BizException;
	
    /**
	*  调价计划数据更新
	*/
	public abstract ModifypriplanAggDO[] update(ModifypriplanAggDO[] aggdos) throws BizException;
	
	/**
	*  调价计划数据逻辑删除
	*/
	public abstract void logicDelete(ModifypriplanAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对调价计划数据真删除
	 */
	public abstract void deleteByParentDO(ModifyPriPlanDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对调价计划数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(ModifyPriPlanDO[] mainDos) throws BizException;
}
