package iih.sc.apt.scaptappl.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.sc.apt.scaptappl.d.ScAptApplDO;
import iih.sc.apt.scaptappl.d.ScAptApplOptDO;
import iih.sc.apt.scaptappl.d.desc.ScAptApplOptDODesc;
import iih.sc.apt.scaptappl.d.ScAptApplItmDO;
import iih.sc.apt.scaptappl.d.desc.ScAptApplItmDODesc;

/**
 * 计划排班_预约_申请
 * @author
 *
 */
public class ScaptapplAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public ScaptapplAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(ScAptApplDO.class);
        addChildren(ScAptApplOptDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(ScAptApplOptDODesc.class).getFKAttrDesc());        
        addChildren(ScAptApplItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(ScAptApplItmDODesc.class).getFKAttrDesc());        
	  }	  
}