package iih.sc.scbd.schedulesrv.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvDO;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvRelDO;
import iih.sc.scbd.schedulesrv.d.desc.ScheduleSrvRelDODesc;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvChlDO;
import iih.sc.scbd.schedulesrv.d.desc.ScheduleSrvChlDODesc;

/**
 * 排班服务
 * @author
 *
 */
public class SchedulesrvAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public SchedulesrvAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(ScheduleSrvDO.class);
        addChildren(ScheduleSrvRelDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(ScheduleSrvRelDODesc.class).getFKAttrDesc());        
        addChildren(ScheduleSrvChlDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(ScheduleSrvChlDODesc.class).getFKAttrDesc());        
	  }	  
}