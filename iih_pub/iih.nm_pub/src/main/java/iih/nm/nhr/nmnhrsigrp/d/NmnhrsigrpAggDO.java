package iih.nm.nhr.nmnhrsigrp.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nhr.nmnhrsigrp.d.desc.NmnhrsigrpAggDODesc;



/**
 * 排班分组
 */
public class NmnhrsigrpAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NhrSigrpDO getParentDO() {
		return ((NhrSigrpDO) super.getParentDO());
	}

	public void setParentDO(NhrSigrpDO headDO) {
		setParent(headDO);
	}

	public NhrSigrpPsnDO[] getNhrSigrpPsnDO() {
		IBaseDO[] dos = getChildren(NhrSigrpPsnDO.class);
		if(dos==null) return null;
		NhrSigrpPsnDO[] result=new NhrSigrpPsnDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NhrSigrpPsnDO)dos[i];
		}
		return result;
	}
	
	public void setNhrSigrpPsnDO(NhrSigrpPsnDO[] dos) {
		setChildren(NhrSigrpPsnDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NmnhrsigrpAggDODesc desc = new NmnhrsigrpAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NhrSigrpDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nhr.nmnhrsigrp.d.NhrSigrpPsnDO")) {
             return new NhrSigrpPsnDO();
         }
         return null;
     }
}