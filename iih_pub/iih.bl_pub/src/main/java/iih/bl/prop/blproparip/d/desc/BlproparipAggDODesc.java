package iih.bl.prop.blproparip.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bl.prop.blproparip.d.BlPropArIpDO;
import iih.bl.prop.blproparip.d.BlPropArSegIpDO;
import iih.bl.prop.blproparip.d.desc.BlPropArSegIpDODesc;
import iih.bl.prop.blproparip.d.BlStarItmIpDO;
import iih.bl.prop.blproparip.d.desc.BlStarItmIpDODesc;

/**
 * 组件
 * @author
 *
 */
public class BlproparipAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public BlproparipAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(BlPropArIpDO.class);
        addChildren(BlPropArSegIpDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BlPropArSegIpDODesc.class).getFKAttrDesc());        
        addChildren(BlStarItmIpDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BlStarItmIpDODesc.class).getFKAttrDesc());        
	  }	  
}