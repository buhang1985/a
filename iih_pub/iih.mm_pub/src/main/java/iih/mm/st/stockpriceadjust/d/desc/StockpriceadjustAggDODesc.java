package iih.mm.st.stockpriceadjust.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mm.st.stockpriceadjust.d.StockPriceAdjustDO;
import iih.mm.st.stockpriceadjust.d.StockPriceAdjustItmDO;
import iih.mm.st.stockpriceadjust.d.desc.StockPriceAdjustItmDODesc;

/**
 * 库存调价
 * @author
 *
 */
public class StockpriceadjustAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public StockpriceadjustAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(StockPriceAdjustDO.class);
        addChildren(StockPriceAdjustItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(StockPriceAdjustItmDODesc.class).getFKAttrDesc());        
	  }	  
}