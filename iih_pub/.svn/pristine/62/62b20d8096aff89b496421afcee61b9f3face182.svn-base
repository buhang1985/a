package iih.bl.prop.blproparoep.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bl.prop.blproparoep.d.BlPropArOepDO;
import iih.bl.prop.blproparoep.d.BlPropArItmOepDO;
import iih.bl.prop.blproparoep.d.desc.BlPropArItmOepDODesc;
import iih.bl.prop.blproparoep.d.BlPropArSegOepDO;
import iih.bl.prop.blproparoep.d.desc.BlPropArSegOepDODesc;

/**
 * 组件
 * @author
 *
 */
public class BlproparoepAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public BlproparoepAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(BlPropArOepDO.class);
        addChildren(BlPropArItmOepDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BlPropArItmOepDODesc.class).getFKAttrDesc());        
        addChildren(BlPropArSegOepDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BlPropArSegOepDODesc.class).getFKAttrDesc());        
	  }	  
}