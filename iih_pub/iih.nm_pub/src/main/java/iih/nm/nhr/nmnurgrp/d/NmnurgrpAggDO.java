package iih.nm.nhr.nmnurgrp.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nhr.nmnurgrp.d.desc.NmnurgrpAggDODesc;



/**
 * 护理管理人员小组
 */
public class NmnurgrpAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NmNurGrpDO getParentDO() {
		return ((NmNurGrpDO) super.getParentDO());
	}

	public void setParentDO(NmNurGrpDO headDO) {
		setParent(headDO);
	}

	public NmNurGrpPsnDo[] getNmNurGrpPsnDo() {
		IBaseDO[] dos = getChildren(NmNurGrpPsnDo.class);
		if(dos==null) return null;
		NmNurGrpPsnDo[] result=new NmNurGrpPsnDo[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NmNurGrpPsnDo)dos[i];
		}
		return result;
	}
	
	public void setNmNurGrpPsnDo(NmNurGrpPsnDo[] dos) {
		setChildren(NmNurGrpPsnDo.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NmnurgrpAggDODesc desc = new NmnurgrpAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NmNurGrpDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nhr.nmnurgrp.d.NmNurGrpPsnDo")) {
             return new NmNurGrpPsnDo();
         }
         return null;
     }
}