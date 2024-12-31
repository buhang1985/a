package iih.ci.rcm.s.bp.common;

import iih.ci.mr.pub.MrConst.IMrSysParamConst;
import iih.ci.mr.pub.MrConst.IMrSysParamDefaultConst;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

public class CiRcmParamUtils {
	/**
	 * 传染病保存通知手机号集合，多个以逗号分隔
	 * 
	 * @param id_org
	 * @return
	 */
	public static String GetSysParamCardContagionSendMobile(String id_org) {
		try {
			return ParamsetQryUtil.getParaString(id_org,
					IMrSysParamConst.SYS_PARAM_CARD_CONTAGIONSENDMOBILE);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_CARD_CONTAGIONSENDMOBILE_DEFAULT;
		}
	}
	
	/**
	 * 获取传染病附卡艾滋病卡确认检测单位
	 * 
	 * @param id_org
	 * @return
	 */
	public static String GetSysParaContagionAidsUnit(String id_org) {
		String strResult = "";
		try {
			strResult = ParamsetQryUtil.getParaString(id_org,IMrSysParamConst.SYS_PARAM_CONTAGION_AIDS_UNIT);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_CONTAGION_AIDS_UNIT_DEFAULT;
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_CONTAGION_AIDS_UNIT_DEFAULT
				: strResult);
	}
	
	/**
	 * 获取传染漏报定点刷新时间
	 * 
	 * @param id_org
	 * @return
	 */
	public static String getSysParaConPassFixedTime(String id_org) {
		String strResult = "";
		try {
			strResult = ParamsetQryUtil.getParaString(id_org,IMrSysParamConst.SYS_PARAM_CONPASS_FIXEDTIME);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_CONPASS_FIXEDTIME_DEFAULT;
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_CONPASS_FIXEDTIME_DEFAULT
				: strResult);
	}
	
	/**
	 * 获取传染漏报刷新间隔时间
	 * 
	 * @param id_org
	 * @return
	 */
	public static String getSysParaConPassIntervalTime(String id_org) {
		String strResult = "";
		try {
			strResult = ParamsetQryUtil.getParaString(id_org,IMrSysParamConst.SYS_PARAM_CONPASS_INTERVALTIME);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_CONPASS_INTERVALTIME_DEFAULT;
		}
		return (strResult == null ? IMrSysParamDefaultConst.SYS_PARAM_CONPASS_INTERVALTIME_DEFAULT
				: strResult);
	}
	
	/**
	 * 获取传染漏报是否启用动刷新
	 * @param id_org
	 * @return
	 */
	public static Boolean getSysParaConPassRefrushActive(String id_org) {
		FBoolean result = FBoolean.TRUE;
		try {
			result = ParamsetQryUtil.getParaBoolean(id_org,IMrSysParamConst.SYS_PARAM_CONPASS_REFRUSHACTIVE);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_CONPASS_REFRUSHACTIVE_DEFAULT;
		}

		return result.booleanValue();
	}
	
	/**
	 * 获取死亡报卡医院邮编
	 * @param id_org
	 * @return
	 */
	public static String getSysParaAdminCode(String id_org) {
		String strResult = "";
		try {
			strResult = ParamsetQryUtil.getParaString(id_org,IMrSysParamConst.SYS_PARAM_RCM_ADMINCODE);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_RCM_ADMINCODE_DEFAULT;
		}

		return strResult;
	}
	
	/**
	 * 获取死亡报卡编码前缀
	 * @param id_org
	 * @return
	 */
	public static String getSysParaPrefixCode(String id_org) {
		String strResult = "";
		try {
			strResult = ParamsetQryUtil.getParaString(id_org,IMrSysParamConst.SYS_PARAM_RCM_PREFIXCODE);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_RCM_PREFIXCODE_DEFAULT;
		}

		return strResult;
	}
	
}
