package iih.bd.pp.bdhpspec.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.pp.bdhpspec.d.BdHpSpecDO;
import iih.bd.pp.bdhpspec.d.BdHpSpecDrugDO;
import iih.bd.pp.bdhpspec.d.desc.BdHpSpecDrugDODesc;

/**
 * 医保特殊病
 * @author
 *
 */
public class BdhpspecAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public BdhpspecAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(BdHpSpecDO.class);
        addChildren(BdHpSpecDrugDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BdHpSpecDrugDODesc.class).getFKAttrDesc());        
	  }	  
}