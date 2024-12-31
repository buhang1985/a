package iih.mm.st.stockdaycheck.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mm.st.stockdaycheck.d.StockDayCheckDO;
import iih.mm.st.stockdaycheck.d.StockDayCheckItmDO;
import iih.mm.st.stockdaycheck.d.desc.StockDayCheckItmDODesc;

/**
 * 药房日点账
 * @author
 *
 */
public class StockdaycheckAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public StockdaycheckAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(StockDayCheckDO.class);
        addChildren(StockDayCheckItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(StockDayCheckItmDODesc.class).getFKAttrDesc());        
	  }	  
}