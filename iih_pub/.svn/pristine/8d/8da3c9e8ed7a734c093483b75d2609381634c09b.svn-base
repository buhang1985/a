package iih.nm.nhr.nhrsched.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nhr.nhrsched.d.desc.NhrschedAggDODesc;



/**
 * 人员排班
 */
public class NhrschedAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NhrSchedDO getParentDO() {
		return ((NhrSchedDO) super.getParentDO());
	}

	public void setParentDO(NhrSchedDO headDO) {
		setParent(headDO);
	}

	public NhrSchedStuDO[] getNhrSchedStuDO() {
		IBaseDO[] dos = getChildren(NhrSchedStuDO.class);
		if(dos==null) return null;
		NhrSchedStuDO[] result=new NhrSchedStuDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NhrSchedStuDO)dos[i];
		}
		return result;
	}
	
	public void setNhrSchedStuDO(NhrSchedStuDO[] dos) {
		setChildren(NhrSchedStuDO.class, dos);
	}
	public NhrSchedBedDO[] getNhrSchedBedDO() {
		IBaseDO[] dos = getChildren(NhrSchedBedDO.class);
		if(dos==null) return null;
		NhrSchedBedDO[] result=new NhrSchedBedDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NhrSchedBedDO)dos[i];
		}
		return result;
	}
	
	public void setNhrSchedBedDO(NhrSchedBedDO[] dos) {
		setChildren(NhrSchedBedDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NhrschedAggDODesc desc = new NhrschedAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NhrSchedDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nhr.nhrsched.d.NhrSchedStuDO")) {
             return new NhrSchedStuDO();
         }
	    else if (clzName.equals("iih.nm.nhr.nhrsched.d.NhrSchedBedDO")) {
             return new NhrSchedBedDO();
         }
         return null;
     }
}