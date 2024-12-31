package iih.mm.pl.trapimpl.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mm.pl.trapimpl.d.TrapImplDO;
import iih.mm.pl.trapimpl.d.TrapImplItemDO;
import iih.mm.pl.trapimpl.d.desc.TrapImplItemDODesc;

/**
 * 调拨单
 * @author
 *
 */
public class TrapimplAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public TrapimplAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(TrapImplDO.class);
        addChildren(TrapImplItemDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(TrapImplItemDODesc.class).getFKAttrDesc());        
	  }	  
}