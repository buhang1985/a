package iih.mm.st.stockin.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mm.st.stockin.d.StockInDO;
import iih.mm.st.stockin.d.StockInItemDO;
import iih.mm.st.stockin.d.desc.StockInItemDODesc;

/**
 * 入库单
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
	    setParent(StockInDO.class);
        addChildren(StockInItemDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(StockInItemDODesc.class).getFKAttrDesc());        
	  }	  
}