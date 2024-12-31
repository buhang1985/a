package iih.ci.mr.s.util;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import xap.mw.core.data.BizRuntimeException;

/**
 * xml标签解析成javabean属性 工具类
 * @author F
 *
 */
public class XmlToBeanUtil {
	
	public static <T> List<T> xmlToList(String xml,T t){
	    	SAXReader reader = new SAXReader();
	        Method[] methods = t.getClass().getDeclaredMethods();
	        List<T> list=new ArrayList<T>();
	        try {
	        	int len = methods.length;        
	            Document doc=reader.read(new ByteArrayInputStream(xml.getBytes("UTF-8")));
	       	 	Element root=doc.getRootElement();
	       	 	List<Element> eles = root.elements();
	            for (Element book :eles) {
	            	T obj=(T) t.getClass().newInstance();
	                for (int j = 0; j < len; j++) {
	                	if(!methods[j].getName().startsWith("get") && !methods[j].getName().equals("toString")){                		
	                		int mlen = methods[j].getName().length();               		
	                		methods[j].invoke(obj, book.element(methods[j].getName().substring(3, mlen).toLowerCase()).getStringValue());
	                	}
	                }
	                list.add(obj);
	            }
	        }catch(Exception e){
	        	throw new BizRuntimeException("解析错误",e);
	        }
	        return list;
	 }
	
	public static <T> T[] xmlToArray(String xmlstr, T t) {
		List<T> src = (List<T>) xmlToList(xmlstr, t);
		if (src == null || src.isEmpty()) {
			return null;
		}
		
		T[] dest = (T[]) Array.newInstance( t.getClass(), src.size());
		for (int i = 0; i < src.size(); i++) {
			dest[i] = src.get(i);
		}
		return (T[]) dest;
	}
}
