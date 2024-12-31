package iih.bd.base.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BaseDO;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;

/**
 * map工具类
 * 
 * @author ly 2018/06/26
 *
 */
public class MapUtils {

	/**
	 * 转换数组为map
	 * 
	 * @param         <T>
	 * @param dos     do数组
	 * @param keyName 多个用','分隔
	 * @return
	 */
	public static <T extends BaseDO> Map<String, T> convertArrayToMap(T[] dos, String keyName) {

		Map<String, T> map = new HashMap<String, T>();
		if (ArrayUtil.isEmpty(dos))
			return map;

		String[] keyNames = keyName.split(",");
		for (T baseDO : dos) {
			map.put(getKey(baseDO, keyNames), baseDO);
		}

		return map;
	}

	/**
	 * 转换列表为map
	 * 
	 * @param dos     do数组
	 * @param keyName 多个用','分隔
	 * @return
	 */
	public static <T extends BaseDO> Map<String, T> convertListToMap(List<T> doList, String keyName) {

		Map<String, T> map = new HashMap<String, T>();
		if (ListUtil.isEmpty(doList))
			return map;

		String[] keyNames = keyName.split(",");
		for (T baseDO : doList) {
			map.put(getKey(baseDO, keyNames), baseDO);
		}

		return map;
	}

	/**
	 * 获取key值
	 * 
	 * @param base
	 * @param keyNames
	 * @return
	 */
	private static String getKey(BaseDO base, String[] keyNames) {
		String ret = "";

		for (String str : keyNames) {
			ret += base.getAttrVal(str) == null ? "" : base.getAttrVal(str).toString();
		}

		return ret;
	}
}
