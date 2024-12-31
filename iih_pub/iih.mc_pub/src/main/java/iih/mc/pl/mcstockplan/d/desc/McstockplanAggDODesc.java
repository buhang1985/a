package iih.mc.pl.mcstockplan.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mc.pl.mcstockplan.d.McStockPlanDO;
import iih.mc.pl.mcstockplan.d.McStockPlanItmDO;
import iih.mc.pl.mcstockplan.d.desc.McStockPlanItmDODesc;

/**
 * 耗材库存计划
 * @author
 *
 */
public class McstockplanAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public McstockplanAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(McStockPlanDO.class);
        addChildren(McStockPlanItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(McStockPlanItmDODesc.class).getFKAttrDesc());        
	  }	  
}