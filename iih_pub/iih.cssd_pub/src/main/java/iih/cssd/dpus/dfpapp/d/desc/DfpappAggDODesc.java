package iih.cssd.dpus.dfpapp.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.cssd.dpus.dfpapp.d.DfpAppDO;
import iih.cssd.dpus.dfpapp.d.DfpAppItmDO;
import iih.cssd.dpus.dfpapp.d.desc.DfpAppItmDODesc;

/**
 * 请领消毒包
 * @author
 *
 */
public class DfpappAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public DfpappAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(DfpAppDO.class);
        addChildren(DfpAppItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(DfpAppItmDODesc.class).getFKAttrDesc());        
	  }	  
}