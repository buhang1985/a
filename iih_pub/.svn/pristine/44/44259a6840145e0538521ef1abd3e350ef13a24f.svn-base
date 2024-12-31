package iih.nm.nit.nitpracgrp.i;

import xap.mw.core.data.BizException;
import iih.nm.nit.nitpracgrp.d.NitPracgrpDO;
import iih.nm.nit.nitpracgrp.d.NitpracgrpAggDO;

/**
* 实习小组数据维护服务
*/
public interface INitpracgrpCudService {
	/**
	*  实习小组数据真删除
	*/
    public abstract void delete(NitpracgrpAggDO[] aggdos) throws BizException;
    
    /**
	*  实习小组数据插入保存
	*/
	public abstract NitpracgrpAggDO[] insert(NitpracgrpAggDO[] aggdos) throws BizException;
	
    /**
	*  实习小组数据保存
	*/
	public abstract NitpracgrpAggDO[] save(NitpracgrpAggDO[] aggdos) throws BizException;
	
    /**
	*  实习小组数据更新
	*/
	public abstract NitpracgrpAggDO[] update(NitpracgrpAggDO[] aggdos) throws BizException;
	
	/**
	*  实习小组数据逻辑删除
	*/
	public abstract void logicDelete(NitpracgrpAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对实习小组数据真删除
	 */
	public abstract void deleteByParentDO(NitPracgrpDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对实习小组数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NitPracgrpDO[] mainDos) throws BizException;
}
