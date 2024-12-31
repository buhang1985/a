package iih.ci.mr.nu.hemodialycare.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.nu.hemodialycare.d.HemodialycareinfoDO;
import iih.ci.mr.nu.hemodialycare.d.HemodialycareitmDO;
import iih.ci.mr.nu.hemodialycare.d.desc.HemodialycareitmDODesc;

/**
 * 血液透析护理记录单
 * @author
 *
 */
public class HemodialycaredoAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public HemodialycaredoAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(HemodialycareinfoDO.class);
        addChildren(HemodialycareitmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(HemodialycareitmDODesc.class).getFKAttrDesc());        
	  }	  
}