package iih.pe.por.pepsnpot.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.por.pepsnpot.d.PePsnPotDO;
import iih.pe.por.pepsnpot.d.PePsnPotFollowDO;
import iih.pe.por.pepsnpot.d.desc.PePsnPotFollowDODesc;

/**
 * 体检潜在客户
 * @author
 *
 */
public class PepsnpotAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PepsnpotAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PePsnPotDO.class);
        addChildren(PePsnPotFollowDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PePsnPotFollowDODesc.class).getFKAttrDesc());        
	  }	  
}