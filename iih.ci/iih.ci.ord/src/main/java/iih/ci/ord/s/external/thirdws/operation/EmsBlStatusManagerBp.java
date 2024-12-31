package iih.ci.ord.s.external.thirdws.operation;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;
import iih.ci.ord.s.external.thirdws.base.EmsBaseManageBP;
import iih.ci.ord.s.external.thirdws.utils.RstMsgBP;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;

public class EmsBlStatusManagerBp extends EmsBaseManageBP{
	public EmsBlStatusManagerBp() {
	}

	public String pareXml(String xmlStr) throws BizException {
		SAXReader reader= new SAXReader();
		String code_ors ="";
		try {
			//读取XML文件内容
			Document document = reader.read(new ByteArrayInputStream(xmlStr.getBytes("UTF-8")) );
			//获取XML根节点
			Element eleRoot = document.getRootElement();
			if (eleRoot != null) {
				//获取XML根节点下面的元素
				List<Element> listEle = eleRoot.elements();
				if (listEle == null || listEle.size() < 1) {
					return null;
				}

				
				for (Element element : listEle) {
					if (element == null)
						continue;
					// 遍历Xml节点，赋值给DTO
					if (ElEMENT_CODE_OR.equals(element.getName().toLowerCase())) {
						//setVal(rtn, element);
						if (element.getData() != null && !StringUtil.isEmptyWithTrim(element.getData().toString())) {
							code_ors=code_ors+element.getData()+",";
						}
						
					}
				}
			}
			return code_ors;
		} catch (Exception e1) {
			throw new BizException("解析Xml异常！");
		}
	}

	@Override
	public EntWsDTO pareXmlToDTO(String xmlStr) throws BizException, UnsupportedEncodingException, DocumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String save(String xmlStr){
		String xmlparam;
		try {
			xmlparam = pareXml(xmlStr);
			if (StringUtils.isEmpty(xmlparam)) {
				
				return RstMsgBP.getRstMsg("1", "医嘱编码为空！");
			}else{
				ThirdGetBlStatusBP bp1= new ThirdGetBlStatusBP();
				return bp1.getBlStatus(xmlparam);
			}
			
		} catch (BizException e) {
			return RstMsgBP.getRstMsg("1", e.getMessage());
		}
	}
}
