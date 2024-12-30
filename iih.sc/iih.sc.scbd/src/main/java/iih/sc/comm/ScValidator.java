package iih.sc.comm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import iih.sc.comm.exception.ArgumentNullException;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;

/**
 * 就诊验证器
 * @author yank
 *
 */
public final class ScValidator {
	/**
	 * 验证参数
	 * @param paramName 参数名
	 * @param paramValue 参数值
	 * @throws BizException
	 */
	public static void validateParam(String paramName,Object paramValue) throws BizException{
		if(isNullOrEmpty(paramValue)){
			throw new ArgumentNullException(paramName);
		}
	}
	
	/**
	 * 验证参数
	 * @param methodName 方法名
	 * @param paramName 参数名
	 * @param paramValue 参数值
	 * @throws BizException
	 */
	public static void validateParam(String methodName,String paramName,Object paramValue) throws BizException{
		if(isNullOrEmpty(paramValue)){
			throw new ArgumentNullException(methodName,paramName,null);
		}
	}
	
	/**
	 * 验证参数
	 * @param methodName 方法名
	 * @param paramName 参数名
	 * @param paramDesc 参数描述
	 * @param paramValue 参数值
	 * @throws BizException
	 */
	public static void validateParam(String methodName,String paramName,String paramDesc,Object paramValue) throws BizException{
		if(isNullOrEmpty(paramValue)){
			throw new ArgumentNullException(methodName,paramName,paramDesc);
		}
	}
	/**
	 * 是否为null或空
	 * @param paramValue
	 * @return
	 */
	public static boolean isNullOrEmpty(Object paramValue){
		if(paramValue==null){
			return true;
		}
		//字符串
		if(String.class.isInstance(paramValue)){
			return paramValue.toString().trim().length()<=0;
		}
		//数组
		if(paramValue.getClass().isArray()){
			if(((Object[])paramValue).length<=0){
				return true;
			}
		}
		//FArrayList
		if(FArrayList.class.isInstance(paramValue)){
			if(((FArrayList)paramValue).size()<=0){
				return true;
			}
		}
		return false;
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
     * 判断字符串是否为非空(包含null与"") 
     * @param str 
     * @return 
     */  
    public static boolean isNotEmpty(String str){  
        if(str == null || "".equals(str))  
            return false;  
        return true;  
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
      
    /** 
     * 判断字符串是否为空(包含null与"") 
     * @param str 
     * @return 
     */  
    public static boolean isEmpty(String str){  
        if(str == null || "".equals(str))  
            return true;  
        return false;  
    }  
      
    /** 
     * 判断字符串是否为空(包含null与"","    ") 
     * @param str 
     * @return 
     */  
    public static boolean isEmptyIgnoreBlank(String str){  
        if(str == null || "".equals(str) || "".equals(str.trim()))  
            return true;  
        return false;  
    }  
    /**
     * 验证号源池
     * @param polcn 号源池
     * @throws BizException
     */
    public static void validatPolcn(Integer polcn) throws BizException{
		if(polcn==null || polcn<0 || polcn>10){
			throw new BizException(IScMsgConst.ERROR_SC_SCH_POLCN_OUT_OF_RANGE);
		}	
    }
    /*
     * 私有构造函数
     */
    private ScValidator(){
    	
    }
}
