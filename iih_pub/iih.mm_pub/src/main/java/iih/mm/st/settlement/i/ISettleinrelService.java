package iih.mm.st.settlement.i;

import iih.mm.st.stockin.d.StockinAggDO;
import xap.mw.core.data.BizException;

public interface ISettleinrelService {
	
	/**
	 * 发票结算处理。
	 */
	public void initSettleInRel(StockinAggDO[] backFlushAggDOS) throws BizException;
	
}
