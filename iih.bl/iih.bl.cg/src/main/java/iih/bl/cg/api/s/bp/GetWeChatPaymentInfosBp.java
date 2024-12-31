package iih.bl.cg.api.s.bp;

import iih.bl.cg.api.d.WeChatPayInfo;
import iih.bl.cg.api.s.bp.qry.GetPaymentInfosQry;

import java.util.Date;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class GetWeChatPaymentInfosBp {
	public WeChatPayInfo[] exec(String rep_date, String end_date) throws BizException {

		DAFacade da = new DAFacade();
		GetPaymentInfosQry qry = new GetPaymentInfosQry("12", rep_date, end_date);
		@SuppressWarnings("unchecked")
		List<WeChatPayInfo> retval = (List<WeChatPayInfo>) da.execQuery(qry.getQrySQLStr(), qry.getQryParameter(null), new BeanListHandler(WeChatPayInfo.class));
		if (retval != null)
			return retval.toArray(new WeChatPayInfo[retval.size()]);
		return null;
	}
}
