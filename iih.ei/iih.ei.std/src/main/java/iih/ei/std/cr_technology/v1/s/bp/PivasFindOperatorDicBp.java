package iih.ei.std.cr_technology.v1.s.bp;

import iih.bd.utils.CommDAFacade;
import iih.ei.std.cr_technology.v1.d.PivasBaseParamBean;
import iih.ei.std.cr_technology.v1.d.PivasFindOperatorDicResultBeanInfoDt;
import iih.ei.std.cr_technology.v1.s.bp.qry.PivasFindOperatorDicQry;
import xap.mw.core.data.BizException;

/**
 * 操作员基本信息
 * 
 * @author dj.zhang
 *
 */
public class PivasFindOperatorDicBp {

	public PivasFindOperatorDicResultBeanInfoDt[] exec(PivasBaseParamBean paramBean) throws BizException {
		PivasFindOperatorDicQry qry = new PivasFindOperatorDicQry();
		PivasFindOperatorDicResultBeanInfoDt[] result = CommDAFacade.execQuery(qry,
				PivasFindOperatorDicResultBeanInfoDt.class);
		return result;
	}

}
