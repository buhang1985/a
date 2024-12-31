package iih.ci.ord.s.external.thirdws.op.drugs;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import iih.ci.ord.i.external.thirdws.base.EmsCommonSrvDTO;
import iih.ci.ord.i.external.thirdws.drugs.d.EmsDrugsOrdDTO;
import iih.ci.ord.i.external.thirdws.drugs.d.EmsDrugsPresDTO;
import iih.ci.ord.i.external.thirdws.drugs.d.EmsDrugsSrvDTO;
import iih.ci.ord.i.external.thirdws.drugs.d.EntWsDrugsDTO;
import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;
import iih.ci.ord.s.external.thirdws.base.EmsBaseManageBP;
import xap.mw.core.data.BizException;

/**
 * Xml转DTO，并保存医嘱信息类
 * 
 * @author zhangwq
 *
 */
public class EmsDrugManageBP extends EmsBaseManageBP{
	// 第一步，将xml解析成DTO

	// 第二步，调用savebp完成保存
	
	public EmsDrugManageBP() {
		super(new ThirdEmsDrugsSaveBP());
		
		// TODO Auto-generated constructor stub
	}
	/**
	 * 将xml入参解析成dto
	 * 
	 * @param xmlstr
	 * @return
	 * @throws BizException 
	 * @throws DocumentException 
	 * @throws UnsupportedEncodingException 
	 */
	public EntWsDTO pareXmlToDTO(String xmlStr) throws BizException, UnsupportedEncodingException, DocumentException {
		List<String> listAttr = new ArrayList<String>();
		EntWsDrugsDTO entdto = (EntWsDrugsDTO)initRtn(EntWsDrugsDTO.class, listAttr);
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
				if (ELEMENT_PRES.equals(element.getName().toLowerCase())) {
					List<EmsDrugsPresDTO> presDtos = entdto.getPresList();
					if(presDtos==null){
						presDtos = new ArrayList<EmsDrugsPresDTO>();
						entdto.setPresList(presDtos);
					}
					EmsDrugsPresDTO presDto = new EmsDrugsPresDTO();
					presDtos.add(presDto);
					List<Element> presEleList = element.elements();
					for(Element presEle : presEleList){
						if (ELEMENT_ORDER.equals(presEle.getName().toLowerCase())) {
							List<EmsDrugsOrdDTO> ordDtos = presDto.getOrdList();
							if(ordDtos == null){
								ordDtos = new ArrayList<EmsDrugsOrdDTO>();
								presDto.setOrdList(ordDtos);
							}
							EmsDrugsOrdDTO ordDto = new EmsDrugsOrdDTO();
							ordDtos.add(ordDto);
							List<Element> ordEleList = presEle.elements();
							for (Element ordEle : ordEleList) {
								if (ordEle == null)
									continue;
								if (ELEMENT_SRV.equals(ordEle.getName().toLowerCase())) {
									List<EmsCommonSrvDTO> srvDtos = ordDto.getSrvList();
									if(srvDtos==null){
										srvDtos = new ArrayList<EmsCommonSrvDTO>();
										ordDto.setSrvList(srvDtos);
									}
									List<Element> srvEleList = ordEle.elements();
									EmsDrugsSrvDTO srvDto = new EmsDrugsSrvDTO();
									srvDtos.add(srvDto);
									for (Element srvEle : srvEleList) {
										setVal(srvDto, srvEle);
									}
								} else {
									setVal(ordDto, ordEle);
								}
							}
						} else{
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
