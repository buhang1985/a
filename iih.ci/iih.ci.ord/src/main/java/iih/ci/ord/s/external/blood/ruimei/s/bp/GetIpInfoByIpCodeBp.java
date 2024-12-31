package iih.ci.ord.s.external.blood.ruimei.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import iih.ci.ord.external.blood.ruimei.d.PatIpcodeParam;
import iih.ci.ord.external.blood.ruimei.d.Patientinfo;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;

public class GetIpInfoByIpCodeBp {


	public String exec(PatIpcodeParam param) throws BizException {

		// 1、基础校验
		List<String> listMsg = new ArrayList<String>();
		validation(param, listMsg);

		// 2、创建Document对象
		Document document = getDocumentObj();

		// 3、实例化Title，返回title节点
		HashMap<String, Element> mapEle = new HashMap<String, Element>();
		Element root = initTitle(document, mapEle);

		// 4、满足中断条件时，生成Xml并返回
		if (isInterrupt(mapEle, listMsg)) {
			return getXmlStr(document);
		}

		try {

			// 5、查询住院患者信息
			Patientinfo[] patients = getIpInfo(param);

			// 6、DTO转换xml
//			if (patients != null && patients.length > 0) {
//				conversionXml(document, root, patients);
//			}
			
			return conversionXml_new(document,root,patients);

		} catch (BizException e) {

			// 7、满足中断条件时，生成Xml并返回
			List<String> listError = new ArrayList<String>();
			listError.add(e.getMessage());
			if (isInterrupt(mapEle, listError)) {
				return getXmlStr(document);
			}
		}

		// 7、生成结果xml
//		String rtn = getXmlStr(document);

		return null;
	}
	
	private String conversionXml_new(Document document,Element root, BaseDTO[] params) throws BizException {
		ConvertDTOs2XmlUtils bp = new ConvertDTOs2XmlUtils();
		return bp.exec2( params,root,document);
	}

	/**
	 * 基础校验
	 * 
	 * @param param
	 * @param mapCond
	 * @throws BizException
	 */
	private void validation(PatIpcodeParam param, List<String> listMsg) {
		if (param == null) {
			listMsg.add("参数空异常");
		}

		if (StringUtil.isEmptyWithTrim(param.getIpcode())) {
			listMsg.add("“住院号”没被赋值");
		}
	}

	/**
	 * 实例化Document对象，增加
	 * 
	 * @return
	 * @throws BizException
	 */
	private Document getDocumentObj() throws BizException {
		return ApiUtils.getDocumentObj();
	}

	/**
	 * 实例化结果信息，并返回根节点
	 * 
	 * @param document
	 * @return
	 */
	private Element initTitle(Document document, HashMap<String, Element> reMap) {

		// 根节点
		Element root = document.createElement("result");
		document.appendChild(root);

		// title节点
		Element titleRoot = document.createElement("result_title");
		root.appendChild(titleRoot);

		// title内容节点
		Element eleCode = document.createElement("code");
		eleCode.setTextContent("0");
		Element eleMsg = document.createElement("message");
		eleMsg.setTextContent("");
		titleRoot.appendChild(eleCode);
		titleRoot.appendChild(eleMsg);

		reMap.put("code", eleCode);
		reMap.put("message", eleMsg);

		return root;
	}

	/**
	 * 是否满足中断条件
	 * 
	 * @param reMap
	 * @param listMsg
	 * @return
	 */
	private boolean isInterrupt(HashMap<String, Element> reMap, List<String> listMsg) {

		if (listMsg.size() > 0) {

			String msgStr = "";
			for (String msg : listMsg) {
				msgStr += (msgStr.length() == 0 ? "" : ",") + msg;
			}
			reMap.get("code").setTextContent("1");
			reMap.get("message").setTextContent(msgStr);
			return true;
		}
		return false;
	}

	/**
	 * 查询住院患者信息
	 * 
	 * @param param
	 * @param code
	 * @return
	 * @throws BizException
	 */
	private Patientinfo[] getIpInfo(PatIpcodeParam param) throws BizException {
		QueryPatientInfo8IpCodeBp bp = new QueryPatientInfo8IpCodeBp();
		return bp.exec(param);
	}

	/**
	 * 将指定的DTO对象转换为xml
	 * 
	 * @param document
	 * @param root
	 * @param param
	 */
//	private void conversionXml(Document document, Element root, BaseDTO[] params) throws BizException {
//		ConversionDTOSToXmlBp bp = new ConversionDTOSToXmlBp();
//		bp.exec(document, root, params);
//	}

	/**
	 * 生成xml字符串
	 * 
	 * @param document
	 * @return
	 * @throws BizException
	 */
	private String getXmlStr(Document document) throws BizException {
		return ApiUtils.getXmlStr(document);
	}

}
