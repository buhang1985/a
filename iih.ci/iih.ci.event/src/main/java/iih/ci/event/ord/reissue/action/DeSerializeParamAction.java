package iih.ci.event.ord.reissue.action;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import iih.ci.event.i.reissue.IDeSerializeParamService;
import iih.ci.event.reissue.d.IEMsgReissueDTO;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
/**
 * 将入参解析为dto
 * @author F
 *
 */
public class DeSerializeParamAction implements IDeSerializeParamService {

	@Override
	public BaseDTO deserialize(String xml) throws BizException {
		
		// 1、基础校验
		validation(xml);

		// 2、解析Xml
		return parseXml(xml, IEMsgReissueDTO.class);
	}

	/**
	 * 基础校验
	 * 
	 * @param param
	 * @throws BizException
	 */
	private void validation(String xml) throws BizException {
		if (StringUtil.isEmptyWithTrim(xml)) {
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
			getNodes(eleRoot, rtn);
			return rtn;
		} catch (Exception e1) {
			throw new BizException("解析Xml异常！");
		}
	}
	
	public void getNodes(final Element node, BaseDTO rtn) {
		
		setVal(rtn, node);
		// 递归遍历当前节点所有的子节点
		final List<Element> listElement = node.elements();// 所有一级子节点的list
		for (final Element e : listElement) {// 遍历所有一级子节点
			getNodes(e, rtn);// 递归
		}
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
		if (ele.getTextTrim() != null && !StringUtil.isEmptyWithTrim(ele.getTextTrim().toString())) {
			String arrtName = ele.getName();
			rtn.setAttrVal(arrtName.substring(0, 1).toUpperCase() + arrtName.substring(1).toLowerCase(), ele.getData());
		}
	}
}
