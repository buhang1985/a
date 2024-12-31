package iih.bd.base.utils;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BaseDO;

/**
 * DO工具类
 * 
 * @author hao_wu 2019-8-16
 *
 */
public class DoUtils {

	/**
	 * 获取DO属性值集合
	 * 
	 * @param datas     数据集合
	 * @param attrName  属性名
	 * @param attrClass 属性值类型
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T extends BaseDO, AT> AT[] getAttrValArr(T[] datas, String attrName, Class<AT> attrValClass) {

		ArrayList<AT> attrValList = new ArrayList<AT>();
		for (T data : datas) {
			AT attrVal = (AT) data.getAttrVal(attrName);
			attrValList.add(attrVal);
		}

		AT[] ats = (AT[]) Array.newInstance(attrValClass, attrValList.size());
		ats = attrValList.toArray(ats);
		return ats;
	}

	/**
	 * 获取DO非空属性值集合
	 * 
	 * @param datas     数据集合
	 * @param attrName  属性名
	 * @param attrClass 属性值类型
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T extends BaseDO, AT> AT[] getAttrValArrNotNull(T[] datas, String attrName, Class<AT> attrValClass) {

		ArrayList<AT> attrValList = new ArrayList<AT>();
		for (T data : datas) {
			AT attrVal = (AT) data.getAttrVal(attrName);
			if (attrVal != null || (attrVal instanceof String) && StringUtils.isNotBlank((String) attrVal)) {
				attrValList.add(attrVal);
			}
		}

		AT[] ats = (AT[]) Array.newInstance(attrValClass, attrValList.size());
		ats = attrValList.toArray(ats);
		return ats;
	}
}
