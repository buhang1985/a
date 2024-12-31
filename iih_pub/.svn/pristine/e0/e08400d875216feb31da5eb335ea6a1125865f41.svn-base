package iih.ems.einv.emout.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ems.einv.emout.d.EmsOutDO;
import iih.ems.einv.emout.d.EmsOutItmDO;
import iih.ems.einv.emout.d.desc.EmsOutItmDODesc;

/**
 * 设备出库
 * @author
 *
 */
public class EmoutAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public EmoutAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(EmsOutDO.class);
        addChildren(EmsOutItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(EmsOutItmDODesc.class).getFKAttrDesc());        
	  }	  
}