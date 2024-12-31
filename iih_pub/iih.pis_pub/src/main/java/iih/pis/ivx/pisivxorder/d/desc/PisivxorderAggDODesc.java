package iih.pis.ivx.pisivxorder.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pis.ivx.pisivxorder.d.PisIvxOrderDO;
import iih.pis.ivx.pisivxorder.d.PisIvxOrderDtlDO;
import iih.pis.ivx.pisivxorder.d.desc.PisIvxOrderDtlDODesc;

/**
 * 微信处方订单
 * @author
 *
 */
public class PisivxorderAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PisivxorderAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PisIvxOrderDO.class);
        addChildren(PisIvxOrderDtlDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PisIvxOrderDtlDODesc.class).getFKAttrDesc());        
	  }	  
}