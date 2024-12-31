package iih.ei.std.s.v1.bp.ci.thirdws.utils;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.utils.StringUtil;

public class ConvertDTOs2XmlUtils {
	/**
	 * 主入口
	 * @param params DTO集合
	 * @param rootName 根节点名称
	 * @param calssNodeName 类节点名称
	 * @return
	 * @throws BizException
	 */
	public String exec(BaseDTO[] params, String rootName, String calssNodeName) 
			throws BizException{
		Document doc = this.getDocumentObj();
		this.generalDocument(doc, params, rootName, calssNodeName);
		
		return this.getXmlStr(doc);
	}
	public String exec(BaseDTO[] params,  Element root, Document doc) 
			throws BizException{

		this.generalDocument(doc, params, root, params[0].getClass().getSimpleName().toLowerCase());
		
		return this.getXmlStr(doc);
	}

	/**
	 * xml节点中嵌套子循环  子循环用的FArrayList和FArrayList2。
	 * 如果是FArrayList单个子项目是HashMap
	 * 如果是FArrayList2单个子项目放的是BaseDTO。
	 * @param params
	 * @param root
	 * @param doc
	 * @return
	 * @throws BizException
	 */
	public String exec2(BaseDTO[] params,  Element root, Document doc) 
			throws BizException{

		this.generalDocument2(doc, params, root);
		
		return this.getXmlStr(doc);
	}
	
	private void generalDocument(Document document, BaseDTO[] params,  Element root, String calssNodeName) 
			throws BizException {
		// 数据校验
		validation_new(document, root, params);
		// 生成Xml节点
		generalXml_new(document, params, root, calssNodeName);
	}
	
	private void generalDocument2(Document document, BaseDTO[] params,  Element root) 
			throws BizException {
		// 数据校验
		if (document == null) {
			throw new BizException("Xml格式转换，Document空异常！");
		}
		if (root == null ) {
			throw new BizException("Xml格式转换，root根节点空异常！");
		}
		// 生成Xml节点
		for (BaseDTO baseDTO : params) {
			generalXml_new2(document, baseDTO, root);
		}		
	}
	/**
	 * 生成Xml结构
	 * @param document
	 * @param params
	 * @param rootName
	 * @param calssNodeName
	 * @throws BizException
	 */
	private void generalDocument(Document document, BaseDTO[] params, String rootName, String calssNodeName) 
			throws BizException {
		// 数据校验
		validation(document, rootName, params);
		// 生成Xml节点
		generalXml(document, params, rootName, calssNodeName);
	}

	/**
	 * 基础校验
	 * @param document
	 * @param rootName
	 * @param params
	 * @throws BizException
	 */
	private void validation(Document document, String rootName, BaseDTO[] params) throws BizException {
		if (document == null) {
			throw new BizException("Xml格式转换，Document空异常！");
		}
		if (rootName == null || rootName.length() < 1) {
			throw new BizException("Xml格式转换，rootName根节点名称空异常！");
		}
//		if (params == null || params.length < 1) {
//			throw new BizException("Xml格式转换，源对象空异常！");
//		}
	}
	
	/**
	 * 基础校验
	 * @param document
	 * @param rootName
	 * @param params
	 * @throws BizException
	 */
	private void validation_new(Document document,  Element root, BaseDTO[] params) throws BizException {
		if (document == null) {
			throw new BizException("Xml格式转换，Document空异常！");
		}
		if (root == null ) {
			throw new BizException("Xml格式转换，root根节点空异常！");
		}
//		if (params == null || params.length < 1) {
//			throw new BizException("Xml格式转换，源对象空异常！");
//		}
	}

	/**
	 * XML生成节点
	 * @param document
	 * @param params
	 * @param rootName
	 * @param calssNodeName
	 * @throws BizException
	 */
	private void generalXml(Document document, BaseDTO[] params, String rootName, String calssNodeName) 
			throws BizException {
		// 创建根节点
		Element root = createRootElement(document, rootName);
		if(params==null||params.length==0){
			return;
		}
		// 生成Xml子节点
		if (calssNodeName != null && calssNodeName.length() > 0) {
			recursiveXml(document, root, params, calssNodeName);
		}
		else{
			recursiveXml( document, root, params);
		}
	}
	
	/**
	 * XML生成节点
	 * @param document
	 * @param params
	 * @param rootName
	 * @param calssNodeName
	 * @throws BizException
	 */
	private void generalXml_new(Document document, BaseDTO[] params, Element root , String calssNodeName) 
			throws BizException {
		// 根集合
		Element topRoot = createElement(document, params[0].getClass().getSimpleName().toLowerCase() + "s", "");
		root.appendChild(topRoot);// 集合根节点
		// 创建根节点
		if(params==null||params.length==0){
			return;
		}
		// 生成Xml子节点
		if (calssNodeName != null && calssNodeName.length() > 0) {
			recursiveXml(document, topRoot, params, calssNodeName);
		}
		else{
			recursiveXml( document, topRoot, params);
		}
	}
	
