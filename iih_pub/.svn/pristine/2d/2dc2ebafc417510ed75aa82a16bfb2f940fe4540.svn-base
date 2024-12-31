package iih.mm.pl.traprequest.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mm.pl.traprequest.d.TrapReqOrderDO;
import iih.mm.pl.traprequest.d.TrapReqItemDO;
import iih.mm.pl.traprequest.d.desc.TrapReqItemDODesc;

/**
 * 调拨申请
 * @author
 *
 */
public class TraprequestAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public TraprequestAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(TrapReqOrderDO.class);
        addChildren(TrapReqItemDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(TrapReqItemDODesc.class).getFKAttrDesc());        
	  }	  
}