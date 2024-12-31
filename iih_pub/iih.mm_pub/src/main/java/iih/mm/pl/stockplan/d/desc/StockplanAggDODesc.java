package iih.mm.pl.stockplan.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mm.pl.stockplan.d.StockPlanDO;
import iih.mm.pl.stockplan.d.StockPlanItmDO;
import iih.mm.pl.stockplan.d.desc.StockPlanItmDODesc;

/**
 * 库存计划
 * @author
 *
 */
public class StockplanAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public StockplanAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(StockPlanDO.class);
        addChildren(StockPlanItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(StockPlanItmDODesc.class).getFKAttrDesc());        
	  }	  
}