package iih.nm.nqm.nqmimprovl.i;

import xap.mw.core.data.BizException;
import iih.nm.nqm.nqmimprovl.d.NqmImprovDO;
import iih.nm.nqm.nqmimprovl.d.NqmimprovlAggDO;

/**
* 持续改进数据维护服务
*/
public interface INqmimprovlCudService {
	/**
	*  持续改进数据真删除
	*/
    public abstract void delete(NqmimprovlAggDO[] aggdos) throws BizException;
    
    /**
	*  持续改进数据插入保存
	*/
	public abstract NqmimprovlAggDO[] insert(NqmimprovlAggDO[] aggdos) throws BizException;
	
    /**
	*  持续改进数据保存
	*/
	public abstract NqmimprovlAggDO[] save(NqmimprovlAggDO[] aggdos) throws BizException;
	
    /**
	*  持续改进数据更新
	*/
	public abstract NqmimprovlAggDO[] update(NqmimprovlAggDO[] aggdos) throws BizException;
	
	/**
	*  持续改进数据逻辑删除
	*/
	public abstract void logicDelete(NqmimprovlAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对持续改进数据真删除
	 */
	public abstract void deleteByParentDO(NqmImprovDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对持续改进数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NqmImprovDO[] mainDos) throws BizException;
}
