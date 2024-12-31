package iih.ci.ord.s.external.blood.ruimei.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.external.blood.ruimei.d.IEOpUbOrEnParamDTO;
import iih.ci.ord.s.external.thirdws.utils.RstMsgBP;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class WriteBackUBTDataBp {

	public String exec(IEOpUbOrEnParamDTO param) throws BizException {
		validation(param);

		writebackUBTData(param);

		return RstMsgBP.getRstMsgCodeMsg("0", "用血医嘱回写成功");
	}

	/**
	 * 回写用血医嘱
	 * 
	 * @param param
	 */
	private void writebackUBTData(IEOpUbOrEnParamDTO param) throws BizException {
		SaveWritebackUBTDataBp bp = new SaveWritebackUBTDataBp();
		bp.exec(param);
	}

	/**
	 * 数据校验
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private List<String> validation(IEOpUbOrEnParamDTO param) throws BizException {

		List<String> reList = new ArrayList<String>();
		if (param == null) {
			throw new BizException("参数空异常！");
		}
		if(param.getApplyno()==null||param.getApplyno().trim().length()==0)
			throw new BizException("传入的申请单号为空！");
		if(param.getName_or()==null||param.getName_or().trim().length()==0)
			throw new BizException("传入的医嘱名称为空！");
		CiOrderDO[] ords=ServiceFinder.find(ICiorderMDORService.class).find(" applyno='"+param.getApplyno()+"' ", "", FBoolean.FALSE);
		if(ords!=null&&ords.length>0)
			throw new BizException("该申请单号重复");
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
		Element root = document.createElement("results");
		document.appendChild(root);

		// title内容节点
		Element eleCode = document.createElement("code");
		eleCode.setTextContent("0");
		Element eleMsg = document.createElement("message");
		eleMsg.setTextContent("");
		root.appendChild(eleCode);
		root.appendChild(eleMsg);

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
