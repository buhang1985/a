package iih.ci.mr.nu.perioperativenurrec.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.nu.perioperativenurrec.d.PpNurDO;
import iih.ci.mr.nu.perioperativenurrec.d.PpNurRecDO;
import iih.ci.mr.nu.perioperativenurrec.d.desc.PpNurRecDODesc;

/**
 * 围手术期护理记录单
 * @author
 *
 */
public class PerioperativenurrecAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PerioperativenurrecAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PpNurDO.class);
        addChildren(PpNurRecDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PpNurRecDODesc.class).getFKAttrDesc());        
	  }	  
}