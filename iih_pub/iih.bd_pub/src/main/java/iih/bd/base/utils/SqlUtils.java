package iih.bd.base.utils;

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
import xap.sys.jdbc.kernel.SqlParam;

/**
 * Sql帮组类
 * 
 * @author yankan
 * @author hao_wu 2019-5-14
 *
 */
public class SqlUtils {
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
	 * @param idList    id字符串列表
	 * @param fieldName 查询字段名
	 * @return in查询语句
	 * @author zhengcm
	 */
	public static String getInSqlByIds(String fieldName, List<String> idList) {
		return getInSqlByIds(fieldName, idList.toArray(new String[0]));
	}

	/**
	 * 根据ids和查询字段生成in条件语句
	 * 
	 * @param fieldName 查询字段名
	 * @param ids       id字符串集合
	 * @return in查询语句
	 */
	public static String getInSqlByIds(String fieldName, String[] ids) {
		if (ArrayUtil.isEmpty(ids) || StringUtil.isEmptyWithTrim(fieldName)) {
			return null;
		}

		if (ids.length > 1000) {
			return getInSqlByBigIds(fieldName, ids);
		}
		return fieldName + " in (" + SqlUtils.arrayToStr(ids) + ") ";
	}

	/**
	 * 根据ids和查询字段生成in条件语句 以,分割
	 * 
	 * @param fieldName 查询字段名
	 * @param ids       id字符串集合
	 * @return in查询语句
	 */
	public static String getInSqlByIdsSplit(String fieldName, String idsStr) {
		String[] ids = idsStr.split(",");
		String inSql = getInSqlByIds(fieldName, ids);
		return inSql;
	}

	/**
	 * 根据ids和查询字段生成in条件语句 以,分割
	 * 
	 * @param fieldName 查询字段名
	 * @param ids       id字符串集合
	 * @return in查询语句
	 */
	public static String getInSqlByIdsSplit(String id) {
		String[] ids = id.split(",");
		if (ids.length > 1000) {
			return getInSqlByBigIds("", ids);
		}
		if (ArrayUtil.isEmpty(ids)) {
			return null;
		}
		return " in (" + arrayToStr(ids) + ") ";
	}

	/**
	 * 根据ids和查询字段生成in条件语句<br/>
	 * 建议使用 iih.bd.base.utils.SqlUtils.getInSqlByIds(String, String[])
	 * 
	 * @param fieldName 查询字段名
	 * @param ids       id字符串集合
	 * @return in查询语句
	 */
	@Deprecated
	public static String getInSqlByBigIds(String fieldName, String[] ids) {
		if (ids.length <= 1000) {
			return getInSqlByIds(fieldName, ids);
		}
		String qrySql = TempTableUtils.buildQrySql(ids);
		String wherePart = String.format("%s in (%s)", fieldName, qrySql);
		return wherePart;
	}

	/**
	 * 获取not in条件语句
	 *
	 * @param fieldName 查询字段名
	 * @param ids       id字符串集合
	 * @return not in查询语句
	 */
	public static String getNotInSqlByIds(String fieldName, List<String> idList) {
		return getNotInSqlByIds(fieldName, idList.toArray(new String[0]));
	}

	/**
	 * 获取not in条件语句
	 *
	 * @param fieldName 查询字段名
	 * @param ids       id字符串集合
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
	 * 根据ids和查询字段生成Notin条件语句</br>
	 * 建议使用 iih.bd.base.utils.SqlUtils.getNotInSqlByIds(String, String[])
	 * 
	 * @param fieldName 查询字段名
	 * @param ids       id字符串集合
	 * @return NotIn查询语句
	 */
	@Deprecated
	public static String getNotInSqlByBigIds(String fieldName, String[] ids) {
		if (ids.length <= 1000) {
			return getNotInSqlByIds(fieldName, ids);
		}
		String qrySql = TempTableUtils.buildQrySql(ids);
		String wherePart = String.format("%s not in (%s)", fieldName, qrySql);
		return wherePart;
	}

	/**
	 * 使用查询方案信息生成条件语句
	 * 
	 * @param qryRootNodeDTO 查询方案信息
	 * @param doName         Do类名
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
	 * @param qryRootNodeDTO 查询方案信息
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

	/**
	 * 根据参数值列表获取InSql</br>
	 * 建议使用String getInSqlByIds(String fieldName, String[] ids)
	 * 
	 * @param fieldName
	 * @param paramValues
	 * @return
	 */
	@Deprecated
	public static String getInSqlByParamValues(String fieldName, String[] paramValues) {
		if (ArrayUtil.isEmpty(paramValues) || StringUtil.isEmptyWithTrim(fieldName)) {
			return null;
		}

		if (paramValues == null || paramValues.length <= 0) {
			return null;
		}

		if (paramValues.length > 1000) {
			return getInSqlByBigParamValues(fieldName, paramValues);
		}

		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("?");

		for (int i = 1; i < paramValues.length; i++) {
			sqlBuilder.append(",?");
		}

		return String.format("%s in (%s)", fieldName, sqlBuilder.toString());
	}

	/**
	 * 根据大参数值列表获取InSql
	 * 
	 * @param fieldName
	 * @param paramValues
	 * @return
	 */
	private static String getInSqlByBigParamValues(String fieldName, String[] paramValues) {
		StringBuilder wherePartBuilder = new StringBuilder();

		int length = paramValues.length;
		int left = 0;
		int groupSize = 1000;
		ArrayList<String> tempList = new ArrayList<String>(1000);

		while (left < length) {
			tempList.add(paramValues[left]);
			left++;
			if (tempList.size() >= groupSize || left >= length) {
				String inSql = getInSqlByParamValues(fieldName, tempList.toArray(new String[0]));
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
	 * 添加参数值列表到SqlParam</br>
	 * 建议使用String getInSqlByIds(String fieldName, String[] ids)
	 * 
	 * @param sqlParam
	 * @param paramValues
	 */
	@Deprecated
	public static void addParamValue(SqlParam sqlParam, Object[] paramValues) {
		if (paramValues == null || paramValues.length <= 0) {
			return;
		}

		for (Object paramValue : paramValues) {
			sqlParam.addParam(paramValue);
		}
	}
}
