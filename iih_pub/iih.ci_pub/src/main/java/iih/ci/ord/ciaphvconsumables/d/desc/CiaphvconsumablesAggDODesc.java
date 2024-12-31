package iih.ci.ord.ciaphvconsumables.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.ord.ciaphvconsumables.d.CiApHvconsumblesDO;
import iih.ci.ord.ciaphvconsumables.d.CiApHvconsumablesItmDO;
import iih.ci.ord.ciaphvconsumables.d.desc.CiApHvconsumablesItmDODesc;

/**
 * 医嘱高值耗材申请 
 * @author
 *
 */
public class CiaphvconsumablesAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public CiaphvconsumablesAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(CiApHvconsumblesDO.class);
        addChildren(CiApHvconsumablesItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CiApHvconsumablesItmDODesc.class).getFKAttrDesc());        
	  }	  
}