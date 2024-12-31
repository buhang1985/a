package iih.mm.po.purchase.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mm.po.purchase.d.desc.PurchaseAggDODesc;



/**
 * 采购单
 */
public class PurchaseAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PurchaseOrderDO getParentDO() {
		return ((PurchaseOrderDO) super.getParentDO());
	}

	public void setParentDO(PurchaseOrderDO headDO) {
		setParent(headDO);
	}

	public PurchseOrderItmDO[] getPurchseOrderItmDO() {
		IBaseDO[] dos = getChildren(PurchseOrderItmDO.class);
		if(dos==null) return null;
		PurchseOrderItmDO[] result=new PurchseOrderItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PurchseOrderItmDO)dos[i];
		}
		return result;
	}
	
	public void setPurchseOrderItmDO(PurchseOrderItmDO[] dos) {
		setChildren(PurchseOrderItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PurchaseAggDODesc desc = new PurchaseAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PurchaseOrderDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mm.po.purchase.d.PurchseOrderItmDO")) {
             return new PurchseOrderItmDO();
         }
         return null;
     }
}