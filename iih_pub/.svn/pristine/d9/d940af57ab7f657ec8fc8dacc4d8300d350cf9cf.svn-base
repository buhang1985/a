package iih.pe.phm.peeduplan.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.phm.peeduplan.d.desc.PeeduplanAggDODesc;



/**
 * 健康群体教育计划
 */
public class PeeduplanAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeEduPlanDO getParentDO() {
		return ((PeEduPlanDO) super.getParentDO());
	}

	public void setParentDO(PeEduPlanDO headDO) {
		setParent(headDO);
	}

	public PeEduPlanDtlDO[] getPeEduPlanDtlDO() {
		IBaseDO[] dos = getChildren(PeEduPlanDtlDO.class);
		if(dos==null) return null;
		PeEduPlanDtlDO[] result=new PeEduPlanDtlDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeEduPlanDtlDO)dos[i];
		}
		return result;
	}
	
	public void setPeEduPlanDtlDO(PeEduPlanDtlDO[] dos) {
		setChildren(PeEduPlanDtlDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PeeduplanAggDODesc desc = new PeeduplanAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeEduPlanDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.phm.peeduplan.d.PeEduPlanDtlDO")) {
             return new PeEduPlanDtlDO();
         }
         return null;
     }
}