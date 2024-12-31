package iih.pe.pitm.pedishes.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pitm.pedishes.d.PeDishesDO;
import iih.pe.pitm.pedishes.d.PeDishesItmDO;
import iih.pe.pitm.pedishes.d.desc.PeDishesItmDODesc;

/**
 * 体检食物菜单定义
 * @author
 *
 */
public class PedishesAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PedishesAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeDishesDO.class);
        addChildren(PeDishesItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeDishesItmDODesc.class).getFKAttrDesc());        
	  }	  
}