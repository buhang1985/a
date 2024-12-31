package iih.ci.mr.mrname.s.bp.common;

import iih.ci.mr.pub.MrConst.IMrSysParamConst;
import iih.ci.mr.pub.MrConst.IMrSysParamDefaultConst;
import xap.mw.core.data.BizException;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

public class CiMrNameParamUtils {

	/**
	 * 病案文件名称
	 * @param id_org
	 * @return
	 */
	public static String GetMrNameParam(String id_org)
	{
		String strResult = "";
		try {
			strResult = ParamsetQryUtil.getParaString(id_org, IMrSysParamConst.CIMR_NAME);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.CIMR_NAME_DEFAULT;
		}
		return (strResult==null?IMrSysParamDefaultConst.CIMR_NAME_DEFAULT:strResult);	
	}
}
