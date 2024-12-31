package iih.ci.mrqc.autoqc.s.bp;



import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.ci.mrqc.autoitmconfig.d.AutoItmConfigDO;
import iih.ci.mrqc.autoitmconfig.i.IAutoitmconfigRService;
import iih.ci.mrqc.autoqc.ruleclazz.common.CommonInterface;
import iih.ci.mrqc.divide.d.DivideDO;
import iih.ci.mrqc.divide.i.IDivideCudService;
import iih.en.pv.dto.d.EnEmrDTO;
import iih.en.pv.i.IEnOutQryService;
import java.util.ArrayList;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;

public class GetAutoQcDefectsBP {
    
    /**
	 * getAutoQcDefects
	 *
     * @param id_ent id_ent
     * @return ItmDO[]
     * @throws BizException 
     * @throws Exception 
	 */
    public  void exec( String id_ent ,String id_qc_type) throws BizException {
    	DAFacade daf=new DAFacade();
    	if(id_qc_type.equals(ICiMrDictCodeConst.ID_EXEC_AUTOMATIC)){
    		String strSql = " ID_ENT='"+id_ent+"' and ID_QA_TY = '"+id_qc_type+"'";
    		daf.deleteByWhere(DivideDO.class, strSql);
    	}else{
    		String strSqlCon = "select count(id_qa_divide) from CI_QA_DIVIDE where ID_ENT= '"+id_ent+"' and ID_QA_TY = '"+id_qc_type+"'";
    		int itemCount = (int)daf.execQuery(strSqlCon, new ColumnHandler());
    		if(itemCount>0)
    			return;
    	}
    	
    	
    	ArrayList list = new ArrayList();
    	
    	IAutoitmconfigRService iAutoitmconfigRService = ServiceFinder.find(IAutoitmconfigRService.class);
    	AutoItmConfigDO[] autoItmConfigDOArr= iAutoitmconfigRService.find("1=1", "", new FBoolean(false));
    	if(autoItmConfigDOArr==null||autoItmConfigDOArr.length<0)
    		return;
    	
    	
    	IEnOutQryService IEnEmrService = ServiceFinder.find(IEnOutQryService.class);
    	EnEmrDTO enEmrDTO= IEnEmrService.getEntInfo4Mr(id_ent);
    	if(enEmrDTO==null)
    		return;

    	
    	for(int i=0;i<autoItmConfigDOArr.length;i++){
    		String strRuleClazzs=autoItmConfigDOArr[i].getRule_clazzes();
    		if(strRuleClazzs!=null&&strRuleClazzs!=""&&strRuleClazzs.length()>0){
    			ArrayList doArr = Launcher(strRuleClazzs,enEmrDTO,autoItmConfigDOArr[i], id_qc_type);
        		if(doArr!=null&&doArr.size()>0){
        			
        			for(int j=0;j<doArr.size();j++){
        				list.add(doArr.get(j));
        			}
        			
        		}
    		}
    	}
    	IDivideCudService iDivideCudService = ServiceFinder.find(IDivideCudService.class);
    	DivideDO[] divideDOarr=(DivideDO[])list.toArray(new DivideDO[list.size()]);
    	iDivideCudService.save(divideDOarr);
    }
    
    public ArrayList Launcher(String strRuleClazzs,EnEmrDTO enEmrDTO,AutoItmConfigDO autoItmConfigDO,String id_qc_type) {
		try {
			
			Class cls = Class.forName(strRuleClazzs);
			Object o = cls.newInstance();
			CommonInterface autoInterface =(CommonInterface)o;
			autoInterface.setEnEmrDTOAndAutoItm(enEmrDTO, autoItmConfigDO, id_qc_type);
			autoInterface.isOk();
			if(autoInterface.isOk()==null){ 
				return null;
			}else{
				return (ArrayList) autoInterface.isOk();
			}
	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }
    
    
}