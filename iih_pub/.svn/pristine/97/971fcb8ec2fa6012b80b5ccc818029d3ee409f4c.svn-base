package iih.bl.inc.blcpnin.i;

import xap.mw.core.data.BizException;
import iih.bl.inc.blcpnin.d.BlCpnInDO;
import iih.bl.inc.blcpnin.d.BlcpninAggDO;

/**
* 组件数据维护服务
*/
public interface IBlcpninCudService {
	/**
	*  组件数据真删除
	*/
    public abstract void delete(BlcpninAggDO[] aggdos) throws BizException;
    
    /**
	*  组件数据插入保存
	*/
	public abstract BlcpninAggDO[] insert(BlcpninAggDO[] aggdos) throws BizException;
	
    /**
	*  组件数据保存
	*/
	public abstract BlcpninAggDO[] save(BlcpninAggDO[] aggdos) throws BizException;
	
    /**
	*  组件数据更新
	*/
	public abstract BlcpninAggDO[] update(BlcpninAggDO[] aggdos) throws BizException;
	
	/**
	*  组件数据逻辑删除
	*/
	public abstract void logicDelete(BlcpninAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对组件数据真删除
	 */
	public abstract void deleteByParentDO(BlCpnInDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对组件数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(BlCpnInDO[] mainDos) throws BizException;
}
