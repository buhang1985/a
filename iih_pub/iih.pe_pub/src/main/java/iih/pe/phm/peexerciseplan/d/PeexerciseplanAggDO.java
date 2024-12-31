package iih.pe.phm.peexerciseplan.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.phm.peexerciseplan.d.desc.PeexerciseplanAggDODesc;



/**
 * 体检运动计划
 */
public class PeexerciseplanAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeExercisePlanDO getParentDO() {
		return ((PeExercisePlanDO) super.getParentDO());
	}

	public void setParentDO(PeExercisePlanDO headDO) {
		setParent(headDO);
	}

	public PeExercisePlanDtlDO[] getPeExercisePlanDtlDO() {
		IBaseDO[] dos = getChildren(PeExercisePlanDtlDO.class);
		if(dos==null) return null;
		PeExercisePlanDtlDO[] result=new PeExercisePlanDtlDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeExercisePlanDtlDO)dos[i];
		}
		return result;
	}
	
	public void setPeExercisePlanDtlDO(PeExercisePlanDtlDO[] dos) {
		setChildren(PeExercisePlanDtlDO.class, dos);
	}
	public PeExerciseListDO[] getPeExerciseListDO() {
		IBaseDO[] dos = getChildren(PeExerciseListDO.class);
		if(dos==null) return null;
		PeExerciseListDO[] result=new PeExerciseListDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeExerciseListDO)dos[i];
		}
		return result;
	}
	
	public void setPeExerciseListDO(PeExerciseListDO[] dos) {
		setChildren(PeExerciseListDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PeexerciseplanAggDODesc desc = new PeexerciseplanAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeExercisePlanDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.phm.peexerciseplan.d.PeExercisePlanDtlDO")) {
             return new PeExercisePlanDtlDO();
         }
	    else if (clzName.equals("iih.pe.phm.peexerciseplan.d.PeExerciseListDO")) {
             return new PeExerciseListDO();
         }
         return null;
     }
}