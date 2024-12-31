package iih.pe.pqn.peevalchrorisk.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pqn.peevalchrorisk.d.desc.PeevalchroriskAggDODesc;



/**
 * 体检慢病风险因素
 */
public class PeevalchroriskAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeChroRiskDO getParentDO() {
		return ((PeChroRiskDO) super.getParentDO());
	}

	public void setParentDO(PeChroRiskDO headDO) {
		setParent(headDO);
	}

	public PeChroDiDO[] getPeChroDiDO() {
		IBaseDO[] dos = getChildren(PeChroDiDO.class);
		if(dos==null) return null;
		PeChroDiDO[] result=new PeChroDiDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeChroDiDO)dos[i];
		}
		return result;
	}
	
	public void setPeChroDiDO(PeChroDiDO[] dos) {
		setChildren(PeChroDiDO.class, dos);
	}
	public PeChroQaDO[] getPeChroQaDO() {
		IBaseDO[] dos = getChildren(PeChroQaDO.class);
		if(dos==null) return null;
		PeChroQaDO[] result=new PeChroQaDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeChroQaDO)dos[i];
		}
		return result;
	}
	
	public void setPeChroQaDO(PeChroQaDO[] dos) {
		setChildren(PeChroQaDO.class, dos);
	}
	public PeChroRstDO[] getPeChroRstDO() {
		IBaseDO[] dos = getChildren(PeChroRstDO.class);
		if(dos==null) return null;
		PeChroRstDO[] result=new PeChroRstDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeChroRstDO)dos[i];
		}
		return result;
	}
	
	public void setPeChroRstDO(PeChroRstDO[] dos) {
		setChildren(PeChroRstDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PeevalchroriskAggDODesc desc = new PeevalchroriskAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeChroRiskDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pqn.peevalchrorisk.d.PeChroDiDO")) {
             return new PeChroDiDO();
         }
	    else if (clzName.equals("iih.pe.pqn.peevalchrorisk.d.PeChroQaDO")) {
             return new PeChroQaDO();
         }
	    else if (clzName.equals("iih.pe.pqn.peevalchrorisk.d.PeChroRstDO")) {
             return new PeChroRstDO();
         }
         return null;
     }
}