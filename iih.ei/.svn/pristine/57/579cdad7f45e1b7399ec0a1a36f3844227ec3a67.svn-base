package iih.ei.std.bd.v1.model;

import org.dom4j.Document;
import org.dom4j.Element;

import iih.ei.std.bd.v1.i.BdWebXmlKeyConst;
import iih.ei.std.bd.v1.utils.XmlUtils;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;

/**
 * 基础数据分页查询参数
 * 
 * @author hao_wu 2019-2-27
 *
 */
public class BDQryParam {

	/**
	 * 接口编码
	 */
	private String itfCode;

	/**
	 * 分页信息
	 */
	private PaginationInfo pgInfo;

	/**
	 * 内部参数XML
	 */
	private String innerParamXml;

	public String getItfCode() {
		return itfCode;
	}

	public void setItfCode(String interfaceCode) {
		this.itfCode = interfaceCode;
	}

	public PaginationInfo getPgInfo() {
		return pgInfo;
	}

	public void setPgInfo(PaginationInfo pgInfo) {
		this.pgInfo = pgInfo;
	}

	public String getInnerParamXml() {
		return innerParamXml;
	}

	public void setInnerParamXml(String innerParamXml) {
		this.innerParamXml = innerParamXml;
	}

	public static BDQryParam deSerializeByXml(String xml) throws BizException {
		Document doc = XmlUtils.getDocument(xml);

		String itfCodePath = String.format("/%s/%s", BdWebXmlKeyConst.REQUEST, BdWebXmlKeyConst.REQUEST_ITFCODE);
		Element itfCodeEle = (Element) doc.selectSingleNode(itfCodePath);
		String itfCode = itfCodeEle.getText();

		String pageInfoNodePath = String.format("/%s/%s", BdWebXmlKeyConst.REQUEST, BdWebXmlKeyConst.REQUEST_PAGEINFO);
		Element pageInfoEle = (Element) doc.selectSingleNode(pageInfoNodePath);
		PaginationInfo pgInfo = createPgInfo(pageInfoEle);

		String paramListNodePath = String.format("/%s/%s", BdWebXmlKeyConst.REQUEST,
				BdWebXmlKeyConst.REQUEST_PARAMLIST);
		Element paramListEle = (Element) doc.selectSingleNode(paramListNodePath);
		String paramListXml = paramListEle == null ? null : paramListEle.asXML();

		BDQryParam qryParam = new BDQryParam();
		qryParam.setItfCode(itfCode);
		qryParam.setPgInfo(pgInfo);
		qryParam.setInnerParamXml(paramListXml);

		return qryParam;
	}

	/**
	 * 根据XML节点信息创建分页信息
	 * 
	 * @param pageInfoEle
	 * @return
	 */
	private static PaginationInfo createPgInfo(Element pageInfoEle) {
		if (pageInfoEle == null) {
			return null;
		}

		PaginationInfo pgInfo = new PaginationInfo();

		String pageSizeStr = pageInfoEle.elementText(BdWebXmlKeyConst.REQUEST_PAGEINFO_PAGESIZE);
		Integer pageSize = Integer.parseInt(pageSizeStr);

		String pageIndexStr = pageInfoEle.elementText(BdWebXmlKeyConst.REQUEST_PAGEINFO_PAGEINDEX);
		Integer pageIndex = Integer.parseInt(pageIndexStr);

		pgInfo.setPageSize(pageSize);
		pgInfo.setPageIndex(pageIndex);
		return pgInfo;
	}
}
