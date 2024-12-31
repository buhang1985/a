package iih.bd.srv.srvortpl.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.srv.srvortpl.d.SrvOrdTplDO;
import iih.bd.srv.srvortpl.d.SrvOrTplDiDO;
import iih.bd.srv.srvortpl.d.desc.SrvOrTplDiDODesc;

/**
 * 医疗服务医嘱模板
 * @author
 *
 */
public class SrvortplAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public SrvortplAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(SrvOrdTplDO.class);
        addChildren(SrvOrTplDiDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(SrvOrTplDiDODesc.class).getFKAttrDesc());        
	  }	  
}