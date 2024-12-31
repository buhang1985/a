package iih.nm.nit.nmnitgrp.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nit.nmnitgrp.d.NmNitGrpDO;
import iih.nm.nit.nmnitgrp.d.NmNitGrpDepDO;
import iih.nm.nit.nmnitgrp.d.desc.NmNitGrpDepDODesc;

/**
 * 护理管理_实习小组
 * @author
 *
 */
public class NmnitgrpAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NmnitgrpAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NmNitGrpDO.class);
        addChildren(NmNitGrpDepDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NmNitGrpDepDODesc.class).getFKAttrDesc());        
	  }	  
}