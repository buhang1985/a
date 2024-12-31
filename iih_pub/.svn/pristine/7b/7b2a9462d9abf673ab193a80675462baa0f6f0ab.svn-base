package iih.mm.pl.stockplan.i.ds;

import xap.mw.core.data.BizException;
import iih.mm.pl.stockplan.d.StockplanAggDO;

public interface IPurchasePlanFlowService {
	/**
	 * 提交采购计划
	 */
	public StockplanAggDO[] submitPurchasePlan(String[] ids) throws BizException;
	
	/**
	 * 采购计划审核通过
	 */
	public StockplanAggDO acceptPurchasePlan(StockplanAggDO stockplanAggDO) throws BizException;
	
	/**
	 * 采购计划审核驳回
	 */
	public StockplanAggDO rejectPurchasePlan(StockplanAggDO stockplanAggDO) throws BizException;	
}
