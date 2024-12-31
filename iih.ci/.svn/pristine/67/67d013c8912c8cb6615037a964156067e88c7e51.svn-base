package iih.ci.ord.s.external.thirdws.op.ris;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import iih.ci.ord.i.external.thirdws.base.EmsCommonSrvDTO;
import iih.ci.ord.i.external.thirdws.ris.d.EmsRisOrdDTO;
import iih.ci.ord.i.external.thirdws.ris.d.EmsRisPrintDTO;
import iih.ci.ord.i.external.thirdws.ris.d.EmsRisSrvDTO;
import iih.ci.ord.i.external.thirdws.ris.d.EntWsRisDTO;
import iih.ci.ord.s.external.thirdws.base.EmsBaseManageBP;
import iih.ci.ord.s.external.thirdws.base.IEmsSaveBP;
import iih.ci.ord.s.external.thirdws.base.IValidate;
import xap.mw.core.data.BizException;

public class EmsRisManagerBP extends EmsBaseManageBP {

	public EmsRisManagerBP() {
		super(new ThirdEmsRisSaveBP());
	}

	@Override
	public EntWsRisDTO pareXmlToDTO(String xmlStr)
			throws BizException, UnsupportedEncodingException, DocumentException {
		List<String> listAttr = new ArrayList<String>();
		EntWsRisDTO entdto = (EntWsRisDTO) initRtn(EntWsRisDTO.class, listAttr);
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
				// 打印
				if (ELEMENT_PRINT.equals(element.getName().toLowerCase())) {
					List<EmsRisPrintDTO> printDtos = entdto.getPrintList();
					if (printDtos == null) {
						printDtos = new ArrayList<EmsRisPrintDTO>();
						entdto.setPrintList(printDtos);
					}
					EmsRisPrintDTO printDto = new EmsRisPrintDTO();
					printDtos.add(printDto);
					List<Element> printEleList = element.elements();
					for (Element printElement : printEleList) {
						if (ELEMENT_ORDER.equals(printElement.getName().toLowerCase())) {
							List<EmsRisOrdDTO> oreDtos = printDto.getOrdList();
							if (oreDtos == null) {
								oreDtos = new ArrayList<EmsRisOrdDTO>();
								printDto.setOrdList(oreDtos);
							}
							EmsRisOrdDTO ordDto = new EmsRisOrdDTO();
							oreDtos.add(ordDto);
							List<Element> ordEleList = printElement.elements();
							for (Element ordEle : ordEleList) {
								// 费用
								if (ELEMENT_SRV.equals(ordEle.getName().toLowerCase())) {
									List<EmsCommonSrvDTO> srvDtos = ordDto.getSrvList();
									if(srvDtos == null){
										srvDtos = new ArrayList<EmsCommonSrvDTO>();
										ordDto.setSrvList(srvDtos);
									}
									EmsRisSrvDTO srcDto = new EmsRisSrvDTO();
									srvDtos.add(srcDto);
									List<Element> srvEleList = ordEle.elements();
									for (Element srvElement : srvEleList) {
										setVal(srcDto, srvElement);
									}
								} else {
									setVal(ordDto, ordEle);
								}
							}
						} else {
							setVal(printDto, printElement);
						}

					}
				} else {
					setVal(entdto, element);
				}
			}
		}
		return entdto;
	}

}
