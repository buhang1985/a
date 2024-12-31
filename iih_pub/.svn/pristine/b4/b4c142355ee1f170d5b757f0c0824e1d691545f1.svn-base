package iih.nm.nqm.nqmchk.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nqm.nqmchk.d.NqmChkDO;
import iih.nm.nqm.nqmchk.d.NmNqmChkItmDO;
import iih.nm.nqm.nqmchk.d.desc.NmNqmChkItmDODesc;

/**
 * 质量检查
 * @author
 *
 */
public class NqmchkAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NqmchkAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NqmChkDO.class);
        addChildren(NmNqmChkItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NmNqmChkItmDODesc.class).getFKAttrDesc());        
	  }	  
}