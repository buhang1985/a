package iih.bd.pp.baseprisrv.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.pp.baseprisrv.d.PriSrvDO;
import iih.bd.pp.baseprisrv.d.SrvPriDO;
import iih.bd.pp.baseprisrv.d.desc.SrvPriDODesc;

/**
 * 价格服务
 * @author
 *
 */
public class BaseprisrvAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public BaseprisrvAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PriSrvDO.class);
        addChildren(SrvPriDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(SrvPriDODesc.class).getFKAttrDesc());        
	  }	  
}