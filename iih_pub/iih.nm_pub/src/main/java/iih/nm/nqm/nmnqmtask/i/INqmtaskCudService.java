package iih.nm.nqm.nmnqmtask.i;

import xap.mw.core.data.BizException;
import iih.nm.nqm.nmnqmtask.d.NmNqmTaskDO;
import iih.nm.nqm.nmnqmtask.d.NqmtaskAggDO;

/**
* 护理管理_检查任务数据维护服务
*/
public interface INqmtaskCudService {
	/**
	*  护理管理_检查任务数据真删除
	*/
    public abstract void delete(NqmtaskAggDO[] aggdos) throws BizException;
    
    /**
	*  护理管理_检查任务数据插入保存
	*/
	public abstract NqmtaskAggDO[] insert(NqmtaskAggDO[] aggdos) throws BizException;
	
    /**
	*  护理管理_检查任务数据保存
	*/
	public abstract NqmtaskAggDO[] save(NqmtaskAggDO[] aggdos) throws BizException;
	
    /**
	*  护理管理_检查任务数据更新
	*/
	public abstract NqmtaskAggDO[] update(NqmtaskAggDO[] aggdos) throws BizException;
	
	/**
	*  护理管理_检查任务数据逻辑删除
	*/
	public abstract void logicDelete(NqmtaskAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对护理管理_检查任务数据真删除
	 */
	public abstract void deleteByParentDO(NmNqmTaskDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对护理管理_检查任务数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NmNqmTaskDO[] mainDos) throws BizException;
}
