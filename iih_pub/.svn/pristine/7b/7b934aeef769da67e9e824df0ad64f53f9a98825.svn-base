package iih.pe.pqn.peevalchrodef.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pqn.peevalchrodef.d.desc.PeevalchrodefAggDODesc;



/**
 * 体检慢性病评估定义
 */
public class PeevalchrodefAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeEvalChroDefDO getParentDO() {
		return ((PeEvalChroDefDO) super.getParentDO());
	}

	public void setParentDO(PeEvalChroDefDO headDO) {
		setParent(headDO);
	}

	public PeChroRiskDefDO[] getPeChroRiskDefDO() {
		IBaseDO[] dos = getChildren(PeChroRiskDefDO.class);
		if(dos==null) return null;
		PeChroRiskDefDO[] result=new PeChroRiskDefDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeChroRiskDefDO)dos[i];
		}
		return result;
	}
	
	public void setPeChroRiskDefDO(PeChroRiskDefDO[] dos) {
		setChildren(PeChroRiskDefDO.class, dos);
	}
	public PeChroGradeDO[] getPeChroGradeDO() {
		IBaseDO[] dos = getChildren(PeChroGradeDO.class);
		if(dos==null) return null;
		PeChroGradeDO[] result=new PeChroGradeDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeChroGradeDO)dos[i];
		}
		return result;
	}
	
	public void setPeChroGradeDO(PeChroGradeDO[] dos) {
		setChildren(PeChroGradeDO.class, dos);
	}
	public PeChroDietDefDO[] getPeChroDietDefDO() {
		IBaseDO[] dos = getChildren(PeChroDietDefDO.class);
		if(dos==null) return null;
		PeChroDietDefDO[] result=new PeChroDietDefDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeChroDietDefDO)dos[i];
		}
		return result;
	}
	
	public void setPeChroDietDefDO(PeChroDietDefDO[] dos) {
		setChildren(PeChroDietDefDO.class, dos);
	}
	public PeChroExerciseDefDO[] getPeChroExerciseDefDO() {
		IBaseDO[] dos = getChildren(PeChroExerciseDefDO.class);
		if(dos==null) return null;
		PeChroExerciseDefDO[] result=new PeChroExerciseDefDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeChroExerciseDefDO)dos[i];
		}
		return result;
	}
	
	public void setPeChroExerciseDefDO(PeChroExerciseDefDO[] dos) {
		setChildren(PeChroExerciseDefDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PeevalchrodefAggDODesc desc = new PeevalchrodefAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeEvalChroDefDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pqn.peevalchrodef.d.PeChroRiskDefDO")) {
             return new PeChroRiskDefDO();
         }
	    else if (clzName.equals("iih.pe.pqn.peevalchrodef.d.PeChroGradeDO")) {
             return new PeChroGradeDO();
         }
	    else if (clzName.equals("iih.pe.pqn.peevalchrodef.d.PeChroDietDefDO")) {
             return new PeChroDietDefDO();
         }
	    else if (clzName.equals("iih.pe.pqn.peevalchrodef.d.PeChroExerciseDefDO")) {
             return new PeChroExerciseDefDO();
         }
         return null;
     }
}