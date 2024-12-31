package iih.bd.base.validator;

import iih.bd.base.exception.ArgumentNullException;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;

/**
 * 参数校验
 * @author yankan
 *
 */
public class ParamValidator {
	/**
	 * 验证参数
	 * @param paramName 参数名
	 * @param paramValue 参数值
	 * @throws BizException
	 */
	public static void validateNotNull(String paramName,Object paramValue) throws BizException{
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
	public static void validateNotNull(String methodName,String paramName,Object paramValue) throws BizException{
		if(isNullOrEmpty(paramValue)){
			throw new ArgumentNullException(methodName,paramName);
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
}
