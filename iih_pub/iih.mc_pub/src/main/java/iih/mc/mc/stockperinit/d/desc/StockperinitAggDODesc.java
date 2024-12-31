package iih.mc.mc.stockperinit.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mc.mc.stockperinit.d.McStockPerInitDO;
import iih.mc.mc.stockperinit.d.McStockPerInitItemDO;
import iih.mc.mc.stockperinit.d.desc.McStockPerInitItemDODesc;

/**
 * 耗材库存期初
 * @author
 *
 */
public class StockperinitAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public StockperinitAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(McStockPerInitDO.class);
        addChildren(McStockPerInitItemDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(McStockPerInitItemDODesc.class).getFKAttrDesc());        
	  }	  
}