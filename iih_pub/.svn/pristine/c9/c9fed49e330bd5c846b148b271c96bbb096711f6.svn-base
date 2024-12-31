package iih.pe.pqn.peevallifestyle.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pqn.peevallifestyle.d.PeEvalLifestyleDO;
import iih.pe.pqn.peevallifestyle.d.PeEvalLifestyleItmDO;
import iih.pe.pqn.peevallifestyle.d.desc.PeEvalLifestyleItmDODesc;

/**
 * 健康生活方式评估定义
 * @author
 *
 */
public class PeevallifestyleAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PeevallifestyleAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeEvalLifestyleDO.class);
        addChildren(PeEvalLifestyleItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeEvalLifestyleItmDODesc.class).getFKAttrDesc());        
	  }	  
}