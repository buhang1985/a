package iih.pe.pqn.peevalmeal.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pqn.peevalmeal.d.PeEvalMealDO;
import iih.pe.pqn.peevalmeal.d.PeEvalMealQaDO;
import iih.pe.pqn.peevalmeal.d.desc.PeEvalMealQaDODesc;

/**
 * 体检饮食评估定义
 * @author
 *
 */
public class PeevalmealAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PeevalmealAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeEvalMealDO.class);
        addChildren(PeEvalMealQaDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeEvalMealQaDODesc.class).getFKAttrDesc());        
	  }	  
}