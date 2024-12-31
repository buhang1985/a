package iih.bd.pp.pripat.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.pp.pripat.d.PriPatDO;
import iih.bd.pp.pripat.d.PriPatSrvOrCaDO;
import iih.bd.pp.pripat.d.desc.PriPatSrvOrCaDODesc;

/**
 * 患者价格分类
 * @author
 *
 */
public class PripatAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PripatAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PriPatDO.class);
        addChildren(PriPatSrvOrCaDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PriPatSrvOrCaDODesc.class).getFKAttrDesc());        
	  }	  
}