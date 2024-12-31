package iih.bd.bs.workcalendar.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.bs.workcalendar.d.WorkCalendarDO;
import iih.bd.bs.workcalendar.d.WorkCalendYearDO;
import iih.bd.bs.workcalendar.d.desc.WorkCalendYearDODesc;
import iih.bd.bs.workcalendar.d.WorkCalendDateDO;
import iih.bd.bs.workcalendar.d.desc.WorkCalendDateDODesc;

/**
 * 工作日历
 * @author
 *
 */
public class WorkcalendarAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public WorkcalendarAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(WorkCalendarDO.class);
        addChildren(WorkCalendYearDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(WorkCalendYearDODesc.class).getFKAttrDesc());        
        addChildren(WorkCalendDateDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(WorkCalendDateDODesc.class).getFKAttrDesc());        
	  }	  
}