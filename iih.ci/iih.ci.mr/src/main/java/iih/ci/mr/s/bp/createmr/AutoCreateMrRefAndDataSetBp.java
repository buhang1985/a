package iih.ci.mr.s.bp.createmr;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import iih.ci.mr.i.ICiMrOutQryServices;
import iih.ci.mr.mrdocrefvalue.d.MrDocRefValueDO;
import iih.ci.mr.mrserviceext.i.IMrServiceExt;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.mw.sf.core.util.ServiceFinder;

public class AutoCreateMrRefAndDataSetBp {
    // xid 前缀
	private String xidBefore;
	private AutoCreateMrRandomNumBp bp;
	
	/**
	 * 刷宏元素或引用或数据组
	 * @param list  元素
	 * @param arr  宏元素编码数组
	 * @param id_ent  就诊id
	 * @param classify 元素类型
	 * @throws BizException
	 * @throws SQLException
	 */
	public List<Element> refAndDataSet(List<Element> list,String[] arr,String id_ent,Classify classify) throws BizException, SQLException{
		bp=new AutoCreateMrRandomNumBp();
		String xidMid=bp.randomString(18);						  
		xidBefore="xid-"+xidMid+"-";  
		
		String text="";
		// 刷宏元素
		if(classify==Classify.MACRO){
			IMrServiceExt service2 =ServiceFinder.find(IMrServiceExt.class);
			FMap2 map2=service2.getMacroResultMap(id_ent, "03", arr);	
			if(map2==null || map2.values().size()<=0) return null;
			text=(String) map2.values().iterator().next();			
		}// 刷引用数据组
		else if(classify==Classify.QUOTE || (classify==Classify.DATASET)){
			ICiMrOutQryServices service3=ServiceFinder.find(ICiMrOutQryServices.class);
			MrDocRefValueDO[] refValueDos = service3.getCimrPhaseByElemCode(id_ent,arr);
			if(refValueDos==null || refValueDos.length<=0) return null;
			text=refValueDos[0].getContent();
		}
		return  refreshData(list,text);	
	}
	
	public List<Element> refreshData(List<Element> list,String text){
		for(int i=0;i<list.size();i++){
			if("XID".equals(list.get(i).getName())){
				 Element elementParent = DocumentHelper.createElement("XElements");
				 Element elementChild = DocumentHelper.createElement("Element");
				 elementChild.addAttribute("xsi:type", "XString"); 
				 elementChild.addElement("XID").setText(xidBefore+bp.randomString(3));					
			     elementChild.addElement("Text").setText(text);
				 SimpleDateFormat sf=new SimpleDateFormat("yyyyMMddHHmmss");	
			     String strsystime = sf.format(System.currentTimeMillis());//系统当前时间
			     String timeEnd=bp.randomString(6);
			     String time=strsystime+timeEnd;
			     elementChild.addElement("ID").setText(time);
			     elementParent.add(elementChild);
				 list.add(i+1,elementParent);							
			}
		}
		return list;
	}	
}
