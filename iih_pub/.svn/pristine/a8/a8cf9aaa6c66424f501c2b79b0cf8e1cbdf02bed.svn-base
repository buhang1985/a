package iih.bl.cg.blcgoep.i;

import xap.mw.core.data.BizException;
import iih.bl.cg.blcgoep.d.BlCgOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;

/**
* 组件数据维护服务
*/
public interface IBlcgoepCudService {
	/**
	*  组件数据真删除
	*/
    public abstract void delete(BlcgoepAggDO[] aggdos) throws BizException;
    
    /**
	*  组件数据插入保存
	*/
	public abstract BlcgoepAggDO[] insert(BlcgoepAggDO[] aggdos) throws BizException;
	
    /**
	*  组件数据保存
	*/
	public abstract BlcgoepAggDO[] save(BlcgoepAggDO[] aggdos) throws BizException;
	
    /**
	*  组件数据更新
	*/
	public abstract BlcgoepAggDO[] update(BlcgoepAggDO[] aggdos) throws BizException;
	
	/**
	*  组件数据逻辑删除
	*/
	public abstract void logicDelete(BlcgoepAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对组件数据真删除
	 */
	public abstract void deleteByParentDO(BlCgOepDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对组件数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(BlCgOepDO[] mainDos) throws BizException;
}
