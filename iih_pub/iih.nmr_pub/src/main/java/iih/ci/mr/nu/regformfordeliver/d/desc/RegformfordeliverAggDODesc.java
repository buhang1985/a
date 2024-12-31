package iih.ci.mr.nu.regformfordeliver.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.nu.regformfordeliver.d.RegformDO;
import iih.ci.mr.nu.regformfordeliver.d.RegmaterDO;
import iih.ci.mr.nu.regformfordeliver.d.desc.RegmaterDODesc;

/**
 * 分娩登记表
 * @author
 *
 */
public class RegformfordeliverAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public RegformfordeliverAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(RegformDO.class);
        addChildren(RegmaterDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(RegmaterDODesc.class).getFKAttrDesc());        
	  }	  
}