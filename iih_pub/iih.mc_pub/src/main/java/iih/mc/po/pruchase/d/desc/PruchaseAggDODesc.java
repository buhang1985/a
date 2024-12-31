package iih.mc.po.pruchase.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mc.po.pruchase.d.McPurchaseOrderDO;
import iih.mc.po.pruchase.d.McPurchseOrderItmDO;
import iih.mc.po.pruchase.d.desc.McPurchseOrderItmDODesc;

/**
 * 采购订单
 * @author
 *
 */
public class PruchaseAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PruchaseAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(McPurchaseOrderDO.class);
        addChildren(McPurchseOrderItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(McPurchseOrderItmDODesc.class).getFKAttrDesc());        
	  }	  
}