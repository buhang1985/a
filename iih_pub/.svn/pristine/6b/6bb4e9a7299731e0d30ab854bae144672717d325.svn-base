package iih.mm.bl.blreserve.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mm.bl.blreserve.d.StockBlReserveDO;
import iih.mm.bl.blreserve.d.StockBlReserveItemDO;
import iih.mm.bl.blreserve.d.desc.StockBlReserveItemDODesc;

/**
 * 物品结存预留处理明细
 * @author
 *
 */
public class BlreserveAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public BlreserveAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(StockBlReserveDO.class);
        addChildren(StockBlReserveItemDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(StockBlReserveItemDODesc.class).getFKAttrDesc());        
	  }	  
}