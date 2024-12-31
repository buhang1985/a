package iih.sc.scbd.schedulechl.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.sc.scbd.schedulechl.d.desc.SchedulechlAggDODesc;



/**
 * 排班预约渠道
 */
public class SchedulechlAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public SchedulechlDO getParentDO() {
		return ((SchedulechlDO) super.getParentDO());
	}

	public void setParentDO(SchedulechlDO headDO) {
		setParent(headDO);
	}

	public ScChlPeriodDO[] getScChlPeriodDO() {
		IBaseDO[] dos = getChildren(ScChlPeriodDO.class);
		if(dos==null) return null;
		ScChlPeriodDO[] result=new ScChlPeriodDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(ScChlPeriodDO)dos[i];
		}
		return result;
	}
	
	public void setScChlPeriodDO(ScChlPeriodDO[] dos) {
		setChildren(ScChlPeriodDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		SchedulechlAggDODesc desc = new SchedulechlAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new SchedulechlDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.sc.scbd.schedulechl.d.ScChlPeriodDO")) {
             return new ScChlPeriodDO();
         }
         return null;
     }
}