package iih.ei.std.cr_technology.v1.s.bp;

import iih.bd.utils.CommDAFacade;
import iih.ei.std.cr_technology.v1.d.PivasBaseParamBean;
import iih.ei.std.cr_technology.v1.d.PivasFindDoctorDicResultBeanInfoDt;
import iih.ei.std.cr_technology.v1.s.bp.qry.PivasFindDoctorDicQry;
import xap.mw.core.data.BizException;

/**
 * 医生基本信息
 * 
 * @author dj.zhang
 *
 */
public class PivasFindDoctorDicBp {

	public PivasFindDoctorDicResultBeanInfoDt[] exec(PivasBaseParamBean paramBean) throws BizException {
		PivasFindDoctorDicQry qry = new PivasFindDoctorDicQry();
		PivasFindDoctorDicResultBeanInfoDt[] result = CommDAFacade.execQuery(qry,
				PivasFindDoctorDicResultBeanInfoDt.class);
		return result;
	}

}
