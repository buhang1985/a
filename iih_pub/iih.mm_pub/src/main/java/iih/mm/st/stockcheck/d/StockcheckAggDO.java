package iih.mm.st.stockcheck.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mm.st.stockcheck.d.desc.StockcheckAggDODesc;



/**
 * 库存盘点
 */
public class StockcheckAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public StockCheckDO getParentDO() {
		return ((StockCheckDO) super.getParentDO());
	}

	public void setParentDO(StockCheckDO headDO) {
		setParent(headDO);
	}

	public StockCheckItmDO[] getStockCheckItmDO() {
		IBaseDO[] dos = getChildren(StockCheckItmDO.class);
		if(dos==null) return null;
		StockCheckItmDO[] result=new StockCheckItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(StockCheckItmDO)dos[i];
		}
		return result;
	}
	
	public void setStockCheckItmDO(StockCheckItmDO[] dos) {
		setChildren(StockCheckItmDO.class, dos);
	}
	public StockCaspItemDO[] getStockCaspItemDO() {
		IBaseDO[] dos = getChildren(StockCaspItemDO.class);
		if(dos==null) return null;
		StockCaspItemDO[] result=new StockCaspItemDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(StockCaspItemDO)dos[i];
		}
		return result;
	}
	
	public void setStockCaspItemDO(StockCaspItemDO[] dos) {
		setChildren(StockCaspItemDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		StockcheckAggDODesc desc = new StockcheckAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new StockCheckDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mm.st.stockcheck.d.StockCheckItmDO")) {
             return new StockCheckItmDO();
         }
	    else if (clzName.equals("iih.mm.st.stockcheck.d.StockCaspItemDO")) {
             return new StockCaspItemDO();
         }
         return null;
     }
}