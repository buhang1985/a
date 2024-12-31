package iih.nm.nqm.nqmimprovl.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nqm.nqmimprovl.d.NqmImprovDO;
import iih.nm.nqm.nqmimprovl.d.NqmImprovKpiDO;
import iih.nm.nqm.nqmimprovl.d.desc.NqmImprovKpiDODesc;
import iih.nm.nqm.nqmimprovl.d.NqmImprovMendRecDO;
import iih.nm.nqm.nqmimprovl.d.desc.NqmImprovMendRecDODesc;

/**
 * 持续改进
 * @author
 *
 */
public class NqmimprovlAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NqmimprovlAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NqmImprovDO.class);
        addChildren(NqmImprovKpiDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NqmImprovKpiDODesc.class).getFKAttrDesc());        
        addChildren(NqmImprovMendRecDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NqmImprovMendRecDODesc.class).getFKAttrDesc());        
	  }	  
}