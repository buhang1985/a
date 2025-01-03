package iih.mm.st.stockcheck.i.ds;

import iih.mm.st.stockcheck.d.MaterialCheckItemDTO;
import iih.mm.st.stockcheck.d.StockCaspItemDO;
import iih.mm.st.stockcheck.d.StockCheckDO;
import iih.mm.st.stockcheck.d.StockCheckItmDO;
import iih.mm.st.stockcheck.d.StockcheckAggDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface IStockCheckService {
	/**
	 * 获取物品盘点条目。
	 * @param whId 仓库ID(必须)
	 * @param mmPkguTp 包装单位类型(必须)
	 * @param mmcaId 物品基本分类
	 * @param fgLoc 是否按货位(必须)
	 * @param fgCreate 零结存是否生单(必须) 
	 * @return
	 * @throws BizException
	 */
	public MaterialCheckItemDTO[] initMaterialCheckItems(String whId, String mmPkguTp, String mmcaId, Boolean fgLoc, Boolean fgCreat) throws BizException;
	
	/**
	 * 获取物品盘点条目。
	 * @param stockCheckItemList 已生成库存盘点明细列表(必须)
	 * @param whId 仓库(必须)
	 * @param mmPkguTp 包装单位类型(必须)
	 * @param mmcaId 物品基本分类
	 * @param fgCreate 零结存是否生单(必须)
	 * @return
	 * @throws BizException
	 */
	public MaterialCheckItemDTO[] getMaterialCheckItems(QryRootNodeDTO queryNode,StockCheckItmDO[] stockCheckItemList, String whId, String mmPkguTp, String mmcaId, Boolean fgCreat) throws BizException;
	
	/**
	 * 获取物品盘点条目。
	 * @param stockCaspItemList 已生成货位盘点明细列表(必须)
	 * @param whId 仓库(必须)
	 * @param mmPkguTp 包装单位类型(必须)
	 * @param mmcaId 物品基本分类
	 * @param fgCreate 零结存是否生单(必须)
	 * @return
	 * @throws BizException
	 */
	public MaterialCheckItemDTO[] getMaterialCheckCaspItems(QryRootNodeDTO queryNode,StockCaspItemDO[] stockCaspItemList, String whId, String mmPkguTp, String mmcaId, Boolean fgCreat) throws BizException;

	/**
	 * 获取物品盘点条目。
	 * @param stockCaspItemList 已生成货位盘点明细列表(必须)
	 * @param mmPkguTp 包装单位类型(必须)
	 * @return
	 * @throws BizException
	 */
	public StockCheckItmDO[] getStockCheckItems(StockCheckItmDO[] stockCheckItemList, String mmPkguTp) throws BizException;
	
	/**
	 * 获取物品盘点条目。
	 * @param stockCaspItemList 已生成货位盘点明细列表(必须)
	 * @param mmPkguTp 包装单位类型(必须)
	 * @return
	 * @throws BizException
	 */
	public StockCaspItemDO[] getStockCaspItems(StockCaspItemDO[] stockCaspItemList, String mmPkguTp) throws BizException;
	
	/**
	 * 删除物品盘点。
	 * @param ids 盘点单主键(必须)
	 * @return
	 * @throws BizException
	 */
	public void delete(String[] ids) throws BizException;
	
	/**
	 * 物品盘点录入完成确认。
	 * @param ids 盘点单主键(必须)
	 * @return
	 * @throws BizException
	 */
	public StockcheckAggDO[] confirm(String[] ids) throws BizException;
	
	/**
	 * 物品盘点取消录入完成确认。
	 * @param ids 盘点单主键(必须)
	 * @return
	 * @throws BizException
	 */
	public StockcheckAggDO[] cancelConfirm(String[] ids) throws BizException;
	
	/**
	 * 盘点结果录入时，对于新增物品，匹配结存信息。
	 * @param id_wh 盘点仓库(必须)
	 * @param checkItemDO 盘点项目(必须)
	 * @return
	 * @throws BizException
	 */
	public StockCheckItmDO setCheckItemInfo(String id_wh, StockCheckItmDO checkItemDO) throws BizException;
	public StockCaspItemDO setCaspItemInfo(String id_wh, StockCaspItemDO checkItemDO) throws BizException;
	
	/**
	 * 根据条件分单。
	 * @param checkAggDO 盘点单(必须)
	 * @return
	 * @throws BizException
	 */
	public StockcheckAggDO splitCheckItem(StockcheckAggDO checkAggDO) throws BizException;
	
	/**
	 * 根据组别加载数据。
	 * @param checkAggDO 盘点单(必须)
	 * @return
	 * @throws BizException
	 */
	public StockcheckAggDO loadGrpData(StockCheckDO checkDO) throws BizException;
	
	/**
	 * 保存盘点信息。
	 * @param checkAggDO 盘点单(必须)
	 * @return
	 * @throws BizException
	 */
	public void recordInvenInfo(StockcheckAggDO checkAggDO) throws BizException;
	
	/**
	 * 获取盘点单明细导出数据。
	 * @param checkAggDO 盘点单(必须)
	 * @return
	 * @throws BizException
	 */
	public MaterialCheckItemDTO[] getChekExportData(StockCheckDO checkDO) throws BizException;
	
	/**
	 * 盘点结果录入，更改包装单位，重新计算价格和数量
	 * @param checkItm
	 * @param caspItm
	 * @return
	 * @throws BizException
	 */
	public StockCheckItmDO[] calCheckItem(StockCheckItmDO[] checkItms) throws BizException;
	public StockCaspItemDO[] calCaspItem(StockCaspItemDO[] caspItms) throws BizException;
}
