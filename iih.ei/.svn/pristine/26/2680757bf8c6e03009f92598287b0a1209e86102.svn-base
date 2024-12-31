package iih.ei.std.cr_technology.v1.s.bp;

import iih.bd.utils.CommDAFacade;
import iih.ei.std.cr_technology.v1.d.PivasBaseParamBean;
import iih.ei.std.cr_technology.v1.d.PivasFindDeptDicResultBeanInfoDt;
import iih.ei.std.cr_technology.v1.s.bp.qry.PivasFindDeptDicQry;
import xap.mw.core.data.BizException;

/**
 * 科室基本信息BP
 * 
 * @author dj.zhang
 *
 */
public class PivasFindDeptDicBp {

	public PivasFindDeptDicResultBeanInfoDt[] exec(PivasBaseParamBean paramBean) throws BizException {
		PivasFindDeptDicQry qry = new PivasFindDeptDicQry();
		PivasFindDeptDicResultBeanInfoDt[] result = CommDAFacade.execQuery(qry, PivasFindDeptDicResultBeanInfoDt.class);
		return result;
	}

}
