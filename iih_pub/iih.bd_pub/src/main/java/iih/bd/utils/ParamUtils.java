package iih.bd.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 参数工具类
 * 
 * @author hao_wu
 *
 */
public class ParamUtils {

	/**
	 * 获取组织参数字符串值
	 * 
	 * @param orgId     组织ID
	 * @param paramCode 参数编码
	 * @return 参数值
	 * @throws BizException
	 */
	public static String getOrgParamStringValue(String orgId, String paramCode) throws BizException {
		try {
			String paramValue = ParamsetQryUtil.getParaString(orgId, paramCode);
			return paramValue;
		} catch (BizException e) {
			throw e;
		} catch (Exception e) {
			String msg = getParamErrorMsg(paramCode);
			throw new BizException(msg, e);
		}
	}

	/**
	 * 获取组织参数字符串值
	 * 
	 * @param paramCode 参数编码
	 * @return 参数值
	 * @throws BizException
	 */
	public static String getOrgParamStringValue(String paramCode) throws BizException {
		String paramValue = getOrgParamStringValue(Context.get().getOrgId(), paramCode);
		return paramValue;
	}

	/**
	 * 获取组织参数逻辑值
	 * 
	 * @param orgId     组织ID
	 * @param paramCode 参数编码
	 * @return 参数值
	 * @throws BizException
	 */
	public static FBoolean getOrgParamFBooleanValue(String orgId, String paramCode) throws BizException {
		try {
			FBoolean paramValue = ParamsetQryUtil.getParaBoolean(orgId, paramCode);
			return paramValue;
		} catch (BizException e) {
			throw e;
		} catch (Exception e) {
			String msg = getParamErrorMsg(paramCode);
			throw new BizException(msg, e);
		}
	}

	/**
	 * 获取组织参数逻辑值
	 * 
	 * @param paramCode 参数编码
	 * @return 参数值
	 * @throws BizException
	 */
	public static FBoolean getOrgParamFBooleanValue(String paramCode) throws BizException {
		FBoolean paramValue = getOrgParamFBooleanValue(Context.get().getOrgId(), paramCode);
		return paramValue;
	}

	/**
	 * 获取参数失败消息
	 * 
	 * @param paramCode 参数编码
	 * @return
	 */
	private static String getParamErrorMsg(String paramCode) {
		return String.format("参数\"%s\"获取失败。", paramCode);
	}

	/**
	 * 获取组织参数整型值
	 * 
	 * @param orgId     组织ID
	 * @param paramCode 参数编码
	 * @return 参数值
	 * @throws BizException
	 */
	public static Integer getOrgParamIntegerValue(String orgId, String paramCode) throws BizException {
		try {
			Integer paramValue = ParamsetQryUtil.getParaInt(orgId, paramCode);
			return paramValue;
		} catch (BizException e) {
			throw e;
		} catch (Exception e) {
			String msg = getParamErrorMsg(paramCode);
			throw new BizException(msg, e);
		}
	}

	/**
	 * 获取组织参数整型值
	 * 
	 * @param paramCode 参数编码
	 * @return 参数值
	 * @throws BizException
	 */
	public static Integer getOrgParamIntegerValue(String paramCode) throws BizException {
		Integer paramValue = getOrgParamIntegerValue(Context.get().getOrgId(), paramCode);
		return paramValue;
	}

	/**
	 * 获取实体参数字符串型值
	 * 
	 * @param instId    实体主键
	 * @param paramCode 参数编码
	 * @return 参数值
	 * @throws BizException
	 */
	public static String getInstanceParamStringValue(String instId, String paramCode) throws BizException {
		try {
			String paramValue = ParamsetQryUtil.getParaStringByInstance(instId, paramCode);
			return paramValue;
		} catch (BizException e) {
			throw e;
		} catch (Exception e) {
			String msg = getParamErrorMsg(paramCode);
			throw new BizException(msg, e);
		}
	}

	/**
	 * 获取实体参数字符串型值
	 * 
	 * @param instId    实体主键
	 * @param paramCode 参数编码
	 * @return 参数值
	 * @throws BizException
	 */
	public static Integer getInstanceParamIntegerValue(String instId, String paramCode) throws BizException {
		try {
			Integer paramValue = ParamsetQryUtil.getParaIntByInstance(instId, paramCode);
			return paramValue;
		} catch (BizException e) {
			throw e;
		} catch (Exception e) {
			String msg = getParamErrorMsg(paramCode);
			throw new BizException(msg, e);
		}
	}

	/**
	 * 获取实体参数字符串字典型值
	 * 
	 * @param instIds   实体主键集合
	 * @param paramCode 参数编码
	 * @return 参数值
	 * @throws BizException
	 */
	public static Map<String, String> getInstanceParamStringValueMap(String[] instIds, String paramCode)
			throws BizException {
		try {
			Map<String, String> paramValueMap = new HashMap<String, String>();
			for (String instId : instIds) {
				String paramValue = getInstanceParamStringValue(instId, paramCode);
				if (StringUtils.isNotEmpty(paramValue)) {
					paramValueMap.put(instId, paramValue);
				}
			}
			return paramValueMap;
		} catch (BizException e) {
			throw e;
		} catch (Exception e) {
			String msg = getParamErrorMsg(paramCode);
			throw new BizException(msg, e);
		}
	}

	/**
	 * 获取上下文参数FBoolean值
	 * 
	 * @param paramCode 参数编码
	 * @return
	 */
	public static FBoolean getContextParamFBooleanValue(String paramCode) {
		FBoolean paramValue = Context.get().getAttribute(paramCode, FBoolean.class);
		if (paramValue == null) {
			return FBoolean.FALSE;
		}
		return paramValue;
	}

	/**
	 * 设置上下文参数
	 * 
	 * @param paramCode  参数编码
	 * @param paramValue 参数值
	 */
	public static void setContextParam(String paramCode, FBoolean paramValue) {
		Context.get().setAttribute(paramCode, paramValue);
	}

	@Deprecated
	public static String GetOrgParamStringValue(String orgId, String paramCode) throws BizException {
		return getOrgParamStringValue(orgId, paramCode);
	}

	@Deprecated
	public static String GetOrgParamStringValue(String paramCode) throws BizException {
		return getOrgParamStringValue(paramCode);
	}

	@Deprecated
	public static FBoolean GetOrgParamFBooleanValue(String orgId, String paramCode) throws BizException {
		return getOrgParamFBooleanValue(orgId, paramCode);
	}

	@Deprecated
	public static FBoolean GetOrgParamFBooleanValue(String paramCode) throws BizException {
		return getOrgParamFBooleanValue(paramCode);
	}

	@Deprecated
	public static Integer GetOrgParamIntegerValue(String orgId, String paramCode) throws BizException {
		return getOrgParamIntegerValue(orgId, paramCode);
	}

	@Deprecated
	public static Integer GetOrgParamIntegerValue(String paramCode) throws BizException {
		return getOrgParamIntegerValue(paramCode);
	}

	@Deprecated
	public static String GetInstanceParamStringValue(String instId, String paramCode) throws BizException {
		return getInstanceParamStringValue(instId, paramCode);
	}

	@Deprecated
	public static Integer GetInstanceParamIntegerValue(String instId, String paramCode) throws BizException {
		return getInstanceParamIntegerValue(instId, paramCode);
	}

	@Deprecated
	public static Map<String, String> GetInstanceParamStringValueMap(String[] instIds, String paramCode)
			throws BizException {
		return getInstanceParamStringValueMap(instIds, paramCode);
	}
}
