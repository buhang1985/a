package iih.bl.prop.blproparip.i;

import xap.mw.core.data.BizException;
import iih.bl.prop.blproparip.d.BlPropArIpDO;
import iih.bl.prop.blproparip.d.BlproparipAggDO;

/**
* 组件数据维护服务
*/
public interface IBlproparipCudService {
	/**
	*  组件数据真删除
	*/
    public abstract void delete(BlproparipAggDO[] aggdos) throws BizException;
    
    /**
	*  组件数据插入保存
	*/
	public abstract BlproparipAggDO[] insert(BlproparipAggDO[] aggdos) throws BizException;
	
    /**
	*  组件数据保存
	*/
	public abstract BlproparipAggDO[] save(BlproparipAggDO[] aggdos) throws BizException;
	
    /**
	*  组件数据更新
	*/
	public abstract BlproparipAggDO[] update(BlproparipAggDO[] aggdos) throws BizException;
	
	/**
	*  组件数据逻辑删除
	*/
	public abstract void logicDelete(BlproparipAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对组件数据真删除
	 */
	public abstract void deleteByParentDO(BlPropArIpDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对组件数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(BlPropArIpDO[] mainDos) throws BizException;
}
