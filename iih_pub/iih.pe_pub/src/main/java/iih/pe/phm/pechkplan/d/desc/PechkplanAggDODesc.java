package iih.pe.phm.pechkplan.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.phm.pechkplan.d.PeChkPlanDO;
import iih.pe.phm.pechkplan.d.PeChkPlanItmDO;
import iih.pe.phm.pechkplan.d.desc.PeChkPlanItmDODesc;

/**
 * 健康体检计划
 * @author
 *
 */
public class PechkplanAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PechkplanAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeChkPlanDO.class);
        addChildren(PeChkPlanItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeChkPlanItmDODesc.class).getFKAttrDesc());        
	  }	  
}