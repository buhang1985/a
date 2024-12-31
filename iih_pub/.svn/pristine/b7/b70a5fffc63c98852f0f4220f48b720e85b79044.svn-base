package iih.ci.mr.nu.ccupatcarerec.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.nu.ccupatcarerec.d.CcuPatrecDO;
import iih.ci.mr.nu.ccupatcarerec.d.CcupatcarerecDO;
import iih.ci.mr.nu.ccupatcarerec.d.desc.CcupatcarerecDODesc;

/**
 * 组件
 * @author
 *
 */
public class CcupatcarerecAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public CcupatcarerecAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(CcuPatrecDO.class);
        addChildren(CcupatcarerecDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CcupatcarerecDODesc.class).getFKAttrDesc());        
	  }	  
}