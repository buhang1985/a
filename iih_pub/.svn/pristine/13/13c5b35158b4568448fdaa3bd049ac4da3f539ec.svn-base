package iih.nm.nhr.nhrschedweek.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nhr.nhrschedweek.d.desc.NhrschedweekAggDODesc;



/**
 * 排班周信息
 */
public class NhrschedweekAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NhrSchedWeekDO getParentDO() {
		return ((NhrSchedWeekDO) super.getParentDO());
	}

	public void setParentDO(NhrSchedWeekDO headDO) {
		setParent(headDO);
	}

	public NhrSchedDO[] getNhrSchedDO() {
		IBaseDO[] dos = getChildren(NhrSchedDO.class);
		if(dos==null) return null;
		NhrSchedDO[] result=new NhrSchedDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NhrSchedDO)dos[i];
		}
		return result;
	}
	
	public void setNhrSchedDO(NhrSchedDO[] dos) {
		setChildren(NhrSchedDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NhrschedweekAggDODesc desc = new NhrschedweekAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NhrSchedWeekDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nhr.nhrschedweek.d.NhrSchedDO")) {
             return new NhrSchedDO();
         }
         return null;
     }
}