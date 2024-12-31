package iih.ei.std.cr_technology.v1.s.bp;

import iih.bd.utils.CommDAFacade;
import iih.ei.std.cr_technology.v1.d.PivasBaseParamBean;
import iih.ei.std.cr_technology.v1.d.PivasFindPatDicResultBeanInfoDt;
import iih.ei.std.cr_technology.v1.s.bp.qry.PivasFindPatDicQry;
import xap.mw.core.data.BizException;

/**
 * 在院病人基本信息接口BP
 * 
 * @author dj.zhang
 *
 */
public class PivasFindPatDicBp {

	public PivasFindPatDicResultBeanInfoDt[] exec(PivasBaseParamBean paramBean) throws BizException {
		PivasFindPatDicQry qry = new PivasFindPatDicQry();
		PivasFindPatDicResultBeanInfoDt[] result = CommDAFacade.execQuery(qry, PivasFindPatDicResultBeanInfoDt.class);
		return result;
	}

}
