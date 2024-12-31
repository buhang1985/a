package iih.nmr.pkuf.nmrcoll.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nmr.pkuf.nmrcoll.d.NmrCollDO;
import iih.nmr.pkuf.nmrcoll.d.NmrCollItmDO;
import iih.nmr.pkuf.nmrcoll.d.desc.NmrCollItmDODesc;

/**
 * 文书采集记录
 * @author
 *
 */
public class NmrcollAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NmrcollAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NmrCollDO.class);
        addChildren(NmrCollItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NmrCollItmDODesc.class).getFKAttrDesc());        
	  }	  
}