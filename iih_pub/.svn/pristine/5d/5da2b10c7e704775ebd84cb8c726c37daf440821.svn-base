package iih.pe.phm.penutrition.i;

import xap.mw.core.data.BizException;
import iih.pe.phm.penutrition.d.PeNutritionDO;
import iih.pe.phm.penutrition.d.PenutritionAggDO;

/**
* 健康营养评估结果数据维护服务
*/
public interface IPenutritionCudService {
	/**
	*  健康营养评估结果数据真删除
	*/
    public abstract void delete(PenutritionAggDO[] aggdos) throws BizException;
    
    /**
	*  健康营养评估结果数据插入保存
	*/
	public abstract PenutritionAggDO[] insert(PenutritionAggDO[] aggdos) throws BizException;
	
    /**
	*  健康营养评估结果数据保存
	*/
	public abstract PenutritionAggDO[] save(PenutritionAggDO[] aggdos) throws BizException;
	
    /**
	*  健康营养评估结果数据更新
	*/
	public abstract PenutritionAggDO[] update(PenutritionAggDO[] aggdos) throws BizException;
	
	/**
	*  健康营养评估结果数据逻辑删除
	*/
	public abstract void logicDelete(PenutritionAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对健康营养评估结果数据真删除
	 */
	public abstract void deleteByParentDO(PeNutritionDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对健康营养评估结果数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeNutritionDO[] mainDos) throws BizException;
}
