package iih.mm.st.stockin.purchase.i;

import iih.mm.pl.trapimpl.d.TrapImplDO;
import iih.mm.st.stockin.d.StockInDO;
import xap.mw.core.data.BizException;

/**
 * 采购入库扩展服务
 * @author liuyilin
 *
 */
public interface IPurchaseExtCudService {

	/**
	 * 采购入库，根据入库单和选择的转入仓库，生成调拨单
	 * @param stockInDos
	 * @param idWhAp
	 * @return
	 * @throws BizException 
	 */
	public abstract TrapImplDO createTrByStockIn(StockInDO[] stockInDos, String idWhAp, String code) throws BizException;
}
