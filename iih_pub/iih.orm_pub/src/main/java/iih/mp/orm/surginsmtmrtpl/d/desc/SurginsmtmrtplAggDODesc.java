package iih.mp.orm.surginsmtmrtpl.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mp.orm.surginsmtmrtpl.d.SurgInsmtMrtplDO;
import iih.mp.orm.surginsmtmrtpl.d.SurgInsmtMrtplItemDO;
import iih.mp.orm.surginsmtmrtpl.d.desc.SurgInsmtMrtplItemDODesc;

/**
 * 手术器械模板
 * @author
 *
 */
public class SurginsmtmrtplAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public SurginsmtmrtplAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(SurgInsmtMrtplDO.class);
        addChildren(SurgInsmtMrtplItemDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(SurgInsmtMrtplItemDODesc.class).getFKAttrDesc());        
	  }	  
}