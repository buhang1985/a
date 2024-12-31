package iih.mc.st.stockcheck.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mc.st.stockcheck.d.McStockCheckDO;
import iih.mc.st.stockcheck.d.McStockCheckItmDO;
import iih.mc.st.stockcheck.d.desc.McStockCheckItmDODesc;
import iih.mc.st.stockcheck.d.McStockCaspItemDO;
import iih.mc.st.stockcheck.d.desc.McStockCaspItemDODesc;

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
	    setParent(McStockCheckDO.class);
        addChildren(McStockCheckItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(McStockCheckItmDODesc.class).getFKAttrDesc());        
        addChildren(McStockCaspItemDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(McStockCaspItemDODesc.class).getFKAttrDesc());        
	  }	  
}