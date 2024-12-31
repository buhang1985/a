package iih.ci.sdk.utils;

import xap.mw.coreitf.d.FBoolean;

public class BooleanUtils {

	public static boolean IsTrue(FBoolean flg) {
		return FBoolean.TRUE.equals(flg);
	}
}
