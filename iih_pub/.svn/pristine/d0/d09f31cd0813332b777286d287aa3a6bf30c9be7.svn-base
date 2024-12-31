package iih.mp.orm.surgappconfirm.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mp.orm.surgappconfirm.d.SurgAppConfirmDO;
import iih.mp.orm.surgappconfirm.d.SurgAppEmpConfDO;
import iih.mp.orm.surgappconfirm.d.desc.SurgAppEmpConfDODesc;
import iih.mp.orm.surgappconfirm.d.SurgMmConfDO;
import iih.mp.orm.surgappconfirm.d.desc.SurgMmConfDODesc;
import iih.mp.orm.surgappconfirm.d.SurgSrvConfDO;
import iih.mp.orm.surgappconfirm.d.desc.SurgSrvConfDODesc;
import iih.mp.orm.surgappconfirm.d.SurgImConfDO;
import iih.mp.orm.surgappconfirm.d.desc.SurgImConfDODesc;

/**
 * 手术申请单确认
 * @author
 *
 */
public class SurgappconfirmAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public SurgappconfirmAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(SurgAppConfirmDO.class);
        addChildren(SurgAppEmpConfDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(SurgAppEmpConfDODesc.class).getFKAttrDesc());        
        addChildren(SurgMmConfDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(SurgMmConfDODesc.class).getFKAttrDesc());        
        addChildren(SurgSrvConfDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(SurgSrvConfDODesc.class).getFKAttrDesc());        
        addChildren(SurgImConfDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(SurgImConfDODesc.class).getFKAttrDesc());        
	  }	  
}