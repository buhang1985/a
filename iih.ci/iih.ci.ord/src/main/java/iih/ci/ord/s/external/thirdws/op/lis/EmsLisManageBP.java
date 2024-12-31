package iih.ci.ord.s.external.thirdws.op.lis;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import iih.ci.ord.i.external.thirdws.base.EmsCommonSrvDTO;
import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;
import iih.ci.ord.i.external.thirdws.lis.d.EmsLisOrdDTO;
import iih.ci.ord.i.external.thirdws.lis.d.EmsLisPrintDTO;
import iih.ci.ord.i.external.thirdws.lis.d.EmsLisSrvDTO;
import iih.ci.ord.i.external.thirdws.lis.d.EntWsLisDTO;
import iih.ci.ord.s.external.thirdws.base.EmsBaseManageBP;
import xap.mw.core.data.BizException;

/**
 * @code Xml转DTO，并保存检验医嘱信息类 @author LiYue @date 2019年6月17日,下午3:44:41
 */
public class EmsLisManageBP extends EmsBaseManageBP {

	public EmsLisManageBP() {
		super(new ThirdEmsLisSaveBP());
	}
	@Override
	public EntWsDTO pareXmlToDTO(String xmlStr) throws BizException, UnsupportedEncodingException, DocumentException {
		List<String> listAttr = new ArrayList<String>();
		EntWsLisDTO entdto = (EntWsLisDTO) initRtn(EntWsLisDTO.class, listAttr);
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
				//打印
				if (ELEMENT_PRINT.equals(element.getName().toLowerCase())) {
					List<EmsLisPrintDTO> printDtos = entdto.getPrintList();
					if(printDtos == null){
						printDtos = new ArrayList<EmsLisPrintDTO>();
						entdto.setPrintList(printDtos);
					}
					EmsLisPrintDTO printDto = new EmsLisPrintDTO();
					printDtos.add(printDto);
					List<Element> printEleList = element.elements();
					for(Element printElement : printEleList) {
						if (ELEMENT_ORDER.equals(printElement.getName().toLowerCase())) {
							List<EmsLisOrdDTO> oreDtos = printDto.getOrdList();
							if(oreDtos==null){
								oreDtos = new ArrayList<EmsLisOrdDTO>();
								printDto.setOrdList(oreDtos);
							}
							EmsLisOrdDTO ordDto = new EmsLisOrdDTO();
							oreDtos.add(ordDto);
							List<Element> ordEleList = printElement.elements();
							for(Element ordEle : ordEleList){
								//费用
								if (ELEMENT_SRV.equals(ordEle.getName().toLowerCase())) {
									List<EmsCommonSrvDTO> srvDtos = ordDto.getSrvList();
									if(srvDtos == null){
										srvDtos = new ArrayList<EmsCommonSrvDTO>();
										ordDto.setSrvList(srvDtos);
									}
									EmsLisSrvDTO srcDto = new EmsLisSrvDTO();
									srvDtos.add(srcDto);
									List<Element> srvEleList = ordEle.elements();
									for (Element srvElement : srvEleList) {
										setVal(srcDto, srvElement);
									}
								}else {
									setVal(ordDto, ordEle);
								}
							}
						}else {
							setVal(printDto, printElement);
						}
						
					}
				}else {
					setVal(entdto, element);
				}
			}
		}
		return entdto;
	}

}
