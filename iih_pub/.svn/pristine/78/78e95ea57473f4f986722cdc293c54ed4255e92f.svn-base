package iih.mc.st.stockout.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mc.st.stockout.d.McStockOutDO;
import iih.mc.st.stockout.d.McStockOutSumItemDO;
import iih.mc.st.stockout.d.desc.McStockOutSumItemDODesc;
import iih.mc.st.stockout.d.McStockOutItemDO;
import iih.mc.st.stockout.d.desc.McStockOutItemDODesc;

/**
 * 耗材出库
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
	    setParent(McStockOutDO.class);
        addChildren(McStockOutSumItemDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(McStockOutSumItemDODesc.class).getFKAttrDesc());        
        addChildren(McStockOutItemDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(McStockOutItemDODesc.class).getFKAttrDesc());        
	  }	  
}