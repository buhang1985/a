package iih.ei.std.cr_technology.v1.s.bp;

import iih.bd.utils.CommDAFacade;
import iih.ei.std.cr_technology.v1.d.PivasBaseParamBean;
import iih.ei.std.cr_technology.v1.d.PivasFindPharmStockDicResultBeanInfoDt;
import iih.ei.std.cr_technology.v1.s.bp.qry.PivasFindPharmStockDicQry;
import xap.mw.core.data.BizException;

/**
 * 药局(房)库存基本信息
 * 
 * @author dj.zhang
 *
 */
public class PivasFindPharmStockDicBp {

	public PivasFindPharmStockDicResultBeanInfoDt[] exec(PivasBaseParamBean paramBean) throws BizException {
		PivasFindPharmStockDicQry qry = new PivasFindPharmStockDicQry();
		PivasFindPharmStockDicResultBeanInfoDt[] result = CommDAFacade.execQuery(qry,
				PivasFindPharmStockDicResultBeanInfoDt.class);
		return result;
	}

}
