package iih.nm.nqm.nmnqmcs.i;

import xap.mw.core.data.BizException;
import iih.nm.nqm.nmnqmcs.d.NmNqmCsDO;
import iih.nm.nqm.nmnqmcs.d.NmnqmcsAggDO;

/**
* 检查标准数据维护服务
*/
public interface INmnqmcsCudService {
	/**
	*  检查标准数据真删除
	*/
    public abstract void delete(NmnqmcsAggDO[] aggdos) throws BizException;
    
    /**
	*  检查标准数据插入保存
	*/
	public abstract NmnqmcsAggDO[] insert(NmnqmcsAggDO[] aggdos) throws BizException;
	
    /**
	*  检查标准数据保存
	*/
	public abstract NmnqmcsAggDO[] save(NmnqmcsAggDO[] aggdos) throws BizException;
	
    /**
	*  检查标准数据更新
	*/
	public abstract NmnqmcsAggDO[] update(NmnqmcsAggDO[] aggdos) throws BizException;
	
	/**
	*  检查标准数据逻辑删除
	*/
	public abstract void logicDelete(NmnqmcsAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对检查标准数据真删除
	 */
	public abstract void deleteByParentDO(NmNqmCsDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对检查标准数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NmNqmCsDO[] mainDos) throws BizException;
}
