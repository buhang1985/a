package iih.ci.sdk.utils;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;

public class CiXmlUtils {

	public static <T extends BaseDTO> T[] ParseXml(String xmlStr, String xPath, Class<T> cls) throws BizException {
		
		try {
			T dto = cls.newInstance();
			SAXReader reader= new SAXReader();
			Document xmlDoc = reader.read(new ByteArrayInputStream(xmlStr.getBytes("UTF-8")) );
			
			if (ObjectUtils.isEmpty(xmlDoc)){
				throw new BizException("Xml数据流加载失败");
			}
			// XPath 方式查询到数组节点 
			List<Node> lsNodes = xmlDoc.getRootElement().selectNodes(xPath);
				
				if(ObjectUtils.isEmpty(lsNodes)) {
					throw new BizException(String.format("没有找到指定的XPath节点（%s）", xPath));
				}
				
				for(Node itemNode : lsNodes) {
					
				}
				
				
				
			
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new BizException("解析Xml异常！");
			
		}
		return null;
	}
	
	
}
