package iih.pe.phm.pedietplan.i;

import xap.mw.core.data.BizException;
import iih.pe.phm.pedietplan.d.PeDietPlanDO;
import iih.pe.phm.pedietplan.d.PedietplanAggDO;

/**
* 体检饮食计划数据维护服务
*/
public interface IPedietplanCudService {
	/**
	*  体检饮食计划数据真删除
	*/
    public abstract void delete(PedietplanAggDO[] aggdos) throws BizException;
    
    /**
	*  体检饮食计划数据插入保存
	*/
	public abstract PedietplanAggDO[] insert(PedietplanAggDO[] aggdos) throws BizException;
	
    /**
	*  体检饮食计划数据保存
	*/
	public abstract PedietplanAggDO[] save(PedietplanAggDO[] aggdos) throws BizException;
	
    /**
	*  体检饮食计划数据更新
	*/
	public abstract PedietplanAggDO[] update(PedietplanAggDO[] aggdos) throws BizException;
	
	/**
	*  体检饮食计划数据逻辑删除
	*/
	public abstract void logicDelete(PedietplanAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检饮食计划数据真删除
	 */
	public abstract void deleteByParentDO(PeDietPlanDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检饮食计划数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeDietPlanDO[] mainDos) throws BizException;
}
