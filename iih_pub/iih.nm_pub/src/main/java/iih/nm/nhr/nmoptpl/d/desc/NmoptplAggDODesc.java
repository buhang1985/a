package iih.nm.nhr.nmoptpl.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nhr.nmoptpl.d.NmOptPlDO;
import iih.nm.nhr.nmoptpl.d.NmOptPlDepDO;
import iih.nm.nhr.nmoptpl.d.desc.NmOptPlDepDODesc;

/**
 * 实习计划
 * @author
 *
 */
public class NmoptplAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NmoptplAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NmOptPlDO.class);
        addChildren(NmOptPlDepDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NmOptPlDepDODesc.class).getFKAttrDesc());        
	  }	  
}