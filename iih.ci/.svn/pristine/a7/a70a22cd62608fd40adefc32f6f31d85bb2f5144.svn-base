package iih.ci.mrfp.zyprint.s.bp.common;

import iih.ci.mr.pub.MrConst.IMrSysParamConst;
import iih.ci.mr.pub.MrConst.IMrSysParamDefaultConst;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

public class CiMrFpPrintParamUtils {

	/**
	 * 病案首页中医打印
	 * @param id_org
	 * @return
	 */
	public static Boolean GetPrintParam(String id_org)
	{
		FBoolean result = FBoolean.FALSE;
		try {
			result = ParamsetQryUtil.getParaBoolean(id_org, IMrSysParamConst.CIMRFP_ZY_PRINT);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.CIMRFP_ZY_PRINT_DEFAULT;
		}
		return result.booleanValue();
	}
}
