package iih.pe.phm.peinterveneplan.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.phm.peinterveneplan.d.PeIntervenePlanDO;
import iih.pe.phm.peinterveneplan.d.PeIntervenePlanRiskDO;
import iih.pe.phm.peinterveneplan.d.desc.PeIntervenePlanRiskDODesc;

/**
 * 健康干预个人计划
 * @author
 *
 */
public class PeinterveneplanAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PeinterveneplanAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeIntervenePlanDO.class);
        addChildren(PeIntervenePlanRiskDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeIntervenePlanRiskDODesc.class).getFKAttrDesc());        
	  }	  
}