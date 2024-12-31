package iih.ci.ord.s.external.blood.ruimei.s.bp;

import java.io.ByteArrayOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

import xap.mw.core.data.BizException;

public class ApiUtils {


	/**
	 * 实例化Document对象，增加
	 * 
	 * @return
	 * @throws BizException
	 */
	public static Document getDocumentObj() throws BizException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();
			document.setXmlVersion("1.0");
			return document;
		} catch (Exception e) {
			throw new BizException("实例化XML异常！");
		}
	}
	
	/**
	 * 转换Document为xml串
	 * 
	 * @param document
	 * @return
	 * @throws BizException
	 */
	public static String getXmlStr(Document document) throws BizException {
		try {
			TransformerFactory transFactory = TransformerFactory.newInstance();
			Transformer transformer = transFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource domSource = new DOMSource(document);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			transformer.transform(domSource, new StreamResult(bos));
			return bos.toString();
		} catch (TransformerException e) {
			throw new BizException("Xml生成失败！");
		}
	}


}
