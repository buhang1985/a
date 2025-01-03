package iih.mc.st.stockin.i;

import java.util.Map;

import iih.mc.po.pruchase.d.McPurchaseOrderDO;
import iih.mc.po.settlement.d.SettlementAggDO;
import iih.mc.po.stockinvoice.d.StockinvoiceAggDO;
import iih.mc.st.inspection.d.McInspectionDo;
import iih.mc.st.stockin.d.McStockInDO;
import iih.mc.st.stockin.d.McStockInItemDO;
import iih.mc.st.stockin.d.StockinAggDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

public interface IStockinMaintainService {
	
	/**
	 * 初始化入库单
	 * @param stca_code 库存交易分类
	 * @throws BizException
	 */
	public StockinAggDO initAggDo(String sd_sttp) throws BizException;
	
	/**
	 * 初始化入库明细信息
	 * @param inOrderDO 入库单
	 * @param inItemDO 入库单明细
	 * @throws BizException
	 */
	public McStockInItemDO initStockInItemInfo(McStockInDO inOrderDO, McStockInItemDO inItemDO) throws BizException;
	
	/**
	 * 根据采购订单生成采购入库单
	 * @param purOrderDOS 入库单
	 * @throws BizException
	 */
	public StockinAggDO initInOrderByPurchaseOrder(McPurchaseOrderDO[] purOrderDOS) throws BizException;
	
	/**
	 * 入库单提交
	 * @param inOrderDO 入库单
	 * @throws BizException
	 */
	public McStockInDO[] submitMainDO(McStockInDO[] inOrderDOS) throws BizException;
	
	/**
	 * 入库单提交
	 * @param inAggDO 入库单
	 * @throws BizException
	 */
	public StockinAggDO submitAggDO(StockinAggDO inAggDO) throws BizException;
	
	/**
	 * 更新入库单采购发票信息
	 * @param invoiceAggDOS 采购发票单
	 * @param fg_delete 删除标志
	 * @throws BizException
	 */
	public void updateInOrderInvInfo(StockinvoiceAggDO[] invoiceAggDOS, FBoolean fg_delete) throws BizException;
	
	/**
	 * 根据采购发票结算单生成回冲入库单
	 * @param settleTime 采购发票结算时间
	 * @param settleAggDOS 采购发票结算单
	 * @param inAggMap 入库单
	 * @throws BizException
	 */
	public StockinAggDO[] initInOrderBySettlement(FDateTime settleTime, SettlementAggDO[] settleAggDOS, Map<String, Map<String, StockinAggDO>> inAggMap) throws BizException;
    
	/**
	 * 高值入库生单，验收单转换为入库单,默认模式下
	 * @param inspOrderDOS
	 * @return
	 * @throws BizException
	 */
	public StockinAggDO initInOrderDataForInspBp(McInspectionDo[] inspOrderDOS) throws BizException;
	  /**
  	 * 、获取过滤已退货耗材入库明细
  	 * @param 
  	 * @return
  	 * @throws BizException
  	 */
       public McStockInItemDO[] getItemDO(String[] idins) throws BizException;
    		
       /**
     	 * 通过id获取厂商证件号
     	 * @param 
     	 * @return
     	 * @throws BizException
     	 */
          public String[]  getcf_no(String id_itmin) throws BizException;
       		
}
