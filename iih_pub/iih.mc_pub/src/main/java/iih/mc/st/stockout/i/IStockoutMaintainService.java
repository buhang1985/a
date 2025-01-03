package iih.mc.st.stockout.i;

import iih.mc.bl.stockbl.d.McStockBlDO;
import iih.mc.itf.hvitem.d.McHvUseOutDTO;
import iih.mc.pl.deprequestap.d.McDepReqApOrderDO;
import iih.mc.st.stockout.d.McStockOutDO;
import iih.mc.st.stockout.d.McStockOutItemDO;
import iih.mc.st.stockout.d.StockoutAggDO;
import xap.mw.core.data.BizException;

public interface IStockoutMaintainService {
	
	/**
	 * 初始化出库单
	 * @param sd_sttp 库存交易类型
	 * @throws BizException
	 */
	public StockoutAggDO initAggDo(String sd_sttp) throws BizException;
	
	/**
	 * 初始化出库单明细
	 * @param outOrderDO 出库单
	 * @param outItemDO 出库单明细
	 * @throws BizException
	 */
	public McStockOutItemDO initStockOutItemInfo(McStockOutDO outOrderDO, McStockOutItemDO outItemDO) throws BizException;
	
	/**
	 * 根据所选结存初始化出库明细信息(批次修改用)
	 * @param stockBlDO 结存信息
	 * @param inItemDO 入库单明细
	 * @throws BizException
	 */
	public McStockOutItemDO initStockOutItemByStockbl(McStockBlDO stockBlDO, McStockOutItemDO outItemDO) throws BizException;
	
	/**
	 * 根据领用申请单生成领用出库单
	 * @param depreqOrderDOS 领用申请单
	 * @throws BizException
	 */
	public StockoutAggDO initOutOrderByDepreqOrder(McDepReqApOrderDO[] depreqOrderDOS) throws BizException;
	
	/**
	 * 出库单提交
	 * @param outOrderDOS 出库单
	 * @throws BizException
	 */
	public void submitMainDO(McStockOutDO[] outOrderDOS) throws BizException;
	
	/**
	 * 出库单提交
	 * @param outAggDO 出库单
	 * @throws BizException
	 */
	public StockoutAggDO submitAggDO(StockoutAggDO outAggDO) throws BizException;
	
	/**
	 * 根据物品结存ID查询物品信息
	 * @param idBl
	 * @return
	 * @throws BizException
	 */
	public McStockOutItemDO getOutItemMsg(String idBl) throws BizException;
	/**
	 * 根据原出库单据，生成退库单据
	 * @param idBl
	 * @return
	 * @throws BizException
	 */
	public StockoutAggDO getBackAggDO(McStockOutDO outOrderDOS) throws BizException;
	
	/**
	 * 高值耗材出库退库单提交
	 * @param outAggDO 出库单
	 * @throws BizException
	 */
	public StockoutAggDO submitBackAggDO(StockoutAggDO outAggDO) throws BizException;
	/**
	 * 高值耗材出库使用增加正式库出入库流程
	 * @param stockoutAggDOs 出库单 ，McHvUseOutDTO 高值使用DTO
	 * @throws BizException
	 */
   public McHvUseOutDTO[] McInOut(StockoutAggDO[] stockoutAggDOs) throws BizException;
   /**
	 * 高值耗材退库通过唯一码和退库仓库验证结存，不为0时禁止退库
	 * @throws BizException
	 */
  public String checkonlycodebl(String[] OnlyCodes,String IdWh) throws BizException;
}
