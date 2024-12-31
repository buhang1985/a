package iih.mm.po.purchase.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mm.po.purchase.d.PurchaseOrderDO;
import iih.mm.po.purchase.d.PurchseOrderItmDO;
import iih.mm.po.purchase.d.desc.PurchseOrderItmDODesc;

/**
 * 采购单
 * @author
 *
 */
public class PurchaseAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PurchaseAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PurchaseOrderDO.class);
        addChildren(PurchseOrderItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PurchseOrderItmDODesc.class).getFKAttrDesc());        
	  }	  
}