package iih.nmr.pkuf.nmrbase.i;

import xap.mw.core.data.BizException;
import iih.nmr.pkuf.nmrbase.d.NmrBaseDO;
import iih.nmr.pkuf.nmrbase.d.NmrbaseAggDO;

/**
* 文书属性信息数据维护服务
*/
public interface INmrbaseCudService {
	/**
	*  文书属性信息数据真删除
	*/
    public abstract void delete(NmrbaseAggDO[] aggdos) throws BizException;
    
    /**
	*  文书属性信息数据插入保存
	*/
	public abstract NmrbaseAggDO[] insert(NmrbaseAggDO[] aggdos) throws BizException;
	
    /**
	*  文书属性信息数据保存
	*/
	public abstract NmrbaseAggDO[] save(NmrbaseAggDO[] aggdos) throws BizException;
	
    /**
	*  文书属性信息数据更新
	*/
	public abstract NmrbaseAggDO[] update(NmrbaseAggDO[] aggdos) throws BizException;
	
	/**
	*  文书属性信息数据逻辑删除
	*/
	public abstract void logicDelete(NmrbaseAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对文书属性信息数据真删除
	 */
	public abstract void deleteByParentDO(NmrBaseDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对文书属性信息数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NmrBaseDO[] mainDos) throws BizException;
}
