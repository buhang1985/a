package iih.mc.po.pruchase.i;

import xap.mw.core.data.BizException;
import iih.mc.po.pruchase.d.McPurchaseOrderDO;
import iih.mc.po.pruchase.d.PruchaseAggDO;

/**
* 采购订单数据维护服务
*/
public interface IPruchaseCudService {
	/**
	*  采购订单数据真删除
	*/
    public abstract void delete(PruchaseAggDO[] aggdos) throws BizException;
    
    /**
	*  采购订单数据插入保存
	*/
	public abstract PruchaseAggDO[] insert(PruchaseAggDO[] aggdos) throws BizException;
	
    /**
	*  采购订单数据保存
	*/
	public abstract PruchaseAggDO[] save(PruchaseAggDO[] aggdos) throws BizException;
	
    /**
	*  采购订单数据更新
	*/
	public abstract PruchaseAggDO[] update(PruchaseAggDO[] aggdos) throws BizException;
	
	/**
	*  采购订单数据逻辑删除
	*/
	public abstract void logicDelete(PruchaseAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对采购订单数据真删除
	 */
	public abstract void deleteByParentDO(McPurchaseOrderDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对采购订单数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(McPurchaseOrderDO[] mainDos) throws BizException;
}
