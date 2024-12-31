package iih.nmr.ha.tcho.hemodiasis.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nmr.ha.tcho.hemodiasis.d.HemodialysisDO;
import iih.nmr.ha.tcho.hemodiasis.d.HemodialrecDO;
import iih.nmr.ha.tcho.hemodiasis.d.desc.HemodialrecDODesc;

/**
 * 血液透析护理记录
 * @author
 *
 */
public class HemodiasisAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public HemodiasisAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(HemodialysisDO.class);
        addChildren(HemodialrecDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(HemodialrecDODesc.class).getFKAttrDesc());        
	  }	  
}