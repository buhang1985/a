package iih.ci.mr.nu.dvtriskass.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.nu.dvtriskass.d.DvtriskassDO;
import iih.ci.mr.nu.dvtriskass.d.DvtriskasslistDO;
import iih.ci.mr.nu.dvtriskass.d.desc.DvtriskasslistDODesc;

/**
 * DVT风险评估单
 * @author
 *
 */
public class DvtriskassAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public DvtriskassAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(DvtriskassDO.class);
        addChildren(DvtriskasslistDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(DvtriskasslistDODesc.class).getFKAttrDesc());        
	  }	  
}