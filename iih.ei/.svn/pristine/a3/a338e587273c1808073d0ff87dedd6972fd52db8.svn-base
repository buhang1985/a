package iih.ei.std.cr_technology.v1.s.bp;

import iih.bd.utils.CommDAFacade;
import iih.ei.std.cr_technology.v1.d.PivasBaseParamBean;
import iih.ei.std.cr_technology.v1.d.PivasFindOrdAdviceDicResultBeanInfoDt;
import iih.ei.std.cr_technology.v1.s.bp.qry.PivasFindOrdAdviceDicQry;
import xap.mw.core.data.BizException;

/**
 * 医嘱用法资料信息
 * 
 * @author dj.zhang
 *
 */
public class PivasFindOrdAdviceDicBp {

	public PivasFindOrdAdviceDicResultBeanInfoDt[] exec(PivasBaseParamBean paramBean) throws BizException {
		PivasFindOrdAdviceDicQry qry = new PivasFindOrdAdviceDicQry();
		PivasFindOrdAdviceDicResultBeanInfoDt[] result = CommDAFacade.execQuery(qry,
				PivasFindOrdAdviceDicResultBeanInfoDt.class);
		return result;
	}

}
