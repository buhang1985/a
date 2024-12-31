package iih.bd.fc.orpltp.i;

import xap.mw.core.data.BizException;
import iih.bd.fc.orpltp.d.OrpltpDO;
import iih.bd.fc.orpltp.d.OrpltpAggDO;

/**
* 医嘱执行计划状态数据维护服务
*/
public interface IOrpltpCudService {
	/**
	*  医嘱执行计划状态数据真删除
	*/
    public abstract void delete(OrpltpAggDO[] aggdos) throws BizException;
    
    /**
	*  医嘱执行计划状态数据插入保存
	*/
	public abstract OrpltpAggDO[] insert(OrpltpAggDO[] aggdos) throws BizException;
	
    /**
	*  医嘱执行计划状态数据保存
	*/
	public abstract OrpltpAggDO[] save(OrpltpAggDO[] aggdos) throws BizException;
	
    /**
	*  医嘱执行计划状态数据更新
	*/
	public abstract OrpltpAggDO[] update(OrpltpAggDO[] aggdos) throws BizException;
	
	/**
	*  医嘱执行计划状态数据逻辑删除
	*/
	public abstract void logicDelete(OrpltpAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对医嘱执行计划状态数据真删除
	 */
	public abstract void deleteByParentDO(OrpltpDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对医嘱执行计划状态数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(OrpltpDO[] mainDos) throws BizException;
}
