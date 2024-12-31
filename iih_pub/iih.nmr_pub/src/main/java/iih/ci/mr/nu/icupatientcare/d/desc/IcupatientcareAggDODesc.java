package iih.ci.mr.nu.icupatientcare.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.nu.icupatientcare.d.PatientInfoDO;
import iih.ci.mr.nu.icupatientcare.d.IcuPatientCareDO;
import iih.ci.mr.nu.icupatientcare.d.desc.IcuPatientCareDODesc;

/**
 * ICU患者护理记录单
 * @author
 *
 */
public class IcupatientcareAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public IcupatientcareAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PatientInfoDO.class);
        addChildren(IcuPatientCareDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(IcuPatientCareDODesc.class).getFKAttrDesc());        
	  }	  
}