package iih.mm.st.stockout.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mm.st.stockout.d.desc.StockoutAggDODesc;



/**
 * 出库单
 */
public class StockoutAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public StockOutDO getParentDO() {
		return ((StockOutDO) super.getParentDO());
	}

	public void setParentDO(StockOutDO headDO) {
		setParent(headDO);
	}

	public StockOutItemDO[] getStockOutItemDO() {
		IBaseDO[] dos = getChildren(StockOutItemDO.class);
		if(dos==null) return null;
		StockOutItemDO[] result=new StockOutItemDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(StockOutItemDO)dos[i];
		}
		return result;
	}
	
	public void setStockOutItemDO(StockOutItemDO[] dos) {
		setChildren(StockOutItemDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		StockoutAggDODesc desc = new StockoutAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new StockOutDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mm.st.stockout.d.StockOutItemDO")) {
             return new StockOutItemDO();
         }
         return null;
     }
}