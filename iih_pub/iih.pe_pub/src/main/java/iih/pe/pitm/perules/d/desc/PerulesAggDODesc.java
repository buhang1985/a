package iih.pe.pitm.perules.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pitm.perules.d.PeRuleDefDO;
import iih.pe.pitm.perules.d.PeRuleItemDO;
import iih.pe.pitm.perules.d.desc.PeRuleItemDODesc;
import iih.pe.pitm.perules.d.PeRuleDtlDO;
import iih.pe.pitm.perules.d.desc.PeRuleDtlDODesc;
import iih.pe.pitm.perules.d.PeRuleDiagDO;
import iih.pe.pitm.perules.d.desc.PeRuleDiagDODesc;
import iih.pe.pitm.perules.d.PeRuleExclusiveDO;
import iih.pe.pitm.perules.d.desc.PeRuleExclusiveDODesc;

/**
 * 异常结果判定规则
 * @author
 *
 */
public class PerulesAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PerulesAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeRuleDefDO.class);
        addChildren(PeRuleItemDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeRuleItemDODesc.class).getFKAttrDesc());        
        addChildren(PeRuleDtlDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeRuleDtlDODesc.class).getFKAttrDesc());        
        addChildren(PeRuleDiagDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeRuleDiagDODesc.class).getFKAttrDesc());        
        addChildren(PeRuleExclusiveDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeRuleExclusiveDODesc.class).getFKAttrDesc());        
	  }	  
}