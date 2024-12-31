package iih.mm.mc.stockperinit.i;

import iih.mm.comm.finance.d.FinancePeriodDTO;
import iih.mm.mc.stockperinit.d.StockInitDataImportDTO;
import iih.mm.mc.stockperinit.d.StockInitDataImportResultDTO;
import iih.mm.mc.stockperinit.d.StockPerInitDO;
import xap.mw.core.data.BizException;

public interface IStockperinitService {
	
	/**
	 * 补全期初导入数据
	 * @param initDatas 导入数据
	 * @param idWh 仓库ID
	 */
	public StockInitDataImportResultDTO assemblePerinitImportData(StockInitDataImportDTO[] initDatas, StockPerInitDO perInitDO) throws BizException;
	
	/**
	 * 导出期初数据
	 * @param perInitDO 期初数据
	 */
	public StockInitDataImportDTO[] perInitExportData(StockPerInitDO perInitDO) throws BizException;
	
	/**
	 * 能否取消记账
	 * @param idWh 仓库ID
	 * @param yearMonth 年月
	 */
	public void canCancelAcoount(String idWh, String yearMonth) throws BizException;
	
	/**
	 * 判断仓库是否已经进行了[期初记账]处理。
	 * @param whId 仓库ID
	 * @return true 已处理 false 未处理
	 * @throws BizException
	 */
	public boolean isWarehouseInited(String whId) throws BizException;
	
	/**
	 * 获取仓库期初年月
	 */
	public FinancePeriodDTO getWarehouseInitYearmonth(String whId) throws BizException;
}
