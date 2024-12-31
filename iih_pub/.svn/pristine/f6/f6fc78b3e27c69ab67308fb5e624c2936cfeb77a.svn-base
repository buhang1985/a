package iih.ci.mr.cimrvs.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.cimrvs.d.CiMrVsDO;
import iih.ci.mr.cimrvs.d.CiMrVsItmDO;
import iih.ci.mr.cimrvs.d.desc.CiMrVsItmDODesc;

/**
 * 临床生命体征测量
 * @author
 *
 */
public class CimrvsAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public CimrvsAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(CiMrVsDO.class);
        addChildren(CiMrVsItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CiMrVsItmDODesc.class).getFKAttrDesc());        
	  }	  
}