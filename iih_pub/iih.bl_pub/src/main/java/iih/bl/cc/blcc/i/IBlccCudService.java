package iih.bl.cc.blcc.i;

import xap.mw.core.data.BizException;
import iih.bl.cc.blcc.d.BlCcDO;
import iih.bl.cc.blcc.d.BlccAggDO;

/**
* 组件数据维护服务
*/
public interface IBlccCudService {
	/**
	*  组件数据真删除
	*/
    public abstract void delete(BlccAggDO[] aggdos) throws BizException;
    
    /**
	*  组件数据插入保存
	*/
	public abstract BlccAggDO[] insert(BlccAggDO[] aggdos) throws BizException;
	
    /**
	*  组件数据保存
	*/
	public abstract BlccAggDO[] save(BlccAggDO[] aggdos) throws BizException;
	
    /**
	*  组件数据更新
	*/
	public abstract BlccAggDO[] update(BlccAggDO[] aggdos) throws BizException;
	
	/**
	*  组件数据逻辑删除
	*/
	public abstract void logicDelete(BlccAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对组件数据真删除
	 */
	public abstract void deleteByParentDO(BlCcDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对组件数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(BlCcDO[] mainDos) throws BizException;
}
