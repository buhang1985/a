package iih.mc.st.stockout.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mc.st.stockout.d.desc.StockoutAggDODesc;



/**
 * 耗材出库
 */
public class StockoutAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public McStockOutDO getParentDO() {
		return ((McStockOutDO) super.getParentDO());
	}

	public void setParentDO(McStockOutDO headDO) {
		setParent(headDO);
	}

	public McStockOutSumItemDO[] getMcStockOutSumItemDO() {
		IBaseDO[] dos = getChildren(McStockOutSumItemDO.class);
		if(dos==null) return null;
		McStockOutSumItemDO[] result=new McStockOutSumItemDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(McStockOutSumItemDO)dos[i];
		}
		return result;
	}
	
	public void setMcStockOutSumItemDO(McStockOutSumItemDO[] dos) {
		setChildren(McStockOutSumItemDO.class, dos);
	}
	public McStockOutItemDO[] getMcStockOutItemDO() {
		IBaseDO[] dos = getChildren(McStockOutItemDO.class);
		if(dos==null) return null;
		McStockOutItemDO[] result=new McStockOutItemDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(McStockOutItemDO)dos[i];
		}
		return result;
	}
	
	public void setMcStockOutItemDO(McStockOutItemDO[] dos) {
		setChildren(McStockOutItemDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		StockoutAggDODesc desc = new StockoutAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new McStockOutDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mc.st.stockout.d.McStockOutSumItemDO")) {
             return new McStockOutSumItemDO();
         }
	    else if (clzName.equals("iih.mc.st.stockout.d.McStockOutItemDO")) {
             return new McStockOutItemDO();
         }
         return null;
     }
}