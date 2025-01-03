package iih.ci.ord.s.external.thirdws.operation;
import static org.hamcrest.CoreMatchers.nullValue;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.external.thirdws.base.EmsValidateRstDTO;
import iih.ci.ord.i.external.thirdws.base.StringList;
import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;
import iih.ci.ord.i.external.thirdws.operation.d.EmsCancelOrdDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.s.ems.op.order.CiOrderMainServiceImpl;
import iih.ci.ord.s.external.thirdws.utils.RstMsgBP;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 第三方作废医嘱回写
 * @author zhangwq
 *
 */
public class ThirdCancelOrdBP{
	
	
	public  String parseXml(String xml) throws BizException {
		
		//将xml文件解析成DTO 文件
		validation(xml);
		EntWsDTO entWsDTO = (EntWsDTO) parseXml(xml,EntWsDTO.class);
		List<EmsCancelOrdDTO> emsCancelOrdDTO=parseXml(xml, EmsCancelOrdDTO.class, "cancal");
		//校验入参是否为空
		EmsValidateRstDTO rstDTO = validateEmpty(entWsDTO,emsCancelOrdDTO);
		if (rstDTO.getLevel()==EmsValidateRstDTO.ERROR) {
			List<String> msgInfoList = rstDTO.getMsgInfoList();
			return getoutformMsg("1", msgInfoList);
		}
		OrderRstDTO canceRstDTO= saveCancelOrder(entWsDTO, emsCancelOrdDTO);
		if(FBoolean.TRUE.equals(canceRstDTO.getIsSuccess())&&"医嘱作废成功".equals(canceRstDTO.getMessageInfo())){ 
			return outexec();
		}
		return getoutformMsg("1","医嘱作废失败");
	}
	
	public  String getoutformMsg(String code, List<String> msgInfoList) {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n");
		sqlStr.append("<root>                                   \n");
		sqlStr.append(" 		<resultcode>" + code + "</resultcode>          \n");
		for (String msg : msgInfoList) {
			sqlStr.append(" 		<resultmsg>" + msg + "</resultmsg>     \n");
		}	
		sqlStr.append("</root>                                  \n");
		return sqlStr.toString();
	}
	
	private EmsValidateRstDTO validateEmpty(EntWsDTO entWsDTO, List<EmsCancelOrdDTO> emsCancelOrdDTO) {
		EmsValidateRstDTO rstDTO = new EmsValidateRstDTO();
		StringList MsgInfoList =new StringList();
		if (entWsDTO==null) {
			rstDTO.setLevel(EmsValidateRstDTO.ERROR);
			MsgInfoList.add("就诊信息为空！");
			return rstDTO;
			
		}else{
			if(StringUtils.isEmpty(entWsDTO.getCode_org())){
				rstDTO.setLevel(EmsValidateRstDTO.ERROR);	
				MsgInfoList.add("就诊信息中的所属组织不能为空\n");
			}
			if (StringUtils.isEmpty(entWsDTO.getCode_pat())) {
				rstDTO.setLevel(EmsValidateRstDTO.ERROR);	
				MsgInfoList.add("就诊信息中的患者编码不能为空\n");
			}
			if (StringUtils.isEmpty(entWsDTO.getCode_entp())) {
				rstDTO.setLevel(EmsValidateRstDTO.ERROR);	
				MsgInfoList.add("就诊信息中的就诊类型编码不能为空\n");
			}
			if (emsCancelOrdDTO==null) {
				
				rstDTO.setLevel(EmsValidateRstDTO.ERROR);
				MsgInfoList.add("作废信息为空！");
			}else{
				
				for(int i=0;i<emsCancelOrdDTO.size();i++){
					EmsCancelOrdDTO cancelOrdDTO = emsCancelOrdDTO.get(i);
					if(StringUtils.isEmpty(cancelOrdDTO.getCode_or())){
						rstDTO.setLevel(EmsValidateRstDTO.ERROR);	
						MsgInfoList.add("第"+(i+1)+"个作废信息中的医嘱编码不能为空\n");
					}
					if(StringUtils.isEmpty(cancelOrdDTO.getCode_emp_canc())){
						rstDTO.setLevel(EmsValidateRstDTO.ERROR);	
						MsgInfoList.add("第"+(i+1)+"个作废信息中的作废医生不能为空\n");
					}
					if(StringUtils.isEmpty(cancelOrdDTO.getCode_dep_canc())){
						rstDTO.setLevel(EmsValidateRstDTO.ERROR);	
						MsgInfoList.add("第"+(i+1)+"个作废信息中的作废科室不能为空\n");
					}
					if(StringUtils.isEmpty(cancelOrdDTO.getDt_canc())){
						rstDTO.setLevel(EmsValidateRstDTO.ERROR);	
						MsgInfoList.add("第"+(i+1)+"个作废信息中的作废操作时间不能为空\n");
					}
					if(StringUtils.isEmpty(cancelOrdDTO.getEu_actiontp())){
						rstDTO.setLevel(EmsValidateRstDTO.ERROR);	
						MsgInfoList.add("第"+(i+1)+"个作废信息中的操作类型不能为空\n");
					}
					
				}
				
			}
		}
		rstDTO.setMsgInfoList(MsgInfoList);
		return rstDTO;
	}

