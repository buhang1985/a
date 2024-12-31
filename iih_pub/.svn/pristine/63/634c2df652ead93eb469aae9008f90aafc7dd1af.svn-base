package iih.pe.pqn.peevalnutrition.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pqn.peevalnutrition.d.PeEvalNutritionDO;
import iih.pe.pqn.peevalnutrition.d.PeEvalNutritionClsDO;
import iih.pe.pqn.peevalnutrition.d.desc.PeEvalNutritionClsDODesc;

/**
 * 健康评估-营养评估定义
 * @author
 *
 */
public class PeevalnutritionAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PeevalnutritionAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeEvalNutritionDO.class);
        addChildren(PeEvalNutritionClsDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeEvalNutritionClsDODesc.class).getFKAttrDesc());        
	  }	  
}