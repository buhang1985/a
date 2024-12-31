package iih.ci.ord.s.external.blood.ruimei.s.bp;

public class ErrorMsgBp {


	/**
	 * RIS申请单获取过程中不可预料
	 * 
	 * @param code
	 * @param msg
	 * @return
	 */
	public static String getRisApplyformMsg(String code, String msg) {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n");
		sqlStr.append("<result>                                   \n");
		sqlStr.append(" 	<result_title>                         \n");
		sqlStr.append(" 		<code>" + code + "</code>          \n");
		sqlStr.append(" 		<message>" + msg + "</message>     \n");
		sqlStr.append(" 	</result_title>                        \n");
		sqlStr.append("</result>                                  \n");
		return sqlStr.toString();
	}

	/**
	 * LIS申请单获取过程中不可预料
	 * 
	 * @param code
	 * @param msg
	 * @return
	 */
	public static String getLisApplyformMsg(String code, String msg) {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>  \n");
		sqlStr.append("<result>                                    \n");
		sqlStr.append(" 	<resultmsg>                             \n");
		sqlStr.append(" 		<code>" + code + "</code>           \n");
		sqlStr.append(" 		<message>" + msg + "</message>      \n");
		sqlStr.append(" 	</resultmsg>                            \n");
		sqlStr.append("</result>                                   \n");
		return sqlStr.toString();
	}

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
		sqlStr.append("<result>                                    \n");
		sqlStr.append(" 	<resultmsg>                            \n");
		sqlStr.append(" 		<code>" + code + "</code>          \n");
		sqlStr.append(" 		<message>" + msg + "</message>     \n");
		sqlStr.append(" 	</resultmsg>                           \n");
		sqlStr.append(" 	<" + rootData + "s>                    \n");
		sqlStr.append(" 	</" + rootData + "s>                   \n");
		sqlStr.append("</result>                                   \n");
		return sqlStr.toString();
	}
	/**
	 * 确费获取过程中不可预料
	 * 
	 * @param code
	 * @param msg
	 * @return
	 */
	public static String getBedCardErrorMsg(String code, String msg) {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("<?xml version=\"1.0\" encoding=\"utf-8\" ?> \n");
		sqlStr.append("<result>                                   \n");
		sqlStr.append(" 	<code>" + code + "</code>              \n");
		sqlStr.append(" 	<message>" + msg + "</message>         \n");
		sqlStr.append("</result>                                  \n");
		return sqlStr.toString();
	}
	/**
	 * 自助机接口不可预料的错误
	 * 
	 * @param code
	 * @param msg
	 * @return
	 */
	public static String selfToHisErroeMsg(String code, String msg) {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("<Response>                                   \n");
		sqlStr.append(" 	<ResultCode>" + code + "</ResultCode>   \n");
		sqlStr.append(" 	<ErrorMsg>" + msg + "</ErrorMsg>        \n");
		sqlStr.append(" 	<HISDateTime>" + msg + "</HISDateTime>  \n");
		sqlStr.append("</Response>                                  \n");
		return sqlStr.toString();
	}


}
