package iih.mi.mc.mimcspec.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mi.mc.mimcspec.d.MiMcSpecDO;
import iih.mi.mc.mimcspec.d.MiMcSpecDrugDO;
import iih.mi.mc.mimcspec.d.desc.MiMcSpecDrugDODesc;

/**
 * 医保特殊病
 * @author
 *
 */
public class MimcspecAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public MimcspecAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(MiMcSpecDO.class);
        addChildren(MiMcSpecDrugDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MiMcSpecDrugDODesc.class).getFKAttrDesc());        
	  }	  
}