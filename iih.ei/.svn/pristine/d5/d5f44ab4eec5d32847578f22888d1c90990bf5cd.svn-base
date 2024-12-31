package iih.ei.std.cr_technology.v1.s.bp;

import iih.bd.utils.CommDAFacade;
import iih.ei.std.cr_technology.v1.d.PivasBaseParamBean;
import iih.ei.std.cr_technology.v1.d.PivasFindPharmacyDicResultBeanInfoDt;
import iih.ei.std.cr_technology.v1.s.bp.qry.PivasFindPharmacyDicQry;
import xap.mw.core.data.BizException;

/**
 * 药局基本信息
 * 
 * @author dj.zhang
 *
 */
public class PivasFindPharmacyDicBp {

	public PivasFindPharmacyDicResultBeanInfoDt[] exec(PivasBaseParamBean paramBean) throws BizException {
		PivasFindPharmacyDicQry qry = new PivasFindPharmacyDicQry();
		PivasFindPharmacyDicResultBeanInfoDt[] result = CommDAFacade.execQuery(qry, PivasFindPharmacyDicResultBeanInfoDt.class);
		return result;
	}

}
