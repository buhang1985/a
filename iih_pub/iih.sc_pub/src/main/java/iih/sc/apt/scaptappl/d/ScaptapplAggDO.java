package iih.sc.apt.scaptappl.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.sc.apt.scaptappl.d.desc.ScaptapplAggDODesc;



/**
 * 计划排班_预约_申请
 */
public class ScaptapplAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public ScAptApplDO getParentDO() {
		return ((ScAptApplDO) super.getParentDO());
	}

	public void setParentDO(ScAptApplDO headDO) {
		setParent(headDO);
	}

	public ScAptApplOptDO[] getScAptApplOptDO() {
		IBaseDO[] dos = getChildren(ScAptApplOptDO.class);
		if(dos==null) return null;
		ScAptApplOptDO[] result=new ScAptApplOptDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(ScAptApplOptDO)dos[i];
		}
		return result;
	}
	
	public void setScAptApplOptDO(ScAptApplOptDO[] dos) {
		setChildren(ScAptApplOptDO.class, dos);
	}
	public ScAptApplItmDO[] getScAptApplItmDO() {
		IBaseDO[] dos = getChildren(ScAptApplItmDO.class);
		if(dos==null) return null;
		ScAptApplItmDO[] result=new ScAptApplItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(ScAptApplItmDO)dos[i];
		}
		return result;
	}
	
	public void setScAptApplItmDO(ScAptApplItmDO[] dos) {
		setChildren(ScAptApplItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		ScaptapplAggDODesc desc = new ScaptapplAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new ScAptApplDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.sc.apt.scaptappl.d.ScAptApplOptDO")) {
             return new ScAptApplOptDO();
         }
	    else if (clzName.equals("iih.sc.apt.scaptappl.d.ScAptApplItmDO")) {
             return new ScAptApplItmDO();
         }
         return null;
     }
}