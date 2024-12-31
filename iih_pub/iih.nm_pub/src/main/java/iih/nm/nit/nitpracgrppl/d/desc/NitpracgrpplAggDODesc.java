package iih.nm.nit.nitpracgrppl.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nit.nitpracgrppl.d.NitPracgrpPlDO;
import iih.nm.nit.nitpracgrppl.d.NitPracgrpPlDepDO;
import iih.nm.nit.nitpracgrppl.d.desc.NitPracgrpPlDepDODesc;
import iih.nm.nit.nitpracgrppl.d.NitPracGrpPlPsnDO;
import iih.nm.nit.nitpracgrppl.d.desc.NitPracGrpPlPsnDODesc;

/**
 * 小组计划
 * @author
 *
 */
public class NitpracgrpplAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NitpracgrpplAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NitPracgrpPlDO.class);
        addChildren(NitPracgrpPlDepDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NitPracgrpPlDepDODesc.class).getFKAttrDesc());        
        addChildren(NitPracGrpPlPsnDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NitPracGrpPlPsnDODesc.class).getFKAttrDesc());        
	  }	  
}