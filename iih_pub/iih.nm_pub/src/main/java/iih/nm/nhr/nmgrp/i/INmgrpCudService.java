package iih.nm.nhr.nmgrp.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.nmgrp.d.NmGrpDO;
import iih.nm.nhr.nmgrp.d.NmgrpAggDO;

/**
* 护理小组数据维护服务
*/
public interface INmgrpCudService {
	/**
	*  护理小组数据真删除
	*/
    public abstract void delete(NmgrpAggDO[] aggdos) throws BizException;
    
    /**
	*  护理小组数据插入保存
	*/
	public abstract NmgrpAggDO[] insert(NmgrpAggDO[] aggdos) throws BizException;
	
    /**
	*  护理小组数据保存
	*/
	public abstract NmgrpAggDO[] save(NmgrpAggDO[] aggdos) throws BizException;
	
    /**
	*  护理小组数据更新
	*/
	public abstract NmgrpAggDO[] update(NmgrpAggDO[] aggdos) throws BizException;
	
	/**
	*  护理小组数据逻辑删除
	*/
	public abstract void logicDelete(NmgrpAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对护理小组数据真删除
	 */
	public abstract void deleteByParentDO(NmGrpDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对护理小组数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NmGrpDO[] mainDos) throws BizException;
}
