package iih.ci.rcm.infectionoutbreakreport.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.rcm.infectionoutbreakreport.d.InfectionOutbreakReportDO;
import iih.ci.rcm.infectionoutbreakreport.d.InfecOutbreakDetailReportDO;
import iih.ci.rcm.infectionoutbreakreport.d.desc.InfecOutbreakDetailReportDODesc;

/**
 * 医院感染暴发报告登记表
 * @author
 *
 */
public class InfectionoutbreakreportAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public InfectionoutbreakreportAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(InfectionOutbreakReportDO.class);
        addChildren(InfecOutbreakDetailReportDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(InfecOutbreakDetailReportDODesc.class).getFKAttrDesc());        
	  }	  
}