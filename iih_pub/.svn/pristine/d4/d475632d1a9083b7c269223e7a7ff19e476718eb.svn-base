package iih.bd.srv.mrtaskrule.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.srv.mrtaskrule.d.MrTaskRuleDO;
import iih.bd.srv.mrtaskrule.d.MrTaskRuleSupportDO;
import iih.bd.srv.mrtaskrule.d.desc.MrTaskRuleSupportDODesc;
import iih.bd.srv.mrtaskrule.d.MrTaskRuleExcludeDO;
import iih.bd.srv.mrtaskrule.d.desc.MrTaskRuleExcludeDODesc;

/**
 * 病历书写任务配置
 * @author
 *
 */
public class MrtaskruleAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public MrtaskruleAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(MrTaskRuleDO.class);
        addChildren(MrTaskRuleSupportDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MrTaskRuleSupportDODesc.class).getFKAttrDesc());        
        addChildren(MrTaskRuleExcludeDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MrTaskRuleExcludeDODesc.class).getFKAttrDesc());        
	  }	  
}