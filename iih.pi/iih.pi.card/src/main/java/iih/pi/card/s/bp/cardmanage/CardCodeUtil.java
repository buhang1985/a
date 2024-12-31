package iih.pi.card.s.bp.cardmanage;

import xap.mw.core.utils.StringUtil;

/**
 * 卡号拆分util类
 * @author ly
 *
 */
public class CardCodeUtil {

	private static final int MAX_DIGIT = 9;
	
	/**
	 * 卡号拆分
	 * @param code
	 * @return
	 */
	public static String[] subString(String code){
		
		String[] strs = new String[]{"",""};
		
		if(StringUtil.isEmpty(code))
			return strs;
		
		if(code.length() < MAX_DIGIT)
		{
			strs[1] = code;
			return strs;
		}
		
		strs[0] = code.substring(0, code.length() - MAX_DIGIT);
		strs[1] = code.substring(code.length() - MAX_DIGIT, code.length());
		
		return strs;
	}
}
