package iih.mm.po.purchase.i.ds;

import iih.mm.po.purchase.d.PurchaseAggDO;
import xap.mw.core.data.BizException;

public interface IPurchaseFlowService {
	public PurchaseAggDO[] submitPurchaseOrder(String[] purchaseIdList) throws BizException;
	
	/**
	 * 采购单审核通过
	 */
	public PurchaseAggDO acceptPurchaseOrder(PurchaseAggDO purchaseAggDO) throws BizException;
	
	/**
	 * 采购单审核驳回
	 */
	public PurchaseAggDO rejectPurchaseOrder(PurchaseAggDO purchaseAggDO) throws BizException;
}
