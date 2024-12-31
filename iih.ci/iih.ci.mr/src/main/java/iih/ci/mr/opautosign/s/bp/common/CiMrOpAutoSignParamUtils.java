package iih.ci.mr.opautosign.s.bp.common;

import iih.ci.mr.pub.MrConst.IMrSysParamConst;
import iih.ci.mr.pub.MrConst.IMrSysParamDefaultConst;
import xap.mw.core.data.BizException;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

public class CiMrOpAutoSignParamUtils {

	/**
	 * 门诊自动签名方式
	 * @param id_org
	 * @return
	 */
	public static String GetSysParamOpAutoSign(String id_org)
	{
		String strResult = "";
		try {
			strResult = ParamsetQryUtil.getParaString(id_org, IMrSysParamConst.SYS_PARAM_MR_OPAUTOSIGN);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MR_OPAUTOSIGN_DEFAULT;
		}
		return (strResult==null?IMrSysParamDefaultConst.SYS_PARAM_MR_OPAUTOSIGN_DEFAULT:strResult);	
	}
}
