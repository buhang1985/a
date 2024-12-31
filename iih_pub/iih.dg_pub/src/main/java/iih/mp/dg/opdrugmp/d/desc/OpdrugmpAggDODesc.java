package iih.mp.dg.opdrugmp.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mp.dg.opdrugmp.d.OpDrugExeDO;
import iih.mp.dg.opdrugmp.d.OpDrugExeItemDO;
import iih.mp.dg.opdrugmp.d.desc.OpDrugExeItemDODesc;

/**
 * 门诊药品执行
 * @author
 *
 */
public class OpdrugmpAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public OpdrugmpAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(OpDrugExeDO.class);
        addChildren(OpDrugExeItemDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(OpDrugExeItemDODesc.class).getFKAttrDesc());        
	  }	  
}