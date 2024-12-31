package iih.nm.nqm.nqmqcgrp.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nqm.nqmqcgrp.d.desc.NqmqcgrpAggDODesc;



/**
 * 质控组
 */
public class NqmqcgrpAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NqmQcgrpDO getParentDO() {
		return ((NqmQcgrpDO) super.getParentDO());
	}

	public void setParentDO(NqmQcgrpDO headDO) {
		setParent(headDO);
	}

	public NqmQcgrpPsnDO[] getNqmQcgrpPsnDO() {
		IBaseDO[] dos = getChildren(NqmQcgrpPsnDO.class);
		if(dos==null) return null;
		NqmQcgrpPsnDO[] result=new NqmQcgrpPsnDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NqmQcgrpPsnDO)dos[i];
		}
		return result;
	}
	
	public void setNqmQcgrpPsnDO(NqmQcgrpPsnDO[] dos) {
		setChildren(NqmQcgrpPsnDO.class, dos);
	}
	public NqmQcgrpCsDO[] getNqmQcgrpCsDO() {
		IBaseDO[] dos = getChildren(NqmQcgrpCsDO.class);
		if(dos==null) return null;
		NqmQcgrpCsDO[] result=new NqmQcgrpCsDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NqmQcgrpCsDO)dos[i];
		}
		return result;
	}
	
	public void setNqmQcgrpCsDO(NqmQcgrpCsDO[] dos) {
		setChildren(NqmQcgrpCsDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NqmqcgrpAggDODesc desc = new NqmqcgrpAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NqmQcgrpDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nqm.nqmqcgrp.d.NqmQcgrpPsnDO")) {
             return new NqmQcgrpPsnDO();
         }
	    else if (clzName.equals("iih.nm.nqm.nqmqcgrp.d.NqmQcgrpCsDO")) {
             return new NqmQcgrpCsDO();
         }
         return null;
     }
}