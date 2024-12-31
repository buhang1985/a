package iih.bd.base.utils;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;

/**
 * FDouble帮助类
 * 
 * @author yankan
 *
 */
public class FDoubleUtils {
	/**
	 * 判断值大于0
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isMoreThanZero(FDouble val) {
		return val != null && val.compareTo(FDouble.ZERO_DBL) > 0;
	}

	/**
	 * 判断值大于1
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isMoreThanOne(FDouble val) {
		return (val != null && val.compareTo(FDouble.ONE_DBL) > 0);
	}

	/**
	 * 判断非空或0
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isNotNullOrZero(FDouble val) {
		return val != null && val.doubleValue() != 0;
	}

	/**
	 * 为空或为0
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isNullOrZero(FDouble val) {
		return val == null || val.doubleValue() == 0;
	}
	
	/**
	 * 对比两个FDouble值大小
	 * @param a
	 * @param b
	 * @throws BizException
	 */
	public static int compareFDouble(FDouble a,FDouble b) throws BizException{
		
		if(a == null || b == null){
			throw new BizException("无效数字");
		}
			
		if(isEqualWithTwoFDouble(a,b))
			return 0;
		
		return a.compareTo(b);
	}
	
	/**
	 * 对比两个FDouble值是否相等
	 * @param a
	 * @param b
	 * @return
	 * @throws BizException
	 * @author ly
	 */
	public static boolean isEqualWithTwoFDouble(FDouble a,FDouble b) throws BizException{
		
		if(a == null || b == null)
			return false;
		
		return Math.abs(a.sub(b).doubleValue()) <= 0.00000001;
	}
	
	/**
	 * 对比两个double值是否相等
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @throws BizException
	 * @author ly
	 */
	public static boolean isEqualWithTwoFDouble(Double a,Double b) throws BizException{
		if(a == null || b == null)
			return false;
		
		return Math.abs(a - b) <= 0.00000001;
	}
	
	/**
	 * null转零
	 * @param a
	 * @return
	 * @throws BizException
	 * @author ly
	 */
	public static FDouble nullToZero(FDouble a) throws BizException{
		return a == null ? FDouble.ZERO_DBL : a;
	}
}
