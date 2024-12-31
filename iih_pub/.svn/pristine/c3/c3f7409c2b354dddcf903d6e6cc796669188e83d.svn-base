package iih.ci.mr.nu.childhealthedu.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.nu.childhealthedu.d.ChildHealthEduDO;
import iih.ci.mr.nu.childhealthedu.d.ChildHealthEduItmDO;
import iih.ci.mr.nu.childhealthedu.d.desc.ChildHealthEduItmDODesc;

/**
 * 儿科住院健康教育评价单
 * @author
 *
 */
public class ChildhealtheduAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public ChildhealtheduAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(ChildHealthEduDO.class);
        addChildren(ChildHealthEduItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(ChildHealthEduItmDODesc.class).getFKAttrDesc());        
	  }	  
}