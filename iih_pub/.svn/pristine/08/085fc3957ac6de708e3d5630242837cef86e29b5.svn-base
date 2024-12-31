package iih.bl.hp.hptransactah.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bl.hp.hptransactah.d.HpTransActAhDO;
import iih.bl.hp.hptransactah.d.HpTransActItmAhDO;
import iih.bl.hp.hptransactah.d.desc.HpTransActItmAhDODesc;

/**
 * 安徽医保交易记录
 * @author
 *
 */
public class HptransactahAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public HptransactahAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(HpTransActAhDO.class);
        addChildren(HpTransActItmAhDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(HpTransActItmAhDODesc.class).getFKAttrDesc());        
	  }	  
}