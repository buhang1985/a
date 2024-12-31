package iih.ci.ord.s.external.thirdws.op.apbu;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import iih.ci.ord.i.external.thirdws.apbu.d.EmsapbubbDTO;
import iih.ci.ord.i.external.thirdws.apbu.d.EmsapbuentDTO;
import iih.ci.ord.i.external.thirdws.apbu.d.EmsapbuordDTO;
import iih.ci.ord.i.external.thirdws.base.EmsCommonSrvDTO;
import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;
import iih.ci.ord.s.external.thirdws.base.EmsBaseManageBP;
import xap.mw.core.data.BizException;

public class EmsApbuManageBP extends EmsBaseManageBP{

	public EmsApbuManageBP() {
		super(new ThirdEmsApBuSaveBP());
	}
	@Override
	public EntWsDTO pareXmlToDTO(String xmlStr) throws BizException, UnsupportedEncodingException, DocumentException {
		List<String> listAttr = new ArrayList<String>();
		EmsapbuentDTO entdto = (EmsapbuentDTO)initRtn(EmsapbuentDTO.class, listAttr);
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
			//ent下面所有节点
			for (Element element : entEleList) {
				if (element == null)
					continue;
				if (ELEMENT_ORDER.equals(element.getName().toLowerCase())) {
					List<EmsapbuordDTO> ordDtos = entdto.getOrdlist();
					if(ordDtos==null){
						ordDtos = new ArrayList<EmsapbuordDTO>();
						entdto.setOrdlist(ordDtos);
					}
					EmsapbuordDTO presDto = new EmsapbuordDTO();
					ordDtos.add(presDto);
					List<Element> presEleList = element.elements();
					//医嘱下面所有节点  
					for(Element presEle : presEleList){
						//费用
						if(ELEMENT_SRV.equals(presEle.getName().toLowerCase())){
							List<EmsCommonSrvDTO> srvDtos = presDto.getSrvList();
							if(srvDtos == null){
								srvDtos = new ArrayList<EmsCommonSrvDTO>();
								presDto.setSrvList(srvDtos);
							}
							List<Element> srvList = presEle.elements();
							EmsCommonSrvDTO srvDto = new EmsCommonSrvDTO();
							srvDtos.add(srvDto);
							for (Element srv : srvList) {
								setVal(srvDto, srv);
							}
						}else if(ELEMENT_BB_INFO.equals(presEle.getName().toLowerCase())){
							List<EmsapbubbDTO> bbDtos = presDto.getBbList();
							if(bbDtos == null){
								bbDtos = new ArrayList<EmsapbubbDTO>();
								presDto.setBbList(bbDtos);
							}
							List<Element> srvList = presEle.elements();
							EmsapbubbDTO bbDto = new EmsapbubbDTO();
							bbDtos.add(bbDto);
							for (Element srv : srvList) {
								setVal(bbDto, srv);
							}
						}else {
							setVal(presDto, presEle);
						}
					}
				}else{
					setVal(entdto, element);
				}
			}
		}
		return entdto;
	}

}
