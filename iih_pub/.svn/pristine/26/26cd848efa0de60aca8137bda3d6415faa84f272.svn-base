package iih.ci.mr.nu.critillpatcare.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.nu.critillpatcare.d.IllPatientDO;
import iih.ci.mr.nu.critillpatcare.d.IllPatientCareDO;
import iih.ci.mr.nu.critillpatcare.d.desc.IllPatientCareDODesc;

/**
 * 患者病危护理记录
 * @author
 *
 */
public class CritillpatcareAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public CritillpatcareAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(IllPatientDO.class);
        addChildren(IllPatientCareDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(IllPatientCareDODesc.class).getFKAttrDesc());        
	  }	  
}