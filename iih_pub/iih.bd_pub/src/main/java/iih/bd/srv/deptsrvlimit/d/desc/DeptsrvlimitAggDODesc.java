package iih.bd.srv.deptsrvlimit.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.srv.deptsrvlimit.d.DeptSrvLimitDO;
import iih.bd.srv.deptsrvlimit.d.DeptSrvLimitItemDO;
import iih.bd.srv.deptsrvlimit.d.desc.DeptSrvLimitItemDODesc;

/**
 * 科室服务白黑名单
 * @author
 *
 */
public class DeptsrvlimitAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public DeptsrvlimitAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(DeptSrvLimitDO.class);
        addChildren(DeptSrvLimitItemDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(DeptSrvLimitItemDODesc.class).getFKAttrDesc());        
	  }	  
}