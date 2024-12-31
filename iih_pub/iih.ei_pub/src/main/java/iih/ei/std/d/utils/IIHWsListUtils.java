package iih.ei.std.d.utils;

import xap.mw.core.data.FArrayList;

/***
 * 数组通用类
 * @author fanlq
 * @date: 2019年8月9日 下午1:29:14
 */
public class IIHWsListUtils {
	
	/***
	 * @Description:数组转换为FArrayList
	 * @param objects
	 * @return
	 */
	public static FArrayList objsToArrayList(Object[] objects){
		if(objects == null) {
			return null;
		}
		FArrayList list = new FArrayList();
		for(Object obj : objects ){
			list.add(obj);
		}
		return list;
	}

}
