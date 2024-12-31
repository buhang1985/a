package iih.nm.nqm.aer.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nqm.aer.d.desc.AerAggDODesc;



/**
 * 不良事件上报
 */
public class AerAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NmAerDO getParentDO() {
		return ((NmAerDO) super.getParentDO());
	}

	public void setParentDO(NmAerDO headDO) {
		setParent(headDO);
	}

	public NmAerCaDO[] getNmAerCaDO() {
		IBaseDO[] dos = getChildren(NmAerCaDO.class);
		if(dos==null) return null;
		NmAerCaDO[] result=new NmAerCaDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NmAerCaDO)dos[i];
		}
		return result;
	}
	
	public void setNmAerCaDO(NmAerCaDO[] dos) {
		setChildren(NmAerCaDO.class, dos);
	}
	public NmAerPatDO[] getNmAerPatDO() {
		IBaseDO[] dos = getChildren(NmAerPatDO.class);
		if(dos==null) return null;
		NmAerPatDO[] result=new NmAerPatDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NmAerPatDO)dos[i];
		}
		return result;
	}
	
	public void setNmAerPatDO(NmAerPatDO[] dos) {
		setChildren(NmAerPatDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		AerAggDODesc desc = new AerAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NmAerDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nqm.aer.d.NmAerCaDO")) {
             return new NmAerCaDO();
         }
	    else if (clzName.equals("iih.nm.nqm.aer.d.NmAerPatDO")) {
             return new NmAerPatDO();
         }
         return null;
     }
}