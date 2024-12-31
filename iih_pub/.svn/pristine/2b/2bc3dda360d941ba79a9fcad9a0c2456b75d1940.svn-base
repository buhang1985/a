package iih.pe.pitm.perstillness.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pitm.perstillness.d.desc.PerstillnessAggDODesc;



/**
 * 体检疾病定义
 */
public class PerstillnessAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeRstIllnessDO getParentDO() {
		return ((PeRstIllnessDO) super.getParentDO());
	}

	public void setParentDO(PeRstIllnessDO headDO) {
		setParent(headDO);
	}

	public PeRstIllnessItemDO[] getPeRstIllnessItemDO() {
		IBaseDO[] dos = getChildren(PeRstIllnessItemDO.class);
		if(dos==null) return null;
		PeRstIllnessItemDO[] result=new PeRstIllnessItemDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeRstIllnessItemDO)dos[i];
		}
		return result;
	}
	
	public void setPeRstIllnessItemDO(PeRstIllnessItemDO[] dos) {
		setChildren(PeRstIllnessItemDO.class, dos);
	}
	public PeRstIllnessDiDO[] getPeRstIllnessDiDO() {
		IBaseDO[] dos = getChildren(PeRstIllnessDiDO.class);
		if(dos==null) return null;
		PeRstIllnessDiDO[] result=new PeRstIllnessDiDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeRstIllnessDiDO)dos[i];
		}
		return result;
	}
	
	public void setPeRstIllnessDiDO(PeRstIllnessDiDO[] dos) {
		setChildren(PeRstIllnessDiDO.class, dos);
	}
	public PeRstIllnessSportDO[] getPeRstIllnessSportDO() {
		IBaseDO[] dos = getChildren(PeRstIllnessSportDO.class);
		if(dos==null) return null;
		PeRstIllnessSportDO[] result=new PeRstIllnessSportDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeRstIllnessSportDO)dos[i];
		}
		return result;
	}
	
	public void setPeRstIllnessSportDO(PeRstIllnessSportDO[] dos) {
		setChildren(PeRstIllnessSportDO.class, dos);
	}
	public PeRstIllnessFoodDO[] getPeRstIllnessFoodDO() {
		IBaseDO[] dos = getChildren(PeRstIllnessFoodDO.class);
		if(dos==null) return null;
		PeRstIllnessFoodDO[] result=new PeRstIllnessFoodDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeRstIllnessFoodDO)dos[i];
		}
		return result;
	}
	
	public void setPeRstIllnessFoodDO(PeRstIllnessFoodDO[] dos) {
		setChildren(PeRstIllnessFoodDO.class, dos);
	}
	public PeRstIllnessKeyDO[] getPeRstIllnessKeyDO() {
		IBaseDO[] dos = getChildren(PeRstIllnessKeyDO.class);
		if(dos==null) return null;
		PeRstIllnessKeyDO[] result=new PeRstIllnessKeyDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeRstIllnessKeyDO)dos[i];
		}
		return result;
	}
	
	public void setPeRstIllnessKeyDO(PeRstIllnessKeyDO[] dos) {
		setChildren(PeRstIllnessKeyDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PerstillnessAggDODesc desc = new PerstillnessAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeRstIllnessDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pitm.perstillness.d.PeRstIllnessItemDO")) {
             return new PeRstIllnessItemDO();
         }
	    else if (clzName.equals("iih.pe.pitm.perstillness.d.PeRstIllnessDiDO")) {
             return new PeRstIllnessDiDO();
         }
	    else if (clzName.equals("iih.pe.pitm.perstillness.d.PeRstIllnessSportDO")) {
             return new PeRstIllnessSportDO();
         }
	    else if (clzName.equals("iih.pe.pitm.perstillness.d.PeRstIllnessFoodDO")) {
             return new PeRstIllnessFoodDO();
         }
	    else if (clzName.equals("iih.pe.pitm.perstillness.d.PeRstIllnessKeyDO")) {
             return new PeRstIllnessKeyDO();
         }
         return null;
     }
}