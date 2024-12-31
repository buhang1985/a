package iih.mm.st.stockpriceadjust.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mm.st.stockpriceadjust.d.desc.StockpriceadjustAggDODesc;



/**
 * 库存调价
 */
public class StockpriceadjustAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public StockPriceAdjustDO getParentDO() {
		return ((StockPriceAdjustDO) super.getParentDO());
	}

	public void setParentDO(StockPriceAdjustDO headDO) {
		setParent(headDO);
	}

	public StockPriceAdjustItmDO[] getStockPriceAdjustItmDO() {
		IBaseDO[] dos = getChildren(StockPriceAdjustItmDO.class);
		if(dos==null) return null;
		StockPriceAdjustItmDO[] result=new StockPriceAdjustItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(StockPriceAdjustItmDO)dos[i];
		}
		return result;
	}
	
	public void setStockPriceAdjustItmDO(StockPriceAdjustItmDO[] dos) {
		setChildren(StockPriceAdjustItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		StockpriceadjustAggDODesc desc = new StockpriceadjustAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new StockPriceAdjustDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mm.st.stockpriceadjust.d.StockPriceAdjustItmDO")) {
             return new StockPriceAdjustItmDO();
         }
         return null;
     }
}