package iih.cssd.dpp.stz.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.cssd.dpp.stz.d.CssddfpstzDO;
import iih.cssd.dpp.stz.d.CssdDfpStzItmDO;
import iih.cssd.dpp.stz.d.desc.CssdDfpStzItmDODesc;

/**
 * 包灭菌
 * @author
 *
 */
public class StzAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public StzAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(CssddfpstzDO.class);
        addChildren(CssdDfpStzItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CssdDfpStzItmDODesc.class).getFKAttrDesc());        
	  }	  
}