	/**
	 * XML生成节点  basedto带子循环
	 * @param document
	 * @param params
	 * @param rootName
	 * @param calssNodeName
	 * @throws BizException
	 */
	private void generalXml_new2(Document document, BaseDTO params, Element root ) 
			throws BizException {
		// 根集合
		Element topRoot = createElement(document, params.getClass().getSimpleName().toLowerCase(), "");
		root.appendChild(topRoot);// 集合根节点
		// 创建根节点
		if(params==null){
			return;
		}
			recursiveXml( document, topRoot, params);

			

	}
	private Element createRootElement(Document document,String rootName){
		Element element = document.createElement(rootName);  
        document.appendChild(element);  
        return element;  
	}
	
	/**
	 * 创建一个节点
	 * 
	 * @param document
	 * @param name
	 * @param value
	 * @return
	 */
	private Element createElement(Document document, String name, String value) {
		Element reEle = document.createElement(name.toLowerCase());
		reEle.setTextContent(value);
		return reEle;
	}
	/**
	 * 节点Xml递归生成（根节点下直接生成元素节点）
	 * @param document
	 * @param root
	 * @param params
	 */
	private void recursiveXml(Document document, Node root, BaseDTO[] params) {
		String[] attrs = getAttrs(params[0]);
		if (attrs != null && attrs.length > 0) {
			for (String attr : attrs) {
				// 基础属性
				String val = getAttrVal(params[0], attr);
				Element normalEle = createTextElement(document, attr, val);
				root.appendChild(normalEle);
			}
		}
	}
	/**
	 * 节点Xml递归生成（根节点下直接生成元素节点）  new
	 * @param document
	 * @param root
	 * @param params
	 */
	private void recursiveXml(Document document, Node root, BaseDTO params) {
		String[] attrs = getAttrs(params);
		if (attrs != null && attrs.length > 0) {
			for (String attr : attrs) {
				// 基础属性
				Object obj = params.getAttrVal(attr);
				if(obj!=null) {
					if(obj instanceof FArrayList) {
						//FArrayList中放的是hashmap
						FArrayList fa=(FArrayList)obj;
						Element child = createElement(document, attr, "");
						root.appendChild(child);// 集合根节点
						for (Object o : fa) {
							HashMap<String,String> map=(HashMap<String,String>)o;
							Element child2 = createElement(document, "item", "");
							child.appendChild(child2);
							for (String key : map.keySet()) {
								String val = map.get(key);
								if(val==null)
									val="";
								Element normalEle = createTextElement(document, key, val);
								child2.appendChild(normalEle);
							}
						}
					}else if(obj instanceof FArrayList2){
						//FArrayList2中放的是BaseDTO
						FArrayList2 fa=(FArrayList2)obj;
						Element child = createElement(document, attr, "");
						root.appendChild(child);// 集合根节点
						if(fa!=null&&fa.size()>0)
						recursiveXml(document, child, fa, ((BaseDTO)fa.get(0)).getClass().getSimpleName());
						
					}else {
						String val = getAttrVal(params, attr);
						Element normalEle = createTextElement(document, attr, val);
						root.appendChild(normalEle);
					}
				}else {
					Element normalEle = createTextElement(document, attr, "");
					root.appendChild(normalEle);
				}
				
			}
		}
	}
	
	/**
	 * 节点Xml递归生成（根节点下是DTO节点，DTO节点下是元素节点）
	 * @param document
	 * @param root
	 * @param params
	 * @param calssNodeName
	 */
	private void recursiveXml(Document document, Element root, FArrayList2 params, String calssNodeName) {
		String[] attrs = getAttrs((BaseDTO)params.get(0));
		if (attrs != null && attrs.length > 0) {
			for (Object o : params) {
				BaseDTO param=(BaseDTO)o;
				// 设置DTO本身的节点
				Element selfRoot = setSelfDTONode(document, root, param, calssNodeName);
				root.appendChild(selfRoot);
				for (String attr : attrs) {
					// 子集合处理
					if (isChildrenAttr(param, attr)) {
						FArrayList array = getChildrenList(param, attr);
						if (array != null && array.size() > 0) {
							// 子集合属性节点
							Element childRoot = createElement(document, attr);
							selfRoot.appendChild(childRoot);
							List<BaseDTO> listChild = new ArrayList<BaseDTO>();
							for (Object obj : array) {
								BaseDTO childDTO = (BaseDTO) obj;
								listChild.add(childDTO);
							}
							// 递归子集合
							recursiveXml(document, childRoot, listChild.toArray(new BaseDTO[listChild.size()]), calssNodeName);
						}
						continue;
					}

					// 基础属性
					String val = getAttrVal(param, attr);
					Element normalEle = createTextElement(document, attr, val);
					selfRoot.appendChild(normalEle);
				}
			}
		}
	}
	
