package iih.nmr.nm.bch.evaluation.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nmr.nm.bch.evaluation.d.EvaluatDO;
import iih.nmr.nm.bch.evaluation.d.EvaluateItmDO;
import iih.nmr.nm.bch.evaluation.d.desc.EvaluateItmDODesc;

/**
 * 患者和家属健康教育计划表
 * @author
 *
 */
public class EvaluationAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public EvaluationAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(EvaluatDO.class);
        addChildren(EvaluateItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(EvaluateItmDODesc.class).getFKAttrDesc());        
	  }	  
}