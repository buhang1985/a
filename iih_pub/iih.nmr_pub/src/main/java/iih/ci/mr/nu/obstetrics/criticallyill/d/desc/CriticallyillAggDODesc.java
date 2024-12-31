package iih.ci.mr.nu.obstetrics.criticallyill.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.nu.obstetrics.criticallyill.d.CriticallyCustDO;
import iih.ci.mr.nu.obstetrics.criticallyill.d.CriticallyIllDO;
import iih.ci.mr.nu.obstetrics.criticallyill.d.desc.CriticallyIllDODesc;

/**
 * 患者就诊护理记录单
 * @author
 *
 */
public class CriticallyillAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public CriticallyillAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(CriticallyCustDO.class);
        addChildren(CriticallyIllDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CriticallyIllDODesc.class).getFKAttrDesc());        
	  }	  
}