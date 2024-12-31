package iih.bl.pay.blpayspcl.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bl.pay.blpayspcl.d.BlPaySpclDO;
import iih.bl.pay.blpayspcl.d.BlPayItmSpclDO;
import iih.bl.pay.blpayspcl.d.desc.BlPayItmSpclDODesc;

/**
 * 收付款_专用款
 * @author
 *
 */
public class BlpayspclAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public BlpayspclAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(BlPaySpclDO.class);
        addChildren(BlPayItmSpclDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BlPayItmSpclDODesc.class).getFKAttrDesc());        
	  }	  
}