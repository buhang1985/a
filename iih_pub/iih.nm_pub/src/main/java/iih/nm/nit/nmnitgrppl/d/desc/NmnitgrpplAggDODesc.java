package iih.nm.nit.nmnitgrppl.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nit.nmnitgrppl.d.NmNitGrpPlDO;
import iih.nm.nit.nmnitgrppl.d.NmNitGrpPlDepDO;
import iih.nm.nit.nmnitgrppl.d.desc.NmNitGrpPlDepDODesc;

/**
 * 护理管理_实习小组_计划
 * @author
 *
 */
public class NmnitgrpplAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NmnitgrpplAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NmNitGrpPlDO.class);
        addChildren(NmNitGrpPlDepDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NmNitGrpPlDepDODesc.class).getFKAttrDesc());        
	  }	  
}