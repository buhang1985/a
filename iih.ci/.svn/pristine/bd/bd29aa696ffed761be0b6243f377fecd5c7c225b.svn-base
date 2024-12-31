package iih.ci.ord.s.external.thirdws.op.apbt;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import iih.ci.ord.i.external.thirdws.apbt.d.EmsapbtBloodItemDTO;
import iih.ci.ord.i.external.thirdws.apbt.d.EmsapbtentDTO;
import iih.ci.ord.i.external.thirdws.apbt.d.EmsapbtordDTO;
import iih.ci.ord.i.external.thirdws.apbt.d.EmsapbtsrvDTO;
import iih.ci.ord.i.external.thirdws.apbt.d.EmsapbtviewitemDTO;
import iih.ci.ord.i.external.thirdws.base.EmsCommonSrvDTO;
import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;
import iih.ci.ord.s.external.thirdws.base.EmsBaseManageBP;
import xap.mw.core.data.BizException;

public class EmsApbtManageBP extends EmsBaseManageBP{
	public EmsApbtManageBP() {
		super(new ThirdEmsApBtSaveBP());
	}
	/**
	 * 解析xml
	 */
	@Override
	public EntWsDTO pareXmlToDTO(String xmlStr) throws BizException, UnsupportedEncodingException, DocumentException {
		List<String> listAttr = new ArrayList<String>();
		EmsapbtentDTO entdto = (EmsapbtentDTO)initRtn(EmsapbtentDTO.class, listAttr);
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
					List<EmsapbtordDTO> ordDtos = entdto.getOrdList();
					if(ordDtos==null){
						ordDtos = new ArrayList<EmsapbtordDTO>();
						entdto.setOrdList(ordDtos);
					}
					EmsapbtordDTO presDto = new EmsapbtordDTO();
					ordDtos.add(presDto);
					List<Element> presEleList = element.elements();
					//医嘱下面所有节点 -检验 费用
					for(Element presEle : presEleList){
						//检验
						if (ELEMENT_CHECK.equals(presEle.getName().toLowerCase())) {
							List<EmsapbtviewitemDTO> checkDtos = presDto.getCheckList();
							if(checkDtos == null){
								checkDtos = new ArrayList<EmsapbtviewitemDTO>();
								presDto.setCheckList(checkDtos);
							}
							List<Element> checkList = presEle.elements();
							EmsapbtviewitemDTO checkDto = new EmsapbtviewitemDTO();
							checkDtos.add(checkDto);
							for (Element ckeck : checkList) {
								setVal(checkDto, ckeck);
							}
							//费用
						} else if(ELEMENT_SRV.equals(presEle.getName().toLowerCase())){
							List<EmsCommonSrvDTO> srvDtos = presDto.getSrvList();
							if(srvDtos == null){
								srvDtos = new ArrayList<EmsCommonSrvDTO>();
								presDto.setSrvList(srvDtos);
							}
							List<Element> srvList = presEle.elements();
							EmsapbtsrvDTO srvDto = new EmsapbtsrvDTO();
							srvDtos.add(srvDto);
							for (Element srv : srvList) {
								setVal(srvDto, srv);
							}
							//血液成分
						}else if(ELEMENT_BLOOD_ITEM.equals(presEle.getName().toLowerCase())){
							List<EmsapbtBloodItemDTO> srvDtos = presDto.getBloodItemList();
							if(srvDtos == null){
								srvDtos = new ArrayList<EmsapbtBloodItemDTO>();
								presDto.setBloodItemList(srvDtos);
							}
							List<Element> srvList = presEle.elements();
							EmsapbtBloodItemDTO srvDto = new EmsapbtBloodItemDTO();
							srvDtos.add(srvDto);
							for (Element srv : srvList) {
								setVal(srvDto, srv);
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
	
	private void blood2srv(Element srv,EmsCommonSrvDTO dto) {
		
	}
}
