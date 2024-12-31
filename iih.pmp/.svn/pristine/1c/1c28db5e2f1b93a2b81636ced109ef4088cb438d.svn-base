package iih.pmp.yilutong.util;

import java.io.StringWriter;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import iih.pmp.pay.udi.PmpPayConst;
import xap.mw.core.data.BizException;

/**
 * 医路通 工具类
 * 
 * @author zhangxin06
 * @date 2019年1月11日
 */
public class YiLuTongWXPayUtil {

	/**
	 * 将Map转换为XML格式的字符串
	 * 
	 * @param data
	 *            Map类型数据
	 * @return XML格式的字符串
	 * @throws Exception
	 */
	public static String mapToXml(Map<String, String> data) throws Exception {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		org.w3c.dom.Document document = documentBuilder.newDocument();
		org.w3c.dom.Element root = document.createElement("request");
		document.appendChild(root);

		for (String key : data.keySet()) {
			String value = (String) data.get(key);
			if (value == null) {
				value = "";
			}
			value = value.trim();
			org.w3c.dom.Element filed = document.createElement(key);
			filed.appendChild(document.createTextNode(value));
			root.appendChild(filed);
		}

		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		DOMSource source = new DOMSource(document);
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		StringWriter writer = new StringWriter();
		StreamResult result = new StreamResult(writer);
		transformer.transform(source, result);
		String output = writer.getBuffer().toString(); // .replaceAll("\n|\r",
														// "");

		try {
			writer.close();
		} catch (Exception ex) {
		}
		return output;
	}

	/**
	 * 生成带有 sign 的 XML 格式字符串
	 * 
	 * @param data
	 *            Map类型数据
	 * @param key
	 *            API密钥
	 * @return 含有sign字段的XML
	 * @throws Exception
	 */
	public static String generateSignedXml(final Map<String, String> data, String key) throws Exception {
		String sign = generateSignature(data, key);
		data.put(ScanPayConst.SIGN, sign);
		return mapToXml(data);
	}

	/**
	 * 判断签名是否正确，必须包含sign字段，否则返回false。使用MD5签名。
	 * 
	 * @param data
	 *            Map类型数据
	 * @param key
	 *            API密钥
	 * @return 签名是否正确
	 * @throws BizException
	 * @throws Exception
	 */
	public static boolean isSignatureValid(Map<String, String> data, String key) throws BizException {
		if (!data.containsKey(ScanPayConst.SIGN)) {
			return false;
		}
		String sign = (String) data.get(ScanPayConst.SIGN);
		try {
			return generateSignature(data, key).equals(sign);
		} catch (Exception e) {
			YiLuTongWXPayUtil.getLogger()
					.warn(String.format("Invalid XML, can not generateSignature. Error message:" + e.getMessage()));
			throw new BizException(e.getMessage());
		}

	}

	/**
	 * 生成签名. 注意，若含有sign_type字段，必须和signType参数保持一致。
	 * 
	 * @param data
	 *            待签名数据
	 * @param key
	 *            API密钥
	 * @param signType
	 *            签名方式
	 * @return 签名
	 * @throws Exception
	 */
	public static String generateSignature(final Map<String, String> data, String key) throws Exception {
		Set<String> keySet = data.keySet();
		String[] keyArray = keySet.toArray(new String[keySet.size()]);
		Arrays.sort(keyArray);
		StringBuilder sb = new StringBuilder();
		for (String k : keyArray) {
			if (k.equals(ScanPayConst.SIGN)) {
				continue;
			}
			if (data.get(k).trim().length() > 0) // 参数值为空，则不参与签名
				sb.append(k).append("=").append((data.get(k)).trim()).append("&");
		}
		sb.append("key=").append(key);
		return MD5(sb.toString()).toUpperCase();
	}

	/**
	 * 获取随机字符串 Nonce Str
	 * 
	 * @return String 随机字符串
	 */
	public static String generateNonceStr() {
		return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
	}

