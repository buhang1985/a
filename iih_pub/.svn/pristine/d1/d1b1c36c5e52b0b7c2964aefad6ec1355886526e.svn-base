package iih.bd.pp.modifypriplan.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.pp.modifypriplan.d.ModifyPriPlanDO;
import iih.bd.pp.modifypriplan.d.ModifyPriPlanItmDO;
import iih.bd.pp.modifypriplan.d.desc.ModifyPriPlanItmDODesc;

/**
 * 调价计划
 * @author
 *
 */
public class ModifypriplanAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public ModifypriplanAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(ModifyPriPlanDO.class);
        addChildren(ModifyPriPlanItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(ModifyPriPlanItmDODesc.class).getFKAttrDesc());        
	  }	  
}