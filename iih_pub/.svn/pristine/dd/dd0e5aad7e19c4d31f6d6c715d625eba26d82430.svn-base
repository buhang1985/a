package iih.mm.st.stockin.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mm.st.stockin.d.desc.StockinAggDODesc;



/**
 * 入库单
 */
public class StockinAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public StockInDO getParentDO() {
		return ((StockInDO) super.getParentDO());
	}

	public void setParentDO(StockInDO headDO) {
		setParent(headDO);
	}

	public StockInItemDO[] getStockInItemDO() {
		IBaseDO[] dos = getChildren(StockInItemDO.class);
		if(dos==null) return null;
		StockInItemDO[] result=new StockInItemDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(StockInItemDO)dos[i];
		}
		return result;
	}
	
	public void setStockInItemDO(StockInItemDO[] dos) {
		setChildren(StockInItemDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		StockinAggDODesc desc = new StockinAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new StockInDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mm.st.stockin.d.StockInItemDO")) {
             return new StockInItemDO();
         }
         return null;
     }
}