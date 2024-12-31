package iih.mm.st.stockcheck.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mm.st.stockcheck.d.StockCheckDO;
import iih.mm.st.stockcheck.d.StockCheckItmDO;
import iih.mm.st.stockcheck.d.desc.StockCheckItmDODesc;
import iih.mm.st.stockcheck.d.StockCaspItemDO;
import iih.mm.st.stockcheck.d.desc.StockCaspItemDODesc;

/**
 * 库存盘点
 * @author
 *
 */
public class StockcheckAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public StockcheckAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(StockCheckDO.class);
        addChildren(StockCheckItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(StockCheckItmDODesc.class).getFKAttrDesc());        
        addChildren(StockCaspItemDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(StockCaspItemDODesc.class).getFKAttrDesc());        
	  }	  
}