package iih.mm.st.settlement.i;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;

public interface ISettlementService {

	/**
	 * 发票结算处理。
	 * @param invIds 发票单号
	 * @param settleTime 结算日期
	 * @throws BizException
	 */
	public void doSettlement(String[] invIds, FDateTime settleTime) throws BizException;
}
