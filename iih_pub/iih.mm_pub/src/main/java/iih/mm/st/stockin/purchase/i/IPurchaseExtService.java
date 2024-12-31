package iih.mm.st.stockin.purchase.i;

import iih.mm.st.stockin.d.StockInItemDO;
import xap.mw.core.data.BizException;

/**
 * 采购入库扩展业务接口
 * @author liuyilin
 *
 */
public interface IPurchaseExtService {

	/**
	 * 获取物品历史入库信息
	 * @param item
	 * @return
	 * @throws BizException 
	 */
	public abstract StockInItemDO[] findHistoryInfo(String id_mm, String id_wh) throws BizException;
}
