package iih.mm.st.settlement.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mm.st.settlement.d.SettlementDO;
import iih.mm.st.settlement.d.SettlementItmDO;
import iih.mm.st.settlement.d.desc.SettlementItmDODesc;

/**
 * 采购结算
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
	    setParent(SettlementDO.class);
        addChildren(SettlementItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(SettlementItmDODesc.class).getFKAttrDesc());        
	  }	  
}