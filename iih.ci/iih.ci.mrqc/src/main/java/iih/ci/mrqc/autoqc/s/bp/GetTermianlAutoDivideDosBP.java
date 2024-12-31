package iih.ci.mrqc.autoqc.s.bp;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.srv.autoitm.d.AutoItmDO;
import iih.bd.srv.autoitm.i.IAutoitmRService;
import iih.bd.srv.qcevent.d.QcEventDO;
import iih.bd.srv.qcevent.i.IQceventRService;
import iih.ci.mrqc.autoqc.rulemethod.TerminalAutoQc.TerminalAutoQcForOneUtil;
import iih.ci.mrqc.autoqc.rulemethod.TerminalAutoQc.TerminalAutoQcForTwoUtil;
import iih.ci.mrqc.divide.d.DivideDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

public class GetTermianlAutoDivideDosBP {

	public  DivideDO[] exec( String id_ent,String id_qc_type) throws BizException{
    	DAFacade daf=new DAFacade();
    	if(id_qc_type.equals(ICiMrDictCodeConst.SD_EXEC_AUTOMATIC)){
    		String strSql = " ID_ENT='"+id_ent+"' and SD_QA_TY = '"+id_qc_type+"' and ds='0'";
    		daf.deleteByWhere(DivideDO.class, strSql);
    		
    		IQceventRService qceventService=ServiceFinder.find(IQceventRService.class);
    		IAutoitmRService autoService =ServiceFinder.find(IAutoitmRService.class);
        	AutoItmDO[] autoItmDOArr= autoService.find("1=1 and a0.ds='0'", "", new FBoolean(false));
        	if(autoItmDOArr==null||autoItmDOArr.length<0)
        		return null;
        	
        	for (int i = 0; i < autoItmDOArr.length; i++) {
        		QcEventDO eventdo= qceventService.findById(autoItmDOArr[i].getEvent_type_code());
        		//文书有无 
    			if(eventdo.getMethod().equals(ICiMrDictCodeConst.ID_MR_AUTOQC_ISHAVEMR)){
    				TerminalAutoQcForOneUtil mOne=new TerminalAutoQcForOneUtil();
    				return mOne.exec(id_ent,eventdo, autoItmDOArr[i]);
    			}
    			//内容有无
    			if(eventdo.getMethod().equals(ICiMrDictCodeConst.ID_MR_AUTOQC_ISHAVEMRELEMENT)){
    				//AutoQcMethodForMTwo mTwo=new AutoQcMethodForMTwo();
    				TerminalAutoQcForTwoUtil mTwo=new  TerminalAutoQcForTwoUtil();
    				return mTwo.exec(id_ent,eventdo, autoItmDOArr[i]);
    			}
    		}
    	}
		return null;
	
	}
}
