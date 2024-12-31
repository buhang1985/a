package iih.pe.phm.peinterveneplan.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.phm.peinterveneplan.d.desc.PeinterveneplanAggDODesc;



/**
 * 健康干预个人计划
 */
public class PeinterveneplanAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeIntervenePlanDO getParentDO() {
		return ((PeIntervenePlanDO) super.getParentDO());
	}

	public void setParentDO(PeIntervenePlanDO headDO) {
		setParent(headDO);
	}

	public PeIntervenePlanRiskDO[] getPeIntervenePlanRiskDO() {
		IBaseDO[] dos = getChildren(PeIntervenePlanRiskDO.class);
		if(dos==null) return null;
		PeIntervenePlanRiskDO[] result=new PeIntervenePlanRiskDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeIntervenePlanRiskDO)dos[i];
		}
		return result;
	}
	
	public void setPeIntervenePlanRiskDO(PeIntervenePlanRiskDO[] dos) {
		setChildren(PeIntervenePlanRiskDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PeinterveneplanAggDODesc desc = new PeinterveneplanAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeIntervenePlanDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.phm.peinterveneplan.d.PeIntervenePlanRiskDO")) {
             return new PeIntervenePlanRiskDO();
         }
         return null;
     }
}