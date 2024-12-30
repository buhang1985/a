package iih.sc.sch.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;

/**
 * 作废号位BP
 * @author yank
 *
 */
public class RevokeTickBP {
	/**
	 * 作废号码
	 * @param tickId 号位
	 * @param supplyTicketType 补号类型
	 * @throws BizException
	 */
	public void exec(final String tickId, String supplyTicketType) throws BizException{
		//校验参数
		if(StringUtil.isEmpty(tickId)){
			throw new BizException("参数tickId为空！");
		}	
		switch (supplyTicketType) {
		case IScDictCodeConst.SC_CANC_RULE_RELEASE:
			DrawbackTicketBP drawbackTicketBP = new DrawbackTicketBP();
			drawbackTicketBP.exec(tickId);
			break;
		case IScDictCodeConst.SC_CANC_RULE_SUPPLY:
			InvalidAndSupplyTicketBP invalidAndSupplyTicketBP = new InvalidAndSupplyTicketBP();
			invalidAndSupplyTicketBP.exec(tickId);
			break;
		case IScDictCodeConst.SC_CANC_RULE_USED:
			break;

		case IScDictCodeConst.SC_CANC_RULE_PAST:
			CancAndPastTickBP cancAndPastTickBP = new CancAndPastTickBP();
			cancAndPastTickBP.exec(tickId);
			break;
		}
	}
}
