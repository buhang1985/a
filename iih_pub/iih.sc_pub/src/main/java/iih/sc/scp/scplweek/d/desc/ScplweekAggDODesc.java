package iih.sc.scp.scplweek.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.sc.scp.scplweek.d.ScPlanWeekDO;
import iih.sc.scp.scplweek.d.ScPlanWeekChlDO;
import iih.sc.scp.scplweek.d.desc.ScPlanWeekChlDODesc;
import iih.sc.scp.scplweek.d.ScPlanWeekEmpDO;
import iih.sc.scp.scplweek.d.desc.ScPlanWeekEmpDODesc;
import iih.sc.scp.scplweek.d.ScPlanWeekEnDO;
import iih.sc.scp.scplweek.d.desc.ScPlanWeekEnDODesc;

/**
 * 计划排班_计划_周
 * @author
 *
 */
public class ScplweekAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public ScplweekAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(ScPlanWeekDO.class);
        addChildren(ScPlanWeekChlDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(ScPlanWeekChlDODesc.class).getFKAttrDesc());        
        addChildren(ScPlanWeekEmpDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(ScPlanWeekEmpDODesc.class).getFKAttrDesc());        
        addChildren(ScPlanWeekEnDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(ScPlanWeekEnDODesc.class).getFKAttrDesc());        
	  }	  
}