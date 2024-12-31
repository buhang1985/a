package iih.nm.nhr.nhrscheditm.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nhr.nhrscheditm.d.desc.NhrscheditmAggDODesc;



/**
 * 人员排班明细
 */
public class NhrscheditmAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NhrSchedDO getParentDO() {
		return ((NhrSchedDO) super.getParentDO());
	}

	public void setParentDO(NhrSchedDO headDO) {
		setParent(headDO);
	}

	public NhrSchedItmStuDO[] getNhrSchedItmStuDO() {
		IBaseDO[] dos = getChildren(NhrSchedItmStuDO.class);
		if(dos==null) return null;
		NhrSchedItmStuDO[] result=new NhrSchedItmStuDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NhrSchedItmStuDO)dos[i];
		}
		return result;
	}
	
	public void setNhrSchedItmStuDO(NhrSchedItmStuDO[] dos) {
		setChildren(NhrSchedItmStuDO.class, dos);
	}
	public NhrSchedItmBedDO[] getNhrSchedItmBedDO() {
		IBaseDO[] dos = getChildren(NhrSchedItmBedDO.class);
		if(dos==null) return null;
		NhrSchedItmBedDO[] result=new NhrSchedItmBedDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NhrSchedItmBedDO)dos[i];
		}
		return result;
	}
	
	public void setNhrSchedItmBedDO(NhrSchedItmBedDO[] dos) {
		setChildren(NhrSchedItmBedDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NhrscheditmAggDODesc desc = new NhrscheditmAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NhrSchedDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nhr.nhrscheditm.d.NhrSchedItmStuDO")) {
             return new NhrSchedItmStuDO();
         }
	    else if (clzName.equals("iih.nm.nhr.nhrscheditm.d.NhrSchedItmBedDO")) {
             return new NhrSchedItmBedDO();
         }
         return null;
     }
}