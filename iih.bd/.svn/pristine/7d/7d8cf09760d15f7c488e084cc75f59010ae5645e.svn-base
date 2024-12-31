package iih.bd.base.util;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;

/**
 * XML文件转为BaseDTO对象集合
 * @author Young
 *
 */
public class ConvertXml2DTOsUtils {
	/**
	 * 主入口
	 * @param param
	 * @param classInfo
	 * @return
	 * @throws BizException
	 */
	public <T extends BaseDTO> BaseDTO exec(String param, Class<T> classInfo) 
			throws BizException {
		// 1、基础校验
		validation(param);

		// 2、解析Xml
		return parseXml(param, classInfo);
	}
	
	/**
	 * 主入口
	 * @param param
	 * @param classInfo
	 * @param nodeName
	 * @return
	 * @throws BizException
	 */
	public <T extends BaseDTO> BaseDTO[] exec(String param, Class<T> classInfo, String nodeName) 
			throws BizException {

		// 1、基础校验
		validation(param);

		// 2、解析Xml
		BaseDTO[] rtns = parseXml(param, classInfo, nodeName);

		return rtns;
	}
	
	/**
	 * 扩展入口
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public BaseDTO[] exec(String param, Class<? extends BaseDTO> classInfo, Class<? extends BaseDTO> classInfoSub, Map<String, String> nodeMap) throws BizException {

		// 1、基础校验
		validation(param);

		// 2、解析Xml
		BaseDTO[] rtns = parseXml(param, classInfo, classInfoSub, nodeMap);

		return rtns;
	}

	/**
	 * 基础校验
	 * 
	 * @param param
	 * @throws BizException
	 */
	private void validation(String param) throws BizException {
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
	private BaseDTO parseXml(String xmlStr, Class<?> classInfo) 
			throws BizException {
		List<String> listAttr = new ArrayList<String>();
		BaseDTO dto = initRtn(classInfo, listAttr);
		BaseDTO rtn = (BaseDTO) dto.clone();
		SAXReader reader= new SAXReader();
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
					if (listAttr.contains(element.getName().toLowerCase())) {
						setVal(rtn, element);
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
	private BaseDTO[] parseXml(String xmlStr, Class<?> classInfo, String nodeName) throws BizException {

		List<String> listAttr = new ArrayList<String>();
		BaseDTO dto = initRtn(classInfo, listAttr);
		List<BaseDTO> reList = new ArrayList<BaseDTO>();
		SAXReader reader= new SAXReader();
		try {
			Document document = reader.read(new ByteArrayInputStream(xmlStr.getBytes("UTF-8")) );
			Element eleRoot = document.getRootElement();
			if (eleRoot != null) {
				//获取XML根节点下面的元素
				List<Element> listEle = eleRoot.elements();
				if (listEle == null || listEle.size() < 1) {
					return null;
				}

				for (Element element : listEle) {
					if (element == null || !(nodeName.equals(element.getName().toLowerCase())))
						continue;//2 节点名称和实体名称不对应时不处理
					// 遍历Xml节点，赋值给DTO
					BaseDTO rtn = (BaseDTO) dto.clone();
					List<Element> listEleAttr = element.elements();
					for (Element attrEle : listEleAttr) {
						if (listAttr.contains(attrEle.getName().toLowerCase())) {
							setVal(rtn, attrEle);
						}
					}	
					reList.add(rtn);
				}
			}
		} catch (Exception e1) {
			throw new BizException("解析Xml异常！");
		}
		return reList.toArray(new BaseDTO[reList.size()]);
	}
	
	/**
	 * 解析Xml
	 * @param xmlStr
	 * @param classInfo
	 * @param classInfoSub
	 * @param nodeMap
	 * @return
	 * @throws BizException
	 */
	private BaseDTO[] parseXml(String xmlStr, Class<?> classInfo, Class<?> classInfoSub, Map<String, String> nodeMap) throws BizException {

		List<String> listAttr = new ArrayList<String>();
		List<String> listAttrRef = new ArrayList<String>();
		BaseDTO dto = initRtn(classInfo, listAttr);
		BaseDTO dtoSub = initRtn(classInfoSub, listAttrRef);
		List<BaseDTO> reList = new ArrayList<BaseDTO>();
		FArrayList  reListRef = new FArrayList();
		SAXReader reader= new SAXReader();
		try {
			//读取XML文件内容
			Document document = reader.read(new ByteArrayInputStream(xmlStr.getBytes("UTF-8")));
			//获取XML根节点
			Element eleRoot = document.getRootElement();
			if (eleRoot != null) {
				//获取XML根节点下面的元素
				List<Element> listEle = eleRoot.elements();
				if (listEle == null || listEle.size() < 1) {
					return null;
				}

				for (Element element : listEle) {	
					if (element == null || !(nodeMap.get("nodeName").equals(element.getName().toLowerCase())))
						continue;//节点名称和实体名称不对应时不处理
					//遍历Xml节点，赋值给DTO
					BaseDTO rtn = (BaseDTO) dto.clone();
					
					List<Element> listEleAttr = element.elements();
					for (Element attrEle : listEleAttr) {
						if (listAttr.contains(attrEle.getName().toLowerCase())) {
							setVal(rtn, attrEle);
						}
						if (nodeMap.get("subNodeName").equals(attrEle.getName().toLowerCase())) {
							BaseDTO rtnSub = (BaseDTO) dtoSub.clone();
							List<Element> listEleAttrSub = attrEle.elements();
							for (Element attrEleSub : listEleAttrSub) {
								if (listAttrRef.contains(attrEleSub.getName().toLowerCase())) {
									setVal(rtnSub, attrEleSub);
								}
							}
							reListRef.append(rtnSub); 	
						}					
					}
					rtn.setAttrVal(nodeMap.get("arrayListName"), reListRef);
					reList.add(rtn);
				}
			}
		} catch (Exception e1) {
			throw new BizException("解析Xml异常！");
		}
		return reList.toArray(new BaseDTO[reList.size()]); //返回子节点数据
	}
	
	

	/**
	 * 实例化返回值
	 * 
	 * @param classInfo
	 * @return
	 * @throws BizException
	 */
	private BaseDTO initRtn(Class<?> classInfo, List<String> listAttr) throws BizException {
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
	private void setVal(BaseDTO rtn, Element ele) {
		if (ele.getData() != null && !StringUtil.isEmptyWithTrim(ele.getData().toString())) {
			String arrtName = ele.getName();
			rtn.setAttrVal(arrtName.substring(0, 1).toUpperCase() + arrtName.substring(1).toLowerCase(), ele.getData());
		}
	}
}
