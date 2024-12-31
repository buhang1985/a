package iih.mc.st.mcstockaplrel.i;

import xap.mw.core.data.BizException;

public interface IMcstockaplrelService {
	/**
	 * 出库申请关联表数据插入处理
	 * @param depAplID 申请单主键
	 * @param stockOutID 出库单主键
	 */
	public void initStockAplRel(String[] depAplIDList, String stockOutID) throws BizException;
}
