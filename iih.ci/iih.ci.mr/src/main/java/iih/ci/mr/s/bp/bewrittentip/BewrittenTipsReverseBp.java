package iih.ci.mr.s.bp.bewrittentip;

import java.util.ArrayList;
import java.util.List;
import iih.bd.bc.event.pub.IEnEventConst;
import xap.mw.core.data.BaseDO;
import xap.mw.core.utils.StringUtil;

public class BewrittenTipsReverseBp {

	public List<String> getPks(Object[] newObjs,String souceId){
		List<String> list =new ArrayList<String>();
		if (newObjs!= null && newObjs.length > 0) {
			for(Object obj:newObjs){
				String pk="";
				
				boolean isarr=obj instanceof Object[];
				boolean flag=obj instanceof BaseDO;	
                if(isarr){
                	Object[] objArr=(Object[])obj;
                	for(Object o:objArr){
                		if(o instanceof BaseDO){
                			pk=getPK((BaseDO) o,souceId);
                		}
                	}
                }else if(flag){
					pk=getPK((BaseDO) obj,souceId);
				}
				
				if(!StringUtil.isEmptyWithTrim(pk)){
					list.add(pk);
				}
			}
		}
		return list;
	}
	
	
	public String getPK(BaseDO baseDo,String souceId){
		String pk="";
		String pkFieldName = baseDo.getPKFieldName();
		if(pkFieldName==null && IEnEventConst.EVENT_SOURCE_EN_IP_TRANS_DEPT.equals(souceId)){ 
			pk = (String) baseDo.getAttrVal("Id_or");
		}else if(pkFieldName==null && (IEnEventConst.EVENT_SOURCE_EN_IP_IN_DEPT.equals(souceId)
				||IEnEventConst.EVENT_SOURCE_EN_IP_LEAVE.equals(souceId))
				||IEnEventConst.EVENT_SOURCE_EN_IP_CANCEL_IN_DEPT.equals(souceId)){
			pk = (String) baseDo.getAttrVal("Id_ent");
		}else if(pkFieldName!=null){
			pk=baseDo.getPkVal();
		}	
		return pk;
	}
}
