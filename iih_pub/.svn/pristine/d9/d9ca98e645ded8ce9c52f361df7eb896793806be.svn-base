package iih.mm.po.purchase.i;

import xap.mw.core.data.BizException;
import iih.mm.po.purchase.d.PurchaseOrderDO;
import iih.mm.po.purchase.d.PurchaseAggDO;

/**
* 采购单数据维护服务
*/
public interface IPurchaseCudService {
	/**
	*  采购单数据真删除
	*/
    public abstract void delete(PurchaseAggDO[] aggdos) throws BizException;
    
    /**
	*  采购单数据插入保存
	*/
	public abstract PurchaseAggDO[] insert(PurchaseAggDO[] aggdos) throws BizException;
	
    /**
	*  采购单数据保存
	*/
	public abstract PurchaseAggDO[] save(PurchaseAggDO[] aggdos) throws BizException;
	
    /**
	*  采购单数据更新
	*/
	public abstract PurchaseAggDO[] update(PurchaseAggDO[] aggdos) throws BizException;
	
	/**
	*  采购单数据逻辑删除
	*/
	public abstract void logicDelete(PurchaseAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对采购单数据真删除
	 */
	public abstract void deleteByParentDO(PurchaseOrderDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对采购单数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PurchaseOrderDO[] mainDos) throws BizException;
}
