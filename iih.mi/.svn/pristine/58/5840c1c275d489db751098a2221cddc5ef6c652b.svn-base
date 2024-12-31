package iih.mi.device.util;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import xap.lui.core.xml.StringUtils;

public class XmlUtilHelper {
	/**
	 * 查找第一个符合定义的节点
	 * @param node
	 * @param strPath
	 * @return
	 */
    public static Element recurisionFindByName(Element node, String strPath){
        if (StringUtils.isEmpty(strPath))
        {
            return null;
        }
        Element nodeResult = null;
        for(Element item: node.elements()){
            if (item.elements().size() > 1){
                nodeResult = recurisionFindByName(item, strPath);
                break;
            }
            else{
                //查找到对应节点
                if (item.getName() == strPath){
                    nodeResult = item;
                    break;
                }
            }
        }
        return nodeResult;
    }
    /**
     * 读取Document
     * @return
     */
    public static Document readDocument(String strDoc){
		SAXReader reader = new SAXReader();
		Document doc = null;
		try {
			if (strDoc.toLowerCase().indexOf("utf-16")>0){
				strDoc =strDoc.replaceFirst("encoding[a-zA-Z0-9\"-=]{1,}","encoding=\"UTF-8\"");
				doc = reader.read(new ByteArrayInputStream(strDoc.getBytes()));
			}else{
				try {				
					doc = reader.read(new ByteArrayInputStream(strDoc.getBytes("UTF-8")));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return doc;
    }
    /**
     * docment中添加节点
     * @param doc
     * @param strEle
     * @param eleTxt
     * @param attributeKey
     * @param attributeValue
     */
    public static void setElement(Document doc,String strEle,String eleTxt,String attributeKey,String AttributeValue){
        Element element = doc.addElement(strEle);
        if(!StringUtils.isEmpty(eleTxt)){
        	element.addText(eleTxt);
        }
        if(!StringUtils.isEmpty(attributeKey)&& !StringUtils.isEmpty(AttributeValue)){
        	element.addAttribute(attributeKey, AttributeValue);
        }
    }
    /**
     * docment中添加节点
     * @param doc
     * @param strEle
     * @param eleTxt
     */
    public static void setElement(Document doc,String strEle,String eleTxt){
        Element element = doc.addElement(strEle);
        if(!StringUtils.isEmpty(eleTxt)){
        	element.addText(eleTxt);
        }
    }    
}
