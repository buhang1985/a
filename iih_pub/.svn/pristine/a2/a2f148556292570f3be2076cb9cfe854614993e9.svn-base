package iih.nm.nit.nmnitgrp.i;

import xap.mw.core.data.BizException;
import iih.nm.nit.nmnitgrp.d.NmNitGrpDO;
import iih.nm.nit.nmnitgrp.d.NmnitgrpAggDO;

/**
* 护理管理_实习小组数据维护服务
*/
public interface INmnitgrpCudService {
	/**
	*  护理管理_实习小组数据真删除
	*/
    public abstract void delete(NmnitgrpAggDO[] aggdos) throws BizException;
    
    /**
	*  护理管理_实习小组数据插入保存
	*/
	public abstract NmnitgrpAggDO[] insert(NmnitgrpAggDO[] aggdos) throws BizException;
	
    /**
	*  护理管理_实习小组数据保存
	*/
	public abstract NmnitgrpAggDO[] save(NmnitgrpAggDO[] aggdos) throws BizException;
	
    /**
	*  护理管理_实习小组数据更新
	*/
	public abstract NmnitgrpAggDO[] update(NmnitgrpAggDO[] aggdos) throws BizException;
	
	/**
	*  护理管理_实习小组数据逻辑删除
	*/
	public abstract void logicDelete(NmnitgrpAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对护理管理_实习小组数据真删除
	 */
	public abstract void deleteByParentDO(NmNitGrpDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对护理管理_实习小组数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NmNitGrpDO[] mainDos) throws BizException;
}
