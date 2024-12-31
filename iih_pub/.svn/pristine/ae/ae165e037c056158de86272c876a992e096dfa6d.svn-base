package iih.ems.einv.emin.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ems.einv.emin.d.EmsInDO;
import iih.ems.einv.emin.d.EmsInItmDO;
import iih.ems.einv.emin.d.desc.EmsInItmDODesc;

/**
 * 设备入库
 * @author
 *
 */
public class EminAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public EminAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(EmsInDO.class);
        addChildren(EmsInItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(EmsInItmDODesc.class).getFKAttrDesc());        
	  }	  
}