package iih.bd.res.bizgrp.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.res.bizgrp.d.BizGroupDO;
import iih.bd.res.bizgrp.d.BizGrpEmpsDO;
import iih.bd.res.bizgrp.d.desc.BizGrpEmpsDODesc;
import iih.bd.res.bizgrp.d.BizGrpBedDO;
import iih.bd.res.bizgrp.d.desc.BizGrpBedDODesc;

/**
 * 业务组
 * @author
 *
 */
public class BizgrpAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public BizgrpAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(BizGroupDO.class);
        addChildren(BizGrpEmpsDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BizGrpEmpsDODesc.class).getFKAttrDesc());        
        addChildren(BizGrpBedDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BizGrpBedDODesc.class).getFKAttrDesc());        
	  }	  
}