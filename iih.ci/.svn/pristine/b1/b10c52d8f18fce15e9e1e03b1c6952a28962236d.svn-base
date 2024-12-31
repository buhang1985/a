package iih.ci.ord.s.external.thirdws.utils;
/**
 * 
 * @author zhangwq
 *
 */
public class RstMsgBP {
	/**
	 * 返回值
	 * 
	 * @param code
	 * @param msg
	 * @return
	 */
	public static String getRstMsg(String code, String msg) {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("<root>                                   \n");
		sqlStr.append(" 	<resultcode>" + code + "</resultcode>   \n");
		sqlStr.append(" 	<resultmsg>" + msg + "</resultmsg>        \n");
		sqlStr.append("</root>                                  \n");
		return sqlStr.toString();
	}
	/**
	 * 返回值
	 * 
	 * @param code
	 * @param msg
	 * @return
	 */
	public static String getRstMsgCodeMsg(String code, String msg) {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		sqlStr.append("<results>                                   \n");
		sqlStr.append(" 	<code>" + code + "</code>   \n");
		sqlStr.append(" 	<msg>" + msg + "</msg>        \n");
		sqlStr.append("</results>                                  \n");
		return sqlStr.toString();
	}
}
