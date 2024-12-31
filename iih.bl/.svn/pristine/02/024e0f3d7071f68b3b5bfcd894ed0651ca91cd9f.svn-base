package iih.bl.comm;

public class ErrorMsgBp {
	
	/**
	 * 确费获取过程中不可预料
	 * 
	 * @param code
	 * @param msg
	 * @return
	 */
	public static String getComfirmFeeMsg(String code, String msg) {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("<?xml version=\"1.0\" encoding=\"utf-8\" ?> \n");
		sqlStr.append("<results>                                   \n");
		sqlStr.append(" 	<code>" + code + "</code>              \n");
		sqlStr.append(" 	<message>" + msg + "</message>         \n");
		sqlStr.append("</results>                                  \n");
		return sqlStr.toString();
	}

	/**
	 * 基础数据异常情况返回结果
	 * 
	 * @param code
	 * @param msg
	 * @return
	 */
	public static String getBaseDataMsg(String code, String msg, String rootData) {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>  \n");
		sqlStr.append("<results>                                   \n");
		sqlStr.append(" 	<resultmsg>                            \n");
		sqlStr.append(" 		<code>" + code + "</code>          \n");
		sqlStr.append(" 		<message>" + msg + "</message>     \n");
		sqlStr.append(" 	</resultmsg>                           \n");
		sqlStr.append(" 	<" + rootData + "s>                    \n");
		sqlStr.append(" 	</" + rootData + "s>                   \n");
		sqlStr.append("</results>                                  \n");
		return sqlStr.toString();
	}
	
	/**
	 * 基础数据情况返回结果
	 * 
	 * @param code
	 * @param msg
	 * @return
	 */
	public static String getBaseReturnMsg(String code, String msg) {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("<?xml version=\"1.0\" encoding=\"utf-8\" ?> \n");
		sqlStr.append("<results>                                   \n");
		sqlStr.append(" 	<code>" + code + "</code>              \n");
		sqlStr.append(" 	<message>" + msg + "</message>         \n");
		sqlStr.append("</results>                                  \n");
		return sqlStr.toString();
	}
}
