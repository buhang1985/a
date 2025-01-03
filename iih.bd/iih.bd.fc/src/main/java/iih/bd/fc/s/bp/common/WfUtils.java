package iih.bd.fc.s.bp.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import iih.bd.fc.bdwfdepctr.d.DgCtrEnum;
import iih.bd.fc.pub.BdFcAppUtils;
import iih.bd.fc.wf.d.OrRecurTypeEnum;
import xap.mw.core.data.BaseDO;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FTime;
import xap.mw.coreitf.i.IBaseDO;
import xap.sys.jdbc.kernel.SqlParam;

public class WfUtils {

	/**
	 * 参数化查询实例化SqlParam
	 * 
	 * @param param
	 * @param values
	 */
	public static void setSqlParam(SqlParam param, String[] values) {
		if (param != null) {
			if (values != null && values.length > 0) {
				for (String val : values) {
					if (!StringUtil.isEmptyWithTrim(val))
						param.addParam(val);
				}
			}
		}
	}

	/**
	 * 获取参数化查询字符串
	 * 
	 * @param values
	 * @return
	 */
	public static String getSqlParamChars(String[] values) {
		String reString = "";
		if (values != null && values.length > 0) {
			for (String val : values) {
				if (!StringUtil.isEmptyWithTrim(val))
					reString += (reString.length() == 0 ? "" : ",") + "?";
			}
		}
		return reString;
	}

	/**
	 * 获取DO中指定的列集合
	 * 
	 * @param params
	 * @param attrName
	 * @return
	 */
	public static String[] getAttrVal(BaseDO[] params, String attrName) {
		List<String> reList = new ArrayList<String>();
		if (params == null || params.length < 1)
			return reList.toArray(new String[reList.size()]);
		for (BaseDO param : params) {
			Object key = param.getAttrVal(attrName);
			if (key == null)
				continue;
			if (StringUtil.isEmptyWithTrim(key.toString()))
				continue;
			if (!reList.contains(key.toString()))
				reList.add(key.toString());
		}
		return reList.toArray(new String[reList.size()]);
	}

	/**
	 * 参数是否是集合（层次树）中某一项的子 ；向下兼容，01 兼容 0102
	 * @param listVal
	 * @param val
	 * @return
	 */
	public static boolean isStarWithClude(List<String> listVal, String val) {
		if (StringUtil.isEmptyWithTrim(val))
			return false;
		if (listVal == null || listVal.size() < 1)
			return false;
		for (String item : listVal) {
			if (val.indexOf(item) == 0)
				return true;
		}
		return false;
	}


	/**
	 * BaseDO类型映射为Map
	 * 
	 * @param params
	 * @param attrName
	 * @return
	 */
	public static <T extends IBaseDO> HashMap<String, T> mapBaseDO(T[] params, String attrName) {
		HashMap<String, T> reMap = new HashMap<String, T>();
		if (params == null || params.length < 1)
			return reMap;
		if (params != null && params.length > 0) {
			for (T t : params) {
				Object key = t.getAttrVal(attrName);
				if (key == null)
					continue;
				reMap.put(key.toString(), t);
			}
		}
		return reMap;
	}

	/**
	 * BaseDO分组映射
	 * 
	 * @param params
	 * @param ketAttrName
	 * @param valArrtName
	 * @return
	 */
	public static <T extends IBaseDO> HashMap<String, List<T>> groupBaseDO(T[] params, String attrName) {
		HashMap<String, List<T>> reMap = new HashMap<String, List<T>>();
		if (params == null || params.length < 1)
			return reMap;
		if (params != null && params.length > 0) {
			for (T t : params) {
				Object key = t.getAttrVal(attrName);
				if (key == null)
					continue;
				if (reMap.containsKey(key.toString())) {
					reMap.get(key.toString()).add(t);
				} else {
					List<T> list = new ArrayList<T>();
					list.add(t);
					reMap.put(key.toString(), list);
				}
			}
		}
		return reMap;
	}
	
	/**
	 * BaseDO分组映射
	 * 
	 * @param params
	 * @param ketAttrName
	 * @param valArrtName
	 * @return
	 */
	public static <T extends IBaseDO> HashMap<String, List<String>> groupBaseDO(T[] params, String ketAttrName, String valArrtName) {
		HashMap<String, List<String>> reMap = new HashMap<String, List<String>>();
		if (params == null || params.length < 1)
			return reMap;
		if (params != null && params.length > 0) {
			for (T t : params) {
				Object key = t.getAttrVal(ketAttrName);
				Object val = t.getAttrVal(valArrtName);
				if (key == null || val == null)
					continue;
				if (reMap.containsKey(key.toString())) {
					reMap.get(key.toString()).add(val.toString());
				} else {
					List<String> list = new ArrayList<String>();
					list.add(val.toString());
					reMap.put(key.toString(), list);
				}
			}
		}
		return reMap;
	}

