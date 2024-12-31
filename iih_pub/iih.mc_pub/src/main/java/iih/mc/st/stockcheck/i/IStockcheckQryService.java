package iih.mc.st.stockcheck.i;

import iih.mc.st.stockcheck.d.McStockCheckDO;
import iih.mc.st.stockcheck.d.StockcheckAggDO;
import iih.mm.st.stockcheck.d.MaterialCheckItemDTO;
import xap.mw.core.data.BizException;

public interface IStockcheckQryService {
	
	/**
	 * 根据组别加载盘点明细数据
	 * @param stockCheckDO 盘点单
	 * @throws BizException
	 */
	public StockcheckAggDO loadGrpData(McStockCheckDO stockCheckDO) throws BizException;
	
	/**
	 * 获取导出数据
	 * @param stockCheckDO 盘点单
	 * @throws BizException
	 */
	public MaterialCheckItemDTO[] stockCheckExportData(McStockCheckDO checkDO) throws BizException;
}
