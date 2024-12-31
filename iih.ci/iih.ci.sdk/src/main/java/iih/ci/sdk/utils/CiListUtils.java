package iih.ci.sdk.utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 
 * @author wangqingzhu
 *
 */
public class CiListUtils {

	public static boolean isEmpty(Object obj) {
		return null == obj;
	}
	
	public static boolean isEmpty(Object[] szObj) {
		return null == szObj || szObj.length == 0; 
	}
	
	public static boolean IsEmpty(Collection<?> cln) {
		return null == cln || cln.size() == 0;
	}
	
	public static <T> List<T> asList(T[] szObj){
		return Arrays.asList(szObj);
	}
	
}
