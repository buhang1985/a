package iih.bl.inc.blincoep.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.inc.blincoep.d.BlStIncOepDO;
import iih.bl.inc.blincoep.d.desc.BlStIncOepDODesc;
import iih.bl.inc.blincoep.d.BlIncCgItmOep;
import iih.bl.inc.blincoep.d.desc.BlIncCgItmOepDesc;
import iih.bl.inc.blincoep.d.BlIncItmOepDO;
import iih.bl.inc.blincoep.d.desc.BlIncItmOepDODesc;

/**
 * 组件
 * @author
 *
 */
public class BlincoepAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public BlincoepAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(BlIncOepDO.class);
        addChildren(BlStIncOepDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BlStIncOepDODesc.class).getFKAttrDesc());        
        addChildren(BlIncCgItmOep.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BlIncCgItmOepDesc.class).getFKAttrDesc());        
        addChildren(BlIncItmOepDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BlIncItmOepDODesc.class).getFKAttrDesc());        
	  }	  
}