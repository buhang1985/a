package iih.bd.srv.s.bp;

import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;

public class BdSrvUtils {

	/**
	 * 数组对象为空
	 * @param objs
	 * @return
	 */
	public static boolean isEmpty(Object obj){
		if(obj==null)return true;
		return false;
	}
	
	/**
	 * 数组对象为空
	 * @param objs
	 * @return
	 */
	public static boolean isEmpty(Object[] objs){
		if(objs==null || objs.length==0)return true;
		return false;
	}
	
	/**
	 * Map列表为空
	 * @param objs
	 * @return
	 */
	public static boolean isEmpty(FMap map){
		if(map==null || map.size()==0)return true;
		return false;
	}
	
	/**
	 * 数组列表为空
	 * @param objs
	 * @return
	 */
	public static boolean isEmpty(FArrayList list){
		if(list==null || list.size()==0)return true;
		return false;
	}
	
	/**
	 * 是否为空串判断
	 * @param input
	 * @return
	 */
	public static boolean isEmpty(String input){
		
		return StringUtils.isBlank(input);
	}
}