	/**
	 * 节点Xml递归生成（根节点下是DTO节点，DTO节点下是元素节点）
	 * @param document
	 * @param root
	 * @param params
	 * @param calssNodeName
	 */
	private void recursiveXml(Document document, Element root, BaseDTO[] params, String calssNodeName) {
		String[] attrs = getAttrs(params[0]);
		if (attrs != null && attrs.length > 0) {
			for (BaseDTO param : params) {
				// 设置DTO本身的节点
				Element selfRoot = setSelfDTONode(document, root, param, calssNodeName);
				root.appendChild(selfRoot);
				for (String attr : attrs) {
					// 子集合处理
					if (isChildrenAttr(param, attr)) {
						FArrayList array = getChildrenList(param, attr);
						if (array != null && array.size() > 0) {
							// 子集合属性节点
							Element childRoot = createElement(document, attr);
							selfRoot.appendChild(childRoot);
							List<BaseDTO> listChild = new ArrayList<BaseDTO>();
							for (Object obj : array) {
								BaseDTO childDTO = (BaseDTO) obj;
								listChild.add(childDTO);
							}
							// 递归子集合
							recursiveXml(document, childRoot, listChild.toArray(new BaseDTO[listChild.size()]), calssNodeName);
						}
						continue;
					}

					// 基础属性
					String val = getAttrVal(param, attr);
					Element normalEle = createTextElement(document, attr, val);
					selfRoot.appendChild(normalEle);
				}
			}
		}
	}

	/**
	 * 获取属性名称集合
	 * @param param
	 * @return
	 */
	private String[] getAttrs(BaseDTO param) {
		List<String> reList = new ArrayList<String>();
		String[] attrs = param.getAttrNames();
		if (attrs != null && attrs.length > 0) {
			for (String attr : attrs) {
				String attr_name = attr.substring(0, 1).toUpperCase() + attr.substring(1).toLowerCase();// 首字母大写
				reList.add(attr_name);
			}
		}
		return reList.toArray(new String[reList.size()]);
	}

	/**
	 * 判断是否子集合
	 * @param param
	 * @param attr
	 * @return
	 */
	private boolean isChildrenAttr(BaseDTO param, String attr) {
		Object obj = param.getAttrVal(attr);
		return (obj instanceof FArrayList);
	}

	/**
	 * 获取子集合对象
	 * @param param
	 * @param attr
	 * @return
	 */
	private FArrayList getChildrenList(BaseDTO param, String attr) {

		Object obj = param.getAttrVal(attr);
		if (obj instanceof FArrayList) {
			return (FArrayList) obj;
		}

		return null;
	}

	/**
	 * 设置DTO本身的节点
	 * @param document
	 * @param parant
	 * @param param
	 * @param nodeName
	 */
	private Element setSelfDTONode(Document document, Element parant, BaseDTO param, String nodeName) {
		//本身节点名称 
		String selfNodeName = StringUtil.isEmptyWithTrim(nodeName) ? 
				param.getClass().getSimpleName().toLowerCase() : nodeName;
		Element ele = createElement(document, selfNodeName);
		return ele;
	}

	/**
	 * 获取DTO中指定属性的值
	 * 
	 * @param param
	 * @param attr
	 * @return
	 */
	private String getAttrVal(BaseDTO param, String attr) {
		Object obj = param.getAttrVal(attr);
		if (obj == null) {
			return "";
		}
		return obj.toString();
	}

	/**
	 * 创建一个节点
	 * 
	 * @param document
	 * @param name
	 * @param value
	 * @return
	 */
	private Element createElement(Document document, String name) {
		Element reEle = document.createElement(name.toLowerCase());
		return reEle;
	}
	/**
	 * 创建一个节点
	 * 
	 * @param document
	 * @param name
	 * @param value
	 * @return
	 */
	private Element createTextElement(Document document, String name, String value) {
		Element reEle = document.createElement(name.toLowerCase());
		reEle.appendChild(document.createTextNode(value));
		return reEle;
	}
	/**
	 * 实例化Document对象
	 * @return
	 * @throws BizException
	 */
	private Document getDocumentObj() throws BizException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();
			document.setXmlVersion("1.0");
			return document;
		} catch (Exception e) {
			throw new BizException("实例化XML异常！");
		}
	}
	
	/**
	 * 转换Document为xml串
	 * @param document
	 * @return
	 * @throws BizException
	 */
	private String getXmlStr(Document document) throws BizException {
		try {
			TransformerFactory transFactory = TransformerFactory.newInstance();
			Transformer transformer = transFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource domSource = new DOMSource(document);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			transformer.transform(domSource, new StreamResult(bos));
			return bos.toString();
		} catch (TransformerException e) {
			throw new BizException("Xml生成失败！");
		}
	}
}
