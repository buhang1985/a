package iih.pe.phm.pehmriskdef.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.phm.pehmriskdef.d.desc.PehmriskdefAggDODesc;



/**
 * 健康危险因素定义
 */
public class PehmriskdefAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeHmRiskDefDO getParentDO() {
		return ((PeHmRiskDefDO) super.getParentDO());
	}

	public void setParentDO(PeHmRiskDefDO headDO) {
		setParent(headDO);
	}

	public PeHmRiskRangeDO[] getPeHmRiskRangeDO() {
		IBaseDO[] dos = getChildren(PeHmRiskRangeDO.class);
		if(dos==null) return null;
		PeHmRiskRangeDO[] result=new PeHmRiskRangeDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeHmRiskRangeDO)dos[i];
		}
		return result;
	}
	
	public void setPeHmRiskRangeDO(PeHmRiskRangeDO[] dos) {
		setChildren(PeHmRiskRangeDO.class, dos);
	}
	public PeHmRiskSrvItmDO[] getPeHmRiskSrvItmDO() {
		IBaseDO[] dos = getChildren(PeHmRiskSrvItmDO.class);
		if(dos==null) return null;
		PeHmRiskSrvItmDO[] result=new PeHmRiskSrvItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeHmRiskSrvItmDO)dos[i];
		}
		return result;
	}
	
	public void setPeHmRiskSrvItmDO(PeHmRiskSrvItmDO[] dos) {
		setChildren(PeHmRiskSrvItmDO.class, dos);
	}
	public PeHmRiskSurveyDO[] getPeHmRiskSurveyDO() {
		IBaseDO[] dos = getChildren(PeHmRiskSurveyDO.class);
		if(dos==null) return null;
		PeHmRiskSurveyDO[] result=new PeHmRiskSurveyDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeHmRiskSurveyDO)dos[i];
		}
		return result;
	}
	
	public void setPeHmRiskSurveyDO(PeHmRiskSurveyDO[] dos) {
		setChildren(PeHmRiskSurveyDO.class, dos);
	}
	public PeHmRiskAgeTargetDO[] getPeHmRiskAgeTargetDO() {
		IBaseDO[] dos = getChildren(PeHmRiskAgeTargetDO.class);
		if(dos==null) return null;
		PeHmRiskAgeTargetDO[] result=new PeHmRiskAgeTargetDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeHmRiskAgeTargetDO)dos[i];
		}
		return result;
	}
	
	public void setPeHmRiskAgeTargetDO(PeHmRiskAgeTargetDO[] dos) {
		setChildren(PeHmRiskAgeTargetDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PehmriskdefAggDODesc desc = new PehmriskdefAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeHmRiskDefDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.phm.pehmriskdef.d.PeHmRiskRangeDO")) {
             return new PeHmRiskRangeDO();
         }
	    else if (clzName.equals("iih.pe.phm.pehmriskdef.d.PeHmRiskSrvItmDO")) {
             return new PeHmRiskSrvItmDO();
         }
	    else if (clzName.equals("iih.pe.phm.pehmriskdef.d.PeHmRiskSurveyDO")) {
             return new PeHmRiskSurveyDO();
         }
	    else if (clzName.equals("iih.pe.phm.pehmriskdef.d.PeHmRiskAgeTargetDO")) {
             return new PeHmRiskAgeTargetDO();
         }
         return null;
     }
}