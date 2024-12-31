package iih.sc.scp.scplweek.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.sc.scp.scplweek.d.desc.ScplweekAggDODesc;



/**
 * 计划排班_计划_周
 */
public class ScplweekAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public ScPlanWeekDO getParentDO() {
		return ((ScPlanWeekDO) super.getParentDO());
	}

	public void setParentDO(ScPlanWeekDO headDO) {
		setParent(headDO);
	}

	public ScPlanWeekChlDO[] getScPlanWeekChlDO() {
		IBaseDO[] dos = getChildren(ScPlanWeekChlDO.class);
		if(dos==null) return null;
		ScPlanWeekChlDO[] result=new ScPlanWeekChlDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(ScPlanWeekChlDO)dos[i];
		}
		return result;
	}
	
	public void setScPlanWeekChlDO(ScPlanWeekChlDO[] dos) {
		setChildren(ScPlanWeekChlDO.class, dos);
	}
	public ScPlanWeekEmpDO[] getScPlanWeekEmpDO() {
		IBaseDO[] dos = getChildren(ScPlanWeekEmpDO.class);
		if(dos==null) return null;
		ScPlanWeekEmpDO[] result=new ScPlanWeekEmpDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(ScPlanWeekEmpDO)dos[i];
		}
		return result;
	}
	
	public void setScPlanWeekEmpDO(ScPlanWeekEmpDO[] dos) {
		setChildren(ScPlanWeekEmpDO.class, dos);
	}
	public ScPlanWeekEnDO[] getScPlanWeekEnDO() {
		IBaseDO[] dos = getChildren(ScPlanWeekEnDO.class);
		if(dos==null) return null;
		ScPlanWeekEnDO[] result=new ScPlanWeekEnDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(ScPlanWeekEnDO)dos[i];
		}
		return result;
	}
	
	public void setScPlanWeekEnDO(ScPlanWeekEnDO[] dos) {
		setChildren(ScPlanWeekEnDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		ScplweekAggDODesc desc = new ScplweekAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new ScPlanWeekDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.sc.scp.scplweek.d.ScPlanWeekChlDO")) {
             return new ScPlanWeekChlDO();
         }
	    else if (clzName.equals("iih.sc.scp.scplweek.d.ScPlanWeekEmpDO")) {
             return new ScPlanWeekEmpDO();
         }
	    else if (clzName.equals("iih.sc.scp.scplweek.d.ScPlanWeekEnDO")) {
             return new ScPlanWeekEnDO();
         }
         return null;
     }
}