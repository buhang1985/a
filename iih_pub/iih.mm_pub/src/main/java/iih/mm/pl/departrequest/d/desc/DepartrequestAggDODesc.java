package iih.mm.pl.departrequest.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mm.pl.departrequest.d.DepartReqOrderDO;
import iih.mm.pl.departrequest.d.DepartReqItemDO;
import iih.mm.pl.departrequest.d.desc.DepartReqItemDODesc;

/**
 * 部门领用申请
 * @author
 *
 */
public class DepartrequestAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public DepartrequestAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(DepartReqOrderDO.class);
        addChildren(DepartReqItemDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(DepartReqItemDODesc.class).getFKAttrDesc());        
	  }	  
}