package iih.ci.mr.s.bp.createmr;

import java.sql.SQLException;
import java.util.List;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import xap.mw.core.data.BizException;

public class AutoCreateMrOrganizeXmlFileBp {

	private Classify classify=Classify.OTHER;
	private String styleIndex;

	public void organizeMrXmlFile(Element elem,String id_ent) throws BizException, SQLException{
		Element contactElem = elem.element("XElements");
		if(contactElem!=null ){
			List<Element> contactList = contactElem.elements("Element");
			if(contactList!=null && contactList.size()>0){
				recursionXml(contactList,id_ent);
		    }else{	
		    	if(classify==Classify.OTHER)return;
		    		
		    	Element xElementsRemove=elem.element("XElements");
				elem.remove(xElementsRemove);
				
				List<Element> list = elem.elements();	
				if(elem.element("Attributes")==null) return;
				List<Element> attributes = elem.element("Attributes").elements("Attribute");
						
				// 刷诊断
		    	if(classify==Classify.DIAGNOSIS){	    		
		    		AutoCreateMrRefreshDiagnosisBp diagnosisBp=new AutoCreateMrRefreshDiagnosisBp(); 		
		    		diagnosisBp.refreshDiagnosis(elem,attributes,id_ent,styleIndex);				
		    	}// 刷宏元素引用数据组
		    	else if(classify==Classify.MACRO|| classify==Classify.QUOTE || classify==Classify.DATASET){ 
		    		for(int e=0;e<attributes.size();e++) {
		    			Element element = attributes.get(e);
						Element name = element.element("Name");
						String nameText =name.getText();
						if("decode".equals(nameText) || "gpcode".equals(nameText)){
							AutoCreateMrRefAndDataSetBp refAndDataSetBp=new AutoCreateMrRefAndDataSetBp();
					    	String[] codeArr=new String[]{element.element("Value").getText()};
					    	refAndDataSetBp.refAndDataSet(list,codeArr,id_ent,classify);
					    	break;
						}
		    		}
		    	}
		    }
		}
	}
	
	
	public void  recursionXml(List<Element> contactList,String id_ent) throws BizException, SQLException{
		for(int e=0;e<contactList.size();e++){	
			Element element = contactList.get(e);
			if("XInputField".equals(element.attributeValue("type"))){
				List<Element> attributes = element.element("Attributes").elements("Attribute");
				if(attributes==null || attributes.size()<=0) return;
				String attrText =  attributes.get(0).element("Value").getText();			
				switch(attrText)
				{
					//宏元素
					case "1001":
						classify=Classify.MACRO;
						break;
					//数据组
					case "1101":
						for(int count=0;count<attributes.size();count++){
							if("fgqs".equals(attributes.get(count).element("Name").getText())){
								if("false".equals(attributes.get(count).element("Value").getText())){
									classify=Classify.DATASET;
									element.add(createXElement(element));
									break;
								}
							}
						}
						break;
					//引用
					case "9004":
						for(int count=0;count<attributes.size();count++){
							if("fgquote".equals(attributes.get(count).element("Name").getText())){
								if("True".equals(attributes.get(count).element("Value").getText())){
									classify=Classify.QUOTE;
									element.add(createXElement(element));
									break;
								}
							}
						}	
						break;		
				    //诊断
					case "4001":
					case "4002":
					case "4003":
					case "4004":
					case "4006":
					case "4007":
					case "4008":
						classify=Classify.DIAGNOSIS;
						getStyleIndex(contactList,e);	
						break;
				}
			}
			organizeMrXmlFile(contactList.get(e),id_ent);
	   }
	}
	
	// 获取段落StyleIndex
	public  void  getStyleIndex(List<Element> contactList,int e){
		for(int r=e+1;r<contactList.size();r++){
			if("XParagraphFlag".equals(contactList.get(r).attributeValue("type"))){
				styleIndex = contactList.get(r).attributeValue("StyleIndex");
			}
		}
	}
	
	// 创建空XElements元素
	public Element createXElement(Element element){
		Element xElementsRemove=element.element("XElements");
		element.remove(xElementsRemove);
		Element elementChild = DocumentHelper.createElement("XElements");
		return elementChild;
	}
}