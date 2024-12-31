package iih.mc.po.pruchase.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mc.po.pruchase.d.desc.PruchaseAggDODesc;



/**
 * 采购订单
 */
public class PruchaseAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public McPurchaseOrderDO getParentDO() {
		return ((McPurchaseOrderDO) super.getParentDO());
	}

	public void setParentDO(McPurchaseOrderDO headDO) {
		setParent(headDO);
	}

	public McPurchseOrderItmDO[] getMcPurchseOrderItmDO() {
		IBaseDO[] dos = getChildren(McPurchseOrderItmDO.class);
		if(dos==null) return null;
		McPurchseOrderItmDO[] result=new McPurchseOrderItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(McPurchseOrderItmDO)dos[i];
		}
		return result;
	}
	
	public void setMcPurchseOrderItmDO(McPurchseOrderItmDO[] dos) {
		setChildren(McPurchseOrderItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PruchaseAggDODesc desc = new PruchaseAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new McPurchaseOrderDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mc.po.pruchase.d.McPurchseOrderItmDO")) {
             return new McPurchseOrderItmDO();
         }
         return null;
     }
}