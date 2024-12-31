package iih.mc.mc.stockperinit.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mc.mc.stockperinit.d.desc.StockperinitAggDODesc;



/**
 * 耗材库存期初
 */
public class StockperinitAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public McStockPerInitDO getParentDO() {
		return ((McStockPerInitDO) super.getParentDO());
	}

	public void setParentDO(McStockPerInitDO headDO) {
		setParent(headDO);
	}

	public McStockPerInitItemDO[] getMcStockPerInitItemDO() {
		IBaseDO[] dos = getChildren(McStockPerInitItemDO.class);
		if(dos==null) return null;
		McStockPerInitItemDO[] result=new McStockPerInitItemDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(McStockPerInitItemDO)dos[i];
		}
		return result;
	}
	
	public void setMcStockPerInitItemDO(McStockPerInitItemDO[] dos) {
		setChildren(McStockPerInitItemDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		StockperinitAggDODesc desc = new StockperinitAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new McStockPerInitDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mc.mc.stockperinit.d.McStockPerInitItemDO")) {
             return new McStockPerInitItemDO();
         }
         return null;
     }
}