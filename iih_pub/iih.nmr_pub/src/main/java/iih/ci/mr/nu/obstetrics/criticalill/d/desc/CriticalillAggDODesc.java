package iih.ci.mr.nu.obstetrics.criticalill.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.nu.obstetrics.criticalill.d.CriticalCustDO;
import iih.ci.mr.nu.obstetrics.criticalill.d.CriticalillDO;
import iih.ci.mr.nu.obstetrics.criticalill.d.desc.CriticalillDODesc;

/**
 * 患者急诊就诊护理记录单
 * @author
 *
 */
public class CriticalillAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public CriticalillAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(CriticalCustDO.class);
        addChildren(CriticalillDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CriticalillDODesc.class).getFKAttrDesc());        
	  }	  
}