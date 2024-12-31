package iih.bd.fc.orpltpmatch.i;

import xap.mw.core.data.BizException;
import iih.bd.fc.orpltpmatch.d.OrpltpMatchDO;
import iih.bd.fc.orpltpmatch.d.OrpltpmatchAggDO;

/**
* 医嘱闭环匹配数据维护服务
*/
public interface IOrpltpmatchCudService {
	/**
	*  医嘱闭环匹配数据真删除
	*/
    public abstract void delete(OrpltpmatchAggDO[] aggdos) throws BizException;
    
    /**
	*  医嘱闭环匹配数据插入保存
	*/
	public abstract OrpltpmatchAggDO[] insert(OrpltpmatchAggDO[] aggdos) throws BizException;
	
    /**
	*  医嘱闭环匹配数据保存
	*/
	public abstract OrpltpmatchAggDO[] save(OrpltpmatchAggDO[] aggdos) throws BizException;
	
    /**
	*  医嘱闭环匹配数据更新
	*/
	public abstract OrpltpmatchAggDO[] update(OrpltpmatchAggDO[] aggdos) throws BizException;
	
	/**
	*  医嘱闭环匹配数据逻辑删除
	*/
	public abstract void logicDelete(OrpltpmatchAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对医嘱闭环匹配数据真删除
	 */
	public abstract void deleteByParentDO(OrpltpMatchDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对医嘱闭环匹配数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(OrpltpMatchDO[] mainDos) throws BizException;
}
