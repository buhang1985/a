package iih.bd.utils;

import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * WebServiceXml工具类
 * 
 * @author hao_wu
 *
 */
public class WsXmlUtils {

	/**
	 * 数据序列化为XML
	 * 
	 * @param obj 需要序列化的数据
	 * @return 序列化后的xml文本
	 */
	public static String serialize(Serializable obj) {
		return serialize(obj, false);
	}

	/**
	 * 数据序列化为XML
	 * 
	 * @param obj      需要序列化的数据
	 * @param fragment 去掉生成xml的默认报文头
	 * @return 序列化后的xml文本
	 */
	public static String serialize(Serializable obj, boolean fragment) {
		try {
			StringWriter writer = new StringWriter();
			JAXBContext context = JAXBContext.newInstance(obj.getClass());
			Marshaller marshal = context.createMarshaller();

			marshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // 格式化输出
			marshal.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");// 编码格式,默认为utf-8
			marshal.setProperty(Marshaller.JAXB_FRAGMENT, false);// 是否省略xml头信息
			marshal.setProperty(Marshaller.JAXB_FRAGMENT, fragment);// 去掉生成xml的默认报文头

			marshal.marshal(obj, writer);
			return new String(writer.getBuffer());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * XML反序列化为BaseDO
	 * 
	 * @param xml xml文本
	 * @return 反序列化后的数据
	 */
	@SuppressWarnings("unchecked")
	public static <T> T deSerializeBaseDO(String xml, Class<T> dataClass) {
		try {
			StringReader reader = new StringReader(xml);
			JAXBContext context = JAXBContext.newInstance(dataClass);
			Unmarshaller unmarshaller = context.createUnmarshaller();

			Object obj = unmarshaller.unmarshal(reader);
			return (T) obj;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * XML反序列化为BaseDO</br>
	 * 反序列化提供对属性中有数组的类的支持</br>
	 * 2019-6-21 体检组增加
	 * 
	 * @param xml        xml文本
	 * @param dataClass
	 * @param dataClazzs
	 * @return 反序列化后的数据
	 */
	@SuppressWarnings("unchecked")
	public static <T> T deSerializeBaseDO(String xml, Class<T> dataClass, Class<?>... dataClazzs) {
		try {
			StringReader reader = new StringReader(xml);
			int dataLength = dataClazzs.length;
			Class<?>[] clazzs = new Class[dataLength + 1];
			for (int i = 0; i < dataLength; i++) {
				clazzs[i] = dataClazzs[i];
			}
			clazzs[dataLength] = dataClass;
			JAXBContext context = JAXBContext.newInstance(clazzs);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			Object obj = unmarshaller.unmarshal(reader);
			return (T) obj;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
