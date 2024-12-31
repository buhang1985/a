package iih.ci.rcm.infectionrate.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.rcm.infectionrate.d.desc.InfectionrateAggDODesc;



/**
 * 医院感染现患率
 */
public class InfectionrateAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public InfectionRateDO getParentDO() {
		return ((InfectionRateDO) super.getParentDO());
	}

	public void setParentDO(InfectionRateDO headDO) {
		setParent(headDO);
	}

	public InfectionSiteDO[] getInfectionSiteDO() {
		IBaseDO[] dos = getChildren(InfectionSiteDO.class);
		if(dos==null) return null;
		InfectionSiteDO[] result=new InfectionSiteDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(InfectionSiteDO)dos[i];
		}
		return result;
	}
	
	public void setInfectionSiteDO(InfectionSiteDO[] dos) {
		setChildren(InfectionSiteDO.class, dos);
	}
	public InfectionDiagnosisDO[] getInfectionDiagnosisDO() {
		IBaseDO[] dos = getChildren(InfectionDiagnosisDO.class);
		if(dos==null) return null;
		InfectionDiagnosisDO[] result=new InfectionDiagnosisDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(InfectionDiagnosisDO)dos[i];
		}
		return result;
	}
	
	public void setInfectionDiagnosisDO(InfectionDiagnosisDO[] dos) {
		setChildren(InfectionDiagnosisDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		InfectionrateAggDODesc desc = new InfectionrateAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new InfectionRateDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.rcm.infectionrate.d.InfectionSiteDO")) {
             return new InfectionSiteDO();
         }
	    else if (clzName.equals("iih.ci.rcm.infectionrate.d.InfectionDiagnosisDO")) {
             return new InfectionDiagnosisDO();
         }
         return null;
     }
}