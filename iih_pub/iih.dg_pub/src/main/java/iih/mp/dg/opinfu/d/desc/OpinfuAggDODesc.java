package iih.mp.dg.opinfu.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mp.dg.opinfu.d.OpInfuseDO;
import iih.mp.dg.opinfu.d.OpInfuseDtDO;
import iih.mp.dg.opinfu.d.desc.OpInfuseDtDODesc;

/**
 * 门诊输液
 * @author
 *
 */
public class OpinfuAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public OpinfuAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(OpInfuseDO.class);
        addChildren(OpInfuseDtDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(OpInfuseDtDODesc.class).getFKAttrDesc());        
	  }	  
}