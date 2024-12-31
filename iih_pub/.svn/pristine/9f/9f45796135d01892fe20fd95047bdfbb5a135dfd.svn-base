package iih.nmr.common.hecptp.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nmr.common.hecptp.d.HeduPlanTpDO;
import iih.nmr.common.hecptp.d.HeduPlanRelDO;
import iih.nmr.common.hecptp.d.desc.HeduPlanRelDODesc;

/**
 * 健康教育计划单据类型
 * @author
 *
 */
public class HecptpAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public HecptpAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(HeduPlanTpDO.class);
        addChildren(HeduPlanRelDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(HeduPlanRelDODesc.class).getFKAttrDesc());        
	  }	  
}