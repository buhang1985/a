package iih.mm.pl.traprequest.i;

import xap.mw.core.data.BizException;
import iih.mm.pl.traprequest.d.TrapReqOrderDO;
import iih.mm.pl.traprequest.d.TraprequestAggDO;

/**
* 调拨申请数据维护服务
*/
public interface ITraprequestCudService {
	/**
	*  调拨申请数据真删除
	*/
    public abstract void delete(TraprequestAggDO[] aggdos) throws BizException;
    
    /**
	*  调拨申请数据插入保存
	*/
	public abstract TraprequestAggDO[] insert(TraprequestAggDO[] aggdos) throws BizException;
	
    /**
	*  调拨申请数据保存
	*/
	public abstract TraprequestAggDO[] save(TraprequestAggDO[] aggdos) throws BizException;
	
    /**
	*  调拨申请数据更新
	*/
	public abstract TraprequestAggDO[] update(TraprequestAggDO[] aggdos) throws BizException;
	
	/**
	*  调拨申请数据逻辑删除
	*/
	public abstract void logicDelete(TraprequestAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对调拨申请数据真删除
	 */
	public abstract void deleteByParentDO(TrapReqOrderDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对调拨申请数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(TrapReqOrderDO[] mainDos) throws BizException;
}
