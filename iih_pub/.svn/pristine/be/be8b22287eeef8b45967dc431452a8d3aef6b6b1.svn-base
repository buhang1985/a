package iih.mc.po.settlement.i;

import iih.mc.po.settlement.d.McSettlementDO;
import iih.mc.po.stockinvoice.d.McStockInvoiceDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;

public interface ISettlementMaintainService {
	
	/**
	 * 采购发票结算
	 * @param invoiceOrderDOS 采购发票单
	 * @throws BizException
	 */
	public McSettlementDO[] doSettle(McStockInvoiceDO[] invoiceOrderDOS, FDateTime settleTime) throws BizException;
}
