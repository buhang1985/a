package iih.ci.mr.nu.antencare.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.nu.antencare.d.AntenCareDO;
import iih.ci.mr.nu.antencare.d.InspRecDO;
import iih.ci.mr.nu.antencare.d.desc.InspRecDODesc;

/**
 * 产前检查记录单
 * @author
 *
 */
public class AntencareAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public AntencareAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(AntenCareDO.class);
        addChildren(InspRecDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(InspRecDODesc.class).getFKAttrDesc());        
	  }	  
}