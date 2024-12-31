package iih.ci.ord.s.external.thirdws.op.opr;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import iih.ci.ord.i.external.thirdws.apbt.d.EmsapbtsrvDTO;
import iih.ci.ord.i.external.thirdws.base.EmsCommonSrvDTO;
import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;
import iih.ci.ord.i.external.thirdws.opr.d.EmsOprAddDTO;
import iih.ci.ord.i.external.thirdws.opr.d.EmsOprOrdDTO;
import iih.ci.ord.i.external.thirdws.opr.d.EmsOprPerDTO;
import iih.ci.ord.i.external.thirdws.opr.d.EmsOprSrvDTO;
import iih.ci.ord.i.external.thirdws.opr.d.EntWsOprDTO;
import iih.ci.ord.s.external.thirdws.base.EmsBaseManageBP;
import iih.ci.ord.s.external.thirdws.op.apbu.ThirdEmsApBuSaveBP;
import iih.ci.ord.s.external.thirdws.op.lis.ThirdEmsLisSaveBP;
import xap.mw.core.data.BizException;

/**
 * @code Xml转DTO，并保存手术医嘱信息类
 * @author LiYue
 * @date 2019年6月17日,下午3:44:41
 */
public class EmsOprManageBP extends EmsBaseManageBP{

	public EmsOprManageBP(){
		super(new ThirdEmsOprSaveBP());
	}
	
	/*public String exec(String xmlStr) throws BizException {
		
		
		EntWsOprDTO entWs;
		try {
			entWs = parseXml(xmlStr);
		} catch (UnsupportedEncodingException | DocumentException e) {
			throw new BizException("解析手术回写xml字符串错误:"+e.getMessage(),e);
		}
		ThirdEmsOprSaveBP bp = new ThirdEmsOprSaveBP();
		return bp.save(entWs);
	}*/

	/*public String save(String xmlStr) {
		
		EntWsOprDTO entWs  = parseXml(xmlStr);
		ThirdEmsOprSaveBP bp = new ThirdEmsOprSaveBP();
		return bp.save(entWs);
	}*/

	@Override
	public EntWsDTO pareXmlToDTO(String xmlStr) throws BizException, UnsupportedEncodingException, DocumentException {
		List<String> listAttr = new ArrayList<String>();
		EntWsOprDTO entdto = (EntWsOprDTO)initRtn(EntWsOprDTO.class, listAttr);
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
					List<EmsOprOrdDTO> ordList = entdto.getOrdList();
					if(ordList==null){
						ordList = new ArrayList<EmsOprOrdDTO>();
						entdto.setOrdList(ordList);
					}
					
					EmsOprOrdDTO order = new EmsOprOrdDTO();
					ordList.add(order);
					List<Element> elementList = element.elements();
					
					//医嘱下面所有节点 -检验 费用
					for(Element ordEle : elementList){
						if(ELEMENT_SRV.equals(ordEle.getName().toLowerCase())){ // 费用项目
							List<EmsCommonSrvDTO> srvDtos = order.getSrvList();
							if(srvDtos == null){
								srvDtos = new ArrayList<EmsCommonSrvDTO>();
								order.setSrvList(srvDtos);
							}
							List<Element> srvList = ordEle.elements();
							EmsOprSrvDTO srvDto = new EmsOprSrvDTO();
							srvDtos.add(srvDto);
							for (Element srv : srvList) {
								setVal(srvDto, srv);
							}
						}else if(ELEMENT_ADDITIONAL_SURGERY.equals(ordEle.getName().toLowerCase())){ // 附件手术
							List<EmsOprAddDTO> srvDtos = order.getAddList();
							if(srvDtos == null){
								srvDtos = new ArrayList<EmsOprAddDTO>();
								order.setAddList(srvDtos);
							}
							List<Element> srvList = ordEle.elements();
							EmsOprAddDTO srvDto = new EmsOprAddDTO();
							srvDtos.add(srvDto);
							for (Element srv : srvList) {
								setVal(srvDto, srv);
							}
						}else if(ELEMENT_SUG_EMP.equals(ordEle.getName().toLowerCase())){ // 手术人员
							List<EmsOprPerDTO> srvDtos = order.getPerList();
							if(srvDtos == null){
								srvDtos = new ArrayList<EmsOprPerDTO>();
								order.setPerList(srvDtos);
							}
							List<Element> srvList = ordEle.elements();
							EmsOprPerDTO srvDto = new EmsOprPerDTO();
							srvDtos.add(srvDto);
							for (Element srv : srvList) {
								setVal(srvDto, srv);
							}
						}else {
							setVal(order, ordEle);
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
