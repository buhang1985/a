package iih.mp.nr.crisisval.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mp.nr.crisisval.d.CrisisValDO;
import iih.mp.nr.crisisval.d.CrisisValLisDO;
import iih.mp.nr.crisisval.d.desc.CrisisValLisDODesc;
import iih.mp.nr.crisisval.d.CrisisValObsDO;
import iih.mp.nr.crisisval.d.desc.CrisisValObsDODesc;

/**
 * 危急值
 * @author
 *
 */
public class CrisisvalAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public CrisisvalAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(CrisisValDO.class);
        addChildren(CrisisValLisDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CrisisValLisDODesc.class).getFKAttrDesc());        
        addChildren(CrisisValObsDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CrisisValObsDODesc.class).getFKAttrDesc());        
	  }	  
}