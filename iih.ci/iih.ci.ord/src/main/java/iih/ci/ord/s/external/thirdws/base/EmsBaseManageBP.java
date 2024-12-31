package iih.ci.ord.s.external.thirdws.base;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;
import iih.ci.ord.s.external.thirdws.utils.LogUtils;
import iih.ci.ord.s.external.thirdws.utils.RstMsgBP;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;

public abstract class EmsBaseManageBP {
	/**
	 * 保存类
	 */
	private IEmsSaveBP emssavebp;
    //就诊节点
	public static String ELEMENT_ENT = "ent";
	//医嘱节点
	public static String ELEMENT_ORDER = "order";
	//服务节点
	public static String ELEMENT_SRV = "srv";
	//处方节点
	public static String ELEMENT_PRES = "pres";

	//诊断节点
	public static String ELEMENT_DIAG = "diag";

	//打印节点
	public static String ELEMENT_PRINT = "print";
	//备血-检验指标节点
	public static String ELEMENT_CHECK = "check";

	//医嘱收费状态
	public static String ElEMENT_CODE_OR= "code_or";
	
	// 附件手术
	public static String ELEMENT_ADDITIONAL_SURGERY= "additional_surgery";
	
	// 手术人员
	public static String ELEMENT_SUG_EMP= "sug_emp";
	//血液成分
	public static String ELEMENT_BLOOD_ITEM="blooditem";
	//血袋信息
	public static String ELEMENT_BB_INFO="bbinfo";

	public EmsBaseManageBP(){};
	public EmsBaseManageBP(IEmsSaveBP emssavebp){
		this.emssavebp = emssavebp;
	}
	/**
	 * 保存逻辑
	 * @param dataSource
	 * @return
	 * @throws BizException
	 */
	public String save(String xmlStr){
		LogUtils.Logger(xmlStr);
		try{
			EntWsDTO entwsdto = this.pareXmlToDTO(xmlStr);
			return this.getEmssavebp().save(entwsdto);
		}catch(Exception e){
			return RstMsgBP.getRstMsg("1", e.getMessage());
		}
	}
	/**
	 * 将入参的xml文件映射成dto
	 * @param xmlStr
	 * @return
	 * @throws BizException
	 * @throws UnsupportedEncodingException
	 * @throws DocumentException
	 */
	public abstract EntWsDTO pareXmlToDTO(String xmlStr) throws BizException, UnsupportedEncodingException, DocumentException;
	/**
	 * 解析Xml
	 * 
	 * @param xmlStr
	 * @param classInfo
	 * @throws BizException
	 */
	protected BaseDTO parseXml(String xmlStr, Class<?> classInfo) throws BizException {
		List<String> listAttr = new ArrayList<String>();
		BaseDTO dto = initRtn(classInfo, listAttr);
		BaseDTO rtn = (BaseDTO) dto.clone();
		SAXReader reader = new SAXReader();
		try {
			// 读取XML文件内容
			Document document = reader.read(new ByteArrayInputStream(xmlStr.getBytes("UTF-8")));
			// 获取XML根节点
			Element eleRoot = document.getRootElement();
			if (eleRoot != null) {
				// 获取XML根节点下面的元素
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
	 * 
	 * @param xmlStr
	 * @param classInfo
	 * @param nodeName
	 * @return
	 * @throws BizException
	 */
	protected BaseDTO[] parseXml(String xmlStr, Class<?> classInfo, String nodeName) throws BizException {

		List<String> listAttr = new ArrayList<String>();
		BaseDTO dto = initRtn(classInfo, listAttr);
		List<BaseDTO> reList = new ArrayList<BaseDTO>();
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(new ByteArrayInputStream(xmlStr.getBytes("UTF-8")));
			Element eleRoot = document.getRootElement();
			if (eleRoot != null) {
				// 获取XML根节点下面的元素
				List<Element> listEle = eleRoot.elements();
				if (listEle == null || listEle.size() < 1) {
					return null;
				}

				for (Element element : listEle) {
					if (element == null || !(nodeName.equals(element.getName().toLowerCase())))
						continue;// 2 节点名称和实体名称不对应时不处理
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
	 * 实例化返回值
	 * 
	 * @param classInfo
	 * @return
	 * @throws BizException
	 */
	protected BaseDTO initRtn(Class<?> classInfo, List<String> listAttr) throws BizException {
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
	protected void setVal(BaseDTO rtn, Element ele) {
		if (ele.getData() != null && !StringUtil.isEmptyWithTrim(ele.getData().toString())) {
			String arrtName = ele.getName();
			rtn.setAttrVal(arrtName.substring(0, 1).toUpperCase() + arrtName.substring(1).toLowerCase(), ele.getData());
		}
	}
	public IEmsSaveBP getEmssavebp() {
		return emssavebp;
	}
	public void setEmssavebp(IEmsSaveBP emssavebp) {
		this.emssavebp = emssavebp;
	}
	
}
