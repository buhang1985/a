package iih.mc.pl.trrequestap.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mc.pl.trrequestap.d.McTrReqApOrderDO;
import iih.mc.pl.trrequestap.d.McTrReqApItemDO;
import iih.mc.pl.trrequestap.d.desc.McTrReqApItemDODesc;

/**
 * 调拨申请单
 * @author
 *
 */
public class TrrequestapAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public TrrequestapAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(McTrReqApOrderDO.class);
        addChildren(McTrReqApItemDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(McTrReqApItemDODesc.class).getFKAttrDesc());        
	  }	  
}