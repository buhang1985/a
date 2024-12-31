package iih.bl.comm.util;

/**
 * 发票票号字符串处理工具
 * (原bl.inc下工具提出方法)
 * @author ly 2019/04/15
 *
 */
public class BlIncNumStrUtil {

	/**
	 * 补零
	 * @param lenth
	 * @param str
	 * @return
	 */
	public static String addZero(int lenth, String str) {
		int k=lenth - str.length();
		for (int i = 0; i < k ; i++) {
			str = "0" + str;
		}
		return str;
	}
	
	/**
	 * 分隔字母与数字部分
	 * @param incno
	 * @return
	 */
	public static String[] splitComputable(String incno){
		int splitIndex = -1;
		char[] c = incno.toCharArray();
		for (int i = c.length - 1; i >= 0; i--) {
			//遇到字母则分割
			if((int)c[i] < 48 || (int)c[i] > 57){
				splitIndex = i;
				break;
			}
			
			//18位长度极限分割
			if(c.length - i > 18){
				splitIndex = i;
				break;
			}
		}
		
		String[] array = new String[2];
		array[0] = incno.substring(0, splitIndex + 1);
		array[1] = incno.substring(splitIndex + 1, incno.length());
		
		return array;
	}
	
}
