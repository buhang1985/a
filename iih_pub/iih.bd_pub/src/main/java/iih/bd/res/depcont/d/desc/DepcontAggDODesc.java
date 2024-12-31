package iih.bd.res.depcont.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.res.depcont.d.DepContDO;
import iih.bd.res.depcont.d.DepContItmDO;
import iih.bd.res.depcont.d.desc.DepContItmDODesc;

/**
 * 医技科室对照
 * @author
 *
 */
public class DepcontAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public DepcontAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(DepContDO.class);
        addChildren(DepContItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(DepContItmDODesc.class).getFKAttrDesc());        
	  }	  
}