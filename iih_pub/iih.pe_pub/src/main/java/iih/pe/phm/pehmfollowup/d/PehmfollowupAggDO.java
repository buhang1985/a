package iih.pe.phm.pehmfollowup.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.phm.pehmfollowup.d.desc.PehmfollowupAggDODesc;



/**
 * 健康管理随访记录
 */
public class PehmfollowupAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeHmFollowupDO getParentDO() {
		return ((PeHmFollowupDO) super.getParentDO());
	}

	public void setParentDO(PeHmFollowupDO headDO) {
		setParent(headDO);
	}

	public PeHmFollowupRiskDO[] getPeHmFollowupRiskDO() {
		IBaseDO[] dos = getChildren(PeHmFollowupRiskDO.class);
		if(dos==null) return null;
		PeHmFollowupRiskDO[] result=new PeHmFollowupRiskDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeHmFollowupRiskDO)dos[i];
		}
		return result;
	}
	
	public void setPeHmFollowupRiskDO(PeHmFollowupRiskDO[] dos) {
		setChildren(PeHmFollowupRiskDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PehmfollowupAggDODesc desc = new PehmfollowupAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeHmFollowupDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.phm.pehmfollowup.d.PeHmFollowupRiskDO")) {
             return new PeHmFollowupRiskDO();
         }
         return null;
     }
}