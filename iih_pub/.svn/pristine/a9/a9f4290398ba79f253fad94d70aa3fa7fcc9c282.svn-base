package iih.mc.po.pruchase.i;

import iih.mc.pl.mcstockplan.d.McStockPlanDO;
import iih.mc.po.pruchase.d.McPurchaseOrderDO;
import iih.mc.po.pruchase.d.McPurchseOrderItmDO;
import iih.mc.po.pruchase.d.PruchaseAggDO;
import xap.mw.core.data.BizException;

public interface IPruchaseMaintainService {
	
	/**
	 * 初始化采购订单
	 * @param 
	 * @throws BizException
	 */
	public PruchaseAggDO initAggDo() throws BizException;
	
	/**
	 * 填充采购明细信息
	 * @param purOrderDO 采购单
	 * @param purOrderItemDO 采购单明细
	 * @throws BizException
	 */
	public McPurchseOrderItmDO initPurchaseItemInfo(McPurchaseOrderDO purOrderDO, McPurchseOrderItmDO purOrderItemDO) throws BizException;
	
	/**
	 * 采购订单启用
	 * @param purChaseOrderODS 采购单
	 * @return 启用数据数据
	 * @throws BizException
	 */
	public McPurchaseOrderDO[] enable(McPurchaseOrderDO[] purChaseOrderODS) throws BizException;
	
	/**
	 * 采购订单停用
	 * @param purChaseOrderODS 采购单
	 * @return 停用数据
	 * @throws BizException
	 */
	public McPurchaseOrderDO[] disable(McPurchaseOrderDO[] purChaseOrderODS) throws BizException;
	
	/**
	 * 通过采购计划生成采购订单
	 * @param mcStockPlanDO
	 * @return
	 */
	public PruchaseAggDO[] initPruchaseOrderByStockPlan(McStockPlanDO mcStockPlanDO) throws BizException;;
}
