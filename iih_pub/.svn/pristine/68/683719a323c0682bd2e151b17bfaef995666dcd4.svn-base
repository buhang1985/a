package iih.bl.hp.hptransactahip.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bl.hp.hptransactahip.d.HpTransActAhIpDO;
import iih.bl.hp.hptransactahip.d.HpTransActItmAhIpDO;
import iih.bl.hp.hptransactahip.d.desc.HpTransActItmAhIpDODesc;

/**
 * 安徽医保住院
 * @author
 *
 */
public class HptransactahipAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public HptransactahipAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(HpTransActAhIpDO.class);
        addChildren(HpTransActItmAhIpDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(HpTransActItmAhIpDODesc.class).getFKAttrDesc());        
	  }	  
}