package iih.pe.comm.utils;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.agg.IAggDO;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.i.IBaseDO;

/**
 * 就诊验证器
 * @author yank
 *
 */
public final class PeValidator {
    /** 
     * 判断字符串(trim后)是否为空
     * @param str 
     * @return 
     */  
    public static boolean isEmpty(String str){  
        return StringUtil.isEmpty(str);
    }   
    /**
     * 判定Map是否为空
     * 
     * @param map
     * @return
     */
	public static <K, V> boolean isEmpty(Map<K, V> map) {
		return ((map == null) || (map.isEmpty()));
	}
	/**
	 * 判定List是否为空
	 * 
	 * @param list
	 * @return
	 */
	public static <T> boolean isEmpty(List<T> list){
		return ListUtil.isEmpty(list);
	}
	/**
	 * 判定数组是否为空
	 * 
	 * @param array
	 * @return
	 */
	public static boolean isEmpty(Object[] array) {
		return ArrayUtil.isEmpty(array);
	}
	/**
	 * 判定AggDO是否为空
	 * 
	 * @param agg
	 * @return
	 */
	public static boolean isEmpty(IAggDO agg) {
		return agg == null;
	}
	/**
	 * 判定DO/DTO是否为空
	 * 
	 * @param baseDo
	 * @return
	 */
	public static boolean isEmpty(IBaseDO baseDo) {
		return baseDo == null;
	}
	/**
	 * 判定FDateTime是否为空
	 * 
	 * @param dateTime
	 * @return
	 */
	public static boolean isEmpty(FDateTime dateTime) {
		return dateTime == null;
	}
	/**
	 * 判定FDate是否为空
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isEmpty(FDate date) {
		return date == null;
	}
	
    /** 
     * 判断是否为浮点数或者整数 
     * @param str 
     * @return true Or false 
     */  
    public static boolean isNumeric(String str){  
          Pattern pattern = Pattern.compile("^(-?\\d+)(\\.\\d+)?$");  
          Matcher isNum = pattern.matcher(str);  
          if( !isNum.matches() ){  
                return false;  
          }  
          return true;  
    } 
    /** 
     * 判断是否为正确的邮件格式 
     * @param str 
     * @return boolean 
     */  
    public static boolean isEmail(String str){  
        if(isEmpty(str))  
            return false;  
        return str.matches("^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$");  
    }  
      
    /** 
     * 判断字符串是否为合法手机号 11位 13 14 15 18开头 
     * @param str 
     * @return boolean 
     */  
    public static boolean isMobile(String str){  
        if(isEmpty(str))  
            return false;  
        return str.matches("^(13|14|15|18)\\d{9}$");  
    }  
    /** 
     * 判断是否为数字 
     * @param str 
     * @return 
     */  
    public static boolean isNumber(String str) {  
        try{  
            Integer.parseInt(str);  
            return true;  
        }catch(Exception ex){  
            return false;  
        }  
    }  
	/**
	 * 是否为null或空
	 * @param paramValue
	 * @return
	 */
	private static boolean isNullOrEmpty(Object paramValue){
		if(paramValue==null){
			return true;
		}
		//字符串
		if(String.class.isInstance(paramValue)){
			return isEmpty((String)paramValue);
		}
		//数组
		if(paramValue.getClass().isArray()){
			return isEmpty((Object[])paramValue);
		}
		//FArrayList
		if(FArrayList.class.isInstance(paramValue)){
			return isEmpty((FArrayList)paramValue);
		}
		return false;
	}
	/** 
     * 判断字符串是否为非空(包含null与"","    ") 
     * @param str 
     * @return 
     */  
    public static boolean isNotEmptyIgnoreBlank(String str){  
        if(str == null || "".equals(str) || "".equals(str.trim()))  
            return false;  
        return true;  
    } 
}
