package iih.nm.nhr.nmnurgrp.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nhr.nmnurgrp.d.NmNurGrpDO;
import iih.nm.nhr.nmnurgrp.d.NmNurGrpPsnDo;
import iih.nm.nhr.nmnurgrp.d.desc.NmNurGrpPsnDoDesc;

/**
 * 护理管理人员小组
 * @author
 *
 */
public class NmnurgrpAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NmnurgrpAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NmNurGrpDO.class);
        addChildren(NmNurGrpPsnDo.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NmNurGrpPsnDoDesc.class).getFKAttrDesc());        
	  }	  
}