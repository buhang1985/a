package iih.en.comm.util;

import xap.mw.coreitf.d.FDouble;

/**
 * FDouble帮助类
 * @author yank
 *
 */
public class FDoubleUtils {
	/**
	 * 判断值大于0
	 * @param val
	 * @return
	 */
	public static boolean isMoreThanZero(FDouble val){
		return val!=null && val.compareTo(FDouble.ZERO_DBL)>0;
	}
	/**
	 * 判断值大于0
	 * @param val
	 * @return
	 */
	public static boolean isNotNullOrZero(FDouble val){
		return val!=null && val.doubleValue()!=0;
	}
	/**
	 * 为空或为0
	 * @param val
	 * @return
	 */
	public static boolean isNullOrZero(FDouble val){
		return val==null || val.doubleValue()==0;
	}
	
	/**
	 * 新生儿体重 g转换为Kg
	 * @param val
	 * @return
	 */
	public static FDouble  convertGToKg(FDouble val){
		if(val == null)return null; 
		return val.div(1000);
	}
	
	/**
	 * 新生儿体重 Kg转换为g
	 * @param val
	 * @return
	 */
	public static FDouble  convertKgToG(FDouble val){
		if(val == null)return null; 
		return val.multiply(1000);
	}
}
