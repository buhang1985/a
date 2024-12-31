package iih.nm.nit.nmnitgrpplpsn.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nit.nmnitgrpplpsn.d.NmNitGrpPlPsnDO;
import iih.nm.nit.nmnitgrpplpsn.d.NmNitPsnCycRecDO;
import iih.nm.nit.nmnitgrpplpsn.d.desc.NmNitPsnCycRecDODesc;

/**
 * 护理管理_实习小组计划_人员
 * @author
 *
 */
public class NmnitgrpplpsnAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NmnitgrpplpsnAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NmNitGrpPlPsnDO.class);
        addChildren(NmNitPsnCycRecDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NmNitPsnCycRecDODesc.class).getFKAttrDesc());        
	  }	  
}