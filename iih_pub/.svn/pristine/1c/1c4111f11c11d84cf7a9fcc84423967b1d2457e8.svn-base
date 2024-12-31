package iih.nm.nqm.nqmqcgrp.i;

import xap.mw.core.data.BizException;
import iih.nm.nqm.nqmqcgrp.d.NqmQcgrpDO;
import iih.nm.nqm.nqmqcgrp.d.NqmqcgrpAggDO;

/**
* 质控组数据维护服务
*/
public interface INqmqcgrpCudService {
	/**
	*  质控组数据真删除
	*/
    public abstract void delete(NqmqcgrpAggDO[] aggdos) throws BizException;
    
    /**
	*  质控组数据插入保存
	*/
	public abstract NqmqcgrpAggDO[] insert(NqmqcgrpAggDO[] aggdos) throws BizException;
	
    /**
	*  质控组数据保存
	*/
	public abstract NqmqcgrpAggDO[] save(NqmqcgrpAggDO[] aggdos) throws BizException;
	
    /**
	*  质控组数据更新
	*/
	public abstract NqmqcgrpAggDO[] update(NqmqcgrpAggDO[] aggdos) throws BizException;
	
	/**
	*  质控组数据逻辑删除
	*/
	public abstract void logicDelete(NqmqcgrpAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对质控组数据真删除
	 */
	public abstract void deleteByParentDO(NqmQcgrpDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对质控组数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NqmQcgrpDO[] mainDos) throws BizException;
}
