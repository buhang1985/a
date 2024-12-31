package iih.ci.mr.s.bp.createmr;

import java.util.ArrayList;
import java.util.List;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;

public class AutoCreateMrGetIdEntsBp {

	public List<String> getIdEnts(Object[] newObjs) throws BizException {
		List<String> list =new ArrayList<String>();
		if (newObjs != null && newObjs.length > 0) {
			for(Object obj:newObjs){
				String id_ent="";
				
                if(obj instanceof Object[]){
                	Object[] objArr=(Object[])obj;
                	for(Object o:objArr){
                		if(o instanceof BaseDO){
                			BaseDO baseDo=(BaseDO) o;
                			id_ent=(String) baseDo.getAttrVal("Id_ent");	
                			if(StringUtil.isEmptyWithTrim(id_ent)){
        						id_ent=(String) baseDo.getAttrVal("Id_en");
        					}
                		}
                	}
                }else if(obj instanceof BaseDO){
					BaseDO baseDo = (BaseDO) obj;
					id_ent=(String) baseDo.getAttrVal("Id_ent");
					if(StringUtil.isEmptyWithTrim(id_ent)){
						id_ent=(String) baseDo.getAttrVal("Id_en");
					}				
				}
				
                IPativisitRService patService= ServiceFinder.find(IPativisitRService.class);
        		PatiVisitDO patiVisitDO = patService.findById(id_ent);	
        		boolean flag=patiVisitDO!=null&&!IEnDictCodeConst.SD_ENTP_IPPRE.equals(patiVisitDO.getCode_entp());
        		
				if(flag && id_ent.length()==20){
					list.add(id_ent);
				}				
			}
		}
		return list;
	}
}
