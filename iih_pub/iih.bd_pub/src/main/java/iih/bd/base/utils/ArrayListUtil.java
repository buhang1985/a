package iih.bd.base.utils;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.FArrayList;

/**
 * 数组列表公共工具类
 * 
 * @author hao_wu
 *
 */
public class ArrayListUtil {

	/**
	 * 数组转列表
	 * 
	 * @param dataArray
	 * @return
	 */
	public static <T> ArrayList<T> ConvertToArrayList(T[] dataArray) {
		ArrayList<T> list = new ArrayList<T>();
		if (dataArray == null) {
			return list;
		}
		for (T data : dataArray) {
			list.add(data);
		}
		return list;
	}

	/**
	 * 数组转列表
	 * 
	 * @param dataArray
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> FArrayList ConvertToFArrayList(T[] dataArray) {
		FArrayList list = new FArrayList();
		if (dataArray == null) {
			return list;
		}
		for (T data : dataArray) {
			list.add(data);
		}
		return list;
	}
	
	/**
	 * 数组转列表
	 * 
	 * @param dataArray
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> FArrayList ConvertToFArrayList(List<T> dataList) {
		FArrayList list = new FArrayList();
		if (dataList == null) {
			return list;
		}
		for (T data : dataList) {
			list.add(data);
		}
		return list;
	}
}
