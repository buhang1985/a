package iih.ei.std.bd.v1.s.bp;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import iih.ei.std.bd.v1.i.IResultCodeConst;
import iih.ei.std.bd.v1.utils.BdStdLogUtils;
import iih.ei.std.bd.v1.utils.XmlUtils;

/**
 * 使用消息创建错误XML
 * 
 * @author hao_wu 2019-2-27
 *
 */
public class CreateErrXmlByMsgBp {

	public String exec(String msg) {
		try {
			Document document = createDocument(msg);

			String resultXml = XmlUtils.toString(document);
			return resultXml;
		} catch (Exception e) {
			BdStdLogUtils.logExAndTitle(e, "根据消息创建错误XML异常");
			return null;
		}
	}

	/**
	 * 创建XMl文档
	 * 
	 * @param msg
	 * @return
	 */
	private Document createDocument(String msg) {
		Document document = DocumentHelper.createDocument();

		Element resultElement = document.addElement("result");

		Element codeEle = resultElement.addElement("code");
		codeEle.setText(IResultCodeConst.ERR);

		Element msgEle = resultElement.addElement("msg");
		msgEle.setText(msg);

		return document;
	}

}
