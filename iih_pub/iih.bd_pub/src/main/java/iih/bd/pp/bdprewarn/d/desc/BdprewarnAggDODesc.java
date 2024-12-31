package iih.bd.pp.bdprewarn.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.pp.bdprewarn.d.BdPreWarnDO;
import iih.bd.pp.bdprewarn.d.BdPreWarnItmDO;
import iih.bd.pp.bdprewarn.d.desc.BdPreWarnItmDODesc;

/**
 * 预交金警告策略
 * @author
 *
 */
public class BdprewarnAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public BdprewarnAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(BdPreWarnDO.class);
        addChildren(BdPreWarnItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BdPreWarnItmDODesc.class).getFKAttrDesc());        
	  }	  
}