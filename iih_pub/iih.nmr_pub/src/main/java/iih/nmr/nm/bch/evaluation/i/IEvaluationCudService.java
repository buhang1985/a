package iih.nmr.nm.bch.evaluation.i;

import xap.mw.core.data.BizException;
import iih.nmr.nm.bch.evaluation.d.EvaluatDO;
import iih.nmr.nm.bch.evaluation.d.EvaluationAggDO;

/**
* 患者和家属健康教育计划表数据维护服务
*/
public interface IEvaluationCudService {
	/**
	*  患者和家属健康教育计划表数据真删除
	*/
    public abstract void delete(EvaluationAggDO[] aggdos) throws BizException;
    
    /**
	*  患者和家属健康教育计划表数据插入保存
	*/
	public abstract EvaluationAggDO[] insert(EvaluationAggDO[] aggdos) throws BizException;
	
    /**
	*  患者和家属健康教育计划表数据保存
	*/
	public abstract EvaluationAggDO[] save(EvaluationAggDO[] aggdos) throws BizException;
	
    /**
	*  患者和家属健康教育计划表数据更新
	*/
	public abstract EvaluationAggDO[] update(EvaluationAggDO[] aggdos) throws BizException;
	
	/**
	*  患者和家属健康教育计划表数据逻辑删除
	*/
	public abstract void logicDelete(EvaluationAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对患者和家属健康教育计划表数据真删除
	 */
	public abstract void deleteByParentDO(EvaluatDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对患者和家属健康教育计划表数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(EvaluatDO[] mainDos) throws BizException;
}
