package iih.mm.mc.stockperinit.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mm.mc.stockperinit.d.StockPerInitDO;
import iih.mm.mc.stockperinit.d.StockPerInitItemDO;
import iih.mm.mc.stockperinit.d.desc.StockPerInitItemDODesc;

/**
 * 库存期初
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
	    setParent(StockPerInitDO.class);
        addChildren(StockPerInitItemDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(StockPerInitItemDODesc.class).getFKAttrDesc());        
	  }	  
}