package iih.ci.rcm.infectionrate.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.rcm.infectionrate.d.InfectionRateDO;
import iih.ci.rcm.infectionrate.d.InfectionSiteDO;
import iih.ci.rcm.infectionrate.d.desc.InfectionSiteDODesc;
import iih.ci.rcm.infectionrate.d.InfectionDiagnosisDO;
import iih.ci.rcm.infectionrate.d.desc.InfectionDiagnosisDODesc;

/**
 * 医院感染现患率
 * @author
 *
 */
public class InfectionrateAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public InfectionrateAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(InfectionRateDO.class);
        addChildren(InfectionSiteDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(InfectionSiteDODesc.class).getFKAttrDesc());        
        addChildren(InfectionDiagnosisDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(InfectionDiagnosisDODesc.class).getFKAttrDesc());        
	  }	  
}