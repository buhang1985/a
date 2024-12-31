package iih.ci.mr.mrbrowse.s.bp.common;

import iih.ci.mr.pub.MrConst.IMrSysParamConst;
import iih.ci.mr.pub.MrConst.IMrSysParamDefaultConst;
import xap.mw.core.data.BizException;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

public class CiMrBrowseParamUtils {

	/**
	 * 未归档病历浏览可查看状态
	 * @param id_org
	 * @return
	 */
	public static String GetSysParamNoArchive(String id_org)
	{
		String strResult = "";
		try {
			strResult = ParamsetQryUtil.getParaString(id_org, IMrSysParamConst.SYS_PARAM_MR_NOARCHIVE);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MR_NOARCHIVE_DEFAULT;
		}
		return (strResult==null?IMrSysParamDefaultConst.SYS_PARAM_MR_NOARCHIVE_DEFAULT:strResult);	
	}
	
	/**
	 * 归档后病历浏览可查看状态
	 * @param id_org
	 * @return
	 */
	public static String GetSysParamArchived(String id_org)
	{
		String strResult = "";
		try {
			strResult = ParamsetQryUtil.getParaString(id_org, IMrSysParamConst.SYS_PARAM_MR_ARCHIVED);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_MR_ARCHIVED_DEFAULT;
		}
		return (strResult==null?IMrSysParamDefaultConst.SYS_PARAM_MR_ARCHIVED_DEFAULT:strResult);	
	}
}
