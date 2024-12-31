package iih.bd.res.bizgrp.i;

import xap.mw.core.data.BizException;
import iih.bd.res.bizgrp.d.BizGroupDO;
import iih.bd.res.bizgrp.d.BizgrpAggDO;

/**
* 业务组数据维护服务
*/
public interface IBizgrpCudService {
	/**
	*  业务组数据真删除
	*/
    public abstract void delete(BizgrpAggDO[] aggdos) throws BizException;
    
    /**
	*  业务组数据插入保存
	*/
	public abstract BizgrpAggDO[] insert(BizgrpAggDO[] aggdos) throws BizException;
	
    /**
	*  业务组数据保存
	*/
	public abstract BizgrpAggDO[] save(BizgrpAggDO[] aggdos) throws BizException;
	
    /**
	*  业务组数据更新
	*/
	public abstract BizgrpAggDO[] update(BizgrpAggDO[] aggdos) throws BizException;
	
	/**
	*  业务组数据逻辑删除
	*/
	public abstract void logicDelete(BizgrpAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对业务组数据真删除
	 */
	public abstract void deleteByParentDO(BizGroupDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对业务组数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(BizGroupDO[] mainDos) throws BizException;
}
