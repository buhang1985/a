package iih.bd.base.utils;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.ArrayUtil;

/**
 * 就诊集合帮助类
 * @author yankan
 *
 */
public class CollectionUtils {
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
		for(int i=0;i<array.length;i++){
			list.add(array[i]);
		}
		return list;
	}
	/**
	 * 数组转为FArrayList2
	 * @param array 对象数组
	 * @return
	 */
	public static <T> FArrayList2 toFArrayList2(T[] array){
		if(ArrayUtil.isEmpty(array)){
			return null;
		}
		FArrayList2 list = new FArrayList2();
		for(int i=0;i<array.length;i++){
			list.add(array[i]);
		}
		return list;
	}
	/**
	 * 是否为空
	 * @param farray
	 * @return
	 */
	public static boolean isEmpty(FArrayList farray){
		return farray == null || farray.size()<=0;
	}
	/**
	 * 是否为空
	 * @param map
	 * @return
	 */
	public static boolean isEmpty(Map map) {
		return (map == null || map.size() <= 0);
	}
	/**
	 * 是否不为空
	 * @param farray
	 * @return
	 */
	public static boolean isNotEmpty(FArrayList farray){
		return farray!=null && farray.size()>0;
	}
	/**
	 * 是否为空
	 * @param farray
	 * @return
	 */
	public static boolean isEmpty(FArrayList2 farray){
		return farray == null || farray.size()<=0;
	}
	/**
	 * 是否不为空
	 * @param farray
	 * @return
	 */
	public static boolean isNotEmpty(FArrayList2 farray){
		return farray!=null && farray.size()>0;
	}
	/**
	 * 是否为空
	 * @param fmap
	 * @return
	 */
	public static boolean isEmpty(FMap fmap){
		return fmap == null || fmap.size()<=0;
	}
	/**
	 * 获取随机MapKEY
	 * @param map
	 * @return
	 */
    public static Object getRandomKeyFromMap(Map map) {  
    	if(map==null || map.size()<0)
    		return null;
    	
	    Random random = new Random();
		int rdmInt = random.nextInt(map.size());
        int i = 0;  
        for (Object key : map.keySet()) {  
            if(i==rdmInt){  
                return key;  
            }  
            i++;  
        }  
        return null;  
     }  
	/**
	 * 获取随机MapKEY
	 * @param map
	 * @return
	 */
    public static Object getRandomKeyFromCollection(Collection col) {  
    	if(col==null || col.size()<0){
    		return null;
    	}
    	
	    Random random = new Random();
		int rdmInt = random.nextInt(col.size());
		int i = 0;		
		Iterator iterator = col.iterator();	
		Object temp =null;
		while(iterator.hasNext()){
			temp = iterator.next();
			if(i==rdmInt){
				break;
			}
			i++;			
		}
        return temp;  
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
    /**
     * map转为FMap
     * @param map
     * @return
     */
    public static FMap convertToFMap(Map map){
		FMap fmap = new FMap();
		if(!CollectionUtils.isEmpty(map)){
			fmap.putAll(map);
		}
		return fmap;
    }
}
