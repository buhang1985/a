package iih.bd.srv.mrtplvs.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.srv.mrtplvs.d.BdMrtplVsDO;
import iih.bd.srv.mrtplvs.d.BdMrtplVsItmDO;
import iih.bd.srv.mrtplvs.d.desc.BdMrtplVsItmDODesc;

/**
 * 生命体征项
 * @author
 *
 */
public class MrtplvsAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public MrtplvsAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(BdMrtplVsDO.class);
        addChildren(BdMrtplVsItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BdMrtplVsItmDODesc.class).getFKAttrDesc());        
	  }	  
}