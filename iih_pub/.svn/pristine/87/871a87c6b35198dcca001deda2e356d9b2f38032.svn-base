package iih.hr.hsc.hscschedweek.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.hr.hsc.hscschedweek.d.desc.HscschedweekAggDODesc;



/**
 * 排班周信息
 */
public class HscschedweekAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public HscSchedWeekDO getParentDO() {
		return ((HscSchedWeekDO) super.getParentDO());
	}

	public void setParentDO(HscSchedWeekDO headDO) {
		setParent(headDO);
	}

	public HscSchedDO[] getHscSchedDO() {
		IBaseDO[] dos = getChildren(HscSchedDO.class);
		if(dos==null) return null;
		HscSchedDO[] result=new HscSchedDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(HscSchedDO)dos[i];
		}
		return result;
	}
	
	public void setHscSchedDO(HscSchedDO[] dos) {
		setChildren(HscSchedDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		HscschedweekAggDODesc desc = new HscschedweekAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new HscSchedWeekDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.hr.hsc.hscschedweek.d.HscSchedDO")) {
             return new HscSchedDO();
         }
         return null;
     }
}