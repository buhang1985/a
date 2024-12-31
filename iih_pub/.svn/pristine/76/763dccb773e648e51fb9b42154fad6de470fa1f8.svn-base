package iih.bd.pp.modifypriplan.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.pp.modifypriplan.d.desc.ModifypriplanAggDODesc;



/**
 * 调价计划
 */
public class ModifypriplanAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public ModifyPriPlanDO getParentDO() {
		return ((ModifyPriPlanDO) super.getParentDO());
	}

	public void setParentDO(ModifyPriPlanDO headDO) {
		setParent(headDO);
	}

	public ModifyPriPlanItmDO[] getModifyPriPlanItmDO() {
		IBaseDO[] dos = getChildren(ModifyPriPlanItmDO.class);
		if(dos==null) return null;
		ModifyPriPlanItmDO[] result=new ModifyPriPlanItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(ModifyPriPlanItmDO)dos[i];
		}
		return result;
	}
	
	public void setModifyPriPlanItmDO(ModifyPriPlanItmDO[] dos) {
		setChildren(ModifyPriPlanItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		ModifypriplanAggDODesc desc = new ModifypriplanAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new ModifyPriPlanDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.pp.modifypriplan.d.ModifyPriPlanItmDO")) {
             return new ModifyPriPlanItmDO();
         }
         return null;
     }
}