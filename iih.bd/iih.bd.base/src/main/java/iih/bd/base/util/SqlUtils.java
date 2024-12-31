package iih.bd.base.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * Sql帮组类
 * 
 * @author yankan
 *
 */
public class SqlUtils {
	/**
	 * 生成id的查询串
	 * 
	 * @param idList
	 *            id集合
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
	 * 数组变为值字符串
	 * 
	 * @param items
	 *            某项多个值
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
	 * 格式化SQL，防止SQL注入
	 * 
	 * @param condition
	 *            查询条件
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
	 * @param idList
	 *            id字符串列表
	 * @param fieldName
	 *            查询字段名
	 * @return in查询语句
	 * @author zhengcm
	 */
	public static String getInSqlByIds(String fieldName, List<String> idList) {
		if (idList == null || idList.size() <= 0) {
			return null;
		}
		return getInSqlByIds(fieldName, idList.toArray(new String[0]));
		// if (ListUtil.isEmpty(idList) ||
		// StringUtil.isEmptyWithTrim(fieldName)) {
		// return null;
		// }
		// return fieldName + " in (" + SqlUtils.buildIdStr(idList) + ") ";
	}

	/**
	 * 根据ids和查询字段生成in条件语句
	 * 
	 * @param fieldName
	 *            查询字段名
	 * @param ids
	 *            id字符串集合
	 * @return in查询语句
	 */
	public static String getInSqlByIds(String fieldName, String[] ids) {
		if (ids.length > 1000) {
			return getInSqlByBigIds(fieldName, ids);
		}
		if (ArrayUtil.isEmpty(ids) || StringUtil.isEmptyWithTrim(fieldName)) {
			return null;
		}
		return fieldName + " in (" + arrayToStr(ids) + ") ";
	}

	/**
	 * 根据ids和查询字段生成in条件语句
	 * 
	 * @param fieldName
	 *            查询字段名
	 * @param ids
	 *            id字符串集合
	 * @return in查询语句
	 */
	private static String getInSqlByBigIds(String fieldName, String[] ids) {
		StringBuilder wherePartBuilder = new StringBuilder();

		int length = ids.length;
		int left = 0;
		int groupSize = 1000;
		ArrayList<String> tempList = new ArrayList<String>(1000);

		while (left < length) {
			tempList.add(ids[left]);
			left++;
			if (tempList.size() >= groupSize || left >= length) {
				String inSql = getInSqlByIds(fieldName, tempList.toArray(new String[0]));
				tempList.clear();
				if (left > groupSize) {
					wherePartBuilder.append(String.format(" or ", inSql));
				}
				wherePartBuilder.append(String.format(" (%s) ", inSql));
			}
		}

		return String.format("(%s)", wherePartBuilder.toString());
	}

	/**
	 * 获取not in条件语句
	 *
	 * @param fieldName
	 *            查询字段名
	 * @param ids
	 *            id字符串集合
	 * @return not in查询语句
	 */
	public static String getNotInSqlByIds(String fieldName, String[] ids) {
		if (ArrayUtil.isEmpty(ids) || StringUtil.isEmptyWithTrim(fieldName)) {
			return null;
		}
		if (ids.length > 1000) {
			return getNotInSqlByBigIds(fieldName, ids);
		}
		return fieldName + " not in (" + SqlUtils.arrayToStr(ids) + ") ";
	}

	/**
	 * 根据ids和查询字段生成Notin条件语句
	 * 
	 * @param fieldName
	 *            查询字段名
	 * @param ids
	 *            id字符串集合
	 * @return NotIn查询语句
	 */
	public static String getNotInSqlByBigIds(String fieldName, String[] ids) {
		StringBuilder wherePartBuilder = new StringBuilder();

		int length = ids.length;
		int left = 0;
		int groupSize = 1000;
		ArrayList<String> tempList = new ArrayList<String>(1000);

		while (left < length) {
			tempList.add(ids[left]);
			left++;
			if (tempList.size() >= groupSize || left >= length) {
				String inSql = getNotInSqlByIds(fieldName, tempList.toArray(new String[0]));
				tempList.clear();
				if (left > groupSize) {
					wherePartBuilder.append(String.format(" or ", inSql));
				}
				wherePartBuilder.append(String.format(" (%s) ", inSql));
			}
		}

		return String.format("(%s)", wherePartBuilder.toString());
	}

	/**
	 * 使用查询方案信息生成条件语句
	 * 
	 * @param qryRootNodeDTO
	 *            查询方案信息
	 * @param doName
	 *            Do类名
	 * @return
	 * @throws BizException
	 */
	public static String getWherePartByQCond(QryRootNodeDTO qryRootNodeDTO, String doName) throws BizException {
		IQrySQLGeneratorService sqlGeneratorService = ServiceFinder.find(IQrySQLGeneratorService.class);
		String wherePart = sqlGeneratorService.getQueryStringWithDOName(qryRootNodeDTO, doName);
		if (StringUtils.isEmpty(wherePart)) {
			return "1 = 1";
		}
		return wherePart;
	}

	/**
	 * 使用查询方案信息生成条件语句
	 * 
	 * @param qryRootNodeDTO
	 *            查询方案信息
	 * @return
	 * @throws BizException
	 */
	public static String getWherePartByQCond(QryRootNodeDTO qryRootNodeDTO) throws BizException {
		IQrySQLGeneratorService sqlGeneratorService = ServiceFinder.find(IQrySQLGeneratorService.class);
		String wherePart = sqlGeneratorService.getQueryStringWithoutDesc(qryRootNodeDTO);
		if (StringUtils.isEmpty(wherePart)) {
			return "1 = 1";
		}
		return wherePart;
	}
}
