package iih.mm.st.stockpriceadjust.i.ds;

import iih.mm.st.stockpriceadjust.d.StockPriceAdjustItmDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

public interface IStockPriceAdjustService {
	/**
	 * 获取物品在所有仓库还存在可用物品的结存列表。
	 * @param mmId 物品ID
	 * @return 结存列表
	 * @throws BizException
	 */
	public StockPriceAdjustItmDO[] getMaterialStockList(String mmId, FBoolean fg_zero) throws BizException;
	
	/**
	 * 调价单删除
	 * @param ids 调价单ID
	 * @throws BizException
	 */
	public void delete(String[] ids) throws BizException;
}
