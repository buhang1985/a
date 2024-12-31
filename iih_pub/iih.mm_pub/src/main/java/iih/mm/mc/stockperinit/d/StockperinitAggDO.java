package iih.mm.mc.stockperinit.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mm.mc.stockperinit.d.desc.StockperinitAggDODesc;



/**
 * 库存期初
 */
public class StockperinitAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public StockPerInitDO getParentDO() {
		return ((StockPerInitDO) super.getParentDO());
	}

	public void setParentDO(StockPerInitDO headDO) {
		setParent(headDO);
	}

	public StockPerInitItemDO[] getStockPerInitItemDO() {
		IBaseDO[] dos = getChildren(StockPerInitItemDO.class);
		if(dos==null) return null;
		StockPerInitItemDO[] result=new StockPerInitItemDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(StockPerInitItemDO)dos[i];
		}
		return result;
	}
	
	public void setStockPerInitItemDO(StockPerInitItemDO[] dos) {
		setChildren(StockPerInitItemDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		StockperinitAggDODesc desc = new StockperinitAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new StockPerInitDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mm.mc.stockperinit.d.StockPerInitItemDO")) {
             return new StockPerInitItemDO();
         }
         return null;
     }
}