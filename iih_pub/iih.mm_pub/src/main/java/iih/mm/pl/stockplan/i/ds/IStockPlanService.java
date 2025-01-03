package iih.mm.pl.stockplan.i.ds;

import iih.bd.mm.meterial.d.MeterialDO;
import iih.mm.pl.stockplan.d.StockPlanDO;
import iih.mm.pl.stockplan.d.StockPlanItmDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

public interface IStockPlanService {

	/**
	 * 物品快速新增，初始化采购计划明细
	 */
	public abstract StockPlanItmDO[] initStockPalnItemList(String[] mmIdList, String id_wh) throws BizException;
	
	/**
	 * 物品、包装单位变更时，初始化采购计划明细
	 */
	public abstract StockPlanItmDO initStockPalnItemInfo(StockPlanItmDO planItemDO, String id_wh) throws BizException;
	
	/**
	 * 库存计划删除
	 */
	public abstract void delete(String[] ids) throws BizException;
	
	/**
	 * 更新库存计划单状态
	 */
	public abstract void updateStockPlanStatus(String[] plIdList, FBoolean fg_delete) throws BizException;
	
	/**
	 * 获取采购计划单明细导出数据
	 */
	public abstract StockPlanItmDO[] getStockPlanExportData(StockPlanDO planDO) throws BizException;

	/**
	 * 快速新增界面根据分类和仓库查询物品信息
	 * @param categoryId
	 * @param id_wh
	 * @param zero
	 * @param pois
	 * @return
	 * @throws BizException
	 */
	public abstract MeterialDO[] findMMByMmca(String categoryId, String id_wh_ap, String id_wh, String zero, Boolean pois, String funcode) throws BizException;

	/**
	 * 编辑或查看已存在的采购计划时，初始化明细中的计算字段信息
	 * @param stockPlanItmDOs
	 * @return
	 * @throws BizException
	 */
	public abstract StockPlanItmDO[] initItemList(StockPlanItmDO[] stockPlanItmDOs, String id_wh) throws BizException;
	
	/**
	 * 采购计划快速新增后，查询初始化明细
	 * @param mmIdList
	 * @param id_wh
	 * @return
	 * @throws BizException
	 */
	public abstract StockPlanItmDO[] getItemList(String[] mmIdList, String id_wh) throws BizException;

	/**
	 * 新增一条明细或修改一条明细时，查询计算该物品信息
	 * @param stockPlanItmDO
	 * @param id_wh
	 * @param fg_pkgu 区分是否是单独修改单位时触发，修改单位时，不重新计算供应商
	 * @return
	 * @throws BizException
	 */
	public abstract StockPlanItmDO getItem(StockPlanItmDO stockPlanItmDO, String id_wh, Boolean fg_pkgu) throws BizException;
	
	/**
	 * 在卡界面有已经保存的明细时，直接在卡界面修改采购策略，确认时重新计算各种计算字段和供应商
	 * @param stockPlanItmDOs
	 * @param id_wh
	 * @return
	 * @throws BizException
	 */
	public abstract StockPlanItmDO[] initItemListWithStrategyChange(StockPlanItmDO[] stockPlanItmDOs, String id_wh) throws BizException;

	/**
	 * 修改供应商，当入库价根据协议价获取时，需要变更入库价
	 * @param stockPlanItmDO
	 * @return
	 * @throws BizException
	 */
	public abstract FDouble changePriBySup(StockPlanDO parent, StockPlanItmDO stockPlanItmDO) throws BizException;
}
