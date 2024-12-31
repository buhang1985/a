package iih.pe.pitm.perulecombine.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pitm.perulecombine.d.PeRuleCombineDO;
import iih.pe.pitm.perulecombine.d.PeRuleCombineItemDO;
import iih.pe.pitm.perulecombine.d.desc.PeRuleCombineItemDODesc;

/**
 * 体检组合规则定义
 * @author
 *
 */
public class PerulecombineAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PerulecombineAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeRuleCombineDO.class);
        addChildren(PeRuleCombineItemDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeRuleCombineItemDODesc.class).getFKAttrDesc());        
	  }	  
}