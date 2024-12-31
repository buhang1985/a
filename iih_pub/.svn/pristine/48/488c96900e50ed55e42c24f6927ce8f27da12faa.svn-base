package iih.nmr.pkuf.heduplan.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nmr.pkuf.heduplan.d.HeduPlanDO;
import iih.nmr.pkuf.heduplan.d.HeduPlanItemDO;
import iih.nmr.pkuf.heduplan.d.desc.HeduPlanItemDODesc;

/**
 * 健康教育计划
 * @author
 *
 */
public class HeduplanAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public HeduplanAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(HeduPlanDO.class);
        addChildren(HeduPlanItemDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(HeduPlanItemDODesc.class).getFKAttrDesc());        
	  }	  
}