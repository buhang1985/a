package iih.ci.ord.s.external.thirdws.diag;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import iih.ci.ord.i.external.thirdws.diag.d.EmsDiagDto;
import iih.ci.ord.i.external.thirdws.diag.d.EntWsDiagDTO;
import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;
import iih.ci.ord.s.external.thirdws.base.EmsBaseManageBP;
import iih.ci.ord.s.external.thirdws.utils.RstMsgBP;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;

public class EmsDiagManagerBP extends EmsBaseManageBP {

	public EmsDiagManagerBP() {
		super(new ThirdCiDiagSaveBP());
	}

	// 第一步，将xml解析成DTO
	/**
	 * 将xml入参解析成dto
	 * 
	 * @param xmlstr
	 * @return
	 * @throws BizException
	 * @throws DocumentException
	 * @throws UnsupportedEncodingException
	 */
	

	@Override
	public EntWsDTO pareXmlToDTO(String xmlStr) throws BizException, UnsupportedEncodingException, DocumentException {
		List<String> listAttr = new ArrayList<String>();
		EntWsDiagDTO entdto = (EntWsDiagDTO) initRtn(EntWsDiagDTO.class, listAttr);
		SAXReader reader = new SAXReader();
		Document document = reader.read(new ByteArrayInputStream(xmlStr.getBytes("UTF-8")));
		Element eleRoot = document.getRootElement();
		if (eleRoot != null) {
			// 获取XML根节点下面的元素
			List<Element> listEle = eleRoot.elements(ELEMENT_ENT);
			if (listEle == null || listEle.size() < 1) {
				return null;
			}
			Element entele = listEle.get(0);
			List<Element> entEleList = entele.elements();
			for (Element element : entEleList) {
				if (element == null)
					continue;
				if (ELEMENT_DIAG.equals(element.getName().toLowerCase())) {
					List<EmsDiagDto> diagList = entdto.getDiagList();
					if (diagList == null) {
						diagList = new ArrayList<EmsDiagDto>();
						entdto.setDiagList(diagList);
					}
					List<Element> diagEleList = element.elements();
					EmsDiagDto emsDiagDto = new EmsDiagDto();

					diagList.add(emsDiagDto);
					for (Element diagEle : diagEleList) {
						setVal(emsDiagDto, diagEle);
					}
				} else {
					setVal(entdto, element);
				}
			}
		}
		return entdto;
	}

	
}
