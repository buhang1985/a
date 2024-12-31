package iih.pe.phm.penutrition.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.phm.penutrition.d.PeNutritionDO;
import iih.pe.phm.penutrition.d.PeNutritionDtlDO;
import iih.pe.phm.penutrition.d.desc.PeNutritionDtlDODesc;

/**
 * 健康营养评估结果
 * @author
 *
 */
public class PenutritionAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PenutritionAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeNutritionDO.class);
        addChildren(PeNutritionDtlDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeNutritionDtlDODesc.class).getFKAttrDesc());        
	  }	  
}