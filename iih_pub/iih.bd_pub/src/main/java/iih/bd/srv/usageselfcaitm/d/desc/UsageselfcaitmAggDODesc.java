package iih.bd.srv.usageselfcaitm.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.srv.usageselfcaitm.d.UsageSelfCaItemDO;
import iih.bd.srv.usageselfcaitm.d.UsageSelfCaItmRelDO;
import iih.bd.srv.usageselfcaitm.d.desc.UsageSelfCaItmRelDODesc;

/**
 * 用法自定义分类项目
 * @author
 *
 */
public class UsageselfcaitmAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public UsageselfcaitmAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(UsageSelfCaItemDO.class);
        addChildren(UsageSelfCaItmRelDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(UsageSelfCaItmRelDODesc.class).getFKAttrDesc());        
	  }	  
}