	private OrderRstDTO saveCancelOrder(EntWsDTO entWsDTO ,List<EmsCancelOrdDTO> emsCancelOrdDTO) throws BizException {
		String id_ors="";
		OrderRstDTO rstDTO = new OrderRstDTO();
		for (EmsCancelOrdDTO emsCancelOrdDTO2 : emsCancelOrdDTO) {
			String Code_or = (String) emsCancelOrdDTO2.getAttrVal("Code_or");
			id_ors=id_ors+Code_or+",";
		}
		id_ors=id_ors.substring(0,id_ors.length()-1);
		ICiorderMDORService srv = ServiceFinder.find(ICiorderMDORService.class);
		CiOrderDO[] orsDOs = srv.findByAttrValStrings(CiOrderDO.CODE_OR, id_ors.split(","));
		FArrayList fList = new FArrayList();
		FMap2 map = new FMap2();
		if (orsDOs!=null) {
			for (CiOrderDO ciOrderDO : orsDOs) {
				fList.add(ciOrderDO.getAttrVal("Id_or"));
				map.put((String) ciOrderDO.getAttrVal("Id_or"), ciOrderDO.getAttrVal("Sd_su_or"));
			}	
			//调用作废医嘱
			CiOrderMainServiceImpl ciOrderMainServiceImpl = new CiOrderMainServiceImpl();
			
			OrderOperateDTO orderOperateDTO = new OrderOperateDTO();
			CiEnContextDTO ctx = new CiEnContextDTO();
			ctx.setAttrVal("Id_grp", entWsDTO.getAttrVal("Code_grp"));
			ctx.setAttrVal("Id_org", entWsDTO.getAttrVal("code_org"));
			ctx.setAttrVal("Id_pat", entWsDTO.getAttrVal("code_pat"));
			ctx.setAttrVal("Id_en", entWsDTO.getAttrVal("code_en"));
			ctx.setAttrVal("Id_entp", entWsDTO.getAttrVal("code_entp"));
			orderOperateDTO.setAttrVal("Extension", map);
			orderOperateDTO.setAttrVal("Document", fList);
			 rstDTO= ciOrderMainServiceImpl.cancel(ctx, orderOperateDTO);	
		}else{
			getoutformMsg("1","作废医嘱不存在！");
		}
		return rstDTO;
		

	}
	
