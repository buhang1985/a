package iih.nm.nqm.nqmcssty.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nqm.nqmcssty.d.NqmCsStyDO;
import iih.nm.nqm.nqmcssty.d.NqmCsStyItmDO;
import iih.nm.nqm.nqmcssty.d.desc.NqmCsStyItmDODesc;

/**
 * 质量检查表样式
 * @author
 *
 */
public class NqmcsstyAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NqmcsstyAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NqmCsStyDO.class);
        addChildren(NqmCsStyItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NqmCsStyItmDODesc.class).getFKAttrDesc());        
	  }	  
}