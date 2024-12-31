package iih.sc.scbd.screleaserule.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.sc.scbd.screleaserule.d.ScReleaseRuleDO;
import iih.sc.scbd.screleaserule.d.ScReleaseRuleItmDO;
import iih.sc.scbd.screleaserule.d.desc.ScReleaseRuleItmDODesc;

/**
 * 排班释放规则
 * @author
 *
 */
public class ScreleaseruleAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public ScreleaseruleAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(ScReleaseRuleDO.class);
        addChildren(ScReleaseRuleItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(ScReleaseRuleItmDODesc.class).getFKAttrDesc());        
	  }	  
}