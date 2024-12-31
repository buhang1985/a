package iih.pe.phm.peeduplan.i;

import xap.mw.core.data.BizException;
import iih.pe.phm.peeduplan.d.PeEduPlanDO;
import iih.pe.phm.peeduplan.d.PeeduplanAggDO;

/**
* 健康群体教育计划数据维护服务
*/
public interface IPeeduplanCudService {
	/**
	*  健康群体教育计划数据真删除
	*/
    public abstract void delete(PeeduplanAggDO[] aggdos) throws BizException;
    
    /**
	*  健康群体教育计划数据插入保存
	*/
	public abstract PeeduplanAggDO[] insert(PeeduplanAggDO[] aggdos) throws BizException;
	
    /**
	*  健康群体教育计划数据保存
	*/
	public abstract PeeduplanAggDO[] save(PeeduplanAggDO[] aggdos) throws BizException;
	
    /**
	*  健康群体教育计划数据更新
	*/
	public abstract PeeduplanAggDO[] update(PeeduplanAggDO[] aggdos) throws BizException;
	
	/**
	*  健康群体教育计划数据逻辑删除
	*/
	public abstract void logicDelete(PeeduplanAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对健康群体教育计划数据真删除
	 */
	public abstract void deleteByParentDO(PeEduPlanDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对健康群体教育计划数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeEduPlanDO[] mainDos) throws BizException;
}
