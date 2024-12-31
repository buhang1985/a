package iih.nm.nqm.nqmimprovl.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nqm.nqmimprovl.d.desc.NqmimprovlAggDODesc;



/**
 * 持续改进
 */
public class NqmimprovlAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NqmImprovDO getParentDO() {
		return ((NqmImprovDO) super.getParentDO());
	}

	public void setParentDO(NqmImprovDO headDO) {
		setParent(headDO);
	}

	public NqmImprovKpiDO[] getNqmImprovKpiDO() {
		IBaseDO[] dos = getChildren(NqmImprovKpiDO.class);
		if(dos==null) return null;
		NqmImprovKpiDO[] result=new NqmImprovKpiDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NqmImprovKpiDO)dos[i];
		}
		return result;
	}
	
	public void setNqmImprovKpiDO(NqmImprovKpiDO[] dos) {
		setChildren(NqmImprovKpiDO.class, dos);
	}
	public NqmImprovMendRecDO[] getNqmImprovMendRecDO() {
		IBaseDO[] dos = getChildren(NqmImprovMendRecDO.class);
		if(dos==null) return null;
		NqmImprovMendRecDO[] result=new NqmImprovMendRecDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NqmImprovMendRecDO)dos[i];
		}
		return result;
	}
	
	public void setNqmImprovMendRecDO(NqmImprovMendRecDO[] dos) {
		setChildren(NqmImprovMendRecDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NqmimprovlAggDODesc desc = new NqmimprovlAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NqmImprovDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nqm.nqmimprovl.d.NqmImprovKpiDO")) {
             return new NqmImprovKpiDO();
         }
	    else if (clzName.equals("iih.nm.nqm.nqmimprovl.d.NqmImprovMendRecDO")) {
             return new NqmImprovMendRecDO();
         }
         return null;
     }
}