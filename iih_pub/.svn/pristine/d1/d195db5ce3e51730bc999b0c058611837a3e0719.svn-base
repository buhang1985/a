package iih.bd.pp.bddepcg.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.pp.bddepcg.d.BdDepCgDO;
import iih.bd.pp.bddepcg.d.BdDepCgItmDO;
import iih.bd.pp.bddepcg.d.desc.BdDepCgItmDODesc;

/**
 * 科室补费策略
 * @author
 *
 */
public class BddepcgAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public BddepcgAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(BdDepCgDO.class);
        addChildren(BdDepCgItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BdDepCgItmDODesc.class).getFKAttrDesc());        
	  }	  
}