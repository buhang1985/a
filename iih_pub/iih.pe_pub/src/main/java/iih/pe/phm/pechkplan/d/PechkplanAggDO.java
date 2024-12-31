package iih.pe.phm.pechkplan.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.phm.pechkplan.d.desc.PechkplanAggDODesc;



/**
 * 健康体检计划
 */
public class PechkplanAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeChkPlanDO getParentDO() {
		return ((PeChkPlanDO) super.getParentDO());
	}

	public void setParentDO(PeChkPlanDO headDO) {
		setParent(headDO);
	}

	public PeChkPlanItmDO[] getPeChkPlanItmDO() {
		IBaseDO[] dos = getChildren(PeChkPlanItmDO.class);
		if(dos==null) return null;
		PeChkPlanItmDO[] result=new PeChkPlanItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeChkPlanItmDO)dos[i];
		}
		return result;
	}
	
	public void setPeChkPlanItmDO(PeChkPlanItmDO[] dos) {
		setChildren(PeChkPlanItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PechkplanAggDODesc desc = new PechkplanAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeChkPlanDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.phm.pechkplan.d.PeChkPlanItmDO")) {
             return new PeChkPlanItmDO();
         }
         return null;
     }
}