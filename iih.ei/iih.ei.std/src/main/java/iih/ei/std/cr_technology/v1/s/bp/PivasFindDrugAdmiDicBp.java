package iih.ei.std.cr_technology.v1.s.bp;

import iih.bd.utils.CommDAFacade;
import iih.ei.std.cr_technology.v1.d.PivasBaseParamBean;
import iih.ei.std.cr_technology.v1.d.PivasFindDrugAdmiDicResultBeanInfoDt;
import iih.ei.std.cr_technology.v1.s.bp.qry.PivasFindDrugAdmiDicQry;
import xap.mw.core.data.BizException;

/**
 * 给药方式基本信息
 * 
 * @author dj.zhang
 *
 */
public class PivasFindDrugAdmiDicBp {

	public PivasFindDrugAdmiDicResultBeanInfoDt[] exec(PivasBaseParamBean paramBean) throws BizException {
		PivasFindDrugAdmiDicQry qry = new PivasFindDrugAdmiDicQry();
		PivasFindDrugAdmiDicResultBeanInfoDt[] result = CommDAFacade.execQuery(qry,
				PivasFindDrugAdmiDicResultBeanInfoDt.class);
		return result;
	}

}
