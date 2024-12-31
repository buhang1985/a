package iih.sc.scbd.schedulesrv.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.sc.scbd.schedulesrv.d.desc.SchedulesrvAggDODesc;



/**
 * 排班服务
 */
public class SchedulesrvAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public ScheduleSrvDO getParentDO() {
		return ((ScheduleSrvDO) super.getParentDO());
	}

	public void setParentDO(ScheduleSrvDO headDO) {
		setParent(headDO);
	}

	public ScheduleSrvRelDO[] getScheduleSrvRelDO() {
		IBaseDO[] dos = getChildren(ScheduleSrvRelDO.class);
		if(dos==null) return null;
		ScheduleSrvRelDO[] result=new ScheduleSrvRelDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(ScheduleSrvRelDO)dos[i];
		}
		return result;
	}
	
	public void setScheduleSrvRelDO(ScheduleSrvRelDO[] dos) {
		setChildren(ScheduleSrvRelDO.class, dos);
	}
	public ScheduleSrvChlDO[] getScheduleSrvChlDO() {
		IBaseDO[] dos = getChildren(ScheduleSrvChlDO.class);
		if(dos==null) return null;
		ScheduleSrvChlDO[] result=new ScheduleSrvChlDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(ScheduleSrvChlDO)dos[i];
		}
		return result;
	}
	
	public void setScheduleSrvChlDO(ScheduleSrvChlDO[] dos) {
		setChildren(ScheduleSrvChlDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		SchedulesrvAggDODesc desc = new SchedulesrvAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new ScheduleSrvDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.sc.scbd.schedulesrv.d.ScheduleSrvRelDO")) {
             return new ScheduleSrvRelDO();
         }
	    else if (clzName.equals("iih.sc.scbd.schedulesrv.d.ScheduleSrvChlDO")) {
             return new ScheduleSrvChlDO();
         }
         return null;
     }
}