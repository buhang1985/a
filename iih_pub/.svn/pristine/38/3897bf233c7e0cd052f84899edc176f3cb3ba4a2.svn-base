package iih.nm.nhr.nmnurgrp.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.nmnurgrp.d.NmNurGrpDO;
import iih.nm.nhr.nmnurgrp.d.NmnurgrpAggDO;

/**
* 护理管理人员小组数据维护服务
*/
public interface INmnurgrpCudService {
	/**
	*  护理管理人员小组数据真删除
	*/
    public abstract void delete(NmnurgrpAggDO[] aggdos) throws BizException;
    
    /**
	*  护理管理人员小组数据插入保存
	*/
	public abstract NmnurgrpAggDO[] insert(NmnurgrpAggDO[] aggdos) throws BizException;
	
    /**
	*  护理管理人员小组数据保存
	*/
	public abstract NmnurgrpAggDO[] save(NmnurgrpAggDO[] aggdos) throws BizException;
	
    /**
	*  护理管理人员小组数据更新
	*/
	public abstract NmnurgrpAggDO[] update(NmnurgrpAggDO[] aggdos) throws BizException;
	
	/**
	*  护理管理人员小组数据逻辑删除
	*/
	public abstract void logicDelete(NmnurgrpAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对护理管理人员小组数据真删除
	 */
	public abstract void deleteByParentDO(NmNurGrpDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对护理管理人员小组数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NmNurGrpDO[] mainDos) throws BizException;
}
