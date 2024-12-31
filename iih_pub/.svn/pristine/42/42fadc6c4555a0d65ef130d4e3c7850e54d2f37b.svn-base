package iih.nm.nqm.nqmqcgrp.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nqm.nqmqcgrp.d.NqmQcgrpDO;
import iih.nm.nqm.nqmqcgrp.d.NqmQcgrpPsnDO;
import iih.nm.nqm.nqmqcgrp.d.desc.NqmQcgrpPsnDODesc;
import iih.nm.nqm.nqmqcgrp.d.NqmQcgrpCsDO;
import iih.nm.nqm.nqmqcgrp.d.desc.NqmQcgrpCsDODesc;

/**
 * 质控组
 * @author
 *
 */
public class NqmqcgrpAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NqmqcgrpAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NqmQcgrpDO.class);
        addChildren(NqmQcgrpPsnDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NqmQcgrpPsnDODesc.class).getFKAttrDesc());        
        addChildren(NqmQcgrpCsDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NqmQcgrpCsDODesc.class).getFKAttrDesc());        
	  }	  
}