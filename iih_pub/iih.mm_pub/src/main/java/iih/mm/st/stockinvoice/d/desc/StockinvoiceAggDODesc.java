package iih.mm.st.stockinvoice.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mm.st.stockinvoice.d.StockInvoiceDO;
import iih.mm.st.stockinvoice.d.StockInvItemDO;
import iih.mm.st.stockinvoice.d.desc.StockInvItemDODesc;

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
	    setParent(StockInvoiceDO.class);
        addChildren(StockInvItemDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(StockInvItemDODesc.class).getFKAttrDesc());        
	  }	  
}