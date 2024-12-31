package iih.nm.nqm.nmnqmcs.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nqm.nmnqmcs.d.NmNqmCsDO;
import iih.nm.nqm.nmnqmcs.d.NmNqmCsExtDO;
import iih.nm.nqm.nmnqmcs.d.desc.NmNqmCsExtDODesc;

/**
 * 检查标准
 * @author
 *
 */
public class NmnqmcsAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NmnqmcsAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NmNqmCsDO.class);
        addChildren(NmNqmCsExtDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NmNqmCsExtDODesc.class).getFKAttrDesc());        
	  }	  
}