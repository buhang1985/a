package iih.mm.qy.stockdealtypeconfig.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mm.qy.stockdealtypeconfig.d.desc.StockdealtypeconfigAggDODesc;



/**
 * 库存交易分类方案配置
 */
public class StockdealtypeconfigAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public StockDealTypeConfigDO getParentDO() {
		return ((StockDealTypeConfigDO) super.getParentDO());
	}

	public void setParentDO(StockDealTypeConfigDO headDO) {
		setParent(headDO);
	}

	public StockDealTypeConfigItmDO[] getStockDealTypeConfigItmDO() {
		IBaseDO[] dos = getChildren(StockDealTypeConfigItmDO.class);
		if(dos==null) return null;
		StockDealTypeConfigItmDO[] result=new StockDealTypeConfigItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(StockDealTypeConfigItmDO)dos[i];
		}
		return result;
	}
	
	public void setStockDealTypeConfigItmDO(StockDealTypeConfigItmDO[] dos) {
		setChildren(StockDealTypeConfigItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		StockdealtypeconfigAggDODesc desc = new StockdealtypeconfigAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new StockDealTypeConfigDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mm.qy.stockdealtypeconfig.d.StockDealTypeConfigItmDO")) {
             return new StockDealTypeConfigItmDO();
         }
         return null;
     }
}