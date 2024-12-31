package iih.bd.cmp.marplan.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.cmp.marplan.d.desc.MarplanAggDODesc;



/**
 * 营销方案
 */
public class MarplanAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public BdCmpMarPlanDO getParentDO() {
		return ((BdCmpMarPlanDO) super.getParentDO());
	}

	public void setParentDO(BdCmpMarPlanDO headDO) {
		setParent(headDO);
	}

	public BdCmpMarCtrDO[] getBdCmpMarCtrDO() {
		IBaseDO[] dos = getChildren(BdCmpMarCtrDO.class);
		if(dos==null) return null;
		BdCmpMarCtrDO[] result=new BdCmpMarCtrDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BdCmpMarCtrDO)dos[i];
		}
		return result;
	}
	
	public void setBdCmpMarCtrDO(BdCmpMarCtrDO[] dos) {
		setChildren(BdCmpMarCtrDO.class, dos);
	}
	public BdCmpMarChkDO[] getBdCmpMarChkDO() {
		IBaseDO[] dos = getChildren(BdCmpMarChkDO.class);
		if(dos==null) return null;
		BdCmpMarChkDO[] result=new BdCmpMarChkDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BdCmpMarChkDO)dos[i];
		}
		return result;
	}
	
	public void setBdCmpMarChkDO(BdCmpMarChkDO[] dos) {
		setChildren(BdCmpMarChkDO.class, dos);
	}
	public BdCmpMarTreatDO[] getBdCmpMarTreatDO() {
		IBaseDO[] dos = getChildren(BdCmpMarTreatDO.class);
		if(dos==null) return null;
		BdCmpMarTreatDO[] result=new BdCmpMarTreatDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BdCmpMarTreatDO)dos[i];
		}
		return result;
	}
	
	public void setBdCmpMarTreatDO(BdCmpMarTreatDO[] dos) {
		setChildren(BdCmpMarTreatDO.class, dos);
	}
	public BdCmpMarFreeDO[] getBdCmpMarFreeDO() {
		IBaseDO[] dos = getChildren(BdCmpMarFreeDO.class);
		if(dos==null) return null;
		BdCmpMarFreeDO[] result=new BdCmpMarFreeDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BdCmpMarFreeDO)dos[i];
		}
		return result;
	}
	
	public void setBdCmpMarFreeDO(BdCmpMarFreeDO[] dos) {
		setChildren(BdCmpMarFreeDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		MarplanAggDODesc desc = new MarplanAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new BdCmpMarPlanDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.cmp.marplan.d.BdCmpMarCtrDO")) {
             return new BdCmpMarCtrDO();
         }
	    else if (clzName.equals("iih.bd.cmp.marplan.d.BdCmpMarChkDO")) {
             return new BdCmpMarChkDO();
         }
	    else if (clzName.equals("iih.bd.cmp.marplan.d.BdCmpMarTreatDO")) {
             return new BdCmpMarTreatDO();
         }
	    else if (clzName.equals("iih.bd.cmp.marplan.d.BdCmpMarFreeDO")) {
             return new BdCmpMarFreeDO();
         }
         return null;
     }
}