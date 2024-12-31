package iih.pe.phm.pechkplan.i;

import xap.mw.core.data.BizException;
import iih.pe.phm.pechkplan.d.PeChkPlanDO;
import iih.pe.phm.pechkplan.d.PechkplanAggDO;

/**
* 健康体检计划数据维护服务
*/
public interface IPechkplanCudService {
	/**
	*  健康体检计划数据真删除
	*/
    public abstract void delete(PechkplanAggDO[] aggdos) throws BizException;
    
    /**
	*  健康体检计划数据插入保存
	*/
	public abstract PechkplanAggDO[] insert(PechkplanAggDO[] aggdos) throws BizException;
	
    /**
	*  健康体检计划数据保存
	*/
	public abstract PechkplanAggDO[] save(PechkplanAggDO[] aggdos) throws BizException;
	
    /**
	*  健康体检计划数据更新
	*/
	public abstract PechkplanAggDO[] update(PechkplanAggDO[] aggdos) throws BizException;
	
	/**
	*  健康体检计划数据逻辑删除
	*/
	public abstract void logicDelete(PechkplanAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对健康体检计划数据真删除
	 */
	public abstract void deleteByParentDO(PeChkPlanDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对健康体检计划数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeChkPlanDO[] mainDos) throws BizException;
}
