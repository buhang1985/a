package iih.bd.base.utils;

import xap.mw.core.utils.StringUtil;

/**
 * 字符串工具类
 * 
 * @author hao_wu
 *
 */
public class StringUtils {

	/**
	 * 字符串不为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		return org.apache.commons.lang.StringUtils.isNotEmpty(str);
	}

	/**
	 * 串联字符串数组的所有元素，其中在每个元素之间使用指定的分隔符。
	 * 
	 * @param separator
	 *            要用作分隔符的字符串。
	 * @param value
	 *            一个数组，其中包含要连接的元素。
	 * @return 一个由 value 中的元素组成的字符串，这些元素以 separator 字符串分隔。
	 */
	public static String join(String separator, String[] value) {
		if (value == null || value.length <= 0) {
			return null;
		}
		StringBuilder stringBuilder = new StringBuilder(value[0]);
		for (int i = 1; i < value.length; i++) {
			stringBuilder.append(separator);
			stringBuilder.append(value[i]);
		}
		return stringBuilder.toString();
	}

	/**
	 * 全角转半角
	 * @param str
	 * @return
	 * @author ly 2018/09/12
	 */
	public static String full2Half(String str) {
		if (StringUtil.isEmpty(str)) {
			return str;
		}

		char[] charArray = str.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == 12288) {
				charArray[i] = ' ';
			} else if (charArray[i] >= 65281 && charArray[i] <= 65374) {
				charArray[i] = (char) (charArray[i] - 65248);
			} 
		}

		return new String(charArray);
	}
	
	/**
	 * 半角转全角
	 * @param str
	 * @return
	 * @author ly 2018/09/12
	 */
	public static String half2Full(String str) {
		if (StringUtil.isEmpty(str)) {
			return str;
		}

		char[] charArray = str.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == ' ') {
				charArray[i] = 12288;
			} else if (charArray[i] >= 33 && charArray[i] <= 126) {
				charArray[i] = (char) (charArray[i] + 65248);
			} 
		}

		return new String(charArray);
	}
}
