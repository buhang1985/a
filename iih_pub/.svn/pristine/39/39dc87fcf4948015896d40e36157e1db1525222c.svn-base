package iih.nmr.pkuf.heduplan.i;

import xap.mw.core.data.BizException;
import iih.nmr.pkuf.heduplan.d.HeduPlanDO;
import iih.nmr.pkuf.heduplan.d.HeduplanAggDO;

/**
* 健康教育计划数据维护服务
*/
public interface IHeduplanCudService {
	/**
	*  健康教育计划数据真删除
	*/
    public abstract void delete(HeduplanAggDO[] aggdos) throws BizException;
    
    /**
	*  健康教育计划数据插入保存
	*/
	public abstract HeduplanAggDO[] insert(HeduplanAggDO[] aggdos) throws BizException;
	
    /**
	*  健康教育计划数据保存
	*/
	public abstract HeduplanAggDO[] save(HeduplanAggDO[] aggdos) throws BizException;
	
    /**
	*  健康教育计划数据更新
	*/
	public abstract HeduplanAggDO[] update(HeduplanAggDO[] aggdos) throws BizException;
	
	/**
	*  健康教育计划数据逻辑删除
	*/
	public abstract void logicDelete(HeduplanAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对健康教育计划数据真删除
	 */
	public abstract void deleteByParentDO(HeduPlanDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对健康教育计划数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(HeduPlanDO[] mainDos) throws BizException;
}
