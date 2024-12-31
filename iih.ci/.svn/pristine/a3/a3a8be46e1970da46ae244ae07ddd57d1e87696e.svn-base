package iih.ci.ord.s.external.blood.ruimei.s.bp;

import java.util.List;
import java.util.Map;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;

public class GeneralBaseDataXml {
	/**
	 * 主入口
	 * 
	 * @param datas
	 * @param nameRoot
	 * @return
	 * @throws BizException
	 */
	public String exec(List<Map<String, Object>> datas, String nameRoot) throws BizException {

		// 1、基础校验
		validation(nameRoot);

		// 2、实例化Document对象
		Document document = ApiUtils.getDocumentObj();

		// 3、实例化根节点
		Element root = initXml(document, nameRoot);

		// 4、生成数据
		generanXml(document, root, datas, nameRoot);

		// 5、转换Xml
		String rtn = ApiUtils.getXmlStr(document);

		return rtn;
	}

	/**
	 * 基础校验
	 * 
	 * @param nameRoot
	 * @throws BizException
	 */
	private void validation(String nameRoot) throws BizException {
		if (StringUtil.isEmptyWithTrim(nameRoot)) {
			throw new BizException("基础数据：必须有根节点名称！");
		}
	}

	/**
	 * 实例化结果信息，并返回根节点
	 * 
	 * @param document
	 * @return
	 */
	private Element initXml(Document document, String nameRoot) {
		Element root = document.createElement("result");
		document.appendChild(root);
		Element resultmsgEle = document.createElement("resultmsg");
		root.appendChild(resultmsgEle);
		Element codeEle = document.createElement("code");
		codeEle.setTextContent("0");
		resultmsgEle.appendChild(codeEle);
		Element msgEle = document.createElement("message");
		resultmsgEle.appendChild(msgEle);
		Element datasEle = document.createElement(nameRoot + "s");
		root.appendChild(datasEle);
		return datasEle;
	}

	/**
	 * 根据数据集合生成Xml
	 * 
	 * @param document
	 * @param root
	 * @param datas
	 * @param nameRoot
	 */
	private void generanXml(Document document, Element root, List<Map<String, Object>> datas, String nameRoot) {
		if (datas == null || datas.size() < 1) {
			return;
		}
		for (Map<String, Object> row : datas) {
			Element dataEle = document.createElement(nameRoot);
			root.appendChild(dataEle);
			for (Map.Entry<String, Object> column : row.entrySet()) {
				if (column != null) {
					Element columnEle = getColumnEle(document, column.getKey(), column.getValue());
					if (columnEle != null) {
						dataEle.appendChild(columnEle);
					}
				}
			}
		}
	}

	/**
	 * 生成一行一列节点
	 * 
	 * @param document
	 * @param root
	 * @param columnName
	 * @param value
	 */
	private Element getColumnEle(Document document, String columnName, Object value) {
		if (!StringUtil.isEmptyWithTrim(columnName)) {
			Element columnEle = document.createElement(columnName);
			if (value != null) {
				columnEle.setTextContent(value.toString());
			}
			return columnEle;
		}
		return null;
	}


}
