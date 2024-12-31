package iih.nm.nhr.nmnhrsigrp.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.nmnhrsigrp.d.NhrSigrpDO;
import iih.nm.nhr.nmnhrsigrp.d.NmnhrsigrpAggDO;

/**
* 排班分组数据维护服务
*/
public interface INmnhrsigrpCudService {
	/**
	*  排班分组数据真删除
	*/
    public abstract void delete(NmnhrsigrpAggDO[] aggdos) throws BizException;
    
    /**
	*  排班分组数据插入保存
	*/
	public abstract NmnhrsigrpAggDO[] insert(NmnhrsigrpAggDO[] aggdos) throws BizException;
	
    /**
	*  排班分组数据保存
	*/
	public abstract NmnhrsigrpAggDO[] save(NmnhrsigrpAggDO[] aggdos) throws BizException;
	
    /**
	*  排班分组数据更新
	*/
	public abstract NmnhrsigrpAggDO[] update(NmnhrsigrpAggDO[] aggdos) throws BizException;
	
	/**
	*  排班分组数据逻辑删除
	*/
	public abstract void logicDelete(NmnhrsigrpAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对排班分组数据真删除
	 */
	public abstract void deleteByParentDO(NhrSigrpDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对排班分组数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NhrSigrpDO[] mainDos) throws BizException;
}
