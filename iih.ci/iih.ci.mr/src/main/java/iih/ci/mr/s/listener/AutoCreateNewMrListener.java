package iih.ci.mr.s.listener;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import org.apache.commons.lang3.ArrayUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.srv.mrtaskrule.d.MrTaskRuleDO;
import iih.bd.srv.mrtaskrule.i.IMrtaskruleMDORService;
import iih.bd.srv.mrtplstream.d.EmrTplStreamDO;
import iih.bd.srv.mrtplstream.i.IMrtplstreamRService;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimrfs.d.CiMrFsDO;
import iih.ci.mr.i.IMrTransactionService;
import iih.ci.mr.s.bp.createmr.AutoCreateCiMrDoBp;
import iih.ci.mr.s.bp.createmr.AutoCreateMrGetIdEntsBp;
import iih.ci.mr.s.bp.createmr.AutoCreateMrOrganizeXmlFileBp;
import xap.lui.core.xml.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;

public class AutoCreateNewMrListener implements IBusinessListener{

   // 自动创建病历
	@Override
	public void doAction(IBusinessEvent event) throws BizException{

		boolean flag=event instanceof BusinessEvent;
		boolean flag2=event instanceof BDCommonEvent;
		
		List<String> idEnts=null;
		String sourceId=null; // 事件源id
		AutoCreateMrGetIdEntsBp entsBp=new AutoCreateMrGetIdEntsBp();
		if(flag){
			BusinessEvent busEvent=(BusinessEvent)event;
			sourceId=busEvent.getSourceID();
			BusinessUserObj userObject =(BusinessUserObj) event.getUserObject();
			Object userObj = userObject.getUserObj();		
			idEnts=entsBp.getIdEnts(new Object[] {userObj});		
		}
		
		if(flag2){
		   BDCommonEvent dbevent=(BDCommonEvent)event;	
		   sourceId=dbevent.getSourceID();
		   Object[] newObjs=dbevent.getNewObjs();
		   if(ArrayUtils.isEmpty(newObjs))return;  
		   idEnts=entsBp.getIdEnts(newObjs);	  
		}
		if (idEnts==null || idEnts.size()<=0 ||StringUtils.isEmptyWithTrim(sourceId)) return;
			
		IMrtaskruleMDORService service=ServiceFinder.find(IMrtaskruleMDORService.class);
		MrTaskRuleDO[] ruleDos=service.find("srccode_evt='"+sourceId+"' and fg_active='Y'", "sv desc", FBoolean.FALSE);
		if(ruleDos!=null && ruleDos.length<=0) return;	
	
		for(MrTaskRuleDO ruleDo:ruleDos){
			// 医疗记录模板
			String tmpls=ruleDo.getId_tmpl();
			if(StringUtils.isEmptyWithTrim(tmpls)) continue;
			String[] tmplArr=tmpls.split(",");
			// 医疗记录模板名称
			String tmplNames=ruleDo.getName_tmpl();
		   	String[] tmplNameArr=tmplNames.split(",");
		   	
			for(String id_ent:idEnts){
			    for(int i=0;i<tmplArr.length;i++){
		    	    IMrtplstreamRService servicetmpl=ServiceFinder.find(IMrtplstreamRService.class);
				    EmrTplStreamDO[] streamDos = servicetmpl.find("id_mrtpl='"+tmplArr[i]+"'","",FBoolean.FALSE);
				    if(streamDos==null || streamDos.length<=0) return;
				    byte[] bytes = streamDos[0].getFs();
				 
				    Document document=null;
					if (bytes != null && bytes.length > 0) {
						SAXReader reader = new SAXReader();						
						try {
							reader.setEncoding(ICiMrDictCodeConst.EDITOR_DEFAULT);
							document = reader.read(new ByteArrayInputStream(bytes));
						} catch (DocumentException e) {
							reader.setEncoding(ICiMrDictCodeConst.EDITOR_GB2312);	
							try {
								document = reader.read(new ByteArrayInputStream(bytes));
							} catch (DocumentException e1) {
								e1.printStackTrace();
							}
						}
						
						if(document ==null) return;
	  
						byte[] byteArr=null;
						try {
							AutoCreateMrOrganizeXmlFileBp xmlFileBp=new AutoCreateMrOrganizeXmlFileBp();
							// 重构xml
							xmlFileBp.organizeMrXmlFile(document.getRootElement(),id_ent);					
						    StringWriter sw = new StringWriter();
						    OutputFormat format = OutputFormat.createPrettyPrint();
						    //设置编码
						    format.setEncoding(ICiMrDictCodeConst.EDITOR_DEFAULT);
						    format.setTrimText(false);
				            XMLWriter xmlWriter = new XMLWriter(sw, format);
				        	xmlWriter.write(document);					
							xmlWriter.close();
						    byteArr=sw.toString().getBytes();
						}catch (Exception e) {
							e.printStackTrace();
						}	
						
						AutoCreateCiMrDoBp createMrBp=new AutoCreateCiMrDoBp();
						// 新建病历记录
						CiMrDO cimrdo=createMrBp.createMr(id_ent,ruleDo,tmplArr[i],tmplNameArr[i]);
						// 新建医疗记录流数据
						CiMrFsDO cimrfsdo=new CiMrFsDO();
			            cimrfsdo.setEmrfs(byteArr);
			            cimrfsdo.setStatus(DOStatus.NEW);
	
			            IMrTransactionService actionService=ServiceFinder.find(IMrTransactionService.class);
			            try {
							actionService.saveMr(cimrdo,cimrfsdo);				
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
		    }
		}		  
	}
}
