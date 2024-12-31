package iih.pe.phm.peeduplan.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.phm.peeduplan.d.PeEduPlanDO;
import iih.pe.phm.peeduplan.d.PeEduPlanDtlDO;
import iih.pe.phm.peeduplan.d.desc.PeEduPlanDtlDODesc;

/**
 * 健康群体教育计划
 * @author
 *
 */
public class PeeduplanAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PeeduplanAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeEduPlanDO.class);
        addChildren(PeEduPlanDtlDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeEduPlanDtlDODesc.class).getFKAttrDesc());        
	  }	  
}