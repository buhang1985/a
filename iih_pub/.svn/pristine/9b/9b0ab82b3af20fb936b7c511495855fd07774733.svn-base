package iih.pi.acc.account.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pi.acc.account.d.PiPatAccDO;
import iih.pi.acc.account.d.PiPatAccActDO;
import iih.pi.acc.account.d.desc.PiPatAccActDODesc;

/**
 * 患者账户
 * @author
 *
 */
public class AccountAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public AccountAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PiPatAccDO.class);
        addChildren(PiPatAccActDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PiPatAccActDODesc.class).getFKAttrDesc());        
	  }	  
}