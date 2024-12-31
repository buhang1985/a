package iih.nm.nit.nitpracgrp.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nit.nitpracgrp.d.NitPracgrpDO;
import iih.nm.nit.nitpracgrp.d.NitPracgrpDepDO;
import iih.nm.nit.nitpracgrp.d.desc.NitPracgrpDepDODesc;
import iih.nm.nit.nitpracgrp.d.NitPracGrpPsnDO;
import iih.nm.nit.nitpracgrp.d.desc.NitPracGrpPsnDODesc;

/**
 * 实习小组
 * @author
 *
 */
public class NitpracgrpAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NitpracgrpAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NitPracgrpDO.class);
        addChildren(NitPracgrpDepDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NitPracgrpDepDODesc.class).getFKAttrDesc());        
        addChildren(NitPracGrpPsnDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NitPracGrpPsnDODesc.class).getFKAttrDesc());        
	  }	  
}