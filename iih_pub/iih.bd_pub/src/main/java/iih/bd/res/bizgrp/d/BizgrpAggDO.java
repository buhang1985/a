package iih.bd.res.bizgrp.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.res.bizgrp.d.desc.BizgrpAggDODesc;



/**
 * 业务组
 */
public class BizgrpAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public BizGroupDO getParentDO() {
		return ((BizGroupDO) super.getParentDO());
	}

	public void setParentDO(BizGroupDO headDO) {
		setParent(headDO);
	}

	public BizGrpEmpsDO[] getBizGrpEmpsDO() {
		IBaseDO[] dos = getChildren(BizGrpEmpsDO.class);
		if(dos==null) return null;
		BizGrpEmpsDO[] result=new BizGrpEmpsDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BizGrpEmpsDO)dos[i];
		}
		return result;
	}
	
	public void setBizGrpEmpsDO(BizGrpEmpsDO[] dos) {
		setChildren(BizGrpEmpsDO.class, dos);
	}
	public BizGrpBedDO[] getBizGrpBedDO() {
		IBaseDO[] dos = getChildren(BizGrpBedDO.class);
		if(dos==null) return null;
		BizGrpBedDO[] result=new BizGrpBedDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BizGrpBedDO)dos[i];
		}
		return result;
	}
	
	public void setBizGrpBedDO(BizGrpBedDO[] dos) {
		setChildren(BizGrpBedDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		BizgrpAggDODesc desc = new BizgrpAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new BizGroupDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.res.bizgrp.d.BizGrpEmpsDO")) {
             return new BizGrpEmpsDO();
         }
	    else if (clzName.equals("iih.bd.res.bizgrp.d.BizGrpBedDO")) {
             return new BizGrpBedDO();
         }
         return null;
     }
}