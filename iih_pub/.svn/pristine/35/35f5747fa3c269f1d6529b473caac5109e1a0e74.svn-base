package iih.mm.po.purchase.i.ds;

import java.util.List;

import iih.mm.pl.stockplan.d.StockPlanItmDO;
import iih.mm.po.purchase.d.PurchaseAggDO;
import iih.mm.po.purchase.d.PurchaseOrderDO;
import iih.mm.po.purchase.d.PurchseOrderItmDO;
import iih.mm.st.stockin.d.StockInDO;
import iih.mm.st.stockin.d.StockinAggDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

public interface IPurchaseService {
	
	/**
	 * 根据供应商、物品类型对库存采购计划进行拆单处理。
	 */
	public PurchaseAggDO[] generatePoOrderFromPlan(String[] planIds) throws BizException;
	
	public PurchseOrderItmDO initPurchaseItemInfo(PurchaseOrderDO purOrderDO, PurchseOrderItmDO purOrderItemDO) throws BizException;
	
	/**
	 * 删除
	 */
	public void delete(String[] poIds) throws BizException;
	
	/**
	 * 启用
	 */
	public PurchaseAggDO[] start(String[] poIds) throws BizException;
	
	/**
	 * 停用
	 */
	public PurchaseAggDO[] stop(String[] poIds) throws BizException;
	
	public void updatePurchaseOrderStatus(String[] poIdList, FBoolean fg_delete, List<StockinAggDO> inList) throws BizException;
	
	/**
	 * 校验生单时，明细中的采购停用标志物品，返回前台提示用
	 * @param planIds
	 * @return
	 * @throws BizException
	 */
	public StockPlanItmDO[] checkFgStopPo(String[] planIds) throws BizException;
}
