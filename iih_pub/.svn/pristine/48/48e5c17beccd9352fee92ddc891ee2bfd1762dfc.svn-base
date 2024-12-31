package iih.bd.base.utils;

import xap.mw.core.data.BaseDO;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;

/**
 * FMap帮助类
 * 
 * @author hao_wu
 *
 */
public class FMapUtils {

	/**
	 * 根据键属性名和BaseDO列表生成字典
	 * 
	 * @param keyPropName
	 *            键属性名
	 * @param dos
	 *            BaseDO列表
	 * @return [键属性名对应的值(字符串类型),BaseDO]
	 */
	public static FMap getFMap(String keyPropName, BaseDO[] dos) {
		if (dos == null || dos.length <= 0) {
			return null;
		}

		FMap map = new FMap();
		for (BaseDO baseDO : dos) {
			String key = baseDO.getAttrVal(keyPropName).toString();
			map.put(key, baseDO);
		}
		return map;
	}

	/**
	 * 根据键属性名和BaseDO列表生成字典
	 * 
	 * @param keyPropName
	 *            键属性名
	 * @param dos
	 *            BaseDO列表
	 * @return [键属性名对应的值(字符串类型),BaseDO]
	 */
	public static FMap2 getFMap2(String keyPropName, BaseDO[] dos) {
		if (dos == null || dos.length <= 0) {
			return null;
		}

		FMap2 map = new FMap2();
		for (BaseDO baseDO : dos) {
			String key = baseDO.getAttrVal(keyPropName).toString();
			map.put(key, baseDO);
		}
		return map;
	}
}
