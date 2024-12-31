package iih.bd.srv.srvortplgrp.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import iih.bd.srv.srvortplgrp.d.desc.SrvortplgrpAggDODesc;

/**
 * 医疗服务_医嘱开立模板分组
 */
public class SrvortplgrpAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public SrvOrTplGrpDO getParentDO() {
		return ((SrvOrTplGrpDO) super.getParentDO());
	}

	public void setParentDO(SrvOrTplGrpDO headDO) {
		setParent(headDO);
	}

	public SrvOrTplGrpItemDO[] getSrvOrTplGrpItemDO() {
		return ((SrvOrTplGrpItemDO[]) (SrvOrTplGrpItemDO[]) getChildren(SrvOrTplGrpItemDO.class));
	}
	
	public void setSrvOrTplGrpItemDO(SrvOrTplGrpItemDO[] dos) {
		setChildren(SrvOrTplGrpItemDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		SrvortplgrpAggDODesc desc = new SrvortplgrpAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new SrvOrTplGrpDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.srv.srvortplgrp.d.SrvOrTplGrpItemDO")) {
             return new SrvOrTplGrpItemDO();
         }
         return null;
     }
}