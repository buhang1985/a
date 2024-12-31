package iih.nm.nqm.nqmtaskdetdep.i;

import xap.mw.core.data.BizException;
import iih.nm.nqm.nqmtaskdetdep.d.NqmTaskDetDepDO;
import iih.nm.nqm.nqmtaskdetdep.d.NqmtaskdetdepAggDO;

/**
* 质控任务明细科室数据维护服务
*/
public interface INqmtaskdetdepCudService {
	/**
	*  质控任务明细科室数据真删除
	*/
    public abstract void delete(NqmtaskdetdepAggDO[] aggdos) throws BizException;
    
    /**
	*  质控任务明细科室数据插入保存
	*/
	public abstract NqmtaskdetdepAggDO[] insert(NqmtaskdetdepAggDO[] aggdos) throws BizException;
	
    /**
	*  质控任务明细科室数据保存
	*/
	public abstract NqmtaskdetdepAggDO[] save(NqmtaskdetdepAggDO[] aggdos) throws BizException;
	
    /**
	*  质控任务明细科室数据更新
	*/
	public abstract NqmtaskdetdepAggDO[] update(NqmtaskdetdepAggDO[] aggdos) throws BizException;
	
	/**
	*  质控任务明细科室数据逻辑删除
	*/
	public abstract void logicDelete(NqmtaskdetdepAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对质控任务明细科室数据真删除
	 */
	public abstract void deleteByParentDO(NqmTaskDetDepDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对质控任务明细科室数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NqmTaskDetDepDO[] mainDos) throws BizException;
}
