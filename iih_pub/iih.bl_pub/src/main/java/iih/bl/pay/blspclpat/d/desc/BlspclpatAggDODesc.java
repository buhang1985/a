package iih.bl.pay.blspclpat.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bl.pay.blspclpat.d.BlSpclPatDO;
import iih.bl.pay.blspclpat.d.BlSpclItmPatDO;
import iih.bl.pay.blspclpat.d.desc.BlSpclItmPatDODesc;

/**
 * 患者专用款
 * @author
 *
 */
public class BlspclpatAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public BlspclpatAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(BlSpclPatDO.class);
        addChildren(BlSpclItmPatDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BlSpclItmPatDODesc.class).getFKAttrDesc());        
	  }	  
}