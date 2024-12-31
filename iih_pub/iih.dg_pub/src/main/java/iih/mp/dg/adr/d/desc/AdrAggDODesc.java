package iih.mp.dg.adr.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mp.dg.adr.d.MpDgAdrDO;
import iih.mp.dg.adr.d.MpDgAdrItmDO;
import iih.mp.dg.adr.d.desc.MpDgAdrItmDODesc;

/**
 * 药品不良反应
 * @author
 *
 */
public class AdrAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public AdrAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(MpDgAdrDO.class);
        addChildren(MpDgAdrItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MpDgAdrItmDODesc.class).getFKAttrDesc());        
	  }	  
}