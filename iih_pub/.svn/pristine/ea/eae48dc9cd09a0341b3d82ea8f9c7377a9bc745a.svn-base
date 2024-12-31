package iih.bd.res.depcont.i;

import xap.mw.core.data.BizException;
import iih.bd.res.depcont.d.DepContDO;
import iih.bd.res.depcont.d.DepcontAggDO;

/**
* 医技科室对照数据维护服务
*/
public interface IDepcontCudService {
	/**
	*  医技科室对照数据真删除
	*/
    public abstract void delete(DepcontAggDO[] aggdos) throws BizException;
    
    /**
	*  医技科室对照数据插入保存
	*/
	public abstract DepcontAggDO[] insert(DepcontAggDO[] aggdos) throws BizException;
	
    /**
	*  医技科室对照数据保存
	*/
	public abstract DepcontAggDO[] save(DepcontAggDO[] aggdos) throws BizException;
	
    /**
	*  医技科室对照数据更新
	*/
	public abstract DepcontAggDO[] update(DepcontAggDO[] aggdos) throws BizException;
	
	/**
	*  医技科室对照数据逻辑删除
	*/
	public abstract void logicDelete(DepcontAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对医技科室对照数据真删除
	 */
	public abstract void deleteByParentDO(DepContDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对医技科室对照数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(DepContDO[] mainDos) throws BizException;
}
