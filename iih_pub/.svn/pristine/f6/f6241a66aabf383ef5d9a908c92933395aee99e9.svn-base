package iih.bd.srv.mrtplvt.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.srv.mrtplvt.d.MrtplVtDO;
import iih.bd.srv.mrtplvt.d.MrtplVtItmDO;
import iih.bd.srv.mrtplvt.d.desc.MrtplVtItmDODesc;

/**
 * 生命体征测量
 * @author
 *
 */
public class MrtplvtAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public MrtplvtAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(MrtplVtDO.class);
        addChildren(MrtplVtItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MrtplVtItmDODesc.class).getFKAttrDesc());        
	  }	  
}