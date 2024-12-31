package iih.ci.mrqc.s.bp.common;

import iih.ci.mr.pub.MrConst.IMrSysParamConst;
import iih.ci.mr.pub.MrConst.IMrSysParamDefaultConst;
import iih.ci.mrm.pub.MrMConst.IMrMSysParamConst;
import iih.ci.mrm.pub.MrMConst.IMrMSysParamDefaultConst;
import xap.mw.core.data.BizException;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

public class CiMrQcParamUtils {

	/**
	 * 获取门诊病历召回最大申请天数
	 * @param id_org
	 * @return
	 */
	public static String GetSysParamOpRcMaxDays(String id_org)
	{
		String strResult = "";
		try {
			strResult = ParamsetQryUtil.getParaString(id_org, IMrSysParamConst.SYS_PARAM_OP_RC_MAXDAYS);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_OP_RC_MAXDAYS_DEFAULT;
		}
		return (strResult==null?IMrSysParamDefaultConst.SYS_PARAM_OP_RC_MAXDAYS_DEFAULT:strResult);
		
	}
	
	/**
	 * 获取门诊病历召回默认天数
	 * @param id_org
	 * @return
	 */
	public static String GetSysParamOpRcDefaultDays(String id_org)
	{
		String strResult = "";
		try {
			strResult = ParamsetQryUtil.getParaString(id_org, IMrSysParamConst.SYS_PARAM_OP_RC_DEFAULTDAYS);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_OP_RC_DEFAULTDAYS_DEFAULT;
		}
		return (strResult==null?IMrSysParamDefaultConst.SYS_PARAM_OP_RC_DEFAULTDAYS_DEFAULT:strResult);
		
	}
	
	/**
	 * 病案可召回状态
	 * @param id_org
	 * @return
	 */
	public static String getSysParamRecallStatus(String id_org) {
		String result = "";
		try {
			result = ParamsetQryUtil.getParaString(id_org,IMrMSysParamConst.SYS_PARAM_MRM_RECALL_STATUS);
		} catch (BizException e) {
			return IMrMSysParamDefaultConst.SYS_PARAM_MRM_PRINT_CHARGE_DEFAULT;
		}
		return result;
	}
	
}
