package iih.ci.mr.nu.bgm.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.nu.bgm.d.BgmPatInfoDO;
import iih.ci.mr.nu.bgm.d.BgmRecDO;
import iih.ci.mr.nu.bgm.d.desc.BgmRecDODesc;

/**
 * 血糖监测表
 * @author
 *
 */
public class BgmAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public BgmAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(BgmPatInfoDO.class);
        addChildren(BgmRecDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BgmRecDODesc.class).getFKAttrDesc());        
	  }	  
}