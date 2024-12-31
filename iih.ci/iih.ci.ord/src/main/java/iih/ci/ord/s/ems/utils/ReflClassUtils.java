package iih.ci.ord.s.ems.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.mysql.jdbc.StringUtils;

import iih.bd.base.cache.ContextCache;
import iih.ci.ord.ems.d.CiEnContextDTO;
import xap.mw.core.data.BizException;

/**
 * 类反射工具
 * 
 * @author wangqingzhu
 *
 */
public class ReflClassUtils extends ContextCache {

	public static <T> T ReflCallWith(String classString, String methodString, Object ctx, Class<?> paramClass,
			Object param) throws BizException {
		if(StringUtils.isNullOrEmpty(classString)){
			throw new BizException("未匹配到医疗单，请检查医嘱单维护是否正确");
		}
		try {
			Class<?> classBP = Class.forName(classString);
			Object objBP = classBP.newInstance();
			Method saveMethod = classBP.getMethod(methodString, CiEnContextDTO.class, paramClass);
			return (T) saveMethod.invoke(objBP, ctx, param);
		} catch (ClassNotFoundException e) {  
			throw new BizException(String.format("后台驱动：【%s.%s】类定义没有找到, 请检查后台医疗单驱动部署信息", classString, methodString)); 
        } catch (SecurityException e) {  
        	throw new BizException(String.format("后台驱动：【%s.%s】存在安全隐患, 请检查后台医疗单驱动部署信息", classString, methodString));
        } catch (NoSuchMethodException e) {  
        	throw new BizException(String.format("后台驱动：【%s.%s】不存在此方法, 请检查后台医疗单驱动部署信息", classString, methodString)); 
        } catch (IllegalArgumentException e) {  
        	throw new BizException(String.format("后台驱动：【%s.%s】方法参数错误, 请检查后台医疗单驱动部署信息", classString, methodString)); 
        } catch (IllegalAccessException e) {  
        	throw new BizException(String.format("后台驱动：【%s.%s】访问方式错误, 请检查后台医疗单驱动部署信息", classString, methodString)); 
        } catch (InvocationTargetException e) {  
            Throwable t = e.getTargetException();// 获取目标异常  
            throw new BizException( t);
        } catch (InstantiationException e) {  
        	throw new BizException(String.format("后台驱动：【%s】构造方法错误, 请检查后台医疗单驱动部署信息", classString));
        }  
	}
}
