package iih.bd.res.dayslot.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.res.dayslot.d.desc.DayslotAggDODesc;



/**
 * 日期分组
 */
public class DayslotAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public DaysLotDO getParentDO() {
		return ((DaysLotDO) super.getParentDO());
	}

	public void setParentDO(DaysLotDO headDO) {
		setParent(headDO);
	}

	public DaysLotTimeDO[] getDaysLotTimeDO() {
		IBaseDO[] dos = getChildren(DaysLotTimeDO.class);
		if(dos==null) return null;
		DaysLotTimeDO[] result=new DaysLotTimeDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(DaysLotTimeDO)dos[i];
		}
		return result;
	}
	
	public void setDaysLotTimeDO(DaysLotTimeDO[] dos) {
		setChildren(DaysLotTimeDO.class, dos);
	}
	public DayslotSecDO[] getDayslotSecDO() {
		IBaseDO[] dos = getChildren(DayslotSecDO.class);
		if(dos==null) return null;
		DayslotSecDO[] result=new DayslotSecDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(DayslotSecDO)dos[i];
		}
		return result;
	}
	
	public void setDayslotSecDO(DayslotSecDO[] dos) {
		setChildren(DayslotSecDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		DayslotAggDODesc desc = new DayslotAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new DaysLotDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.res.dayslot.d.DaysLotTimeDO")) {
             return new DaysLotTimeDO();
         }
	    else if (clzName.equals("iih.bd.res.dayslot.d.DayslotSecDO")) {
             return new DayslotSecDO();
         }
         return null;
     }
}