package iih.nm.nqm.nmnqmkpi.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nqm.nmnqmkpi.d.NmNqmKpiDO;
import iih.nm.nqm.nmnqmkpi.d.NmNqmKpiItmDO;
import iih.nm.nqm.nmnqmkpi.d.desc.NmNqmKpiItmDODesc;

/**
 * 标准指标
 * @author
 *
 */
public class NmnqmkpiAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NmnqmkpiAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NmNqmKpiDO.class);
        addChildren(NmNqmKpiItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NmNqmKpiItmDODesc.class).getFKAttrDesc());        
	  }	  
}