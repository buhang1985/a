package iih.bd.mm.stockdealtype.s.bp;

import iih.bd.mm.stockdealtype.d.StockDealTypeDO;
import xap.mw.core.data.BizException;

public class StockDealtpDeBeforeBp {

	public void exec(StockDealTypeDO[] stockDealTpDOS) throws BizException {

		if (stockDealTpDOS == null || stockDealTpDOS.length <= 0) {

			return;
		}

		// ■ 验证库存交易分类是否允许删除
		this.checkCanDelete(stockDealTpDOS);
	}

	private void checkCanDelete(StockDealTypeDO[] stockDealTpDOS) throws BizException {

		checkFgSystem(stockDealTpDOS);

		// IStockinMDORService stockInRSrv =
		// ServiceFinder.find(IStockinMDORService.class);
		// IStockoutMDORService stockOutRSrv =
		// ServiceFinder.find(IStockoutMDORService.class);
		//
		// for (StockDealTypeDO stockDealTpDO : stockDealTpDOS) {
		//
		// // 是否已被入库数据引用
		// String whrStr = String.format("id_mmstca = '%s'",
		// stockDealTpDO.getId_mmstca());
		// StockInDO[] stockInDOS = stockInRSrv.find(whrStr, "", FBoolean.TRUE);
		// if (stockInDOS != null && stockInDOS.length > 0) {
		//
		// throw new BizException(String.format("库存交易分类【%s】已被入库数据引用，不允许删除。",
		// stockDealTpDO.getName()));
		// }
		// // 是否已被出库数据引用
		// StockOutDO[] stockOutDOS = stockOutRSrv.find(whrStr, "",
		// FBoolean.TRUE);
		// if (stockOutDOS != null && stockOutDOS.length > 0) {
		//
		// throw new BizException(String.format("库存交易分类【%s】已被出库数据引用，不允许删除。",
		// stockDealTpDO.getName()));
		// }
		// }
	}

	/**
	 * 检查系统标识
	 * 
	 * @param stockDealTpDOS
	 * @throws BizException
	 */
	private void checkFgSystem(StockDealTypeDO[] stockDealTpDOS) throws BizException {
		for (StockDealTypeDO stockDealTypeDO : stockDealTpDOS) {
			if (stockDealTypeDO.getFlag_sys().booleanValue() == true) {
				String msg = String.format("\"%s\"为系统数据，不允许删除。", stockDealTypeDO.getName());
				throw new BizException(msg);
			}
		}
	}
}
