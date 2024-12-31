package iih.nm.nqm.nmnqmtaskdep.i;

import xap.mw.core.data.BizException;
import iih.nm.nqm.nmnqmtaskdep.d.NmNqmTaskDepDO;
import iih.nm.nqm.nmnqmtaskdep.d.NmnqmtaskdepAggDO;

/**
* 护理管理_检查任务明细数据维护服务
*/
public interface INmnqmtaskdepCudService {
	/**
	*  护理管理_检查任务明细数据真删除
	*/
    public abstract void delete(NmnqmtaskdepAggDO[] aggdos) throws BizException;
    
    /**
	*  护理管理_检查任务明细数据插入保存
	*/
	public abstract NmnqmtaskdepAggDO[] insert(NmnqmtaskdepAggDO[] aggdos) throws BizException;
	
    /**
	*  护理管理_检查任务明细数据保存
	*/
	public abstract NmnqmtaskdepAggDO[] save(NmnqmtaskdepAggDO[] aggdos) throws BizException;
	
    /**
	*  护理管理_检查任务明细数据更新
	*/
	public abstract NmnqmtaskdepAggDO[] update(NmnqmtaskdepAggDO[] aggdos) throws BizException;
	
	/**
	*  护理管理_检查任务明细数据逻辑删除
	*/
	public abstract void logicDelete(NmnqmtaskdepAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对护理管理_检查任务明细数据真删除
	 */
	public abstract void deleteByParentDO(NmNqmTaskDepDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对护理管理_检查任务明细数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NmNqmTaskDepDO[] mainDos) throws BizException;
}
