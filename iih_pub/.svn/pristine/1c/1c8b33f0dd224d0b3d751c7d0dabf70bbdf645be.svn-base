package iih.nm.nhr.nhrschedweek.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nhr.nhrschedweek.d.NhrSchedWeekDO;
import iih.nm.nhr.nhrschedweek.d.NhrSchedDO;
import iih.nm.nhr.nhrschedweek.d.desc.NhrSchedDODesc;

/**
 * 排班周信息
 * @author
 *
 */
public class NhrschedweekAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NhrschedweekAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NhrSchedWeekDO.class);
        addChildren(NhrSchedDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NhrSchedDODesc.class).getFKAttrDesc());        
	  }	  
}