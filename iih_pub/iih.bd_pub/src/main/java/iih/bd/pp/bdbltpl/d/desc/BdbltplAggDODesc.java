package iih.bd.pp.bdbltpl.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.pp.bdbltpl.d.BdBlTplDO;
import iih.bd.pp.bdbltpl.d.BdBltplItmDO;
import iih.bd.pp.bdbltpl.d.desc.BdBltplItmDODesc;

/**
 * 自定义费用模板
 * @author
 *
 */
public class BdbltplAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public BdbltplAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(BdBlTplDO.class);
        addChildren(BdBltplItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BdBltplItmDODesc.class).getFKAttrDesc());        
	  }	  
}