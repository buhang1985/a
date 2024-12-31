package iih.nm.nhr.nmnhrsigrp.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nhr.nmnhrsigrp.d.NhrSigrpDO;
import iih.nm.nhr.nmnhrsigrp.d.NhrSigrpPsnDO;
import iih.nm.nhr.nmnhrsigrp.d.desc.NhrSigrpPsnDODesc;

/**
 * 排班分组
 * @author
 *
 */
public class NmnhrsigrpAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NmnhrsigrpAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NhrSigrpDO.class);
        addChildren(NhrSigrpPsnDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NhrSigrpPsnDODesc.class).getFKAttrDesc());        
	  }	  
}