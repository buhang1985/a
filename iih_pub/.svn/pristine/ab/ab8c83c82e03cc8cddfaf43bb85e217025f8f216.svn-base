package iih.en.pv.enfee.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.en.pv.enfee.d.EnFixedFeeDO;
import iih.en.pv.enfee.d.EnFixedFeeItemDO;
import iih.en.pv.enfee.d.desc.EnFixedFeeItemDODesc;

/**
 * 患者就诊_固定费用
 * @author
 *
 */
public class EnfixedfeeAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public EnfixedfeeAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(EnFixedFeeDO.class);
        addChildren(EnFixedFeeItemDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(EnFixedFeeItemDODesc.class).getFKAttrDesc());        
	  }	  
}