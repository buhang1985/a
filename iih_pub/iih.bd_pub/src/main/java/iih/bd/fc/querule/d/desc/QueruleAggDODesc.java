package iih.bd.fc.querule.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.fc.querule.d.QueRuleDO;
import iih.bd.fc.querule.d.QueRuleItmDO;
import iih.bd.fc.querule.d.desc.QueRuleItmDODesc;

/**
 * 队列规则
 * @author
 *
 */
public class QueruleAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public QueruleAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(QueRuleDO.class);
        addChildren(QueRuleItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(QueRuleItmDODesc.class).getFKAttrDesc());        
	  }	  
}