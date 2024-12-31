package iih.mp.dg.opdrugmp.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mp.dg.opdrugmp.d.desc.OpdrugmpAggDODesc;



/**
 * 门诊药品执行
 */
public class OpdrugmpAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public OpDrugExeDO getParentDO() {
		return ((OpDrugExeDO) super.getParentDO());
	}

	public void setParentDO(OpDrugExeDO headDO) {
		setParent(headDO);
	}

	public OpDrugExeItemDO[] getOpDrugExeItemDO() {
		IBaseDO[] dos = getChildren(OpDrugExeItemDO.class);
		if(dos==null) return null;
		OpDrugExeItemDO[] result=new OpDrugExeItemDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(OpDrugExeItemDO)dos[i];
		}
		return result;
	}
	
	public void setOpDrugExeItemDO(OpDrugExeItemDO[] dos) {
		setChildren(OpDrugExeItemDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		OpdrugmpAggDODesc desc = new OpdrugmpAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new OpDrugExeDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mp.dg.opdrugmp.d.OpDrugExeItemDO")) {
             return new OpDrugExeItemDO();
         }
         return null;
     }
}