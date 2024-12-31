package iih.hr.hsc.hscschedweek.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.hr.hsc.hscschedweek.d.HscSchedWeekDO;
import iih.hr.hsc.hscschedweek.d.HscSchedDO;
import iih.hr.hsc.hscschedweek.d.desc.HscSchedDODesc;

/**
 * 排班周信息
 * @author
 *
 */
public class HscschedweekAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public HscschedweekAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(HscSchedWeekDO.class);
        addChildren(HscSchedDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(HscSchedDODesc.class).getFKAttrDesc());        
	  }	  
}