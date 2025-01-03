package iih.en.comm.util;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;

import java.util.List;

/**
 * Sql帮组类
 * 
 * @author yankan
 *
 */
public class EnSqlUtils {
	/**
	 * 根据ids和查询字段生成in条件语句
	 *
	 * @param idList id字符串列表
	 * @param fieldName 查询字段名
	 * @return in查询语句
	 * @author zhengcm
	 */
	public static String getInSqlByIds(String fieldName, List<String> idList) {
		if (EnValidator.isEmpty(idList) || EnValidator.isEmpty(fieldName)) {
			return null;
		}
		return SqlUtils.getInSqlByIds(fieldName, idList);
	}
	
	/**
	 * 根据ids和查询字段生成in条件语句
	 * @param fieldName 查询字段名
	 * @param ids id字符串集合
	 * @return in查询语句
	 */
	public static String getInSqlByIds(String fieldName, String[] ids) {
		if (EnValidator.isEmpty(ids) || EnValidator.isEmpty(fieldName)) {
			return null;
		}
		return SqlUtils.getInSqlByIds(fieldName, ids);
	}
	/**
	 * 获取not in条件语句
	 *
	 * @param fieldName 查询字段名
	 * @param ids id字符串集合	 
	 * @return not in查询语句
	 */
	public static String getNotInSqlByIds(String fieldName, String[] ids) {
		if (EnValidator.isEmpty(ids) || EnValidator.isEmpty(fieldName)) {
			return null;
		}
		return SqlUtils.getNotInSqlByIds(fieldName, ids);
	}	
	/**
	 * 获取门诊或急诊就诊类型sql
	 * 
	 * @param entAliasName
	 * @return
	 */
	public static String getOpOrErTpSql(String entAliasName, String code_entp) {
		String codeEntpSql = EnValidator.isEmpty(entAliasName) ? PatiVisitDO.CODE_ENTP : String.format("%s.%s", entAliasName, PatiVisitDO.CODE_ENTP);
		if(IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(code_entp)){
			String[] codeEntps = EnParamUtils.getErTpComm();
			return EnValidator.isEmpty(codeEntps) ? "1=2" : getInSqlByIds(codeEntpSql, codeEntps);
		}
		return String.format(" ( %s = '%s') ", codeEntpSql, IBdFcDictCodeConst.SD_CODE_ENTP_OP);
	}
	
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
}
