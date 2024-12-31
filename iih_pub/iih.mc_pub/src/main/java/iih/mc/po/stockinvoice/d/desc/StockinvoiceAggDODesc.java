package iih.mc.po.stockinvoice.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mc.po.stockinvoice.d.McStockInvoiceDO;
import iih.mc.po.stockinvoice.d.McStockInvItemDO;
import iih.mc.po.stockinvoice.d.desc.McStockInvItemDODesc;

/**
 * 采购发票
 * @author
 *
 */
public class StockinvoiceAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public StockinvoiceAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(McStockInvoiceDO.class);
        addChildren(McStockInvItemDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(McStockInvItemDODesc.class).getFKAttrDesc());        
	  }	  
}