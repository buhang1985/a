package iih.mm.pl.stockplan.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mm.pl.stockplan.d.desc.StockplanAggDODesc;



/**
 * 库存计划
 */
public class StockplanAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public StockPlanDO getParentDO() {
		return ((StockPlanDO) super.getParentDO());
	}

	public void setParentDO(StockPlanDO headDO) {
		setParent(headDO);
	}

	public StockPlanItmDO[] getStockPlanItmDO() {
		IBaseDO[] dos = getChildren(StockPlanItmDO.class);
		if(dos==null) return null;
		StockPlanItmDO[] result=new StockPlanItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(StockPlanItmDO)dos[i];
		}
		return result;
	}
	
	public void setStockPlanItmDO(StockPlanItmDO[] dos) {
		setChildren(StockPlanItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		StockplanAggDODesc desc = new StockplanAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new StockPlanDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mm.pl.stockplan.d.StockPlanItmDO")) {
             return new StockPlanItmDO();
         }
         return null;
     }
}