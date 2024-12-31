package iih.ci.mr.nu.opermatlist.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.nu.opermatlist.d.OpermatDO;
import iih.ci.mr.nu.opermatlist.d.OpermatDutyDO;
import iih.ci.mr.nu.opermatlist.d.desc.OpermatDutyDODesc;
import iih.ci.mr.nu.opermatlist.d.OpermatEquipDO;
import iih.ci.mr.nu.opermatlist.d.desc.OpermatEquipDODesc;

/**
 * 手术患者术中物品清点单
 * @author
 *
 */
public class OpermatlistAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public OpermatlistAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(OpermatDO.class);
        addChildren(OpermatDutyDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(OpermatDutyDODesc.class).getFKAttrDesc());        
        addChildren(OpermatEquipDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(OpermatEquipDODesc.class).getFKAttrDesc());        
	  }	  
}