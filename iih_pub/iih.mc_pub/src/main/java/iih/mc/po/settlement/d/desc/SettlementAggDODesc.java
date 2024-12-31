package iih.mc.po.settlement.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mc.po.settlement.d.McSettlementDO;
import iih.mc.po.settlement.d.McSettlementItmDO;
import iih.mc.po.settlement.d.desc.McSettlementItmDODesc;

/**
 * 采购发票结算
 * @author
 *
 */
public class SettlementAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public SettlementAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(McSettlementDO.class);
        addChildren(McSettlementItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(McSettlementItmDODesc.class).getFKAttrDesc());        
	  }	  
}