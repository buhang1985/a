package iih.ems.eass.emshift.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ems.eass.emshift.d.EmsEmShiftDO;
import iih.ems.eass.emshift.d.EmsEmShiftItmDO;
import iih.ems.eass.emshift.d.desc.EmsEmShiftItmDODesc;

/**
 * 设备资产保管变更
 * @author
 *
 */
public class EmshiftAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public EmshiftAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(EmsEmShiftDO.class);
        addChildren(EmsEmShiftItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(EmsEmShiftItmDODesc.class).getFKAttrDesc());        
	  }	  
}