	/**
	 * BaseDO分组映射
	 * 
	 * @param params
	 * @param ketAttrName
	 * @param valArrtName
	 * @return
	 */
	public static <T extends IBaseDO> HashMap<Integer, List<T>> groupBaseDOByInt(T[] params, String ketAttrName) {
		HashMap<Integer, List<T>> reMap = new HashMap<Integer, List<T>>();
		if (params == null || params.length < 1)
			return reMap;
		if (params != null && params.length > 0) {
			for (T t : params) {
				Object key = t.getAttrVal(ketAttrName);
				if (key == null)
					continue;
				Integer intKey = Integer.parseInt(key.toString());
				if (reMap.containsKey(intKey)) {
					reMap.get(intKey).add(t);
				} else {
					List<T> list = new ArrayList<T>();
					list.add(t);
					reMap.put(intKey, list);
				}
			}
		}
		return reMap;
	}


	/**
	 * List集合中获取有效的字符集合
	 * 
	 * @param list
	 * @return
	 */
	public static String[] getEffecFromList(List<String> list) {
		if (list == null || list.size() < 1)
			return null;
		List<String> reList = new ArrayList<String>();
		for (String str : list) {
			if (!StringUtil.isEmptyWithTrim(str)) {
				if (!reList.contains(str))
					reList.add(str);
			}
		}
		if (reList.size() < 1)
			return null;
		return reList.toArray(new String[0]);
	}
	
	/**
	 * 字符串包含（键）校验（以逗号分割），字符串和键都非空才校验
	 * 
	 * @param strSplit
	 * @param str
	 * @return
	 */
	public static boolean isStrsInclude(String strSplit, String str) {
		if (!StringUtil.isEmptyWithTrim(strSplit)) {
			if (StringUtil.isEmptyWithTrim(str))
				return false;
			for (String itm : strSplit.split(",")) {
				if (str.equals(itm))
					return true;
			}
			return false;
		}
		return true;
	}

	/**
	 * 字符串包含字符串
	 * 
	 * @param strSplit
	 * @param strs
	 * @return
	 */
	public static boolean isStrsIncludeStrs(String strSplit, String strs) {
		if (!StringUtil.isEmptyWithTrim(strSplit)) {
			if (StringUtil.isEmptyWithTrim(strs)) {
				return false;
			}
			int count = 0;
			for (String str : strs.split(",")) {
				for (String itm : strSplit.split(",")) {
					if (itm.equals(str)) {
						count++;
						break;
					}
				}
			}
			return count == strs.split(",").length;
		}
		return true;
	}

	/**
	 * 字符串和整型比较
	 * 
	 * @param str
	 * @param integ
	 * @return
	 */
	public static boolean isStrMatchInt(Integer integ, String str) {
		if (integ == null)
			return true;
		if (OrRecurTypeEnum.NULL.equals(integ))
			return true;
		if (StringUtil.isEmptyWithTrim(str))
			return false;
		if (!str.equals(integ + ""))
			return false;
		return true;
	}

	/**
	 * 时间区间校验
	 * 
	 * @param bg
	 * @param ed
	 * @param time
	 * @return
	 */
	public static boolean isTimeBetween(FTime bg, FTime ed, FTime time) {
		if (bg != null && ed != null) {
			FTime inputTime = null;
			if (time == null) {
				inputTime = BdFcAppUtils.getServerDateTime().getUFTime();
			} else {
				inputTime = time;
			}
			if (inputTime.before(bg) || inputTime.after(ed)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 加急匹配
	 * 
	 * @param eu_urgent
	 * @param fg_urgent
	 * @return
	 */
	public static boolean isEnumAndBoolMatch(Integer eu_enum, FBoolean fg_bool) {
		// 规则未设置，默认匹配
		if (eu_enum == null)
			return true;
		// 不限制
		if (eu_enum == DgCtrEnum.NOLIMIT)
			return true;
		// 加急
		if (eu_enum == DgCtrEnum.LIMIT_TRUE && FBoolean.TRUE.equals(fg_bool))
			return true;
		// 不加急
		if (eu_enum == DgCtrEnum.LIMIT_FALSE && FBoolean.FALSE.equals(fg_bool))
			return true;
		return false;
	}
	
	
}
