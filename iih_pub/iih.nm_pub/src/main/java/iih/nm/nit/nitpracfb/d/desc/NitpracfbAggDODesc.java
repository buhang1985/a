package iih.nm.nit.nitpracfb.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nit.nitpracfb.d.NitPracfbDO;
import iih.nm.nit.nitpracfb.d.NitPracfbItmDO;
import iih.nm.nit.nitpracfb.d.desc.NitPracfbItmDODesc;

/**
 * 实习反馈
 * @author
 *
 */
public class NitpracfbAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NitpracfbAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NitPracfbDO.class);
        addChildren(NitPracfbItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NitPracfbItmDODesc.class).getFKAttrDesc());        
	  }	  
}