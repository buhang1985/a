package iih.ci.ord.s.bp.orsrvsplit.help;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:医嘱拆分数据分组处理
 * @author: xu_xing@founder.com.cn
 * @version：2018年4月26日 上午8:32:27 创建
 */
public class ArrayGroupingBp {
	private Integer groupCount = 500;// 每组条数
	private Integer groupIndex = 0;// 当前已经到第几组
	private String[] array;

	/**
	 * 构造函数
	 * 
	 * @param objArray
	 */
	public ArrayGroupingBp(String[] objArray) {
		array = objArray;
	}

	/**
	 * 下一组
	 * 
	 * @return
	 */
	public String[] nextArrayGroup() {
		List<String> reList = new ArrayList<String>();
		if (array == null || array.length < 1)
			return null;
		int index = 0;
		for (int i = groupIndex * groupCount; i < array.length; i++) {
			reList.add(array[i]);
			index++;
			if (index == groupCount)
				break;
		}
		groupIndex++;
		if (reList.size() == 0)
			return null;
		return reList.toArray(new String[reList.size()]);
	}

	/**
	 * 下一组
	 * 
	 * @return
	 */
	public List<Object> nextListGroup() {
		List<Object> reList = new ArrayList<Object>();
		if (array == null || array.length < 1)
			return null;
		int index = 0;
		for (int i = groupIndex * groupCount; i < array.length; i++) {
			reList.add(array[i]);
			index++;
			if (index == groupCount)
				break;
		}
		groupIndex++;
		if (reList.size() == 0)
			return null;
		return reList;
	}

}
