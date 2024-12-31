package iih.nm.nqm.nmnqmsuper.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nqm.nmnqmsuper.d.NmNqmSuperDO;
import iih.nm.nqm.nmnqmsuper.d.NmNqmSuperItmDO;
import iih.nm.nqm.nmnqmsuper.d.desc.NmNqmSuperItmDODesc;

/**
 * 护理管理_督导项
 * @author
 *
 */
public class NmnqmsuperAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NmnqmsuperAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NmNqmSuperDO.class);
        addChildren(NmNqmSuperItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NmNqmSuperItmDODesc.class).getFKAttrDesc());        
	  }	  
}