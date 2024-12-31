package iih.pe.pbd.pewfroute.i;

import xap.mw.core.data.BizException;
import iih.pe.pbd.pewfroute.d.PeWfRouteDO;
import iih.pe.pbd.pewfroute.d.PewfrouteAggDO;

/**
* 体检流程路线定义数据维护服务
*/
public interface IPewfrouteCudService {
	/**
	*  体检流程路线定义数据真删除
	*/
    public abstract void delete(PewfrouteAggDO[] aggdos) throws BizException;
    
    /**
	*  体检流程路线定义数据插入保存
	*/
	public abstract PewfrouteAggDO[] insert(PewfrouteAggDO[] aggdos) throws BizException;
	
    /**
	*  体检流程路线定义数据保存
	*/
	public abstract PewfrouteAggDO[] save(PewfrouteAggDO[] aggdos) throws BizException;
	
    /**
	*  体检流程路线定义数据更新
	*/
	public abstract PewfrouteAggDO[] update(PewfrouteAggDO[] aggdos) throws BizException;
	
	/**
	*  体检流程路线定义数据逻辑删除
	*/
	public abstract void logicDelete(PewfrouteAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检流程路线定义数据真删除
	 */
	public abstract void deleteByParentDO(PeWfRouteDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检流程路线定义数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeWfRouteDO[] mainDos) throws BizException;
}
