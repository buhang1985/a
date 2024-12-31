package iih.en.pv.shiftturnover.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.en.pv.shiftturnover.d.ShiftTurnOverDO;
import iih.en.pv.shiftturnover.d.ShiftTurnOverItemDO;
import iih.en.pv.shiftturnover.d.desc.ShiftTurnOverItemDODesc;

/**
 * 医生交接班
 * @author
 *
 */
public class ShiftturnoverAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public ShiftturnoverAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(ShiftTurnOverDO.class);
        addChildren(ShiftTurnOverItemDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(ShiftTurnOverItemDODesc.class).getFKAttrDesc());        
	  }	  
}