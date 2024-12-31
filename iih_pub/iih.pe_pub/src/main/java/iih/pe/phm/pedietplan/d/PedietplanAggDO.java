package iih.pe.phm.pedietplan.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.phm.pedietplan.d.desc.PedietplanAggDODesc;



/**
 * 体检饮食计划
 */
public class PedietplanAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeDietPlanDO getParentDO() {
		return ((PeDietPlanDO) super.getParentDO());
	}

	public void setParentDO(PeDietPlanDO headDO) {
		setParent(headDO);
	}

	public PeDietDivideDO[] getPeDietDivideDO() {
		IBaseDO[] dos = getChildren(PeDietDivideDO.class);
		if(dos==null) return null;
		PeDietDivideDO[] result=new PeDietDivideDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeDietDivideDO)dos[i];
		}
		return result;
	}
	
	public void setPeDietDivideDO(PeDietDivideDO[] dos) {
		setChildren(PeDietDivideDO.class, dos);
	}
	public PeDietPlanDayDO[] getPeDietPlanDayDO() {
		IBaseDO[] dos = getChildren(PeDietPlanDayDO.class);
		if(dos==null) return null;
		PeDietPlanDayDO[] result=new PeDietPlanDayDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeDietPlanDayDO)dos[i];
		}
		return result;
	}
	
	public void setPeDietPlanDayDO(PeDietPlanDayDO[] dos) {
		setChildren(PeDietPlanDayDO.class, dos);
	}
	public PeDietRecipeDO[] getPeDietRecipeDO() {
		IBaseDO[] dos = getChildren(PeDietRecipeDO.class);
		if(dos==null) return null;
		PeDietRecipeDO[] result=new PeDietRecipeDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeDietRecipeDO)dos[i];
		}
		return result;
	}
	
	public void setPeDietRecipeDO(PeDietRecipeDO[] dos) {
		setChildren(PeDietRecipeDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PedietplanAggDODesc desc = new PedietplanAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeDietPlanDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.phm.pedietplan.d.PeDietDivideDO")) {
             return new PeDietDivideDO();
         }
	    else if (clzName.equals("iih.pe.phm.pedietplan.d.PeDietPlanDayDO")) {
             return new PeDietPlanDayDO();
         }
	    else if (clzName.equals("iih.pe.phm.pedietplan.d.PeDietRecipeDO")) {
             return new PeDietRecipeDO();
         }
         return null;
     }
}