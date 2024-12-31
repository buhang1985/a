package iih.ei.std.d.v1.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
/**
 * 临床域对方复制
 * @author zhangwq
 *
 */
public class CiOrdUtils {
	/***
	 * 通过类的方法进行赋值
	 * 
	 * @param from
	 * @param to
	 */
	public static void copyObjectByMethod(Object from, Object to) {
		Class fclass = from.getClass();
		Class tclass = to.getClass();
		Field[] cFields = tclass.getDeclaredFields();
		Method[] fmethods = fclass.getDeclaredMethods();
		try {
			for (Method fmd : fmethods) {
				String fname = fmd.getName();
				if (fname.startsWith("get")) {
					Object fvalue = fmd.invoke(from);
					Method tmethod = tclass.getMethod("set" + fname.substring(3), fvalue.getClass());
					if (tmethod == null)
						continue;
					tmethod.invoke(to, fvalue);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
