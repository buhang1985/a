package iih.bd.srv.mrtplvst.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.srv.mrtplvst.d.BdMrtplVstDO;
import iih.bd.srv.mrtplvst.d.BdMrtplVstItmDO;
import iih.bd.srv.mrtplvst.d.desc.BdMrtplVstItmDODesc;

/**
 * 生命体征模版
 * @author
 *
 */
public class MrtplvstAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public MrtplvstAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(BdMrtplVstDO.class);
        addChildren(BdMrtplVstItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BdMrtplVstItmDODesc.class).getFKAttrDesc());        
	  }	  
}