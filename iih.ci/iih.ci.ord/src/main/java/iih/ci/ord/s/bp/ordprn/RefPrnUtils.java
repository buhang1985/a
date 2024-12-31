package iih.ci.ord.s.bp.ordprn;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
/**
 * 医嘱单打印通过反射的操作
 * @author zhangwq
 *
 */
public class RefPrnUtils {
	/**
	 * 
	 * @code 
	 * @author Zhangwq
	 * @date 2019年5月9日,下午8:20:12
	 * @param param 方法入参
	 * @param classname 类路径
	 * @param method 方法名
	 * @return
	 * @throws Exception
	 */
	public static Object ReflectMethodInvoke(Object param0,Object param1, String classname, String method) throws Exception {
		Class<?> rule = Class.forName(classname);
		Method getCodeMethod = rule.getMethod(method, param0.getClass(),param1.getClass());
		Constructor ruleConstructor = rule.getConstructor();
		Object ruleObj = ruleConstructor.newInstance();
		return getCodeMethod.invoke(ruleObj, param0,param1);
	}
}
