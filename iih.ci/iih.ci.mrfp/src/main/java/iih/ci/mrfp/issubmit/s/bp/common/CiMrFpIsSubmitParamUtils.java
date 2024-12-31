package iih.ci.mrfp.issubmit.s.bp.common;

import iih.ci.mr.pub.MrConst.IMrSysParamConst;
import iih.ci.mr.pub.MrConst.IMrSysParamDefaultConst;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

public class CiMrFpIsSubmitParamUtils {

	/**
	 * 病案首页是否需要提交
	 * @param id_org
	 * @return
	 */
	public static Boolean GetIsSubmitParam(String id_org)
	{
		FBoolean result = FBoolean.TRUE;
		try {
			result = ParamsetQryUtil.getParaBoolean(id_org, IMrSysParamConst.CIMRFP_IS_SUBMIT);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.CIMRFP_IS_SUBMIT;
		}
		return result.booleanValue();
	}
}
