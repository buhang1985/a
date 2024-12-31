package iih.bd.srv.srvrtctl.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.srv.srvrtctl.d.SrvRtCtlDO;
import iih.bd.srv.srvrtctl.d.SrvRtItmDO;
import iih.bd.srv.srvrtctl.d.desc.SrvRtItmDODesc;

/**
 * 服务开立权限
 * @author
 *
 */
public class SrvrtctlAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public SrvrtctlAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(SrvRtCtlDO.class);
        addChildren(SrvRtItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(SrvRtItmDODesc.class).getFKAttrDesc());        
	  }	  
}