package iih.mc.pl.deprequestap.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mc.pl.deprequestap.d.McDepReqApOrderDO;
import iih.mc.pl.deprequestap.d.McDepReqApItemDO;
import iih.mc.pl.deprequestap.d.desc.McDepReqApItemDODesc;

/**
 * 部门领用申请单
 * @author
 *
 */
public class DeprequestapAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public DeprequestapAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(McDepReqApOrderDO.class);
        addChildren(McDepReqApItemDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(McDepReqApItemDODesc.class).getFKAttrDesc());        
	  }	  
}