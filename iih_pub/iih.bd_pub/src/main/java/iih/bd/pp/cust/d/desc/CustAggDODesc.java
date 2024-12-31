package iih.bd.pp.cust.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.pp.cust.d.CustCaDO;
import iih.bd.pp.cust.d.CustDO;
import iih.bd.pp.cust.d.desc.CustDODesc;

/**
 * 付款客户
 * @author
 *
 */
public class CustAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public CustAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(CustCaDO.class);
        addChildren(CustDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CustDODesc.class).getFKAttrDesc());        
	  }	  
}