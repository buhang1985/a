package iih.nm.nhr.nmgrp.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nhr.nmgrp.d.NmGrpDO;
import iih.nm.nhr.nmgrp.d.GrpDepDO;
import iih.nm.nhr.nmgrp.d.desc.GrpDepDODesc;

/**
 * 护理小组
 * @author
 *
 */
public class NmgrpAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NmgrpAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NmGrpDO.class);
        addChildren(GrpDepDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(GrpDepDODesc.class).getFKAttrDesc());        
	  }	  
}