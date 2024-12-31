package iih.mm.util;

/**
 * 字符工具包
 * 
 * @author hao_wu
 *
 */
public class CharUtil {
	/**
	 * 是数字
	 * 
	 * @param ch
	 * @return
	 */
	public static boolean isDigital(char ch) {
		return ch >= '0' && ch <= '9';
	}

	/**
	 * 是大写字母
	 * 
	 * @param ch
	 * @return
	 */
	public static boolean isUppercase(char ch) {
		return ch >= 'A' && ch <= 'Z';
	}

	/**
	 * 是小写字母
	 * 
	 * @param ch
	 * @return
	 */
	public static boolean isLowercase(char ch) {
		return ch >= 'a' && ch <= 'z';
	}

}
