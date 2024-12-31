package iih.ei.std.bd.v1.s.bp;

import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import iih.ei.std.bd.v1.i.BdWebXmlKeyConst;
import iih.ei.std.bd.v1.i.IResultCodeConst;
import iih.ei.std.bd.v1.model.BdQryRtnData;
import iih.ei.std.bd.v1.utils.XmlUtils;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;

/**
 * 数据列表序列化业务逻辑
 * 
 * @author hao_wu 2019-2-26
 *
 */
public class PagingDataSerializeBp {
	public String exec(BdQryRtnData pagingRtnData) throws BizException {
		// 1.创建文档
		Document document = createDocument(pagingRtnData);

		// 2.将文档转为字符串
		String resultXml = XmlUtils.toString(document);
		return resultXml;
	}

	/**
	 * 创建分页信息节点
	 * 
	 * @param document
	 * @param pgInfo
	 */
	private void createPageInfoEle(Element pageInfoEle, PaginationInfo pgInfo) {

		Element pageSizeEle = pageInfoEle.addElement(BdWebXmlKeyConst.RESPONSE_PAGEINFO_PAGESIZE);
		pageSizeEle.setText(pgInfo.getPageSize().toString());

		Element pageCountEle = pageInfoEle.addElement(BdWebXmlKeyConst.RESPONSE_PAGEINFO_PAGECOUNT);
		pageCountEle.setText(pgInfo.getPageCount().toString());

		Element pageIndexEle = pageInfoEle.addElement(BdWebXmlKeyConst.RESPONSE_PAGEINFO_PAGEINDEX);
		pageIndexEle.setText(pgInfo.getPageIndex().toString());

		Element recordsCountEle = pageInfoEle.addElement(BdWebXmlKeyConst.RESPONSE_PAGEINFO_RECORDSCOUNT);
		recordsCountEle.setText(pgInfo.getRecordsCount().toString());
	}

	/**
	 * 创建数据列表XML
	 * 
	 * @param document
	 * @param dataList
	 */
	private void createDataList(Element dataListEle, List<Map<String, Object>> dataList) {
		if (dataList == null || dataList.size() <= 0) {
			return;
		}
		for (Map<String, Object> dataMap : dataList) {
			Element dataElement = dataListEle.addElement(BdWebXmlKeyConst.RESPONSE_DATA);

			for (String propName : dataMap.keySet()) {
				if ("rownum_".equals(propName.toLowerCase())) {
					continue;
				}
				if ("id_org".equals(propName.toLowerCase())) {
					continue;
				}
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
	 * @param pagingRtnData
	 * @return
	 * @throws BizException
	 */
	private Document createDocument(BdQryRtnData pagingRtnData) {
		Document document = DocumentHelper.createDocument();

		Element resultElement = document.addElement(BdWebXmlKeyConst.RESPONSE);

		Element codeEle = resultElement.addElement(BdWebXmlKeyConst.RESPONSE_CODE);
		codeEle.setText(IResultCodeConst.SUCC);

		resultElement.addElement(BdWebXmlKeyConst.RESPONSE_MSG);

		Element pageInfoEle = resultElement.addElement(BdWebXmlKeyConst.RESPONSE_PAGEINFO);
		// 创建分页信息节点
		createPageInfoEle(pageInfoEle, pagingRtnData.getPgInfo());

		Element dataListEle = resultElement.addElement(BdWebXmlKeyConst.RESPONSE_DATALIST);
		// 创建数据列表节点
		createDataList(dataListEle, pagingRtnData.getPageData());

		return document;
	}
}
