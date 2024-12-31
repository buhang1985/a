package iih.ei.std.cr_technology.v1.s.bp;

import iih.bd.utils.CommDAFacade;
import iih.ei.std.cr_technology.v1.d.PivasBaseParamBean;
import iih.ei.std.cr_technology.v1.d.PivasFindPatBedDicResultBeanInfoDt;
import iih.ei.std.cr_technology.v1.s.bp.qry.PivasFindPatBedDicQry;
import xap.mw.core.data.BizException;

/**
 * 在院病人床位基本信息BP
 * 
 * @author dj.zhang
 *
 */
public class PivasFindPatBedDicBp {

	public PivasFindPatBedDicResultBeanInfoDt[] exec(PivasBaseParamBean paramBean) throws BizException {
		PivasFindPatBedDicQry qry = new PivasFindPatBedDicQry();
		PivasFindPatBedDicResultBeanInfoDt[] result = CommDAFacade.execQuery(qry,
				PivasFindPatBedDicResultBeanInfoDt.class);
		return result;
	}

}
