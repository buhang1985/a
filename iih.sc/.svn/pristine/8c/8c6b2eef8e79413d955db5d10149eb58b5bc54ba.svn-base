package iih.sc.comm;

import java.util.List;
import iih.bd.base.utils.SqlUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;

/**
 * Sql帮组类
 * 
 * @author yankan
 *
 */
public class ScSqlUtils {
	/**
	 * 生成id的查询串
	 * 
	 * @param idList id集合
	 * @return
	 */
	public static String buildIdStr(List<String> idList) {
		if (ListUtil.isEmpty(idList)) {
			return null;
		}

		StringBuilder builder = new StringBuilder();
		boolean first = true;
		for (String id : idList) {
			if (StringUtil.isEmpty(id)) {
				continue;
			}
			if (first) {
				first = false;
			} else {
				builder.append(",");
			}
			builder.append(String.format("'%s'", id));
		}

		return builder.toString();
	}
	/**
	 * 生成id的查询串
	 * 
	 * @param ids id集合
	 * @return
	 */
	public static String buildIdStr(String[] ids) {
		if (ArrayUtil.isEmpty(ids)) {
			return null;
		}

		StringBuilder builder = new StringBuilder();
		boolean first = true;
		for (String id : ids) {
			if (StringUtil.isEmpty(id)) {
				continue;
			}
			if (first) {
				first = false;
			} else {
				builder.append(",");
			}
			builder.append(String.format("'%s'", id));
		}

		return builder.toString();
	}

	/**
	 * 数组变为值字符串
	 * 
	 * @param items 某项多个值
	 * @return
	 */
	public static String arrayToStr(String[] items) {
		if (ArrayUtil.isEmpty(items)) {
			return null;
		}
		StringBuilder builder = new StringBuilder();
		boolean first = true;
		for (String item : items) {
			if (StringUtil.isEmpty(item)) {
				continue;
			}
			if (first) {
				first = false;
			} else {
				builder.append(",");
			}
			builder.append(String.format("'%s'", item));
		}

		return builder.toString();
	}

	/**
	 * 数组变为值字符串
	 * 
	 * @param items 某项多个值
	 * @return
	 */
	public static String arrayToStr(FArrayList items) {
		if (items == null || items.size() <= 0) {
			return null;
		}
		StringBuilder builder = new StringBuilder();
		boolean first = true;
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i) == null) {
				continue;
			}
			if (first) {
				first = false;
			} else {
				builder.append(",");
			}
			builder.append(String.format("'%s'", items.get(i)));
		}

		return builder.toString();
	}

	/**
	 * 格式化SQL，防止SQL注入
	 * 
	 * @param condition 查询条件
	 * @return
	 */
	public static String formatSQLInjection(String condition) {
		if (StringUtil.isEmpty(condition)) {
			return "";
		}
		return condition.replaceAll(".*([';]+|(--)+).*", " ");
	}

	/**
	 * 根据ids和查询字段生成in条件语句
	 *
	 * @param idList id字符串列表
	 * @param fieldName 查询字段名
	 * @return in查询语句
	 * @author zhengcm
	 */
	public static String getInSqlByIds(String fieldName, List<String> idList) {
		if (ListUtil.isEmpty(idList) || StringUtil.isEmptyWithTrim(fieldName)) {
			return null;
		}
		return SqlUtils.getInSqlByIds(fieldName, idList);
	}

	/**
	 * 根据ids和查询字段生成in条件语句
	 *
	 * @param ids id字符串列表
	 * @param fieldName 查询字段名
	 * @return in查询语句
	 * @author yzh
	 */
	public static String getInSqlByIds(String fieldName, String[] ids) {
		if (ArrayUtil.isEmpty(ids) || StringUtil.isEmptyWithTrim(fieldName)) {
			return null;
		}
		return SqlUtils.getInSqlByBigIds(fieldName, ids);
	}
	
	/**
	 * 根据ids和查询字段生成not in 条件语句
	 * @param fieldName
	 * @param idList
	 * @return
	 */
	public static String getNotInSqlByIds(String fieldName, List<String> idList) {
		if (ListUtil.isEmpty(idList) || StringUtil.isEmptyWithTrim(fieldName)) {
			return null;
		}
		return SqlUtils.getNotInSqlByIds(fieldName, idList);
	}
	
	/**
	 * 根据ids和查询字段生成not in 条件语句
	 * @param fieldName
	 * @param ids
	 * @return
	 */
	public static String getNotInSqlByIds(String fieldName, String[] ids) {
		if (ArrayUtil.isEmpty(ids) || StringUtil.isEmptyWithTrim(fieldName)) {
			return null;
		}
		return SqlUtils.getNotInSqlByIds(fieldName, ids);
	}
	
	/**
	 * 
	 * @return
	 * @throws BizException
	 */
	public static String getMapConveretstr(FMap2 map) throws BizException {
		StringBuffer sb = new StringBuffer();
		if (map == null && map.size() == 0)
			return null;
		for (Object key : map.values()) {
			sb.append(",'");
			sb.append(key.toString());
			sb.append("'");
		}
		return sb.toString().substring(1);
	}
}
