package iih.ei.std.bd.v1.s.bp;

import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import iih.ei.std.bd.v1.i.BdWebXmlKeyConst;
import iih.ei.std.bd.v1.i.IResultCodeConst;
import iih.ei.std.bd.v1.utils.XmlUtils;
import xap.mw.core.data.BizException;

/**
 * 数据列表序列化业务逻辑
 * 
 * @author hao_wu 2019-2-26
 *
 */
public class DataListSerializeBp {

	public String exec(List<Map<String, Object>> dataList) throws BizException {
		Document document = createDocument(dataList);

		String resultXml = XmlUtils.toString(document);
		return resultXml;
	}

	/**
	 * 创建数据列表XML
	 * 
	 * @param document
	 * @param dataList
	 */
	private void createDataList(Element dataListElement, List<Map<String, Object>> dataList) {
		if (dataList == null || dataList.size() <= 0) {
			return;
		}

		for (Map<String, Object> dataMap : dataList) {
			Element dataElement = dataListElement.addElement(BdWebXmlKeyConst.RESPONSE_DATA);

			for (String propName : dataMap.keySet()) {
				Element propEle = dataElement.addElement(propName);
				String propValue = propValueToString(dataMap.get(propName));
				propEle.setText(propValue);
			}
		}
	}

	/**
	 * 属性值转字符串
	 * 
	 * @param object
	 * @return
	 */
	private String propValueToString(Object obj) {
		if (obj == null) {
			return "";
		}
		return obj.toString();
	}

	/**
	 * 创建XML文档
	 * 
	 * @param dataList
	 * @return
	 * @throws BizException
	 */
	private Document createDocument(List<Map<String, Object>> dataList) {
		Document document = DocumentHelper.createDocument();

		Element resultElement = document.addElement(BdWebXmlKeyConst.RESPONSE);

		Element codeEle = resultElement.addElement(BdWebXmlKeyConst.RESPONSE_CODE);
		codeEle.setText(IResultCodeConst.SUCC);

		resultElement.addElement(BdWebXmlKeyConst.RESPONSE_MSG);

		Element dataListElement = resultElement.addElement(BdWebXmlKeyConst.RESPONSE_DATALIST);
		createDataList(dataListElement, dataList);

		return document;
	}
}
