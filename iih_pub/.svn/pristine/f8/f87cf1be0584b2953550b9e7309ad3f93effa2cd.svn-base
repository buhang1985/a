package iih.ci.mr.nu.babycare.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.nu.babycare.d.BabyInfoDO;
import iih.ci.mr.nu.babycare.d.BabyNurRecDO;
import iih.ci.mr.nu.babycare.d.desc.BabyNurRecDODesc;

/**
 * 新生儿护理记录单
 * @author
 *
 */
public class BabycareAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public BabycareAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(BabyInfoDO.class);
        addChildren(BabyNurRecDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BabyNurRecDODesc.class).getFKAttrDesc());        
	  }	  
}