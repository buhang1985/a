package iih.pmp.pay.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import xap.mw.core.data.BizException;


public class PmpPayToolUtils {
	
	/**
     * XML格式字符串转换为Map
	 * @param strXML  XML字符串
	 * @return XML数据转换后的Map
	 * @throws Exception
	 */
	public static Map<String,String> xmlToMap(String strXML)throws BizException
	{
		try{
			Map<String,String>data=new HashMap<String,String>();
			DocumentBuilderFactory documentBuilderFactory=DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder=documentBuilderFactory.newDocumentBuilder();
			InputStream stream=new ByteArrayInputStream(strXML.getBytes("UTF-8"));
            org.w3c.dom.Document doc = documentBuilder.parse(stream);
            doc.getDocumentElement().normalize();
            NodeList nodeList=doc.getDocumentElement().getChildNodes();
            
            for(int idx=0;idx<nodeList.getLength();++idx){
            	Node node=nodeList.item(idx);
            	if(node.getNodeType()==Node.ELEMENT_NODE){
            		org.w3c.dom.Element element=(org.w3c.dom.Element)node;
            		data.put(element.getNodeName(), element.getTextContent());
            		NodeList nodeList2=node.getChildNodes();
            		if(nodeList2.getLength()>0) {
            			  for(int i=0;i<nodeList2.getLength();++i){
            				  Node node2=nodeList2.item(i);
            	            	if(node2.getNodeType()==Node.ELEMENT_NODE){
            	            		org.w3c.dom.Element element2=(org.w3c.dom.Element)node2;
            	            		data.put(element2.getNodeName(), element2.getTextContent());
            	            		NodeList nodeList3=node2.getChildNodes();
            	            		if(nodeList3.getLength()>0) {
            	            			  for(int j=0;j<nodeList3.getLength();++j){
            	            				  Node node3=nodeList3.item(j);
            	            	            	if(node3.getNodeType()==Node.ELEMENT_NODE){
            	            	            		org.w3c.dom.Element element3=(org.w3c.dom.Element)node3;
            	            	            		data.put(element3.getNodeName(), element3.getTextContent());
            	            	            		NodeList nodeList4=node3.getChildNodes();
            	            	            		if(nodeList4.getLength()>0) {
            	            	            			  for(int k=0;k<nodeList4.getLength();++k){
            	            	            				  Node node4=nodeList4.item(k);
            	            	            	            	if(node4!=null&&node4.getNodeType()==Node.ELEMENT_NODE){
            	            	            	            		org.w3c.dom.Element element4=(org.w3c.dom.Element)node4;
            	            	            	            		data.put(element4.getNodeName(), element4.getTextContent());
            	            	            	            	}
            	            	            			  }
            	            	            			  }
            	            	            	}
            	            			  }
            	            			  }
            	            	}
            			  }
            		}
            		
            	}
            }
            try{
            	stream.close();
            }catch(Exception ex){
            	
            }
            return data;
		}catch(Exception ex){
			
			throw new BizException(ex);
		}
	}
	
	/**
	 * 将Map转换为XML格式的字符串
	 * @param data Map类型数据
	 * @return XML格式的字符串
	 * @throws Exception
	 */
	public static String mapToXml(Map<String,String>data,String nodename)throws BizException
	{
		
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		     DocumentBuilder documentBuilder= documentBuilderFactory.newDocumentBuilder();
		     org.w3c.dom.Document document = documentBuilder.newDocument();
		     org.w3c.dom.Element root = document.createElement(nodename);
		     document.appendChild(root);
		     
		     for(String key:data.keySet()){
		    	 String value=data.get(key);
		    	 if(value==null){
		    		 value="";
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
		     String output = writer.getBuffer().toString(); //.replaceAll("\n|\r", "");		     
		        try {
		            writer.close();
		        }
		        catch (Exception ex) {
		        	throw new BizException(ex);
		        }
		        return output;
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			throw new BizException(e1);
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			throw new BizException(e);
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			throw new BizException(e);
		}    	    	      
	}
	
	/**
	 * map转json
	 * @param map
	 * @return
	 */
	public static String m2json(Map<String,Object>map) {
		GsonBuilder builder = new GsonBuilder();
		builder.disableHtmlEscaping();
		Gson gson = builder.create();
		String info = gson.toJson(map); 
		return info;
	}
	/**
	 * map转json
	 * @param map
	 * @return
	 */
	public static String m2json2(List<HashMap<String,Object>>map) {
		GsonBuilder builder = new GsonBuilder();
		builder.disableHtmlEscaping();
		Gson gson = builder.create();
		String info = gson.toJson(map); 
		return info;
	}
	/**
	 * json转map
	 * @param json
	 * @return
	 */
	public static Map<String, Object> json2Map(String json){
		Gson gson = new Gson();
		@SuppressWarnings("unchecked")
		Map<String, Object> paraMap = gson.fromJson(json, Map.class);
		return paraMap;
	}
	
	public static List<HashMap<String,Object>> test(String json){
		Gson gson = new Gson();
		Type type = new TypeToken<List<HashMap<String,Object>>>(){}.getType(); 
		@SuppressWarnings("unchecked")
		List<HashMap<String,Object>> paraMap = gson.fromJson(json, type);
		return paraMap;
	}

}
