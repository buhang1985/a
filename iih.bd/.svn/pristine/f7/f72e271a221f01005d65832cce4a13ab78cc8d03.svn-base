package iih.bd.srv.s;

import java.util.ArrayList;
import java.util.Hashtable;

import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.log.logging.internal.Logger;

public class CiOrdUtils {
	public static final String FULLCLASS_NAME_CIORDERDO = "iih.ci.ord.ciorder.d.CiOrderDO";
	public static final FDateTime MAX_SYS_DATETIME = new FDateTime(
			"2099-01-01 00:00:00");
	public static final String MAX_AGEMONTH_NULL = "9999999";
	public static final String COMMA_STR = ",";
	public static final String SEMICOLON_STR = ";";
	public static final String TILDE_STR = "~";
	public static final String FULLSTOP_STR = ".";
	public static final String AND_STR = " AND ";
	public static final String GREATTHAN_STR = ">";
	public static final String LESSTHAN_STR = "<";
	public static final String GREATTHAN_EQUAL_STR = ">=";
	public static final String LESSTHAN_EQUAL_STR = "<=";
	public static final String SQUOTE_MARK_STR = "'";
	public static final String LBRACE_STR = "(";
	public static final String RBRACE_STR = ")";
	public static final String LBRACKET_STR = "[";
	public static final String RBRACKET_STR = "]";
	public static final String PUNCTUATION_STR = "、";
	public static final String CHINESE_AND_STR = "与";
	public static final String IN_STR_WITHBLANK = " in ";
	public static final String EQUAL_STR = "=";
	public static final String SELECT_STR = " SELECT ";
	public static final String FROM_STR = " FROM ";
	public static final String WHERE_STR = " WHERE ";
	public static final String ID_OR = "id_or";
	public static final String ATTRNAME_SORTNO = "Sortno";
	public static final String ORAPP_SHEET_KEY = "orappsheet";
	public static final String REPLACE_STR1 = "$$";
	public static final String CRLF = "\r\n";// char(10)+char(13);
	public static final String SLASH_STR = "/";
	public static final String MACRO_STR = "$";
	public static final Integer SECONDS_PER_HOUR = 3600;
	public static final Integer HOURS_PER_DAY = 24;
	public static final Integer HOURS_PER_WEEK = 168;
	public static final Integer HOURS_PER_MONTH = 744;
	public static final String OR_MAINSRV_FLAG = "Y";

	public static Logger logger;


	/**
	 * 数组对象为空
	 * 
	 * @param objs
	 * @return
	 */
	public static boolean isEmpty(Hashtable obj) {
		if (obj == null || obj.size() <= 0)
			return true;
		return false;
	}

	/**
	 * 数组对象为空
	 * 
	 * @param objs
	 * @return
	 */
	public static boolean isEmpty(Object obj) {
		if (obj == null)
			return true;
		return false;
	}

	/**
	 * 数组对象为空
	 * 
	 * @param objs
	 * @return
	 */
	public static boolean isEmpty(Object[] objs) {
		if (objs == null || objs.length == 0)
			return true;
		return false;
	}

	/**
	 * Map列表为空
	 * 
	 * @param objs
	 * @return
	 */
	public static boolean isEmpty(FMap map) {
		if (map == null || map.size() == 0)
			return true;
		return false;
	}

	/**
	 * 数组列表为空
	 * 
	 * @param objs
	 * @return
	 */
	public static boolean isEmpty(FArrayList list) {
		if (list == null || list.size() == 0)
			return true;
		return false;
	}

	/**
	 * 数组列表为空
	 * 
	 * @param objs
	 * @return
	 */
	public static boolean isEmpty(ArrayList list) {
		if (list == null || list.size() == 0)
			return true;
		return false;
	}

	/**
	 * 是否为空串判断
	 * 
	 * @param input
	 * @return
	 */
	public static boolean isEmpty(String input) {

		return StringUtils.isBlank(input);
	}

}
