package iih.pe.pqn.peevalkinematics.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pqn.peevalkinematics.d.desc.PeevalkinematicsAggDODesc;



/**
 * 健康评估-运动评估定义
 */
public class PeevalkinematicsAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeEvalKinematicsDO getParentDO() {
		return ((PeEvalKinematicsDO) super.getParentDO());
	}

	public void setParentDO(PeEvalKinematicsDO headDO) {
		setParent(headDO);
	}

	public PeEvalKineIntDO[] getPeEvalKineIntDO() {
		IBaseDO[] dos = getChildren(PeEvalKineIntDO.class);
		if(dos==null) return null;
		PeEvalKineIntDO[] result=new PeEvalKineIntDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeEvalKineIntDO)dos[i];
		}
		return result;
	}
	
	public void setPeEvalKineIntDO(PeEvalKineIntDO[] dos) {
		setChildren(PeEvalKineIntDO.class, dos);
	}
	public PeEvalKineDurDO[] getPeEvalKineDurDO() {
		IBaseDO[] dos = getChildren(PeEvalKineDurDO.class);
		if(dos==null) return null;
		PeEvalKineDurDO[] result=new PeEvalKineDurDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeEvalKineDurDO)dos[i];
		}
		return result;
	}
	
	public void setPeEvalKineDurDO(PeEvalKineDurDO[] dos) {
		setChildren(PeEvalKineDurDO.class, dos);
	}
	public PeEvalKineFreqDO[] getPeEvalKineFreqDO() {
		IBaseDO[] dos = getChildren(PeEvalKineFreqDO.class);
		if(dos==null) return null;
		PeEvalKineFreqDO[] result=new PeEvalKineFreqDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeEvalKineFreqDO)dos[i];
		}
		return result;
	}
	
	public void setPeEvalKineFreqDO(PeEvalKineFreqDO[] dos) {
		setChildren(PeEvalKineFreqDO.class, dos);
	}
	public PeEvalKineLevelDO[] getPeEvalKineLevelDO() {
		IBaseDO[] dos = getChildren(PeEvalKineLevelDO.class);
		if(dos==null) return null;
		PeEvalKineLevelDO[] result=new PeEvalKineLevelDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeEvalKineLevelDO)dos[i];
		}
		return result;
	}
	
	public void setPeEvalKineLevelDO(PeEvalKineLevelDO[] dos) {
		setChildren(PeEvalKineLevelDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PeevalkinematicsAggDODesc desc = new PeevalkinematicsAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeEvalKinematicsDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pqn.peevalkinematics.d.PeEvalKineIntDO")) {
             return new PeEvalKineIntDO();
         }
	    else if (clzName.equals("iih.pe.pqn.peevalkinematics.d.PeEvalKineDurDO")) {
             return new PeEvalKineDurDO();
         }
	    else if (clzName.equals("iih.pe.pqn.peevalkinematics.d.PeEvalKineFreqDO")) {
             return new PeEvalKineFreqDO();
         }
	    else if (clzName.equals("iih.pe.pqn.peevalkinematics.d.PeEvalKineLevelDO")) {
             return new PeEvalKineLevelDO();
         }
         return null;
     }
}