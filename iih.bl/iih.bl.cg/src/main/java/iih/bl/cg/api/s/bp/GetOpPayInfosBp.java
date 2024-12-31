package iih.bl.cg.api.s.bp;

import java.util.List;

import iih.bl.cg.api.d.OpPayInfo;
import iih.bl.cg.api.s.bp.qry.GetSettlePaymentInfosQry;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 获取门诊缴费列表
 * @author Liwq
 *
 */
public class GetOpPayInfosBp {
	
	public OpPayInfo[] exec(String patCode,String beginDate,String endDate) throws BizException {

		DAFacade da = new DAFacade();
		GetSettlePaymentInfosQry qry = new GetSettlePaymentInfosQry(patCode, beginDate, endDate);
		@SuppressWarnings("unchecked")
		List<OpPayInfo> retval = (List<OpPayInfo>) da.execQuery(qry.getQrySQLStr(), qry.getQryParameter(null), new BeanListHandler(OpPayInfo.class));
		if (retval != null)
			return retval.toArray(new OpPayInfo[retval.size()]);
		return null;
	} 
}