	public static void main(String[] args) throws BizException, ParserConfigurationException, SAXException, IOException, TransformerException {
		File fileinput = new File("D:/EmsCancalOrdConfig.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = (Document) dBuilder.parse(fileinput);
        //方法2：和方法1类似
		DOMSource domSource = new DOMSource(doc);
		StringWriter writer = new StringWriter();
		StreamResult result = new StreamResult(writer);
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		transformer.transform(domSource, result);
		//cancelOrd(writer.toString());
	}
	
	/**
	 * 基础校验
	 * 
	 * @param param
	 * @throws BizException
	 */
	private  void validation(String param) throws BizException {
		if (StringUtil.isEmptyWithTrim(param)) {
			throw new BizException("Xml转换为DTO对象，Xml参数空异常！");
		}
	}

	/**
	 * 解析Xml
	 * @param xmlStr
	 * @param classInfo
	 * @throws BizException
	 */
	private  BaseDTO parseXml(String xmlStr, Class<?> classInfo) 
			throws BizException {
		List<String> listAttr = new ArrayList<String>();
		BaseDTO dto = initRtn(classInfo, listAttr);
		BaseDTO rtn = (BaseDTO) dto.clone();
		SAXReader reader= new SAXReader();
		try {
			//读取XML文件内容
			org.dom4j.Document document =  reader.read(new ByteArrayInputStream(xmlStr.getBytes("UTF-8")) );
			//获取XML根节点
			Element eleRoot = ((org.dom4j.Document) document).getRootElement();
			if (eleRoot != null) {
				//获取XML根节点下面的元素
				List<Element> listEle = eleRoot.elements();
				if (listEle == null || listEle.size() < 1) {
					return null;
				}

				for (Element element : listEle) {
					if (element == null)
						continue;
					if ("ent".equals(element.getName().toLowerCase())) {
						// 遍历Xml节点，赋值给DTO
						/*if (listAttr.contains(element.getName().toLowerCase())) {
							setVal(rtn, element);
						}*/
						List<Element> elements = element.elements();
						for(Element element1 : elements){
							if (element1 == null)
								continue;
							if (listAttr.contains(element1.getName().toLowerCase())) {
								setVal(rtn, element1);
							}
						}
						
					}
					
				}
				
			}
			return rtn;
		} catch (Exception e1) {
			throw new BizException("解析Xml异常！");
		}
	}
	
	/**
	 * 解析Xml
	 * @param xmlStr
	 * @param classInfo
	 * @param nodeName
	 * @return
	 * @throws BizException
	 */
	private  List<EmsCancelOrdDTO> parseXml(String xmlStr, Class<?> classInfo, String nodeName) throws BizException {

		List<String> listAttr = new ArrayList<String>();
		BaseDTO dto = initRtn(classInfo, listAttr);
		List<EmsCancelOrdDTO> reList = new ArrayList<EmsCancelOrdDTO>();
		SAXReader reader= new SAXReader();
		try {
			//读取XML文件内容
			org.dom4j.Document document =  reader.read(new ByteArrayInputStream(xmlStr.getBytes("UTF-8")) );
			//获取XML根节点
			Element eleRoot = ((org.dom4j.Document) document).getRootElement();
			if (eleRoot != null) {
				//获取XML根节点下面的元素
				List<Element> listEle = eleRoot.elements();
				if (listEle == null || listEle.size() < 1) {
					return null;
				}

				for (Element element : listEle) {
					if (element == null)
						continue;
					if ("ent".equals(element.getName().toLowerCase())) {
						List<Element> elements = element.elements();
						for(Element element1 : elements){
							if (element1 == null)
								continue;
							if (nodeName.equals(element1.getName().toLowerCase())) {
								EmsCancelOrdDTO rtn = (EmsCancelOrdDTO) dto.clone();
								List<Element> element2 = element1.elements();		
								for (Element element3 : element2) {
									if (element3 == null)
										continue;
									if (listAttr.contains(element3.getName().toLowerCase())) {
										setVal(rtn, element3);
									}
									
								}
								reList.add(rtn);
							}
						}
						
					}
					
				}
			}
			
		} catch (Exception e1) {
			throw new BizException("解析Xml异常！");
		}
		return reList;
	}
	
	/**
	 * 实例化返回值
	 * 
	 * @param classInfo
	 * @return
	 * @throws BizException
	 */
	private  BaseDTO initRtn(Class<?> classInfo, List<String> listAttr) throws BizException {
		try {
			BaseDTO rtn = (BaseDTO) classInfo.newInstance();
			if (rtn == null) {
				throw new BizException("不支持的返回值类型！");
			}
			String[] attrs = rtn.getAttrNames();
			if (attrs != null && attrs.length > 0) {
				listAttr.addAll(Arrays.asList(attrs));
			}
			return rtn;
		} catch (Exception e) {
			throw new BizException("返回值实例化异常！");
		}
	}

	/**
	 * DTO设置值
	 * 
	 * @param rtn
	 * @param ele
	 */
	private  void setVal(BaseDTO rtn, Element ele) {
		if (ele.getData() != null && !StringUtil.isEmptyWithTrim(ele.getData().toString())) {
			String arrtName = ele.getName();
			rtn.setAttrVal(arrtName.substring(0, 1).toUpperCase() + arrtName.substring(1).toLowerCase(), ele.getData());
		}
	}

	public String outexec() {
	  return	getoutformMsg("0","医嘱作废成功");	
	}
	
	/**
	 * 
	 * 
	 * @param code
	 * @param msg
	 * @return
	 */
	public  String getoutformMsg(String code, String msg) {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n");
		sqlStr.append("<root>                                   \n");
		sqlStr.append(" 		<resultcode>" + code + "</resultcode>          \n");
		sqlStr.append(" 		<resultmsg>" + msg + "</resultmsg>     \n");
		sqlStr.append("</root>                                  \n");
		return sqlStr.toString();
	}
	
	

}
