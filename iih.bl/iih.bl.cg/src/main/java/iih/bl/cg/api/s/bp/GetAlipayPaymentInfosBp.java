package iih.bl.cg.api.s.bp;

import iih.bl.cg.api.d.AlipayPayInfo;
import iih.bl.cg.api.s.bp.qry.GetPaymentInfosQry;

import java.util.Date;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class GetAlipayPaymentInfosBp {
	/**
	 * 支付宝缴费信息
	 */
	public AlipayPayInfo[] exec(String rep_date, String end_date) throws BizException {
		DAFacade da = new DAFacade();
		GetPaymentInfosQry qry = new GetPaymentInfosQry("11", rep_date, end_date);
		@SuppressWarnings("unchecked")
		List<AlipayPayInfo> retval = (List<AlipayPayInfo>) da.execQuery(qry.getQrySQLStr(), qry.getQryParameter(null), new BeanListHandler(AlipayPayInfo.class));
		if (retval != null)
			return retval.toArray(new AlipayPayInfo[retval.size()]);
		return null;
	}
}
