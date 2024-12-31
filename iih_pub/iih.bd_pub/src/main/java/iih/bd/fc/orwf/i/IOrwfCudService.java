package iih.bd.fc.orwf.i;

import xap.mw.core.data.BizException;
import iih.bd.fc.orwf.d.OrWfCfgDO;
import iih.bd.fc.orwf.d.OrwfAggDO;

/**
* 医嘱流向数据维护服务
*/
public interface IOrwfCudService {
	/**
	*  医嘱流向数据真删除
	*/
    public abstract void delete(OrwfAggDO[] aggdos) throws BizException;
    
    /**
	*  医嘱流向数据插入保存
	*/
	public abstract OrwfAggDO[] insert(OrwfAggDO[] aggdos) throws BizException;
	
    /**
	*  医嘱流向数据保存
	*/
	public abstract OrwfAggDO[] save(OrwfAggDO[] aggdos) throws BizException;
	
    /**
	*  医嘱流向数据更新
	*/
	public abstract OrwfAggDO[] update(OrwfAggDO[] aggdos) throws BizException;
	
	/**
	*  医嘱流向数据逻辑删除
	*/
	public abstract void logicDelete(OrwfAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对医嘱流向数据真删除
	 */
	public abstract void deleteByParentDO(OrWfCfgDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对医嘱流向数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(OrWfCfgDO[] mainDos) throws BizException;
}
