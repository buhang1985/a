package iih.ci.mr.nu.prescforoper.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.nu.prescforoper.d.PrescforDO;
import iih.ci.mr.nu.prescforoper.d.PrescforoperDO;
import iih.ci.mr.nu.prescforoper.d.desc.PrescforoperDODesc;

/**
 * 手术室患者压疮危险因素评分
 * @author
 *
 */
public class PrescforoperAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PrescforoperAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PrescforDO.class);
        addChildren(PrescforoperDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PrescforoperDODesc.class).getFKAttrDesc());        
	  }	  
}