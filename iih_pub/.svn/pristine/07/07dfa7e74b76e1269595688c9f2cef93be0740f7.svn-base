package iih.bd.pp.incca.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.pp.incca.d.IncCaDO;
import iih.bd.pp.incca.d.IncCaItmDO;
import iih.bd.pp.incca.d.desc.IncCaItmDODesc;

/**
 * 票据分类
 * @author
 *
 */
public class InccaAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public InccaAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(IncCaDO.class);
        addChildren(IncCaItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(IncCaItmDODesc.class).getFKAttrDesc());        
	  }	  
}