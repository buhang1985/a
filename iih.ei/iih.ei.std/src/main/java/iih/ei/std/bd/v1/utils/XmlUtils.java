package iih.ei.std.bd.v1.utils;

import java.io.StringWriter;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import xap.mw.core.data.BizException;

/**
 * XML工具类
 * 
 * @author hao_wu
 *
 */
public class XmlUtils {

	/**
	 * Document转字符串
	 * 
	 * @param doc
	 * @return
	 * @throws BizException
	 */
	public static String toString(Document doc) throws BizException {
		try {
			OutputFormat format = new OutputFormat();

			// 设置换行 为false时输出的xml不分行
			format.setNewlines(true);
			// 生成缩进
			format.setIndent(true);
			// 指定使用tab键缩进
			// format.setIndent(" ");
			// 不在文件头生成 XML 声明 (<?xml version="1.0" encoding="UTF-8"?>)
			format.setSuppressDeclaration(false);
			// 不在文件头生成 XML 声明 (<?xml version="1.0" encoding="UTF-8"?>)中加入encoding 属性
			format.setOmitEncoding(false);

			// 关闭自闭合标签
			format.setExpandEmptyElements(true);

			StringWriter strWriter = new StringWriter();
			XMLWriter xmlWriter = new XMLWriter(strWriter, format);
			xmlWriter.write(doc);
			xmlWriter.flush();
			xmlWriter.close();
			return strWriter.toString();
		} catch (Exception e) {
			throw new BizException("文档转XMl字符串失败。", e);
		}
	}

	/**
	 * XML转文档模型
	 * 
	 * @param xml
	 * @return
	 * @throws BizException
	 */
	public static Document getDocument(String xml) throws BizException {
		Document doc;
		try {
			doc = DocumentHelper.parseText(xml);
		} catch (DocumentException e) {
			throw new BizException("Xml格式不正确。", e);
		}
		return doc;
	}
}
