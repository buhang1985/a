package iih.mm.st.stockout.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mm.st.stockout.d.StockOutDO;
import iih.mm.st.stockout.d.StockOutItemDO;
import iih.mm.st.stockout.d.desc.StockOutItemDODesc;

/**
 * 出库单
 * @author
 *
 */
public class StockoutAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public StockoutAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(StockOutDO.class);
        addChildren(StockOutItemDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(StockOutItemDODesc.class).getFKAttrDesc());        
	  }	  
}