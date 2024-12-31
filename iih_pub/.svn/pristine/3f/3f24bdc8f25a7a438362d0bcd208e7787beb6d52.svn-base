package iih.pe.pbd.pewfroute.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pbd.pewfroute.d.PeWfRouteDO;
import iih.pe.pbd.pewfroute.d.PeChkRouteDO;
import iih.pe.pbd.pewfroute.d.desc.PeChkRouteDODesc;
import iih.pe.pbd.pewfroute.d.PeChkRouteCondDO;
import iih.pe.pbd.pewfroute.d.desc.PeChkRouteCondDODesc;

/**
 * 体检流程路线定义
 * @author
 *
 */
public class PewfrouteAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PewfrouteAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeWfRouteDO.class);
        addChildren(PeChkRouteDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeChkRouteDODesc.class).getFKAttrDesc());        
        addChildren(PeChkRouteCondDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeChkRouteCondDODesc.class).getFKAttrDesc());        
	  }	  
}