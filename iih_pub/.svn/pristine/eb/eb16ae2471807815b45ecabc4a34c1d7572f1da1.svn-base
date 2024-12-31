package iih.nm.nhr.nmoptplpsn.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nhr.nmoptplpsn.d.NmOptPlPsnDO;
import iih.nm.nhr.nmoptplpsn.d.NmOptPsnRecDO;
import iih.nm.nhr.nmoptplpsn.d.desc.NmOptPsnRecDODesc;

/**
 * 实习计划_参与人员
 * @author
 *
 */
public class NmoptplpsnAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NmoptplpsnAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NmOptPlPsnDO.class);
        addChildren(NmOptPsnRecDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NmOptPsnRecDODesc.class).getFKAttrDesc());        
	  }	  
}