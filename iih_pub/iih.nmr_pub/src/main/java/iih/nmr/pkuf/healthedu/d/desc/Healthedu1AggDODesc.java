package iih.nmr.pkuf.healthedu.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nmr.pkuf.healthedu.d.HealtheduDO;
import iih.nmr.pkuf.healthedu.d.HealtheduItmDO;
import iih.nmr.pkuf.healthedu.d.desc.HealtheduItmDODesc;

/**
 * 健康教育计划执行单
 * @author
 *
 */
public class Healthedu1AggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public Healthedu1AggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(HealtheduDO.class);
        addChildren(HealtheduItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(HealtheduItmDODesc.class).getFKAttrDesc());        
	  }	  
}