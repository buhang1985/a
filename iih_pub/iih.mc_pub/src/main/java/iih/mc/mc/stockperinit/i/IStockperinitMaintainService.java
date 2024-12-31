package iih.mc.mc.stockperinit.i;

import iih.mc.mc.stockperinit.d.McStockPerInitDO;
import iih.mm.mc.stockperinit.d.StockInitDataImportDTO;
import iih.mm.mc.stockperinit.d.StockInitDataImportResultDTO;
import xap.mw.core.data.BizException;

public interface IStockperinitMaintainService {
	
	/**
	 * 初始化期初记账
	 * @throws BizException
	 */
	public McStockPerInitDO initMainDO() throws BizException;
	
	/**
	 * 期初记账
	 * @param perInitDO 期初数据
	 * @throws BizException
	 */
	public McStockPerInitDO dealBook(McStockPerInitDO perInitDO) throws BizException;
	
	/**
	 * 取消期初记账
	 * @param perInitDO 期初数据
	 * @throws BizException
	 */
	public McStockPerInitDO cancelBook(McStockPerInitDO perInitDO) throws BizException;
	
	/**
	 * 导入期初数据(直接保存明细数据)
	 * @param initDatas 导入数据
	 * @param perInitDO 期初数据
	 * @throws BizException
	 */
	public StockInitDataImportResultDTO perInitImportData(McStockPerInitDO perInitDO, StockInitDataImportDTO[] initDatas) throws BizException;
	
	/**
	 * 导出期初数据
	 * @param perInitDO 期初数据
	 * @throws BizException
	 */
	public StockInitDataImportDTO[] perInitExportData(McStockPerInitDO perInitDO) throws BizException;
}
