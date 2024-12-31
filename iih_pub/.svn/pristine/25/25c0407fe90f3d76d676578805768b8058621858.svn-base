package iih.mm.st.stockout.i.ds;

import iih.mm.pl.trapimpl.d.TrapImplItemDO;
import iih.mm.st.stockout.d.StockOutDO;
import iih.mm.st.stockout.d.StockOutItemDO;
import iih.mm.st.stockout.d.StockoutAggDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

public interface IStockOutService {
	/**
	 * 根据调拨请领计划初始化出库单
	 * @param plId 请领计划ID列表
	 * @param whId 出库仓库ID
	 * @return 调拨出库单
	 * @throws BizException
	 */
	public StockoutAggDO initDiaoboOutOrderByPlan(String[] plIdList) throws BizException;
	
	/**
	 * 获取物品出库条目待选列表
	 * @param whId 出库仓库ID
	 * @param mmId 物品ID
	 * @param uiPkguId 界面包装单位
	 */
	public StockOutItemDO[] getOutOrderItemSelections(StockOutItemDO outItemDO, String whId, FBoolean redBlue) throws BizException;
	
	/**
	 * 获取物品出库条目待选列表
	 * @param trapItemList 调拨明细
	 * @param id_wh 出库仓库ID
	 */
	public StockOutItemDO[] getTrapOutOrderItemSelections(TrapImplItemDO[] trapItemList, String id_wh, Boolean fg_create) throws BizException;
	
	/**
	 * 提交出库单
	 */
	public StockoutAggDO[] submit(String[] ids) throws BizException;
	
	
	/**
	 * 出库单删除 
	 */
	public void delete(String[] ids) throws BizException;
	
	/**
	 * 根据物品结存ID查询物品信息
	 * @param idBl
	 * @return
	 * @throws BizException
	 */
	public StockOutItemDO getOutItemMsg(String idBl, StockOutDO parentDo, String idPkguAct) throws BizException;
}
