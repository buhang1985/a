package iih.bl.st.blpaypatip.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bl.st.blpaypatip.d.BlPayPatIpDO;
import iih.bl.st.blpaypatip.d.BlPayItmPatIpDO;
import iih.bl.st.blpaypatip.d.desc.BlPayItmPatIpDODesc;

/**
 * 住院患者结算收付款
 * @author
 *
 */
public class BlpaypatipAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public BlpaypatipAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(BlPayPatIpDO.class);
        addChildren(BlPayItmPatIpDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BlPayItmPatIpDODesc.class).getFKAttrDesc());        
	  }	  
}