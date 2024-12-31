package iih.pe.pqn.peevalnutrition.i;

import xap.mw.core.data.BizException;
import iih.pe.pqn.peevalnutrition.d.PeEvalNutritionDO;
import iih.pe.pqn.peevalnutrition.d.PeevalnutritionAggDO;

/**
* 健康评估-营养评估定义数据维护服务
*/
public interface IPeevalnutritionCudService {
	/**
	*  健康评估-营养评估定义数据真删除
	*/
    public abstract void delete(PeevalnutritionAggDO[] aggdos) throws BizException;
    
    /**
	*  健康评估-营养评估定义数据插入保存
	*/
	public abstract PeevalnutritionAggDO[] insert(PeevalnutritionAggDO[] aggdos) throws BizException;
	
    /**
	*  健康评估-营养评估定义数据保存
	*/
	public abstract PeevalnutritionAggDO[] save(PeevalnutritionAggDO[] aggdos) throws BizException;
	
    /**
	*  健康评估-营养评估定义数据更新
	*/
	public abstract PeevalnutritionAggDO[] update(PeevalnutritionAggDO[] aggdos) throws BizException;
	
	/**
	*  健康评估-营养评估定义数据逻辑删除
	*/
	public abstract void logicDelete(PeevalnutritionAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对健康评估-营养评估定义数据真删除
	 */
	public abstract void deleteByParentDO(PeEvalNutritionDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对健康评估-营养评估定义数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeEvalNutritionDO[] mainDos) throws BizException;
}
