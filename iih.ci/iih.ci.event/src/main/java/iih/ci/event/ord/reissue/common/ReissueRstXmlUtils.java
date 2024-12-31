package iih.ci.event.ord.reissue.common;

import iih.ci.event.reissue.d.IEMsgReissueItmDTO;
import iih.ci.event.reissue.d.IEMsgReissueRstDTO;
/**
 * 消息补发，组装返回的xml文件
 * @author F
 *
 */
public class ReissueRstXmlUtils {
	/**
	 * 返回消息
	 * @param rstdto
	 * @return
	 */
	public static String getRstMsg(IEMsgReissueRstDTO rstdto){
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<msg>");
		sb.append("<head>");
	    sb.append("<code>"+rstdto.getCode()+"</code>");
		sb.append("<result>"+rstdto.getResult()+"</result>");
		sb.append("</head>");
		sb.append("<body>");
		if(rstdto.getReissueItms() != null && rstdto.getReissueItms().size() > 0){
			for (IEMsgReissueItmDTO itm : rstdto.getReissueItms()) {
				sb.append("<row>");
				sb.append("<head>"+itm.getHead()+"</head>");
				sb.append("<body><![CDATA["+itm.getBody()+"]]</body>");
				sb.append("</row>");
			}
		}  
		sb.append("</body>");
		sb.append("</msg>");
		return sb.toString();
	}
	/**
	 * 错误返回
	 * @param error
	 * @return
	 */
	public static String ErrorMsg(String error){
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<msg>");
		sb.append("<head>");
	    sb.append("<code>-1</code>");
		sb.append("<result>"+error+"</result>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("</body>");
		sb.append("</msg>");
		return sb.toString();
	}
}
