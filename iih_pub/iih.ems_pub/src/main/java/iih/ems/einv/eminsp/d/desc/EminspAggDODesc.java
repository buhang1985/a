package iih.ems.einv.eminsp.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ems.einv.eminsp.d.EmsInspDO;
import iih.ems.einv.eminsp.d.EmsInspItmDO;
import iih.ems.einv.eminsp.d.desc.EmsInspItmDODesc;

/**
 * 大型设备验收
 * @author
 *
 */
public class EminspAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public EminspAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(EmsInspDO.class);
        addChildren(EmsInspItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(EmsInspItmDODesc.class).getFKAttrDesc());        
	  }	  
}