package iih.ei.itf.itftest.s.bp;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;

import iih.bd.utils.BaseDoSerializeFormat;
import iih.bd.utils.XmlSerializeUtils;
import iih.ei.std.d.IIHServiceParamDTO;
import iih.ei.std.d.IIHServiceResultDTO;
import xap.dp.dmengine.d.PropertyDO;
import xap.dp.dmengine.s.MdCachePoolProxy;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;

/**
 * 构建参数模板XML业务逻辑
 * 
 * @author hao_wu 2019-9-26
 *
 */
public class BuildItfParamTempXmlBp {

	/**
	 * 参数类型_入参
	 */
	public static String PARAMTYPE_IN = "paramtype_in";
	/**
	 * 参数类型_出参
	 */
	public static String PARAMTYPE_OUT = "paramtype_out";

	public String exec(Class<?> paramClass, String paramType) throws BizException {

		String rootName = getRootName(paramType);

		BaseDO rootDto = getRootDTO(paramType);

		BaseDoSerializeFormat paramformat = new BaseDoSerializeFormat();
		paramformat.setRootName(rootName);
		paramformat.setOutputBlankEle(true);
		paramformat.setOutputComment(true);
		String xml = null;
		try {
			xml = XmlSerializeUtils.serializeBaseDo(rootDto, paramformat);
		} catch (Exception e) {
			String msg = String.format("构建接口参数模板XML失败,全类名:\"%s\".", rootDto.getClass().getName());
			throw new BizException(msg, e);
		}

		if (paramClass == null || !BaseDO.class.isAssignableFrom(paramClass)
				|| Modifier.isAbstract(paramClass.getModifiers())) {
			return xml;
		}

		Object paramObj = null;
		try {
			paramObj = createEmptyObj(paramClass);
		} catch (Exception e) {
			String msg = String.format("构建空对象失败，全类名:%s.", paramClass.getName());
			throw new BizException(msg, e);
		}

		if (paramObj == null) {
			return xml;
		}

		BaseDoSerializeFormat dataFormat = new BaseDoSerializeFormat();
		dataFormat.setRootName("Data");
		dataFormat.setOutputBlankEle(true);
		dataFormat.setOutputComment(true);
		try {
			String dataXml = XmlSerializeUtils.serializeBaseDo((BaseDO) paramObj, dataFormat);
			xml = buildParamXml(xml, dataXml, rootName);
			return xml;
		} catch (Exception e) {
			String msg = String.format("序列化参数对象异常,全类名:%s.", paramClass.getName());
			throw new BizException(msg, e);
		}
	}

	private BaseDO getRootDTO(String paramType) {
		if (PARAMTYPE_IN.equals(paramType)) {
			return new IIHServiceParamDTO();
		}
		return new IIHServiceResultDTO();
	}

	/**
	 * 获取根节点名称
	 * 
	 * @param paramType
	 * @return
	 * @throws BizException
	 */
	private String getRootName(String paramType) throws BizException {
		if (PARAMTYPE_IN.equals(paramType)) {
			return "iihparam";
		}
		if (PARAMTYPE_OUT.equals(paramType)) {
			return "iihresult";
		}
		String msg = String.format("不支持的参数类型：%s", paramType);
		throw new BizException(msg);
	}

	/**
	 * 构建结果文本，将业务xml节点嵌入框架xml
	 * 
	 * @param resultStr
	 * @param businessResult
	 * @param serializeTp
	 * @return
	 * @throws Exception
	 */
	private String buildParamXml(String paramXml, String dataXml, String rootName) throws Exception {
		Document dataDocument = XmlSerializeUtils.createXmlDocument(dataXml);
		Element dataEle = dataDocument.getRootElement();
		dataEle = (Element) dataEle.clone();

		Document document = XmlSerializeUtils.createXmlDocument(paramXml);

		String nodePath = String.format("/%s", rootName);
		Element iihParamEle = (Element) document.selectSingleNode(nodePath);
		iihParamEle.add(dataEle);

		String paramXmlStr = XmlSerializeUtils.write(document);
		return paramXmlStr;
	}

	@SuppressWarnings("unchecked")
	private Object createEmptyObj(Class<?> paramClass) throws Exception {
		Object obj = paramClass.newInstance();
		BaseDO baseDo = (BaseDO) obj;

		PropertyDO[] propertyDOs = MdCachePoolProxy.getInstance().getPropertyDOsByEntityName(paramClass.getName());
		if (ArrayUtils.isEmpty(propertyDOs)) {
			return baseDo;
		}
		for (PropertyDO propertyDO : propertyDOs) {

			String propName = propertyDO.getName();
			String attrName = String.format("%s%s", propName.substring(0, 1).toUpperCase(),
					propName.substring(1, propName.length()));

			String methodName = String.format("get%s", attrName);
			Method method = getMethod(paramClass, methodName);
			if (method == null) {
				continue;
			}

			Class<?> returnType = method.getReturnType();
			if (FArrayList.class.isAssignableFrom(returnType)) {
				// FArrayList
				Class<?> childDataClass = getChildDataClass(paramClass, attrName);
				if (childDataClass == null || paramClass.equals(childDataClass)) {
					continue;
				}

				Object subObj = createEmptyObj(childDataClass);
				if (subObj != null) {
					FArrayList dataList = new FArrayList();
					dataList.add(subObj);
					baseDo.setAttrVal(attrName, dataList);
				}

			} else if (BaseDO.class.isAssignableFrom(returnType)) {
				if (paramClass.equals(returnType)) {
					continue;
				}
				Class<?> childDataClass = getChildDataClass(paramClass, attrName);
				Object subObj = createEmptyObj(childDataClass);
				baseDo.setAttrVal(attrName, subObj);
			}
		}

		return obj;
	}

	/**
	 * 根据类型和方法名获取方法
	 * 
	 * @param objClass   类型
	 * @param methodName 方法名
	 * @return
	 */
	private static Method getMethod(Class<?> objClass, String methodName) {
		Method[] mehdods = objClass.getMethods();
		if (ArrayUtils.isEmpty(mehdods)) {
			return null;
		}

		for (Method method : mehdods) {
			if (methodName.equals(method.getName())) {
				return method;
			}
		}
		return null;
	}

	private static Class<?> getChildDataClass(Class<?> objClass, String attrName) throws Exception {

		String fullClassName = MdCachePoolProxy.getInstance().getSubFullClassNameByEntityProperty(objClass.getName(),
				attrName.toLowerCase());

		if (StringUtils.isBlank(fullClassName)) {
			return null;
		}

		Class<?> dataTypeClass = Class.forName(fullClassName);
		return dataTypeClass;
	}
}
