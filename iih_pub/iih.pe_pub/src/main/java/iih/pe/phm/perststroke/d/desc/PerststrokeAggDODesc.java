package iih.pe.phm.perststroke.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.phm.perststroke.d.PeRstStrokeDO;
import iih.pe.phm.perststroke.d.PeRstStrokeRiskDO;
import iih.pe.phm.perststroke.d.desc.PeRstStrokeRiskDODesc;

/**
 * 健康管理_脑卒中评估结果
 * @author
 *
 */
public class PerststrokeAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PerststrokeAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeRstStrokeDO.class);
        addChildren(PeRstStrokeRiskDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeRstStrokeRiskDODesc.class).getFKAttrDesc());        
	  }	  
}