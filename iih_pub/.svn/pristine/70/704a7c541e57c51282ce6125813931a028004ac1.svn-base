package iih.nm.nit.nitsro.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nit.nitsro.d.NitSroDO;
import iih.nm.nit.nitsro.d.NitSroBchDO;
import iih.nm.nit.nitsro.d.desc.NitSroBchDODesc;

/**
 * 护理管理_实习单位
 * @author
 *
 */
public class NitsroAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NitsroAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NitSroDO.class);
        addChildren(NitSroBchDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NitSroBchDODesc.class).getFKAttrDesc());        
	  }	  
}