package iih.pe.phm.peexerciseplan.i;

import xap.mw.core.data.BizException;
import iih.pe.phm.peexerciseplan.d.PeExercisePlanDO;
import iih.pe.phm.peexerciseplan.d.PeexerciseplanAggDO;

/**
* 体检运动计划数据维护服务
*/
public interface IPeexerciseplanCudService {
	/**
	*  体检运动计划数据真删除
	*/
    public abstract void delete(PeexerciseplanAggDO[] aggdos) throws BizException;
    
    /**
	*  体检运动计划数据插入保存
	*/
	public abstract PeexerciseplanAggDO[] insert(PeexerciseplanAggDO[] aggdos) throws BizException;
	
    /**
	*  体检运动计划数据保存
	*/
	public abstract PeexerciseplanAggDO[] save(PeexerciseplanAggDO[] aggdos) throws BizException;
	
    /**
	*  体检运动计划数据更新
	*/
	public abstract PeexerciseplanAggDO[] update(PeexerciseplanAggDO[] aggdos) throws BizException;
	
	/**
	*  体检运动计划数据逻辑删除
	*/
	public abstract void logicDelete(PeexerciseplanAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检运动计划数据真删除
	 */
	public abstract void deleteByParentDO(PeExercisePlanDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检运动计划数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeExercisePlanDO[] mainDos) throws BizException;
}
