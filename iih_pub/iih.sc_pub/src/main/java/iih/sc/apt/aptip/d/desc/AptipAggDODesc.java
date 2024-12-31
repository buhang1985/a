package iih.sc.apt.aptip.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.sc.apt.aptip.d.AptIpDO;
import iih.sc.apt.aptip.d.AptIpAttrDO;
import iih.sc.apt.aptip.d.desc.AptIpAttrDODesc;

/**
 * 住院预约
 * @author
 *
 */
public class AptipAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public AptipAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(AptIpDO.class);
        addChildren(AptIpAttrDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(AptIpAttrDODesc.class).getFKAttrDesc());        
	  }	  
}