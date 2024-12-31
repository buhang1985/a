package iih.ei.std.cr_technology.v1.s.bp;

import iih.bd.utils.CommDAFacade;
import iih.ei.std.cr_technology.v1.d.PivasBaseParamBean;
import iih.ei.std.cr_technology.v1.d.PivasFindPharlogyTypeDicResultBeanInfoDt;
import iih.ei.std.cr_technology.v1.s.bp.qry.PivasFindPharlogyTypeDicQry;
import xap.mw.core.data.BizException;

/**
 * 药品药理分类信息BP
 * 
 * @author dj.zhang
 *
 */
public class PivasFindPharlogyTypeDicBp {

	public PivasFindPharlogyTypeDicResultBeanInfoDt[] exec(PivasBaseParamBean paramBean) throws BizException {
		PivasFindPharlogyTypeDicQry qry = new PivasFindPharlogyTypeDicQry();
		PivasFindPharlogyTypeDicResultBeanInfoDt[] result = CommDAFacade.execQuery(qry,
				PivasFindPharlogyTypeDicResultBeanInfoDt.class);
		return result;
	}

}
