package iih.ei.std.cr_technology.v1.s.bp;

import iih.bd.utils.CommDAFacade;
import iih.ei.std.cr_technology.v1.d.PivasBaseParamBean;
import iih.ei.std.cr_technology.v1.d.PivasFindDrugDicResultBeanInfoDt;
import iih.ei.std.cr_technology.v1.s.bp.qry.PivasFindDrugDicQry;
import xap.mw.core.data.BizException;

/**
 * 查询药品字典BP
 * 
 * @author dj.zhang
 *
 */
public class PivasFindDrugDicBp {

	public PivasFindDrugDicResultBeanInfoDt[] exec(PivasBaseParamBean paramBean) throws BizException {
		PivasFindDrugDicQry qry = new PivasFindDrugDicQry();
		PivasFindDrugDicResultBeanInfoDt[] execQuery = CommDAFacade.execQuery(qry, PivasFindDrugDicResultBeanInfoDt.class);
		PivasFindDrugDicResultBeanInfoDt[] result = setNullField(execQuery);
		return result;
	}

	/**
	 * 设置空值
	 * 
	 * @param execQuery
	 * @return
	 */
	private PivasFindDrugDicResultBeanInfoDt[] setNullField(PivasFindDrugDicResultBeanInfoDt[] execQuery) {
		for (PivasFindDrugDicResultBeanInfoDt BeanInfoDt : execQuery) {
			BeanInfoDt.setClass_code("");
			BeanInfoDt.setClass_name("");
		}
		return execQuery;
	}

}
