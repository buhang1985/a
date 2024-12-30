package iih.sc.comm;

import java.lang.reflect.Array;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;

/**
 * 集合工具类
 * @author yank
 *
 */
public class ScCollectionUtils {
	/**
	 * 数组转FArrayList
	 * @param items
	 * @return
	 */
	public static FArrayList arrayToList(Object[] items){
		if(items==null || items.length<=0){
			return null;
		}

		FArrayList list = new FArrayList();
		for(Object obj : items){
			if(obj==null){
				continue;
			}
			list.add(obj);
		}
		return list;
	}
	/**
	 * 是否为空
	 * @param arrayList
	 * @return
	 */
	public static boolean isNullOrEmpty(FArrayList arrayList){
		return arrayList==null || arrayList.isEmpty();
	}
    /**
     * 截取数组
     * @param array 数组
     * @param startIndex 开始索引
     * @param size 长度
     * @return 截取的数组
     * @throws BizException
     */
    public static <T> T[] subArray(T[] array,Integer startIndex,Integer size) throws BizException{
		if (array == null) {
			return null;
		}
		if(size<=0){
			return null;
		}
		int length = array.length;
		if ((startIndex +size) > length) {
			size = length - startIndex;
		}
		Class type = array.getClass().getComponentType();
		if (size <= 0) {
			return ((T[]) Array.newInstance(type, 0));
		}
		T[] subarray = (T[]) Array.newInstance(type, size);
		System.arraycopy(array, startIndex, subarray, 0, size);
		return subarray;
    }
}
