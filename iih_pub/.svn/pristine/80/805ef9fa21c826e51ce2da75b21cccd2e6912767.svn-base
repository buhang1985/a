package iih.bd.res.dayslot.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.res.dayslot.d.DaysLotDO;
import iih.bd.res.dayslot.d.DaysLotTimeDO;
import iih.bd.res.dayslot.d.desc.DaysLotTimeDODesc;
import iih.bd.res.dayslot.d.DayslotSecDO;
import iih.bd.res.dayslot.d.desc.DayslotSecDODesc;

/**
 * 日期分组
 * @author
 *
 */
public class DayslotAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public DayslotAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(DaysLotDO.class);
        addChildren(DaysLotTimeDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(DaysLotTimeDODesc.class).getFKAttrDesc());        
        addChildren(DayslotSecDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(DayslotSecDODesc.class).getFKAttrDesc());        
	  }	  
}