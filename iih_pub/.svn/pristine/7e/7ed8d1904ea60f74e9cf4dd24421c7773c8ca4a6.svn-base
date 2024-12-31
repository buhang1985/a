package iih.bd.utils;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import xap.dp.dmengine.d.PropertyDO;
import xap.dp.dmengine.pub.MetaDataException;
import xap.dp.dmengine.s.MdCachePoolProxy;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FTypeManager;

/**
 * XML序列化工具类
 * 
 * @author hao_wu 2019-8-29
 *
 */
public class XmlSerializeUtils {

	/**
	 * DO序列化时需要忽略的属性
	 */
	private static String[] doIgnoreAttrs = new String[] { "Sv", "Ds" };

	/**
	 * 序列化
	 * 
	 * @param obj
	 * @return
	 */
	public static String serialize(Object obj) {
		return serialize(obj, null);
	}

	/**
	 * 序列化
	 * 
	 * @param obj      需序列化对象
	 * @param rootName 根节点名称,序列化DO是需要
	 * @return
	 */
	public static String serialize(Object obj, String rootName) {
		try {
			String xml = null;
			if (obj instanceof BaseDO) {
				BaseDoSerializeFormat format = new BaseDoSerializeFormat();
				format.setRootName(rootName);
				xml = serializeBaseDo((BaseDO) obj, format);
			} else if (obj instanceof Serializable) {
				xml = serializeBean((Serializable) obj);
			}
			return xml;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	/**
	 * 反序列化
	 * 
	 * @param xml
	 * @param objClass
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T deSerialize(String xml, Class<T> objClass) {
		try {
			T data = null;
			if (BaseDO.class.isAssignableFrom(objClass)) {
				data = (T) deSerializeBaseDo(xml, (Class<BaseDO>) objClass);
			} else if (Serializable.class.isAssignableFrom(objClass)) {
				data = deSerializeBean(xml, objClass);
			}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 序列化
	 * 
	 * @param obj
	 * @return
	 * @throws PropertyException
	 */
	private static String serializeBean(Serializable obj) throws Exception {
		StringWriter writer = new StringWriter();
		JAXBContext context = JAXBContext.newInstance(obj.getClass());
		Marshaller marshal = context.createMarshaller();

		marshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // 格式化输出
		marshal.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");// 编码格式,默认为utf-8
		marshal.setProperty(Marshaller.JAXB_FRAGMENT, false);// 是否省略xml头信息

		marshal.marshal(obj, writer);
		return new String(writer.getBuffer());
	}

	/***
	 * 序列化
	 * 
	 * @param xml
	 * @param objClass
	 * @return
	 * @throws Exception
	 */
	public static <T> T deSerializeBean(String xml, Class<T> objClass) throws Exception {
		StringReader reader = new StringReader(xml);
		JAXBContext context = JAXBContext.newInstance(objClass);
		Unmarshaller unmarshaller = context.createUnmarshaller();

		@SuppressWarnings("unchecked")
		T obj = (T) unmarshaller.unmarshal(reader);
		return obj;
	}

	/**
	 * 序列化DO
	 * 
	 * @param baseDo
	 * @param rootName
	 * @return
	 * @throws Exception
	 */
	public static String serializeBaseDo(BaseDO baseDo, BaseDoSerializeFormat format) throws Exception {
		if (format == null) {
			format = new BaseDoSerializeFormat();
			format.setRootName("root");
		}

		Document xmlDocument = DocumentFactory.getInstance().createDocument();

		Element rootElement = buildXmlElement(baseDo, format.getRootName(), format.isOutputBlankEle(),
				format.isOutputComment());
		xmlDocument.setRootElement(rootElement);

		String xml = write(xmlDocument, format);
		return xml;
	}

	/**
	 * 使用BaseDO构建XML节点
	 * 
	 * @param baseDo
	 * @param eleName 节点名称
	 * @return
	 */
	private static Element buildXmlElement(BaseDO baseDo, String eleName, boolean printBlankEle, boolean printComment)
			throws Exception {
		Element doElement = DocumentFactory.getInstance().createElement(eleName);

		PropertyDO[] propertyDOs = MdCachePoolProxy.getInstance()
				.getPropertyDOsByEntityName(baseDo.getClass().getName());
		if (ArrayUtils.isEmpty(propertyDOs)) {
			return doElement;
		}

		propertyDOs = sortPropDos(propertyDOs);
		for (PropertyDO propertyDO : propertyDOs) {
			Element propEle = buildPropertyElement(baseDo, propertyDO, printBlankEle, printComment);
			if (propEle != null) {
				if (printComment) {
					doElement.addComment(propertyDO.getDisplayname());
				}
				doElement.add(propEle);
			}
		}

		return doElement;
	}

	/**
	 * 构建属性节点
	 * 
	 * @param baseDo
	 * @param propertyDO
	 * @param printBlankEle
	 * @param printComment
	 * @return
	 * @throws Exception
	 */
	private static Element buildPropertyElement(BaseDO baseDo, PropertyDO propertyDO, boolean printBlankEle,
			boolean printComment) throws Exception {
		String attrName = propertyDO.getName();
		attrName = String.format("%s%s", attrName.toUpperCase().charAt(0), attrName.substring(1, attrName.length()));

		if (FBoolean.TRUE.equals(propertyDO.getIsnotserialize())) {
			// 元数据设置不序列化
			return null;
		}
		if (ArrayUtils.contains(doIgnoreAttrs, attrName)) {
			return null;
		}
		Object attrVal = baseDo.getAttrVal(attrName);
		if (attrVal == null && !printBlankEle) {
			return null;
		}

		if (attrVal instanceof FArrayList) {
			Element ele = buildArrayListEle(attrName, (FArrayList) attrVal, printBlankEle, printComment);
			return ele;
		} else if (attrVal instanceof BaseDO) {
			return buildXmlElement((BaseDO) attrVal, attrName, printBlankEle, printComment);
		} else {

			String attrValStr = attrVal == null ? "" : attrVal.toString();

			Element attrEle = DocumentFactory.getInstance().createElement(attrName);
			attrEle.setText(attrValStr);
			return attrEle;
		}
	}

	/**
	 * 构建FArrayList类型属性节点
	 * 
	 * @param attrName
	 * @param attrVal
	 * @param printBlankEle
	 * @param printComment
	 * @return
	 * @throws Exception
	 */
	private static Element buildArrayListEle(String attrName, FArrayList attrVal, boolean printBlankEle,
			boolean printComment) throws Exception {
		if (attrVal.size() <= 0) {
			return null;
		}

		String listEleName = String.format("%ss", attrName);
		Element listEle = DocumentFactory.getInstance().createElement(listEleName);
		for (Object data : attrVal) {
			Element dataEle = buildXmlElement((BaseDO) data, attrName, printBlankEle, printComment);
			if (dataEle != null) {
				listEle.add(dataEle);
			}
		}

		return listEle;
	}

	/**
	 * 按照属性序号排序
	 * 
	 * @param propertyDOs
	 * @return
	 */
	private static PropertyDO[] sortPropDos(PropertyDO[] propertyDOs) {
		Arrays.sort(propertyDOs, new Comparator<PropertyDO>() {

			@Override
			public int compare(PropertyDO o1, PropertyDO o2) {
				if (o2.getSeqno() != null && o1.getSeqno() != null) {
					return o1.getSeqno() - o2.getSeqno();
				}
				return 0;
			}

		});
		return propertyDOs;
	}

	/**
	 * 反序列化DO
	 * 
	 * @param xml
	 * @param objClass
	 * @return
	 * @throws Exception
	 */
	public static <T extends BaseDO> T deSerializeBaseDo(String xml, Class<T> objClass) throws Exception {
		Document xmlDocument = createXmlDocument(xml);

		Element rootEle = xmlDocument.getRootElement();

		T data = deSerializeBaseDo(rootEle, objClass);
		return data;
	}

	/**
	 * 反序列化DO
	 * 
	 * @param ele
	 * @param objClass
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private static <T> T deSerializeBaseDo(Element ele, Class<T> objClass) throws Exception {
		BaseDO data = (BaseDO) objClass.newInstance();

		List<Element> attrEleList = ele.elements();
		for (Element attrEle : attrEleList) {
			List<Element> childEleList = attrEle.elements();
			if (childEleList != null && childEleList.size() > 0) {

				String methodName = String.format("get%s", attrEle.getName());
				Method method = getMethod(objClass, methodName);
				if (method == null) {
					methodName = String.format("get%s", attrEle.getName().substring(0, attrEle.getName().length() - 1));
					method = getMethod(objClass, methodName);
					if (method == null) {
						continue;
					}
				}

				Class<?> returnType = method.getReturnType();
				if (FArrayList.class.isAssignableFrom(returnType)) {
					// FArrayList
					String attrName = attrEle.getName().substring(0, attrEle.getName().length() - 1);
					Class<?> childDataClass = getChildDataClass(objClass, attrName);
					if (childDataClass == null) {
						continue;
					}
					FArrayList dataList = new FArrayList();
					for (Element childEle : childEleList) {
						Object childData = deSerializeBaseDo(childEle, childDataClass);
						dataList.add(childData);
					}
					data.setAttrVal(attrName, dataList);
				} else if (BaseDO.class.isAssignableFrom(returnType)) {
					Class<?> childDataClass = getChildDataClass(objClass, attrEle.getName());
					Object obj = deSerializeBaseDo(attrEle, childDataClass);
					data.setAttrVal(attrEle.getName(), obj);
				} else {
					String msg = String.format("未处理的类型:%s", returnType.getName());
					throw new BizException(msg);
				}
				continue;
			}

			String attrName = attrEle.getName();
			String attrVal = attrEle.getText();

			if (StringUtils.isBlank(attrVal)) {
				data.setAttrVal(attrName, null);
				continue;
			}

			PropertyDO propDo = getPropertyDo(objClass, attrName);
			Class<?> dataTypeClass = null;
			if (305 == propDo.getDatatypestyle()) {
				// 参照
				dataTypeClass = String.class;
			} else {
				dataTypeClass = getChildDataClass(objClass, attrName);

			}

			if (dataTypeClass == null) {
				continue;
			}

			Object attValObj = FTypeManager.convert2FType2(dataTypeClass, attrVal);
			data.setAttrVal(attrName, attValObj);
		}

		return (T) data;
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
		String propFullClassName = MdCachePoolProxy.getInstance()
				.getSubFullClassNameByEntityProperty(objClass.getName(), attrName.toLowerCase());
		if (StringUtils.isBlank(propFullClassName)) {
			return null;
		}

		Class<?> dataTypeClass = Class.forName(propFullClassName);
		return dataTypeClass;
	}

	private static PropertyDO getPropertyDo(Class<?> objClass, String attrName) throws Exception {
		return MdCachePoolProxy.getInstance().getPropertyDOByEntityProperty(objClass.getName(), attrName.toLowerCase());
	}

	/**
	 * 创建XMLDocument
	 * 
	 * @param xml
	 * @return
	 * @throws Exception
	 */
	public static Document createXmlDocument(String xml) throws Exception {
		SAXReader reader = new SAXReader();
		Document xmlDocument = reader.read(new ByteArrayInputStream(xml.getBytes("UTF-8")));
		return xmlDocument;
	}

	/**
	 * XmlDocument转换成字符串
	 * 
	 * @param xmlDocument
	 * @return
	 * @throws Exception
	 */
	public static String write(Document xmlDocument) throws Exception {
		return write(xmlDocument, null);
	}

	/**
	 * XmlDocument转换成字符串
	 * 
	 * @param xmlDocument
	 * @return
	 * @throws Exception
	 */
	public static String write(Document xmlDocument, BaseDoSerializeFormat format) throws Exception {
		OutputFormat outputformat = OutputFormat.createPrettyPrint();
		outputformat.setNewLineAfterDeclaration(false);
		outputformat.setExpandEmptyElements(true);

		if (format != null) {
			outputformat.setSuppressDeclaration(!format.isOutputDeclaration());
		}

		XMLWriter xmlWriter = null;
		try {
			StringWriter out = new StringWriter();
			xmlWriter = new XMLWriter(out, outputformat);
			xmlWriter.write(xmlDocument);
			xmlWriter.flush();
			String xml = out.toString();
			return xml;
		} finally {
			if (xmlWriter != null) {
				xmlWriter.close();
			}
		}
	}
}
