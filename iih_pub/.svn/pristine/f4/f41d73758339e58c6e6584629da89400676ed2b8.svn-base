package iih.pe.pitm.pesrvitemrange.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pitm.pesrvitemrange.d.PeSrvItemRangeDO;
import iih.pe.pitm.pesrvitemrange.d.PeSrvItemRangeRuleDO;
import iih.pe.pitm.pesrvitemrange.d.desc.PeSrvItemRangeRuleDODesc;

/**
 * 体检结果范围定义
 * @author
 *
 */
public class PesrvitemrangeAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PesrvitemrangeAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeSrvItemRangeDO.class);
        addChildren(PeSrvItemRangeRuleDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeSrvItemRangeRuleDODesc.class).getFKAttrDesc());        
	  }	  
}