package iih.nm.nqm.nqmimprovkpi.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nqm.nqmimprovkpi.d.NqmImprovKpiDO;
import iih.nm.nqm.nqmimprovkpi.d.NqmImprovKpiItmDO;
import iih.nm.nqm.nqmimprovkpi.d.desc.NqmImprovKpiItmDODesc;

/**
 * 护理管理_持续改进项目
 * @author
 *
 */
public class NqmimprovkpiAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NqmimprovkpiAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NqmImprovKpiDO.class);
        addChildren(NqmImprovKpiItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NqmImprovKpiItmDODesc.class).getFKAttrDesc());        
	  }	  
}