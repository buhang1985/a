package iih.en.pv.inpatient.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.en.pv.inpatient.d.EnPeCmpyDO;
import iih.en.pv.inpatient.d.EnPeCmpyItmDO;
import iih.en.pv.inpatient.d.desc.EnPeCmpyItmDODesc;

/**
 * 团检记录
 * @author
 *
 */
public class EnpecmpyAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public EnpecmpyAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(EnPeCmpyDO.class);
        addChildren(EnPeCmpyItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(EnPeCmpyItmDODesc.class).getFKAttrDesc());        
	  }	  
}