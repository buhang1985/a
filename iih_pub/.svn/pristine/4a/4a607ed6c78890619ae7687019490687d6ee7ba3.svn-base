package iih.mm.qy.stockdealtypeconfig.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mm.qy.stockdealtypeconfig.d.StockDealTypeConfigDO;
import iih.mm.qy.stockdealtypeconfig.d.StockDealTypeConfigItmDO;
import iih.mm.qy.stockdealtypeconfig.d.desc.StockDealTypeConfigItmDODesc;

/**
 * 库存交易分类方案配置
 * @author
 *
 */
public class StockdealtypeconfigAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public StockdealtypeconfigAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(StockDealTypeConfigDO.class);
        addChildren(StockDealTypeConfigItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(StockDealTypeConfigItmDODesc.class).getFKAttrDesc());        
	  }	  
}