	/**
	 * 生成 MD5
	 * 
	 * @param data
	 *            待处理数据
	 * @return MD5结果
	 * @throws Exception
	 */
	public static String MD5(String data) throws Exception {
		java.security.MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] array = md.digest(data.getBytes("UTF-8"));
		StringBuilder sb = new StringBuilder();
		for (byte item : array) {
			sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
		}
		return sb.toString().toUpperCase();
	}

	/**
	 * 生成 HMACSHA256
	 * 
	 * @param data
	 *            待处理数据
	 * @param key
	 *            密钥
	 * @return 加密结果
	 * @throws Exception
	 */
	public static String HMACSHA256(String data, String key) throws Exception {
		Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
		SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
		sha256_HMAC.init(secret_key);
		byte[] array = sha256_HMAC.doFinal(data.getBytes("UTF-8"));
		StringBuilder sb = new StringBuilder();
		for (byte item : array) {
			sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
		}
		return sb.toString().toUpperCase();
	}

	/**
	 * 日志
	 * 
	 * @return
	 */
	public static Logger getLogger() {
		return Logger.getRootLogger();
	}

	/**
	 * 获取当前时间戳，单位秒
	 * 
	 * @return
	 */
	public static long getCurrentTimestamp() {
		return System.currentTimeMillis() / 1000;
	}

	/**
	 * 获取当前时间戳，单位毫秒
	 * 
	 * @return
	 */
	public static long getCurrentTimestampMs() {
		return System.currentTimeMillis();
	}

	/**
	 * 生成 uuid， 即用来标识一笔单，也用做 nonce_str
	 * 
	 * @return
	 */
	public static String generateUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
	}

	/**
	 * 将Map<String, Object> 转化成 Map<String, String>
	 * 
	 * @param map
	 * @return
	 */
	public static Map<String, String> toMapString(Map<String, Object> map) {
		Map<String, String> rtnMap = new HashMap<String, String>();
		for (String key : map.keySet()) {
			if (map.get(key) != null) {
				String value = map.get(key).toString();
				rtnMap.put(key, value);
			}

		}
		return rtnMap;
	}

	/**
	 * xml To map
	 * 
	 * @throws BizException
	 * @throws Exception
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> xmlToMap2(String responseXmlTemp) throws BizException {
		Document doc = null;
		try {
			doc = DocumentHelper.parseText(responseXmlTemp);
		} catch (DocumentException e) {
			YiLuTongWXPayUtil.getLogger()
					.warn(String.format("Invalid XML, can not convert to map. Error message: %s. XML content: %s",
							e.getMessage(), responseXmlTemp));
			throw new BizException(e.getMessage());
		}
		Element rootElement = doc.getRootElement();
		Map<String, Object> mapXml = new HashMap<>();
		elementToMap(mapXml, rootElement);
		Map<String, Object> map = (Map<String, Object>) mapXml.get(ScanPayConst.RESPONSE);
		Map<String, String> mapdata = new HashMap<>();
		if (map.get(ScanPayConst.RESULT).equals(PmpPayConst.PMP_SUCCESS)) {
			mapdata = (Map<String, String>) map.get(ScanPayConst.DATA);
			mapdata.put(ScanPayConst.RESULT, map.get(ScanPayConst.RESULT).toString());
			mapdata.put(ScanPayConst.MESSAGE, map.get(ScanPayConst.MESSAGE).toString());
			return mapdata;
		} else {
			mapdata.put(ScanPayConst.RESULT, map.get(ScanPayConst.RESULT).toString());
			mapdata.put(ScanPayConst.MESSAGE, map.get(ScanPayConst.MESSAGE).toString());
		}

		return mapdata;
	}

	/**
	 * 使用递归调用将多层级xml转为map
	 *
	 * @param map
	 * @param rootElement
	 */
	private static void elementToMap(Map<String, Object> map, Element rootElement) {
		// 获得当前节点的子节点
		List<Element> childElements = rootElement.elements();
		if (childElements.size() > 0) {
			Map<String, Object> tempMap = new HashMap<>();
			for (Element e : childElements) {
				elementToMap(tempMap, e);
				map.put(rootElement.getName(), tempMap);
			}
		} else {
			map.put(rootElement.getName(), rootElement.getText());
		}

	}
}
