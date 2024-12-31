package iih.pe.phm.pedietplan.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.phm.pedietplan.d.PeDietPlanDO;
import iih.pe.phm.pedietplan.d.PeDietDivideDO;
import iih.pe.phm.pedietplan.d.desc.PeDietDivideDODesc;
import iih.pe.phm.pedietplan.d.PeDietPlanDayDO;
import iih.pe.phm.pedietplan.d.desc.PeDietPlanDayDODesc;
import iih.pe.phm.pedietplan.d.PeDietRecipeDO;
import iih.pe.phm.pedietplan.d.desc.PeDietRecipeDODesc;

/**
 * 体检饮食计划
 * @author
 *
 */
public class PedietplanAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PedietplanAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeDietPlanDO.class);
        addChildren(PeDietDivideDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeDietDivideDODesc.class).getFKAttrDesc());        
        addChildren(PeDietPlanDayDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeDietPlanDayDODesc.class).getFKAttrDesc());        
        addChildren(PeDietRecipeDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeDietRecipeDODesc.class).getFKAttrDesc());        
	  }	  
}