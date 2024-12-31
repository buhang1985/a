package iih.bl.cg.blcgoep.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bl.cg.blcgoep.d.BlCgOepDO;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.desc.BlCgItmOepDODesc;

/**
 * 组件
 * @author
 *
 */
public class BlcgoepAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public BlcgoepAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(BlCgOepDO.class);
        addChildren(BlCgItmOepDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BlCgItmOepDODesc.class).getFKAttrDesc());        
	  }	  
}