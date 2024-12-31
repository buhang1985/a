package iih.nm.nhr.nmgrp.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nhr.nmgrp.d.desc.NmgrpAggDODesc;



/**
 * 护理小组
 */
public class NmgrpAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NmGrpDO getParentDO() {
		return ((NmGrpDO) super.getParentDO());
	}

	public void setParentDO(NmGrpDO headDO) {
		setParent(headDO);
	}

	public GrpDepDO[] getGrpDepDO() {
		IBaseDO[] dos = getChildren(GrpDepDO.class);
		if(dos==null) return null;
		GrpDepDO[] result=new GrpDepDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(GrpDepDO)dos[i];
		}
		return result;
	}
	
	public void setGrpDepDO(GrpDepDO[] dos) {
		setChildren(GrpDepDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NmgrpAggDODesc desc = new NmgrpAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NmGrpDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nhr.nmgrp.d.GrpDepDO")) {
             return new GrpDepDO();
         }
         return null;
     }
}