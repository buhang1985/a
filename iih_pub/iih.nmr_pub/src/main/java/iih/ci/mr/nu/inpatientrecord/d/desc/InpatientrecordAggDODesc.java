package iih.ci.mr.nu.inpatientrecord.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.nu.inpatientrecord.d.InPatientInfoDO;
import iih.ci.mr.nu.inpatientrecord.d.InPatientRecordDO;
import iih.ci.mr.nu.inpatientrecord.d.desc.InPatientRecordDODesc;

/**
 * 内科住院患者护理记录单
 * @author
 *
 */
public class InpatientrecordAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public InpatientrecordAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(InPatientInfoDO.class);
        addChildren(InPatientRecordDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(InPatientRecordDODesc.class).getFKAttrDesc());        
	  }	  
}