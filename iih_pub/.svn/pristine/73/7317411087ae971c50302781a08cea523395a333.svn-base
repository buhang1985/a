package iih.nm.nit.nitpracgrp.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nit.nitpracgrp.d.desc.NitpracgrpAggDODesc;



/**
 * 实习小组
 */
public class NitpracgrpAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NitPracgrpDO getParentDO() {
		return ((NitPracgrpDO) super.getParentDO());
	}

	public void setParentDO(NitPracgrpDO headDO) {
		setParent(headDO);
	}

	public NitPracgrpDepDO[] getNitPracgrpDepDO() {
		IBaseDO[] dos = getChildren(NitPracgrpDepDO.class);
		if(dos==null) return null;
		NitPracgrpDepDO[] result=new NitPracgrpDepDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NitPracgrpDepDO)dos[i];
		}
		return result;
	}
	
	public void setNitPracgrpDepDO(NitPracgrpDepDO[] dos) {
		setChildren(NitPracgrpDepDO.class, dos);
	}
	public NitPracGrpPsnDO[] getNitPracGrpPsnDO() {
		IBaseDO[] dos = getChildren(NitPracGrpPsnDO.class);
		if(dos==null) return null;
		NitPracGrpPsnDO[] result=new NitPracGrpPsnDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NitPracGrpPsnDO)dos[i];
		}
		return result;
	}
	
	public void setNitPracGrpPsnDO(NitPracGrpPsnDO[] dos) {
		setChildren(NitPracGrpPsnDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NitpracgrpAggDODesc desc = new NitpracgrpAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NitPracgrpDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nit.nitpracgrp.d.NitPracgrpDepDO")) {
             return new NitPracgrpDepDO();
         }
	    else if (clzName.equals("iih.nm.nit.nitpracgrp.d.NitPracGrpPsnDO")) {
             return new NitPracGrpPsnDO();
         }
         return null;
     }
}