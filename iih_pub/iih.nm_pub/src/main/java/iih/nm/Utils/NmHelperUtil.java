package iih.nm.Utils;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.model.agg.BaseAggDO;

/**
 * 常用工具类
 * 
 * @author lijm 2018-8-3 10:29:26
 */
public class NmHelperUtil {

	/**
	 * 获取FArrayList中元素类表
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 * @author lijm
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> getEleListFromFArrayList(FArrayList param) throws BizException {
		if (param != null && param.size() > 0) {
			List<T> res = new ArrayList<T>();
			for (Object obj : param) {
				T ele = (T) obj;
				res.add(ele);
			}
			return res;
		}
		return null;
	}

	/**
	 * 获取FArrayList中第一个元素
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 * @author lijm
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getFirstEleFromFArrayList(FArrayList param) throws BizException {
		if (param != null && param.size() > 0) {
			for (Object obj : param) {
				return (T) obj;
			}
		}
		return null;
	}

	/**
	 * 获取集合（BaseDO）中元素某一字段值集合
	 * 
	 * @param baseDo
	 * @param fieldId
	 * @return
	 * @throws BizException
	 * @author lijm
	 */
	public static List<String> getStrListFromBaseDOCollect(List<? extends BaseDO> doList, String fieldId)
			throws BizException {
		if (doList != null && doList.size() > 0) {
			List<String> res = new ArrayList<String>();
			for (BaseDO baseDo : doList) {
				String fieldValue = baseDo.getAttrVal(fieldId).toString();
				if (!StringUtil.isEmptyWithTrim(fieldValue)) {
					res.add(fieldValue);
				}
			}
			return res;
		}
		return null;
	}

	/**
	 * 获取集合（BaseDO）中元素某一字段值集合
	 * 
	 * @param baseDo
	 * @param fieldId
	 * @return
	 * @throws BizException
	 * @author lijm
	 */
	public static List<String> getStrListFromBaseDOCollect(BaseDO[] baseDos, String fieldId) throws BizException {
		if (baseDos != null && baseDos.length > 0) {
			List<String> res = new ArrayList<String>();
			for (BaseDO baseDo : baseDos) {
				String fieldValue = baseDo.getAttrVal(fieldId).toString();
				if (!StringUtil.isEmptyWithTrim(fieldValue)) {
					res.add(fieldValue);
				}
			}
			return res;
		}
		return null;
	}

	/**
	 * 获取集合（BaseAggDO）中元素某一字段值集合
	 * 
	 * @param aggDoList
	 * @param fieldId
	 * @return
	 * @throws BizException
	 * @author lijm
	 */
	public static List<String> getStrListFromBaseAggDOCollect(List<? extends BaseAggDO> aggDoList, String fieldId)
			throws BizException {
		if (aggDoList != null && aggDoList.size() > 0) {
			List<String> res = new ArrayList<String>();
			for (BaseAggDO baseAggDo : aggDoList) {
				BaseDO baseDo = baseAggDo.getParentDO();
				String fieldValue = baseDo.getAttrVal(fieldId).toString();
				if (!StringUtil.isEmptyWithTrim(fieldValue)) {
					res.add(fieldValue);
				}
			}
			return res;
		}
		return null;
	}

	/**
	 * 根据字段值集合拼接Sql-in条件
	 * @param fieldName 字段名
	 * @param fieldValues 字段集合
	 * @return
	 */
	public static String getWherePartAppendFieldValues(String fieldName, String[] fieldValues) {
		if (!StringUtil.isEmptyWithTrim(fieldName) && fieldValues != null && fieldValues.length > 0) {
			StringBuffer sb = new StringBuffer(fieldName + " in ");
			for (int i = 0; i < fieldValues.length; i++) {
				if (i == 0) {
					sb.append("('" + fieldValues[i] + "'");
				} else if (i == fieldValues.length - 1) {
					sb.append(",'" + fieldValues[i] + "')");
				} else {
					sb.append(",'" + fieldValues[i] + "'");
				}
			}
			return sb.toString();
		}
		return null;
	}
}
