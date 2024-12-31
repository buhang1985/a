package iih.bd.mm.supplierprotocol.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.mm.supplierprotocol.d.SuppierProtocolDO;
import iih.bd.mm.supplierprotocol.d.ProtocolGoodsDO;
import iih.bd.mm.supplierprotocol.d.desc.ProtocolGoodsDODesc;

/**
 * 供应商关系及协议
 * @author
 *
 */
public class SupplierprotocolAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public SupplierprotocolAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(SuppierProtocolDO.class);
        addChildren(ProtocolGoodsDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(ProtocolGoodsDODesc.class).getFKAttrDesc());        
	  }	  
}