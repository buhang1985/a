package iih.ci.ord.s.external.blood.ruimei.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import iih.ci.ord.external.blood.ruimei.d.IEOpBtUbCancelOrEnParamDTO;
import xap.mw.core.data.BizException;

public class WriteBackUBPBCancleDataBp {
	

	
	
	public String exec(IEOpBtUbCancelOrEnParamDTO param)throws BizException{
		// 1、基础校验
		List<String> listMsg = validation(param);
		// 2、创建Document对象
		Document document = getDocumentObj();

		// 3、实例化Title，返回title节点
		HashMap<String, Element> mapEle = new HashMap<String, Element>();
		initTitle(document, mapEle);
		// 4、满足中断条件时，生成Xml并返回
		if (isInterrupt(mapEle, listMsg)) {
			return getXmlStr(document);
		}
		boolean result=false;
 		result=new SaveWriteBackCancleUbPbDataBp().exec(param);
		if(result) {
        //生成成功结果
			mapEle.get("resultCode").setTextContent("0");
			mapEle.get("resultMsg").setTextContent("成功");
		}else {
			mapEle.get("resultCode").setTextContent("1");
			mapEle.get("resultMsg").setTextContent("用血医嘱保存失败");
		}
		// 7、生成结果xml
		String rtn = getXmlStr(document);

		return rtn;

	}
	
	
	/**
	 * 数据校验
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private List<String> validation(IEOpBtUbCancelOrEnParamDTO param) throws BizException {

		List<String> reList = new ArrayList<String>();
		if (param == null) {
			throw new BizException("参数空异常！");
		}

		return reList;
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
		Element root = document.createElement("Root");
		document.appendChild(root);

		// title内容节点
		Element eleCode = document.createElement("resultCode");
		eleCode.setTextContent("0");
		Element eleMsg = document.createElement("resultMsg");
		eleMsg.setTextContent("");
		root.appendChild(eleCode);
		root.appendChild(eleMsg);

		reMap.put("resultCode", eleCode);
		reMap.put("resultMsg", eleMsg);

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
			reMap.get("resultCode").setTextContent("1");
			reMap.get("resultMsg").setTextContent(msgStr);
			return true;
		}
		return false;
	}

	
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
