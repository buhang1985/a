package iih.bd.srv.srvreact.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.srv.srvreact.d.SrvReactDO;
import iih.bd.srv.srvreact.d.SrvReactItemDO;
import iih.bd.srv.srvreact.d.desc.SrvReactItemDODesc;

/**
 * 服务互斥
 * @author
 *
 */
public class SrvreactAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public SrvreactAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(SrvReactDO.class);
        addChildren(SrvReactItemDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(SrvReactItemDODesc.class).getFKAttrDesc());        
	  }	  
}