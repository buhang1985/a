package iih.bd.bs.workcalendar.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.bs.workcalendar.d.desc.WorkcalendarAggDODesc;



/**
 * 工作日历
 */
public class WorkcalendarAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public WorkCalendarDO getParentDO() {
		return ((WorkCalendarDO) super.getParentDO());
	}

	public void setParentDO(WorkCalendarDO headDO) {
		setParent(headDO);
	}

	public WorkCalendYearDO[] getWorkCalendYearDO() {
		IBaseDO[] dos = getChildren(WorkCalendYearDO.class);
		if(dos==null) return null;
		WorkCalendYearDO[] result=new WorkCalendYearDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(WorkCalendYearDO)dos[i];
		}
		return result;
	}
	
	public void setWorkCalendYearDO(WorkCalendYearDO[] dos) {
		setChildren(WorkCalendYearDO.class, dos);
	}
	public WorkCalendDateDO[] getWorkCalendDateDO() {
		IBaseDO[] dos = getChildren(WorkCalendDateDO.class);
		if(dos==null) return null;
		WorkCalendDateDO[] result=new WorkCalendDateDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(WorkCalendDateDO)dos[i];
		}
		return result;
	}
	
	public void setWorkCalendDateDO(WorkCalendDateDO[] dos) {
		setChildren(WorkCalendDateDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		WorkcalendarAggDODesc desc = new WorkcalendarAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new WorkCalendarDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.bs.workcalendar.d.WorkCalendYearDO")) {
             return new WorkCalendYearDO();
         }
	    else if (clzName.equals("iih.bd.bs.workcalendar.d.WorkCalendDateDO")) {
             return new WorkCalendDateDO();
         }
         return null;
     }
}