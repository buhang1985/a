package iih.mm.st.stockpriceadjust.i.ds;

import iih.mm.st.stockpriceadjust.d.StockpriceadjustAggDO;
import xap.mw.core.data.BizException;

public interface IStPriceAdjFlowService {
	/**
	 * 提交调价计划
	 */
	public StockpriceadjustAggDO[] submitStPriceAdj(String[] ids) throws BizException;
	
	/**
	 * 调价计划审核通过
	 */
	public StockpriceadjustAggDO acceptStPriceAdj(StockpriceadjustAggDO stPriceAdjAggDO) throws BizException;
	
	/**
	 * 调价计划审核驳回
	 */
	public StockpriceadjustAggDO rejectStPriceAdj(StockpriceadjustAggDO stPriceAdjAggDO) throws BizException;
}
