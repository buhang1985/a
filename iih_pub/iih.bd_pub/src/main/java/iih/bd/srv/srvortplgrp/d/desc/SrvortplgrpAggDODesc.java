package iih.bd.srv.srvortplgrp.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.srv.srvortplgrp.d.SrvOrTplGrpDO;
import iih.bd.srv.srvortplgrp.d.SrvOrTplGrpItemDO;
import iih.bd.srv.srvortplgrp.d.desc.SrvOrTplGrpItemDODesc;

/**
 * 医疗服务_医嘱开立模板分组
 * @author
 *
 */
public class SrvortplgrpAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public SrvortplgrpAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(SrvOrTplGrpDO.class);
        addChildren(SrvOrTplGrpItemDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(SrvOrTplGrpItemDODesc.class).getFKAttrDesc());        
	  }	  
}