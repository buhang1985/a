package iih.ci.mr.nu.sugeryip.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.nu.sugeryip.d.SurgeryPatInfoDO;
import iih.ci.mr.nu.sugeryip.d.SurgeryIpDO;
import iih.ci.mr.nu.sugeryip.d.desc.SurgeryIpDODesc;

/**
 * 外科住院患者护理记录单
 * @author
 *
 */
public class SurgeryipAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public SurgeryipAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(SurgeryPatInfoDO.class);
        addChildren(SurgeryIpDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(SurgeryIpDODesc.class).getFKAttrDesc());        
	  }	  
}