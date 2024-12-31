package iih.ci.ord.s.external.thirdws.op.treat;

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
import iih.ci.ord.i.external.thirdws.treat.d.EmstreatOrdDTO;
import iih.ci.ord.i.external.thirdws.treat.d.EmstreatSrvDTO;
import iih.ci.ord.i.external.thirdws.treat.d.EntWstreatDTO;
import iih.ci.ord.s.external.thirdws.base.EmsBaseManageBP;
import xap.mw.core.data.BizException;

/**
 * @code 第三方回传 xml转DTO,保存 @author LiYue
 * @date 2019年6月19日,下午5:48:38
 */
public class EmsTreatManageBP extends EmsBaseManageBP {

	public EmsTreatManageBP() {
		super(new ThirdEmsTreatSaveBP());
	}

	@Override
	public EntWsDTO pareXmlToDTO(String xmlStr) throws BizException, UnsupportedEncodingException, DocumentException {
		List<String> listAttr = new ArrayList<String>();
		EntWstreatDTO entdto = (EntWstreatDTO) initRtn(EntWstreatDTO.class, listAttr);
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
				if (ELEMENT_ORDER.equals(element.getName().toLowerCase())) {
					List<EmstreatOrdDTO> oreDtos = entdto.getOrdList();
					if (oreDtos == null) {
						oreDtos = new ArrayList<EmstreatOrdDTO>();
						entdto.setOrdList(oreDtos);
					}
					EmstreatOrdDTO ordDto = new EmstreatOrdDTO();
					oreDtos.add(ordDto);
					List<Element> ordEleList = element.elements();
					for (Element ordEle : ordEleList) {
						// 费用
						if (ELEMENT_SRV.equals(ordEle.getName().toLowerCase())) {
							List<EmsCommonSrvDTO> srvDtos = ordDto.getSrvList();
							if (srvDtos == null) {
								srvDtos = new ArrayList<EmsCommonSrvDTO>();
								ordDto.setSrvList(srvDtos);
							}
							EmstreatSrvDTO srcDto = new EmstreatSrvDTO();
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
					setVal(entdto, element);
				}
			}
		}
		return entdto;
	}

}
