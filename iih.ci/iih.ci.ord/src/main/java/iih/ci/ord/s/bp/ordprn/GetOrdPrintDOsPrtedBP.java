package iih.ci.ord.s.bp.ordprn;

import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
import iih.ci.ord.dto.ordprintdto.d.OrdPrintParamDTO;
import iih.ci.ord.ordprn.d.OrdPrintDO;
import iih.ci.ord.s.bp.ordprn.qry.GetOrdPrintDOsPrtedQry;
import iih.ci.ord.s.bp.ordprn.ref.DefaultOrdPrintContentAssembleBP;

/**
 * 查询已打印的数据
 * @author Young
 *
 */
public class GetOrdPrintDOsPrtedBP {
	public OrdPrintDO[] exec(OrdPrintParamDTO paramDTO) throws BizException {
		if (paramDTO == null)
			return null;
		
		GetOrdPrintDOsPrtedQry qry = new GetOrdPrintDOsPrtedQry(paramDTO);
		OrdPrintDO[] rtn = (OrdPrintDO[]) AppFwUtil.getDORstWithDao(qry, OrdPrintDO.class);
		
		for (OrdPrintDO ordPrintDO : rtn) {
			ordPrintDO.setLabel_name_emp_sign(DefaultOrdPrintContentAssembleBP.STR_POSSIGNMODE_DOCTOR);
			ordPrintDO.setLabel_name_emp_check(DefaultOrdPrintContentAssembleBP.STR_POSSIGNMODE_NURSE);
			ordPrintDO.setStr_name_emp_sign(ordPrintDO.getStr_emp_sign());
			ordPrintDO.setStr_name_emp_check(ordPrintDO.getStr_emp_check());
		}
		
		return rtn;
	}
}
