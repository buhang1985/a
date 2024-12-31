package iih.nm.nqm.nqmcssty.i;

import xap.mw.core.data.BizException;
import iih.nm.nqm.nqmcssty.d.NqmCsStyDO;
import iih.nm.nqm.nqmcssty.d.NqmcsstyAggDO;

/**
* 质量检查表样式数据维护服务
*/
public interface INqmcsstyCudService {
	/**
	*  质量检查表样式数据真删除
	*/
    public abstract void delete(NqmcsstyAggDO[] aggdos) throws BizException;
    
    /**
	*  质量检查表样式数据插入保存
	*/
	public abstract NqmcsstyAggDO[] insert(NqmcsstyAggDO[] aggdos) throws BizException;
	
    /**
	*  质量检查表样式数据保存
	*/
	public abstract NqmcsstyAggDO[] save(NqmcsstyAggDO[] aggdos) throws BizException;
	
    /**
	*  质量检查表样式数据更新
	*/
	public abstract NqmcsstyAggDO[] update(NqmcsstyAggDO[] aggdos) throws BizException;
	
	/**
	*  质量检查表样式数据逻辑删除
	*/
	public abstract void logicDelete(NqmcsstyAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对质量检查表样式数据真删除
	 */
	public abstract void deleteByParentDO(NqmCsStyDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对质量检查表样式数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NqmCsStyDO[] mainDos) throws BizException;
}
