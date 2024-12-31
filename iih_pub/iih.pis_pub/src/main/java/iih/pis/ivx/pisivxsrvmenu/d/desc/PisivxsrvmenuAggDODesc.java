package iih.pis.ivx.pisivxsrvmenu.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pis.ivx.pisivxsrvmenu.d.PisIvxSrvMenuDO;
import iih.pis.ivx.pisivxsrvmenu.d.PisIvxSrvMenuItmDO;
import iih.pis.ivx.pisivxsrvmenu.d.desc.PisIvxSrvMenuItmDODesc;

/**
 * 服务号菜单
 * @author
 *
 */
public class PisivxsrvmenuAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PisivxsrvmenuAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PisIvxSrvMenuDO.class);
        addChildren(PisIvxSrvMenuItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PisIvxSrvMenuItmDODesc.class).getFKAttrDesc());        
	  }	  
}