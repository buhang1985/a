package iih.pe.phm.pehmriskrule.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.phm.pehmriskrule.d.PeHmRiskRuleDO;
import iih.pe.phm.pehmriskrule.d.PeHmRiskRuleItemDO;
import iih.pe.phm.pehmriskrule.d.desc.PeHmRiskRuleItemDODesc;

/**
 * 健康危险因素规则定义
 * @author
 *
 */
public class PehmriskruleAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PehmriskruleAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeHmRiskRuleDO.class);
        addChildren(PeHmRiskRuleItemDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeHmRiskRuleItemDODesc.class).getFKAttrDesc());        
	  }	  
}