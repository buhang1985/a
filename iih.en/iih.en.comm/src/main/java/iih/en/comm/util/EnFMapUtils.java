package iih.en.comm.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BaseDO;
import xap.mw.core.data.FMap;

public class EnFMapUtils {
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
			if(baseDO == null)
				continue;
			Object val = baseDO.getAttrVal(keyPropName);
			if(val == null)
				continue;
			String key = (String)val;
			map.put(key, baseDO);
		}
		return map;
	}
	/**
	 * 根据键属性名和BaseDO列表生成字典
	 * 
	 * @param keyPropName
	 * @param dos
	 * @return
	 */
	public static <T extends BaseDO> Map<String, T> getMap(String keyPropName, T[] dos) {
		if (dos == null || dos.length <= 0) {
			return null;
		}
		Map<String, T> map = new HashMap<>();
		for(T d : dos){
			if(d == null)
				continue;
			Object val = ((BaseDO)d).getAttrVal(keyPropName);
			if(val == null)
				continue;
			String key = (String)val;
			map.put(key, d);
		}
		return map;
	}
	/**
	 * 根据键属性名和BaseDO列表生成字典
	 * 
	 * @param keyPropName
	 * @param dos
	 * @return
	 */
	public static <T extends BaseDO> Map<String, List<T>> getMapList(String keyPropName, T[] dos) {
		if (dos == null || dos.length <= 0) {
			return null;
		}
		Map<String, List<T>> map = new HashMap<>();
		for(T d : dos){
			if(d == null)
				continue;
			Object val = ((BaseDO)d).getAttrVal(keyPropName);
			if(val == null)
				continue;
			String key = (String)val;
			if(map.containsKey(key)){
				map.get(key).add(d);
			}else{
				List<T> list = new ArrayList<T>();
				list.add(d);
				map.put(key, list);
			}
		}
		return map;
	}
}
