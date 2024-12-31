package iih.sc.sch.scsch.i;

import xap.mw.core.data.BizException;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.d.ScschAggDO;

/**
* 计划排班_排班数据维护服务
*/
public interface IScschCudService {
	/**
	*  计划排班_排班数据真删除
	*/
    public abstract void delete(ScschAggDO[] aggdos) throws BizException;
    
    /**
	*  计划排班_排班数据插入保存
	*/
	public abstract ScschAggDO[] insert(ScschAggDO[] aggdos) throws BizException;
	
    /**
	*  计划排班_排班数据保存
	*/
	public abstract ScschAggDO[] save(ScschAggDO[] aggdos) throws BizException;
	
    /**
	*  计划排班_排班数据更新
	*/
	public abstract ScschAggDO[] update(ScschAggDO[] aggdos) throws BizException;
	
	/**
	*  计划排班_排班数据逻辑删除
	*/
	public abstract void logicDelete(ScschAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对计划排班_排班数据真删除
	 */
	public abstract void deleteByParentDO(ScSchDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对计划排班_排班数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(ScSchDO[] mainDos) throws BizException;
}
