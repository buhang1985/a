package iih.ems.einv.emda.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ems.einv.emda.d.EmsDaDO;
import iih.ems.einv.emda.d.EmsDaItmDO;
import iih.ems.einv.emda.d.desc.EmsDaItmDODesc;

/**
 * 设备领用申请
 * @author
 *
 */
public class EmdaAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public EmdaAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(EmsDaDO.class);
        addChildren(EmsDaItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(EmsDaItmDODesc.class).getFKAttrDesc());        
	  }	  
}