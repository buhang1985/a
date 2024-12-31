package iih.mm.st.stockdaycheck.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mm.st.stockdaycheck.d.desc.StockdaycheckAggDODesc;



/**
 * 药房日点账
 */
public class StockdaycheckAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public StockDayCheckDO getParentDO() {
		return ((StockDayCheckDO) super.getParentDO());
	}

	public void setParentDO(StockDayCheckDO headDO) {
		setParent(headDO);
	}

	public StockDayCheckItmDO[] getStockDayCheckItmDO() {
		IBaseDO[] dos = getChildren(StockDayCheckItmDO.class);
		if(dos==null) return null;
		StockDayCheckItmDO[] result=new StockDayCheckItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(StockDayCheckItmDO)dos[i];
		}
		return result;
	}
	
	public void setStockDayCheckItmDO(StockDayCheckItmDO[] dos) {
		setChildren(StockDayCheckItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		StockdaycheckAggDODesc desc = new StockdaycheckAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new StockDayCheckDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mm.st.stockdaycheck.d.StockDayCheckItmDO")) {
             return new StockDayCheckItmDO();
         }
         return null;
     }
}