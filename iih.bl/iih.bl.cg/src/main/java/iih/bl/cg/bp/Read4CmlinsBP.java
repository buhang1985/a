package iih.bl.cg.bp;

import iih.bl.cg.bp.qry.GetCodePatQry;
import iih.bl.inc.blincoep.d.BlIncOepDO;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import pkuhit.jspt.webservice.IJsInfoWebService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.log.logging.Logger;
import xap.sys.appfw.orm.utils.AppFwUtil;

public class Read4CmlinsBP {
	IJsInfoWebService _infoService;

	public void exec(IJsInfoWebService infoService) throws BizException {

		_infoService = infoService;

		// 1.发送医院信息并返回xml信息

		String strxml = infoService.queryJsRequestInfoList("21110131");

		// 测试数据
//		 String strxml="<root>"
//		 +"<head>"
//		 +"<code>1</code>"
//		 +"<errorMsg></errorMsg>"
//		 +"</head>"
//		 +"<body>"
//		 +"<output_param>"
//		 +"<jsptParams>"
//		 +"<JSPT_PARAM>"
//		 +"<pid>35ab3ccd4f204eaa8aa5a4683ca8ff35</pid>"
//		 +"<billNos>"
//		 +"<string>2164</string>"
//		 +"</billNos>"
//		 +"<bxType>FZRS</bxType>"
//		 +"<sysHospCode>21110131</sysHospCode>"
//		 +"<receiptSn>18909761</receiptSn>"
//		 +"<visitType>gh_yb</visitType>"
//		 +"<hisPid>000100920500</hisPid>"
//		 +"</JSPT_PARAM>"
//		 +"</jsptParams>"
//		 +"</output_param>"
//		 +"</body>"
//		 +"</root>";
		// 2.通过返回xml信息解析返回读取IIH返回数据

		get4CmlInsToXml(strxml);

	}

	/**
	 * 判断提交是否成功
	 * 
	 * @param saveJsXml
	 * @return
	 */
	private Boolean IsSuccess(String saveJsXml) {

		SAXReader reader = new SAXReader();
		Document doc = null;
		try {
			ByteArrayInputStream stm = new ByteArrayInputStream(saveJsXml.getBytes());
			doc = reader.read(stm);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 获取根节点元素对象
		Element root = doc.getRootElement();
		Node node = root.selectSingleNode("/root");
		Node headno = node.selectSingleNode("head");
		String errorcode = getNodeValue(headno, "code");
		String errorMsg = getNodeValue(headno, "errorMsg");
		if (errorcode.equals("1")) {
			return true;
		} else {
			new BizException("商保上传失败。message：" + errorMsg);
			// 打印失败日志
		}

		return true;
	}

	/**
	 * 根据XML查询数据，并提交
	 * 
	 * @param strXml
	 * @throws BizException
	 */

	public void get4CmlInsToXml(String strXml) throws BizException {
		if (strXml == null || strXml.equals("")) {
			return;
		}

		String codePat = "";
		String firmCode = "";
		String sysHospCode = "";
		ArrayList<String> billNos = new ArrayList<String>();

		SAXReader reader = new SAXReader();
		Document doc = null;
		try {
			ByteArrayInputStream stm = new ByteArrayInputStream(strXml.getBytes());
			doc = reader.read(stm);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String, String> incAndPidMap = new HashMap<String, String>();
		Map<String, String> incAndFirmMap = new HashMap<String, String>();
		ArrayList<String> retXMLList = new ArrayList<String>();
		Element root = doc.getRootElement();
		Node node = root.selectSingleNode("/root");
		Node headno = node.selectSingleNode("head");
		String errorcode = getNodeValue(headno, "code");
		if (errorcode.equals("1")) {
			Node bodyno = node.selectSingleNode("body/output_param");
			List<Node> nodes = bodyno.selectNodes("jsptParams/JSPT_PARAM");
			if (nodes != null && nodes.size() != 0) {
				for (Node node2 : nodes) {
					codePat = getNodeValue(node2, "pid");
					firmCode = getNodeValue(node2, "bxType");
					sysHospCode = getNodeValue(node2, "sysHospCode");
					List<Node> billnodes = node2.selectNodes("billNos/string");
					if (billnodes != null && billnodes.size() != 0)
						for (int i = 0; i < billnodes.size(); i++) {
							String incNo = billnodes.get(i).getText();
							billNos.add(incNo);
							incAndPidMap.put(incNo, codePat);
							incAndFirmMap.put(incNo, firmCode);
						}

				}
			}
		}
		Logger.info("商保上传开始");
		if (billNos != null && billNos.size() != 0) {
			BlIncOepDO[] pis = (BlIncOepDO[]) AppFwUtil.getDORstWithDao(new GetCodePatQry(billNos.toArray(new String[0])), BlIncOepDO.class);
			String testXML = "";
			for (BlIncOepDO blIncOepDO : pis) {
				Get4CmlInsToXmlBP get4CmlInsToXmlBP = new Get4CmlInsToXmlBP();
				String retXML = get4CmlInsToXmlBP.exec(new String[] { blIncOepDO.getIncno() }, blIncOepDO.getId_pat(), incAndPidMap.get(blIncOepDO.getIncno()),
						incAndFirmMap.get(blIncOepDO.getIncno()), sysHospCode);

				try {
					// 3. 发送IIH返回xml
					if (!StringUtil.isEmpty(retXML)) {
						// TODO 测试,抛出XML
						// testXML+=("商保测试0000000000000|"+retXML);

						String saveJsXml = _infoService.saveJsXml(retXML);

						Logger.info(blIncOepDO.getIncno() + "已提交,返回值为:" + saveJsXml);
						// 4.解析返回的xml
						boolean isSuccess = IsSuccess(saveJsXml);
					}

				} catch (Exception e) {
					Logger.error(blIncOepDO.getIncno() + "提交商保发生异常,异常信息为:" + e.getMessage());
					continue;
				}
			}
			// throw new BizException(testXML);
		}
		Logger.info("商保上传结束");

	}

	/**
	 * 获取xml节点值
	 * 
	 * @param node
	 * @param name
	 * @return
	 */
	private String getNodeValue(Node node, String name) {
		if (node == null)
			return "";
		Node no = node.selectSingleNode(name);
		if (no == null)
			return "";
		return no.getText();
	}

}
