package iih.nm.nqm.nqmchk.i;

import xap.mw.core.data.BizException;
import iih.nm.nqm.nqmchk.d.NqmChkDO;
import iih.nm.nqm.nqmchk.d.NqmchkAggDO;

/**
* 质量检查数据维护服务
*/
public interface INqmchkCudService {
	/**
	*  质量检查数据真删除
	*/
    public abstract void delete(NqmchkAggDO[] aggdos) throws BizException;
    
    /**
	*  质量检查数据插入保存
	*/
	public abstract NqmchkAggDO[] insert(NqmchkAggDO[] aggdos) throws BizException;
	
    /**
	*  质量检查数据保存
	*/
	public abstract NqmchkAggDO[] save(NqmchkAggDO[] aggdos) throws BizException;
	
    /**
	*  质量检查数据更新
	*/
	public abstract NqmchkAggDO[] update(NqmchkAggDO[] aggdos) throws BizException;
	
	/**
	*  质量检查数据逻辑删除
	*/
	public abstract void logicDelete(NqmchkAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对质量检查数据真删除
	 */
	public abstract void deleteByParentDO(NqmChkDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对质量检查数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NqmChkDO[] mainDos) throws BizException;
}
