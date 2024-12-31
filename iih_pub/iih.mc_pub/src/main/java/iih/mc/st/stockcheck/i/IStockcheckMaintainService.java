package iih.mc.st.stockcheck.i;

import iih.mc.bl.stockbl.d.McStockBlDO;
import iih.mc.st.stockcheck.d.McStockCaspItemDO;
import iih.mc.st.stockcheck.d.McStockCheckDO;
import iih.mc.st.stockcheck.d.StockcheckAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;

public interface IStockcheckMaintainService {
	
	/**
	 * 初始化盘点单
	 * @throws BizException
	 */
	public StockcheckAggDO initAggDo() throws BizException;
	
	/**
	 * 生成盘库明细、根据结存信息生成盘点单明细信息(货位 、非货位)、直接返回盘点单明细DO、前端再进行转换
	 * @param stockCheckDO 盘点单
	 * @throws BizException
	 */
	public BaseDO[] initMaterialCheckItems(McStockCheckDO stockCheckDO) throws BizException;
	
	/**
	 * 盘点单创建时、手动选择盘点数据、根据选中的结存信息生成盘点明细信息(货位 、非货位)、直接返回盘点单明细DO、前端再进行转换
	 * @param
	 * @throws BizException
	 */
	public BaseDO[] getMaterialCheckItems(McStockCheckDO stockCheckDO, McStockBlDO[] stockBlDOS) throws BizException;
	
	/**
	 * 盘点单创建时、修改包装单位类型、重新计算明细数据的价格和数量信息(货位 、非货位)、直接返回盘点单明细DO、前端再进行转换
	 * @param 
	 * @throws BizException
	 */
	public McStockCaspItemDO[] recalBlinfoByMpkgtp(McStockCaspItemDO[] checkItemList, String mmPkguTp) throws BizException;
	
	/**
	 * 盘点结果录入时、对于新增物品、匹配结存信息(货位 、非货位)、直接返回盘点单明细DO、前端再进行转换
	 * @param 
	 * @throws BizException
	 */
	public BaseDO initCheckItemInputInfo(String id_wh, BaseDO checkItemDO) throws BizException;
	
	/**
	 * 盘点信息保存(盘点结果录入画面使用、只保存明细信息)
	 * @param checkAggDO 盘点单
	 * @throws BizException
	 */
	public void recordInvenInfo(StockcheckAggDO checkAggDO) throws BizException;
	
	/**
	 * 盘点单录入完成确认
	 * @param stockCheckDOS 盘点单
	 * @throws BizException
	 */
	public void entryComplMainDO(McStockCheckDO[] stockCheckDOS) throws BizException;
	
	/**
	 * 取消盘点单录入完成确认
	 * @param stockCheckDOS 盘点单
	 * @throws BizException
	 */
	public void cancelEntryCompl(McStockCheckDO[] stockCheckDOS) throws BizException;
	
	/**
	 * 盘点单录入完成确认
	 * @param checkAggDO 盘点单
	 * @throws BizException
	 */
	public StockcheckAggDO entryComplAggDO(StockcheckAggDO checkAggDO) throws BizException;
	
	/**
	 * 根据盘点人数分单(多人盘点)
	 * @param checkAggDO 盘点单
	 * @throws BizException
	 */
	public StockcheckAggDO splitCheckItem(StockcheckAggDO checkAggDO) throws BizException;
}
