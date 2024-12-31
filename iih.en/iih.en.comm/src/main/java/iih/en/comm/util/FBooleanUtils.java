package iih.en.comm.util;

import xap.mw.coreitf.d.FBoolean;

/**
 * FBoolean的帮助类
 * @author yank
 *
 */
public class FBooleanUtils {
	/**
	 * 是否为空或false
	 * @param fb
	 * @return
	 */
	public static boolean isNullOrFalse(FBoolean fb){
		return fb ==null || FBoolean.FALSE.equals(fb);
	}
	/**
	 * 是否为true
	 * @param fb
	 * @return
	 */
	public static boolean isTrue(FBoolean fb){
		return FBoolean.TRUE.equals(fb);
	}
}
