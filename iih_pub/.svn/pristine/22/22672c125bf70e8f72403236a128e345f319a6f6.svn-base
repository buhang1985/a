package iih.bl.prop.blproparoep.i;

import xap.mw.core.data.BizException;
import iih.bl.prop.blproparoep.d.BlPropArOepDO;
import iih.bl.prop.blproparoep.d.BlproparoepAggDO;

/**
* 组件数据维护服务
*/
public interface IBlproparoepCudService {
	/**
	*  组件数据真删除
	*/
    public abstract void delete(BlproparoepAggDO[] aggdos) throws BizException;
    
    /**
	*  组件数据插入保存
	*/
	public abstract BlproparoepAggDO[] insert(BlproparoepAggDO[] aggdos) throws BizException;
	
    /**
	*  组件数据保存
	*/
	public abstract BlproparoepAggDO[] save(BlproparoepAggDO[] aggdos) throws BizException;
	
    /**
	*  组件数据更新
	*/
	public abstract BlproparoepAggDO[] update(BlproparoepAggDO[] aggdos) throws BizException;
	
	/**
	*  组件数据逻辑删除
	*/
	public abstract void logicDelete(BlproparoepAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对组件数据真删除
	 */
	public abstract void deleteByParentDO(BlPropArOepDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对组件数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(BlPropArOepDO[] mainDos) throws BizException;
}
