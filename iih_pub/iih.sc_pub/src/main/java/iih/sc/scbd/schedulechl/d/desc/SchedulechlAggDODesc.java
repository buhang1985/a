package iih.sc.scbd.schedulechl.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.scbd.schedulechl.d.ScChlPeriodDO;
import iih.sc.scbd.schedulechl.d.desc.ScChlPeriodDODesc;

/**
 * 排班预约渠道
 * @author
 *
 */
public class SchedulechlAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public SchedulechlAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(SchedulechlDO.class);
        addChildren(ScChlPeriodDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(ScChlPeriodDODesc.class).getFKAttrDesc());        
	  }	  
}