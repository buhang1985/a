package iih.mi.util;

import java.util.Arrays;

import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;

/**
 * 工具类，业务逻辑增加
 * @author yangyang
 * @Date 2018-04-13
 */
public class MiCollectionUtils {
	/**
	 * 数组转为FArrayList
	 * @param array 对象数组
	 * @return
	 */
	public static <T> FArrayList toFArrayList(T[] array){
		if(ArrayUtil.isEmpty(array)){
			return null;
		}
		FArrayList list = new FArrayList();
//		for(int i=0;i<array.length;i++){
//			list.add(array[i]);
//		}
		list.addAll(Arrays.asList(array));
		return list;
	}
}
