package iih.bl.inc.blcpnin.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bl.inc.blcpnin.d.BlCpnInDO;
import iih.bl.inc.blcpnin.d.BlCpnDO;
import iih.bl.inc.blcpnin.d.desc.BlCpnDODesc;

/**
 * 组件
 * @author
 *
 */
public class BlcpninAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public BlcpninAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(BlCpnInDO.class);
        addChildren(BlCpnDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BlCpnDODesc.class).getFKAttrDesc());        
	  }	  
}