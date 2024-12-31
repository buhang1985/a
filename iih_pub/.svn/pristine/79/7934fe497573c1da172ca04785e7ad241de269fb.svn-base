package iih.mc.st.stockin.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mc.st.stockin.d.McStockInDO;
import iih.mc.st.stockin.d.McStockInSumItemDO;
import iih.mc.st.stockin.d.desc.McStockInSumItemDODesc;
import iih.mc.st.stockin.d.McStockInItemDO;
import iih.mc.st.stockin.d.desc.McStockInItemDODesc;

/**
 * 耗材入库单
 * @author
 *
 */
public class StockinAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public StockinAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(McStockInDO.class);
        addChildren(McStockInSumItemDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(McStockInSumItemDODesc.class).getFKAttrDesc());        
        addChildren(McStockInItemDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(McStockInItemDODesc.class).getFKAttrDesc());        
	  }	  
}