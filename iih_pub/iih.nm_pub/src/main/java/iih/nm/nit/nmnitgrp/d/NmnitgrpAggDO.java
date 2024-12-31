package iih.nm.nit.nmnitgrp.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nit.nmnitgrp.d.desc.NmnitgrpAggDODesc;



/**
 * 护理管理_实习小组
 */
public class NmnitgrpAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NmNitGrpDO getParentDO() {
		return ((NmNitGrpDO) super.getParentDO());
	}

	public void setParentDO(NmNitGrpDO headDO) {
		setParent(headDO);
	}

	public NmNitGrpDepDO[] getNmNitGrpDepDO() {
		IBaseDO[] dos = getChildren(NmNitGrpDepDO.class);
		if(dos==null) return null;
		NmNitGrpDepDO[] result=new NmNitGrpDepDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NmNitGrpDepDO)dos[i];
		}
		return result;
	}
	
	public void setNmNitGrpDepDO(NmNitGrpDepDO[] dos) {
		setChildren(NmNitGrpDepDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NmnitgrpAggDODesc desc = new NmnitgrpAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NmNitGrpDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nit.nmnitgrp.d.NmNitGrpDepDO")) {
             return new NmNitGrpDepDO();
         }
         return null;
     }
}