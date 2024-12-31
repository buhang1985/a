package iih.bl.inc.blincip.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bl.inc.blincip.d.BlIncIpDO;
import iih.bl.inc.blincip.d.BlStIncIpDO;
import iih.bl.inc.blincip.d.desc.BlStIncIpDODesc;
import iih.bl.inc.blincip.d.BlIncItmIpDO;
import iih.bl.inc.blincip.d.desc.BlIncItmIpDODesc;

/**
 * 住院发票
 * @author
 *
 */
public class BlincipAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public BlincipAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(BlIncIpDO.class);
        addChildren(BlStIncIpDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BlStIncIpDODesc.class).getFKAttrDesc());        
        addChildren(BlIncItmIpDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BlIncItmIpDODesc.class).getFKAttrDesc());        
	  }	  
}