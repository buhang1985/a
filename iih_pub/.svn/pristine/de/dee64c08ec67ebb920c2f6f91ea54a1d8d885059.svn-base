package iih.mm.bl.blreserve.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mm.bl.blreserve.d.desc.BlreserveAggDODesc;



/**
 * 物品结存预留处理明细
 */
public class BlreserveAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public StockBlReserveDO getParentDO() {
		return ((StockBlReserveDO) super.getParentDO());
	}

	public void setParentDO(StockBlReserveDO headDO) {
		setParent(headDO);
	}

	public StockBlReserveItemDO[] getStockBlReserveItemDO() {
		IBaseDO[] dos = getChildren(StockBlReserveItemDO.class);
		if(dos==null) return null;
		StockBlReserveItemDO[] result=new StockBlReserveItemDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(StockBlReserveItemDO)dos[i];
		}
		return result;
	}
	
	public void setStockBlReserveItemDO(StockBlReserveItemDO[] dos) {
		setChildren(StockBlReserveItemDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		BlreserveAggDODesc desc = new BlreserveAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new StockBlReserveDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mm.bl.blreserve.d.StockBlReserveItemDO")) {
             return new StockBlReserveItemDO();
         }
         return null;
     }
}