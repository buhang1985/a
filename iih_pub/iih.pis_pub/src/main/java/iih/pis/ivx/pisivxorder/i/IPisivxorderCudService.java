package iih.pis.ivx.pisivxorder.i;

import xap.mw.core.data.BizException;
import iih.pis.ivx.pisivxorder.d.PisIvxOrderDO;
import iih.pis.ivx.pisivxorder.d.PisivxorderAggDO;

/**
* 微信处方订单数据维护服务
*/
public interface IPisivxorderCudService {
	/**
	*  微信处方订单数据真删除
	*/
    public abstract void delete(PisivxorderAggDO[] aggdos) throws BizException;
    
    /**
	*  微信处方订单数据插入保存
	*/
	public abstract PisivxorderAggDO[] insert(PisivxorderAggDO[] aggdos) throws BizException;
	
    /**
	*  微信处方订单数据保存
	*/
	public abstract PisivxorderAggDO[] save(PisivxorderAggDO[] aggdos) throws BizException;
	
    /**
	*  微信处方订单数据更新
	*/
	public abstract PisivxorderAggDO[] update(PisivxorderAggDO[] aggdos) throws BizException;
	
	/**
	*  微信处方订单数据逻辑删除
	*/
	public abstract void logicDelete(PisivxorderAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对微信处方订单数据真删除
	 */
	public abstract void deleteByParentDO(PisIvxOrderDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对微信处方订单数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PisIvxOrderDO[] mainDos) throws BizException;
}
