package iih.ci.sdk.utils;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;

/**
 * 简单工具类
 * @author wangqingzhu
 *
 */
public class CiBizUtils {
	/**
	 * 是否门急诊
	 * 
	 * @param sd_entp
	 * @return
	 */
	public static boolean isOpUrgentWf(String sd_entp) {
		if (StringUtils.isEmpty(sd_entp))
			return false;
		if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(sd_entp)
				|| IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(sd_entp))
			return true;
		return false;

	}

	/**
	 * 是否门诊
	 * 
	 * @param sd_entp
	 * @return
	 */
	public static boolean isOpWf(String sd_entp) {
		if (StringUtils.isEmpty(sd_entp))
			return false;
		if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(sd_entp))
			return true;
		return false;

	}

	/**
	 * 是否急诊
	 * 
	 * @param sd_entp
	 * @return
	 */
	public static boolean isUrgentWf(String sd_entp) {
		if (StringUtils.isEmpty(sd_entp))
			return false;
		if (IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(sd_entp))
			return true;
		return false;

	}

	/**
	 * 是否住院
	 * 
	 * @param sd_entp
	 * @return
	 */
	public static boolean isIpWf(String sd_entp) {
		if (StringUtils.isEmpty(sd_entp))
			return false;
		if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(sd_entp))
			return true;
		return false;
	}
}
